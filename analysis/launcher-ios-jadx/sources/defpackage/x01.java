package defpackage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class x01 extends tt1 {
    public final st1 a;
    public ut1 b;

    public x01(st1 st1Var) {
        this.a = st1Var;
    }

    @Override // defpackage.tt1
    public final void b(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        int i3 = 0;
        while (true) {
            st1 st1Var = this.a;
            if (i3 >= st1Var.v()) {
                return;
            }
            View viewU = st1Var.u(i3);
            if (viewU == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException("LayoutManager returned a null child at pos " + i3 + "/" + st1Var.v() + " while transforming pages");
            }
            ((th1) this.b).getClass();
            int i4 = SlidingUpWidgetsAppStyle.W;
            ViewPager2 viewPager2 = (ViewPager2) viewU.getParent().getParent();
            float fJ = ((u81.J(viewU) - i) + f2) * (-((r3.a * 2) + r3.b));
            if (viewPager2.getOrientation() == 0) {
                WeakHashMap weakHashMap = qs1.a;
                if (viewPager2.getLayoutDirection() == 1) {
                    viewU.setTranslationX(-fJ);
                } else {
                    viewU.setTranslationX(fJ);
                }
            } else {
                viewU.setTranslationY(fJ);
            }
            i3++;
        }
    }

    @Override // defpackage.tt1
    public final void a(int i) {
    }

    @Override // defpackage.tt1
    public final void c(int i) {
    }
}
