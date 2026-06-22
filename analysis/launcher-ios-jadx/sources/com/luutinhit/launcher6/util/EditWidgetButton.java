package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.e51;
import defpackage.l51;
import defpackage.w61;

/* JADX INFO: loaded from: classes.dex */
public class EditWidgetButton extends AppCompatTextView {
    public EditWidgetButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextSemiBold.ttf"));
        setBackgroundResource(l51.circle_bg_light);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.edit_text_padding);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setGravity(17);
        setText(w61.edit);
        setTextColor(-16777216);
        setTextSize(2, 12.0f);
    }
}
