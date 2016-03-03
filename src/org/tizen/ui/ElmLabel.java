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
public class ElmLabel extends EvasObject{
    
    static {
        System.loadLibrary("ElmLabel");
    }
    
    private final ElmConformant parent;
    
    ElmLabel(Buffer evas_object, ElmConformant parent) {
        super(evas_object);
        this.parent = parent;
    }
    
}
