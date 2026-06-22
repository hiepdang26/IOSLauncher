package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzdww implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdww(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzfjl zzfjlVar = (zzfjl) this.zza.zzb();
        final CookieManager cookieManagerI = hd2.B.e.i();
        zzfjc zzfjcVarZzi = zzfiv.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = cookieManagerI;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) n42.d.c.zza(zzbbw.zzaF));
            }
        }, zzfjf.WEBVIEW_COOKIE, zzfjlVar).zzi(1L, TimeUnit.SECONDS);
        final zzfio zzfioVar = new zzfio() { // from class: com.google.android.gms.internal.ads.zzdwu
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                return "";
            }
        };
        return zzfjcVarZzi.zzc(Exception.class, new zzgbq(zzfioVar) { // from class: com.google.android.gms.internal.ads.zzfiw
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh("");
            }
        }).zza();
    }
}
