package defpackage;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.b;

/* JADX INFO: loaded from: classes.dex */
public final class lx extends ts1 {
    public final int a;
    public vs1 b;
    public final o1 c = new o1(this, 18);
    public final /* synthetic */ DrawerLayout d;

    public lx(DrawerLayout drawerLayout, int i) {
        this.d = drawerLayout;
        this.a = i;
    }

    @Override // defpackage.ts1
    public final int a(int i, View view) {
        DrawerLayout drawerLayout = this.d;
        if (drawerLayout.checkDrawerViewAbsoluteGravity(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // defpackage.ts1
    public final int b(View view, int i) {
        return view.getTop();
    }

    @Override // defpackage.ts1
    public final int c(View view) {
        if (this.d.isDrawerView(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // defpackage.ts1
    public final void e(int i, int i2) {
        int i3 = i & 1;
        DrawerLayout drawerLayout = this.d;
        View viewFindDrawerWithGravity = i3 == 1 ? drawerLayout.findDrawerWithGravity(3) : drawerLayout.findDrawerWithGravity(5);
        if (viewFindDrawerWithGravity == null || drawerLayout.getDrawerLockMode(viewFindDrawerWithGravity) != 0) {
            return;
        }
        this.b.b(i2, viewFindDrawerWithGravity);
    }

    @Override // defpackage.ts1
    public final void f() {
        this.d.postDelayed(this.c, 160L);
    }

    @Override // defpackage.ts1
    public final void g(int i, View view) {
        ((b) view.getLayoutParams()).c = false;
        int i2 = this.a == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.d;
        View viewFindDrawerWithGravity = drawerLayout.findDrawerWithGravity(i2);
        if (viewFindDrawerWithGravity != null) {
            drawerLayout.closeDrawer(viewFindDrawerWithGravity);
        }
    }

    @Override // defpackage.ts1
    public final void h(int i) {
        this.d.updateDrawerState(i, this.b.t);
    }

    @Override // defpackage.ts1
    public final void i(View view, int i, int i2) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.d;
        float width2 = (drawerLayout.checkDrawerViewAbsoluteGravity(view, 3) ? i + width : drawerLayout.getWidth() - i) / width;
        drawerLayout.setDrawerViewOffset(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override // defpackage.ts1
    public final void j(View view, float f, float f2) {
        int i;
        DrawerLayout drawerLayout = this.d;
        float drawerViewOffset = drawerLayout.getDrawerViewOffset(view);
        int width = view.getWidth();
        if (drawerLayout.checkDrawerViewAbsoluteGravity(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f < 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) {
                width2 -= width;
            }
            i = width2;
        }
        this.b.q(i, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // defpackage.ts1
    public final boolean k(int i, View view) {
        DrawerLayout drawerLayout = this.d;
        return drawerLayout.isDrawerView(view) && drawerLayout.checkDrawerViewAbsoluteGravity(view, this.a) && drawerLayout.getDrawerLockMode(view) == 0;
    }
}
