package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import defpackage.yb2;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
final class zzedr extends TimerTask {
    final /* synthetic */ AlertDialog zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ yb2 zzc;

    public zzedr(zzeds zzedsVar, AlertDialog alertDialog, Timer timer, yb2 yb2Var) {
        this.zza = alertDialog;
        this.zzb = timer;
        this.zzc = yb2Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zza.dismiss();
        this.zzb.cancel();
        yb2 yb2Var = this.zzc;
        if (yb2Var != null) {
            yb2Var.zzb();
        }
    }
}
