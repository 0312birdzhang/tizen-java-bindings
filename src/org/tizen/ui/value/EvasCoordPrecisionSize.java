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
public class EvasCoordPrecisionSize {
    
    static {
        System.loadLibrary("EvasCoordPrecisionSize");
        initIDs();
    }

    private static native void initIDs();
    
    /** width */
    public final int w;
    /** height */
    public final int h;
    /** subpixel precision for width */
    public final double wsub;
    /** subpixel precision for height */
    public final double ysub;
    
    EvasCoordPrecisionSize(int w, int h, double wsub, double ysub){
        this.w = w;
        this.h = h;
        this.wsub = wsub;
        this.ysub = ysub;
    }
}
