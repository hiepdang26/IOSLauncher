package defpackage;

import android.animation.ValueAnimator;
import com.luutinhit.launcher6.FolderIcon;

/* JADX INFO: loaded from: classes.dex */
public final class q40 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ boolean g;
    public final /* synthetic */ float h;
    public final /* synthetic */ u40 i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;
    public final /* synthetic */ FolderIcon l;

    public q40(FolderIcon folderIcon, boolean z, float f, u40 u40Var, float f2, float f3) {
        this.l = folderIcon;
        this.g = z;
        this.h = f;
        this.i = u40Var;
        this.j = f2;
        this.k = f3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        boolean z = this.g;
        FolderIcon folderIcon = this.l;
        if (z) {
            fFloatValue = 1.0f - fFloatValue;
            folderIcon.o.getIconView().setAlpha(fFloatValue);
        }
        u40 u40Var = folderIcon.y;
        u40 u40Var2 = this.i;
        float f = u40Var2.a;
        float f2 = this.h;
        u40Var.a = uo.s(f, f2, fFloatValue, f2);
        float f3 = u40Var2.b;
        float f4 = this.j;
        u40Var.b = uo.s(f3, f4, fFloatValue, f4);
        float f5 = u40Var2.c;
        float f6 = this.k;
        u40Var.c = uo.s(f5, f6, fFloatValue, f6);
        folderIcon.postInvalidateOnAnimation();
    }
}
