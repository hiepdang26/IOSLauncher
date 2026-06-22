package defpackage;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final class dv0 implements DialogInterface.OnMultiChoiceClickListener {
    public final /* synthetic */ ev0 a;

    public dv0(ev0 ev0Var) {
        this.a = ev0Var;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
        ev0 ev0Var = this.a;
        if (z) {
            ev0Var.w0 = ev0Var.v0.add(ev0Var.y0[i].toString()) | ev0Var.w0;
        } else {
            ev0Var.w0 = ev0Var.v0.remove(ev0Var.y0[i].toString()) | ev0Var.w0;
        }
    }
}
