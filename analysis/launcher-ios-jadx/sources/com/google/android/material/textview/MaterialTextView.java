package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.f71;
import defpackage.q41;
import defpackage.tr0;
import defpackage.z71;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        super(tr0.a(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = getContext();
        TypedValue typedValueN = z71.n(context2, q41.textAppearanceLineHeightEnabled);
        if (typedValueN != null && typedValueN.type == 18 && typedValueN.data == 0) {
            return;
        }
        Resources.Theme theme = context2.getTheme();
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, f71.MaterialTextView, R.attr.textViewStyle, 0);
        int iB = b(context2, typedArrayObtainStyledAttributes, f71.MaterialTextView_android_lineHeight, f71.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iB != -1) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, f71.MaterialTextView, R.attr.textViewStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(f71.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId != -1) {
            TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, f71.MaterialTextAppearance);
            int iB2 = b(getContext(), typedArrayObtainStyledAttributes3, f71.MaterialTextAppearance_android_lineHeight, f71.MaterialTextAppearance_lineHeight);
            typedArrayObtainStyledAttributes3.recycle();
            if (iB2 >= 0) {
                setLineHeight(iB2);
            }
        }
    }

    public static int b(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i = 0; i < iArr.length && dimensionPixelSize < 0; i++) {
            int i2 = iArr[i];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i2, typedValue) && typedValue.type == 2) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                dimensionPixelSize = dimensionPixelSize2;
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            }
        }
        return dimensionPixelSize;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedValue typedValueN = z71.n(context, q41.textAppearanceLineHeightEnabled);
        if (typedValueN != null && typedValueN.type == 18 && typedValueN.data == 0) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, f71.MaterialTextAppearance);
        int iB = b(getContext(), typedArrayObtainStyledAttributes, f71.MaterialTextAppearance_android_lineHeight, f71.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iB >= 0) {
            setLineHeight(iB);
        }
    }
}
