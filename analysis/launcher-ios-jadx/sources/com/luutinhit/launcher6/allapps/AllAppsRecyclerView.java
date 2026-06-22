package com.luutinhit.launcher6.allapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.BubbleTextView;
import defpackage.ar1;
import defpackage.c4;
import defpackage.e51;
import defpackage.hb;
import defpackage.i4;
import defpackage.ib;
import defpackage.jb;
import defpackage.jj1;
import defpackage.l51;
import defpackage.lb;
import defpackage.m4;
import defpackage.m81;
import defpackage.mb;
import defpackage.mb0;
import defpackage.u81;
import defpackage.x3;
import defpackage.x41;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AllAppsRecyclerView extends jb implements jj1 {
    public m4 X0;
    public x3 Y0;
    public final ib Z0;
    public int a1;
    public int b1;
    public int c1;

    public AllAppsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Q0 = 0;
        this.W0 = new Rect();
        this.R0 = getResources().getDisplayMetrics().density * 4.0f;
        Resources resources = getResources();
        lb lbVar = new lb();
        lbVar.f = new Point(-1, -1);
        lbVar.m = new Path();
        lbVar.v = new Rect();
        lbVar.w = new Rect();
        lbVar.a = this;
        mb mbVar = new mb();
        mbVar.a = new Rect();
        mbVar.b = new Rect();
        new Rect();
        mbVar.e = new Rect();
        int dimensionPixelSize = resources.getDimensionPixelSize(e51.container_fastscroll_popup_size);
        resources.getDrawable(l51.container_fastscroll_popup_bg).setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Paint paint = new Paint();
        mbVar.d = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextSize(resources.getDimensionPixelSize(e51.container_fastscroll_popup_text_size));
        lbVar.b = mbVar;
        Paint paint2 = new Paint();
        lbVar.n = paint2;
        paint2.setColor(-16777216);
        paint2.setAlpha(30);
        int color = resources.getColor(x41.container_fastscroll_thumb_inactive_color);
        lbVar.d = color;
        lbVar.e = resources.getColor(x41.container_fastscroll_thumb_active_color);
        Paint paint3 = new Paint();
        lbVar.g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(color);
        paint3.setStyle(Paint.Style.FILL);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(e51.container_fastscroll_thumb_min_width);
        lbVar.h = dimensionPixelSize2;
        lbVar.j = dimensionPixelSize2;
        int dimensionPixelSize3 = resources.getDimensionPixelSize(e51.container_fastscroll_thumb_max_width);
        lbVar.i = dimensionPixelSize3;
        lbVar.k = resources.getDimensionPixelSize(e51.container_fastscroll_thumb_height);
        lbVar.l = dimensionPixelSize3 - dimensionPixelSize2;
        lbVar.p = resources.getDimensionPixelSize(e51.container_fastscroll_thumb_touch_inset);
        this.S0 = lbVar;
        l(new hb(this, 0));
        this.Z0 = new ib();
        Resources resources2 = getResources();
        this.w.add(this);
        lbVar.s = true;
        resources2.getDimensionPixelSize(e51.all_apps_empty_search_bg_top_offset);
    }

    @Override // defpackage.jb, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        synchronized (canvas) {
            Rect rect = this.W0;
            canvas.clipRect(rect.left, rect.top, getWidth() - this.W0.right, getHeight() - this.W0.bottom);
        }
        super.dispatchDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(m81 m81Var) {
        super.setAdapter(m81Var);
        x3 x3Var = this.Y0;
        x3Var.getClass();
        ((c4) m81Var).z = x3Var;
    }

    public void setApps(m4 m4Var) {
        this.X0 = m4Var;
        this.Y0 = new x3(this, m4Var);
    }

    @Override // defpackage.jj1
    public final void u(View view, Bundle bundle) {
        int iO;
        bundle.putString("container", "all_apps");
        this.X0.getClass();
        if ((view instanceof BubbleTextView) && (iO = RecyclerView.O((BubbleTextView) view)) != -1 && ((i4) this.X0.e.get(iO)).b == 2) {
            bundle.putString("sub_container", "prediction");
        } else {
            bundle.putString("sub_container", "a-z");
        }
    }

    @Override // defpackage.jb
    public final int u0(int i) {
        if (getChildCount() == 0 || i <= 0) {
            return 0;
        }
        return ((i - 1) * this.c1) + this.b1;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == null || super.verifyDrawable(drawable);
    }

    @Override // defpackage.jb
    public final void w0(int i) {
        boolean zIsEmpty = this.X0.e.isEmpty();
        lb lbVar = this.S0;
        if (zIsEmpty || this.a1 == 0) {
            lbVar.b(-1, -1);
            return;
        }
        m4 m4Var = this.X0;
        int i2 = m4Var.q;
        ib ibVar = this.Z0;
        ibVar.a = -1;
        ibVar.b = -1;
        ArrayList arrayList = m4Var.e;
        if (!arrayList.isEmpty() && this.a1 != 0) {
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                int iO = RecyclerView.O(childAt);
                if (iO != -1) {
                    i4 i4Var = (i4) arrayList.get(iO);
                    if (i4Var.b != 0) {
                        ibVar.a = i4Var.f;
                        getLayoutManager().getClass();
                        ibVar.b = u81.D(childAt);
                        break;
                    }
                }
                i3++;
            }
        }
        if (ibVar.a < 0) {
            lbVar.b(-1, -1);
            return;
        }
        int availableScrollBarHeight = getAvailableScrollBarHeight();
        int iT0 = t0(this.X0.q);
        if (iT0 <= 0) {
            lbVar.b(-1, -1);
            return;
        }
        int iU0 = (u0(ibVar.a) + getPaddingTop()) - ibVar.b;
        Rect rect = this.W0;
        int i4 = rect.top + ((int) ((iU0 / iT0) * availableScrollBarHeight));
        if (!lbVar.r) {
            int availableScrollBarHeight2 = getAvailableScrollBarHeight();
            int iT02 = t0(i2);
            if (iT02 <= 0) {
                lbVar.b(-1, -1);
                return;
            } else {
                lbVar.b(ar1.v(getResources()) ? rect.left : (getWidth() - rect.right) - lbVar.j, rect.top + ((int) ((((u0(ibVar.a) + getPaddingTop()) - ibVar.b) / iT02) * availableScrollBarHeight2)));
                return;
            }
        }
        int width = ar1.v(getResources()) ? rect.left : (getWidth() - rect.right) - lbVar.j;
        if (lbVar.q) {
            lbVar.b(width, (int) lbVar.o);
            return;
        }
        int i5 = lbVar.f.y;
        int i6 = i4 - i5;
        if (i6 * i <= 0.0f) {
            lbVar.b(width, i5);
            return;
        }
        int iMax = Math.max(0, Math.min(availableScrollBarHeight, (i < 0 ? Math.max((int) ((i * i5) / i4), i6) : Math.min((int) (((availableScrollBarHeight - i5) * i) / (availableScrollBarHeight - i4)), i6)) + i5));
        lbVar.b(width, iMax);
        if (i4 == iMax) {
            lbVar.r = false;
        }
    }

    public void setElevationController(mb0 mb0Var) {
    }
}
