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
public enum EvasEventFlags {
    EVAS_EVENT_FLAG_NONE(0),
    EVAS_EVENT_FLAG_ON_HOLD(1),
    EVAS_EVENT_FLAG_ON_SCROLL(1<<1);
    
    private final int value;
    
    private EvasEventFlags(int value){
        this.value = value;
    }
    
    public static EvasEventFlags get(int value){
        switch(value){
            case(1): return EVAS_EVENT_FLAG_ON_HOLD;
            case(1<<1): return EVAS_EVENT_FLAG_ON_SCROLL;
            default: return EVAS_EVENT_FLAG_NONE;
        }
    }
    
    public int value(){
        return value;
    }
}
