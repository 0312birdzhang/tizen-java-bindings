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
public abstract class EvasEvent {
    
    public final Object data;
    public final long timestamp;
    public final EvasEventFlags event_flags;

    public EvasEvent(Object data, long timestamp, EvasEventFlags event_flags) {
        this.data = data;
        this.timestamp = timestamp;
        this.event_flags = event_flags;
    }
    
}
