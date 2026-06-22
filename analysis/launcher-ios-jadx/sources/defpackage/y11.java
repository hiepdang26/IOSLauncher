package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class y11 {
    public static final ArrayList d = new ArrayList();
    public Object a;
    public nk1 b;
    public y11 c;

    public static y11 a(nk1 nk1Var, Object obj) {
        ArrayList arrayList = d;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                if (size <= 0) {
                    y11 y11Var = new y11();
                    y11Var.a = obj;
                    y11Var.b = nk1Var;
                    return y11Var;
                }
                y11 y11Var2 = (y11) arrayList.remove(size - 1);
                y11Var2.a = obj;
                y11Var2.b = nk1Var;
                y11Var2.c = null;
                return y11Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
