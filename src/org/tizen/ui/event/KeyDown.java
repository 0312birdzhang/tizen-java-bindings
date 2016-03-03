/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

/**
 *
 * 
 */
public class KeyDown extends Key {
    static {
        System.loadLibrary("KeyDown");
        initIDs();
    }

    private static native void initIDs();
    
    /**
     * Called from c.
     * @param keyname
     * @param key
     * @param string
     * @param compose
     * @param keycode
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    KeyDown(
            String keyname,
            String key, 
            String string, 
            String compose, 
            int keycode, 
            Object data, 
            long timestamp, 
            int event_flags) 
    {
        super(keyname, key, string, compose, keycode, data, timestamp, EvasEventFlags.get(event_flags));
    }
    
    /**
     * 
     * @param keyname
     * @param key
     * @param string
     * @param compose
     * @param keycode
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    public KeyDown(
            String keyname,
            String key, 
            String string, 
            String compose, 
            int keycode, 
            Object data, 
            long timestamp, 
            EvasEventFlags event_flags) 
    {
        super(keyname, key, string, compose, keycode, data, timestamp, event_flags);
    }
    
}
