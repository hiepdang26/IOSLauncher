package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.ew1;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.wc0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbii implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzfta zzftaVar;
        wc0 wc0Var = hd2.B.q;
        if (!wc0Var.g || (zzftaVar = (zzfta) wc0Var.k) == null) {
            k92.a("LastMileDelivery not connected");
            return;
        }
        zzfsy zzfsyVarZzc = zzfsz.zzc();
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkC)).booleanValue() || TextUtils.isEmpty((String) wc0Var.h)) {
            String str = (String) wc0Var.i;
            if (str != null) {
                zzfsyVarZzc.zzb(str);
            } else {
                wc0Var.c("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfsyVarZzc.zza((String) wc0Var.h);
        }
        zzftaVar.zzb(zzfsyVarZzc.zzc(), (ew1) wc0Var.l);
    }
}
