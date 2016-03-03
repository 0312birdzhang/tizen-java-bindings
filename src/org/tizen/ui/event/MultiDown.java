/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.value.EvasCoordPrecisionPoint;
import org.tizen.ui.value.EvasPoint;

/**
 *
 * 
 */
public class MultiDown extends MultiButton {  
    static {
        System.loadLibrary("MultiDown");
        initIDs();
    }

    private static native void initIDs();

    public final EvasPoint output;
    public final EvasCoordPrecisionPoint canvas;
    public final EvasButtonFlags flags;
    
    /**
     * Called from c.
     * @param device
     * @param radius
     * @param radius_x
     * @param radius_y
     * @param pressure
     * @param angle
     * @param x
     * @param y
     * @param ecpx
     * @param ecpy
     * @param xsub
     * @param ysub
     * @param flags
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    MultiDown(
            int device, 
            double radius, 
            double radius_x, 
            double radius_y, 
            double pressure, 
            double angle, 
            int x, int y,
            int ecpx, int ecpy, double xsub, double ysub,
            int flags,
            Object data, 
            long timestamp, 
            int event_flags) 
    {
        super(device, radius, radius_x, radius_y, pressure, angle, data, 
                timestamp, EvasEventFlags.get(event_flags));
        this.output = new EvasPoint(x,y);
        this.canvas = new EvasCoordPrecisionPoint(ecpx, ecpy, xsub, ysub);
        this.flags = EvasButtonFlags.get(flags);
    }
    
    /**
     * 
     * @param device
     * @param radius
     * @param radius_x
     * @param radius_y
     * @param pressure
     * @param angle
     * @param output
     * @param canvas
     * @param flags
     * @param data
     * @param timestamp
     * @param event_flags 
     */
    public MultiDown(
            int device,
            double radius, 
            double radius_x, 
            double radius_y, 
            double pressure, 
            double angle, 
            EvasPoint output, 
            EvasCoordPrecisionPoint canvas, 
            EvasButtonFlags flags,
            Object data, 
            long timestamp, 
            EvasEventFlags event_flags) 
    {
        super(device, radius, radius_x, radius_y, pressure, angle,
                data, timestamp, event_flags);
        this.output = output;
        this.canvas = canvas;
        this.flags = flags;
    }
    
}
