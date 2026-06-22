package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgf {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzgcu zzc;

    public zzfgf(Callable callable, zzgcu zzgcuVar) {
        this.zzb = callable;
        this.zzc = zzgcuVar;
    }

    public final synchronized do0 zza() {
        zzc(1);
        return (do0) this.zza.poll();
    }

    public final synchronized void zzb(do0 do0Var) {
        this.zza.addFirst(do0Var);
    }

    public final synchronized void zzc(int i) {
        int size = i - this.zza.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}
