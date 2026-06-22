package com.google.android.gms.internal.ads;

import defpackage.bb;
import defpackage.vl;

/* JADX INFO: loaded from: classes.dex */
final class zzbkt implements bb {
    final /* synthetic */ zzbzt zza;

    public zzbkt(zzbku zzbkuVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
    }

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        this.zza.zzd(new RuntimeException("Connection failed."));
    }
}
