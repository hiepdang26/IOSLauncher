package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzguz {
    public static final zzguz zza = new zzguz(new zzgva());
    public static final zzguz zzb = new zzguz(new zzgve());
    private final zzguy zzc;

    static {
        new zzguz(new zzgvg());
        new zzguz(new zzgvf());
        new zzguz(new zzgvb());
        new zzguz(new zzgvd());
        new zzguz(new zzgvc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzguz(zzgvh zzgvhVar) {
        this.zzc = !zzgks.zzb() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzgut(zzgvhVar, null) : new zzguv(zzgvhVar, 0 == true ? 1 : 0) : new zzgux(zzgvhVar, 0 == true ? 1 : 0);
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) {
        return this.zzc.zza(str);
    }
}
