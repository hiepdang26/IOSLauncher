package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class s71 extends ConstraintLayout {
    public final fl0 g;
    public int h;
    public final rr0 i;

    public s71(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(l61.material_radial_view_group, this);
        rr0 rr0Var = new rr0();
        this.i = rr0Var;
        y91 y91Var = new y91(0.5f);
        vf1 vf1VarE = rr0Var.g.a.e();
        vf1VarE.e = y91Var;
        vf1VarE.f = y91Var;
        vf1VarE.g = y91Var;
        vf1VarE.h = y91Var;
        rr0Var.setShapeAppearanceModel(vf1VarE.a());
        this.i.k(ColorStateList.valueOf(-1));
        rr0 rr0Var2 = this.i;
        WeakHashMap weakHashMap = qs1.a;
        setBackground(rr0Var2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.RadialViewGroup, i, 0);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.RadialViewGroup_materialCircleRadius, 0);
        this.g = new fl0(this, 9);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = qs1.a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            fl0 fl0Var = this.g;
            handler.removeCallbacks(fl0Var);
            handler.post(fl0Var);
        }
    }

    public final void l() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        en enVar = new en();
        enVar.f(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != u51.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i4 = u51.circle_center;
                int i5 = this.h;
                an anVar = enVar.k(id).e;
                anVar.A = i4;
                anVar.B = i5;
                anVar.C = f;
                f = (360.0f / (childCount - i)) + f;
            }
        }
        enVar.b(this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        l();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            fl0 fl0Var = this.g;
            handler.removeCallbacks(fl0Var);
            handler.post(fl0Var);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.i.k(ColorStateList.valueOf(i));
    }
}
