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
public abstract class ElmContainer extends ElmWidget implements AddBackground {
    
    static {
        System.loadLibrary("ElmContainer");
    }
    
    private final EvasObject parent;
    
    
    ElmContainer(Buffer evas_object, EvasObject parent){
        super(evas_object);
        this.parent = parent;
    }
    
    @Override
    public ElmBg elm_bg_add(){
        return super.elm_bg_add();
    }
    
    /**
     * @brief Add a new button to the canvas
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The new object or NULL if it cannot be created
     *
     * @ingroup Button
     */
    public ElmButton elm_button_add(){
        Buffer button = elm_button_add(pointer);
        if (button == null) return null;
        return new ElmButton(button, this);
    }
    
    private native Buffer elm_button_add(Buffer parent);
    
}
