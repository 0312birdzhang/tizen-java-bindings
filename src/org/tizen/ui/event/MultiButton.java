/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

import org.tizen.ui.value.EvasCoordPrecisionPoint;
import org.tizen.ui.value.EvasPoint;

/**
 *
 * 
 */
public abstract class MultiButton extends EvasEvent {

    public final int device;
    public final double radius;
    public final double radius_x;
    public final double radius_y;
    public final double pressure;
    public final double angle;

    public MultiButton(
            int device, 
            double radius,
            double radius_x,
            double radius_y,
            double pressure,
            double angle,
            Object data, 
            long timestamp,
            EvasEventFlags event_flags) 
    {
        super(data, timestamp, event_flags);
        this.device = device;
        this.radius = radius;
        this.radius_x = radius_x;
        this.radius_y = radius_y;
        this.pressure = pressure;
        this.angle = angle;
    }

}
