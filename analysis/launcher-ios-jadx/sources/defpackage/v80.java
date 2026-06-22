package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLES30;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v80 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ y80 h;

    public /* synthetic */ v80(y80 y80Var, int i) {
        this.g = i;
        this.h = y80Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.requestRender();
                break;
            case 1:
                y80 y80Var = this.h;
                int i = y80Var.n;
                int i2 = 1;
                if (i != 0) {
                    int[] iArr = y80Var.Q;
                    iArr[0] = i;
                    if (y80Var.M == 3) {
                        GLES20.glDeleteTextures(1, iArr, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr, 0);
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Context context = y80Var.g;
                BitmapFactory.decodeResource(context.getResources(), y80Var.G, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int i5 = y80Var.k;
                int i6 = y80Var.l;
                if (i4 > i6 || i3 > i5) {
                    int i7 = i4 / 2;
                    int i8 = i3 / 2;
                    while (i7 / i2 >= i6 && i8 / i2 >= i5) {
                        i2 *= 2;
                    }
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = i2;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                try {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), y80Var.G, options);
                    if (bitmapDecodeResource != null) {
                        y80Var.n = y80Var.d(bitmapDecodeResource);
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 2:
                y80 y80Var2 = this.h;
                if (y80Var2.M == 3) {
                    int i9 = y80Var2.P;
                    if (i9 != 0) {
                        int[] iArr2 = y80Var2.Q;
                        iArr2[0] = i9;
                        GLES30.glDeleteVertexArrays(1, iArr2, 0);
                        y80Var2.P = 0;
                    }
                    int i10 = y80Var2.N;
                    if (i10 != 0) {
                        int[] iArr3 = y80Var2.Q;
                        iArr3[0] = i10;
                        GLES20.glDeleteBuffers(1, iArr3, 0);
                        y80Var2.N = 0;
                    }
                    int i11 = y80Var2.O;
                    if (i11 != 0) {
                        int[] iArr4 = y80Var2.Q;
                        iArr4[0] = i11;
                        GLES20.glDeleteBuffers(1, iArr4, 0);
                        y80Var2.O = 0;
                    }
                } else {
                    int i12 = y80Var2.N;
                    if (i12 != 0) {
                        int[] iArr5 = y80Var2.Q;
                        iArr5[0] = i12;
                        GLES20.glDeleteBuffers(1, iArr5, 0);
                        y80Var2.N = 0;
                    }
                    int i13 = y80Var2.O;
                    if (i13 != 0) {
                        int[] iArr6 = y80Var2.Q;
                        iArr6[0] = i13;
                        GLES20.glDeleteBuffers(1, iArr6, 0);
                        y80Var2.O = 0;
                    }
                }
                int i14 = y80Var2.m;
                if (i14 != 0) {
                    int[] iArr7 = y80Var2.Q;
                    iArr7[0] = i14;
                    if (y80Var2.M == 3) {
                        GLES20.glDeleteTextures(1, iArr7, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr7, 0);
                    }
                    y80Var2.m = 0;
                    y80Var2.p = -1;
                }
                int i15 = y80Var2.n;
                if (i15 != 0) {
                    int[] iArr8 = y80Var2.Q;
                    iArr8[0] = i15;
                    if (y80Var2.M == 3) {
                        GLES20.glDeleteTextures(1, iArr8, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr8, 0);
                    }
                    y80Var2.n = 0;
                    y80Var2.q = -1;
                }
                int i16 = y80Var2.o;
                if (i16 != 0) {
                    if (y80Var2.M == 3) {
                        GLES20.glDeleteProgram(i16);
                    } else {
                        GLES20.glDeleteProgram(i16);
                    }
                    y80Var2.o = 0;
                    y80Var2.r = -1;
                }
                break;
            case 3:
                y80 y80Var3 = this.h;
                int i17 = y80Var3.m;
                if (i17 != 0) {
                    int[] iArr9 = y80Var3.Q;
                    iArr9[0] = i17;
                    if (y80Var3.M == 3) {
                        GLES20.glDeleteTextures(1, iArr9, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr9, 0);
                    }
                }
                y80Var3.m = y80Var3.d(y80Var3.h);
                int i18 = y80Var3.G;
                if (i18 != 0) {
                    y80Var3.setSdfTexture(i18);
                }
                y80Var3.post(new v80(y80Var3, 4));
                break;
            default:
                y80 y80Var4 = this.h;
                if (y80Var4.isAttachedToWindow() && y80Var4.getVisibility() == 0) {
                    y80Var4.requestRender();
                    break;
                }
                break;
        }
    }
}
