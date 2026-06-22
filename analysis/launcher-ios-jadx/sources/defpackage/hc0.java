package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class hc0 {
    public final fe a;
    public boolean c;
    public int b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public ib0[] e = new ib0[8];
    public int f = 7;
    public int g = 0;
    public int h = 0;
    public int d = MotionScene.Transition.TransitionOnClick.JUMP_TO_START;

    public hc0(fe feVar) {
        this.a = feVar;
    }

    public final void a(int i) {
        int i2;
        if (i > 0) {
            int length = this.e.length - 1;
            int i3 = 0;
            while (true) {
                i2 = this.f;
                if (length < i2 || i <= 0) {
                    break;
                }
                int i4 = this.e[length].c;
                i -= i4;
                this.h -= i4;
                this.g--;
                i3++;
                length--;
            }
            ib0[] ib0VarArr = this.e;
            int i5 = i2 + 1;
            System.arraycopy(ib0VarArr, i5, ib0VarArr, i5 + i3, this.g);
            ib0[] ib0VarArr2 = this.e;
            int i6 = this.f + 1;
            Arrays.fill(ib0VarArr2, i6, i6 + i3, (Object) null);
            this.f += i3;
        }
    }

    public final void b(ib0 ib0Var) {
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

    public final void c(df dfVar) {
        qd0.d.getClass();
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < dfVar.i(); i++) {
            j2 += (long) qd0.c[dfVar.d(i) & 255];
        }
        int i2 = (int) ((j2 + 7) >> 3);
        int i3 = dfVar.i();
        fe feVar = this.a;
        if (i2 >= i3) {
            e(dfVar.i(), 127, 0);
            dfVar.m(feVar);
            return;
        }
        fe feVar2 = new fe();
        qd0.d.getClass();
        int i4 = 0;
        for (int i5 = 0; i5 < dfVar.i(); i5++) {
            int iD = dfVar.d(i5) & 255;
            int i6 = qd0.b[iD];
            byte b = qd0.c[iD];
            j = (j << b) | ((long) i6);
            i4 += b;
            while (i4 >= 8) {
                i4 -= 8;
                feVar2.K((int) (j >> i4));
            }
        }
        if (i4 > 0) {
            feVar2.K((int) ((j << (8 - i4)) | ((long) (255 >>> i4))));
        }
        byte[] bArrJ = feVar2.j();
        df dfVar2 = new df(bArrJ);
        e(bArrJ.length, 127, 128);
        dfVar2.m(feVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.util.ArrayList r14) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hc0.d(java.util.ArrayList):void");
    }

    public final void e(int i, int i2, int i3) {
        fe feVar = this.a;
        if (i < i2) {
            feVar.K(i | i3);
            return;
        }
        feVar.K(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            feVar.K(128 | (i4 & 127));
            i4 >>>= 7;
        }
        feVar.K(i4);
    }
}
