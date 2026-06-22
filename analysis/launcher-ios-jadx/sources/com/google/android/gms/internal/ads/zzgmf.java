package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmf {
    private static final zzgmf zza = new zzgmf();
    private static final zzgme zzb = new zzgme(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgmf zzb() {
        return zza;
    }

    public final zzglp zza() {
        zzglp zzglpVar = (zzglp) this.zzc.get();
        return zzglpVar == null ? zzb : zzglpVar;
    }
}
