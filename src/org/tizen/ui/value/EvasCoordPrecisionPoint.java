/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.value;

/**
 *
 * 
 */
public class EvasCoordPrecisionPoint {
    
    static {
        System.loadLibrary("EvasCoordPrecisionPoint");
        initIDs();
    }

    private static native void initIDs();
    
    public final int x;
    public final int y;
    public final double xsub;
    public final double ysub;

    public EvasCoordPrecisionPoint(int ecpx, int ecpy, double xsub, double ysub) {
        x = ecpx;
        y = ecpy;
        this.xsub = xsub;
        this.ysub = ysub;
    }
    
}
