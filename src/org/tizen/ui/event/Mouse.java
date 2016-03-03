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
public abstract class Mouse extends EvasEvent {
        
    public final EvasPoint output;
    public final EvasCoordPoint canvas;
    //    EvasDevice dev;
    public final EvasObject event_src;

    protected Mouse( 
            EvasPoint o, 
            EvasCoordPoint c, 
            Object d, 
            long t, 
            EvasEventFlags ef, 
            EvasObject es) 
    {
        super(d, t, ef);
        output = o;
        canvas = c;
        event_src = es;
    }
    
}
