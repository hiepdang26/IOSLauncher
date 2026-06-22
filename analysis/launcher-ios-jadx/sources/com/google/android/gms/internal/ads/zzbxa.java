package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.a70;
import defpackage.cc1;
import defpackage.e92;
import defpackage.fc1;
import defpackage.gc1;
import defpackage.gy0;
import defpackage.k92;
import defpackage.kf1;
import defpackage.kz0;
import defpackage.lc2;
import defpackage.ly0;
import defpackage.pa2;
import defpackage.q32;
import defpackage.qa2;
import defpackage.s32;
import defpackage.u82;
import defpackage.wb1;
import defpackage.x32;
import defpackage.zy0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxa extends fc1 {
    private final String zza;
    private final zzbwg zzb;
    private final Context zzc;
    private final zzbwy zzd;
    private a70 zze;
    private ly0 zzf;
    private zy0 zzg;
    private final long zzh = System.currentTimeMillis();

    public zzbxa(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        s32 s32Var = x32.f.b;
        zzboi zzboiVar = new zzboi();
        s32Var.getClass();
        this.zzb = (zzbwg) new q32(context, str, zzboiVar).d(context, false);
        this.zzd = new zzbwy();
    }

    public final Bundle getAdMetadata() {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                return zzbwgVar.zzb();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final a70 getFullScreenContentCallback() {
        return this.zze;
    }

    public final ly0 getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final zy0 getOnPaidEventListener() {
        return null;
    }

    @Override // defpackage.fc1
    public final wb1 getResponseInfo() {
        u82 u82VarZzc = null;
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                u82VarZzc = zzbwgVar.zzc();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        return new wb1(u82VarZzc);
    }

    public final cc1 getRewardItem() {
        try {
            zzbwg zzbwgVar = this.zzb;
            zzbwd zzbwdVarZzd = zzbwgVar != null ? zzbwgVar.zzd() : null;
            if (zzbwdVarZzd != null) {
                return new zzbwq(zzbwdVarZzd);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        return cc1.f;
    }

    public final void setFullScreenContentCallback(a70 a70Var) {
        this.zze = a70Var;
        this.zzd.zzb(a70Var);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzh(z);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(ly0 ly0Var) {
        this.zzf = ly0Var;
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzi(new pa2(ly0Var));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(zy0 zy0Var) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzj(new qa2());
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(kf1 kf1Var) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzl(new zzbwu(kf1Var));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.fc1
    public final void show(Activity activity, kz0 kz0Var) {
        this.zzd.zzc(kz0Var);
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                zzbwgVar.zzk(this.zzd);
                this.zzb.zzm(new gy0(activity));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void zza(e92 e92Var, gc1 gc1Var) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                e92Var.k = this.zzh;
                zzbwgVar.zzg(lc2.a(this.zzc, e92Var), new zzbwz(gc1Var, this));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
