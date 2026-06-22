package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.profileinstaller.ProfileVerifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class nb implements Cloneable {
    public int g;
    public int k;
    public boolean p;
    public boolean t;
    public Resources.Theme u;
    public boolean v;
    public boolean x;
    public float h = 1.0f;
    public qv i = qv.e;
    public j31 j = j31.i;
    public boolean l = true;
    public int m = -1;
    public int n = -1;
    public bj0 o = yz.b;
    public g01 q = new g01();
    public jf r = new jf(0);
    public Class s = Object.class;
    public boolean w = true;

    public static boolean j(int i, int i2) {
        return (i & i2) != 0;
    }

    public final nb A(ro1 ro1Var, boolean z) {
        if (this.v) {
            return clone().A(ro1Var, z);
        }
        ex exVar = new ex(ro1Var, z);
        B(Bitmap.class, ro1Var, z);
        B(Drawable.class, exVar, z);
        B(BitmapDrawable.class, exVar, z);
        B(l80.class, new n80(ro1Var), z);
        s();
        return this;
    }

    public final nb B(Class cls, ro1 ro1Var, boolean z) {
        if (this.v) {
            return clone().B(cls, ro1Var, z);
        }
        n90.g(ro1Var);
        this.r.put(cls, ro1Var);
        int i = this.g;
        this.g = 67584 | i;
        this.w = false;
        if (z) {
            this.g = i | 198656;
            this.p = true;
        }
        s();
        return this;
    }

    public nb C(ro1... ro1VarArr) {
        if (ro1VarArr.length > 1) {
            return A(new fv0(ro1VarArr), true);
        }
        if (ro1VarArr.length == 1) {
            return z(ro1VarArr[0]);
        }
        s();
        return this;
    }

    public nb D() {
        if (this.v) {
            return clone().D();
        }
        this.x = true;
        this.g |= 1048576;
        s();
        return this;
    }

    public nb a(nb nbVar) {
        if (this.v) {
            return clone().a(nbVar);
        }
        if (j(nbVar.g, 2)) {
            this.h = nbVar.h;
        }
        if (j(nbVar.g, 1048576)) {
            this.x = nbVar.x;
        }
        if (j(nbVar.g, 4)) {
            this.i = nbVar.i;
        }
        if (j(nbVar.g, 8)) {
            this.j = nbVar.j;
        }
        if (j(nbVar.g, 16)) {
            this.k = 0;
            this.g &= -33;
        }
        if (j(nbVar.g, 32)) {
            this.k = nbVar.k;
            this.g &= -17;
        }
        if (j(nbVar.g, 64)) {
            this.g &= -129;
        }
        if (j(nbVar.g, 128)) {
            this.g &= -65;
        }
        if (j(nbVar.g, MotionScene.Transition.TransitionOnClick.JUMP_TO_END)) {
            this.l = nbVar.l;
        }
        if (j(nbVar.g, 512)) {
            this.n = nbVar.n;
            this.m = nbVar.m;
        }
        if (j(nbVar.g, 1024)) {
            this.o = nbVar.o;
        }
        if (j(nbVar.g, MotionScene.Transition.TransitionOnClick.JUMP_TO_START)) {
            this.s = nbVar.s;
        }
        if (j(nbVar.g, 8192)) {
            this.g &= -16385;
        }
        if (j(nbVar.g, 16384)) {
            this.g &= -8193;
        }
        if (j(nbVar.g, 32768)) {
            this.u = nbVar.u;
        }
        if (j(nbVar.g, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ)) {
            this.p = nbVar.p;
        }
        if (j(nbVar.g, 2048)) {
            this.r.putAll(nbVar.r);
            this.w = nbVar.w;
        }
        this.g |= nbVar.g;
        this.q.b.g(nbVar.q.b);
        s();
        return this;
    }

    public nb b() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return k();
    }

    public nb c() {
        hw hwVar = hw.b;
        return y(new dh());
    }

    @Override // 
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public nb clone() {
        try {
            nb nbVar = (nb) super.clone();
            g01 g01Var = new g01();
            nbVar.q = g01Var;
            g01Var.b.g(this.q.b);
            jf jfVar = new jf(0);
            nbVar.r = jfVar;
            jfVar.putAll(this.r);
            nbVar.t = false;
            nbVar.v = false;
            return nbVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public nb e(Class cls) {
        if (this.v) {
            return clone().e(cls);
        }
        this.s = cls;
        this.g |= MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
        s();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof nb) {
            return i((nb) obj);
        }
        return false;
    }

    public nb f(qv qvVar) {
        if (this.v) {
            return clone().f(qvVar);
        }
        this.i = qvVar;
        this.g |= 4;
        s();
        return this;
    }

    public nb g(hw hwVar) {
        return t(hw.g, hwVar);
    }

    public nb h(int i) {
        if (this.v) {
            return clone().h(i);
        }
        this.k = i;
        this.g = (this.g | 32) & (-17);
        s();
        return this;
    }

    public int hashCode() {
        float f = this.h;
        char[] cArr = vq1.a;
        return vq1.h(vq1.h(vq1.h(vq1.h(vq1.h(vq1.h(vq1.h(vq1.g(0, vq1.g(0, vq1.g(1, vq1.g(this.p ? 1 : 0, vq1.g(this.n, vq1.g(this.m, vq1.g(this.l ? 1 : 0, vq1.h(vq1.g(0, vq1.h(vq1.g(0, vq1.h(vq1.g(this.k, vq1.g(Float.floatToIntBits(f), 17)), null)), null)), null)))))))), this.i), this.j), this.q), this.r), this.s), this.o), this.u);
    }

    public final boolean i(nb nbVar) {
        if (Float.compare(nbVar.h, this.h) != 0 || this.k != nbVar.k) {
            return false;
        }
        char[] cArr = vq1.a;
        return this.l == nbVar.l && this.m == nbVar.m && this.n == nbVar.n && this.p == nbVar.p && this.i.equals(nbVar.i) && this.j == nbVar.j && this.q.equals(nbVar.q) && this.r.equals(nbVar.r) && this.s.equals(nbVar.s) && this.o.equals(nbVar.o) && vq1.b(this.u, nbVar.u);
    }

    public nb k() {
        this.t = true;
        return this;
    }

    public nb l() {
        return o(hw.d, new dh());
    }

    public nb m() {
        nb nbVarO = o(hw.c, new eh());
        nbVarO.w = true;
        return nbVarO;
    }

    public nb n() {
        nb nbVarO = o(hw.b, new e30());
        nbVarO.w = true;
        return nbVarO;
    }

    public final nb o(hw hwVar, qc qcVar) {
        if (this.v) {
            return clone().o(hwVar, qcVar);
        }
        g(hwVar);
        return A(qcVar, false);
    }

    public nb p(int i, int i2) {
        if (this.v) {
            return clone().p(i, i2);
        }
        this.n = i;
        this.m = i2;
        this.g |= 512;
        s();
        return this;
    }

    public nb q() {
        j31 j31Var = j31.j;
        if (this.v) {
            return clone().q();
        }
        this.j = j31Var;
        this.g |= 8;
        s();
        return this;
    }

    public final nb r(e01 e01Var) {
        if (this.v) {
            return clone().r(e01Var);
        }
        this.q.b.remove(e01Var);
        s();
        return this;
    }

    public final void s() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public nb t(e01 e01Var, Object obj) {
        if (this.v) {
            return clone().t(e01Var, obj);
        }
        n90.g(e01Var);
        n90.g(obj);
        this.q.b.put(e01Var, obj);
        s();
        return this;
    }

    public nb u(bj0 bj0Var) {
        if (this.v) {
            return clone().u(bj0Var);
        }
        this.o = bj0Var;
        this.g |= 1024;
        s();
        return this;
    }

    public nb v(float f) {
        if (this.v) {
            return clone().v(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.h = f;
        this.g |= 2;
        s();
        return this;
    }

    public nb w() {
        if (this.v) {
            return clone().w();
        }
        this.l = false;
        this.g |= MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
        s();
        return this;
    }

    public nb x(Resources.Theme theme) {
        if (this.v) {
            return clone().x(theme);
        }
        this.u = theme;
        if (theme != null) {
            this.g |= 32768;
            return t(kb1.b, theme);
        }
        this.g &= -32769;
        return r(kb1.b);
    }

    public final nb y(dh dhVar) {
        hw hwVar = hw.d;
        if (this.v) {
            return clone().y(dhVar);
        }
        g(hwVar);
        return z(dhVar);
    }

    public nb z(ro1 ro1Var) {
        return A(ro1Var, true);
    }
}
