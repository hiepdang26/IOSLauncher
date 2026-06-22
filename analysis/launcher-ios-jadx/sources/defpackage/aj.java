package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class aj {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public aj(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            um0 um0Var = (um0) entry.getValue();
            List arrayList = (List) this.a.get(um0Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(um0Var, arrayList);
            }
            arrayList.add((bj) entry.getKey());
        }
    }

    public static void a(List list, en0 en0Var, um0 um0Var, dn0 dn0Var) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                bj bjVar = (bj) list.get(size);
                bjVar.getClass();
                try {
                    int i = bjVar.a;
                    Method method = bjVar.b;
                    if (i == 0) {
                        method.invoke(dn0Var, null);
                    } else if (i == 1) {
                        method.invoke(dn0Var, en0Var);
                    } else if (i == 2) {
                        method.invoke(dn0Var, en0Var, um0Var);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
