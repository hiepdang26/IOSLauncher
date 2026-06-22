package defpackage;

import android.os.Handler;
import androidx.lifecycle.a;

/* JADX INFO: loaded from: classes.dex */
public final class o31 implements en0 {
    public static final o31 o = new o31();
    public int g;
    public int h;
    public Handler k;
    public final r1 m;
    public final ow1 n;
    public boolean i = true;
    public boolean j = true;
    public final a l = new a(this);

    public o31() {
        int i = 23;
        this.m = new r1(this, i);
        this.n = new ow1(this, i);
    }

    public final void b() {
        int i = this.h + 1;
        this.h = i;
        if (i == 1) {
            if (this.i) {
                this.l.d(um0.ON_RESUME);
                this.i = false;
            } else {
                Handler handler = this.k;
                qg0.h(handler);
                handler.removeCallbacks(this.m);
            }
        }
    }

    @Override // defpackage.en0
    public final a l() {
        return this.l;
    }
}
