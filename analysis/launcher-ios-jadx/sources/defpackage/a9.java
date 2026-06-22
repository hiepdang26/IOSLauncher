package defpackage;

import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class a9 extends AbstractSet {
    public final /* synthetic */ e9 g;

    public a9(e9 e9Var) {
        this.g = e9Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new d9(this.g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.g.i;
    }
}
