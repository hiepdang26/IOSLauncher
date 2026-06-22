package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class n62 extends j42 {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public n62(Context context) {
        this.b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
    @Override // defpackage.j42
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza() {
        /*
            r7 = this;
            int r0 = r7.a
            switch(r0) {
                case 0: goto L93;
                default: goto L5;
            }
        L5:
            hd2 r0 = defpackage.hd2.B
            bm r0 = r0.v
            java.lang.Object r1 = r7.b
            yb2 r1 = (defpackage.yb2) r1
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r1.h
            sb2 r2 = r2.u
            int r2 = r2.l
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.util.concurrent.ConcurrentHashMap r0 = r0.a
            java.lang.Object r0 = r0.get(r2)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto L92
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r1.h
            sb2 r2 = r2.u
            boolean r3 = r2.j
            android.app.Activity r1 = r1.g
            if (r3 == 0) goto L7e
            r3 = 0
            float r2 = r2.k
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L7e
            r3 = 1103626240(0x41c80000, float:25.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L39
            goto L7e
        L39:
            int r3 = r0.getWidth()     // Catch: java.lang.RuntimeException -> L74
            int r4 = r0.getHeight()     // Catch: java.lang.RuntimeException -> L74
            r5 = 0
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r0, r3, r4, r5)     // Catch: java.lang.RuntimeException -> L74
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3)     // Catch: java.lang.RuntimeException -> L74
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r1)     // Catch: java.lang.RuntimeException -> L74
            android.renderscript.Element r6 = android.renderscript.Element.U8_4(r5)     // Catch: java.lang.RuntimeException -> L74
            android.renderscript.ScriptIntrinsicBlur r6 = android.renderscript.ScriptIntrinsicBlur.create(r5, r6)     // Catch: java.lang.RuntimeException -> L74
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r5, r3)     // Catch: java.lang.RuntimeException -> L74
            android.renderscript.Allocation r5 = android.renderscript.Allocation.createFromBitmap(r5, r4)     // Catch: java.lang.RuntimeException -> L74
            r6.setRadius(r2)     // Catch: java.lang.RuntimeException -> L74
            r6.setInput(r3)     // Catch: java.lang.RuntimeException -> L74
            r6.forEach(r5)     // Catch: java.lang.RuntimeException -> L74
            r5.copyTo(r4)     // Catch: java.lang.RuntimeException -> L74
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.RuntimeException -> L74
            android.content.res.Resources r3 = r1.getResources()     // Catch: java.lang.RuntimeException -> L74
            r2.<init>(r3, r4)     // Catch: java.lang.RuntimeException -> L74
            goto L87
        L74:
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r1 = r1.getResources()
            r2.<init>(r1, r0)
            goto L87
        L7e:
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r1 = r1.getResources()
            r2.<init>(r1, r0)
        L87:
            ja2 r0 = defpackage.cd2.l
            gb2 r1 = new gb2
            r3 = 3
            r1.<init>(r7, r2, r3)
            r0.post(r1)
        L92:
            return
        L93:
            java.lang.Object r0 = r7.b     // Catch: java.lang.Throwable -> L9c
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> L9c
            boolean r0 = defpackage.f3.b(r0)     // Catch: java.lang.Throwable -> L9c
            goto La0
        L9c:
            defpackage.k92.f()
            r0 = 0
        La0:
            java.lang.Object r1 = defpackage.ub2.b
            monitor-enter(r1)
            r2 = 1
            defpackage.ub2.c = r2     // Catch: java.lang.Throwable -> Lbb
            defpackage.ub2.d = r0     // Catch: java.lang.Throwable -> Lbb
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Update ad debug logging enablement as "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            defpackage.k92.h(r0)
            return
        Lbb:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbb
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n62.zza():void");
    }

    public /* synthetic */ n62(yb2 yb2Var) {
        this.b = yb2Var;
    }
}
