package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hg0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiy implements zzbix {
    private final zzdvi zza;

    public zzbiy(zzdvi zzdviVar) {
        hg0.j(zzdviVar, "The Inspector Manager must not be null");
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("persistentData") || TextUtils.isEmpty((CharSequence) map.get("persistentData"))) {
            return;
        }
        this.zza.zzj((String) map.get("persistentData"));
    }
}
