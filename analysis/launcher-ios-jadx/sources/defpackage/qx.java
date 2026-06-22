package defpackage;

import android.text.Editable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class qx extends ln1 {
    public final /* synthetic */ int g;
    public final /* synthetic */ c00 h;

    public /* synthetic */ qx(c00 c00Var, int i) {
        this.g = i;
        this.h = c00Var;
    }

    @Override // defpackage.ln1, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        switch (this.g) {
            case 0:
                ux uxVar = (ux) this.h;
                EditText editText = uxVar.a.getEditText();
                if (!(editText instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                if (uxVar.q.isTouchExplorationEnabled() && ux.h(autoCompleteTextView) && !uxVar.c.hasFocus()) {
                    autoCompleteTextView.dismissDropDown();
                }
                autoCompleteTextView.post(new w1(this, autoCompleteTextView, 12, false));
                return;
            default:
                return;
        }
    }

    @Override // defpackage.ln1, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        switch (this.g) {
            case 1:
                ((s11) this.h).c.setChecked(!s11.d(r1));
                break;
        }
    }
}
