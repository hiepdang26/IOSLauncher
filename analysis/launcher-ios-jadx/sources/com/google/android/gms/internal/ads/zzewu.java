package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import defpackage.do0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzewu implements zzevo {
    private final Executor zza;
    private final String zzb;

    public zzewu(zzbyv zzbyvVar, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zza = executor;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 41;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zzf(zzgcj.zzm(zzgcj.zzh(this.zzb), new zzful() { // from class: com.google.android.gms.internal.ads.zzews
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzewv((String) obj);
            }
        }, this.zza), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzewt
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, this.zza);
    }

    public final /* synthetic */ do0 zzc(Throwable th) {
        return zzgcj.zzh(new zzewv(this.zzb));
    }
}
