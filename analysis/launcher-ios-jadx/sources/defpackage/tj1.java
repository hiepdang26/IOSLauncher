package defpackage;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class tj1 implements ib1 {
    public final ArrayList a;
    public final xe b;
    public final cq0 c;

    public tj1(ArrayList arrayList, xe xeVar, cq0 cq0Var) {
        this.a = arrayList;
        this.b = xeVar;
        this.c = cq0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.ib1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.eb1 a(java.lang.Object r6, int r7, int r8, defpackage.g01 r9) {
        /*
            r5 = this;
            java.io.InputStream r6 = (java.io.InputStream) r6
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 16384(0x4000, float:2.2959E-41)
            r0.<init>(r1)
            r2 = 0
            byte[] r1 = new byte[r1]     // Catch: java.io.IOException -> L20
        Lc:
            int r3 = r6.read(r1)     // Catch: java.io.IOException -> L20
            r4 = -1
            if (r3 == r4) goto L18
            r4 = 0
            r0.write(r1, r4, r3)     // Catch: java.io.IOException -> L20
            goto Lc
        L18:
            r0.flush()     // Catch: java.io.IOException -> L20
            byte[] r6 = r0.toByteArray()
            goto L27
        L20:
            java.lang.String r6 = "StreamGifDecoder"
            r0 = 5
            android.util.Log.isLoggable(r6, r0)
            r6 = r2
        L27:
            if (r6 != 0) goto L2a
            goto L34
        L2a:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            xe r0 = r5.b
            eb1 r2 = r0.a(r6, r7, r8, r9)
        L34:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tj1.a(java.lang.Object, int, int, g01):eb1");
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) {
        return !((Boolean) g01Var.c(u80.b)).booleanValue() && np1.s(this.a, (InputStream) obj, this.c) == ImageHeaderParser$ImageType.GIF;
    }
}
