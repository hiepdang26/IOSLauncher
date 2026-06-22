package defpackage;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class bp0 {
    public static final /* synthetic */ int b = 0;
    public final dp0 a;

    static {
        Locale[] localeArr = new Locale[0];
        if (Build.VERSION.SDK_INT >= 24) {
            ep0.i(sl.b(localeArr));
        } else {
            new cp0(localeArr);
        }
    }

    public bp0(dp0 dp0Var) {
        this.a = dp0Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bp0) {
            return this.a.equals(((bp0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
