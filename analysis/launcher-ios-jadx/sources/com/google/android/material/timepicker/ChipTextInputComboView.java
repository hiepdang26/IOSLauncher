package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.ax;
import defpackage.l61;

/* JADX INFO: loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip g;
    public final EditText h;

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(l61.material_time_chip, (ViewGroup) this, false);
        this.g = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(l61.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.h = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a(this));
        if (Build.VERSION.SDK_INT >= 24) {
            editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.g.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 24) {
            this.h.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        Chip chip = this.g;
        chip.setChecked(z);
        int i = z ? 0 : 4;
        EditText editText = this.h;
        editText.setVisibility(i);
        chip.setVisibility(z ? 8 : 0);
        if (chip.isChecked()) {
            editText.requestFocus();
            editText.post(new ax(2, editText));
            if (TextUtils.isEmpty(editText.getText())) {
                return;
            }
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.g.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i, Object obj) {
        this.g.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.g.toggle();
    }
}
