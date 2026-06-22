package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.x82;

/* JADX INFO: loaded from: classes.dex */
public final class zzdik extends zzbez {
    private final zzdjb zza;
    private he0 zzb;

    public zzdik(zzdjb zzdjbVar) {
        this.zza = zzdjbVar;
    }

    private static float zzb(he0 he0Var) {
        Drawable drawable;
        if (he0Var == null || (drawable = (Drawable) gy0.r(he0Var)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zze() {
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException unused) {
                k92.f();
            }
        } else {
            he0 he0Var = this.zzb;
            if (he0Var != null) {
                return zzb(he0Var);
            }
            zzbfd zzbfdVarZzm = this.zza.zzm();
            if (zzbfdVarZzm != null) {
                float fZzd = (zzbfdVarZzm.zzd() == -1 || zzbfdVarZzm.zzc() == -1) ? 0.0f : zzbfdVarZzm.zzd() / zzbfdVarZzm.zzc();
                return fZzd == 0.0f ? zzb(zzbfdVarZzm.zzf()) : fZzd;
            }
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzf() {
        if (this.zza.zzj() != null) {
            return this.zza.zzj().zzf();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzg() {
        if (this.zza.zzj() != null) {
            return this.zza.zzj().zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final x82 zzh() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final he0 zzi() {
        he0 he0Var = this.zzb;
        if (he0Var != null) {
            return he0Var;
        }
        zzbfd zzbfdVarZzm = this.zza.zzm();
        if (zzbfdVarZzm == null) {
            return null;
        }
        return zzbfdVarZzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzj(he0 he0Var) {
        this.zzb = he0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzk() {
        return this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzl() {
        return this.zza.zzj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzm(zzbgl zzbglVar) {
        if (this.zza.zzj() instanceof zzcfl) {
            ((zzcfl) this.zza.zzj()).zzv(zzbglVar);
        }
    }
}
