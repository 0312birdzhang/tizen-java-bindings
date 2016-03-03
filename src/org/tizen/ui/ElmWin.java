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
public class ElmWin extends ElmWidget implements AddBackground {
    
    static {
        System.loadLibrary("ElmWin");
    }
    
    public static enum Elm_Win_Type {
        ELM_WIN_UNKNOWN(0),
        ELM_WIN_BASIC(1), /** A normal window. Indicates a normal, top-level
                         window. Almost every window will be created with this
                         type. */
        ELM_WIN_DIALOG_BASIC(2), /** Used for simple dialog windows/ */
        ELM_WIN_DESKTOP(3), /** For special desktop windows, like a background
                           window holding desktop icons. */
        ELM_WIN_DOCK(4), /** The window is used as a dock or panel. Usually would
                        be kept on top of any other window by the Window
                        Manager. */
        ELM_WIN_TOOLBAR(5), /** The window is used to hold a floating toolbar, or
                           similar. */
        ELM_WIN_MENU(6), /** Similar to #ELM_WIN_TOOLBAR. */
        ELM_WIN_UTILITY(7), /** A persistent utility window, like a toolbox or
                           palette. */
        ELM_WIN_SPLASH(8), /** Splash window for a starting up application. */
        ELM_WIN_DROPDOWN_MENU(9), /** The window is a dropdown menu, as when an
                                 entry in a menubar is clicked. Typically used
                                 with elm_win_override_set(). This hint exists
                                 for completion only, as the EFL way of
                                 implementing a menu would not normally use a
                                 separate window for its contents. */
        ELM_WIN_POPUP_MENU(10), /** Like #ELM_WIN_DROPDOWN_MENU, but for the menu
                              triggered by right-clicking an object. */
        ELM_WIN_TOOLTIP(11), /** The window is a tooltip. A short piece of
                           explanatory text that typically appear after the
                           mouse cursor hovers over an object for a while.
                           Typically used with elm_win_override_set() and also
                           not very commonly used in the EFL. */
        ELM_WIN_NOTIFICATION(12), /** A notification window, like a warning about
                                battery life or a new E-Mail received. */
        ELM_WIN_COMBO(13), /** A window holding the contents of a combo box. Not
                         usually used in the EFL. */
        ELM_WIN_DND(14), /** Used to indicate the window is a representation of an
                       object being dragged across different windows, or even
                       applications. Typically used with
                       elm_win_override_set(). */
        ELM_WIN_INLINED_IMAGE(15), /** The window is rendered onto an image
                                 buffer. No actual window is created for this
                                 type, instead the window and all of its
                                 contents will be rendered to an image buffer.
                                 This allows to have children window inside a
                                 parent one just like any other object would
                                 be, and do other things like applying @c
                                 Evas_Map effects to it. This is the only type
                                 of window that requires the @c parent
                                 parameter of elm_win_add() to be a valid @c
                                 Evas_Object. */
        ELM_WIN_SOCKET_IMAGE(16),/** The window is rendered onto an image buffer
                                 and can be shown other process's plug image object.
                                 No actual window is created for this type,
                                 instead the window and all of its contents will be
                                 rendered to an image buffer and can be shown
                                 other process's plug image object*/
        ELM_WIN_TIZEN_WIDGET(17), // Don't use this type. This is only for internal usage.
        ELM_WIN_FAKE(18); /** This window was created using a pre-existing canvas.
                         The window widget can be deleted, but the canvas
                         must be managed externally.
                         @since 1.13 */
        
        private final int value;
        
        private Elm_Win_Type(int value){
            this.value = value;
        }
        
        public final int value(){
            return value;
        }
        
