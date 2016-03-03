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
public class ElmLayout extends ElmContainer{
    
    static {
        System.loadLibrary("ElmLayout");
    }
    
    private EvasObject child;
    
    ElmLayout(Buffer evas_object, EvasObject parent) {
        super(evas_object, parent);
    }
    
    /**
     * @brief Set the layout content.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param swallow The swallow part name in the edje file
     * @param content The child that will be added in this layout object
     * @return @c EINA_TRUE on success, @c EINA_FALSE otherwise
     *
     * @remark Once the content object is set, a previously set one will be deleted.
     * If you want to keep that old content object, use the
     * elm_layout_content_unset() function.
     *
     * @remark In an Edje theme, the part used as a content container is called
     * @c SWALLOW. This is why the parameter name is called @p swallow, but it is
     * expected to be a part name just like the second parameter of
     * elm_layout_box_append().
     *
     * @see elm_layout_box_append()
     * @see elm_layout_content_get()
     * @see elm_layout_content_unset()
     *
     * @see @ref secBox
     *
     * @ingroup Layout
     */
    public boolean elm_layout_content_set(String swallow, EvasObject content){
        child = content;
        return elm_layout_content_set(pointer, swallow, content.pointer);
    }
    
    private native boolean elm_layout_content_set(Buffer obj, String swallow, Buffer content);
    
    /**
     *
     * @brief Set accessibility to all texblock(text) parts in the layout object
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return @c EINA_TRUE on success or @c EINA_FALSE on failure. If @p obj is not
     * a proper layout object, @c EINA_FALSE is returned.
     *
     * @since 1.7
     *
     * @ingroup Layout
     *
     * @param can_access makes all textblock(text) parts in the layout @p obj possible
    to have accessibility. @c EINA_TRUE means textblock(text) parts can be accessible
     */
    public boolean elm_layout_edje_object_can_access_set(boolean can_access){
        return elm_layout_edje_object_can_access_set(pointer, can_access);
    }
    
    private native boolean elm_layout_edje_object_can_access_set(Buffer pointer, boolean can_access);
    
    /**
     *
     * @brief Get accessibility state of texblock(text) parts in the layout object
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return @c EINA_TRUE, if all textblock(text) parts in the layout can be accessible
     * @c EINA_FALSET if those cannot be accessible. If @p obj is not a proper layout
     * object, @c EINA_FALSE is returned.
     *
     * @see elm_layout_edje_object_access_set()
     *
     * @since 1.7
     *
     * @ingroup Layout
     *
     */
    public boolean elm_layout_edje_object_can_access_get(){
        return elm_layout_edje_object_can_access_get(pointer);
    }
    
    private native boolean elm_layout_edje_object_can_access_get(Buffer pointer);
    
    /**
     *
     * @brief Set the edje group from the elementary theme that will be used as layout
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return (1 = success, 0 = error)
     *
     * @remark Note that @a style will be the new style of @a obj too, as in an
     * elm_object_style_set() call.
     *
     * @ingroup Layout
     *
     * @param klass the class of the group
     * @param group the group
     * @param style the style to used
     */
    public boolean elm_layout_theme_set(String klass, String group, String style){
        return elm_layout_theme_set(pointer, klass, group, style);
    }
    
    private native boolean elm_layout_theme_set(Buffer pointer, 
                                                String klass,
                                                String group, 
                                                String style);
    
    /**
     *
     * @brief Get the edje layout
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return A Evas_Object with the edje layout settings loaded
     * with function elm_layout_file_set
     *
     * @remark This returns the edje object. It is not expected to be used to then
     * swallow objects via edje_object_part_swallow() for example. Use
     * elm_layout_content_set() instead so child object handling and sizing is
     * done properly.
     *
     * @remark This function should only be used if you really need to call some
     * low level Edje function on this edje object. All the common stuff (setting
     * text, emitting signals, hooking callbacks to signals, etc.) can be done
     * with proper elementary functions.
     *
     * @see elm_layout_signal_callback_add()
     * @see elm_layout_signal_emit()
     * @see elm_layout_text_set()
     * @see elm_layout_content_set()
     * @see elm_layout_box_append()
     * @see elm_layout_table_pack()
     * @see elm_layout_data_get()
     *
     * @ingroup Layout
     *
     */
//    public EvasObject elm_layout_edje_get();
    
