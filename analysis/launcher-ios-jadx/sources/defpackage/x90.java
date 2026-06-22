package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class x90 implements bj0 {
    public final gm0 b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public x90(URL url) {
        gm0 gm0Var = pb0.a;
        n90.h(url, "Argument must not be null");
        this.c = url;
        this.d = null;
        n90.h(gm0Var, "Argument must not be null");
        this.b = gm0Var;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = c().getBytes(bj0.a);
        }
        messageDigest.update(this.g);
    }

    public final String c() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        URL url = this.c;
        n90.h(url, "Argument must not be null");
        return url.toString();
    }

    public final URL d() {
        if (this.f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String string = this.d;
                if (TextUtils.isEmpty(string)) {
                    URL url = this.c;
                    n90.h(url, "Argument must not be null");
                    string = url.toString();
                }
                this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f = new URL(this.e);
        }
        return this.f;
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (!(obj instanceof x90)) {
            return false;
        }
        x90 x90Var = (x90) obj;
        return c().equals(x90Var.c()) && this.b.equals(x90Var.b);
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        if (this.h == 0) {
            int iHashCode = c().hashCode();
            this.h = iHashCode;
            this.h = this.b.b.hashCode() + (iHashCode * 31);
        }
        return this.h;
    }

    public final String toString() {
        return c();
    }

    public x90(String str) {
        gm0 gm0Var = pb0.a;
        this.c = null;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            n90.h(gm0Var, "Argument must not be null");
            this.b = gm0Var;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
