package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
final class zzcjv implements zzfcq {
    private final zzcif zza;
    private Context zzb;
    private String zzc;
    private rc2 zzd;

    public /* synthetic */ zzcjv(zzcif zzcifVar, zzcju zzcjuVar) {
        this.zza = zzcifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfcq
    public final /* synthetic */ zzfcq zza(rc2 rc2Var) {
        rc2Var.getClass();
        this.zzd = rc2Var;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfcq
    public final /* synthetic */ zzfcq zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfcq
    public final /* synthetic */ zzfcq zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfcq
    public final zzfcr zzd() {
        zzhfk.zzc(this.zzb, Context.class);
        zzhfk.zzc(this.zzc, String.class);
        zzhfk.zzc(this.zzd, rc2.class);
        return new zzcjx(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
