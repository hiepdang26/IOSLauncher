package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e01 {
    public static final jl1 e = new jl1(29);
    public final Object a;
    public final d01 b;
    public final String c;
    public volatile byte[] d;

    public e01(String str, Object obj, d01 d01Var) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.c = str;
        this.a = obj;
        this.b = d01Var;
    }

    public static e01 a(Object obj, String str) {
        return new e01(str, obj, e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e01) {
            return this.c.equals(((e01) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return uo.k(new StringBuilder("Option{key='"), this.c, "'}");
    }
}
