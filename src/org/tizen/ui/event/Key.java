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
public abstract class Key extends EvasEvent {
    public final String keyname, key, string, compose;
    public final int keycode;
    
    public Key(
            String keyname,
            String key,
            String string,
            String compose,
            int keycode,
            Object data, 
            long timestamp, 
            EvasEventFlags event_flags) 
    {
        super(data, timestamp, event_flags);
        this.keyname = keyname;
        this.key = key;
        this.string = string;
        this.compose = compose;
        this.keycode = keycode;
    }
    
}
