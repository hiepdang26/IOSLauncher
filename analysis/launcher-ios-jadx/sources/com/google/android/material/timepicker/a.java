package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import defpackage.ln1;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ln1 {
    public final /* synthetic */ ChipTextInputComboView g;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.g = chipTextInputComboView;
    }

    @Override // defpackage.ln1, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean zIsEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.g;
        Chip chip = chipTextInputComboView.g;
        if (zIsEmpty) {
            chip.setText(String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt("00"))));
        } else {
            chip.setText(String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(editable)))));
        }
    }
}
