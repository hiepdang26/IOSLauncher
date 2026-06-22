package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class lv1 {
    public static final float[] l = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public final float[] a = new float[18];
    public final boolean b;
    public final FloatBuffer c;
    public final FloatBuffer d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final float i;
    public final int j;
    public final int[] k;

    public lv1(Bitmap bitmap) {
        this.b = false;
        this.e = 1;
        this.f = 1;
        this.g = 0;
        this.h = 0;
        int i = m;
        this.j = i;
        if (bitmap == null) {
            return;
        }
        this.j = i;
        this.b = true;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(72).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.position(0);
        this.c = floatBufferAsFloatBuffer;
        float[] fArr = l;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.position(0);
        floatBufferAsFloatBuffer2.put(fArr);
        floatBufferAsFloatBuffer2.position(0);
        this.d = floatBufferAsFloatBuffer2;
        int width = bitmap.getWidth();
        this.g = width;
        int height = bitmap.getHeight();
        this.h = height;
        this.i = width / height;
        int i2 = height % i;
        int i3 = i + 1;
        int i4 = (width / i3) + 1;
        this.e = i4;
        int i5 = (height / i3) + 1;
        this.f = i5;
        int[] iArr = new int[i4 * i5];
        this.k = iArr;
        if (i4 == 1 && i5 == 1) {
            iArr[0] = m90.m(bitmap);
        } else {
            Rect rect = new Rect();
            for (int i6 = 0; i6 < this.f; i6++) {
                int i7 = 0;
                while (i7 < this.e) {
                    int i8 = this.j;
                    int i9 = this.f - i6;
                    int i10 = i7 + 1;
                    rect.set(i7 * i8, (i9 - 1) * i8, i10 * i8, i9 * i8);
                    if (i2 > 0) {
                        rect.offset(0, (-this.j) + i2);
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
                    this.k[(this.e * i6) + i7] = m90.m(bitmapCreateBitmap);
                    bitmapCreateBitmap.recycle();
                    i7 = i10;
                }
            }
        }
        bitmap.recycle();
    }

    public final void a(float[] fArr) {
        FloatBuffer floatBuffer = this.c;
        int i = this.h;
        int i2 = this.g;
        float f = this.i;
        int i3 = this.j;
        float[] fArr2 = this.a;
        try {
            if (this.b) {
                GLES20.glUseProgram(n);
                char c = 0;
                GLES20.glUniformMatrix4fv(r, 1, false, fArr, 0);
                m90.c("glUniformMatrix4fv");
                GLES20.glEnableVertexAttribArray(o);
                GLES20.glVertexAttribPointer(o, 3, 5126, false, 12, (Buffer) this.c);
                GLES20.glActiveTexture(33984);
                GLES20.glUniform1i(q, 0);
                GLES20.glVertexAttribPointer(p, 2, 5126, false, 8, (Buffer) this.d);
                GLES20.glEnableVertexAttribArray(p);
                int i4 = 0;
                while (i4 < this.f) {
                    int i5 = 0;
                    while (true) {
                        int i6 = this.e;
                        if (i5 < i6) {
                            float f2 = -f;
                            float f3 = i3;
                            float f4 = i2;
                            float fMin = Math.min((((i5 * 2.0f) * f3) / f4) - 1.0f, 1.0f) * f2;
                            fArr2[9] = fMin;
                            fArr2[3] = fMin;
                            fArr2[c] = fMin;
                            float f5 = i;
                            float fMin2 = Math.min(((((i4 + 1) * 2.0f) * f3) / f5) - 1.0f, 1.0f);
                            fArr2[16] = fMin2;
                            fArr2[10] = fMin2;
                            fArr2[1] = fMin2;
                            float fMin3 = f2 * Math.min((((r13 * 2.0f) * f3) / f4) - 1.0f, 1.0f);
                            fArr2[15] = fMin3;
                            fArr2[12] = fMin3;
                            fArr2[6] = fMin3;
                            float fMin4 = Math.min((((i4 * 2.0f) * f3) / f5) - 1.0f, 1.0f);
                            fArr2[13] = fMin4;
                            fArr2[7] = fMin4;
                            fArr2[4] = fMin4;
                            floatBuffer.put(fArr2);
                            floatBuffer.position(0);
                            GLES20.glBindTexture(3553, this.k[(i6 * i4) + i5]);
                            m90.c("glBindTexture");
                            GLES20.glDrawArrays(4, 0, fArr2.length / 3);
                            i5++;
                            c = 0;
                        }
                    }
                    i4++;
                    c = 0;
                }
                GLES20.glDisableVertexAttribArray(o);
                GLES20.glDisableVertexAttribArray(p);
            }
        } catch (Throwable unused) {
        }
    }
}
