package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class e30 extends qc {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(bj0.a);

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.qc
    public final Bitmap c(oc ocVar, Bitmap bitmap, int i, int i2) {
        return to1.b(ocVar, bitmap, i, i2);
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        return obj instanceof e30;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return 1572326941;
    }
}
