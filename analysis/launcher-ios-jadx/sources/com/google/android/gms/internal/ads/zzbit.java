package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbit implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcejVar.zzdg();
        } else if ("resume".equals(str)) {
            zzcejVar.zzdh();
        }
    }
}
