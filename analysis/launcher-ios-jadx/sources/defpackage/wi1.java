package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class wi1 {
    public int[] a;
    public final v21 c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public final int[] j;
    public int k;
    public s80 l;
    public Bitmap m;
    public final boolean n;
    public int o;
    public final int p;
    public final int q;
    public final int r;
    public Boolean s;
    public final int[] b = new int[MotionScene.Transition.TransitionOnClick.JUMP_TO_END];
    public Bitmap.Config t = Bitmap.Config.ARGB_8888;

    public wi1(v21 v21Var, s80 s80Var, ByteBuffer byteBuffer, int i) {
        this.c = v21Var;
        this.l = new s80();
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int iHighestOneBit = Integer.highestOneBit(i);
                int i2 = 0;
                this.o = 0;
                this.l = s80Var;
                this.k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.d.order(ByteOrder.LITTLE_ENDIAN);
                this.n = false;
                ArrayList arrayList = s80Var.e;
                int size = arrayList.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i2);
                    i2++;
                    if (((o80) obj).g == 3) {
                        this.n = true;
                        break;
                    }
                }
                this.p = iHighestOneBit;
                int i3 = s80Var.f;
                this.r = i3 / iHighestOneBit;
                int i4 = s80Var.g;
                this.q = i4 / iHighestOneBit;
                int i5 = i3 * i4;
                cq0 cq0Var = (cq0) this.c.i;
                this.i = cq0Var == null ? new byte[i5] : (byte[]) cq0Var.d(i5, byte[].class);
                v21 v21Var2 = this.c;
                int i6 = this.r * this.q;
                cq0 cq0Var2 = (cq0) v21Var2.i;
                this.j = cq0Var2 == null ? new int[i6] : (int[]) cq0Var2.d(i6, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.s;
        Bitmap bitmapE = ((oc) this.c.h).e(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapE.setHasAlpha(true);
        return bitmapE;
    }

    public final synchronized Bitmap b() {
        try {
            if (this.l.c <= 0 || this.k < 0) {
                if (Log.isLoggable("wi1", 3)) {
                    int i = this.l.c;
                }
                this.o = 1;
            }
            int i2 = this.o;
            if (i2 != 1 && i2 != 2) {
                this.o = 0;
                if (this.e == null) {
                    cq0 cq0Var = (cq0) this.c.i;
                    this.e = cq0Var == null ? new byte[255] : (byte[]) cq0Var.d(255, byte[].class);
                }
                o80 o80Var = (o80) this.l.e.get(this.k);
                int i3 = this.k - 1;
                o80 o80Var2 = i3 >= 0 ? (o80) this.l.e.get(i3) : null;
                int[] iArr = o80Var.k;
                if (iArr == null) {
                    iArr = this.l.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    Log.isLoggable("wi1", 3);
                    this.o = 1;
                    return null;
                }
                if (o80Var.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.a = iArr2;
                    iArr2[o80Var.h] = 0;
                    if (o80Var.g == 2 && this.k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return d(o80Var, o80Var2);
            }
            Log.isLoggable("wi1", 3);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v19, types: [short] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap d(defpackage.o80 r36, defpackage.o80 r37) {
        /*
            Method dump skipped, instruction units count: 1055
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wi1.d(o80, o80):android.graphics.Bitmap");
    }
}
