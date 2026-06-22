package defpackage;

import android.util.LongSparseArray;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class wp0 extends LongSparseArray implements Iterable {
    public final wp0 a() {
        return (wp0) super.clone();
    }

    public final boolean b(long j) {
        return indexOfKey(j) >= 0;
    }

    @Override // android.util.LongSparseArray
    public final LongSparseArray clone() {
        return (wp0) super.clone();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new y8(this);
    }

    @Override // android.util.LongSparseArray
    public final Object clone() {
        return (wp0) super.clone();
    }
}
