package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
enum zzfxz implements Iterator {
    INSTANCE;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzfuu.zzk(false, "no calls to next() since the last call to remove()");
    }
}
