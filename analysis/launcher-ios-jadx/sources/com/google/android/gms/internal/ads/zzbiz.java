package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiz implements zzbix {
    private final zzbja zza;

    public zzbiz(zzbja zzbjaVar) {
        this.zza = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException unused) {
            k92.f();
        }
        this.zza.zzc(zEquals);
        this.zza.zzb(zEquals2, f);
        zzcejVar.zzay(zEquals);
    }
}
