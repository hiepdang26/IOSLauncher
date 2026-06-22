package defpackage;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: classes.dex */
public final class qt1 extends tt1 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ qt1(ViewPager2 viewPager2, int i) {
        this.a = i;
        this.b = viewPager2;
    }

    @Override // defpackage.tt1
    public void a(int i) {
        switch (this.a) {
            case 0:
                if (i == 0) {
                    ((ViewPager2) this.b).c();
                    return;
                }
                return;
            case 1:
            default:
                return;
            case 2:
                try {
                    ArrayList arrayList = (ArrayList) this.b;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((tt1) obj).a(i);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
        }
    }

    @Override // defpackage.tt1
    public void b(int i, float f, int i2) {
        switch (this.a) {
            case 2:
                try {
                    ArrayList arrayList = (ArrayList) this.b;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        ((tt1) obj).b(i, f, i2);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                return;
        }
    }

    @Override // defpackage.tt1
    public final void c(int i) {
        switch (this.a) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.b;
                if (viewPager2.i != i) {
                    viewPager2.i = i;
                    viewPager2.y.o();
                    return;
                }
                return;
            case 1:
                ViewPager2 viewPager22 = (ViewPager2) this.b;
                viewPager22.clearFocus();
                if (viewPager22.hasFocus()) {
                    viewPager22.o.requestFocus(2);
                    return;
                }
                return;
            default:
                try {
                    ArrayList arrayList = (ArrayList) this.b;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((tt1) obj).c(i);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
        }
    }

    public qt1() {
        this.a = 2;
        this.b = new ArrayList(3);
    }
}
