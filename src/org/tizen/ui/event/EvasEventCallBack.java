/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.Evas;

/**
 *
 * 
 */
public abstract class EvasEventCallBack {
    
    private static native void initIDs();
    
    static{
        System.loadLibrary("EvasEventCallBack");
        initIDs();
    }
    
    /**
     * 
     * @param data - supplied at the time the EventCallBack was registered.
     * @param eo - the Evas that the event is associated with.
     * @param eventInfo - 
     */
    public abstract void call(Object data, Evas eo, Object eventInfo );
    
}
