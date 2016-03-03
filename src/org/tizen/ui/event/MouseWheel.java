/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.value.EvasCoordPoint;
import org.tizen.ui.value.EvasPoint;

/**
 *
 * 
 */
public class MouseWheel extends Mouse {
    static {
        System.loadLibrary("MouseWheel");
        initIDs();
    }

    private static native void initIDs();
    
    public final int direction;
    public final int z;
    
    /**
     * Called from c.
     * @param direction
     * @param z
     * @param x
     * @param y
     * @param cx
     * @param cy
     * @param d
     * @param t
     * @param ef 
     */
    MouseWheel(
            int direction, 
            int z, 
            int x, int y,
            int cx, int cy, 
            Object d, 
            long t, 
            int ef) 
    {
        super(new EvasPoint(x,y), new EvasCoordPoint(cx, cy),
                d, t, EvasEventFlags.get(ef), null);
        this.direction = direction;
        this.z = z;
    }
    
    public MouseWheel(
            int direction, 
            int z, 
            EvasPoint o, 
            EvasCoordPoint c, 
            Object d, 
            long t, 
            EvasEventFlags ef) 
    {
        super(o, c, d, t, ef, null);
        this.direction = direction;
        this.z = z;
    }
    
}
