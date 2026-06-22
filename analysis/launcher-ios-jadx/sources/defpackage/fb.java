package defpackage;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class fb implements mu0 {
    public Object g;

    public fb(int i) {
        switch (i) {
            case 1:
                this.g = new LinkedHashMap();
                break;
            default:
                char[] cArr = vq1.a;
                this.g = new ArrayDeque(20);
                break;
        }
    }

    public abstract void a(qm0 qm0Var);

    public abstract String b();

    public void c(g21 g21Var) {
        ArrayDeque arrayDeque = (ArrayDeque) this.g;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(g21Var);
        }
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new re((z20) this.g, 2);
    }

    public fb(z20 z20Var) {
        this.g = z20Var;
    }
}
