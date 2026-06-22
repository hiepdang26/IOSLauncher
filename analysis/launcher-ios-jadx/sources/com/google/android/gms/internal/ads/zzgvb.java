package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvb implements zzgvh {
    @Override // com.google.android.gms.internal.ads.zzgvh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
