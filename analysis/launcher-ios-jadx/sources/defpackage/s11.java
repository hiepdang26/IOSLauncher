package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class s11 extends c00 {
    public final qx e;
    public final ej f;
    public final fj g;

    public s11(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.e = new qx(this, 1);
        this.f = new ej(this, 2);
        this.g = new fj(this, 2);
    }

    public static boolean d(s11 s11Var) {
        EditText editText = s11Var.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // defpackage.c00
    public final void a() {
        int i = this.d;
        if (i == 0) {
            i = k51.design_password_eye;
        }
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(v61.password_toggle_content_description));
        textInputLayout.setEndIconVisible(true);
        textInputLayout.setEndIconCheckable(true);
        textInputLayout.setEndIconOnClickListener(new r11(this));
        LinkedHashSet linkedHashSet = textInputLayout.h0;
        ej ejVar = this.f;
        linkedHashSet.add(ejVar);
        if (textInputLayout.k != null) {
            ejVar.a(textInputLayout);
        }
        textInputLayout.l0.add(this.g);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
