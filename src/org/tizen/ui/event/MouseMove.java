/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.value.EvasPosition;

/**
 *
 * 
 */
public class MouseMove extends EvasEvent {
    static {
        System.loadLibrary("MouseMove");
        initIDs();
    }

    private static native void initIDs();
    
    public final int buttons;
    public final EvasPosition cur;
    public final EvasPosition prev;
    
    /**
     * 
     * @param buttons
     * @param cur
     * @param prev
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    public MouseMove(
            int buttons, 
            EvasPosition cur, 
            EvasPosition prev, 
            Object data, 
            long timestamp, 
            EvasEventFlags event_flags) 
    {
        super(data, timestamp, event_flags);
        this.buttons = buttons;
        this.cur = cur;
        this.prev = prev;
    }
    
    /**
     * Called from c.
     * @param buttons
     * @param cepx
     * @param cepy
     * @param cecpx
     * @param cecpy
     * @param pepx
     * @param pepy
     * @param pecpx
     * @param pecpy
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    MouseMove(
            int buttons, 
            int cepx, int cepy, int cecpx, int cecpy,
            int pepx, int pepy, int pecpx, int pecpy,
            Object data, 
            long timestamp, 
            int event_flags) 
    {
        super(data, timestamp, EvasEventFlags.get(event_flags));
        this.buttons = buttons;
        this.cur = new EvasPosition(cepx, cepy, cecpx, cecpy);
        this.prev = new EvasPosition(pepx, pepy, pecpx, pecpy);
    }
    
}
