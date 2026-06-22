package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class sc1 extends qc {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(bj0.a);
    public final int b;

    public sc1(int i) {
        n90.e("roundingRadius must be greater than 0.", i > 0);
        this.b = i;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // defpackage.qc
    public final Bitmap c(oc ocVar, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapI;
        Paint paint = to1.a;
        int i3 = this.b;
        n90.e("roundingRadius must be greater than 0.", i3 > 0);
        int i4 = Build.VERSION.SDK_INT;
        Bitmap.Config config = (i4 < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
        Bitmap.Config config2 = (i4 < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
        if (config2.equals(bitmap.getConfig())) {
            bitmapI = bitmap;
        } else {
            bitmapI = ocVar.i(bitmap.getWidth(), bitmap.getHeight(), config2);
            new Canvas(bitmapI).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        Bitmap bitmapI2 = ocVar.i(bitmapI.getWidth(), bitmapI.getHeight(), config);
        bitmapI2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapI, tileMode, tileMode);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapI2.getWidth(), bitmapI2.getHeight());
        Lock lock = to1.b;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapI2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i3;
            canvas.drawRoundRect(rectF, f, f, paint2);
            canvas.setBitmap(null);
            lock.unlock();
            if (!bitmapI.equals(bitmap)) {
                ocVar.j(bitmapI);
            }
            return bitmapI2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        return (obj instanceof sc1) && this.b == ((sc1) obj).b;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return vq1.g(-569625254, vq1.g(this.b, 17));
    }
}