        public static Elm_Win_Type get(int value){
            switch(value){
                case 1: return ELM_WIN_BASIC;
                case 2: return ELM_WIN_DIALOG_BASIC;
                case 3: return ELM_WIN_DESKTOP;
                case 4: return ELM_WIN_DOCK;
                case 5: return ELM_WIN_TOOLBAR;
                case 6: return ELM_WIN_MENU;
                case 7: return ELM_WIN_UTILITY;
                case 8: return ELM_WIN_SPLASH;
                case 9: return ELM_WIN_DROPDOWN_MENU;
                case 10: return ELM_WIN_POPUP_MENU;
                case 11: return ELM_WIN_TOOLTIP;
                case 12: return ELM_WIN_NOTIFICATION;
                case 13: return ELM_WIN_COMBO;
                case 14: return ELM_WIN_DND;
                case 15: return ELM_WIN_INLINED_IMAGE;
                case 16: return ELM_WIN_SOCKET_IMAGE;
                case 17: return ELM_WIN_TIZEN_WIDGET;
                case 18: return ELM_WIN_FAKE;
                default: return ELM_WIN_UNKNOWN;
            }
        }
    }
    
    public enum Elm_Win_Keyboard_Mode {
        ELM_WIN_KEYBOARD_UNKNOWN(0), /** Unknown keyboard state */
        ELM_WIN_KEYBOARD_OFF(1), /** Request to deactivate the keyboard */
        ELM_WIN_KEYBOARD_ON(2), /** Enable keyboard with default layout */
        ELM_WIN_KEYBOARD_ALPHA(3), /** Alpha (a-z) keyboard layout */
        ELM_WIN_KEYBOARD_NUMERIC(4), /** Numeric keyboard layout */
        ELM_WIN_KEYBOARD_PIN(5), /** PIN keyboard layout */
        ELM_WIN_KEYBOARD_PHONE_NUMBER(6), /** Phone keyboard layout */
        ELM_WIN_KEYBOARD_HEX(7), /** Hexadecimal numeric keyboard layout */
        ELM_WIN_KEYBOARD_TERMINAL(8), /** Full (QWERTY) keyboard layout */
        ELM_WIN_KEYBOARD_PASSWORD(9), /** Password keyboard layout */
        ELM_WIN_KEYBOARD_IP(10), /** IP keyboard layout */
        ELM_WIN_KEYBOARD_HOST(11), /** Host keyboard layout */
        ELM_WIN_KEYBOARD_FILE(12), /** File keyboard layout */
        ELM_WIN_KEYBOARD_URL(13), /** URL keyboard layout */
        ELM_WIN_KEYBOARD_KEYPAD(14), /** Keypad layout */
        ELM_WIN_KEYBOARD_J2ME(15); /** J2ME keyboard layout */
        
        private final int value;
        
        private Elm_Win_Keyboard_Mode(int value){
            this.value = value;
        }
        
        public static Elm_Win_Keyboard_Mode get(int value){
            switch(value){
                case 1: return ELM_WIN_KEYBOARD_OFF;
                case 2: return ELM_WIN_KEYBOARD_ON;
                case 3: return ELM_WIN_KEYBOARD_ALPHA;
                case 4: return ELM_WIN_KEYBOARD_NUMERIC;
                case 5: return ELM_WIN_KEYBOARD_PIN;
                case 6: return ELM_WIN_KEYBOARD_PHONE_NUMBER;
                case 7: return ELM_WIN_KEYBOARD_HEX;
                case 8: return ELM_WIN_KEYBOARD_TERMINAL;
                case 9: return ELM_WIN_KEYBOARD_PASSWORD;
                case 10: return ELM_WIN_KEYBOARD_IP;
                case 11: return ELM_WIN_KEYBOARD_HOST;
                case 12: return ELM_WIN_KEYBOARD_FILE;
                case 13: return ELM_WIN_KEYBOARD_URL;
                case 14: return ELM_WIN_KEYBOARD_KEYPAD;
                case 15: return ELM_WIN_KEYBOARD_J2ME;
                default: return ELM_WIN_KEYBOARD_UNKNOWN;
            }
        }
    }
    
    public enum Elm_Win_Indicator_Mode {
        ELM_WIN_INDICATOR_UNKNOWN(0), /** Unknown indicator state */
        ELM_WIN_INDICATOR_HIDE(1), /** Hides the indicator */
        ELM_WIN_INDICATOR_SHOW(2); /** Shows the indicator */
        
        private final int value;
        
        private Elm_Win_Indicator_Mode(int value){
            this.value = value;
        }
        
        public static Elm_Win_Indicator_Mode get(int value){
            switch(value){
                case 1: return ELM_WIN_INDICATOR_HIDE;
                case 2: return ELM_WIN_INDICATOR_SHOW;
                default: return ELM_WIN_INDICATOR_UNKNOWN;
            }
        }
    }
    
