package com.luutinhit.launcherios.customsettings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.g71;
import defpackage.l51;
import defpackage.m61;
import defpackage.o61;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class SettingsItem extends ConstraintLayout {
    public SettingsItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(m61.settings_item, (ViewGroup) this, true);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.SettingsItem);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(g71.SettingsItem_settingIcon, o61.ic_launcher);
            if (resourceId > 0) {
                ((AppCompatImageView) findViewById(v51.settings_icon)).setImageResource(resourceId);
            }
            String string = typedArrayObtainStyledAttributes.getString(g71.SettingsItem_settingText);
            if (string != null) {
                ((TextViewCustomFont) findViewById(v51.settings_text)).setText(string);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(g71.SettingsItem_hideDivider, false)) {
                findViewById(v51.divider_line).setVisibility(8);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        setClickable(true);
        setFocusable(true);
        setBackgroundResource(l51.item_press_state);
    }
}
