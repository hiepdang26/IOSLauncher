package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
final class zzgbl extends zzgbk {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    public zzgbl(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    public final int zza(zzgbo zzgboVar) {
        return this.zzb.decrementAndGet(zzgboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    public final void zzb(zzgbo zzgboVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.zza;
            while (!atomicReferenceFieldUpdater.compareAndSet(zzgboVar, null, set2)) {
                if (atomicReferenceFieldUpdater.get(zzgboVar) != null) {
                }
            }
            return;
        } while (atomicReferenceFieldUpdater.get(zzgboVar) == null);
    }
}
