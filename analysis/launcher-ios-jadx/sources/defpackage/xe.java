package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.a;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class xe implements ib1 {
    public static final iy f = new iy();
    public static final we g = new we(0);
    public final Context a;
    public final ArrayList b;
    public final we c;
    public final iy d;
    public final v21 e;

    public xe(Context context, ArrayList arrayList, oc ocVar, cq0 cq0Var) {
        iy iyVar = f;
        this.a = context.getApplicationContext();
        this.b = arrayList;
        this.d = iyVar;
        this.e = new v21(ocVar, cq0Var, 4);
        this.c = g;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:25:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // defpackage.ib1
    public final defpackage.eb1 a(java.lang.Object r8, int r9, int r10, defpackage.g01 r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            we r8 = r7.c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            t80 r0 = (defpackage.t80) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            t80 r0 = new t80     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            s80 r0 = new s80     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.c = r0     // Catch: java.lang.Throwable -> L54
            r5.d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            m80 r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            we r9 = r1.c
            r9.c(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            we r9 = r1.c
            r9.c(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xe.a(java.lang.Object, int, int, g01):eb1");
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) {
        return !((Boolean) g01Var.c(u80.b)).booleanValue() && np1.t(this.b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    public final m80 c(ByteBuffer byteBuffer, int i, int i2, t80 t80Var, g01 g01Var) {
        int i3 = tp0.a;
        SystemClock.elapsedRealtimeNanos();
        try {
            s80 s80VarB = t80Var.b();
            if (s80VarB.c > 0 && s80VarB.b == 0) {
                Bitmap.Config config = g01Var.c(u80.a) == ps.h ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iMin = Math.min(s80VarB.g / i2, s80VarB.f / i);
                int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
                Log.isLoggable("BufferGifDecoder", 2);
                iy iyVar = this.d;
                v21 v21Var = this.e;
                iyVar.getClass();
                wi1 wi1Var = new wi1(v21Var, s80VarB, byteBuffer, iMax);
                wi1Var.c(config);
                wi1Var.k = (wi1Var.k + 1) % wi1Var.l.c;
                Bitmap bitmapB = wi1Var.b();
                if (bitmapB != null) {
                    m80 m80Var = new m80(new l80(new j5(new r80(a.a(this.a), wi1Var, i, i2, bitmapB), 2)), 0);
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        SystemClock.elapsedRealtimeNanos();
                    }
                    return m80Var;
                }
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                    return null;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
        }
    }
}
