package defpackage;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class cq0 {
    public final oz1 a = new oz1(4);
    public final bq0 b = new bq0(0);
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final int e;
    public int f;

    public cq0(int i) {
        this.e = i;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(int i, Class cls) {
        NavigableMap navigableMapG = g(cls);
        Integer num = (Integer) navigableMapG.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapG.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapG.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public final void c(int i) {
        while (this.f > i) {
            Object objJ = this.a.j();
            n90.g(objJ);
            pe peVarE = e(objJ.getClass());
            this.f -= peVarE.b() * peVarE.a(objJ);
            b(peVarE.a(objJ), objJ.getClass());
            if (Log.isLoggable(peVarE.c(), 2)) {
                peVarE.a(objJ);
            }
        }
    }

    public final synchronized Object d(int i, Class cls) {
        aq0 aq0Var;
        int i2;
        try {
            Integer num = (Integer) g(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i2 = this.f) != 0 && this.e / i2 < 2 && num.intValue() > i * 8)) {
                bq0 bq0Var = this.b;
                g21 g21VarD = (g21) ((ArrayDeque) bq0Var.g).poll();
                if (g21VarD == null) {
                    g21VarD = bq0Var.d();
                }
                aq0Var = (aq0) g21VarD;
                aq0Var.b = i;
                aq0Var.c = cls;
            } else {
                bq0 bq0Var2 = this.b;
                int iIntValue = num.intValue();
                g21 g21VarD2 = (g21) ((ArrayDeque) bq0Var2.g).poll();
                if (g21VarD2 == null) {
                    g21VarD2 = bq0Var2.d();
                }
                aq0Var = (aq0) g21VarD2;
                aq0Var.b = iIntValue;
                aq0Var.c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f(aq0Var, cls);
    }

    public final pe e(Class cls) {
        pe peVar;
        HashMap map = this.d;
        pe peVar2 = (pe) map.get(cls);
        if (peVar2 != null) {
            return peVar2;
        }
        if (cls.equals(int[].class)) {
            peVar = new pe(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            peVar = new pe(0);
        }
        map.put(cls, peVar);
        return peVar;
    }

    public final Object f(aq0 aq0Var, Class cls) {
        pe peVarE = e(cls);
        Object objD = this.a.d(aq0Var);
        if (objD != null) {
            this.f -= peVarE.b() * peVarE.a(objD);
            b(peVarE.a(objD), cls);
        }
        if (objD != null) {
            return objD;
        }
        Log.isLoggable(peVarE.c(), 2);
        int i = aq0Var.b;
        switch (peVarE.a) {
            case 0:
                return new byte[i];
            default:
                return new int[i];
        }
    }

    public final NavigableMap g(Class cls) {
        HashMap map = this.c;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void h(Object obj) {
        Class<?> cls = obj.getClass();
        pe peVarE = e(cls);
        int iA = peVarE.a(obj);
        int iB = peVarE.b() * iA;
        if (iB <= this.e / 2) {
            bq0 bq0Var = this.b;
            g21 g21VarD = (g21) ((ArrayDeque) bq0Var.g).poll();
            if (g21VarD == null) {
                g21VarD = bq0Var.d();
            }
            aq0 aq0Var = (aq0) g21VarD;
            aq0Var.b = iA;
            aq0Var.c = cls;
            this.a.h(aq0Var, obj);
            NavigableMap navigableMapG = g(cls);
            Integer num = (Integer) navigableMapG.get(Integer.valueOf(aq0Var.b));
            Integer numValueOf = Integer.valueOf(aq0Var.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapG.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iB;
            c(this.e);
        }
    }

    public final synchronized void i(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                c(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
