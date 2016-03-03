/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.EvasObject;
import org.tizen.ui.value.EvasCoordPoint;
import org.tizen.ui.value.EvasPoint;

/**
 *
 * 
 */
public class MouseOut extends Mouse {
    static {
        System.loadLibrary("MouseOut");
        initIDs();
    }

    private static native void initIDs();

    public final int buttons;

    //    EvasModifier modifiers;
    //    EvasLock locks
    
    MouseOut(
            int b, 
            int x,int y, 
            int cx, int cy,
            Object d, 
            long t, 
            int ef, 
            EvasObject es) {
        super(new EvasPoint(x,y), new EvasCoordPoint(cx,cy), d,
                t, EvasEventFlags.get(ef), es);
        this.buttons = b;
    }
    
    public MouseOut(
            int b, 
            EvasPoint o, 
            EvasCoordPoint c, 
            Object d, 
            long t, 
            EvasEventFlags ef, 
            EvasObject es) {
        super(o, c, d, t, ef, es);
        this.buttons = b;
    }
    
}