    /**
     *
     * @brief Remove all children of the given part box.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return @c EINA_TRUE on success, @c EINA_FALSE otherwise
     *
     * @remark The objects will be removed from the box part and their lifetime will
     * not be handled by the layout anymore. This is equivalent to
     * elm_layout_box_remove() for all box children.
     *
     * @see elm_layout_box_append()
     * @see elm_layout_box_remove()
     *
     * @ingroup Layout
     * 
     *
     * @param part The box part name to remove child.
     * @param clear If true, then all objects will be deleted as
    well, otherwise they will just be removed and will be
    dangling on the canvas.
     */
    public boolean elm_layout_box_remove_all(String part, boolean clear){
        return elm_layout_box_remove_all(pointer, part, clear);
    }
    
    private native boolean elm_layout_box_remove_all(Buffer pointer, 
                                                    String part, 
                                                    boolean clear);
    
    /**
     *
     * @brief Sets if the cursor set should be searched on the theme or should use
     * the provided by the engine, only.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark before you set if should look on theme you should define a
     * cursor with elm_layout_part_cursor_set(). By default it will only
     * look for cursors provided by the engine.
     *
     * @return EINA_TRUE on success or EINA_FALSE on failure, that may be
     * part not exists or it did not had a cursor set.
     *
     * @ingroup Layout
     * 
     *
     * @param part_name a part from loaded edje group.
     * @param engine_only if cursors should be just provided by the engine (EINA_TRUE)
    or should also search on widget's theme as well (EINA_FALSE)
     */
    public boolean elm_layout_part_cursor_engine_only_set(String part_name,
                                                        boolean engine_only)
    {
        return elm_layout_part_cursor_engine_only_set(pointer, part_name, engine_only);
    }
    
    private native boolean 
        elm_layout_part_cursor_engine_only_set(Buffer pointer, 
                                                String part_name, 
                                                boolean engine_only);
        
    /**
     *
     * @brief Get a specific cursor engine_only for an edje part.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return whenever the cursor is just provided by engine or also from theme.
     *
     * @ingroup Layout
     * 
     *
     * @param part_name a part from loaded edje group.
     */
    public boolean elm_layout_part_cursor_engine_only_get(String part_name){
        return elm_layout_part_cursor_engine_only_get(pointer, part_name);
    }
    
    private native boolean 
        elm_layout_part_cursor_engine_only_get(Buffer pointer, String part_name);
        
    /**
     *
     * @brief Unpack (remove) a child of the given part table.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The object that was being used, or NULL if not found.
     *
     * @remark The object will be unpacked from the table part and its lifetime
     * will not be handled by the layout anymore. This is equivalent to
     * elm_layout_content_unset() for table.
     *
     * @see elm_layout_table_pack()
     * @see elm_layout_table_clear()
     *
     * @ingroup Layout
     * 
     *
     * @param part The table part name to remove child.
     * @param child The object to remove from table.
     */
    public EvasObject elm_layout_table_unpack(String part, EvasObject child){
        Buffer used = elm_layout_table_unpack(pointer, part, child.pointer);
        if (used == null) return null;
        if (used.equals(child.pointer)) return child;
        return new EvasObject(used) {};
    }
    
    private native Buffer elm_layout_table_unpack(Buffer pointer, String part, Buffer child);
     
    
    /**
     *
     * @throws java.lang.Exception if an error occurs.
     * @brief Freezes the Elementary layout object.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Layout
     *
     * @return The frozen state
     *
     * @remark This function puts all changes on hold. Successive freezes will
     * nest, requiring an equal number of thaws.
     *
     * @see elm_layout_thaw()
     * 
     *
     */
    public int elm_layout_freeze() throws Exception {
        int frozen_state = elm_layout_freeze(pointer);
        if (frozen_state == 0) throw new Exception("Error occurred");
        return frozen_state;
    }
    
