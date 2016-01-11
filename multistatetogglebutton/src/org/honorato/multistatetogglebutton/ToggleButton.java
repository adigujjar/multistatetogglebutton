package org.honorato.multistatetogglebutton;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class ToggleButton extends LinearLayout {

    public interface OnValueChangedListener {
        // TODO: Add this callback:
        // public void onValueChanged(int value, boolean selected);
        public void onValueChanged(int value);
    }

    OnValueChangedListener listener;
    Context context;
    int colorPressed, colorNotPressed; // Resolved colors (format 0xAARRGGBB)

    public ToggleButton(Context context) {
        super(context, null);
        this.context = context;
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setOnValueChangedListener(OnValueChangedListener l) {
        this.listener = l;
    }

    public void setValue(int value) {
        if (this.listener != null) {
            listener.onValueChanged(value);
        }
    }


    /**
     * The desired color resource identifier generated by the aapt tool
     *
     * @param colorPressed    color resource ID for the pressed button(s)
     * @param colorNotPressed color resource ID for the released button(s)
     */
    public abstract void setColorRes(@ColorRes int colorPressed, @ColorRes int colorNotPressed);

    /**
     * Color values are in the form 0xAARRGGBB
     *
     * @param colorPressed    resolved color for the pressed button(s)
     * @param colorNotPressed resolved color for the released button(s)
     */
    public abstract void setColors(int colorPressed, int colorNotPressed);

}