package defpackage;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.EditTextPreference;

/* JADX INFO: loaded from: classes.dex */
public class oy extends x21 {
    public EditText v0;
    public CharSequence w0;
    public final o1 x0 = new o1(this, 19);
    public long y0 = -1;

    @Override // defpackage.x21, defpackage.ev, defpackage.w50
    public final void G(Bundle bundle) {
        super.G(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.w0);
    }

    @Override // defpackage.x21
    public final void W(View view) {
        super.W(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.v0 = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.v0.setText(this.w0);
        EditText editText2 = this.v0;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) V()).getClass();
    }

    @Override // defpackage.x21
    public final void X(boolean z) {
        if (z) {
            String string = this.v0.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) V();
            editTextPreference.getClass();
            editTextPreference.w(string);
        }
    }

    public final void Z() {
        long j = this.y0;
        if (j == -1 || j + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return;
        }
        EditText editText = this.v0;
        if (editText == null || !editText.isFocused()) {
            this.y0 = -1L;
            return;
        }
        if (((InputMethodManager) this.v0.getContext().getSystemService("input_method")).showSoftInput(this.v0, 0)) {
            this.y0 = -1L;
            return;
        }
        EditText editText2 = this.v0;
        o1 o1Var = this.x0;
        editText2.removeCallbacks(o1Var);
        this.v0.postDelayed(o1Var, 50L);
    }

    @Override // defpackage.x21, defpackage.ev, defpackage.w50
    public final void y(Bundle bundle) {
        super.y(bundle);
        if (bundle == null) {
            this.w0 = ((EditTextPreference) V()).Y;
        } else {
            this.w0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }
}
