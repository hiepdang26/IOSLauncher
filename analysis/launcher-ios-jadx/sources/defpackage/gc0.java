package defpackage;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class gc0 {
    public final b81 b;
    public final ArrayList a = new ArrayList();
    public ib0[] e = new ib0[8];
    public int f = 7;
    public int g = 0;
    public int h = 0;
    public final int c = MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
    public int d = MotionScene.Transition.TransitionOnClick.JUMP_TO_START;

    public gc0(dd0 dd0Var) {
        Logger logger = jy0.a;
        this.b = new b81(dd0Var);
    }

    public final int a(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.e.length;
            while (true) {
                length--;
                i2 = this.f;
                if (length < i2 || i <= 0) {
                    break;
                }
                int i4 = this.e[length].c;
                i -= i4;
                this.h -= i4;
                this.g--;
                i3++;
            }
            ib0[] ib0VarArr = this.e;
            System.arraycopy(ib0VarArr, i2 + 1, ib0VarArr, i2 + 1 + i3, this.g);
            this.f += i3;
        }
        return i3;
    }

    public final df b(int i) throws IOException {
        if (i >= 0) {
            ib0[] ib0VarArr = ic0.a;
            if (i <= ib0VarArr.length - 1) {
                return ib0VarArr[i].a;
            }
        }
        int length = this.f + 1 + (i - ic0.a.length);
        if (length >= 0) {
            ib0[] ib0VarArr2 = this.e;
            if (length < ib0VarArr2.length) {
                return ib0VarArr2[length].a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(ib0 ib0Var) {
        this.a.add(ib0Var);
        int i = this.d;
        int i2 = ib0Var.c;
        if (i2 > i) {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i2) - i);
        int i3 = this.g + 1;
        ib0[] ib0VarArr = this.e;
        if (i3 > ib0VarArr.length) {
            ib0[] ib0VarArr2 = new ib0[ib0VarArr.length * 2];
            System.arraycopy(ib0VarArr, 0, ib0VarArr2, ib0VarArr.length, ib0VarArr.length);
            this.f = this.e.length - 1;
            this.e = ib0VarArr2;
        }
        int i4 = this.f;
        this.f = i4 - 1;
        this.e[i4] = ib0Var;
        this.g++;
        this.h += i2;
    }

    public final df d() {
        int i;
        b81 b81Var = this.b;
        byte bH = b81Var.h();
        int i2 = bH & 255;
        boolean z = (bH & 128) == 128;
        int iE = e(i2, 127);
        if (!z) {
            return b81Var.k(iE);
        }
        qd0 qd0Var = qd0.d;
        long j = iE;
        b81Var.C(j);
        byte[] bArrZ = b81Var.g.z(j);
        qd0Var.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bf bfVar = qd0Var.a;
        bf bfVar2 = bfVar;
        int i3 = 0;
        int i4 = 0;
        for (byte b : bArrZ) {
            i3 = (i3 << 8) | (b & 255);
            i4 += 8;
            while (i4 >= 8) {
                bfVar2 = ((bf[]) bfVar2.c)[(i3 >>> (i4 - 8)) & 255];
                if (((bf[]) bfVar2.c) == null) {
                    byteArrayOutputStream.write(bfVar2.a);
                    i4 -= bfVar2.b;
                    bfVar2 = bfVar;
                } else {
                    i4 -= 8;
                }
            }
        }
        while (i4 > 0) {
            bf bfVar3 = ((bf[]) bfVar2.c)[(i3 << (8 - i4)) & 255];
            if (((bf[]) bfVar3.c) != null || (i = bfVar3.b) > i4) {
                break;
            }
            byteArrayOutputStream.write(bfVar3.a);
            i4 -= i;
            bfVar2 = bfVar;
        }
        return df.f(byteArrayOutputStream.toByteArray());
    }

    public final int e(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            byte bH = this.b.h();
            int i5 = bH & 255;
            if ((bH & 128) == 0) {
                return i2 + (i5 << i4);
            }
            i2 += (bH & 127) << i4;
            i4 += 7;
        }
    }
}
