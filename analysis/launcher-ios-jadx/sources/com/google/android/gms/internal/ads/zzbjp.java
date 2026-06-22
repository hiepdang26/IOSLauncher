package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjp implements zzbix {
    private final zzbjo zza;

    public zzbjp(zzbjo zzbjoVar) {
        this.zza = zzbjoVar;
    }

    public static void zzb(zzcej zzcejVar, zzbjo zzbjoVar) {
        zzcejVar.zzag("/reward", new zzbjp(zzbjoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zza.zzc();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zza.zzb();
                    return;
                }
                return;
            }
        }
        zzbvz zzbvzVar = null;
        try {
            int i = Integer.parseInt((String) map.get("amount"));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzbvzVar = new zzbvz(str2, i);
            }
        } catch (NumberFormatException unused) {
            k92.j(5);
        }
        this.zza.zza(zzbvzVar);
    }
}
