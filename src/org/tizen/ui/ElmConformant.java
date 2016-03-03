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
public class ElmConformant extends ElmContainer {
    
    static {
        System.loadLibrary("ElmConformant");
    }
    
    ElmConformant(Buffer evas_object, EvasObject parent) {
        super(evas_object, parent);
    }
    
}
