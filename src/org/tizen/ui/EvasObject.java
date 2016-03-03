/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tizen.ui;

import java.nio.Buffer;
import org.tizen.ui.event.EextEventCallBack;
import org.tizen.ui.event.Eext_Callback_Type;
import org.tizen.ui.event.EvasObjectEventCallBack;
import org.tizen.ui.event.EvasSmartCallBack;
import org.tizen.ui.event.Evas_Callback_Type;

/**
 *
 * 
 */
public abstract class EvasObject extends Eo {
    
    static {
        System.loadLibrary("EvasObject");
    }
    
    EvasObject(Buffer evas_object){
        super(evas_object);
    }
    
    /**
     * @param <T>
     * @brief Add (register) a callback function to a given Evas object event.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param type The type of event that will trigger the callback
     * @param func The function to be called when the event is triggered
     * @param data The data pointer to be passed to @p func
     *
     * @remark This function adds a function callback to an object when the event
     * of type @p type occurs on object @p obj. The function is @p func.
     *
     * @remark In the event of a memory allocation error during addition of the
     * callback to the object, Evas Alloc Error function should be used to
     * determine the nature of the error, if any, and the program should
     * sensibly try and recover.
     *
     * @remark A callback function must have the ::Evas_Object_Event_Cb prototype
     * definition. The first parameter (@p data) in this definition will
     * have the same value passed to evas_object_event_callback_add() as
     * the @p data parameter, at runtime. The second parameter @p e is the
     * canvas pointer on which the event occurred. The third parameter is
     * a pointer to the object on which event occurred. Finally, the
     * fourth parameter @p event_info is a pointer to a data structure
     * that may or may not be passed to the callback, depending on the
     * event type that triggered the callback. This is so because some
     * events don't carry extra context with them, but others do.
     *
     * @remark The event type @p type to trigger the function may be one of
     * #EVAS_CALLBACK_MOUSE_IN, #EVAS_CALLBACK_MOUSE_OUT,
     * #EVAS_CALLBACK_MOUSE_DOWN, #EVAS_CALLBACK_MOUSE_UP,
     * #EVAS_CALLBACK_MOUSE_MOVE, #EVAS_CALLBACK_MOUSE_WHEEL,
     * #EVAS_CALLBACK_MULTI_DOWN, #EVAS_CALLBACK_MULTI_UP,
     * #EVAS_CALLBACK_AXIS_UPDATE,
     * #EVAS_CALLBACK_MULTI_MOVE, #EVAS_CALLBACK_FREE,
     * #EVAS_CALLBACK_KEY_DOWN, #EVAS_CALLBACK_KEY_UP,
     * #EVAS_CALLBACK_FOCUS_IN, #EVAS_CALLBACK_FOCUS_OUT,
     * #EVAS_CALLBACK_SHOW, #EVAS_CALLBACK_HIDE, #EVAS_CALLBACK_MOVE,
     * #EVAS_CALLBACK_RESIZE, #EVAS_CALLBACK_RESTACK, #EVAS_CALLBACK_DEL,
     * #EVAS_CALLBACK_HOLD, #EVAS_CALLBACK_CHANGED_SIZE_HINTS,
     * #EVAS_CALLBACK_IMAGE_PRELOADED or #EVAS_CALLBACK_IMAGE_UNLOADED.
     *
     * @remark This determines the kind of event that will trigger the callback.
     * What follows is a list explaining better the nature of each type of
     * event, along with their associated @p event_info pointers:
     *
     * - #EVAS_CALLBACK_MOUSE_IN: @p event_info is a pointer to an
     *   #Evas_Event_Mouse_In struct\n\n
     *   This event is triggered when the mouse pointer enters the area
     *   (not shaded by other objects) of the object @p obj. This may
     *   occur by the mouse pointer being moved by
     *   evas_event_feed_mouse_move() calls, or by the object being shown,
     *   raised, moved, resized, or other objects being moved out of the
     *   way, hidden or lowered, whatever may cause the mouse pointer to
     *   get on top of @p obj, having been on top of another object
     *   previously.
     *
     * - #EVAS_CALLBACK_MOUSE_OUT: @p event_info is a pointer to an
     *   #Evas_Event_Mouse_Out struct\n\n
     *   This event is triggered exactly like #EVAS_CALLBACK_MOUSE_IN is,
     *   but it occurs when the mouse pointer exits an object's area. Note
     *   that no mouse out events will be reported if the mouse pointer is
     *   implicitly grabbed to an object (mouse buttons are down, having
     *   been pressed while the pointer was over that object). In these
     *   cases, mouse out events will be reported once all buttons are
     *   released, if the mouse pointer has left the object's area. The
     *   indirect ways of taking off the mouse pointer from an object,
     *   like cited above, for #EVAS_CALLBACK_MOUSE_IN, also apply here,
     *   naturally.
     *
     * - #EVAS_CALLBACK_MOUSE_DOWN: @p event_info is a pointer to an
     *   #Evas_Event_Mouse_Down struct\n\n
     *   This event is triggered by a mouse button being pressed while the
     *   mouse pointer is over an object. If the pointer mode for Evas is
     *   #EVAS_OBJECT_POINTER_MODE_AUTOGRAB (default), this causes this
     *   object to <b>passively grab the mouse</b> until all mouse buttons
     *   have been released: all future mouse events will be reported to
     *   only this object until no buttons are down. That includes mouse
     *   move events, mouse in and mouse out events, and further button
     *   presses. When all buttons are released, event propagation will
     *   occur as normal (see #Evas_Object_Pointer_Mode).
     *
     * - #EVAS_CALLBACK_MOUSE_UP: @p event_info is a pointer to an
     *   #Evas_Event_Mouse_Up struct\n\n
     *   This event is triggered by a mouse button being released while
     *   the mouse pointer is over an object's area (or when passively
     *   grabbed to an object).
     *
     * - #EVAS_CALLBACK_MOUSE_MOVE: @p event_info is a pointer to an
     *   #Evas_Event_Mouse_Move struct\n\n
     *   This event is triggered by the mouse pointer being moved while
     *   over an object's area (or while passively grabbed to an object).
     *
     * - #EVAS_CALLBACK_MOUSE_WHEEL: @p event_info is a pointer to an
     *   #Evas_Event_Mouse_Wheel struct\n\n
     *   This event is triggered by the mouse wheel being rolled while the
     *   mouse pointer is over an object (or passively grabbed to an
     *   object).
     *
     * - #EVAS_CALLBACK_MULTI_DOWN: @p event_info is a pointer to an
     *   #Evas_Event_Multi_Down struct
     *
     * - #EVAS_CALLBACK_MULTI_UP: @p event_info is a pointer to an
     *   #Evas_Event_Multi_Up struct
     *
     * - #EVAS_CALLBACK_MULTI_MOVE: @p event_info is a pointer to an
     *   #Evas_Event_Multi_Move struct
     *
     * - #EVAS_CALLBACK_AXIS_UPDATE: @p event_info is a pointer to an
     *   #Evas_Event_Axis_Update struct
     *
     * - #EVAS_CALLBACK_FREE: @p event_info is @c NULL \n\n
     *   This event is triggered just before Evas is about to free all
     *   memory used by an object and remove all references to it. This is
     *   useful for programs to use if they attached data to an object and
     *   want to free it when the object is deleted. The object is still
     *   valid when this callback is called, but after it returns, there
     *   is no guarantee on the object's validity.
     *
     * - #EVAS_CALLBACK_KEY_DOWN: @p event_info is a pointer to an
     *   #Evas_Event_Key_Down struct\n\n
     *   This callback is called when a key is pressed and the focus is on
     *   the object, or a key has been grabbed to a particular object
     *   which wants to intercept the key press regardless of what object
     *   has the focus.
     *
     * - #EVAS_CALLBACK_KEY_UP: @p event_info is a pointer to an
     *   #Evas_Event_Key_Up struct \n\n
     *   This callback is called when a key is released and the focus is
     *   on the object, or a key has been grabbed to a particular object
     *   which wants to intercept the key release regardless of what
     *   object has the focus.
     *
     * - #EVAS_CALLBACK_FOCUS_IN: @p event_info is @c NULL \n\n
     *   This event is called when an object gains the focus. When it is
     *   called the object has already gained the focus.
     *
     * - #EVAS_CALLBACK_FOCUS_OUT: @p event_info is @c NULL \n\n
     *   This event is triggered when an object loses the focus. When it
     *   is called the object has already lost the focus.
     *
     * - #EVAS_CALLBACK_SHOW: @p event_info is @c NULL \n\n
     *   This event is triggered by the object being shown by
     *   evas_object_show().
     *
     * - #EVAS_CALLBACK_HIDE: @p event_info is @c NULL \n\n
     *   This event is triggered by an object being hidden by
     *   evas_object_hide().
     *
     * - #EVAS_CALLBACK_MOVE: @p event_info is @c NULL \n\n
     *   This event is triggered by an object being
     *   moved. evas_object_move() can trigger this, as can any
     *   object-specific manipulations that would mean the object's origin
     *   could move.
     *
     * - #EVAS_CALLBACK_RESIZE: @p event_info is @c NULL \n\n
     *   This event is triggered by an object being resized. Resizes can
     *   be triggered by evas_object_resize() or by any object-specific
     *   calls that may cause the object to resize.
     *
     * - #EVAS_CALLBACK_RESTACK: @p event_info is @c NULL \n\n
     *   This event is triggered by an object being re-stacked. Stacking
     *   changes can be triggered by
     *   evas_object_stack_below()/evas_object_stack_above() and others.
     *
     * - #EVAS_CALLBACK_DEL: @p event_info is @c NULL.
     *
     * - #EVAS_CALLBACK_HOLD: @p event_info is a pointer to an
     *   #Evas_Event_Hold struct
     *
     * - #EVAS_CALLBACK_CHANGED_SIZE_HINTS: @p event_info is @c NULL.
     *
     * - #EVAS_CALLBACK_IMAGE_PRELOADED: @p event_info is @c NULL.
     *
     * - #EVAS_CALLBACK_IMAGE_UNLOADED: @p event_info is @c NULL.
     *
     * @remark Be careful not to add the same callback multiple times, if
     * that's not what you want, because Evas won't check if a callback
     * existed before exactly as the one being registered (and thus, call
     * it more than once on the event, in this case). This would make
     * sense if you passed different functions and/or callback data, only.
     *
     * @remark Example:
     * @dontinclude evas-events.c
     * @skip evas_object_event_callback_add(
     * @until }
     *
     * @remark See the full example @ref Example_Evas_Events "here".
     *
     */
    public <T> void add(Evas_Callback_Type type,
            EvasObjectEventCallBack<T> func, T data) 
    {
        add(pointer, type, func, data);
    }

