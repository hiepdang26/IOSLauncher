package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzauf implements zzfqc {
    final /* synthetic */ zzfoc zza;

    public zzauf(zzauh zzauhVar, zzfoc zzfocVar) {
        this.zza = zzfocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqc
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
