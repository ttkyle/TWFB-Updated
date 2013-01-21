package com.gmail.ttkyle.src;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;


/**
 * Web automation class.  This class is used to automate the web browser.
 * This class also gets certain webElements that are used in the GUI.
 * The elements this class sends to the GUI are Troops and resources thus far.
 */

public class WebAutomation  {
    static WebDriver driver;
    static String userName;
    static String password;

    private static String currentlySelectedServer;

    public static void login(String user, String pass) throws InterruptedException {


        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        firefoxProfile.setPreference("browser.download.dir","C:\\Users\\kyle\\IdeaProjects\\TWFB");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");


        driver = new FirefoxDriver();

        //driver.navigate().to("http://en65.tribalwars.net/map/village.txt");

        userName = user;
        password = pass;

        String convertServerToString = DetailsPanel.getServerListComboBox().getSelectedItem().toString();
        currentlySelectedServer = convertServerToString.substring(6, 10);
        System.out.println(currentlySelectedServer);

        //Get the logon page
        driver.get("http://www.tribalwars.net");

        //Find the user text input by name and type it
        WebElement elementUser = driver.findElement(By.name("user"));
        elementUser.sendKeys(userName);
        Thread.sleep(250);

        //Wait to enter password
        Thread.sleep(500);

        //Find the password text input and type it
        WebElement elementPassword = driver.findElement(By.name("password"));
        elementPassword.sendKeys(password);
        Thread.sleep(250);
        elementPassword.submit();
        Thread.sleep(500);

        //Choose which server to login and wait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Index.submit_login('server_" + currentlySelectedServer +"')");

        driver.get(currentlySelectedServer + ".tribalwars.net/game.php?screen=overview&intro");
        Thread.sleep(1000);


        String currentUrl = null;
        try {
            currentUrl = driver.getCurrentUrl().substring(7, 57);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("NO ACCOUNT ON SERVER");
            JOptionPane.showMessageDialog(MainFrame.serverNotOnAccountDialog,
                    "THERE IS NO VILLAGE CREATED IN THIS WORLD!!!!!",
                    "NO VILLAGE IN THIS WORLD",
                    JOptionPane.ERROR_MESSAGE);

            driver.close();
            driver = null;
        }

        System.out.println(currentUrl);
        Thread.sleep(1000);
        if(currentUrl.equals(currentlySelectedServer + ".tribalwars.net/game.php?screen=overview&intro")) {
            System.out.println("SERVER EXISTS ON ACCOUNT");


            //display units in village to the GUI
            Village.updateTroops();
            Village.isAttacked();
            Village.setWoodResource();
            Village.setClayResource();
            Village.setIronResource();

            //Waits for the VillageHQ to load then gets the building levels and resource generation
            //driver.get("http://en63.tribalwars.net/game.php?village=119799&screen=main");
            System.out.println(currentlySelectedServer + ".tribalwars.net/game.php?village=34634&screen=main");
            driver.get( currentlySelectedServer + ".tribalwars.net/game.php?village=300322&screen=main");
            Village.getAllBuildingCosts();

            //updates all the buildings and resources on load
            Village.updateBuildings();

            Thread.sleep(500);
            Village.constructionOne();
            Village.constructionTwo();
            Village.constructionOneGetNumbers();
            Village.constructionOneGetTime();
            Village.constructionTwoGetNumbers();
            Village.constructionTwoGetTime();
            Thread.sleep(500);

            //two new thread to keep updating resources on any page and keeping watch for incoming attacks
            TroopThread troops = new TroopThread();
            ResourceUpdateThread resources = new ResourceUpdateThread();
            IsAttackedThread attack = new IsAttackedThread();
            BuildingResourceCostThread buildingCosts = new BuildingResourceCostThread();
            ConstructOneThread constructOneThread = new ConstructOneThread();

            if(Village.getTotalOne() > 0) {
                ConstructOneThread.constructionFlagOne = true;
            }

            //takes user back to the main page
            driver.get(currentlySelectedServer + ".tribalwars.net/game.php?screen=overview&intro");
        }

        else {
            System.out.println("NO ACCOUNT ON SERVER NOT IN CATCH");
            JOptionPane.showMessageDialog(MainFrame.serverNotOnAccountDialog,
                    "THERE IS NO VILLAGE CREATED IN THIS WORLD!!!!!",
                    "NO VILLAGE IN THIS WORLD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openRally() throws InterruptedException {
        driver.get(currentlySelectedServer + ".tribalwars.net/game.php?village=34634&screen=place");
        Thread.sleep(1000);
    }

    public void getFileNameAndRead() {
        File folder = new File("C:\\Users\\kyle\\Documents\\Tribalwars");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
            //else if (listOfFiles[i].isDirectory()) {
            //System.out.println("Directory " + listOfFiles[i].getName());
            //}
        }
    }


    public static void downloader(String worldUrl) throws IOException {
        InputStream is = null;
        BufferedOutputStream bos = null;
        try{
            is = fetch(worldUrl);
            bos = new BufferedOutputStream(new FileOutputStream(new File("village.txt")));

            byte[] buffer = new byte[8192];
            int bytesRead = 0;
            while((bytesRead = is.read(buffer, 0, buffer.length)) > -1){
                bos.write(buffer, 0, bytesRead);
            }
        }
        finally{
            if(bos != null) bos.close();
            if(is != null) is.close();
        }
    }

    public static InputStream fetch(String address) throws MalformedURLException, IOException {
        HttpGet httpRequest = new HttpGet(URI.create(address));
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);
        HttpEntity entity = response.getEntity();
        BufferedHttpEntity buffHttpEntity = new BufferedHttpEntity(entity);
        InputStream instream = buffHttpEntity.getContent();
        return instream;
    }

    public static void downloadVillageTxt() {
        String convertServerToString = DetailsPanel.getServerListComboBox().getSelectedItem().toString();
        String currentlySelectedServer = convertServerToString.substring(6, 10);

        if(currentlySelectedServer.equals("en58")) {
            try {
                downloader("https://dl.dropbox.com/s/8j9xl7owcwaa2ig/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en59")) {
            try {
                downloader("https://dl.dropbox.com/s/15inwz3bwc2wd80/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en60")) {
            try {
                downloader("https://dl.dropbox.com/s/01tqozyyq57nn8c/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en61")) {
            try {
                downloader("https://dl.dropbox.com/s/3f98xq4nebibl8x/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en62")) {
            try {
                downloader("https://dl.dropbox.com/s/k20tiy3yxfm0oxe/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en63")) {
            try {
                downloader("https://dl.dropbox.com/s/ji3m74pgdiqmycg/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en64")) {
            try {
                downloader("https://dl.dropbox.com/s/ui94p4fz9znk9lc/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(currentlySelectedServer.equals("en65")) {
            try {
                downloader("https://dl.dropbox.com/s/rnp66dutpnfuypg/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(currentlySelectedServer.equals("en66")) {
            try {
                downloader("https://www.dropbox.com/s/5ufeijank5c223k/village.txt?dl=1");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}