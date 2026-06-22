package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwq {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzdxx zzc;
    private final zzhew zzd;

    public zzdwq(zzgcu zzgcuVar, zzgcu zzgcuVar2, zzdxx zzdxxVar, zzhew zzhewVar) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = zzdxxVar;
        this.zzd = zzhewVar;
    }

    public final zzdyq zza(zzbvb zzbvbVar) {
        return (zzdyq) this.zzc.zza(zzbvbVar).get(((Integer) n42.d.c.zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
    }

    public final /* synthetic */ do0 zzb(final zzbvb zzbvbVar, int i, zzdyp zzdypVar) {
        Bundle bundle;
        if (zzbvbVar != null && (bundle = zzbvbVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgcj.zzn(((zzeay) this.zzd.zzb()).zzc(zzbvbVar, i), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdwm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(new zzdyq((InputStream) obj, zzbvbVar));
            }
        }, this.zzb);
    }

    public final do0 zzc(final zzbvb zzbvbVar) {
        String str = zzbvbVar.zzd;
        cd2 cd2Var = hd2.B.c;
        do0 do0VarZzg = cd2.c(str) ? zzgcj.zzg(new zzdyp(1)) : zzgcj.zzf(this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(zzbvbVar);
            }
        }), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdwo
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzg(((ExecutionException) obj).getCause());
            }
        }, this.zzb);
        final int callingUid = Binder.getCallingUid();
        return zzgcj.zzf(do0VarZzg, zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdwp
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzb(zzbvbVar, callingUid, (zzdyp) obj);
            }
        }, this.zzb);
    }
}
