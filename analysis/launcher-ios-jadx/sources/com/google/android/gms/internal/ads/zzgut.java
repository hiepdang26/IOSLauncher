package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzgut implements zzguy {
    private final zzgvh zza;

    public /* synthetic */ zzgut(zzgvh zzgvhVar, zzgus zzgusVar) {
        this.zza = zzgvhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguy
    public final Object zza(String str) {
        Iterator it = zzguz.zzb("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, null);
    }
}
