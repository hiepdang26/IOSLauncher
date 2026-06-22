package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
final class zzbrg implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrh zza;

    public zzbrg(zzbrh zzbrhVar) {
        this.zza = zzbrhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("Operation denied by user.");
    }
}
