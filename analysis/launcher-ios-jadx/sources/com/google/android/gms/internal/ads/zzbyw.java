package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import defpackage.us;

/* JADX INFO: loaded from: classes.dex */
final class zzbyw {
    final /* synthetic */ zzbyx zza;
    private long zzb = -1;
    private long zzc = -1;

    public zzbyw(zzbyx zzbyxVar) {
        this.zza = zzbyxVar;
    }

    public final long zza() {
        return this.zzc;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }

    public final void zzc() {
        ((us) this.zza.zza).getClass();
        this.zzc = SystemClock.elapsedRealtime();
    }

    public final void zzd() {
        ((us) this.zza.zza).getClass();
        this.zzb = SystemClock.elapsedRealtime();
    }
}
