package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class h9 extends z71 {
    public static void A(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        qg0.l(iArr, "<this>");
        qg0.l(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static void B(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        qg0.l(objArr, "<this>");
        qg0.l(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static /* synthetic */ void C(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        B(objArr, 0, objArr2, i, i2);
    }

    public static Object[] D(int i, int i2, Object[] objArr) {
        qg0.l(objArr, "<this>");
        int length = objArr.length;
        if (i2 <= length) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
            qg0.k(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + length + ").");
    }

    public static final void E(Object[] objArr, wg1 wg1Var, int i, int i2) {
        qg0.l(objArr, "<this>");
        Arrays.fill(objArr, i, i2, wg1Var);
    }
}
