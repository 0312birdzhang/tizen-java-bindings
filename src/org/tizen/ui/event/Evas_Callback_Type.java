/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui.event;

/**
 * Identifier of callbacks to be set for Evas canvases or Evas
 * objects.
 *
 * The following figure illustrates some Evas callbacks:
 *
 * @image html evas-callbacks.png
 * @image rtf evas-callbacks.png
 * @image latex evas-callbacks.eps
 *
 * @see evas_object_event_callback_add()
 * @see evas_event_callback_add()
 */
public enum Evas_Callback_Type {
    /*
     * The following events are only for use with Evas objects, with
     * evas_object_event_callback_add():
     */
    /**
     * Mouse In Event
     */
    EVAS_CALLBACK_MOUSE_IN(1), 
    /**
     * Mouse Out Event
     */
    EVAS_CALLBACK_MOUSE_OUT(2), 
    /**
     * Mouse Button Down Event
     */
    EVAS_CALLBACK_MOUSE_DOWN(3), 
    /**
     * Mouse Button Up Event
     */
    EVAS_CALLBACK_MOUSE_UP(4), 
    /**
     * Mouse Move Event
     */
    EVAS_CALLBACK_MOUSE_MOVE(5), 
    /**
     * Mouse Wheel Event
     */
    EVAS_CALLBACK_MOUSE_WHEEL(6), 
    /**
     * Multi-touch Down Event
     */
    EVAS_CALLBACK_MULTI_DOWN(7), 
    /**
     * Multi-touch Up Event
     */
    EVAS_CALLBACK_MULTI_UP(8), 
    /**
     * Multi-touch Move Event
     */
    EVAS_CALLBACK_MULTI_MOVE(9), 
    /**
     * Object Being Freed (Called after Del)
     */
    EVAS_CALLBACK_FREE(10), 
    /**
     * Key Press Event
     */
    EVAS_CALLBACK_KEY_DOWN(11), 
    /**
     * Key Release Event
     */
    EVAS_CALLBACK_KEY_UP(12), 
    /**
     * Focus In Event
     */
    EVAS_CALLBACK_FOCUS_IN(13), 
    /**
     * Focus Out Event
     */
    EVAS_CALLBACK_FOCUS_OUT(14), 
    /**
     * Show Event
     */
    EVAS_CALLBACK_SHOW(15), 
    /**
     * Hide Event
     */
    EVAS_CALLBACK_HIDE(16), 
    /**
     * Move Event
     */
    EVAS_CALLBACK_MOVE(17), 
    /**
     * Resize Event
     */
    EVAS_CALLBACK_RESIZE(18), 
    /**
     * Restack Event
     */
    EVAS_CALLBACK_RESTACK(19), 
    /**
     * Object Being Deleted (called before Free)
     */
    EVAS_CALLBACK_DEL(20), 
    /**
     * Events go on/off hold
     */
    EVAS_CALLBACK_HOLD(21), 
    /**
     * Size hints changed event
     */
    EVAS_CALLBACK_CHANGED_SIZE_HINTS(22), 
    /**
     * Image has been preloaded
     */
    EVAS_CALLBACK_IMAGE_PRELOADED(23), 
    /*
     * The following events are only for use with Evas canvases, with
     * evas_event_callback_add():
     */ 
    
    /**
     * Canvas got focus as a whole
     */
    EVAS_CALLBACK_CANVAS_FOCUS_IN(24), 
    /**
     * Canvas lost focus as a whole
     */
    EVAS_CALLBACK_CANVAS_FOCUS_OUT(25), 
    /**
     * Called just before rendering is updated on the canvas target
     */
    EVAS_CALLBACK_RENDER_FLUSH_PRE(26), 
    /**
     * Called just after rendering is updated on the canvas target
     */
    EVAS_CALLBACK_RENDER_FLUSH_POST(27), 
    /**
     * Canvas object got focus
     */
    EVAS_CALLBACK_CANVAS_OBJECT_FOCUS_IN(28), 
    /**
     * Canvas object lost focus
     */
    EVAS_CALLBACK_CANVAS_OBJECT_FOCUS_OUT(29), 
    /*
     * More Evas object event types - see evas_object_event_callback_add():  
     */ 
    
    /**
     * Image data has been unloaded (by some mechanism in Evas that throw out
     * original image data)
     */
    EVAS_CALLBACK_IMAGE_UNLOADED(30), 
    /**
     * Called just before rendering starts on the canvas target @since 1.2
     */
    EVAS_CALLBACK_RENDER_PRE(31), 
    /**
     * Called just after rendering stops on the canvas target @since 1.2
     */
    EVAS_CALLBACK_RENDER_POST(32), 
    /**
     * Image size is changed @since 1.8
     */
    EVAS_CALLBACK_IMAGE_RESIZE(33), 
    /**
     * Devices added, removed or changed on canvas @since 1.8
     */
    EVAS_CALLBACK_DEVICE_CHANGED(34), 
    /**
     * Input device changed value on some axis @since 1.13
     */
    EVAS_CALLBACK_AXIS_UPDATE(35), 
    /**
     * Canvas viewport resized @since 1.15
     */
    EVAS_CALLBACK_CANVAS_VIEWPORT_RESIZE(36), 
    /** kept as last element/sentinel -- not really an event */
    EVAS_CALLBACK_LAST(37);
    
