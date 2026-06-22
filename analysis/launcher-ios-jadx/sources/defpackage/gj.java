package defpackage;

import android.text.Editable;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class gj implements View.OnClickListener {
    public final /* synthetic */ jj g;

    public gj(jj jjVar) {
        this.g = jjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        jj jjVar = this.g;
        Editable text = jjVar.a.getEditText().getText();
        if (text != null) {
            text.clear();
        }
        TextInputLayout textInputLayout = jjVar.a;
        z71.l(textInputLayout, textInputLayout.k0, textInputLayout.m0);
    }
}
