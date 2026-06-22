package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
final class zzcix implements zzfaz {
    private final zzcif zza;
    private Context zzb;
    private String zzc;
    private rc2 zzd;

    public /* synthetic */ zzcix(zzcif zzcifVar, zzciw zzciwVar) {
        this.zza = zzcifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final /* synthetic */ zzfaz zza(rc2 rc2Var) {
        rc2Var.getClass();
        this.zzd = rc2Var;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final /* synthetic */ zzfaz zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final /* synthetic */ zzfaz zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final zzfba zzd() {
        zzhfk.zzc(this.zzb, Context.class);
        zzhfk.zzc(this.zzc, String.class);
        zzhfk.zzc(this.zzd, rc2.class);
        return new zzciz(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
