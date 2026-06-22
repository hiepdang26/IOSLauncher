package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class dh extends qc {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(bj0.a);

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.qc
    public final Bitmap c(oc ocVar, Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        Paint paint = to1.a;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapI = ocVar.i(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapI.setHasAlpha(bitmap.hasAlpha());
        to1.a(bitmap, bitmapI, matrix);
        return bitmapI;
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        return obj instanceof dh;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return -599754482;
    }
}
