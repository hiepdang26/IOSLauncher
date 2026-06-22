package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class jb0 {
    public final String a;
    public final String b;

    public jb0(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && jb0.class == obj.getClass()) {
            jb0 jb0Var = (jb0) obj;
            if (TextUtils.equals(this.a, jb0Var.a) && TextUtils.equals(this.b, jb0Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.a);
        sb.append(",value=");
        return uo.k(sb, this.b, "]");
    }
}
