package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcml implements zzcly {
    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzjz)).booleanValue() || map.isEmpty()) {
            return;
        }
        String str = (String) map.get("is_topics_ad_personalization_allowed");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((ib2) hd2.B.g.zzi()).h(Boolean.parseBoolean(str));
    }
}
