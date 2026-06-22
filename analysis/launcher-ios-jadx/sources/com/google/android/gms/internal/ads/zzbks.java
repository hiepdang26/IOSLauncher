package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import defpackage.ab;
import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
final class zzbks implements ab {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbku zzb;

    public zzbks(zzbku zzbkuVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
        this.zzb = zzbkuVar;
    }

    @Override // defpackage.ab
    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException(k31.k(i, "onConnectionSuspended: ")));
    }
}
