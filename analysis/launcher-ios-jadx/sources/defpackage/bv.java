package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final class bv implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ bv(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.g) {
            case 0:
                ev evVar = (ev) this.h;
                Dialog dialog = evVar.i0;
                if (dialog != null) {
                    evVar.onCancel(dialog);
                }
                break;
            default:
                ((o32) this.h).b();
                break;
        }
    }
}
