package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
final class zzbrm implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrn zza;

    public zzbrm(zzbrn zzbrnVar) {
        this.zza = zzbrnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
