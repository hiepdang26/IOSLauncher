package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class mk1 {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final wc0[] b = new wc0[4];

    public static ArrayList a(wc0 wc0Var) {
        ArrayList arrayList = new ArrayList((ArrayList) wc0Var.h);
        ((ArrayList) wc0Var.h).clear();
        ((HashMap) wc0Var.i).clear();
        ((HashMap) wc0Var.j).clear();
        int i = 0;
        ((StringBuilder) wc0Var.k).setLength(0);
        wc0Var.l = null;
        wc0Var.g = false;
        synchronized (b) {
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    wc0[] wc0VarArr = b;
                    if (wc0VarArr[i] == null) {
                        wc0VarArr[i] = wc0Var;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static wc0 b() {
        synchronized (b) {
            for (int i = 0; i < 4; i++) {
                try {
                    wc0[] wc0VarArr = b;
                    wc0 wc0Var = wc0VarArr[i];
                    if (wc0Var != null) {
                        wc0VarArr[i] = null;
                        return wc0Var;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            wc0 wc0Var2 = new wc0();
            wc0Var2.h = new ArrayList();
            wc0Var2.i = new HashMap();
            wc0Var2.j = new HashMap();
            wc0Var2.k = new StringBuilder(128);
            return wc0Var2;
        }
    }
}
