package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.ov0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfe extends ov0 {
    private final zzbfd zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzbfe(zzbfd zzbfdVar) {
        double dZzb;
        int iZzd;
        he0 he0VarZzf;
        this.zza = zzbfdVar;
        Uri uriZze = null;
        try {
            he0VarZzf = zzbfdVar.zzf();
        } catch (RemoteException unused) {
            k92.f();
        }
        Drawable drawable = he0VarZzf != null ? (Drawable) gy0.r(he0VarZzf) : null;
        this.zzb = drawable;
        try {
            uriZze = this.zza.zze();
        } catch (RemoteException unused2) {
            k92.f();
        }
        this.zzc = uriZze;
        try {
            dZzb = this.zza.zzb();
        } catch (RemoteException unused3) {
            k92.f();
            dZzb = 1.0d;
        }
        this.zzd = dZzb;
        int iZzc = -1;
        try {
            iZzd = this.zza.zzd();
        } catch (RemoteException unused4) {
            k92.f();
            iZzd = -1;
        }
        this.zze = iZzd;
        try {
            iZzc = this.zza.zzc();
        } catch (RemoteException unused5) {
            k92.f();
        }
        this.zzf = iZzc;
    }

    @Override // defpackage.ov0
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // defpackage.ov0
    public final double getScale() {
        return this.zzd;
    }

    @Override // defpackage.ov0
    public final Uri getUri() {
        return this.zzc;
    }

    @Override // defpackage.ov0
    public final int zza() {
        return this.zzf;
    }

    @Override // defpackage.ov0
    public final int zzb() {
        return this.zze;
    }
}
