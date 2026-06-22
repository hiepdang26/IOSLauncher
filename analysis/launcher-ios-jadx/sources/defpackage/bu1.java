package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class bu1 {
    public Interpolator c;
    public hg0 d;
    public boolean e;
    public long b = -1;
    public final au1 f = new au1(this);
    public final ArrayList a = new ArrayList();

    public final void a() {
        if (this.e) {
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zt1) obj).b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zt1 zt1Var = (zt1) obj;
            long j = this.b;
            if (j >= 0) {
                zt1Var.c(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null && (view = (View) zt1Var.a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                zt1Var.d(this.f);
            }
            zt1Var.e();
        }
        this.e = true;
    }
}
