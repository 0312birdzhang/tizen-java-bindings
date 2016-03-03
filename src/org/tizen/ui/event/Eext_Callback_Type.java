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
public enum Eext_Callback_Type {
    EEXT_CALLBACK_BACK(0),    /** H/W Back Key Event */
    EEXT_CALLBACK_MORE(1),    /** H/W More Key Event */
    EEXT_CALLBACK_LAST(2);     /** Reserved value. Acutally This is not matched to
                            any meaningful behavior. */
    
    private final int value;
    
    private Eext_Callback_Type(int i){
        value = i;
    }
    
    public static Eext_Callback_Type get(int i){
        switch (i){
            case 0: return EEXT_CALLBACK_BACK;
            case 1: return EEXT_CALLBACK_MORE;
            case 2: return EEXT_CALLBACK_LAST;
            default: throw new IllegalArgumentException("Unknown callback type");
        }
    }
    
    public int value(){
        return value;
    }
}
