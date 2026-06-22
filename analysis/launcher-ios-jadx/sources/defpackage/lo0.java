package defpackage;

import androidx.lifecycle.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class lo0 {
    public final mc1 g;
    public boolean h;
    public int i = -1;
    public final /* synthetic */ b j;

    public lo0(b bVar, mc1 mc1Var) {
        this.j = bVar;
        this.g = mc1Var;
    }

    public final void b(boolean z) {
        if (z == this.h) {
            return;
        }
        this.h = z;
        int i = z ? 1 : -1;
        b bVar = this.j;
        int i2 = bVar.c;
        bVar.c = i + i2;
        if (!bVar.d) {
            bVar.d = true;
            while (true) {
                try {
                    int i3 = bVar.c;
                    if (i2 == i3) {
                        break;
                    } else {
                        i2 = i3;
                    }
                } finally {
                    bVar.d = false;
                }
            }
        }
        if (this.h) {
            bVar.c(this);
        }
    }

    public abstract boolean d();

    public void c() {
    }
}
