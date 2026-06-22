package defpackage;

import android.app.WallpaperManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class sv1 extends Handler {
    public final DecelerateInterpolator a;
    public final WallpaperManager b;
    public float c;
    public boolean d;
    public long e;
    public float f;
    public float g;
    public float h;

    public sv1(Context context) {
        if (wd.A == null) {
            HandlerThread handlerThread = new HandlerThread("UiThreadHelper", -2);
            wd.A = handlerThread;
            handlerThread.start();
        }
        super(wd.A.getLooper());
        this.c = 0.5f;
        this.a = new DecelerateInterpolator(1.5f);
        this.b = WallpaperManager.getInstance(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleMessage(android.os.Message r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r13.obj
            android.os.IBinder r0 = (android.os.IBinder) r0
            if (r0 != 0) goto L8
            goto Lad
        L8:
            int r1 = r13.what
            r2 = 1056964608(0x3f000000, float:0.5)
            android.app.WallpaperManager r3 = r12.b
            r4 = 0
            r5 = 3
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 1
            if (r1 == r7) goto L47
            r8 = 2
            if (r1 == r8) goto L53
            if (r1 == r5) goto L5c
            r5 = 4
            if (r1 == r5) goto L3b
            r13 = 5
            if (r1 == r13) goto L22
            goto Lad
        L22:
            float r13 = r12.c
            float r1 = r12.g
            int r13 = java.lang.Float.compare(r13, r1)
            if (r13 == 0) goto L38
            float r13 = r12.g
            r12.c = r13
            r3.setWallpaperOffsets(r0, r13, r2)     // Catch: java.lang.Throwable -> L34
            goto L38
        L34:
            r13 = move-exception
            r13.toString()
        L38:
            r12.d = r4
            return
        L3b:
            int r13 = r13.arg1
            int r13 = r13 - r7
            float r13 = (float) r13
            float r13 = r6 / r13
            r12.h = r13
            r3.setWallpaperOffsetSteps(r13, r6)
            return
        L47:
            r12.d = r7
            float r1 = r12.c
            r12.f = r1
            long r8 = r13.getWhen()
            r12.e = r8
        L53:
            int r1 = r13.arg1
            float r1 = (float) r1
            int r13 = r13.arg2
            float r13 = (float) r13
            float r1 = r1 / r13
            r12.g = r1
        L5c:
            float r13 = r12.c
            boolean r1 = r12.d
            if (r1 == 0) goto L87
            long r8 = android.os.SystemClock.uptimeMillis()
            long r10 = r12.e
            long r8 = r8 - r10
            float r1 = (float) r8
            r10 = 1132068864(0x437a0000, float:250.0)
            float r1 = r1 / r10
            android.view.animation.DecelerateInterpolator r10 = r12.a
            float r1 = r10.getInterpolation(r1)
            float r10 = r12.f
            float r11 = r12.g
            float r1 = defpackage.uo.s(r11, r10, r1, r10)
            r12.c = r1
            r10 = 250(0xfa, double:1.235E-321)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L84
            r4 = 1
        L84:
            r12.d = r4
            goto L8b
        L87:
            float r1 = r12.g
            r12.c = r1
        L8b:
            float r1 = r12.c
            int r13 = java.lang.Float.compare(r1, r13)
            if (r13 == 0) goto La2
            float r13 = r12.c     // Catch: java.lang.Throwable -> L99
            r3.setWallpaperOffsets(r0, r13, r2)     // Catch: java.lang.Throwable -> L99
            goto L9d
        L99:
            r13 = move-exception
            r13.toString()
        L9d:
            float r13 = r12.h
            r3.setWallpaperOffsetSteps(r13, r6)
        La2:
            boolean r13 = r12.d
            if (r13 == 0) goto Lad
            android.os.Message r13 = android.os.Message.obtain(r12, r5, r0)
            r13.sendToTarget()
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sv1.handleMessage(android.os.Message):void");
    }
}
