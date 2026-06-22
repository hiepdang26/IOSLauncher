package defpackage;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class r extends AbstractSet implements Set {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
