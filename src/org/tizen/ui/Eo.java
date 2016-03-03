/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui;

import java.nio.Buffer;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 *
 * 
 */
public abstract class Eo {
    
    static {
        System.loadLibrary("Eo");
    }
    
    static final Map<Buffer, Eo> objectCache = new IdentityHashMap<Buffer,Eo>();
    
    /**
     * Called by c code to remove Eo's from map when objects are free'd.
     * 
     * This prevents an Eo from being garbage collected until c code
     * is finished with it.
     * 
     * @param b 
     */
    static void release(Buffer b){
        objectCache.remove(b);
    }
    
    final Buffer pointer;

    Eo(Buffer eo) {
        this(eo, true);
        objectCache.put(eo, this);
    }
    
    private Eo(Buffer eo, boolean ignored){
        pointer = eo;
    }// final field freeze.
    
}
