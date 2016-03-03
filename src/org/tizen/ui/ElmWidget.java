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
public abstract class ElmWidget extends EvasObject{
    
    static {
        System.loadLibrary("ElmWidget");
    }
    
    public ElmWidget(Buffer evas_object) {
        super(evas_object);
    }
    
    /**
     * @brief Add a new Conformant container to this parent Elementary
     * (widget) object.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return A new conformant widget handle or @c NULL, on errors.
     *
     * @remark This function inserts a new conformant widget on the canvas.
     *
     * @ingroup Conformant
     */
    public ElmConformant elm_conformant_add(){
        Buffer conformantContainer = elm_conformant_add(pointer);
        if (conformantContainer != null) return new ElmConformant(conformantContainer, this);
        return null;
    }
    /**
     * elm_conform_legacy
     */
    private native Buffer elm_conformant_add(Buffer pointer);
    
    /**
     * @brief Add a new layout to the parent
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The new object or NULL if it cannot be created
     *
     * @see elm_layout_file_set()
     * @see elm_layout_theme_set()
     *
     * @ingroup Layout
     */
    public ElmLayout elm_layout_add(){
        Buffer layout = elm_layout_add(pointer);
        if (layout == null) return null;
        return new ElmLayout(layout, this);
    }
    /**
     * elm_layout_legacy
     */
    private native Buffer elm_layout_add(Buffer parent);
    
    /**
     * @brief Add a new background to a Window or Container
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The new object or @c NULL if it cannot be created
     *
     * @ingroup Bg
     */
    ElmBg elm_bg_add(){
        Buffer bg = elm_bg_add(pointer);
        if (bg == null) return null;
        return new ElmBg(bg, this);
    }
    
    /**
     * elm_bg_legacy
     * @param parent
     * @return 
     */
    private native Buffer elm_bg_add(Buffer parent);
    
}
