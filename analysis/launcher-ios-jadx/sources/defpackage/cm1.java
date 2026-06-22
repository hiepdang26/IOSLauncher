package defpackage;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class cm1 implements nt1 {
    public final WeakReference g;
    public int h;
    public int i;

    public cm1(TabLayout tabLayout) {
        this.g = new WeakReference(tabLayout);
    }

    @Override // defpackage.nt1
    public final void a(int i) {
        this.h = this.i;
        this.i = i;
    }

    @Override // defpackage.nt1
    public final void b(int i) {
        TabLayout tabLayout = (TabLayout) this.g.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i2 = this.i;
        tabLayout.j(tabLayout.g(i), i2 == 0 || (i2 == 2 && this.h == 0));
    }

    @Override // defpackage.nt1
    public final void c(float f, int i) {
        TabLayout tabLayout = (TabLayout) this.g.get();
        if (tabLayout != null) {
            int i2 = this.i;
            tabLayout.l(i, f, i2 != 2 || this.h == 1, (i2 == 2 && this.h == 0) ? false : true);
        }
    }
}
