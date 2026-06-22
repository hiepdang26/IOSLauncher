package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfus implements Serializable {
    public static zzfus zzc() {
        return zzfud.zza;
    }

    public static zzfus zzd(Object obj) {
        return obj == null ? zzfud.zza : new zzfuz(obj);
    }

    public abstract zzfus zza(zzful zzfulVar);

    public abstract Object zzb(Object obj);
}
