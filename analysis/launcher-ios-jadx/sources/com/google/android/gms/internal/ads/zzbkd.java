package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import defpackage.hg0;
import defpackage.k92;
import defpackage.n42;
import defpackage.s32;
import defpackage.uy0;
import defpackage.v22;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkd {
    private final Context zza;
    private final uy0 zzb;
    private zzbjz zzc;

    public zzbkd(Context context, uy0 uy0Var) {
        hg0.i(context);
        hg0.i(uy0Var);
        this.zza = context;
        this.zzb = uy0Var;
        zzbbw.zza(context);
    }

    public static final boolean zzc(String str) {
        zzbbn zzbbnVar = zzbbw.zzja;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            hg0.i(str);
            if (str.length() > ((Integer) n42Var.c.zza(zzbbw.zzjc)).intValue()) {
                k92.d("H5 GMSG exceeds max length");
                return false;
            }
            Uri uri = Uri.parse(str);
            if ("gmsg".equals(uri.getScheme()) && "mobileads.google.com".equals(uri.getHost()) && "/h5ads".equals(uri.getPath())) {
                return true;
            }
        }
        return false;
    }

    private final void zzd() {
        if (this.zzc != null) {
            return;
        }
        Context context = this.zza;
        s32 s32Var = x32.f.b;
        zzboi zzboiVar = new zzboi();
        uy0 uy0Var = this.zzb;
        s32Var.getClass();
        this.zzc = (zzbjz) new v22(context, zzboiVar, uy0Var).d(context, false);
    }

    public final void zza() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzja)).booleanValue()) {
            zzd();
            zzbjz zzbjzVar = this.zzc;
            if (zzbjzVar != null) {
                try {
                    zzbjzVar.zze();
                } catch (RemoteException e) {
                    k92.i("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbjz zzbjzVar = this.zzc;
        if (zzbjzVar == null) {
            return false;
        }
        try {
            zzbjzVar.zzf(str);
            return true;
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            return true;
        }
    }
}
