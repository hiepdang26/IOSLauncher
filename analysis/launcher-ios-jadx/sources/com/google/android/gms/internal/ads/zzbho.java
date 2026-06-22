package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbho implements zzbix {
    private final zzbhp zza;

    public zzbho(zzbhp zzbhpVar) {
        this.zza = zzbhpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            k92.h("App event with no name parameter.");
        } else {
            this.zza.zzb(str, (String) map.get("info"));
        }
    }
}
