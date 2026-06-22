package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public class qk1 extends ev {
    public AlertDialog n0;
    public DialogInterface.OnCancelListener o0;
    public AlertDialog p0;

    @Override // defpackage.ev
    public final Dialog U() {
        AlertDialog alertDialog = this.n0;
        if (alertDialog != null) {
            return alertDialog;
        }
        this.e0 = false;
        if (this.p0 == null) {
            Context contextP = p();
            hg0.i(contextP);
            this.p0 = new AlertDialog.Builder(contextP).create();
        }
        return this.p0;
    }

    @Override // defpackage.ev, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.o0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