    public enum Elm_Win_Indicator_Opacity_Mode {
        ELM_WIN_INDICATOR_OPACITY_UNKNOWN(0), /** Unknown indicator opacity mode */
        ELM_WIN_INDICATOR_OPAQUE(1), /** Opacifies the indicator */
        ELM_WIN_INDICATOR_TRANSLUCENT(2), /** Be translucent the indicator */
        ELM_WIN_INDICATOR_TRANSPARENT(3), /** Transparentizes the indicator */
        // TIZEN_ONLY(20150113) : NOT FIXED
        ELM_WIN_INDICATOR_BG_TRANSPARENT(4); /** Transparentizes the indicator background*/
        //
        
        private final int value;
        
        private Elm_Win_Indicator_Opacity_Mode(int value){
            this.value = value;
        }
        
        public static Elm_Win_Indicator_Opacity_Mode get(int value){
            switch(value){
                case 1: return ELM_WIN_INDICATOR_OPAQUE;
                case 2: return ELM_WIN_INDICATOR_TRANSLUCENT;
                case 3: return ELM_WIN_INDICATOR_TRANSPARENT;
                case 4: return ELM_WIN_INDICATOR_BG_TRANSPARENT;
                default: return ELM_WIN_INDICATOR_OPACITY_UNKNOWN;
            }
        }
    }
    
    public enum Elm_Illume_Command {
        ELM_ILLUME_COMMAND_FOCUS_BACK(0), /** Reverts focus to the previous window */
        ELM_ILLUME_COMMAND_FOCUS_FORWARD(1), /** Sends focus to the next window in the list */
        ELM_ILLUME_COMMAND_FOCUS_HOME(2), /** Hides all windows to show the Home screen */
        ELM_ILLUME_COMMAND_CLOSE(3); /** Closes the currently active window */
        
        private final int value;
        
        private Elm_Illume_Command(int value){
            this.value = value;
        }
        
        public static Elm_Illume_Command get(int value){
            switch(value){
                case 1: return ELM_ILLUME_COMMAND_FOCUS_FORWARD;
                case 2: return ELM_ILLUME_COMMAND_FOCUS_HOME;
                case 3: return ELM_ILLUME_COMMAND_CLOSE;
                default: return ELM_ILLUME_COMMAND_FOCUS_BACK;
            }
        }
    }
    
    public enum Elm_Win_Keygrab_Mode {
        ELM_WIN_KEYGRAB_UNKNOWN(0), /** Unknown keygrab mode */
        ELM_WIN_KEYGRAB_SHARED(1 << 8), /** Getting the grabbed-key together with the other client windows */
        ELM_WIN_KEYGRAB_TOPMOST(1 << 9), /** Getting the grabbed-key only when window is top of the stack */
        ELM_WIN_KEYGRAB_EXCLUSIVE(1 << 10), /** Getting the grabbed-key exclusively regardless of window's position */
        ELM_WIN_KEYGRAB_OVERRIDE_EXCLUSIVE(1 << 11); /** Getting the grabbed-key exclusively regardless of window's position. Being overrided the grab by the other client window  */
        
        private final int value;
        
        private Elm_Win_Keygrab_Mode(int value){
            this.value = value;
        }
        
        public static Elm_Win_Keygrab_Mode get(int value){
            switch(value){
                case (1 << 8): return ELM_WIN_KEYGRAB_SHARED;
                case (1 << 9): return ELM_WIN_KEYGRAB_TOPMOST;
                case (1 << 10): return ELM_WIN_KEYGRAB_EXCLUSIVE;
                case (1 << 11): return ELM_WIN_KEYGRAB_OVERRIDE_EXCLUSIVE;
                default: return ELM_WIN_KEYGRAB_UNKNOWN;
            }
        }
    }
    
    
    
