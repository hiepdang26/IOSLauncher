package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import defpackage.e20;
import defpackage.ow1;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedEditText extends AppCompatEditText {
    public e20 g;

    public ExtendedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf"));
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return super.onKeyPreIme(i, keyEvent);
        }
        e20 e20Var = this.g;
        if (e20Var == null) {
            return false;
        }
        ((Folder) ((ow1) e20Var).h).C();
        return false;
    }

    public void setOnBackKeyListener(e20 e20Var) {
        this.g = e20Var;
    }
}
