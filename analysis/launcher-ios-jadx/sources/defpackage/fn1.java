package defpackage;

import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class fn1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ TextInputLayout h;

    public /* synthetic */ fn1(TextInputLayout textInputLayout, int i) {
        this.g = i;
        this.h = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                TextInputLayout textInputLayout = this.h;
                textInputLayout.k0.performClick();
                textInputLayout.k0.jumpDrawablesToCurrentState();
                break;
            default:
                this.h.k.requestLayout();
                break;
        }
    }
}