    /**
     * @brief Adds a window object with standard setup
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param name The name of the window
     * @param title The title for the window
     *
     * @remark This creates a window like elm_win_add() but also puts in a standard
     * background with elm_bg_add(), as well as setting the window title to
     * @p title. The window type created is of type ELM_WIN_BASIC, with @c NULL
     * as the parent widget.
     *
     * @return The created object, or @c NULL on failure
     *
     * @see elm_win_add()
     *
     * @ingroup Win
     */
    public static ElmWin elm_win_util_standard_add(String name, String title){
        Buffer elm_win = elm_win_util_standard_add_(name, title);
        if (elm_win == null) return null;
        return new ElmWin(elm_win, null);
    }
    
    private static native Buffer elm_win_util_standard_add_(String name, String title);
    
    /**
     * @brief Adds a window object. If this is the first window created, pass NULL as
     * @p parent.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param parent Parent object to add the window to, or NULL
     * @param name The name of the window
     * @param type The window type, one of #Elm_Win_Type.
     *
     * @remark The @p parent parameter can be @c NULL for every window @p type
     * except #ELM_WIN_INLINED_IMAGE, which needs a parent to retrieve the
     * canvas on which the image object will be created.
     *
     * @return The created object, or @c NULL on failure
     *
     * @ingroup Win
     */
    public static ElmWin elm_win_add(EvasObject parent, String name, Elm_Win_Type type){
        Buffer elm_win = elm_win_add(parent.pointer, name, type.value());
        if (elm_win == null) return null;
        return new ElmWin(elm_win, parent);
    }
    
    private static native Buffer elm_win_add(Buffer parent, String name, int type);
    
    
    private final EvasObject parent;
    
    private ElmWin(Buffer elm_win, EvasObject parent){
        super(elm_win);
        this.parent = parent;
    }
    
    @Override
    public ElmBg elm_bg_add(){
        return super.elm_bg_add();
    }
    
    /**
     *
     * @brief Set the window's autodel state.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark When closing the window in any way outside of the program control, like
     * pressing the X button in the titlebar or using a command from the
     * Window Manager, a "delete,request" signal is emitted to indicate that
     * this event occurred and the developer can take any action, which may
     * include, or not, destroying the window object.
     *
     * @remark When the @p autodel parameter is set, the window will be automatically
     * destroyed when this event occurs, after the signal is emitted.
     * If @p autodel is @c EINA_FALSE, then the window will not be destroyed
     * and is up to the program to do so when it's required.
     *
     * @ingroup Win
     *
     * @param autodel If true, the window will automatically delete itself when closed
     */
    public void elm_win_autodel_set(boolean autodel){
        elm_win_autodel_set(pointer, autodel);
    }
    
    private native void elm_win_autodel_set(Buffer pointer, boolean autodel);
    
    /**
     *
     * @brief Get the window's autodel state.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If the window will automatically delete itself when closed
     *
     * @see elm_win_autodel_set()
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_autodel_get(){
        return elm_win_autodel_get(pointer);
    }
    
    private native boolean elm_win_autodel_get(Buffer pointer);
    
    /**
     *
     * @brief Set the iconified state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param iconified If true, the window is iconified
     */
    public void elm_win_iconified_set(boolean iconified){
        elm_win_iconified_set(pointer, iconified);
    }
    
    private native void elm_win_iconified_set(Buffer pointer, boolean iconified);
    
    /**
     *
     * @brief Get the iconified state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is iconified
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_iconified_get(){
        return elm_win_iconified_get(pointer);
    }
    
    private native boolean elm_win_iconified_get(Buffer pointer);
    
    /**
     *
     * Set the array of available window rotations.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * This function is used to set the available rotations to give the hints to WM.
     * WM will refer this hints and set the orientation window properly.
     *
     * @see elm_win_wm_rotation_available_rotations_get()
     *
     * @ingroup Win
     * @since 1.9
     *
     * @param rotations The array of rotation value, note this array is not modified.
     */
    public void elm_win_wm_rotation_available_rotations_set(int[] rotations){
        elm_win_wm_rotation_available_rotations_set(pointer, rotations, rotations.length);
    }
    
    private native void elm_win_wm_rotation_available_rotations_set(Buffer pointer, int[] rotations, int count);
    
    /**
     *
     * Get the array of available window rotations.
     *
     * @return The array of rotations value.
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * This function is used to get the available rotations.
     *
     * @see elm_win_wm_rotation_available_rotations_set()
     *
     * @ingroup Win
     * @since 1.9
     *
     * @param count The size of the @param rotations array.
     */
    public int [] elm_win_wm_rotation_available_rotations_get(int count){
        return elm_win_wm_rotation_available_rotations_get(pointer, count);
    }
    
