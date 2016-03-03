/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui;

import java.nio.Buffer;

/**
 *
 * 
 */
public class ElmButton extends ElmLayout{
    
    static {
        System.loadLibrary("ElmButton");
    }
    
    ElmButton(Buffer evas_object, EvasObject parent) {
        super(evas_object, parent);
    }
    
    /**
     *
     * @brief Set the initial timeout before the autorepeat event is generated
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Sets the timeout, in seconds, since the button is pressed until the
     * first @c repeated signal is emitted. If @p t is 0.0 or less, there
     * won't be any delay and the event will be fired the moment the button is
     * pressed.
     *
     * @see elm_button_autorepeat_set()
     * @see elm_button_autorepeat_gap_timeout_set()
     *
     * @ingroup Button
     *
     * @param t Timeout in seconds
     */
    public void autorepeat_initial_timeout_set(double t){
        autorepeat_initial_timeout_set(pointer, t);
    }
    
    private native void autorepeat_initial_timeout_set(Buffer pointer, double t);
    
}
