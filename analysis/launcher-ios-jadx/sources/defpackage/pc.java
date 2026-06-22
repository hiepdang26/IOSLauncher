package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class pc implements eb1, nf0 {
    public final /* synthetic */ int g = 1;
    public final Object h;
    public final Object i;

    public pc(oc ocVar, Bitmap bitmap) {
        n90.h(bitmap, "Bitmap must not be null");
        this.h = bitmap;
        n90.h(ocVar, "BitmapPool must not be null");
        this.i = ocVar;
    }

    public static pc b(oc ocVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new pc(ocVar, bitmap);
    }

    @Override // defpackage.nf0
    public final void a() {
        switch (this.g) {
            case 0:
                ((Bitmap) this.h).prepareToDraw();
                break;
            default:
                eb1 eb1Var = (eb1) this.i;
                if (eb1Var instanceof nf0) {
                    ((nf0) eb1Var).a();
                }
                break;
        }
    }

    @Override // defpackage.eb1
    public final int c() {
        switch (this.g) {
            case 0:
                return vq1.c((Bitmap) this.h);
            default:
                return ((eb1) this.i).c();
        }
    }

    @Override // defpackage.eb1
    public final Class d() {
        switch (this.g) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // defpackage.eb1
    public final Object get() {
        switch (this.g) {
            case 0:
                return (Bitmap) this.h;
            default:
                return new BitmapDrawable((Resources) this.h, (Bitmap) ((eb1) this.i).get());
        }
    }

    @Override // defpackage.eb1
    public final void recycle() {
        switch (this.g) {
            case 0:
                ((oc) this.i).j((Bitmap) this.h);
                break;
            default:
                ((eb1) this.i).recycle();
                break;
        }
    }

    public pc(Resources resources, eb1 eb1Var) {
        n90.h(resources, "Argument must not be null");
        this.h = resources;
        n90.h(eb1Var, "Argument must not be null");
        this.i = eb1Var;
    }
}
