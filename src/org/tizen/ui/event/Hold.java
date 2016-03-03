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
public class Hold extends EvasEvent {
    static {
        System.loadLibrary("Hold");
        initIDs();
    }

    private static native void initIDs();
    
    public final int hold;
    
    public Hold(int hold, Object data, long timestamp, EvasEventFlags event_flags) {
        super(data, timestamp, event_flags);
        this.hold = hold;
    }
    
    /**
     * Called from c
     * @param hold
     * @param data
     * @param timestamp
     * @param event_flags
     */
    Hold(int hold, Object data, long timestamp, int event_flags) {
        super(data, timestamp, EvasEventFlags.get(event_flags));
        this.hold = hold;
    }
    
}
