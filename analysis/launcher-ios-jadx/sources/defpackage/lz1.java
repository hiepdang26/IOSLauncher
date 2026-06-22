package defpackage;

import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.work.OverwritingInputMerger;

/* JADX INFO: loaded from: classes.dex */
public final class lz1 {
    public final String a;
    public int b;
    public final String c;
    public final String d;
    public wr e;
    public final wr f;
    public final long g;
    public final long h;
    public final long i;
    public nn j;
    public final int k;
    public final int l;
    public final long m;
    public long n;
    public final long o;
    public final long p;
    public boolean q;
    public final int r;
    public final int s;
    public final int t;
    public final long u;
    public final int v;
    public final int w;

    static {
        qg0.k(ka0.r("WorkSpec"), "tagWithPrefix(\"WorkSpec\")");
    }

    public lz1(String str, int i, String str2, String str3, wr wrVar, wr wrVar2, long j, long j2, long j3, nn nnVar, int i2, int i3, long j4, long j5, long j6, long j7, boolean z, int i4, int i5, int i6, long j8, int i7, int i8) {
        qg0.l(str, "id");
        uo.p(i, "state");
        qg0.l(str2, "workerClassName");
        qg0.l(str3, "inputMergerClassName");
        qg0.l(wrVar, "input");
        qg0.l(wrVar2, "output");
        qg0.l(nnVar, "constraints");
        uo.p(i3, "backoffPolicy");
        uo.p(i4, "outOfQuotaPolicy");
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = wrVar;
        this.f = wrVar2;
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = nnVar;
        this.k = i2;
        this.l = i3;
        this.m = j4;
        this.n = j5;
        this.o = j6;
        this.p = j7;
        this.q = z;
        this.r = i4;
        this.s = i5;
        this.t = i6;
        this.u = j8;
        this.v = i7;
        this.w = i8;
    }

    public final long a() {
        boolean z = this.b == 1 && this.k > 0;
        long j = this.n;
        boolean zC = c();
        int i = this.l;
        uo.p(i, "backoffPolicy");
        int i2 = this.s;
        long j2 = this.u;
        if (j2 != Long.MAX_VALUE && zC) {
            if (i2 != 0) {
                long j3 = j + 900000;
                if (j2 < j3) {
                    return j3;
                }
            }
            return j2;
        }
        if (z) {
            int i3 = this.k;
            long j4 = this.m;
            long jScalb = i == 2 ? j4 * ((long) i3) : (long) Math.scalb(j4, i3 - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j + jScalb;
        }
        long j5 = this.g;
        if (!zC) {
            if (j == -1) {
                return Long.MAX_VALUE;
            }
            return j + j5;
        }
        long j6 = this.h;
        long j7 = i2 == 0 ? j + j5 : j + j6;
        long j8 = this.i;
        return (j8 == j6 || i2 != 0) ? j7 : (j6 - j8) + j7;
    }

    public final boolean b() {
        return !qg0.d(nn.i, this.j);
    }

    public final boolean c() {
        return this.h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lz1)) {
            return false;
        }
        lz1 lz1Var = (lz1) obj;
        return qg0.d(this.a, lz1Var.a) && this.b == lz1Var.b && qg0.d(this.c, lz1Var.c) && qg0.d(this.d, lz1Var.d) && qg0.d(this.e, lz1Var.e) && qg0.d(this.f, lz1Var.f) && this.g == lz1Var.g && this.h == lz1Var.h && this.i == lz1Var.i && qg0.d(this.j, lz1Var.j) && this.k == lz1Var.k && this.l == lz1Var.l && this.m == lz1Var.m && this.n == lz1Var.n && this.o == lz1Var.o && this.p == lz1Var.p && this.q == lz1Var.q && this.r == lz1Var.r && this.s == lz1Var.s && this.t == lz1Var.t && this.u == lz1Var.u && this.v == lz1Var.v && this.w == lz1Var.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    public final int hashCode() {
        int iHashCode = (this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((uo.v(this.b) + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        long j = this.g;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.h;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.i;
        int iV = (uo.v(this.l) + ((((this.j.hashCode() + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.k) * 31)) * 31;
        long j4 = this.m;
        int i3 = (iV + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.n;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.o;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.p;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        boolean z = this.q;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iV2 = (((((uo.v(this.r) + ((i6 + r2) * 31)) * 31) + this.s) * 31) + this.t) * 31;
        long j8 = this.u;
        return ((((iV2 + ((int) ((j8 >>> 32) ^ j8))) * 31) + this.v) * 31) + this.w;
    }

    public final String toString() {
        return "{WorkSpec: " + this.a + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ lz1(String str, int i, String str2, String str3, wr wrVar, wr wrVar2, long j, long j2, long j3, nn nnVar, int i2, int i3, long j4, long j5, long j6, long j7, boolean z, int i4, int i5, long j8, int i6, int i7, int i8) {
        wr wrVar3;
        wr wrVar4;
        int i9 = (i8 & 2) != 0 ? 1 : i;
        String name = (i8 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3;
        if ((i8 & 16) != 0) {
            wr wrVar5 = wr.b;
            qg0.k(wrVar5, "EMPTY");
            wrVar3 = wrVar5;
        } else {
            wrVar3 = wrVar;
        }
        if ((i8 & 32) != 0) {
            wr wrVar6 = wr.b;
            qg0.k(wrVar6, "EMPTY");
            wrVar4 = wrVar6;
        } else {
            wrVar4 = wrVar2;
        }
        this(str, i9, str2, name, wrVar3, wrVar4, (i8 & 64) != 0 ? 0L : j, (i8 & 128) != 0 ? 0L : j2, (i8 & MotionScene.Transition.TransitionOnClick.JUMP_TO_END) != 0 ? 0L : j3, (i8 & 512) != 0 ? nn.i : nnVar, (i8 & 1024) != 0 ? 0 : i2, (i8 & 2048) != 0 ? 1 : i3, (i8 & MotionScene.Transition.TransitionOnClick.JUMP_TO_START) != 0 ? 30000L : j4, (i8 & 8192) != 0 ? -1L : j5, (i8 & 16384) == 0 ? j6 : 0L, (32768 & i8) != 0 ? -1L : j7, (65536 & i8) != 0 ? false : z, (131072 & i8) != 0 ? 1 : i4, (262144 & i8) != 0 ? 0 : i5, 0, (1048576 & i8) != 0 ? Long.MAX_VALUE : j8, (2097152 & i8) != 0 ? 0 : i6, (i8 & 4194304) != 0 ? -256 : i7);
    }
}
