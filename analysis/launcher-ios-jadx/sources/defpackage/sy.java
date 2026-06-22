package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class sy extends ta1 {
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sy(int i) {
        super(4);
        this.h = i;
    }

    @Override // defpackage.ta1
    public final void g(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.h) {
            case 0:
                RectF rectFF = ta1.f(tabLayout, view);
                RectF rectFF2 = ta1.f(tabLayout, view2);
                if (rectFF.left < rectFF2.left) {
                    double d = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d));
                    fCos = (float) Math.sin(d);
                } else {
                    double d2 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d2);
                    fCos = (float) (1.0d - Math.cos(d2));
                }
                drawable.setBounds(n5.c(fSin, (int) rectFF.left, (int) rectFF2.left), drawable.getBounds().top, n5.c(fCos, (int) rectFF.right, (int) rectFF2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFF3 = ta1.f(tabLayout, view);
                float fB = f < 0.5f ? n5.b(1.0f, 0.0f, 0.0f, 0.5f, f) : n5.b(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFF3.left, drawable.getBounds().top, (int) rectFF3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fB * 255.0f));
                break;
        }
    }
}
