package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class xj extends m90 {
    public static int u(List list) {
        qg0.l(list, "<this>");
        return list.size() - 1;
    }

    public static List v(Object... objArr) {
        if (objArr.length <= 0) {
            return vz.g;
        }
        List listAsList = Arrays.asList(objArr);
        qg0.k(listAsList, "asList(...)");
        return listAsList;
    }
}
