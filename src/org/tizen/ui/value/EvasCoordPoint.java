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
public class EvasCoordPoint extends EvasPoint {
    
    static {
        System.loadLibrary("EvasCoordPoint");
        initIDs();
    }

    private static native void initIDs();
    
    public EvasCoordPoint(int x, int y){
        super(x,y);
    }
}
