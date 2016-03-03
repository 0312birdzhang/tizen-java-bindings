/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

/**
 *
 * 
 */
public enum EvasButtonFlags {
    EVAS_BUTTON_NONE(0),
    EVAS_BUTTON_DOUBLE_CLICK(1),
    EVAS_BUTTON_TRIPLE_CLICK(1<<1);
    
    private final int value;
    
    private EvasButtonFlags(int value){
        this.value = value;
    }
    
    public static EvasButtonFlags get(int value){
        switch(value){
            case(1): return EVAS_BUTTON_DOUBLE_CLICK;
            case(1<<1): return EVAS_BUTTON_TRIPLE_CLICK;
            default: return EVAS_BUTTON_NONE;
        }
    }
    
    public int value(){
        return value;
    }
    
}
