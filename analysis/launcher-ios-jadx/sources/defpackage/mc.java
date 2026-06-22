package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class mc {
    public final Uri a;
    public final Bitmap b;
    public final int c;
    public final int d;
    public final Exception e;

    public mc(Uri uri, Bitmap bitmap, int i, int i2) {
        this.a = uri;
        this.b = bitmap;
        this.c = i;
        this.d = i2;
        this.e = null;
    }

    public mc(Uri uri, Exception exc) {
        this.a = uri;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = exc;
    }
}
