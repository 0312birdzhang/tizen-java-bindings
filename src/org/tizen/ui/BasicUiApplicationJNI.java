/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui;

import java.nio.ByteBuffer;

/**
 *
 * 
 */
public class BasicUiApplicationJNI {
    
    private static AppData appdata;
    
    /**
     * C code main method, passes through arguments to underlying JNI code.
     * @param appdata_s ByteBuffer containing pointer to appdata_s C struct.
     */
    public static void main(ByteBuffer appdata_s){
        appdata = new AppData(appdata_s);
    }
    
    public static class AppData {
        private final ByteBuffer appdata_s;
        
        AppData(ByteBuffer appdata_s){
            this.appdata_s = appdata_s;
        }
        
    }
    
}
