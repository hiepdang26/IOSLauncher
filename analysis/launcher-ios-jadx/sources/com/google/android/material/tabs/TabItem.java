package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import defpackage.f71;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {
    public final CharSequence g;
    public final Drawable h;
    public final int i;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f71.TabItem);
        this.g = tintTypedArrayObtainStyledAttributes.getText(f71.TabItem_android_text);
        this.h = tintTypedArrayObtainStyledAttributes.getDrawable(f71.TabItem_android_icon);
        this.i = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TabItem_android_layout, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }
}
