package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b00 {
    public final ArrayList a;

    public b00(int i) {
        switch (i) {
            case 1:
                this.a = new ArrayList();
                break;
            case 2:
                this.a = new ArrayList();
                break;
            default:
                this.a = new ArrayList();
                break;
        }
    }

    public synchronized lb1 a(Class cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            mb1 mb1Var = (mb1) this.a.get(i);
            if (mb1Var.a.isAssignableFrom(cls)) {
                return mb1Var.b;
            }
        }
        return null;
    }
}
