package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class j5 extends Drawable.ConstantState {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ j5(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).getChangingConfigurations();
            case 1:
                return 0;
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.a) {
            case 0:
                k5 k5Var = new k5(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable();
                k5Var.g = drawableNewDrawable;
                drawableNewDrawable.setCallback(k5Var.j);
                return k5Var;
            case 1:
                return (hd) this.b;
            default:
                return new l80(this);
        }
    }

    public j5(hd hdVar) {
        this.a = 1;
        this.b = hdVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.a) {
            case 0:
                k5 k5Var = new k5(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources);
                k5Var.g = drawableNewDrawable;
                drawableNewDrawable.setCallback(k5Var.j);
                return k5Var;
            case 1:
            default:
                return super.newDrawable(resources);
            case 2:
                return new l80(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.a) {
            case 0:
                k5 k5Var = new k5(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources, theme);
                k5Var.g = drawableNewDrawable;
                drawableNewDrawable.setCallback(k5Var.j);
                return k5Var;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
