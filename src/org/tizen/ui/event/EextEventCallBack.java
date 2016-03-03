/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.EvasObject;

/**
 *
 * 
 */
public abstract class EextEventCallBack<T> {
    private static native void initIDs();
    
    static{
        System.loadLibrary("EextEventCallBack");
        initIDs();
    }
    
    /**
     * 
     * @param data - supplied at the time the EventCallBack was registered.
     * @param eo - the object that the event is associated with.
     * @param eventInfo - 
     */
    public abstract void call(T data, EvasObject eo, Object eventInfo );
    
}
