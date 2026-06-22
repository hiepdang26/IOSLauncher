package androidx.work;

import defpackage.is;
import defpackage.qg0;
import defpackage.uf0;
import defpackage.wr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends uf0 {
    @Override // defpackage.uf0
    public final wr a(ArrayList arrayList) throws Throwable {
        is isVar = new is(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((wr) obj).a);
            qg0.k(mapUnmodifiableMap, "input.keyValueMap");
            linkedHashMap.putAll(mapUnmodifiableMap);
        }
        isVar.a(linkedHashMap);
        wr wrVar = new wr(isVar.a);
        wr.c(wrVar);
        return wrVar;
    }
}
