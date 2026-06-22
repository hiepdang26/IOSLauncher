package defpackage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class mj {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public Object g;

    public mj(Set set, String str, String str2) {
        sg1 sg1Var = sg1.b;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.a = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.c = map;
        this.d = str;
        this.e = str2;
        this.f = sg1Var;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        this.b = Collections.unmodifiableSet(hashSet);
    }

    public mj(s90 s90Var, s90 s90Var2, s90 s90Var3, s90 s90Var4, d00 d00Var, d00 d00Var2) {
        this.g = os.t(150, new fz1(this, 13));
        this.a = s90Var;
        this.b = s90Var2;
        this.c = s90Var3;
        this.d = s90Var4;
        this.e = d00Var;
        this.f = d00Var2;
    }
}
