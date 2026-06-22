package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhi {
    private final HashMap zza = new HashMap();

    public final zzfhh zza(zzfgy zzfgyVar, Context context, zzfgq zzfgqVar, zzfho zzfhoVar) {
        zzfhh zzfhhVar = (zzfhh) this.zza.get(zzfgyVar);
        if (zzfhhVar != null) {
            return zzfhhVar;
        }
        zzfgv zzfgvVar = new zzfgv(zzfhb.zza(zzfgyVar, context));
        zzfhh zzfhhVar2 = new zzfhh(zzfgvVar, new zzfhq(zzfgvVar, zzfgqVar, zzfhoVar));
        this.zza.put(zzfgyVar, zzfhhVar2);
        return zzfhhVar2;
    }
}
