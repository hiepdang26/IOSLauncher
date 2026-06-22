package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.allapps.AllAppsContainerView;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class ya extends FrameLayout implements fg0 {
    public final Rect g;
    public final Rect h;
    public final int i;
    public final Drawable j;
    public View k;
    public View l;
    public final int m;

    public ya(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new Rect();
        this.h = new Rect();
        this.i = getResources().getDimensionPixelSize(e51.container_bounds_inset);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.BaseContainerView, 0, 0);
        this.j = typedArrayObtainStyledAttributes.getDrawable(g71.BaseContainerView_revealBackground);
        typedArrayObtainStyledAttributes.recycle();
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.container_max_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(e51.container_min_margin);
        int i = ((t) context).getDeviceProfile().l;
        if (dimensionPixelSize > 0) {
            this.m = Math.max(dimensionPixelSize2, (i - dimensionPixelSize) / 2);
        } else {
            this.m = Math.max(dimensionPixelSize2, (int) getResources().getFraction(n51.container_margin, i, 1));
        }
    }

    public final void a() {
        Rect rect = this.g;
        int i = rect.top;
        int i2 = this.i;
        int i3 = i + i2;
        int i4 = rect.bottom + i2;
        int i5 = this.m;
        new Rect(i5, i3, i5, i4);
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.h;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        InsetDrawable insetDrawable = new InsetDrawable(this.j, rect2.left, 0, rect2.right, 0);
        this.k.setBackground(insetDrawable.getConstantState().newDrawable());
        this.l.setBackground(insetDrawable);
        this.l.setPadding(0, 0, 0, 0);
        Rect rect4 = new Rect();
        insetDrawable.getPadding(rect4);
        AllAppsContainerView allAppsContainerView = (AllAppsContainerView) this;
        allAppsContainerView.t.W0.set(rect4);
        allAppsContainerView.p.r.set(rect4);
        allAppsContainerView.w.d(rect4);
        int maxScrollbarWidth = allAppsContainerView.t.getMaxScrollbarWidth();
        int iMax = Math.max(allAppsContainerView.x, maxScrollbarWidth);
        boolean zV = ar1.v(allAppsContainerView.getResources());
        int i6 = allAppsContainerView.A;
        if (zV) {
            allAppsContainerView.t.setPadding(rect2.left + maxScrollbarWidth, i6, rect2.right + iMax, i6);
        } else {
            allAppsContainerView.t.setPadding(rect2.left + iMax, i6, rect2.right + maxScrollbarWidth, i6);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) allAppsContainerView.u.getLayoutParams();
        marginLayoutParams.leftMargin = rect2.left;
        marginLayoutParams.rightMargin = rect2.right;
        allAppsContainerView.u.setLayoutParams(marginLayoutParams);
    }

    public final View getContentView() {
        return this.l;
    }

    public final View getRevealView() {
        return this.k;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.l = findViewById(v51.main_content);
        this.k = findViewById(v51.reveal_view);
    }

    @Override // defpackage.fg0
    public final void setInsets(Rect rect) {
        this.g.set(rect);
        a();
    }

    public final void setSearchBarBounds(Rect rect) {
        post(new o1(this, 5));
    }
}