    /**
     * The underlying native implementation creates an array to call
     * the relevant function.
     */
    private native int [] elm_win_wm_rotation_available_rotations_get(Buffer pointer, int count);
    
    /**
     *
     * @brief Set the maximized state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param maximized If true, the window is maximized
     */
    public void elm_win_maximized_set(boolean maximized){
        elm_win_maximized_set(pointer, maximized);
    }
    
    private native void elm_win_maximized_set(Buffer pointer, boolean maximized);
    
    /**
     *
     * @brief Get the maximized state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is maximized
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_maximized_get(){
        return elm_win_maximized_get(pointer);
    }
    
    private native boolean elm_win_maximized_get(Buffer pointer);
    
    /**
     *
     * @brief Set the modal state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param modal If true, the window is modal
     */
    public void elm_win_modal_set(boolean modal){
        elm_win_modal_set(pointer, modal);
    }
    
    private native void elm_win_modal_set(Buffer pointer, boolean modal);
    
    /**
     *
     * @brief Get the modal state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is modal
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_modal_get(){
        return elm_win_modal_get(pointer);
    }
    
    private native boolean elm_win_modal_get(Buffer pointer);
    
    /**
     *
     * @brief Set the icon name of the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param icon_name The icon name to set
     */
    public void elm_win_icon_name_set(String icon_name){
        elm_win_icon_name_set(pointer, icon_name);
    }
    
    private native void elm_win_icon_name_set(Buffer pointer, String icon_name);
    
    /**
     *
     * @brief Get the icon name of the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark The returned string is an internal one and should not be freed or
     * modified. It will also be invalid if a new icon name is set or if
     * the window is destroyed.
     *
     * @return The icon name
     *
     * @ingroup Win
     *
     */
    public String elm_win_icon_name_get(){
        return elm_win_icon_name_get(pointer);
    }
    
    private native String elm_win_icon_name_get(Buffer pointer);
    
    /**
     *
     * @brief Set the withdrawn state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param withdrawn If true, the window is withdrawn
     */
    public void elm_win_withdrawn_set(boolean withdrawn){
        elm_win_withdrawn_set(pointer, withdrawn);
    }
    
    private native void elm_win_withdrawn_set(Buffer pointer, boolean withdrawn);
    
    /**
     *
     * @brief Get the withdrawn state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is withdrawn
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_withdrawn_get(){
        return elm_win_withdrawn_get(pointer);
    }
    
    private native boolean elm_win_withdrawn_get(Buffer pointer);
    
    /**
     *
     * @brief Set the role of the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param role The role to set
     */
    public void elm_win_role_set(String role){
        elm_win_role_set(pointer, role);
    }
    
    private native void elm_win_role_set(Buffer pointer, String role);
    
    /**
     *
     * @brief Get the role of the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark The returned string is an internal one and should not be freed or
     * modified. It will also be invalid if a new role is set or if
     * the window is destroyed.
     *
     * @return The role
     *
     * @ingroup Win
     *
     */
    public String elm_win_role_get(){
        return elm_win_role_get(pointer);
    }
    
    private native String elm_win_role_get(Buffer pointer);
    
    /**
     *
     * @brief Set the window stepping used with sizing calculation
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Base size + stepping is what is calculated for window sizing restrictions.
     *
     * @ingroup Win
     * @see elm_win_size_step_get
     * @see elm_win_size_base_set
     * @since 1.7
     *
     * @param w The stepping width (0 disables)
     * @param h The stepping height (0 disables)
     */
    public void elm_win_size_step_set(int w, int h){
        elm_win_size_step_set(pointer, w, h);
    }
    
    private native void elm_win_size_step_set(Buffer pointer, int w, int h);
    
    /**
     *
     * @brief Get the stepping of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     * @see elm_win_size_base_set
     * @see elm_win_size_step_set
     * @since 1.7
     *
     * @return a two element array containing the stepping width (0 disables) as the first
     * element and the stepping height (0 disables) as the second.
     */
    public int[] elm_win_size_step_get(){
        return elm_win_size_step_get(pointer);
    }
    
