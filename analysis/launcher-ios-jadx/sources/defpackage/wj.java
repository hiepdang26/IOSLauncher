package defpackage;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class wj extends ck {
    public static List A(Iterable iterable) {
        ArrayList arrayList;
        qg0.l(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        vz vzVar = vz.g;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return new ArrayList(collection);
                }
                List listSingletonList = Collections.singletonList(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                qg0.k(listSingletonList, "singletonList(...)");
                return listSingletonList;
            }
        } else {
            if (z) {
                arrayList = new ArrayList((Collection) iterable);
            } else {
                arrayList = new ArrayList();
                z(iterable, arrayList);
            }
            int size2 = arrayList.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return arrayList;
                }
                List listSingletonList2 = Collections.singletonList(arrayList.get(0));
                qg0.k(listSingletonList2, "singletonList(...)");
                return listSingletonList2;
            }
        }
        return vzVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set B(AbstractCollection abstractCollection) {
        xz xzVar = xz.g;
        int size = abstractCollection.size();
        if (size == 0) {
            return xzVar;
        }
        if (size != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(uq0.E(abstractCollection.size()));
            z(abstractCollection, linkedHashSet);
            return linkedHashSet;
        }
        Set setSingleton = Collections.singleton(abstractCollection instanceof List ? ((List) abstractCollection).get(0) : abstractCollection.iterator().next());
        qg0.k(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static final void x(Collection collection, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, o70 o70Var) {
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : collection) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            p02.a(sb, obj, o70Var);
        }
        sb.append(charSequence3);
    }

    public static String y(Collection collection, String str, o70 o70Var, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str2 = str;
        String str3 = (i & 2) != 0 ? "" : "[";
        String str4 = (i & 4) == 0 ? "]" : "";
        if ((i & 32) != 0) {
            o70Var = null;
        }
        StringBuilder sb = new StringBuilder();
        x(collection, sb, str2, str3, str4, "...", o70Var);
        return sb.toString();
    }

    public static final void z(Iterable iterable, AbstractCollection abstractCollection) {
        qg0.l(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }
}
