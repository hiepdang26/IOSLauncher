package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.n42;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdrk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdrk(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        Set setSingleton;
        final String str = (String) this.zza.zzb();
        Context contextZza = ((zzcgp) this.zzb).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Map mapZzb = ((zzhfg) this.zzc).zzb();
        if (((Boolean) n42.d.c.zza(zzbbw.zzet)).booleanValue()) {
            zzbav zzbavVar = new zzbav(new zzbbb(contextZza));
            zzbavVar.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdrl
                @Override // com.google.android.gms.internal.ads.zzbau
                public final void zza(zzbbc.zzt.zza zzaVar) {
                    zzaVar.zzO(str);
                }
            });
            setSingleton = Collections.singleton(new zzdei(new zzdrn(zzbavVar, mapZzb), zzgcuVar));
        } else {
            setSingleton = Collections.EMPTY_SET;
        }
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
