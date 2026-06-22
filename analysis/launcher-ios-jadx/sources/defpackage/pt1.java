package defpackage;

import androidx.preference.Preference;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes.dex */
public final class pt1 extends o81 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ pt1(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.o81
    public final void a() {
        switch (this.a) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.b;
                viewPager2.j = true;
                viewPager2.q.l = true;
                break;
            default:
                ((ol1) this.b).o();
                break;
        }
    }

    @Override // defpackage.o81
    public final void b(int i, int i2, Preference preference) {
        a();
    }

    @Override // defpackage.o81
    public final void c(int i, int i2) {
        a();
    }

    @Override // defpackage.o81
    public final void d(int i, int i2) {
        a();
    }

    @Override // defpackage.o81
    public final void e(int i, int i2) {
        a();
    }
}
