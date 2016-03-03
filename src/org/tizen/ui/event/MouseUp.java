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
public class MouseUp extends MouseButton {
    static {
        System.loadLibrary("MouseUp");
        initIDs();
    }

    private static native void initIDs();
    //    EvasModifier modifiers;
    //    EvasLock locks
    
    MouseUp(
            int b, 
            int x,int y, 
            int cx, int cy,
            Object d, 
            int f,
            long t, 
            int ef, 
            EvasObject es) {
        super(checkButton(b), new EvasPoint(x,y), new EvasCoordPoint(cx,cy), d,
                EvasButtonFlags.get(f), t, EvasEventFlags.get(ef), es);
    }
    
    
    public MouseUp(
            int b, 
            EvasPoint o, 
            EvasCoordPoint c, 
            Object d, 
            EvasButtonFlags f, 
            long t, 
            EvasEventFlags ef, 
            EvasObject es) 
    {
        super(checkButton(b), o, c, d, f, t, ef, es);
    }
    
}
