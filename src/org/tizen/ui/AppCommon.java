/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui;

/**
 *
 * 
 */
public class AppCommon {
    
    public static enum AppEventTypeE {
        APP_EVENT_LOW_MEMORY(0),
        APP_EVENT_LOW_BATTERY(1),
        APP_EVENT_LANGUAGE_CHANGED(2),
        APP_EVENT_DEVICE_ORIENTATION_CHANGED(3),
        APP_EVENT_REGION_FORMAT_CHANGED(4);

        private final int value;

        private AppEventTypeE(int value) {
            this.value = value;
        }

        public final int value(){
            return value;
        }

        public static AppEventTypeE get(int value){
            switch(value){
                case 0:
                    return APP_EVENT_LOW_MEMORY;
                case 1:
                    return APP_EVENT_LOW_BATTERY;
                case 2:
                    return APP_EVENT_LANGUAGE_CHANGED;
                case 3:
                    return APP_EVENT_DEVICE_ORIENTATION_CHANGED;
                case 4:
                    return APP_EVENT_REGION_FORMAT_CHANGED;
                default:
                    throw new IllegalArgumentException("Illegal app_event_type_e");
            }
        }
    }
    
}
