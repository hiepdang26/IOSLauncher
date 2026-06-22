package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfrd implements Closeable {
    public static zzfrp zza() {
        return new zzfrp();
    }

    public static zzfrp zzb(final int i, zzfro zzfroVar) {
        return new zzfrp(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrb
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i);
            }
        }, new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrc
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return zzfrd.zze();
            }
        }, zzfroVar);
    }

    public static zzfrp zzc(zzfvk<Integer> zzfvkVar, zzfvk<Integer> zzfvkVar2, zzfro zzfroVar) {
        return new zzfrp(zzfvkVar, zzfvkVar2, zzfroVar);
    }

    public static /* synthetic */ Integer zze() {
        return -1;
    }
}
