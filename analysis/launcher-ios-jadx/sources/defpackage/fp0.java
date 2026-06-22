package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class fp0 implements dp0 {
    public final LocaleList a;

    public fp0(Object obj) {
        this.a = ep0.i(obj);
    }

    @Override // defpackage.dp0
    public final Object a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        return this.a.equals(((dp0) obj).a());
    }

    @Override // defpackage.dp0
    public final Locale get() {
        return this.a.get(0);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
