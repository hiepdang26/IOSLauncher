package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.j02;
import defpackage.ja2;
import defpackage.k92;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzetx implements zzevo, zzevn {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;
    private final Context zzc;
    private final zzdsf zzd;

    public zzetx(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context, zzdsf zzdsfVar) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
        this.zzd = zzdsfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 29;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zza.packageName;
        PackageInfo packageInfo = this.zzb;
        Integer numValueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (numValueOf != null) {
            bundle.putInt("vc", numValueOf.intValue());
            if (((Boolean) n42.d.c.zza(zzbbw.zzbV)).booleanValue()) {
                this.zzd.zzc("vc", numValueOf.toString());
            }
        }
        PackageInfo packageInfo2 = this.zzb;
        String str2 = packageInfo2 != null ? packageInfo2.versionName : null;
        if (str2 != null) {
            bundle.putString("vnm", str2);
            if (((Boolean) n42.d.c.zza(zzbbw.zzbV)).booleanValue()) {
                this.zzd.zzc("vn", str2);
            }
        }
        try {
            Context context = this.zzc;
            String str3 = this.zza.packageName;
            ja2 ja2Var = cd2.l;
            Context context2 = j02.a(context).h;
            bundle.putString("dl", String.valueOf(context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(str3, 0))));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzlN)).booleanValue()) {
                try {
                    InstallSourceInfo installSourceInfo = this.zzc.getPackageManager().getInstallSourceInfo(str);
                    if (installSourceInfo == null) {
                        return;
                    }
                    String installingPackageName = installSourceInfo.getInstallingPackageName();
                    if (TextUtils.isEmpty(installingPackageName)) {
                        k92.a("No installing package name found");
                    } else {
                        bundle.putString("ins_pn", installingPackageName);
                    }
                    String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                    if (TextUtils.isEmpty(initiatingPackageName)) {
                        k92.a("No initiating package name found");
                    } else {
                        bundle.putString("ini_pn", initiatingPackageName);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    hd2.B.g.zzw(e, "PackageInfoSignalsource.compose");
                }
            }
        }
    }
}
