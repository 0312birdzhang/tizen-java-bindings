/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.value.EvasPrecisionPosition;

/**
 *
 * 
 */
public class MultiMove extends MultiButton {
    static {
        System.loadLibrary("MultiMove");
        initIDs();
    }

    private static native void initIDs();
    
    public final EvasPrecisionPosition cur;
    
    /**
     * Called from c
     * @param device
     * @param radius
     * @param radius_x
     * @param radius_y
     * @param pressure
     * @param angle
     * @param epx
     * @param epy
     * @param ecpx
     * @param ecpy
     * @param xsub
     * @param ysub
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    MultiMove(
            int device,
            double radius, 
            double radius_x, 
            double radius_y, 
            double pressure, 
            double angle, 
            int epx, int epy,int ecpx, int ecpy, double xsub, double ysub,
            Object data, 
            long timestamp, 
            int event_flags) 
    {
        super(device, radius, radius_x, radius_y, pressure, angle,
                data, timestamp, EvasEventFlags.get(event_flags));
        this.cur = new EvasPrecisionPosition(epx, epy, ecpx, ecpy, xsub, ysub);
    }
    
    /**
     * 
     * @param device
     * @param radius
     * @param radius_x
     * @param radius_y
     * @param pressure
     * @param angle
     * @param cur
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    public MultiMove(
            int device,
            double radius, 
            double radius_x, 
            double radius_y, 
            double pressure, 
            double angle, 
            EvasPrecisionPosition cur,
            Object data, 
            long timestamp, 
            EvasEventFlags event_flags) 
    {
        super(device, radius, radius_x, radius_y, pressure, angle,
                data, timestamp, event_flags);
        this.cur = cur;
    }
    
    
    
}
