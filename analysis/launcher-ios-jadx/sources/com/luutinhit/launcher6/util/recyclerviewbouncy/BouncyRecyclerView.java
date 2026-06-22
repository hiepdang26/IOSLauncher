package com.luutinhit.launcher6.util.recyclerviewbouncy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.appslibrary.AppsLibraryItemFull;
import com.luutinhit.launcher6.t;
import defpackage.b90;
import defpackage.d90;
import defpackage.g71;
import defpackage.h90;
import defpackage.hb;
import defpackage.l8;
import defpackage.m81;
import defpackage.mi1;
import defpackage.ni1;
import defpackage.nw;
import defpackage.o5;
import defpackage.qd;
import defpackage.qg0;
import defpackage.sd;
import defpackage.td;
import defpackage.u81;
import defpackage.ud;
import defpackage.vh0;
import defpackage.wy0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class BouncyRecyclerView extends RecyclerView {
    public static final /* synthetic */ int b1 = 0;
    public nw Q0;
    public wy0 R0;
    public ud S0;
    public float T0;
    public float U0;
    public Integer V0;
    public float W0;
    public float X0;
    public boolean Y0;
    public boolean Z0;
    public mi1 a1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BouncyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qg0.l(context, "context");
        this.T0 = 0.5f;
        this.U0 = 0.5f;
        this.V0 = 1;
        this.W0 = 1.0f;
        this.X0 = 200.0f;
        mi1 mi1Var = new mi1(this, mi1.m);
        ni1 ni1Var = new ni1();
        ni1Var.i = 0.0f;
        ni1Var.a(this.W0);
        ni1Var.b(this.X0);
        mi1Var.j = ni1Var;
        mi1Var.a(new qd(this, mi1Var, 2));
        this.a1 = mi1Var;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, g71.BouncyRecyclerView, 0, 0);
        setLongPressDragEnabled(typedArrayObtainStyledAttributes.getBoolean(g71.BouncyRecyclerView_allow_drag_reorder, false));
        setItemSwipeEnabled(typedArrayObtainStyledAttributes.getBoolean(g71.BouncyRecyclerView_allow_item_swipe, false));
        this.T0 = typedArrayObtainStyledAttributes.getFloat(g71.BouncyRecyclerView_recyclerview_overscroll_animation_size, 0.5f);
        this.U0 = typedArrayObtainStyledAttributes.getFloat(g71.BouncyRecyclerView_recyclerview_fling_animation_size, 0.5f);
        int i = typedArrayObtainStyledAttributes.getInt(g71.BouncyRecyclerView_recyclerview_damping_ratio, 0);
        if (i == 0) {
            setDampingRatio(1.0f);
        } else if (i == 1) {
            setDampingRatio(0.75f);
        } else if (i == 2) {
            setDampingRatio(0.5f);
        } else if (i == 3) {
            setDampingRatio(0.2f);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(g71.BouncyRecyclerView_recyclerview_stiffness, 1);
        if (i2 == 0) {
            setStiffness(50.0f);
        } else if (i2 == 1) {
            setStiffness(200.0f);
        } else if (i2 == 2) {
            setStiffness(1500.0f);
        } else if (i2 == 3) {
            setStiffness(10000.0f);
        }
        typedArrayObtainStyledAttributes.recycle();
        l(new hb(this, 1));
        setEdgeEffectFactory(new sd(this, this));
    }

    private final void setupDirection(Integer num) {
        if (num != null && num.intValue() == 0) {
            mi1 mi1Var = new mi1(this, mi1.l);
            ni1 ni1Var = new ni1();
            ni1Var.i = 0.0f;
            ni1Var.a(this.W0);
            ni1Var.b(this.X0);
            mi1Var.j = ni1Var;
            mi1Var.a(new qd(this, mi1Var, 0));
            this.a1 = mi1Var;
            return;
        }
        if (num != null && num.intValue() == 1) {
            mi1 mi1Var2 = new mi1(this, mi1.m);
            ni1 ni1Var2 = new ni1();
            ni1Var2.i = 0.0f;
            ni1Var2.a(this.W0);
            ni1Var2.b(this.X0);
            mi1Var2.j = ni1Var2;
            mi1Var2.a(new qd(this, mi1Var2, 1));
            this.a1 = mi1Var2;
        }
    }

    public final float getDampingRatio() {
        return this.W0;
    }

    public final float getFlingAnimationSize() {
        return this.U0;
    }

    public final boolean getItemSwipeEnabled() {
        return this.Z0;
    }

    public final boolean getLongPressDragEnabled() {
        return this.Y0;
    }

    public final wy0 getOnOverPullListener() {
        return this.R0;
    }

    public final ud getOnOverScrollListener() {
        return this.S0;
    }

    public final Integer getOrientation() {
        return this.V0;
    }

    public final float getOverscrollAnimationSize() {
        return this.T0;
    }

    public final float getStiffness() {
        return this.X0;
    }

    public final void setAdapter(td tdVar) {
        super.setAdapter((m81) tdVar);
        if (tdVar != null) {
            nw nwVar = new nw(tdVar, this.Y0, this.Z0);
            this.Q0 = nwVar;
            new vh0(nwVar).i(this);
        }
    }

    public final void setDampingRatio(float f) {
        this.W0 = f;
        mi1 mi1Var = this.a1;
        ni1 ni1Var = new ni1();
        ni1Var.i = 0.0f;
        ni1Var.a(f);
        ni1Var.b(this.X0);
        mi1Var.j = ni1Var;
    }

    public final void setFlingAnimationSize(float f) {
        this.U0 = f;
    }

    public final void setItemSwipeEnabled(boolean z) {
        this.Z0 = z;
        if (getAdapter() instanceof td) {
            nw nwVar = this.Q0;
            if (nwVar != null) {
                nwVar.f = z;
            } else {
                qg0.O("callBack");
                throw null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(u81 u81Var) {
        super.setLayoutManager(u81Var);
        if (u81Var instanceof LinearLayoutManager) {
            setOrientation(Integer.valueOf(((LinearLayoutManager) u81Var).p));
            setupDirection(this.V0);
        }
    }

    public final void setLongPressDragEnabled(boolean z) {
        this.Y0 = z;
        if (getAdapter() instanceof td) {
            nw nwVar = this.Q0;
            if (nwVar != null) {
                nwVar.e = z;
            } else {
                qg0.O("callBack");
                throw null;
            }
        }
    }

    public final void setOnOverPullListener(wy0 wy0Var) {
        this.R0 = wy0Var;
    }

    public final void setOnOverScrollListener(ud udVar) {
        this.S0 = udVar;
    }

    public final void setOrientation(Integer num) {
        this.V0 = num;
        setupDirection(num);
    }

    public final void setOverscrollAnimationSize(float f) {
        this.T0 = f;
    }

    public final void setStiffness(float f) {
        this.X0 = f;
        mi1 mi1Var = this.a1;
        ni1 ni1Var = new ni1();
        ni1Var.i = 0.0f;
        ni1Var.a(this.W0);
        ni1Var.b(f);
        mi1Var.j = ni1Var;
    }

    public final void t0() {
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            qg0.k(childAt, "getChildAt(...)");
            if (RecyclerView.O(childAt) != -1) {
                int left = (int) (childAt.getLeft() + translationX);
                int top = (int) (childAt.getTop() + translationY);
                ud udVar = this.S0;
                if (udVar != null) {
                    l8 l8Var = (l8) ((o5) udVar).h;
                    l8Var.n.invalidate();
                    t tVar = l8Var.g;
                    if (tVar.isUseLiquidGlass && left >= 0 && top >= 0 && left <= tVar.screenWidth && top <= tVar.screenHeight && (childAt instanceof AppsLibraryItemFull)) {
                        AppsLibraryItemFull appsLibraryItemFull = (AppsLibraryItemFull) childAt;
                        float f = left;
                        float f2 = top;
                        d90 d90Var = appsLibraryItemFull.o;
                        if (d90Var != null) {
                            b90 b90Var = (b90) d90Var.g.v.get(d90Var);
                            if (b90Var != null) {
                                b90Var.f = f;
                                b90Var.g = f2;
                                b90Var.h = true;
                            }
                        } else {
                            h90 h90Var = appsLibraryItemFull.p;
                            if (h90Var != null && h90.d(f, f2, h90Var.l, h90Var.k, h90Var.m, h90Var.n)) {
                                Objects.toString(h90Var.getParent());
                                int[] iArr = h90Var.q;
                                iArr[0] = (int) f;
                                iArr[1] = (int) f2;
                                h90Var.h.setFloatUniform("u_GlViewPosition", f, f2);
                                h90Var.invalidate();
                            }
                        }
                    }
                }
            }
        }
    }
}
