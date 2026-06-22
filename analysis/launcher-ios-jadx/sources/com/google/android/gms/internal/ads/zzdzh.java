package com.google.android.gms.internal.ads;

import android.os.Binder;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdzh {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzeac zzc;
    private final zzhew zzd;

    public zzdzh(zzgcu zzgcuVar, zzgcu zzgcuVar2, zzeac zzeacVar, zzhew zzhewVar) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = zzeacVar;
        this.zzd = zzhewVar;
    }

    public final do0 zza(zzbug zzbugVar) {
        return this.zzc.zza(zzbugVar, ((Long) n42.d.c.zza(zzbbw.zzkH)).longValue());
    }

    public final /* synthetic */ do0 zzb(zzbug zzbugVar, int i, zzdyp zzdypVar) {
        return ((zzebi) this.zzd.zzb()).zzb(zzbugVar, i);
    }

    public final do0 zzc(final zzbug zzbugVar) {
        String str = zzbugVar.zzf;
        cd2 cd2Var = hd2.B.c;
        do0 do0VarZzg = cd2.c(str) ? zzgcj.zzg(new zzdyp(1, "Ads service proxy force local")) : zzgcj.zzf(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzdze
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() {
                return this.zza.zza(zzbugVar);
            }
        }, this.zza), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzf
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                Throwable cause = (ExecutionException) obj;
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                return zzgcj.zzg(cause);
            }
        }, this.zzb);
        final int callingUid = Binder.getCallingUid();
        return zzgcj.zzf(do0VarZzg, zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzg
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzb(zzbugVar, callingUid, (zzdyp) obj);
            }
        }, this.zzb);
    }
}
