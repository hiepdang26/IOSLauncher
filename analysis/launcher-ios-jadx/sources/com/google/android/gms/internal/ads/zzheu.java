package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzheu {
    public static zzheu zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzhep(cls.getSimpleName()) : new zzher(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