    private native <T> void add(Buffer pointer, Evas_Callback_Type type,
            EvasObjectEventCallBack<T> func, T data);
    
    /**
     * @param <T>
     * @brief Add (register) a callback function to a given Evas object event with a
     * non-default priority set. Except for the priority field, it's exactly the
     * same as @ref evas_object_event_callback_add
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param type The type of event that will trigger the callback
     * @param priority The priority of the callback, lower values called first.
     * @param func The function to be called when the event is triggered
     * @param data The data pointer to be passed to @p func
     *
     * @see evas_object_event_callback_add#add
     * @since 1.1
     */
    public <T> void evas_object_event_callback_priority_add(Evas_Callback_Type type, 
            short priority, EvasObjectEventCallBack<T> func, T data)
    { //EINA_ARG_NONNULL(1, 4);
        evas_object_event_callback_priority_add(pointer, type, priority, func, data);
    }
    
    private native <T> void evas_object_event_callback_priority_add(Buffer pointer, Evas_Callback_Type type, 
            short priority, EvasObjectEventCallBack<T> func, T data);

    /**
     * @param <T>
     * @brief Delete a callback function from an object
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param type The type of event that was triggering the callback
     * @param func The function that was to be called when the event was triggered
     * @return The data pointer that was to be passed to the callback
     *
     * @remark This function removes the most recently added callback from the
     * object @p obj which was triggered by the event type @p type and was
     * calling the function @p func when triggered. If the removal is
     * successful it will also return the data pointer that was passed to
     * evas_object_event_callback_add() when the callback was added to the
     * object. If not successful @c NULL will be returned.
     *
     * @remark Example:
     * @code
     * extern Evas_Object *object;
     * void *my_data;
     * void up_callback(void *data, Evas *e, Evas_Object *obj, void *event_info);
     *
     * my_data = evas_object_event_callback_del(object, EVAS_CALLBACK_MOUSE_UP, up_callback);
     * @endcode
     */
    public <T> T evas_object_event_callback_del(Evas_Callback_Type type, EvasObjectEventCallBack<T> func)
    {// EINA_ARG_NONNULL(1, 3);
        return evas_object_event_callback_del(pointer, type, func);
    }
    
