package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class bm1 {
    public Drawable a;
    public CharSequence b;
    public CharSequence c;
    public int d;
    public View e;
    public TabLayout f;
    public em1 g;

    public final void a() {
        TabLayout tabLayout = this.f;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.j(this, true);
    }
}
