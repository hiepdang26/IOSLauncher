package defpackage;

import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public final class x2 {
    public int a;
    public int b;
    public Preference c;
    public int d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof x2)) {
                return false;
            }
            x2 x2Var = (x2) obj;
            int i = this.a;
            if (i != x2Var.a) {
                return false;
            }
            if (i != 8 || Math.abs(this.d - this.b) != 1 || this.d != x2Var.b || this.b != x2Var.d) {
                if (this.d != x2Var.d || this.b != x2Var.b) {
                    return false;
                }
                Preference preference = this.c;
                if (preference != null) {
                    if (!preference.equals(x2Var.c)) {
                        return false;
                    }
                } else if (x2Var.c != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i = this.a;
        sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.b);
        sb.append("c:");
        sb.append(this.d);
        sb.append(",p:");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
