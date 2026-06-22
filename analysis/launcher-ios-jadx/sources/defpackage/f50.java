package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f50 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f50(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public final void a(Object obj) {
        switch (this.a) {
            case 0:
                g50 g50Var = (g50) obj;
                if (g50Var == null) {
                    g50Var = new g50(-3);
                }
                ((oz1) this.b).g(g50Var);
                return;
            default:
                g50 g50Var2 = (g50) obj;
                synchronized (h50.c) {
                    try {
                        ug1 ug1Var = h50.d;
                        ArrayList arrayList = (ArrayList) ug1Var.get((String) this.b);
                        if (arrayList == null) {
                            return;
                        }
                        ug1Var.remove((String) this.b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((f50) arrayList.get(i)).a(g50Var2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
