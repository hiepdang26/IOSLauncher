package defpackage;

import android.text.TextUtils;
import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public final class b31 {
    public final int a;
    public final int b;
    public final String c;

    public b31(Preference preference) {
        this.c = preference.getClass().getName();
        this.a = preference.J;
        this.b = preference.K;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b31)) {
            return false;
        }
        b31 b31Var = (b31) obj;
        return this.a == b31Var.a && this.b == b31Var.b && TextUtils.equals(this.c, b31Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((((527 + this.a) * 31) + this.b) * 31);
    }
}
