/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.Evas;
import org.tizen.ui.EvasObject;

/**
 *
 * 
 */
public abstract class EvasObjectEventCallBack<T> {
    private static native void initIDs();
    
    static{
        System.loadLibrary("EvasObjectEventCallBack");
        initIDs();
    }
    
    /**
     * @param data
     * @param e
     * @param eo
     * @param eventInfo
     * @brief Evas object event callback function signature
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     * @ingroup Evas_Object_Group_Events
     */
    public abstract void call(T data, Evas e, EvasObject eo, Object eventInfo );
}