    private native <T> T evas_object_event_callback_del(Buffer pointer, 
            Evas_Callback_Type type, EvasObjectEventCallBack<T> func);

    /**
     * @brief Delete (unregister) a callback function registered to a given
     * Evas object event.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param type The type of event that was triggering the callback
     * @param func The function that was to be called when the event was
     * triggered
     * @param data The data pointer that was to be passed to the callback
     * @return The data pointer that was to be passed to the callback
     *
     * @remark This function removes the most recently added callback from the
     * object @p obj, which was triggered by the event type @p type and was
     * calling the function @p func with data @p data, when triggered. If
     * the removal is successful it will also return the data pointer that
     * was passed to evas_object_event_callback_add() (that will be the
     * same as the parameter) when the callback was added to the
     * object. In errors, @c NULL will be returned.
     *
     * @remark For deletion of Evas object events callbacks filtering by
     * just type and function pointer, use
     * evas_object_event_callback_del().
     *
     * @remark Example:
     * @code
     * extern Evas_Object *object;
     * void *my_data;
     * void up_callback(void *data, Evas *e, Evas_Object *obj, void *event_info);
     *
     * my_data = evas_object_event_callback_del_full(object, EVAS_CALLBACK_MOUSE_UP, up_callback, data);
     * @endcode
     */
    public <T> T evas_object_event_callback_del_full(Evas_Callback_Type type, 
            EvasObjectEventCallBack<T> func, T data)
    {// EINA_ARG_NONNULL(1, 3);
        return evas_object_event_callback_del_full(pointer, type, func, data);
    }

