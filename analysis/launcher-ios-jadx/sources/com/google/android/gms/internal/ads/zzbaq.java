package com.google.android.gms.internal.ads;

import defpackage.bb;
import defpackage.vl;

/* JADX INFO: loaded from: classes.dex */
final class zzbaq implements bb {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbar zzb;

    public zzbaq(zzbar zzbarVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
        this.zzb = zzbarVar;
    }

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
