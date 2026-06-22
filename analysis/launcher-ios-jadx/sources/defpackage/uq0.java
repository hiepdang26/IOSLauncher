package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class uq0 extends hs0 {
    public static int E(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static Map F(ArrayList arrayList) {
        wz wzVar = wz.g;
        int size = arrayList.size();
        if (size == 0) {
            return wzVar;
        }
        if (size == 1) {
            h11 h11Var = (h11) arrayList.get(0);
            qg0.l(h11Var, "pair");
            Map mapSingletonMap = Collections.singletonMap(h11Var.g, h11Var.h);
            qg0.k(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(E(arrayList.size()));
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            h11 h11Var2 = (h11) obj;
            linkedHashMap.put(h11Var2.g, h11Var2.h);
        }
        return linkedHashMap;
    }
}
