package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class x91 {
    public final q11 a;
    public final b00 b;
    public final q11 c;
    public final b00 d;
    public final is e;
    public final wk0 f;
    public final b00 g;
    public final oz1 h = new oz1(5);
    public final zo0 i = new zo0();
    public final wb2 j;

    public x91() {
        wb2 wb2Var = new wb2(new l21(20), new jl1(18), new iy());
        this.j = wb2Var;
        this.a = new q11(wb2Var);
        this.b = new b00(0);
        this.c = new q11(19);
        this.d = new b00(2);
        this.e = new is(0);
        this.f = new wk0();
        this.g = new b00(1);
        List listAsList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        q11 q11Var = this.c;
        synchronized (q11Var) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) q11Var.h);
                ((ArrayList) q11Var.h).clear();
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((ArrayList) q11Var.h).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) q11Var.h).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, zz zzVar) {
        b00 b00Var = this.b;
        synchronized (b00Var) {
            b00Var.a.add(new a00(cls, zzVar));
        }
    }

    public final void b(Class cls, lb1 lb1Var) {
        b00 b00Var = this.d;
        synchronized (b00Var) {
            b00Var.a.add(new mb1(cls, lb1Var));
        }
    }

    public final void c(Class cls, Class cls2, mu0 mu0Var) {
        q11 q11Var = this.a;
        synchronized (q11Var) {
            ((qm0) q11Var.h).a(cls, cls2, mu0Var);
            ((HashMap) ((fz1) q11Var.i).h).clear();
        }
    }

    public final void d(String str, Class cls, Class cls2, ib1 ib1Var) {
        q11 q11Var = this.c;
        synchronized (q11Var) {
            q11Var.G(str).add(new jb1(cls, cls2, ib1Var));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        Class cls4 = cls;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayListH = this.c.H(cls4, cls2);
        int size = arrayListH.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Class cls5 = (Class) arrayListH.get(i);
            ArrayList arrayListB = this.f.b(cls5, cls3);
            int size2 = arrayListB.size();
            int i3 = 0;
            while (i3 < size2) {
                int i4 = i3 + 1;
                Class cls6 = (Class) arrayListB.get(i3);
                q11 q11Var = this.c;
                synchronized (q11Var) {
                    arrayList = new ArrayList();
                    ArrayList arrayList3 = (ArrayList) q11Var.h;
                    int size3 = arrayList3.size();
                    int i5 = 0;
                    while (i5 < size3) {
                        Object obj = arrayList3.get(i5);
                        i5++;
                        ArrayList arrayList4 = arrayList3;
                        String str = (String) obj;
                        int i6 = size3;
                        List list = (List) ((HashMap) q11Var.i).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                jb1 jb1Var = (jb1) it.next();
                                Iterator it2 = it;
                                if (jb1Var.a.isAssignableFrom(cls4) && cls5.isAssignableFrom(jb1Var.b)) {
                                    arrayList.add(jb1Var.c);
                                }
                                it = it2;
                            }
                        }
                        size3 = i6;
                        arrayList3 = arrayList4;
                    }
                }
                arrayList2.add(new ts(cls4, cls5, cls6, arrayList, this.f.a(cls5, cls6), this.j));
                cls4 = cls;
                i3 = i4;
            }
            cls4 = cls;
            i = i2;
        }
        return arrayList2;
    }

    public final ArrayList f() {
        ArrayList arrayList;
        b00 b00Var = this.g;
        synchronized (b00Var) {
            arrayList = b00Var.a;
        }
        if (arrayList.isEmpty()) {
            throw new w91("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List g(Object obj) {
        List listUnmodifiableList;
        q11 q11Var = this.a;
        q11Var.getClass();
        Class<?> cls = obj.getClass();
        synchronized (q11Var) {
            nu0 nu0Var = (nu0) ((HashMap) ((fz1) q11Var.i).h).get(cls);
            listUnmodifiableList = nu0Var == null ? null : nu0Var.a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(((qm0) q11Var.h).c(cls));
                if (((nu0) ((HashMap) ((fz1) q11Var.i).h).put(cls, new nu0(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new w91("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = listUnmodifiableList.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z = true;
        for (int i = 0; i < size; i++) {
            lu0 lu0Var = (lu0) listUnmodifiableList.get(i);
            if (lu0Var.a(obj)) {
                if (z) {
                    arrayList = new ArrayList(size - i);
                    z = false;
                }
                arrayList.add(lu0Var);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new w91("Found ModelLoaders for model class: " + listUnmodifiableList + ", but none that handle this specific model instance: " + obj);
    }

    public final gs h(Object obj) {
        gs gsVarB;
        is isVar = this.e;
        synchronized (isVar) {
            try {
                n90.g(obj);
                fs fsVar = (fs) isVar.a.get(obj.getClass());
                if (fsVar == null) {
                    Iterator it = isVar.a.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        fs fsVar2 = (fs) it.next();
                        if (fsVar2.a().isAssignableFrom(obj.getClass())) {
                            fsVar = fsVar2;
                            break;
                        }
                    }
                }
                if (fsVar == null) {
                    fsVar = is.b;
                }
                gsVarB = fsVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return gsVarB;
    }

    public final void i(fs fsVar) {
        is isVar = this.e;
        synchronized (isVar) {
            isVar.a.put(fsVar.a(), fsVar);
        }
    }

    public final void j(af0 af0Var) {
        b00 b00Var = this.g;
        synchronized (b00Var) {
            b00Var.a.add(af0Var);
        }
    }

    public final void k(Class cls, Class cls2, nb1 nb1Var) {
        wk0 wk0Var = this.f;
        synchronized (wk0Var) {
            wk0Var.a.add(new qo1(cls, cls2, nb1Var));
        }
    }
}
