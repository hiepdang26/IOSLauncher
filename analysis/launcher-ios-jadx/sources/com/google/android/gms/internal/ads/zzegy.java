package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.gy0;
import defpackage.i2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzegy implements zzdgx {
    private final zzfel zza;
    private final zzbql zzb;
    private final i2 zzc;
    private zzcxi zzd = null;

    public zzegy(zzfel zzfelVar, zzbql zzbqlVar, i2 i2Var) {
        this.zza = zzfelVar;
        this.zzb = zzbqlVar;
        this.zzc = i2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final void zza(boolean z, Context context, zzcxd zzcxdVar) throws zzdgw {
        boolean zZzs;
        try {
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(new gy0(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzs = this.zzb.zzr(new gy0(context));
                    }
                    throw new zzdgw("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(new gy0(context));
            }
            if (zZzs) {
                if (this.zzd == null) {
                    return;
                }
                if (((Boolean) n42.d.c.zza(zzbbw.zzbm)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                this.zzd.zza();
                return;
            }
            throw new zzdgw("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdgw(th);
        }
    }

    public final void zzb(zzcxi zzcxiVar) {
        this.zzd = zzcxiVar;
    }
}
