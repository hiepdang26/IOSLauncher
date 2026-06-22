package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeze implements zzevo {
    private final zzbze zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzgcu zze;

    public zzeze(zzbze zzbzeVar, boolean z, boolean z2, zzbyt zzbytVar, zzgcu zzgcuVar, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzbzeVar;
        this.zzb = z;
        this.zzc = z2;
        this.zze = zzgcuVar;
        this.zzd = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 50;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzgu)).booleanValue() && this.zzc) {
            return zzgcj.zzh(null);
        }
        if (!this.zzb) {
            return zzgcj.zzh(null);
        }
        return zzgcj.zze(zzgcj.zzo(zzgcj.zzm(zzgcj.zzh(null), new zzful() { // from class: com.google.android.gms.internal.ads.zzezc
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                return new zzezf(str);
            }
        }, this.zze), ((Long) zzbeg.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzezd
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                this.zza.zzc((Exception) obj);
                return null;
            }
        }, this.zze);
    }

    public final /* synthetic */ zzezf zzc(Exception exc) {
        this.zza.zzw(exc, "TrustlessTokenSignal");
        return null;
    }
}
