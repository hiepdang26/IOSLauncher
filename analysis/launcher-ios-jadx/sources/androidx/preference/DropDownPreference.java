package androidx.preference;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import defpackage.e61;
import defpackage.g31;
import defpackage.mx;
import defpackage.o41;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter d0;
    public Spinner e0;
    public final mx f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, o41.dropdownPreferenceStyle, 0);
        this.f0 = new mx(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_dropdown_item);
        this.d0 = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.Y;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void g() {
        super.g();
        ArrayAdapter arrayAdapter = this.d0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void k(g31 g31Var) {
        int length;
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) g31Var.g.findViewById(e61.spinner);
        this.e0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.d0);
        this.e0.setOnItemSelectedListener(this.f0);
        Spinner spinner2 = this.e0;
        String str = this.a0;
        if (str == null || (charSequenceArr = this.Z) == null) {
            length = -1;
        } else {
            length = charSequenceArr.length - 1;
            while (length >= 0) {
                if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    break;
                } else {
                    length--;
                }
            }
            length = -1;
        }
        spinner2.setSelection(length);
        super.k(g31Var);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void l() {
        this.e0.performClick();
    }
}
