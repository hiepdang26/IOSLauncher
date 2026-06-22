package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class r80 {
    public final wi1 a;
    public final Handler b;
    public final ArrayList c;
    public final sa1 d;
    public final oc e;
    public boolean f;
    public boolean g;
    public na1 h;
    public p80 i;
    public boolean j;
    public p80 k;
    public Bitmap l;
    public p80 m;
    public int n;
    public int o;
    public int p;

    public r80(a aVar, wi1 wi1Var, int i, int i2, Bitmap bitmap) {
        bq1 bq1Var = bq1.b;
        oc ocVar = aVar.g;
        o90 o90Var = aVar.i;
        sa1 sa1VarE = a.e(o90Var.getBaseContext());
        na1 na1VarF = a.e(o90Var.getBaseContext()).l().a(((xa1) ((xa1) ((xa1) new xa1().f(qv.c)).D()).w()).p(i, i2));
        this.c = new ArrayList();
        this.d = sa1VarE;
        Handler handler = new Handler(Looper.getMainLooper(), new h8(this, 1));
        this.e = ocVar;
        this.b = handler;
        this.h = na1VarF;
        this.a = wi1Var;
        c(bq1Var, bitmap);
    }

    public final void a() {
        int i;
        if (!this.f || this.g) {
            return;
        }
        p80 p80Var = this.m;
        if (p80Var != null) {
            this.m = null;
            b(p80Var);
            return;
        }
        this.g = true;
        wi1 wi1Var = this.a;
        s80 s80Var = wi1Var.l;
        int i2 = s80Var.c;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) ((i2 <= 0 || (i = wi1Var.k) < 0) ? 0 : (i < 0 || i >= i2) ? -1 : ((o80) s80Var.e.get(i)).i));
        int i3 = (wi1Var.k + 1) % wi1Var.l.c;
        wi1Var.k = i3;
        this.k = new p80(this.b, i3, jUptimeMillis);
        na1 na1VarM = this.h.a((xa1) new xa1().u(new fy0(Double.valueOf(Math.random())))).M(wi1Var);
        na1VarM.K(this.k, na1VarM);
    }

    public final void b(p80 p80Var) {
        this.g = false;
        boolean z = this.j;
        Handler handler = this.b;
        if (z) {
            handler.obtainMessage(2, p80Var).sendToTarget();
            return;
        }
        if (!this.f) {
            this.m = p80Var;
            return;
        }
        if (p80Var.m != null) {
            Bitmap bitmap = this.l;
            if (bitmap != null) {
                this.e.j(bitmap);
                this.l = null;
            }
            p80 p80Var2 = this.i;
            this.i = p80Var;
            ArrayList arrayList = this.c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                l80 l80Var = (l80) ((q80) arrayList.get(size));
                Object callback = l80Var.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    l80Var.stop();
                    l80Var.invalidateSelf();
                } else {
                    l80Var.invalidateSelf();
                    p80 p80Var3 = ((r80) l80Var.g.b).i;
                    if ((p80Var3 != null ? p80Var3.k : -1) == r5.a.l.c - 1) {
                        l80Var.l++;
                    }
                    int i = l80Var.m;
                    if (i != -1 && l80Var.l >= i) {
                        l80Var.stop();
                    }
                }
            }
            if (p80Var2 != null) {
                handler.obtainMessage(2, p80Var2).sendToTarget();
            }
        }
        a();
    }

    public final void c(ro1 ro1Var, Bitmap bitmap) {
        n90.h(ro1Var, "Argument must not be null");
        n90.h(bitmap, "Argument must not be null");
        this.l = bitmap;
        this.h = this.h.a(new xa1().A(ro1Var, true));
        this.n = vq1.c(bitmap);
        this.o = bitmap.getWidth();
        this.p = bitmap.getHeight();
    }
}
