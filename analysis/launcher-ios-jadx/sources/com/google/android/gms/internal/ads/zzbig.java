package com.google.android.gms.internal.ads;

import defpackage.ew1;
import defpackage.hd2;
import defpackage.k92;
import defpackage.wc0;
import defpackage.xm;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbig implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzfta zzftaVar;
        wc0 wc0Var = hd2.B.q;
        if (!wc0Var.g || (zzftaVar = (zzfta) wc0Var.k) == null) {
            k92.a("LastMileDelivery not connected");
        } else {
            zzftaVar.zzc(wc0Var.f(), (ew1) wc0Var.l);
            zzbzo.zze.execute(new xm(wc0Var, "onLMDOverlayExpand", new HashMap(), 18));
        }
    }
}
