package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class gf {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    static {
        ff ffVar = new ff();
        ffVar.a = true;
        new gf(ffVar);
        ff ffVar2 = new ff();
        ffVar2.c = true;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        long seconds = timeUnit.toSeconds(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (seconds <= 2147483647L) {
            i = (int) seconds;
        }
        ffVar2.b = i;
        new gf(ffVar2);
    }

    public gf(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.gf a(defpackage.ob0 r23) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gf.a(ob0):gf");
    }

    public final String toString() {
        String string;
        String str = this.m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        int i = this.c;
        if (i != -1) {
            sb.append("max-age=");
            sb.append(i);
            sb.append(", ");
        }
        int i2 = this.d;
        if (i2 != -1) {
            sb.append("s-maxage=");
            sb.append(i2);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        int i3 = this.h;
        if (i3 != -1) {
            sb.append("max-stale=");
            sb.append(i3);
            sb.append(", ");
        }
        int i4 = this.i;
        if (i4 != -1) {
            sb.append("min-fresh=");
            sb.append(i4);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            string = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            string = sb.toString();
        }
        this.m = string;
        return string;
    }

    public gf(ff ffVar) {
        this.a = ffVar.a;
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = ffVar.b;
        this.i = -1;
        this.j = ffVar.c;
        this.k = false;
        this.l = false;
    }
}
