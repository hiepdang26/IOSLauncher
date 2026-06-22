package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class r11 implements View.OnClickListener {
    public final /* synthetic */ s11 g;

    public r11(s11 s11Var) {
        this.g = s11Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s11 s11Var = this.g;
        EditText editText = s11Var.a.getEditText();
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (s11.d(s11Var)) {
            editText.setTransformationMethod(null);
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            editText.setSelection(selectionEnd);
        }
        TextInputLayout textInputLayout = s11Var.a;
        z71.l(textInputLayout, textInputLayout.k0, textInputLayout.m0);
    }
}
