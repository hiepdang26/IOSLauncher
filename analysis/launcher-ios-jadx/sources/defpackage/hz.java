package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class hz {
    public static final ThreadLocal d = new ThreadLocal();
    public final int a;
    public final hz1 b;
    public volatile int c = 0;

    public hz(hz1 hz1Var, int i) {
        this.b = hz1Var;
        this.a = i;
    }

    public final int a(int i) {
        bu0 bu0VarB = b();
        int iA = bu0VarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) bu0VarB.j;
        int i2 = iA + bu0VarB.g;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final bu0 b() {
        ThreadLocal threadLocal = d;
        bu0 bu0Var = (bu0) threadLocal.get();
        if (bu0Var == null) {
            bu0Var = new bu0();
            threadLocal.set(bu0Var);
        }
        cu0 cu0Var = (cu0) this.b.a;
        int iA = cu0Var.a(6);
        if (iA != 0) {
            int i = iA + cu0Var.g;
            int i2 = (this.a * 4) + ((ByteBuffer) cu0Var.j).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) cu0Var.j).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) cu0Var.j;
            bu0Var.j = byteBuffer;
            if (byteBuffer != null) {
                bu0Var.g = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                bu0Var.h = i4;
                bu0Var.i = ((ByteBuffer) bu0Var.j).getShort(i4);
                return bu0Var;
            }
            bu0Var.g = 0;
            bu0Var.h = 0;
            bu0Var.i = 0;
        }
        return bu0Var;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        bu0 bu0VarB = b();
        int iA = bu0VarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) bu0VarB.j).getInt(iA + bu0VarB.g) : 0));
        sb.append(", codepoints:");
        bu0 bu0VarB2 = b();
        int iA2 = bu0VarB2.a(16);
        if (iA2 != 0) {
            int i2 = iA2 + bu0VarB2.g;
            i = ((ByteBuffer) bu0VarB2.j).getInt(((ByteBuffer) bu0VarB2.j).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(a(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
