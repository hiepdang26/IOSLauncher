package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final class cv implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ev g;

    public cv(ev evVar) {
        this.g = evVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        ev evVar = this.g;
        Dialog dialog = evVar.i0;
        if (dialog != null) {
            evVar.onDismiss(dialog);
        }
    }
}
