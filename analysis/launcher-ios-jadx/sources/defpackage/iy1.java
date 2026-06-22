package defpackage;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class iy1 {
    public static final ly1 b;
    public final ly1 a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = (i >= 34 ? new ay1() : i >= 30 ? new zx1() : i >= 29 ? new yx1() : new xx1()).b().a.a().a.b().a.c();
    }

    public iy1(ly1 ly1Var) {
        this.a = ly1Var;
    }

    public ly1 a() {
        return this.a;
    }

    public ly1 b() {
        return this.a;
    }

    public ly1 c() {
        return this.a;
    }

    public bw e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iy1)) {
            return false;
        }
        iy1 iy1Var = (iy1) obj;
        return n() == iy1Var.n() && m() == iy1Var.m() && Objects.equals(j(), iy1Var.j()) && Objects.equals(h(), iy1Var.h()) && Objects.equals(e(), iy1Var.e());
    }

    public eg0 f(int i) {
        return eg0.e;
    }

    public eg0 g() {
        return j();
    }

    public eg0 h() {
        return eg0.e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public eg0 i() {
        return j();
    }

    public eg0 j() {
        return eg0.e;
    }

    public eg0 k() {
        return j();
    }

    public ly1 l(int i, int i2, int i3, int i4) {
        return b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void d(View view) {
    }

    public void o(eg0[] eg0VarArr) {
    }

    public void p(ly1 ly1Var) {
    }

    public void q(eg0 eg0Var) {
    }

    public void r(int i) {
    }
}
