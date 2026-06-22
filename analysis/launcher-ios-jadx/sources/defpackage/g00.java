package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class g00 implements Iterable {
    public final ArrayList g;

    public g00(ArrayList arrayList) {
        this.g = arrayList;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.g.iterator();
    }
}
