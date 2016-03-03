/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.value;

import org.tizen.ui.value.EvasCoordPoint;

/**
 * A position.
 * 
 */
public class EvasPosition {
    
    static {
        System.loadLibrary("EvasPosition");
        initIDs();
    }

    private static native void initIDs();
    
    
    /** position on the output */
    public final EvasPoint output;
    /** position on the canvas */
    public final EvasCoordPoint canvas;
    
    public EvasPosition(int epx, int epy, int ecpx, int ecpy){
        output = new EvasPoint(epx, epy);
        canvas = new EvasCoordPoint(ecpx, ecpy);
    }
}
