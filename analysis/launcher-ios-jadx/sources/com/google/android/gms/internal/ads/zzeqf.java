package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.do0;
import defpackage.nj;
import defpackage.us;

/* JADX INFO: loaded from: classes.dex */
final class zzeqf {
    public final do0 zza;
    private final long zzb;
    private final nj zzc;

    public zzeqf(do0 do0Var, long j, nj njVar) {
        this.zza = do0Var;
        this.zzc = njVar;
        ((us) njVar).getClass();
        this.zzb = SystemClock.elapsedRealtime() + j;
    }

    public final boolean zza() {
        nj njVar = this.zzc;
        long j = this.zzb;
        ((us) njVar).getClass();
        return j < SystemClock.elapsedRealtime();
    }
}
