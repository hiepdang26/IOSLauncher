package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.lb2;
import defpackage.or1;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgm {
    private final or1 zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    public /* synthetic */ zzcgm(zzcgk zzcgkVar, zzcgl zzcglVar) {
        this.zza = zzcgkVar.zza;
        this.zzb = zzcgkVar.zzb;
        this.zzd = zzcgkVar.zzd;
        this.zzc = zzcgkVar.zzc;
    }

    public final long zza() {
        return this.zzc;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final lb2 zzc() {
        return new lb2(this.zzb, this.zza);
    }

    public final zzbel zzd() {
        return new zzbel(this.zzb);
    }

    public final or1 zze() {
        return this.zza;
    }

    public final String zzf() {
        return hd2.B.c.w(this.zzb, this.zza.g);
    }

    public final WeakReference zzg() {
        return this.zzd;
    }
}
