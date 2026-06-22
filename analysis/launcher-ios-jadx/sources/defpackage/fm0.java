package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fm0 {
    public final String a;

    public fm0(String str) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof fm0) {
            return this.a.equals(((fm0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return uo.k(new StringBuilder("StringHeaderFactory{value='"), this.a, "'}");
    }
}
