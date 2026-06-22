package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.n42;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjk implements zzbix {
    private final zzdwf zza;

    public zzbjk(zzdwf zzdwfVar) {
        this.zza = zzdwfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (((Boolean) n42.d.c.zza(zzbbw.zziy)).booleanValue()) {
            String str = (String) map.get("action");
            String str2 = (String) map.get("adUnitId");
            String str3 = (String) map.get("redirectUrl");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            String str4 = (String) map.get("format");
            if (str.equals("load") && !TextUtils.isEmpty(str4)) {
                this.zza.zzh(str2, str4, str3);
            } else if (str.equals("show")) {
                this.zza.zzi(str2, str3);
            }
        }
    }
}
