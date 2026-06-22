package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import defpackage.j02;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxc implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdxc(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return j02.a((Context) this.zza.zzb()).g(0, ((zzdwy) this.zzb).zzb().packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
