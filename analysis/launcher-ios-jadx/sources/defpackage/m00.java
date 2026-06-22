package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class m00 extends DialogFragment {
    public AlertDialog g;
    public DialogInterface.OnCancelListener h;
    public AlertDialog i;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.h;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.g;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.i == null) {
            Activity activity = getActivity();
            hg0.i(activity);
            this.i = new AlertDialog.Builder(activity).create();
        }
        return this.i;
    }
}
