package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.a70;
import defpackage.b21;
import defpackage.cc1;
import defpackage.dc1;
import defpackage.e92;
import defpackage.ec1;
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
public final class zzbwp extends dc1 {
    private final String zza;
    private final zzbwg zzb;
    private final Context zzc;
    private final zzbwy zzd;
    private ly0 zze;
    private zy0 zzf;
    private a70 zzg;
    private final long zzh = System.currentTimeMillis();

    public zzbwp(Context context, String str) {
        this.zzc = context.getApplicationContext();
        this.zza = str;
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
        return this.zzg;
    }

    public final ly0 getOnAdMetadataChangedListener() {
        return this.zze;
    }

    public final zy0 getOnPaidEventListener() {
        return null;
    }

    @Override // defpackage.dc1
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
        b21 b21Var = cc1.f;
        try {
            zzbwg zzbwgVar = this.zzb;
            zzbwd zzbwdVarZzd = zzbwgVar != null ? zzbwgVar.zzd() : null;
            return zzbwdVarZzd == null ? b21Var : new zzbwq(zzbwdVarZzd);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            return b21Var;
        }
    }

    public final void setFullScreenContentCallback(a70 a70Var) {
        this.zzg = a70Var;
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
        try {
            this.zze = ly0Var;
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

    @Override // defpackage.dc1
    public final void show(Activity activity, kz0 kz0Var) {
        this.zzd.zzc(kz0Var);
        if (activity == null) {
            k92.h("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
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

    public final void zza(e92 e92Var, ec1 ec1Var) {
        try {
            zzbwg zzbwgVar = this.zzb;
            if (zzbwgVar != null) {
                e92Var.k = this.zzh;
                zzbwgVar.zzf(lc2.a(this.zzc, e92Var), new zzbwt(ec1Var, this));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(kf1 kf1Var) {
    }
}