    private native int[] elm_win_size_step_get(Buffer pointer);
    
    /**
     *
     * @brief Set the style for the focus highlight on this window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Sets the style to use for theming the highlight of focused objects on
     * the given window. If @p style is NULL, the default will be used.
     *
     * @ingroup Win
     *
     * @param style The style to set
     */
    public void elm_win_focus_highlight_style_set(String style){
        elm_win_focus_highlight_style_set(pointer, style);
    }
    
    private native void elm_win_focus_highlight_style_set(Buffer pointer, String style);
    
    /**
     *
     * @brief Get the style set for the focus highlight object
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Get the style set for this windows highlight object, or NULL if none
     * is set.
     *
     * @return The style set or NULL if none was. Default is used in that case.
     *
     * @ingroup Win
     *
     */
    public String elm_win_focus_highlight_style_get(){
        return elm_win_focus_highlight_style_get(pointer);
    }
    
    private native String elm_win_focus_highlight_style_get(Buffer pointer);
    
    /**
     *
     * @brief Set the borderless state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark This function requests the Window Manager to not draw any decoration
     * around the window.
     *
     * @ingroup Win
     *
     * @param borderless If true, the window is borderless
     */
    public void elm_win_borderless_set(boolean borderless){
        elm_win_borderless_set(pointer, borderless);
    }
    
    private native void elm_win_borderless_set(Buffer pointer, boolean borderless);
    
    /**
     *
     * @brief Get the borderless state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is borderless
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_borderless_get(){
        return elm_win_borderless_get(pointer);
    }
    
    private native boolean elm_win_borderless_get(Buffer pointer);
    
    /**
     *
     * @brief Constrain the maximum width and height of a window to the width and height of its screen
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark When @p constrain is true, @p obj will never resize larger than the screen.
     * @ingroup Win
     *
     * @param constrain EINA_TRUE to restrict the window's maximum size, EINA_FALSE to disable restriction
     */
    public void elm_win_screen_constrain_set(boolean constrain){
        elm_win_screen_constrain_set(pointer, constrain);
    }
    
    private native void elm_win_screen_constrain_set(Buffer pointer, boolean constrain);
    
    /**
     *
     * @brief Get the constraints on the maximum width and height of a window relative to the width and height of its screen
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark When this function returns true, @p obj will never resize larger than the screen.
     * @return EINA_TRUE to restrict the window's maximum size, EINA_FALSE to disable restriction
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_screen_constrain_get(){
        return elm_win_screen_constrain_get(pointer);
    }
    
    private native boolean elm_win_screen_constrain_get(Buffer pointer);
    
    /**
     *
     * @brief Set the enabled status for the focus highlight in a window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark This function will enable or disable the focus highlight only for the
     * given window, regardless of the global setting for it
     *
     * @ingroup Win
     *
     * @param enabled The enabled value for the highlight
     */
    public void elm_win_focus_highlight_enabled_set(boolean enabled){
        elm_win_focus_highlight_enabled_set(pointer, enabled);
    }
    
    private native void elm_win_focus_highlight_enabled_set(Buffer pointer, boolean enabled);

    /**
     *
     * @brief Get the enabled value of the focus highlight for this window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return EINA_TRUE if enabled, EINA_FALSE otherwise
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_focus_highlight_enabled_get(){
        return elm_win_focus_highlight_enabled_get(pointer);
    }
    
    private native boolean elm_win_focus_highlight_enabled_get(Buffer pointer);
    
    /**
     *
     * @brief Set the title of the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param title The title to set
     */
    public void elm_win_title_set(String title){
        elm_win_title_set(pointer, title);
    }
    
    private native void elm_win_title_set(Buffer pointer, String title);
    
    /**
     *
     * @brief Get the title of the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark The returned string is an internal one and should not be freed or
     * modified. It will also be invalid if a new title is set or if
     * the window is destroyed.
     *
     * @return The title
     *
     * @ingroup Win
     *
     */
    public String elm_win_title_get(){
        return elm_win_title_get(pointer);
    }
    
    private native String elm_win_title_get(Buffer pointer);
    
