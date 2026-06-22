package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class gf1 extends hf1 {
    public static List V(ef1 ef1Var) {
        Iterator it = ef1Var.iterator();
        if (!it.hasNext()) {
            return vz.g;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            List listSingletonList = Collections.singletonList(next);
            qg0.k(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
