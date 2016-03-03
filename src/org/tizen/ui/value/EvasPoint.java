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
public class EvasPoint {
    
    static {
        System.loadLibrary("EvasPoint");
        initIDs();
    }

    private static native void initIDs();
    
    /** x co-ordinate */
    public final int x;
    /** y co-ordinate */
    public final int y;
    
    public EvasPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}
