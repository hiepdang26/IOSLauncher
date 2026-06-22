package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.nj;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
final class zzbxt {
    private Context zza;
    private nj zzb;
    private za2 zzc;
    private zzbya zzd;

    private zzbxt() {
        throw null;
    }

    public final zzbxt zza(za2 za2Var) {
        this.zzc = za2Var;
        return this;
    }

    public final zzbxt zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbxt zzc(nj njVar) {
        njVar.getClass();
        this.zzb = njVar;
        return this;
    }

    public final zzbxt zzd(zzbya zzbyaVar) {
        this.zzd = zzbyaVar;
        return this;
    }

    public final zzbyb zze() {
        zzhfk.zzc(this.zza, Context.class);
        zzhfk.zzc(this.zzb, nj.class);
        zzhfk.zzc(this.zzc, za2.class);
        zzhfk.zzc(this.zzd, zzbya.class);
        return new zzbxv(this.zza, this.zzb, this.zzc, this.zzd, null);
    }

    public /* synthetic */ zzbxt(zzbxs zzbxsVar) {
    }
}