    private native int elm_layout_freeze(Buffer pointer);
    
    /**
     *
     * @brief Eval sizing
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Manually forces a sizing re-evaluation. This is useful when the minimum
     * size required by the edje theme of this layout has changed. The change on
     * the minimum size required by the edje theme is not immediately reported to
     * the elementary layout, so one needs to call this function in order to tell
     * the widget (layout) that it needs to reevaluate its own size.
     *
     * @remark The minimum size of the theme is calculated based on minimum size of
     * parts, the size of elements inside containers like box and table, etc. All
     * of this can change due to state changes, and that's when this function
     * should be called.
     *
     * @remark Also note that a standard signal of "size,eval" "elm" emitted from the
     * edje object will cause this to happen too.
     *
     * @ingroup Layout
     * 
     *
     */
    public void elm_layout_sizing_eval(){
        elm_layout_sizing_eval(pointer);
    }
    
    private native void elm_layout_sizing_eval(Buffer pointer);
    
    /**
     *
     * @brief Remove a child of the given part box.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The object that was being used, or NULL if not found.
     *
     * @remark The object will be removed from the box part and its lifetime will
     * not be handled by the layout anymore. This is equivalent to
     * elm_layout_content_unset() for box.
     *
     * @see elm_layout_box_append()
     * @see elm_layout_box_remove_all()
     *
     * @ingroup Layout
     * 
     *
     * @param part The box part name to remove child.
     * @param child The object to remove from box.
     */
    public EvasObject elm_layout_box_remove(String part, EvasObject child){
        Buffer obj = elm_layout_box_remove(pointer, part, child.pointer);
        if (obj == null) return null;
        if (obj.equals(child.pointer)) return child;
        return new EvasObject(obj){};
    }
    
    private native Buffer elm_layout_box_remove(Buffer pointer, 
                                                String part, 
                                                Buffer child);
    
    /**
     *
     * @brief Sets a specific cursor style for an edje part.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return EINA_TRUE on success or EINA_FALSE on failure, that may be
     * part not exists or it did not had a cursor set.
     *
     * @ingroup Layout
     * 
     *
     * @param part_name a part from loaded edje group.
     * @param style the theme style to use (default, transparent, ...)
     */
    public boolean elm_layout_part_cursor_style_set(String part_name,
                                                    String style)
    {
        return elm_layout_part_cursor_style_set(pointer, part_name, style);
    }
    
    private native boolean elm_layout_part_cursor_style_set(Buffer pointer, 
                                                            String part_name,
                                                            String style);
    
    /**
     *
     * @brief Get a specific cursor style for an edje part.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return the theme style in use, defaults to "default". If the
     * object does not have a cursor set, then NULL is returned.
     *
     * @ingroup Layout
     * 
     *
     * @param part_name a part from loaded edje group.
     */
    public String elm_layout_part_cursor_style_get(String part_name){
        return elm_layout_part_cursor_style_get(pointer, part_name);
    }
    
    private native String elm_layout_part_cursor_style_get(Buffer pointer,
                                                            String part_name);
    
    /**
     *
     * @brief Set the text of the given part
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return @c EINA_TRUE on success, @c EINA_FALSE otherwise
     *
     * @ingroup Layout
     * 
     *
     * @param part The TEXT part where to set the text
     * @param text The text to set
     */
    public boolean elm_layout_text_set(String part, String text){
        return elm_layout_text_set(pointer, part, text);
    }
    
    private native boolean elm_layout_text_set(Buffer pointer, 
                                                String part, 
                                                String text);
    
    /**
     *
     * @brief Get the text set in the given part
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The text set in @p part
     *
     * @ingroup Layout
     * 
     *
     * @param part The TEXT part to retrieve the text off
     */
    public String elm_layout_text_get(String part){
        return elm_layout_text_get(pointer, part);
    }
    
    private native String elm_layout_text_get(Buffer pointer, String part);
    
    
}
