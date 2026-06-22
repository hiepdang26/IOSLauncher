package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class uy1 extends e42 {
    public final cz1 h;
    public final List i;
    public final ArrayList j;
    public final ArrayList k = new ArrayList();
    public boolean l;

    static {
        ka0.r("WorkContinuationImpl");
    }

    public uy1(cz1 cz1Var, List list) {
        this.h = cz1Var;
        this.i = list;
        this.j = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            String string = ((mz0) list.get(i)).a.toString();
            qg0.k(string, "id.toString()");
            this.j.add(string);
            this.k.add(string);
        }
    }

    public static HashSet y(uy1 uy1Var) {
        HashSet hashSet = new HashSet();
        uy1Var.getClass();
        return hashSet;
    }
}
