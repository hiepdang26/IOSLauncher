package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class o10 {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public o10(int i, byte[] bArr, int i2) {
        this(-1L, bArr, i, i2);
    }

    public static o10 a(long j, ByteOrder byteOrder) {
        long[] jArr = {j};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[s10.E[4]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putInt((int) jArr[0]);
        return new o10(4, byteBufferWrap.array(), 1);
    }

    public static o10 b(q10 q10Var, ByteOrder byteOrder) {
        q10[] q10VarArr = {q10Var};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[s10.E[5]]);
        byteBufferWrap.order(byteOrder);
        q10 q10Var2 = q10VarArr[0];
        byteBufferWrap.putInt((int) q10Var2.a);
        byteBufferWrap.putInt((int) q10Var2.b);
        return new o10(5, byteBufferWrap.array(), 1);
    }

    public static o10 c(int i, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[s10.E[3]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putShort((short) new int[]{i}[0]);
        return new o10(3, byteBufferWrap.array(), 1);
    }

    public final double d(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objG instanceof String) {
            return Double.parseDouble((String) objG);
        }
        if (objG instanceof long[]) {
            if (((long[]) objG).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objG instanceof int[]) {
            if (((int[]) objG).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objG instanceof double[]) {
            double[] dArr = (double[]) objG;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objG instanceof q10[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        q10[] q10VarArr = (q10[]) objG;
        if (q10VarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        q10 q10Var = q10VarArr[0];
        return q10Var.a / q10Var.b;
    }

    public final int e(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objG instanceof String) {
            return Integer.parseInt((String) objG);
        }
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objG instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objG;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String f(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            return null;
        }
        if (objG instanceof String) {
            return (String) objG;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objG instanceof int[]) {
            int[] iArr = (int[]) objG;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objG instanceof double[]) {
            double[] dArr = (double[]) objG;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objG instanceof q10[])) {
            return null;
        }
        q10[] q10VarArr = (q10[]) objG;
        while (i < q10VarArr.length) {
            sb.append(q10VarArr[i].a);
            sb.append('/');
            sb.append(q10VarArr[i].b);
            i++;
            if (i != q10VarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:60|(2:62|(2:63|(2:65|(2:144|67)(1:68))(2:143|69)))|70|(2:72|(6:146|74|80|118|81|82)(3:75|(2:77|148)(2:78|147)|79))|145|80|118|81|82) */
    /* JADX WARN: Type inference failed for: r13v17, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v18, types: [java.io.Serializable, long[]] */
    /* JADX WARN: Type inference failed for: r13v19, types: [java.io.Serializable, q10[]] */
    /* JADX WARN: Type inference failed for: r13v20, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v21, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v22, types: [java.io.Serializable, q10[]] */
    /* JADX WARN: Type inference failed for: r13v23, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v24, types: [double[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable g(java.nio.ByteOrder r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o10.g(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(s10.D[this.a]);
        sb.append(", data length:");
        return uo.j(sb, this.d.length, ")");
    }

    public o10(long j, byte[] bArr, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }
}
