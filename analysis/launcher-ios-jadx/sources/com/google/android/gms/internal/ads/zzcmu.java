package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import defpackage.hd2;
import defpackage.n42;
import defpackage.uo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmu implements zzcly {
    private final CookieManager zza = hd2.B.e.i();

    public zzcmu(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        if (this.zza == null) {
            return;
        }
        if (((String) map.get("clear")) == null) {
            String str = (String) map.get("cookie");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.zza.setCookie((String) n42.d.c.zza(zzbbw.zzaF), str);
            return;
        }
        String str2 = (String) n42.d.c.zza(zzbbw.zzaF);
        String cookie = this.zza.getCookie(str2);
        if (cookie != null) {
            List listZze = zzfvh.zzb(zzfui.zzc(';')).zze(cookie);
            for (int i = 0; i < listZze.size(); i++) {
                CookieManager cookieManager = this.zza;
                Iterator it = zzfvh.zzb(zzfui.zzc('=')).zzc((String) listZze.get(i)).iterator();
                it.getClass();
                if (!it.hasNext()) {
                    throw new IndexOutOfBoundsException(uo.d(0, "position (0) must be less than the number of elements that remained (", ")"));
                }
                cookieManager.setCookie(str2, String.valueOf((String) it.next()).concat(String.valueOf((String) n42.d.c.zza(zzbbw.zzar))));
            }
        }
    }
}
