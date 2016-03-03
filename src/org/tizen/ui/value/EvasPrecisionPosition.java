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
public class EvasPrecisionPosition {
    
    static {
        System.loadLibrary("EvasPrecisionPosition");
        initIDs();
    }

    private static native void initIDs();
    
    public final EvasPoint output;
    public final EvasCoordPrecisionPoint canvas;
    
    public EvasPrecisionPosition(int epx, int epy,
                        int ecpx, int ecpy, 
                        double xsub, double ysub)
    {
        output = new EvasPoint(epx, epy);
        canvas = new EvasCoordPrecisionPoint(ecpx, ecpy, xsub, ysub);
    }
}
