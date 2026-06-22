package defpackage;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class fm1 {
    public final String a;
    public final String b;
    public final boolean c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;

    public fm1(int i, String str, String str2, String str3, boolean z, int i2) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = i;
        this.e = str3;
        this.f = i2;
        Locale locale = Locale.US;
        qg0.k(locale, "US");
        String upperCase = str2.toUpperCase(locale);
        qg0.k(upperCase, "this as java.lang.String).toUpperCase(locale)");
        this.g = hk1.F(upperCase, "INT") ? 3 : (hk1.F(upperCase, "CHAR") || hk1.F(upperCase, "CLOB") || hk1.F(upperCase, "TEXT")) ? 2 : hk1.F(upperCase, "BLOB") ? 5 : (hk1.F(upperCase, "REAL") || hk1.F(upperCase, "FLOA") || hk1.F(upperCase, "DOUB")) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof fm1)) {
                return false;
            }
            fm1 fm1Var = (fm1) obj;
            if (this.d != fm1Var.d) {
                return false;
            }
            if (!this.a.equals(fm1Var.a) || this.c != fm1Var.c) {
                return false;
            }
            int i = fm1Var.f;
            String str = fm1Var.e;
            String str2 = this.e;
            int i2 = this.f;
            if (i2 == 1 && i == 2 && str2 != null && !wd.q(str2, str)) {
                return false;
            }
            if (i2 == 2 && i == 1 && str != null && !wd.q(str, str2)) {
                return false;
            }
            if (i2 != 0 && i2 == i) {
                if (str2 != null) {
                    if (!wd.q(str2, str)) {
                        return false;
                    }
                } else if (str != null) {
                    return false;
                }
            }
            if (this.g != fm1Var.g) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.g) * 31) + (this.c ? 1231 : 1237)) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Column{name='");
        sb.append(this.a);
        sb.append("', type='");
        sb.append(this.b);
        sb.append("', affinity='");
        sb.append(this.g);
        sb.append("', notNull=");
        sb.append(this.c);
        sb.append(", primaryKeyPosition=");
        sb.append(this.d);
        sb.append(", defaultValue='");
        String str = this.e;
        if (str == null) {
            str = "undefined";
        }
        return uo.k(sb, str, "'}");
    }
}
