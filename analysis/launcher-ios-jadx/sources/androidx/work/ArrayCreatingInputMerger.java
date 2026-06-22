package androidx.work;

import defpackage.is;
import defpackage.qg0;
import defpackage.uf0;
import defpackage.wr;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends uf0 {
    @Override // defpackage.uf0
    public final wr a(ArrayList arrayList) throws Throwable {
        Object objNewInstance;
        is isVar = new is(1);
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((wr) obj).a);
            qg0.k(mapUnmodifiableMap, "input.keyValueMap");
            for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj2 = map.get(str);
                qg0.k(str, "key");
                if (obj2 != null) {
                    Class<?> cls2 = obj2.getClass();
                    if (cls2.equals(cls)) {
                        qg0.k(value, "value");
                        int length = Array.getLength(obj2);
                        int length2 = Array.getLength(value);
                        Class<?> componentType = obj2.getClass().getComponentType();
                        qg0.h(componentType);
                        Object objNewInstance2 = Array.newInstance(componentType, length + length2);
                        System.arraycopy(obj2, 0, objNewInstance2, 0, length);
                        System.arraycopy(value, 0, objNewInstance2, length, length2);
                        qg0.k(objNewInstance2, "newArray");
                        value = objNewInstance2;
                    } else {
                        if (!qg0.d(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        int length3 = Array.getLength(obj2);
                        objNewInstance = Array.newInstance(cls, length3 + 1);
                        System.arraycopy(obj2, 0, objNewInstance, 0, length3);
                        Array.set(objNewInstance, length3, value);
                        qg0.k(objNewInstance, "newArray");
                        value = objNewInstance;
                    }
                } else if (!cls.isArray()) {
                    objNewInstance = Array.newInstance(cls, 1);
                    Array.set(objNewInstance, 0, value);
                    qg0.k(objNewInstance, "newArray");
                    value = objNewInstance;
                }
                qg0.k(value, "if (existingValue == nul…      }\n                }");
                map.put(str, value);
            }
        }
        isVar.a(map);
        wr wrVar = new wr(isVar.a);
        wr.c(wrVar);
        return wrVar;
    }
}
