package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.n42;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzepp implements zzevn {
    private final Integer zza;

    private zzepp(Integer num) {
        this.zza = num;
    }

    public static zzepp zzb(or1 or1Var) {
        zzbbn zzbbnVar = zzbbw.zzjg;
        n42 n42Var = n42.d;
        zzbbu zzbbuVar = n42Var.c;
        zzbbu zzbbuVar2 = n42Var.c;
        if (!((Boolean) zzbbuVar.zza(zzbbnVar)).booleanValue()) {
            return new zzepp(null);
        }
        cd2 cd2Var = hd2.B.c;
        int extensionVersion = 0;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
                extensionVersion = SdkExtensions.getExtensionVersion(1000000);
            } else if (((Boolean) zzbbuVar2.zza(zzbbw.zzjj)).booleanValue() && or1Var.i >= ((Integer) zzbbuVar2.zza(zzbbw.zzji)).intValue() && i >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                extensionVersion = SdkExtensions.getExtensionVersion(31);
            }
        } catch (Exception e) {
            hd2.B.g.zzw(e, "AdUtil.getAdServicesExtensionVersion");
        }
        return new zzepp(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
