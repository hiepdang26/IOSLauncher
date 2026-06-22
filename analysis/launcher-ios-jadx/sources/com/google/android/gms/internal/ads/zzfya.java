package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class zzfya extends zzfzx {
    private final Object zza;
    private boolean zzb;

    public zzfya(Object obj) {
        this.zza = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzb;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zzb) {
            throw new NoSuchElementException();
        }
        this.zzb = true;
        return this.zza;
    }
}
