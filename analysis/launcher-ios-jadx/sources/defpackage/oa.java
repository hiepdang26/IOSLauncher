package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class oa extends Drawable implements dn1 {
    public static final int t = b71.Widget_MaterialComponents_Badge;
    public static final int u = q41.badgeStyle;
    public final WeakReference g;
    public final rr0 h;
    public final en1 i;
    public final Rect j;
    public final qa k;
    public float l;
    public float m;
    public final int n;
    public float o;
    public float p;
    public float q;
    public WeakReference r;
    public WeakReference s;

    public oa(Context context) {
        zm1 zm1Var;
        Context context2;
        WeakReference weakReference = new WeakReference(context);
        this.g = weakReference;
        mn1.c(context, mn1.b, "Theme.MaterialComponents");
        this.j = new Rect();
        rr0 rr0Var = new rr0();
        this.h = rr0Var;
        en1 en1Var = new en1(this);
        this.i = en1Var;
        TextPaint textPaint = en1Var.a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        int i = b71.TextAppearance_MaterialComponents_Badge;
        Context context3 = (Context) weakReference.get();
        if (context3 != null && en1Var.f != (zm1Var = new zm1(context3, i)) && (context2 = (Context) weakReference.get()) != null) {
            en1Var.b(zm1Var, context2);
            f();
        }
        qa qaVar = new qa(context);
        this.k = qaVar;
        pa paVar = qaVar.b;
        this.n = ((int) Math.pow(10.0d, ((double) paVar.l) - 1.0d)) - 1;
        en1Var.d = true;
        f();
        invalidateSelf();
        en1Var.d = true;
        f();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(paVar.h.intValue());
        if (rr0Var.g.c != colorStateListValueOf) {
            rr0Var.k(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(paVar.i.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.r;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.r.get();
            WeakReference weakReference3 = this.s;
            e(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        f();
        setVisible(paVar.r.booleanValue(), false);
    }

    @Override // defpackage.dn1
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        int iC = c();
        int i = this.n;
        qa qaVar = this.k;
        if (iC <= i) {
            return NumberFormat.getInstance(qaVar.b.m).format(c());
        }
        Context context = (Context) this.g.get();
        return context == null ? "" : String.format(qaVar.b.m, context.getString(v61.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i), "+");
    }

    public final int c() {
        if (d()) {
            return this.k.b.k;
        }
        return 0;
    }

    public final boolean d() {
        return this.k.b.k != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.h.draw(canvas);
        if (d()) {
            Rect rect = new Rect();
            String strB = b();
            en1 en1Var = this.i;
            en1Var.a.getTextBounds(strB, 0, strB.length(), rect);
            canvas.drawText(strB, this.l, this.m + (rect.height() / 2), en1Var.a);
        }
    }

    public final void e(View view, FrameLayout frameLayout) {
        this.r = new WeakReference(view);
        this.s = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        f();
        invalidateSelf();
    }

    public final void f() {
        Context context = (Context) this.g.get();
        WeakReference weakReference = this.r;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.j;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference2 = this.s;
        FrameLayout frameLayout = weakReference2 != null ? (FrameLayout) weakReference2.get() : null;
        if (frameLayout != null) {
            frameLayout.offsetDescendantRectToMyCoords(view, rect3);
        }
        boolean zD = d();
        qa qaVar = this.k;
        int iIntValue = qaVar.b.x.intValue() + (zD ? qaVar.b.v.intValue() : qaVar.b.t.intValue());
        pa paVar = qaVar.b;
        int iIntValue2 = paVar.q.intValue();
        if (iIntValue2 == 8388691 || iIntValue2 == 8388693) {
            this.m = rect3.bottom - iIntValue;
        } else {
            this.m = rect3.top + iIntValue;
        }
        int iC = c();
        float f = qaVar.d;
        if (iC <= 9) {
            if (!d()) {
                f = qaVar.c;
            }
            this.o = f;
            this.q = f;
            this.p = f;
        } else {
            this.o = f;
            this.q = f;
            this.p = (this.i.a(b()) / 2.0f) + qaVar.e;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d() ? d51.mtrl_badge_text_horizontal_edge_offset : d51.mtrl_badge_horizontal_edge_offset);
        int iIntValue3 = paVar.w.intValue() + (d() ? paVar.u.intValue() : paVar.s.intValue());
        int iIntValue4 = paVar.q.intValue();
        if (iIntValue4 == 8388659 || iIntValue4 == 8388691) {
            WeakHashMap weakHashMap = qs1.a;
            this.l = view.getLayoutDirection() == 0 ? (rect3.left - this.p) + dimensionPixelSize + iIntValue3 : ((rect3.right + this.p) - dimensionPixelSize) - iIntValue3;
        } else {
            WeakHashMap weakHashMap2 = qs1.a;
            this.l = view.getLayoutDirection() == 0 ? ((rect3.right + this.p) - dimensionPixelSize) - iIntValue3 : (rect3.left - this.p) + dimensionPixelSize + iIntValue3;
        }
        float f2 = this.l;
        float f3 = this.m;
        float f4 = this.p;
        float f5 = this.q;
        rect2.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
        float f6 = this.o;
        rr0 rr0Var = this.h;
        vf1 vf1VarE = rr0Var.g.a.e();
        vf1VarE.e = new d(f6);
        vf1VarE.f = new d(f6);
        vf1VarE.g = new d(f6);
        vf1VarE.h = new d(f6);
        rr0Var.setShapeAppearanceModel(vf1VarE.a());
        if (rect.equals(rect2)) {
            return;
        }
        rr0Var.setBounds(rect2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.k.b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.j.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.j.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, defpackage.dn1
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        qa qaVar = this.k;
        qaVar.a.j = i;
        qaVar.b.j = i;
        this.i.a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
