package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgax;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgbo extends zzgax.zzi {
    private static final zzgbk zzbd;
    private static final zzgct zzbe = new zzgct(zzgbo.class);
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzgbk zzgbnVar;
        zzgbm zzgbmVar = null;
        try {
            zzgbnVar = new zzgbl(AtomicReferenceFieldUpdater.newUpdater(zzgbo.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzgbo.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgbnVar = new zzgbn(zzgbmVar);
        }
        zzbd = zzgbnVar;
        if (th != null) {
            zzbe.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzgbo(int i) {
        this.remaining = i;
    }

    public final int zzA() {
        return zzbd.zza(this);
    }

    public final Set zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zze(setNewSetFromMap);
        zzbd.zzb(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        Objects.requireNonNull(set2);
        return set2;
    }

    public final void zzF() {
        this.seenExceptions = null;
    }

    public abstract void zze(Set set);
}
