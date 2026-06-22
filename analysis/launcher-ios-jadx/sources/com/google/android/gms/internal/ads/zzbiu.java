package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbiu implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        if (map.keySet().contains("start")) {
            zzcejVar.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcejVar.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcejVar.zzN().zzk();
        }
    }
}
