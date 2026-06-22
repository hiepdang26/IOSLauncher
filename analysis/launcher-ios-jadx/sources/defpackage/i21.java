package defpackage;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class i21 {
    public static final int a = z51.pooling_container_listener_holder_tag;
    public static final int b = z51.is_pooling_container_tag;

    public static final void a(View view) {
        qg0.l(view, "<this>");
        zs1 zs1Var = new zs1(view, null);
        ff1 ff1Var = new ff1();
        ff1Var.j = zs1Var.create(ff1Var, ff1Var);
        while (ff1Var.hasNext()) {
            View view2 = (View) ff1Var.next();
            int i = a;
            j21 j21Var = (j21) view2.getTag(i);
            if (j21Var == null) {
                j21Var = new j21();
                view2.setTag(i, j21Var);
            }
            ArrayList arrayList = j21Var.a;
            int iU = xj.u(arrayList);
            if (-1 < iU) {
                arrayList.get(iU).getClass();
                throw new ClassCastException();
            }
        }
    }
}
