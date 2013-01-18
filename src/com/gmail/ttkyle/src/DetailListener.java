package com.gmail.ttkyle.src;

import java.util.EventListener;

/**
 *The actual event listener for text box changes (user and password)
 */

//Detail event listener
public interface DetailListener extends EventListener {
    public void detailEventOccurred(DetailEvent event);
}
