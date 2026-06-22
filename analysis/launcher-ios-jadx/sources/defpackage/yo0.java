package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class yo0 {
    public final wb2 a;
    public final List b;
    public final String c;

    public yo0(Class cls, Class cls2, Class cls3, List list, wb2 wb2Var) {
        this.a = wb2Var;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.b = list;
        this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final eb1 a(int i, int i2, t3 t3Var, gs gsVar, g01 g01Var) {
        wb2 wb2Var = this.a;
        List list = (List) wb2Var.h();
        try {
            List list2 = this.b;
            int size = list2.size();
            eb1 eb1VarA = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    eb1VarA = ((ts) list2.get(i3)).a(i, i2, t3Var, gsVar, g01Var);
                } catch (q90 e) {
                    list.add(e);
                }
                if (eb1VarA != null) {
                    break;
                }
            }
            if (eb1VarA != null) {
                return eb1VarA;
            }
            throw new q90(this.c, new ArrayList(list));
        } finally {
            wb2Var.z(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }
}
