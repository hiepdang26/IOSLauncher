package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxk {
    private final ScheduledExecutorService zza;
    private final zzgcu zzb;
    private final zzgcu zzc;
    private final zzdyc zzd;
    private final zzhew zze;

    public zzdxk(ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar, zzgcu zzgcuVar2, zzdyc zzdycVar, zzhew zzhewVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgcuVar;
        this.zzc = zzgcuVar2;
        this.zzd = zzdycVar;
        this.zze = zzhewVar;
    }

    public final zzdyq zza(zzbvb zzbvbVar) {
        return (zzdyq) this.zzd.zza(zzbvbVar).get(((Integer) n42.d.c.zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
    }

    public final /* synthetic */ do0 zzb(final zzbvb zzbvbVar, int i, Throwable th) {
        Bundle bundle;
        if (zzbvbVar != null && (bundle = zzbvbVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgcj.zzn(((zzeay) this.zze.zzb()).zzd(zzbvbVar, i), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxh
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(new zzdyq((InputStream) obj, zzbvbVar));
            }
        }, this.zzb);
    }

    public final do0 zzc(final zzbvb zzbvbVar) {
        do0 do0VarZzb;
        String str = zzbvbVar.zzd;
        cd2 cd2Var = hd2.B.c;
        if (cd2.c(str)) {
            do0VarZzb = zzgcj.zzg(new zzdyp(1));
        } else {
            do0VarZzb = ((Boolean) n42.d.c.zza(zzbbw.zzgK)).booleanValue() ? this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxi
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zza(zzbvbVar);
                }
            }) : this.zzd.zza(zzbvbVar);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgcj.zzf((zzgca) zzgcj.zzo(zzgca.zzu(do0VarZzb), ((Integer) n42.d.c.zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxj
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzb(zzbvbVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }
}
