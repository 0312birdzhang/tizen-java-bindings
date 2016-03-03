/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.value;

/**
 * A size in Evas_Coord
 * 
 */
public class EvasCoordSize {
    
    static {
        System.loadLibrary("EvasCoordSize");
        initIDs();
    }

    private static native void initIDs();
    
    
    /** width */
    public final int w;
    /** height */
    public final int h;
    
    EvasCoordSize(int w, int h){
        this.w = w;
        this.h = h;
    }
}
