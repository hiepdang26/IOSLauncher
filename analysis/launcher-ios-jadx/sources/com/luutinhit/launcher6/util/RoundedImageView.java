package com.luutinhit.launcher6.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.e51;
import defpackage.g71;
import defpackage.hi;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends AppCompatImageView {
    public final float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final hi l;

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 400.0f;
        this.k = 400.0f;
        this.l = new hi(2, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.RoundedImageView, 0, 0);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RoundedImageView_imageCornerSize, getResources().getDimensionPixelSize(e51.small_icon_round_corner));
        typedArrayObtainStyledAttributes.recycle();
        setClipToOutline(true);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.h = (f * 1.0f) / 2.0f;
        float f2 = i2;
        this.i = (1.0f * f2) / 2.0f;
        this.j = f;
        this.k = f2;
        if (getClipToOutline()) {
            setOutlineProvider(this.l);
        }
    }
}
