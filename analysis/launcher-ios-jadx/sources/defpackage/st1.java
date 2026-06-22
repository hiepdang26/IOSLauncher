package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes.dex */
public final class st1 extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st1(ViewPager2 viewPager2) {
        super(1);
        this.E = viewPager2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void E0(i91 i91Var, int[] iArr) {
        ViewPager2 viewPager2 = this.E;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.E0(i91Var, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // defpackage.u81
    public final void W(c91 c91Var, i91 i91Var, r0 r0Var) {
        super.W(c91Var, i91Var, r0Var);
        this.E.y.getClass();
    }

    @Override // defpackage.u81
    public final void X(c91 c91Var, i91 i91Var, View view, r0 r0Var) {
        int iJ;
        int iJ2;
        ViewPager2 viewPager2 = (ViewPager2) this.E.y.j;
        if (viewPager2.getOrientation() == 1) {
            viewPager2.l.getClass();
            iJ = u81.J(view);
        } else {
            iJ = 0;
        }
        if (viewPager2.getOrientation() == 0) {
            viewPager2.l.getClass();
            iJ2 = u81.J(view);
        } else {
            iJ2 = 0;
        }
        r0Var.j(nx0.v(iJ, 1, iJ2, 1, false, false));
    }

    @Override // defpackage.u81
    public final boolean j0(c91 c91Var, i91 i91Var, int i, Bundle bundle) {
        this.E.y.getClass();
        return super.j0(c91Var, i91Var, i, bundle);
    }

    @Override // defpackage.u81
    public final boolean o0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }
}