    /**
     *
     * @brief Set the alpha channel state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark If @p alpha is EINA_TRUE, the alpha channel of the canvas will be enabled
     * possibly making parts of the window completely or partially transparent.
     * This is also subject to the underlying system supporting it, like for
     * example, running under a compositing manager. If no compositing is
     * available, enabling this option will instead fallback to using shaped
     * windows, with elm_win_shaped_set().
     *
     * @note Alpha window can be enabled automatically by window theme style's property.
     * If "alpha" data.item is "1" or "true" in window style(eg. elm/win/base/default),
     * the window is switched to alpha automatically without the explicit api call.
     *
     * @see elm_win_alpha_set()
     *
     * @ingroup Win
     *
     * @param alpha EINA_TRUE if the window alpha channel is enabled, EINA_FALSE otherwise
     */
    public void elm_win_alpha_set(boolean alpha){
        elm_win_alpha_set(pointer, alpha);
    }
    
    private native void elm_win_alpha_set(Buffer pointer, boolean alpha);
    
    /**
     *
     * @brief Get the alpha channel state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return EINA_TRUE if the window alpha channel is enabled, EINA_FALSE
     * otherwise
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_alpha_get(){
        return elm_win_alpha_get(pointer);
    }
    
    private native boolean elm_win_alpha_get(Buffer pointer);
    
    /**
     *
     * @brief Set the urgent state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @ingroup Win
     *
     * @param urgent If true, the window is urgent
     */
    public void elm_win_urgent_set(boolean urgent){
        elm_win_urgent_set(pointer, urgent);
    }
    
    private native void elm_win_urgent_set(Buffer pointer, boolean urgent);
    
    /**
     *
     * @brief Get the urgent state of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is urgent
     *
     * @ingroup Win
     *
     */
    public boolean elm_win_urgent_get(){
        return elm_win_urgent_get(pointer);
    }
    
    private native boolean elm_win_urgent_get(Buffer pointer);
    /**
     *
     * @brief Set the rotation of the window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Most engines only work with multiples of 90.
     *
     * @remark This function is used to set the orientation of the window @p obj to
     * match that of the screen. The window itself will be resized to adjust
     * to the new geometry of its contents. If you want to keep the window size,
     * see elm_win_rotation_with_resize_set().
     *
     * @ingroup Win
     *
     * @param rotation The rotation of the window, in degrees (0-360),
     * counter-clockwise.
     */
    public void elm_win_rotation_set(int rotation){
        if (rotation < 0 || rotation > 360) return;
        elm_win_rotation_set(pointer, rotation);
    }
    
    private native void elm_win_rotation_set(Buffer pointer, int rotation);
    
    /**
     *
     * @brief Get the rotation of the window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The rotation of the window in degrees (0-360)
     *
     * @see elm_win_rotation_set()
     * @see elm_win_rotation_with_resize_set()
     *
     * @ingroup Win
     *
     */
    public int elm_win_rotation_get(){
        return elm_win_rotation_get(pointer);
    }
    
    private native int elm_win_rotation_get(Buffer pointer);
    
    /**
     *
     * @brief Set a window object's icon
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark This sets an image to be used as the icon for the given window, in
     * the window manager decoration part. The exact pixel dimensions of
     * the object (not object size) will be used, and the image pixels
     * will be used as-is when this function is called. If the image
     * object has been updated, then call this function again to source
     * the image pixels and put them on the window's icon. Note that
     * <b>only Evas image objects are allowed</b>, for
     *
     * @remark Example of usage:
     * @code
     * icon = evas_object_image_add(evas_object_evas_get(elm_window));
     * evas_object_image_file_set(icon, "/path/to/the/icon", NULL);
     * elm_win_icon_object_set(elm_window, icon);
     * evas_object_show(icon);
     * @endcode
     *
     * @ingroup Win
     *
     * @param icon The Evas image object to use for an icon
     */
    public void elm_win_icon_object_set(EvasObject icon){
        
    }
    
