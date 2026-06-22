package defpackage;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class pi0 {
    public final ComponentName a;
    public boolean b;
    public int c;

    public pi0(ComponentName componentName) {
        this.a = componentName;
    }

    public abstract void a(Intent intent);

    public final void b(int i) {
        if (!this.b) {
            this.b = true;
            this.c = i;
        } else {
            if (this.c == i) {
                return;
            }
            StringBuilder sbL = uo.l(i, "Given job ID ", " is different than previous ");
            sbL.append(this.c);
            throw new IllegalArgumentException(sbL.toString());
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
