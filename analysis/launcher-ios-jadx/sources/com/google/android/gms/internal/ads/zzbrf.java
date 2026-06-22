package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import defpackage.cd2;
import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
final class zzbrf implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrh zza;

    public zzbrf(zzbrh zzbrhVar) {
        this.zza = zzbrhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbrh zzbrhVar = this.zza;
        Intent intentZzb = zzbrhVar.zzb();
        cd2 cd2Var = hd2.B.c;
        cd2.p(zzbrhVar.zzb, intentZzb);
    }
}
