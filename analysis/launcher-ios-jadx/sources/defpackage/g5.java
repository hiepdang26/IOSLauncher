package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class g5 extends bx implements zn1 {
    public d5 t;
    public boolean u;
    public d5 v;
    public wd w;
    public int x;
    public int y;
    public boolean z;

    public g5(d5 d5Var, Resources resources) {
        this.k = 255;
        this.m = -1;
        this.x = -1;
        this.y = -1;
        d(new d5(d5Var, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0289, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0282, code lost:
    
        r5.onStateChange(r5.getState());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.g5 e(android.content.Context r25, android.content.res.Resources r26, org.xmlpull.v1.XmlPullParser r27, android.util.AttributeSet r28, android.content.res.Resources.Theme r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g5.e(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):g5");
    }

    @Override // defpackage.bx, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // defpackage.bx
    public final void d(d5 d5Var) {
        this.g = d5Var;
        int i = this.m;
        if (i >= 0) {
            Drawable drawableD = d5Var.d(i);
            this.i = drawableD;
            if (drawableD != null) {
                b(drawableD);
            }
        }
        this.j = null;
        this.t = d5Var;
        this.v = d5Var;
    }

    public final Drawable f() {
        if (!this.u) {
            super.mutate();
            d5 d5Var = this.t;
            d5Var.I = d5Var.I.clone();
            d5Var.J = d5Var.J.clone();
            this.u = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // defpackage.bx, android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        wd wdVar = this.w;
        if (wdVar != null) {
            wdVar.J();
            this.w = null;
            c(this.x);
            this.x = -1;
            this.y = -1;
        }
    }

    @Override // defpackage.bx, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.z) {
            f();
            d5 d5Var = this.v;
            d5Var.I = d5Var.I.clone();
            d5Var.J = d5Var.J.clone();
            this.z = true;
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d3  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r14) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g5.onStateChange(int[]):boolean");
    }

    @Override // defpackage.bx, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        wd wdVar = this.w;
        if (wdVar != null && (visible || z2)) {
            if (z) {
                wdVar.I();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }
}
