package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
final class zzgvm extends ThreadLocal {
    final /* synthetic */ zzgvn zza;

    public zzgvm(zzgvn zzgvnVar) {
        this.zza = zzgvnVar;
    }

    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) zzguz.zzb.zza(this.zza.zzb);
            mac.init(this.zza.zzc);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
