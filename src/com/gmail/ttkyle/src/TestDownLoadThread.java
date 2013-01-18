package com.gmail.ttkyle.src;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 10/30/12
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDownLoadThread implements Runnable {

    TestDownLoadThread() {

        //create the new thread
        Thread resourceThread = new Thread(this);

        //start the new thread
        resourceThread.start();
    }


    public void run() {
        WebAutomation.downloadVillageTxt();
    }
}
