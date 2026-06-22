package defpackage;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class ln {
    public final Uri a;
    public final boolean b;

    public ln(Uri uri, boolean z) {
        this.a = uri;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!ln.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        qg0.i(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
        ln lnVar = (ln) obj;
        return qg0.d(this.a, lnVar.a) && this.b == lnVar.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1231 : 1237);
    }
}
