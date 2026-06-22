package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.wc0;
import defpackage.xm;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbie implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        wc0 wc0Var = hd2.B.q;
        Context context = zzcejVar.getContext();
        synchronized (wc0Var) {
            wc0Var.j = zzcejVar;
            if (!wc0Var.e(context)) {
                wc0Var.c("Unable to bind", "on_play_store_bind");
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("action", "fetch_completed");
            zzbzo.zze.execute(new xm(wc0Var, "on_play_store_bind", map2, 18));
        }
    }
}
