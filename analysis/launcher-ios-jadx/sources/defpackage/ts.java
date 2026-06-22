package defpackage;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ts {
    public final Class a;
    public final List b;
    public final nb1 c;
    public final wb2 d;
    public final String e;

    public ts(Class cls, Class cls2, Class cls3, List list, nb1 nb1Var, wb2 wb2Var) {
        this.a = cls;
        this.b = list;
        this.c = nb1Var;
        this.d = wb2Var;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.eb1 a(int r17, int r18, defpackage.t3 r19, defpackage.gs r20, defpackage.g01 r21) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ts.a(int, int, t3, gs, g01):eb1");
    }

    public final eb1 b(gs gsVar, int i, int i2, g01 g01Var, List list) throws q90 {
        List list2 = this.b;
        int size = list2.size();
        eb1 eb1VarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            ib1 ib1Var = (ib1) list2.get(i3);
            try {
                if (ib1Var.b(gsVar.r(), g01Var)) {
                    eb1VarA = ib1Var.a(gsVar.r(), i, i2, g01Var);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Objects.toString(ib1Var);
                }
                list.add(e);
            }
            if (eb1VarA != null) {
                break;
            }
        }
        if (eb1VarA != null) {
            return eb1VarA;
        }
        throw new q90(this.e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
