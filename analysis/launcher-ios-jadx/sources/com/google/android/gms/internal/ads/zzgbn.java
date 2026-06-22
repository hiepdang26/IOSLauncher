package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzgbn extends zzgbk {
    private zzgbn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    public final int zza(zzgbo zzgboVar) {
        int i;
        synchronized (zzgboVar) {
            i = zzgboVar.remaining - 1;
            zzgboVar.remaining = i;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    public final void zzb(zzgbo zzgboVar, Set set, Set set2) {
        synchronized (zzgboVar) {
            try {
                if (zzgboVar.seenExceptions == null) {
                    zzgboVar.seenExceptions = set2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ zzgbn(zzgbm zzgbmVar) {
        super(null);
    }
}
