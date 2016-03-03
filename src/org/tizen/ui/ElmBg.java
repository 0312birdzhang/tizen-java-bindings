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
public class ElmBg extends ElmLayout {

    static {
        System.loadLibrary("ElmBg");
    }

    public enum Elm_Bg_Option {
        ELM_BG_OPTION_CENTRE(0),
        ELM_BG_OPTION_SCALE(1),
        ELM_BG_OPTION_STRETCH(2),
        ELM_BG_OPTION_TILE(3),
        ELM_BG_OPTION_LAST(4);

        private final int value;

        private Elm_Bg_Option(int value) {
            this.value = value;
        }

        public final int value() {
            return value;
        }

        public static Elm_Bg_Option get(int value) {
            switch (value) {
                case 0:
                    return ELM_BG_OPTION_CENTRE;
                case 1:
                    return ELM_BG_OPTION_SCALE;
                case 2:
                    return ELM_BG_OPTION_STRETCH;
                case 3:
                    return ELM_BG_OPTION_TILE;
                default:
                    return ELM_BG_OPTION_LAST;
            }
        }
    }

    ElmBg(Buffer evas_object, EvasObject parent) {
        super(evas_object, parent);
    }

    /**
     *
     * @brief Set the mode of display for a given background widget's image
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark This sets how the background widget will display its image. This
     * will only work if the elm_bg_file_set() was previously called with an
     * image file on @a obj. The image can be display tiled, scaled, centered or
     * stretched. #ELM_BG_OPTION_SCALE by default.
     *
     * @see #option_get()
     *
     * @ingroup Bg
     *
     * @param option The desired background option
     * @see Elm_Bg_Option
     */
    public void option_set(Elm_Bg_Option option) {
        option_set(pointer, option.value());
    }

    private native void option_set(Buffer pointer, int option);

    /**
     *
     * @brief Get the mode of display for a given background widget's image
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return The image displaying mode in use for @a obj or
     * #ELM_BG_OPTION_LAST, on errors.
     *
     * @see elm_bg_option_set() for more details
     *
     * @ingroup Bg
     *
     */
    public Elm_Bg_Option option_get() {
        return Elm_Bg_Option.get(option_get(pointer));
    }

    private native int option_get(Buffer pointer);

    /**
     *
     * @brief Set the size of the pixmap representation of the image set on a
     * given background widget.
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @warning This function just makes sense if an image file was set on
     * @p obj, with elm_bg_file_set().
     *
     * @remark This function sets a new size for pixmap representation of the
     * given bg image. It allows for the image to be loaded already in the
     * specified size, reducing the memory usage and load time (for example,
     * when loading a big image file with its load size set to a smaller size)
     *
     * @remark This is just a hint for the underlying system. The real size of
     * the pixmap may differ depending on the type of image being loaded, being
     * bigger than requested.
     *
     * @ingroup Bg
     *
     * @param w The new width of the image pixmap representation.
     * @param h The new height of the image pixmap representation.
     */
    public void load_size_set(int w, int h) {
        load_size_set(pointer, w, h);
    }

    private native void load_size_set(Buffer pointer, int w, int h);

    /**
     * @brief Set the color on a given background widget
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @param r The red color component's value
     * @param g The green color component's value
     * @param b The blue color component's value
     *
     * @remark This sets the color used for the background rectangle, in RGB
     * format. Each color component's range is from 0 to 255.
     *
     * @remark You probably only want to use this function if you haven't
     * previously called elm_bg_file_set(), so that you just want a solid color
     * background.
     *
     * @remark You can reset the color by setting @p r, @p g, @p b as -1, -1,
     * -1.
     *
     * @see #color_get()
     *
     * @ingroup Bg
     */
    public void color_set(int r, int g, int b) {
        color_set(pointer, r, g, b);
    }

    private native void color_set(Buffer pointer, int r, int g, int b);

    /**
     * @return int [] array containing three elements, red, green, blue, in that
     * order.
     * @brief Get the color set on a given background widget
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Use @c NULL pointers on the file components you're not interested
     * in: they'll be ignored by the function.
     *
     * @see #color_get() for more details
     *
     * @ingroup Bg
     */
    public int[] color_get() {
        return color_get(pointer);
    }

    private native int[] color_get(Buffer pointer);

    /**
     * @brief Set the file (image or edje collection) to give life for the
     * background
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @return @c EINA_TRUE on success, @c EINA_FALSE otherwise
     *
     * @remark This sets the image file used in the background object. If the
     * image comes from an Edje group, it will be stretched to completely fill
     * the background object. If it comes from a traditional image file, it will
     * by default be centered in this widget's area (thus retaining its aspect),
     * what could lead to some parts being not visible. You may change the mode
     * of exhibition for a real image file with elm_bg_option_set().
     *
     * @remark Once the image of @p obj is set, a previously set one will be
     * deleted, even if @p file is @c NULL.
     *
     * @remark This will only affect the contents of one of the background's
     * swallow spots, namely @c "elm.swallow.background". If you want to achieve
     * the @c Layout's file setting behavior, you'll have to call that method on
     * this object.
     *
     * @ingroup Bg
     *
     * @param file The file path
     * @param group Optional key (group in Edje) within the file
     */
    public boolean file_set(String file, String group) {
        return file_set(pointer, file, group);
    }

    private native boolean file_set(Buffer pointer, String file, String group);

    /**
     * @return a String [] array, containing the file path as the first element
     * and the Optional key (group in Edje) within the file.
     * @brief Get the file (image or edje collection) set on a given background
     * widget
     *
     * @if MOBILE @since_tizen 2.3
     * @elseif WEARABLE @since_tizen 2.3.1
     * @endif
     *
     * @remark Use @c NULL pointers on the file components you're not interested
     * in: they'll be ignored by the function.
     *
     * @ingroup Bg
     *
     */
    public String[] file_get() {
        return file_get(pointer);
    }

    private native String[] file_get(Buffer pointer);

}
