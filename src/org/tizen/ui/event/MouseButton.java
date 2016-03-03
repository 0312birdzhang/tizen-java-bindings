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
public class MouseButton extends Mouse {
    static {
        System.loadLibrary("MouseButton");
        initIDs();
    }

    private static native void initIDs();

    protected static int checkButton(int button) throws IllegalArgumentException {
        if (button >= 1 && button <= 32) {
            return button;
        }
        throw new IllegalArgumentException("Button number out of range (1 - 32): " + button);
    }

    //    EvasModifier modifiers;
    //    EvasLock locks
    public final EvasButtonFlags flags;
    public final int button;
    
    /**
     * Called from c.
     * @param b
     * @param x
     * @param y
     * @param cx
     * @param cy
     * @param d
     * @param f
     * @param t
     * @param ef
     * @param es 
     */
    MouseButton(int b, 
            int x, int y,
            int cx, int cy,
            Object d, 
            int f, 
            long t, 
            int ef, 
            EvasObject es) 
    {
        super(new EvasPoint(x,y), new EvasCoordPoint(cx,cy), d, t, EvasEventFlags.get(ef), es);
        button = b;
        flags = EvasButtonFlags.get(f);
    }
    
    public MouseButton(int b, 
            EvasPoint o, 
            EvasCoordPoint c, 
            Object d, 
            EvasButtonFlags f, 
            long t, 
            EvasEventFlags ef, 
            EvasObject es) 
    {
        super(o, c, d, t, ef, es);
        button = b;
        flags = f;
    }
    
}
