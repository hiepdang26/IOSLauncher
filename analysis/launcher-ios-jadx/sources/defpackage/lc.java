package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class lc extends ob {
    public static final int k = r51.glide_custom_view_target_tag;
    public final ImageView g;
    public final ju1 h;
    public Animatable i;
    public final /* synthetic */ int j;

    public lc(ImageView imageView, int i) {
        this.j = i;
        n90.h(imageView, "Argument must not be null");
        this.g = imageView;
        this.h = new ju1(imageView);
    }

    @Override // defpackage.lm1
    public final void a(Drawable drawable) {
        k(null);
        this.i = null;
        this.g.setImageDrawable(drawable);
    }

    @Override // defpackage.cn0
    public final void b() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // defpackage.lm1
    public final void c(ha1 ha1Var) {
        this.g.setTag(k, ha1Var);
    }

    @Override // defpackage.lm1
    public final void d(yg1 yg1Var) {
        this.h.b.remove(yg1Var);
    }

    @Override // defpackage.lm1
    public final void e(Object obj, wo1 wo1Var) {
        if (wo1Var != null && wo1Var.a(obj, this)) {
            if (!(obj instanceof Animatable)) {
                this.i = null;
                return;
            }
            Animatable animatable = (Animatable) obj;
            this.i = animatable;
            animatable.start();
            return;
        }
        k(obj);
        if (!(obj instanceof Animatable)) {
            this.i = null;
            return;
        }
        Animatable animatable2 = (Animatable) obj;
        this.i = animatable2;
        animatable2.start();
    }

    @Override // defpackage.lm1
    public final void f(yg1 yg1Var) {
        ju1 ju1Var = this.h;
        ImageView imageView = ju1Var.a;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iA = ju1Var.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = ju1Var.a;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iA2 = ju1Var.a(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iA > 0 || iA == Integer.MIN_VALUE) && (iA2 > 0 || iA2 == Integer.MIN_VALUE)) {
            yg1Var.i(iA, iA2);
            return;
        }
        ArrayList arrayList = ju1Var.b;
        if (!arrayList.contains(yg1Var)) {
            arrayList.add(yg1Var);
        }
        if (ju1Var.c == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            qo qoVar = new qo(ju1Var);
            ju1Var.c = qoVar;
            viewTreeObserver.addOnPreDrawListener(qoVar);
        }
    }

    @Override // defpackage.lm1
    public final void g(Drawable drawable) {
        k(null);
        this.i = null;
        this.g.setImageDrawable(drawable);
    }

    @Override // defpackage.lm1
    public final ha1 h() {
        Object tag = this.g.getTag(k);
        if (tag == null) {
            return null;
        }
        if (tag instanceof ha1) {
            return (ha1) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // defpackage.lm1
    public final void i(Drawable drawable) {
        ju1 ju1Var = this.h;
        ViewTreeObserver viewTreeObserver = ju1Var.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(ju1Var.c);
        }
        ju1Var.c = null;
        ju1Var.b.clear();
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
        k(null);
        this.i = null;
        this.g.setImageDrawable(drawable);
    }

    @Override // defpackage.cn0
    public final void j() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void k(Object obj) {
        switch (this.j) {
            case 0:
                this.g.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.g.setImageDrawable((Drawable) obj);
                break;
        }
    }

    public final String toString() {
        return "Target for: " + this.g;
    }
}
