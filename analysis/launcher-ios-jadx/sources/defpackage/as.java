package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class as implements bj0 {
    public final bj0 b;
    public final bj0 c;

    public as(bj0 bj0Var, bj0 bj0Var2) {
        this.b = bj0Var;
        this.c = bj0Var2;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof as) {
            as asVar = (as) obj;
            if (this.b.equals(asVar.b) && this.c.equals(asVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
