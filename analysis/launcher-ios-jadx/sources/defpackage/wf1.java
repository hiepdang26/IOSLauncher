package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class wf1 {
    public static final y91 m = new y91(0.5f);
    public bf1 a = new rc1();
    public bf1 b = new rc1();
    public bf1 c = new rc1();
    public bf1 d = new rc1();
    public to e = new d(0.0f);
    public to f = new d(0.0f);
    public to g = new d(0.0f);
    public to h = new d(0.0f);
    public iy i = new iy();
    public iy j = new iy();
    public iy k = new iy();
    public iy l = new iy();

    public static vf1 a(Context context, int i, int i2, to toVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, f71.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(f71.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(f71.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(f71.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(f71.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(f71.ShapeAppearance_cornerFamilyBottomLeft, i3);
            to toVarC = c(typedArrayObtainStyledAttributes, f71.ShapeAppearance_cornerSize, toVar);
            to toVarC2 = c(typedArrayObtainStyledAttributes, f71.ShapeAppearance_cornerSizeTopLeft, toVarC);
            to toVarC3 = c(typedArrayObtainStyledAttributes, f71.ShapeAppearance_cornerSizeTopRight, toVarC);
            to toVarC4 = c(typedArrayObtainStyledAttributes, f71.ShapeAppearance_cornerSizeBottomRight, toVarC);
            to toVarC5 = c(typedArrayObtainStyledAttributes, f71.ShapeAppearance_cornerSizeBottomLeft, toVarC);
            vf1 vf1Var = new vf1();
            bf1 bf1VarF = az1.f(i4);
            vf1Var.a = bf1VarF;
            vf1.b(bf1VarF);
            vf1Var.e = toVarC2;
            bf1 bf1VarF2 = az1.f(i5);
            vf1Var.b = bf1VarF2;
            vf1.b(bf1VarF2);
            vf1Var.f = toVarC3;
            bf1 bf1VarF3 = az1.f(i6);
            vf1Var.c = bf1VarF3;
            vf1.b(bf1VarF3);
            vf1Var.g = toVarC4;
            bf1 bf1VarF4 = az1.f(i7);
            vf1Var.d = bf1VarF4;
            vf1.b(bf1VarF4);
            vf1Var.h = toVarC5;
            return vf1Var;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static vf1 b(Context context, AttributeSet attributeSet, int i, int i2) {
        d dVar = new d(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(f71.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(f71.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, dVar);
    }

    public static to c(TypedArray typedArray, int i, to toVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new d(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new y91(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return toVar;
    }

    public final boolean d(RectF rectF) {
        boolean z = this.l.getClass().equals(iy.class) && this.j.getClass().equals(iy.class) && this.i.getClass().equals(iy.class) && this.k.getClass().equals(iy.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof rc1) && (this.a instanceof rc1) && (this.c instanceof rc1) && (this.d instanceof rc1));
    }

    public final vf1 e() {
        vf1 vf1Var = new vf1();
        vf1Var.a = this.a;
        vf1Var.b = this.b;
        vf1Var.c = this.c;
        vf1Var.d = this.d;
        vf1Var.e = this.e;
        vf1Var.f = this.f;
        vf1Var.g = this.g;
        vf1Var.h = this.h;
        vf1Var.i = this.i;
        vf1Var.j = this.j;
        vf1Var.k = this.k;
        vf1Var.l = this.l;
        return vf1Var;
    }
}
