package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class fy0 implements bj0 {
    public final Object b;

    public fy0(Object obj) {
        n90.h(obj, "Argument must not be null");
        this.b = obj;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(bj0.a));
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof fy0) {
            return this.b.equals(((fy0) obj).b);
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
