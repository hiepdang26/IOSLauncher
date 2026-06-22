package com.google.android.material.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import defpackage.f71;
import defpackage.jr0;
import defpackage.mn1;
import defpackage.np1;
import defpackage.pr0;
import defpackage.q41;
import defpackage.t6;
import defpackage.tr0;
import defpackage.xq0;

/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends t6 {
    @Override // defpackage.t6
    public final AppCompatAutoCompleteTextView a(Context context, AttributeSet attributeSet) {
        return new xq0(context, attributeSet);
    }

    @Override // defpackage.t6
    public final AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // defpackage.t6
    public final AppCompatCheckBox c(Context context, AttributeSet attributeSet) {
        int i = q41.checkboxStyle;
        int i2 = jr0.j;
        jr0 jr0Var = new jr0(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = jr0Var.getContext();
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.MaterialCheckBox, i, i2, new int[0]);
        if (typedArrayD.hasValue(f71.MaterialCheckBox_buttonTint)) {
            jr0Var.setButtonTintList(np1.l(context2, typedArrayD, f71.MaterialCheckBox_buttonTint));
        }
        jr0Var.h = typedArrayD.getBoolean(f71.MaterialCheckBox_useMaterialThemeColors, false);
        jr0Var.i = typedArrayD.getBoolean(f71.MaterialCheckBox_centerIfNoTextEnabled, true);
        typedArrayD.recycle();
        return jr0Var;
    }

    @Override // defpackage.t6
    public final AppCompatRadioButton d(Context context, AttributeSet attributeSet) {
        int i = q41.radioButtonStyle;
        int i2 = pr0.i;
        pr0 pr0Var = new pr0(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = pr0Var.getContext();
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.MaterialRadioButton, i, i2, new int[0]);
        if (typedArrayD.hasValue(f71.MaterialRadioButton_buttonTint)) {
            pr0Var.setButtonTintList(np1.l(context2, typedArrayD, f71.MaterialRadioButton_buttonTint));
        }
        pr0Var.h = typedArrayD.getBoolean(f71.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayD.recycle();
        return pr0Var;
    }

    @Override // defpackage.t6
    public final AppCompatTextView e(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
