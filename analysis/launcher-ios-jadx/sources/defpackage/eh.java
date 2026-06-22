package defpackage;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class eh extends qc {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(bj0.a);

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.qc
    public final Bitmap c(oc ocVar, Bitmap bitmap, int i, int i2) {
        Paint paint = to1.a;
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            Log.isLoggable("TransformationUtils", 2);
            return to1.b(ocVar, bitmap, i, i2);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        return obj instanceof eh;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return -670243078;
    }
}
