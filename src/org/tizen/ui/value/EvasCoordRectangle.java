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
public class EvasCoordRectangle {
    
    static {
        System.loadLibrary("EvasCoordRectangle");
        initIDs();
    }

    private static native void initIDs();
    
    
    /** top-left x co-ordinate of rectangle */
    public final int x;
    /** top-left y co-ordinate of rectangle */
    public final int y;
    /** width of rectangle */
    public final int w;
    /** height of rectangle */
    public final int h;
    
    public EvasCoordRectangle(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
