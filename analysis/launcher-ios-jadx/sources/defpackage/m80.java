package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class m80 implements eb1, nf0 {
    public final Drawable g;
    public final /* synthetic */ int h;

    public m80(Drawable drawable, int i) {
        this.h = i;
        n90.h(drawable, "Argument must not be null");
        this.g = drawable;
    }

    @Override // defpackage.nf0
    public void a() {
        switch (this.h) {
            case 0:
                ((r80) ((l80) this.g).g.b).l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.g;
                if (drawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                } else if (drawable instanceof l80) {
                    ((r80) ((l80) drawable).g.b).l.prepareToDraw();
                }
                break;
        }
    }

    @Override // defpackage.eb1
    public final int c() {
        switch (this.h) {
            case 0:
                r80 r80Var = (r80) ((l80) this.g).g.b;
                wi1 wi1Var = r80Var.a;
                return (wi1Var.j.length * 4) + wi1Var.d.limit() + wi1Var.i.length + r80Var.n;
            default:
                Drawable drawable = this.g;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
        }
    }

    @Override // defpackage.eb1
    public final Class d() {
        switch (this.h) {
            case 0:
                return l80.class;
            default:
                return this.g.getClass();
        }
    }

    @Override // defpackage.eb1
    public final Object get() {
        Drawable drawable = this.g;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override // defpackage.eb1
    public final void recycle() {
        cq0 cq0Var;
        cq0 cq0Var2;
        cq0 cq0Var3;
        switch (this.h) {
            case 0:
                l80 l80Var = (l80) this.g;
                l80Var.stop();
                l80Var.j = true;
                r80 r80Var = (r80) l80Var.g.b;
                r80Var.c.clear();
                Bitmap bitmap = r80Var.l;
                if (bitmap != null) {
                    r80Var.e.j(bitmap);
                    r80Var.l = null;
                }
                r80Var.f = false;
                p80 p80Var = r80Var.i;
                sa1 sa1Var = r80Var.d;
                if (p80Var != null) {
                    sa1Var.n(p80Var);
                    r80Var.i = null;
                }
                p80 p80Var2 = r80Var.k;
                if (p80Var2 != null) {
                    sa1Var.n(p80Var2);
                    r80Var.k = null;
                }
                p80 p80Var3 = r80Var.m;
                if (p80Var3 != null) {
                    sa1Var.n(p80Var3);
                    r80Var.m = null;
                }
                wi1 wi1Var = r80Var.a;
                wi1Var.l = null;
                byte[] bArr = wi1Var.i;
                v21 v21Var = wi1Var.c;
                if (bArr != null && (cq0Var3 = (cq0) v21Var.i) != null) {
                    cq0Var3.h(bArr);
                }
                int[] iArr = wi1Var.j;
                if (iArr != null && (cq0Var2 = (cq0) v21Var.i) != null) {
                    cq0Var2.h(iArr);
                }
                Bitmap bitmap2 = wi1Var.m;
                if (bitmap2 != null) {
                    ((oc) v21Var.h).j(bitmap2);
                }
                wi1Var.m = null;
                wi1Var.d = null;
                wi1Var.s = null;
                byte[] bArr2 = wi1Var.e;
                if (bArr2 != null && (cq0Var = (cq0) v21Var.i) != null) {
                    cq0Var.h(bArr2);
                }
                r80Var.j = true;
                break;
        }
    }

    private final void b() {
    }
}
