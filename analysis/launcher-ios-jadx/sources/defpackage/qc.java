package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class qc implements ro1 {
    @Override // defpackage.ro1
    public final eb1 a(Context context, eb1 eb1Var, int i, int i2) {
        if (!vq1.i(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        oc ocVar = a.a(context).g;
        Bitmap bitmap = (Bitmap) eb1Var.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(ocVar, bitmap, i, i2);
        return bitmap.equals(bitmapC) ? eb1Var : pc.b(ocVar, bitmapC);
    }

    public abstract Bitmap c(oc ocVar, Bitmap bitmap, int i, int i2);
}
