package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class fc {
    public final Bitmap a;
    public final Uri b;
    public final Exception c;
    public final int d;

    public fc(int i, Bitmap bitmap) {
        this.a = bitmap;
        this.b = null;
        this.c = null;
        this.d = i;
    }

    public fc(Uri uri, int i) {
        this.a = null;
        this.b = uri;
        this.c = null;
        this.d = i;
    }

    public fc(Exception exc) {
        this.a = null;
        this.b = null;
        this.c = exc;
        this.d = 1;
    }
}
