package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.kr;
import defpackage.lr;
import defpackage.nr;
import defpackage.or;
import defpackage.td0;
import defpackage.vd0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbct {
    private or zza;
    private lr zzb;
    private nr zzc;
    private zzbcs zzd;

    public static boolean zzg(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                for (int i = 0; i < listQueryIntentActivities.size(); i++) {
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i).activityInfo.name)) {
                        return resolveInfoResolveActivity.activityInfo.packageName.equals(zzhfv.zza(context));
                    }
                }
            }
        }
        return false;
    }

    public final or zza() {
        lr lrVar = this.zzb;
        or orVar = null;
        if (lrVar == null) {
            this.zza = orVar;
        } else if (this.zza == null) {
            kr krVar = new kr(null);
            vd0 vd0Var = lrVar.a;
            try {
                if (((td0) vd0Var).f(krVar)) {
                    orVar = new or(vd0Var, krVar, lrVar.b);
                }
            } catch (RemoteException unused) {
            }
            this.zza = orVar;
        }
        return this.zza;
    }

    public final void zzb(Activity activity) {
        String strZza;
        if (this.zzb == null && (strZza = zzhfv.zza(activity)) != null) {
            zzhfw zzhfwVar = new zzhfw(this);
            this.zzc = zzhfwVar;
            zzhfwVar.setApplicationContext(activity.getApplicationContext());
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            if (!TextUtils.isEmpty(strZza)) {
                intent.setPackage(strZza);
            }
            activity.bindService(intent, zzhfwVar, 33);
        }
    }

    public final void zzc(lr lrVar) {
        this.zzb = lrVar;
        lrVar.getClass();
        try {
            ((td0) lrVar.a).r();
        } catch (RemoteException unused) {
        }
        zzbcs zzbcsVar = this.zzd;
        if (zzbcsVar != null) {
            zzbcsVar.zza();
        }
    }

    public final void zzd() {
        this.zzb = null;
        this.zza = null;
    }

    public final void zze(zzbcs zzbcsVar) {
        this.zzd = zzbcsVar;
    }

    public final void zzf(Activity activity) {
        nr nrVar = this.zzc;
        if (nrVar == null) {
            return;
        }
        activity.unbindService(nrVar);
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }
}