    /**
     * @brief Set the floating mode of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param floating If true, the window is floating mode
     *
     * @remark The floating mode can be used on mobile environment. For example, if the
     * video-player window sets the floating mode, then e (enlightenment window
     * manager) changes its geometry and handles it like a popup. This is similar to
     * a multi window concept in a mobile phone. The way of handling floating mode
     * window is decided by enlightenment window manager.
     *
     * @ingroup Win
     * @see elm_win_floating_mode_get()
     * @since 1.8
     */
    public void elm_win_floating_mode_set(boolean floating){
        elm_win_floating_mode_set(pointer, floating);
    }
    
    private native void elm_win_floating_mode_set(Buffer pointer, boolean floating);
    
    
    /**
     * @brief Get the floating mode of a window.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return If true, the window is floating mode
     *
     * @ingroup Win
     * @see elm_win_floating_mode_set()
     * @since 1.8
     */
    public boolean elm_win_floating_mode_get(){
        return elm_win_floating_mode_get(pointer);
    }
    
    private native boolean elm_win_floating_mode_get(Buffer pointer);
    
    /**
     * @brief This pushes (increments) the norender counter on the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     *
     * @remark There are some occasions where you wish to suspend rendering on a window.
     * You may be "sleeping" and have nothing to update and do not want animations
     * or other theme side-effects causing rendering to the window while "asleep".
     * You can push (and pop) the norender mode to have this work.
     *
     * @remark If combined with evas_render_dump(), evas_image_cache_flush() and
     * evas_font_cache_flush() (and maybe edje_file_cache_flush() and
     * edje_collection_cache_flush()), you can minimize memory footprint
     * significantly while "asleep", and the pausing of rendering ensures
     * evas does not re-load data into memory until needed. When rendering is
     * resumed, data will be re-loaded as needed, which may result in some
     * lag, but does save memory.
     *
     * @see elm_win_norender_pop()
     * @see elm_win_norender_get()
     * @see elm_win_render()
     * @ingroup Win
     * @since 1.7
     */
    public void elm_win_norender_push(){
        elm_win_norender_push(pointer);
    }
    
    private native void elm_win_norender_push(Buffer pointer);
    
    /**
     * @brief This pops (decrements) the norender counter on the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Once norender has gone back to 0, then automatic rendering will continue
     * in the given window. If it is already at 0, this will have no effect.
     *
     * @see elm_win_norender_push()
     * @see elm_win_norender_get()
     * @see elm_win_render()
     * @ingroup Win
     * @since 1.7
     */
    public void elm_win_norender_pop(){
        elm_win_norender_pop(pointer);
    }
    
    private native void elm_win_norender_pop(Buffer pointer);
    
    /**
     * @brief The retruns how many times norender has been pushed on the window
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The number of times norender has been pushed
     *
     * @see elm_win_norender_push()
     * @see elm_win_norender_pop()
     * @see elm_win_render()
     * @ingroup Win
     * @since 1.7
     */
    public int elm_win_norender_get(){
        return elm_win_norender_get(pointer);
    }
    
    private native int elm_win_norender_get(Buffer pointer);
    
    /**
     * @brief This manually asks evas to render the window now
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     *
     * @remark You should NEVER call this unless you really know what you are doing and
     * why. Never call this unless you are asking for performance degredation
     * and possibly weird behavior. Windows get automatically rendered when the
     * application goes into the idle enter state so there is never a need to call
     * this UNLESS you have enabled "norender" mode.
     *
     * @see elm_win_norender_push()
     * @see elm_win_norender_pop()
     * @see elm_win_norender_get()
     * @ingroup Win
     * @since 1.7
     */
    public void elm_win_render(){
        elm_win_render(pointer);
    }
    
    private native void elm_win_render(Buffer pointer);
    
    /**
     * @brief Set the preferred rotation value.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark This function is used to set the orientation of window @p obj to spicific angle fixed.
     *
     * @param rotation The preferred rotation of the window in degrees (0-360),
     * counter-clockwise.
     *
     * @see elm_win_wm_rotation_preferred_rotation_get()
     *
     * @ingroup Win
     * @since 1.9
     */
    public void elm_win_wm_rotation_preferred_rotation_set(int rotation){
        if (rotation >= 0 && rotation <= 360){
            elm_win_wm_rotation_preferred_rotation_set(pointer, rotation);
        }
    }
    
    private native void elm_win_wm_rotation_preferred_rotation_set(Buffer pointer, int rotation);
}