    private native <T> T evas_object_event_callback_del_full(Buffer pointer, 
            Evas_Callback_Type type, 
            EvasObjectEventCallBack<T> func, T data);
    
    /**
     * 
     * @brief Add (register) a callback function to the smart event specified by
     * @p event on the smart object @p obj.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * 
     * @param event the event's name string
     * @param func the callback function
     * @param data user data to be passed to the callback function
     *
     * @remark Smart callbacks look very similar to Evas callbacks, but are
     * implemented as smart object's custom ones.
     *
     * @remark This function adds a function callback to an smart object when the
     * event named @p event occurs in it. The function is @p func.
     *
     * @remark In the event of a memory allocation error during addition of the
     * callback to the object, Evas Alloc Error function should be used to
     * determine the nature of the error, if any, and the program should
     * sensibly try and recover.
     *
     * @remark A smart callback function must have the ::Evas_Smart_Cb prototype
     * definition. The first parameter (@p data) in this definition will
     * have the same value passed to evas_object_smart_callback_add() as
     * the @p data parameter, at runtime. The second parameter @p obj is a
     * handle to the object on which the event occurred. The third
     * parameter, @p event_info, is a pointer to data which is totally
     * dependent on the smart object's implementation and semantic for the
     * given event.
     *
     * @remark There is an infrastructure for introspection on smart objects'
     * events, but no
     * internal smart objects on Evas implement them yet.
     *
     * @see @ref Evas_Smart_Object_Group_Callbacks for more details.
     *
     * @see evas_object_smart_callback_del()
     */
    public <T> void add_smart(String event, 
                                        EvasSmartCallBack<T> func,
                                        T data) 
    {
        add_smart(pointer, event, func, data);
    }
    
    private native <T> void add_smart(Buffer pointer, 
                                                String event, 
                                                EvasSmartCallBack<T> func, 
                                                T data);
    
    /**
     * @param <T> the data type.
     * @brief Delete (unregister) a callback function from the smart event
     * specified by @p event on the smart object @p obj.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param event the event's name string
     * @param func the callback function
     * @return the data pointer
     *
     * @remark This function removes <b>the first</b> added smart callback on the
     * object @p obj matching the event name @p event and the registered
     * function pointer @p func. If the removal is successful it will also
     * return the data pointer that was passed to
     * evas_object_smart_callback_add() (that will be the same as the
     * parameter) when the callback(s) was(were) added to the canvas. If
     * not successful @c NULL will be returned.
     *
     * @see smart_callback_add() for more details.
     *
     */
    public <T> T smart_callback_del(String event, EvasSmartCallBack<T> func){
        return smart_callback_del(pointer, event, func);
    }
    
    private native <T> T smart_callback_del(Buffer pointer, 
            String event, EvasSmartCallBack<T> func);
    
