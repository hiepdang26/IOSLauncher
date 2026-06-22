package defpackage;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class nz extends xy {
    public final WeakReference a;

    public nz(EditText editText) {
        this.a = new WeakReference(editText);
    }

    @Override // defpackage.xy
    public final void onInitialized() {
        oz.a((EditText) this.a.get(), 1);
    }
}