    private final int value;

    private Evas_Callback_Type(int value) {
        this.value = value;
    }

    public final int value() {
        return value;
    }

    public static Evas_Callback_Type get(int value) {
        switch (value) {
            case 0:
                return EVAS_CALLBACK_MOUSE_IN; /** Mouse In Event */
            case 1:
                return EVAS_CALLBACK_MOUSE_OUT; /** Mouse Out Event */
            case 2:
                return EVAS_CALLBACK_MOUSE_DOWN; /** Mouse Button Down Event */
            case 3:
                return EVAS_CALLBACK_MOUSE_UP; /** Mouse Button Up Event */
            case 4:
                return EVAS_CALLBACK_MOUSE_MOVE; /** Mouse Move Event */
            case 5:
                return EVAS_CALLBACK_MOUSE_WHEEL; /** Mouse Wheel Event */
            case 6:
                return EVAS_CALLBACK_MULTI_DOWN; /** Multi-touch Down Event */
            case 7:
                return EVAS_CALLBACK_MULTI_UP; /** Multi-touch Up Event */
            case 8:
                return EVAS_CALLBACK_MULTI_MOVE; /** Multi-touch Move Event */
            case 9:
                return EVAS_CALLBACK_FREE; /** Object Being Freed (Called after Del) */
            case 10:
                return EVAS_CALLBACK_KEY_DOWN; /** Key Press Event */
            case 11:
                return EVAS_CALLBACK_KEY_UP; /** Key Release Event */
            case 12:
                return EVAS_CALLBACK_FOCUS_IN; /** Focus In Event */
            case 13:
                return EVAS_CALLBACK_FOCUS_OUT; /** Focus Out Event */
            case 14:
                return EVAS_CALLBACK_SHOW; /** Show Event */
            case 15:
                return EVAS_CALLBACK_HIDE; /** Hide Event */
            case 16:
                return EVAS_CALLBACK_MOVE; /** Move Event */
            case 17:
                return EVAS_CALLBACK_RESIZE; /** Resize Event */
            case 18:
                return EVAS_CALLBACK_RESTACK; /** Restack Event */
            case 19:
                return EVAS_CALLBACK_DEL; /** Object Being Deleted (called before Free) */
            case 20:
                return EVAS_CALLBACK_HOLD; /** Events go on/off hold */
            case 21:
                return EVAS_CALLBACK_CHANGED_SIZE_HINTS; /** Size hints changed event */
            case 22:
                return EVAS_CALLBACK_IMAGE_PRELOADED; /** Image has been preloaded */
        /*
         * The following events are only for use with Evas canvases, with
         * evas_event_callback_add():
         */
            case 23:
                return EVAS_CALLBACK_CANVAS_FOCUS_IN; /** Canvas got focus as a whole */
            case 24:
                return EVAS_CALLBACK_CANVAS_FOCUS_OUT; /** Canvas lost focus as a whole */
            case 25:
                return EVAS_CALLBACK_RENDER_FLUSH_PRE; /** Called just before rendering is updated on the canvas target */
            case 26:
                return EVAS_CALLBACK_RENDER_FLUSH_POST; /** Called just after rendering is updated on the canvas target */
            case 27:
                return EVAS_CALLBACK_CANVAS_OBJECT_FOCUS_IN; /** Canvas object got focus */
            case 28:
                return EVAS_CALLBACK_CANVAS_OBJECT_FOCUS_OUT; /** Canvas object lost focus */
        /*
         * More Evas object event types - see evas_object_event_callback_add():
         */
            case 29:
                return EVAS_CALLBACK_IMAGE_UNLOADED; /** Image data has been unloaded (by some mechanism in Evas that throw out original image data) */
            case 30:
                return EVAS_CALLBACK_RENDER_PRE; /** Called just before rendering starts on the canvas target @since 1.2 */
            case 31:
                return EVAS_CALLBACK_RENDER_POST; /** Called just after rendering stops on the canvas target @since 1.2 */
            case 32:
                return EVAS_CALLBACK_IMAGE_RESIZE; /** Image size is changed @since 1.8 */
            case 33:
                return EVAS_CALLBACK_DEVICE_CHANGED; /** Devices added, removed or changed on canvas @since 1.8 */
            case 34:
                return EVAS_CALLBACK_AXIS_UPDATE; /** Input device changed value on some axis @since 1.13 */
            case 35:
                return EVAS_CALLBACK_CANVAS_VIEWPORT_RESIZE; /** Canvas viewport resized @since 1.15 */
            case 36:
                return EVAS_CALLBACK_LAST; /** kept as last element/sentinel -- not really an event */
            default:
                throw new IllegalArgumentException("Illegal event_type");
        }
    }
    
}
