package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class k80 {
    public final AbstractCollection a;

    /* JADX WARN: Multi-variable type inference failed */
    public k80(List list) {
        qg0.l(list, "topics");
        this.a = (AbstractCollection) list;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractCollection, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.AbstractCollection, java.util.List] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k80)) {
            return false;
        }
        ?? r0 = this.a;
        k80 k80Var = (k80) obj;
        if (r0.size() != k80Var.a.size()) {
            return false;
        }
        return new HashSet((Collection) r0).equals(new HashSet(k80Var.a));
    }

    public final int hashCode() {
        return Objects.hash(this.a);
    }

    public final String toString() {
        return "Topics=" + this.a;
    }
}
