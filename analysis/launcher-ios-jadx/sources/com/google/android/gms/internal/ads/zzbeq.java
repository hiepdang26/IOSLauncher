package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbeq extends zzbfc {
    private final Drawable zza;
    private final Uri zzb;
    private final double zzc;
    private final int zzd;
    private final int zze;

    public zzbeq(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d;
        this.zzd = i;
        this.zze = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final double zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final Uri zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final he0 zzf() {
        return new gy0(this.zza);
    }
}
