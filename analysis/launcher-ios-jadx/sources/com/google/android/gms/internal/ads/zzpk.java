package com.google.android.gms.internal.ads;

import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzpk extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzaf zzc;

    public zzpk(int i, zzaf zzafVar, boolean z) {
        super(k31.k(i, "AudioTrack write failed: "));
        this.zzb = z;
        this.zza = i;
        this.zzc = zzafVar;
    }
}
