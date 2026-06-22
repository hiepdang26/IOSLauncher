package com.google.android.gms.internal.ads;

import android.net.Uri;
import defpackage.k92;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcep implements zzgcf {
    final /* synthetic */ List zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Uri zzc;
    final /* synthetic */ zzcer zzd;

    public zzcep(zzcer zzcerVar, List list, String str, Uri uri) {
        this.zza = list;
        this.zzb = str;
        this.zzc = uri;
        this.zzd = zzcerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        k92.h("Failed to parse gmsg params for: ".concat(String.valueOf(this.zzc)));
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list = this.zza;
        String str = this.zzb;
        this.zzd.zzU((Map) obj, list, str);
    }
}
