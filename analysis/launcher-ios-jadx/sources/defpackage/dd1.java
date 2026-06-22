package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class dd1 implements Map.Entry {
    public final Object g;
    public final Object h;
    public dd1 i;
    public dd1 j;

    public dd1(Object obj, Object obj2) {
        this.g = obj;
        this.h = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dd1)) {
            return false;
        }
        dd1 dd1Var = (dd1) obj;
        return this.g.equals(dd1Var.g) && this.h.equals(dd1Var.h);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.g;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.g.hashCode() ^ this.h.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.g + "=" + this.h;
    }
}
