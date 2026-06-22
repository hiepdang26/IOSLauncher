package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.button.MaterialButton;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ar0 {
    public static final boolean t;
    public static final boolean u;
    public final MaterialButton a;
    public wf1 b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    static {
        int i = Build.VERSION.SDK_INT;
        t = true;
        u = i <= 22;
    }

    public ar0(MaterialButton materialButton, wf1 wf1Var) {
        this.a = materialButton;
        this.b = wf1Var;
    }

    public final hg1 a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.r.getNumberOfLayers() > 2 ? (hg1) this.r.getDrawable(2) : (hg1) this.r.getDrawable(1);
    }

    public final rr0 b(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return t ? (rr0) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (rr0) this.r.getDrawable(!z ? 1 : 0);
    }

    public final void c(wf1 wf1Var) {
        this.b = wf1Var;
        if (!u || this.o) {
            if (b(false) != null) {
                b(false).setShapeAppearanceModel(wf1Var);
            }
            if (b(true) != null) {
                b(true).setShapeAppearanceModel(wf1Var);
            }
            if (a() != null) {
                a().setShapeAppearanceModel(wf1Var);
                return;
            }
            return;
        }
        WeakHashMap weakHashMap = qs1.a;
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        e();
        materialButton.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public final void d(int i, int i2) {
        WeakHashMap weakHashMap = qs1.a;
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e() {
        Drawable insetDrawable;
        rr0 rr0Var = new rr0(this.b);
        MaterialButton materialButton = this.a;
        rr0Var.i(materialButton.getContext());
        rr0Var.setTintList(this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            rr0Var.setTintMode(mode);
        }
        float f = this.h;
        ColorStateList colorStateList = this.k;
        rr0Var.g.j = f;
        rr0Var.invalidateSelf();
        qr0 qr0Var = rr0Var.g;
        if (qr0Var.d != colorStateList) {
            qr0Var.d = colorStateList;
            rr0Var.onStateChange(rr0Var.getState());
        }
        rr0 rr0Var2 = new rr0(this.b);
        rr0Var2.setTint(0);
        float f2 = this.h;
        int iE = this.n ? bf1.e(q41.colorSurface, materialButton) : 0;
        rr0Var2.g.j = f2;
        rr0Var2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iE);
        qr0 qr0Var2 = rr0Var2.g;
        if (qr0Var2.d != colorStateListValueOf) {
            qr0Var2.d = colorStateListValueOf;
            rr0Var2.onStateChange(rr0Var2.getState());
        }
        if (t) {
            rr0 rr0Var3 = new rr0(this.b);
            this.m = rr0Var3;
            rr0Var3.setTint(-1);
            RippleDrawable rippleDrawable = new RippleDrawable(wd.F(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{rr0Var2, rr0Var}), this.c, this.e, this.d, this.f), this.m);
            this.r = rippleDrawable;
            insetDrawable = rippleDrawable;
        } else {
            rr0 rr0Var4 = new rr0(this.b);
            hc1 hc1Var = new hc1();
            hc1Var.a = rr0Var4;
            hc1Var.b = false;
            ic1 ic1Var = new ic1(hc1Var);
            this.m = ic1Var;
            ic1Var.setTintList(wd.F(this.l));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{rr0Var2, rr0Var, this.m});
            this.r = layerDrawable;
            insetDrawable = new InsetDrawable((Drawable) layerDrawable, this.c, this.e, this.d, this.f);
        }
        materialButton.setInternalBackground(insetDrawable);
        rr0 rr0VarB = b(false);
        if (rr0VarB != null) {
            rr0VarB.j(this.s);
        }
    }

    public final void f() {
        int iE = 0;
        rr0 rr0VarB = b(false);
        rr0 rr0VarB2 = b(true);
        if (rr0VarB != null) {
            float f = this.h;
            ColorStateList colorStateList = this.k;
            rr0VarB.g.j = f;
            rr0VarB.invalidateSelf();
            qr0 qr0Var = rr0VarB.g;
            if (qr0Var.d != colorStateList) {
                qr0Var.d = colorStateList;
                rr0VarB.onStateChange(rr0VarB.getState());
            }
            if (rr0VarB2 != null) {
                float f2 = this.h;
                if (this.n) {
                    iE = bf1.e(q41.colorSurface, this.a);
                }
                rr0VarB2.g.j = f2;
                rr0VarB2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iE);
                qr0 qr0Var2 = rr0VarB2.g;
                if (qr0Var2.d != colorStateListValueOf) {
                    qr0Var2.d = colorStateListValueOf;
                    rr0VarB2.onStateChange(rr0VarB2.getState());
                }
            }
        }
    }
}
