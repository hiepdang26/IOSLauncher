package com.google.android.gms.internal.ads;

import defpackage.a3;

/* JADX INFO: loaded from: classes.dex */
public final class zzbld {
    private final a3 zza;
    private final String zzb;
    private final int zzc;

    public zzbld(a3 a3Var, String str, int i) {
        this.zza = a3Var;
        this.zzb = str;
        this.zzc = i;
    }

    public final String getDescription() {
        return this.zzb;
    }

    public final a3 getInitializationState() {
        return this.zza;
    }

    public final int getLatency() {
        return this.zzc;
    }
}
