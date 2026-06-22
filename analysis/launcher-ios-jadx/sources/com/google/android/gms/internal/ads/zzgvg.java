package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Signature;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvg implements zzgvh {
    @Override // com.google.android.gms.internal.ads.zzgvh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