    /**
     * @brief Delete (unregister) a callback function from the smart event
     * specified by @p event on the smart object @p obj.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param event the event's name string
     * @param func the callback function
     * @param data the data pointer that was passed to the callback
     * @return the data pointer
     *
     * @remark This function removes <b>the first</b> added smart callback on the
     * object @p obj matching the event name @p event, the registered
     * function pointer @p func and the callback data pointer @p data. If
     * the removal is successful it will also return the data pointer that
     * was passed to evas_object_smart_callback_add() (that will be the same
     * as the parameter) when the callback(s) was(were) added to the canvas.
     * If not successful @c NULL will be returned. A common use would be to
     * remove an exact match of a callback
     *
     * @see evas_object_smart_callback_add() for more details.
     * @since 1.2
     *
     * @remark To delete all smart event callbacks which match @p type and @p func,
     * use smart_callback_del().
     */
    public <T> T smart_callback_del_full(String event,
                                        EvasSmartCallBack<T> func, 
                                        T data)
    {
        return smart_callback_del_full(pointer, event, func, data);
    }
    
    private native <T> T smart_callback_del_full(Buffer pointer,
            String event, EvasSmartCallBack<T> func, T data);
    
    /**
     * @brief Call a given smart callback on the smart object @p obj.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param event the event's name string
     * @param event_info pointer to an event specific struct or information to
     * pass to the callback functions registered on this smart event
     *
     * @remark This should be called @b internally, from the smart object's own
     * code, when some specific event has occurred and the implementor
     * wants is to pertain to the object's events API (see @ref
     * Evas_Smart_Object_Group_Callbacks). The documentation for the smart
     * object should include a list of possible events and what type of @p
     * event_info to expect for each of them. Also, when defining an
     * #Evas_Smart_Class, smart object implementors are strongly
     * encouraged to properly set the Evas_Smart_Class::callbacks
     * callbacks description array, so that the users of the smart object
     * can have introspection on its events API <b>at run time</b>.
     *
     */
//    public void evas_object_smart_callback_call(String event, Object event_info){
//        evas_object_smart_callback_call(pointer, event, event_info);
//    }
//    
//    private native void evas_object_smart_callback_call(Buffer pointer, 
//            String event, Object event_info);
    
    /**
     * @param <T>
     * @brief Delete a callback function from an object.
     *
     * @details This function removes the most recently added callback from the
     *          object @p obj which was triggered by the type @p type and
     *          was calling the function @p func when triggered. If the removal is
     *          successful it will also return the data pointer that was passed to
     *          eext_object_event_callback_add() when the callback was added to
     *          the object. If not successful @c NULl will be returned.
     *
     * 
     * @param type The type of event that was triggering the callback.
     * @param func The function that was to be called when the event was
     *            triggered
     * @return    data The data pointer that was to be passed to the callback.
     *
     * @see eext_object_event_callback_add()
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     */
    public <T> T eext_object_event_callback_del(Eext_Callback_Type type, EextEventCallBack<T> func){
        return eext_object_event_callback_del(pointer, type.value(), func);
    }
    
    private native <T> T eext_object_event_callback_del(Buffer pointer, 
            int type, EextEventCallBack<T> func);

    /**
     * @brief Add (register) a callback function to a given evas object.
     *
     * @details This function adds a function callback to an object when the key
     *          event occurs on object @p obj. The key event on the object is only
     *          triggered when the object is the most top in objects stack and
     *          visible. This means, like the naviframe widget, if your application
     *          needs to have the events based on the view but not focus, you can
     *          use this callback. A callback function must have the Eext_Event_Cb
     *          prototype definition. The first parameter (@p data) in this
     *          definition will have the same value passed to
     *          eext_object_event_callback_add() as the @p data parameter, at
     *          runtime. The second parameter @p obj is the evas object on which
     *          event occurred. Finally, the third parameter @p event_info is a
     *          pointer to a data structure that may or may not be passed to the
     *          callback, depending on the event type that triggered the callback.
     *          This is so because some events don't carry extra context with them,
     *          but others do.
     *
     * @param type The type of event that will trigger the callback.
     * @param func The function to be called when the key event is triggered.
     * @param data The data pointer to be passed to @p func.
     *
     * @see eext_object_event_callback_del()
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     */
    public <T> void eext_object_event_callback_add(Eext_Callback_Type type, 
            EextEventCallBack<T> func, T data)
    {
        eext_object_event_callback_add(pointer, type.value(), func, data);
    }
    
    private native <T> void eext_object_event_callback_add(Buffer pointer,
            int type, EextEventCallBack<T> func, T data);

}
