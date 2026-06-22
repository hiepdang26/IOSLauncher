package defpackage;

import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class pr implements lm1 {
    public final int g;
    public final int h;
    public ha1 i;

    public pr() {
        if (!vq1.i(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.g = RtlSpacingHelper.UNDEFINED;
        this.h = RtlSpacingHelper.UNDEFINED;
    }

    @Override // defpackage.lm1
    public final void c(ha1 ha1Var) {
        this.i = ha1Var;
    }

    @Override // defpackage.lm1
    public final void f(yg1 yg1Var) {
        yg1Var.i(this.g, this.h);
    }

    @Override // defpackage.lm1
    public final ha1 h() {
        return this.i;
    }

    @Override // defpackage.cn0
    public final void b() {
    }

    @Override // defpackage.cn0
    public final void j() {
    }

    @Override // defpackage.cn0
    public final void onDestroy() {
    }

    @Override // defpackage.lm1
    public final void a(Drawable drawable) {
    }

    @Override // defpackage.lm1
    public final void d(yg1 yg1Var) {
    }

    @Override // defpackage.lm1
    public final void g(Drawable drawable) {
    }
}
