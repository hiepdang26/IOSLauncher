package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcfg implements zzbix {
    final /* synthetic */ zzcfi zza;

    public zzcfg(zzcfi zzcfiVar) {
        this.zza = zzcfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i = Integer.parseInt(str);
                synchronized (this.zza) {
                    try {
                        zzcfi zzcfiVar = this.zza;
                        if (zzcfiVar.zzI != i) {
                            zzcfiVar.zzI = i;
                            this.zza.requestLayout();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
                k92.j(5);
            }
        }
    }
}
