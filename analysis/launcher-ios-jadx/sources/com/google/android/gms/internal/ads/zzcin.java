package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcin implements zzezl {
    private final zzcif zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcin(zzcif zzcifVar, zzcim zzcimVar) {
        this.zza = zzcifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezl
    public final /* synthetic */ zzezl zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzezl
    public final /* synthetic */ zzezl zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzezl
    public final zzezm zzc() {
        zzhfk.zzc(this.zzb, Context.class);
        zzhfk.zzc(this.zzc, String.class);
        return new zzcip(this.zza, this.zzb, this.zzc, null);
    }
}
