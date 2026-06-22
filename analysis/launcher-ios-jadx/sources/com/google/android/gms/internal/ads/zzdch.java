package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.k92;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class zzdch {
    protected final Map zza = new HashMap();

    public zzdch(Set set) {
        zzp(set);
    }

    public final synchronized void zzk(zzdei zzdeiVar) {
        zzo(zzdeiVar.zza, zzdeiVar.zzb);
    }

    public final synchronized void zzo(Object obj, Executor executor) {
        this.zza.put(obj, executor);
    }

    public final synchronized void zzp(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzk((zzdei) it.next());
        }
    }

    public final synchronized void zzq(final zzdcg zzdcgVar) {
        for (Map.Entry entry : this.zza.entrySet()) {
            final Object key = entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdcf
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdcgVar.zza(key);
                    } catch (Throwable th) {
                        hd2.B.g.zzv(th, "EventEmitter.notify");
                        k92.b();
                    }
                }
            });
        }
    }
}
