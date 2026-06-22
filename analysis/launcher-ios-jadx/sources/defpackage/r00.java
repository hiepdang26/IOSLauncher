package defpackage;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponentsImpl;

/* JADX INFO: loaded from: classes.dex */
public final class r00 {
    public static volatile r00 q;
    public static final s00 r;
    public static final HashMap s;
    public final HashMap a;
    public final HashMap b;
    public final ConcurrentHashMap c;
    public final o00 d = new o00(0);
    public final ka0 e;
    public final bb0 f;
    public final fa g;
    public final w1 h;
    public final mk1 i;
    public final ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final vp0 p;

    static {
        s00 s00Var = new s00();
        s00Var.a = s00.b;
        r = s00Var;
        s = new HashMap();
    }

    public r00() {
        s00 s00Var = r;
        s00Var.getClass();
        AndroidComponentsImpl androidComponentsImpl = AndroidComponentsImpl.c;
        this.p = androidComponentsImpl != null ? androidComponentsImpl.a : new jl1(26);
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        ka0 ka0Var = androidComponentsImpl != null ? androidComponentsImpl.b : null;
        this.e = ka0Var;
        this.f = ka0Var != null ? new bb0(this, Looper.getMainLooper()) : null;
        this.g = new fa(this);
        this.h = new w1(this);
        this.i = new mk1();
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.j = s00Var.a;
    }

    public static void a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                a(arrayList, cls.getInterfaces());
            }
        }
    }

    public static r00 b() {
        r00 r00Var;
        r00 r00Var2 = q;
        if (r00Var2 != null) {
            return r00Var2;
        }
        synchronized (r00.class) {
            try {
                r00Var = q;
                if (r00Var == null) {
                    r00Var = new r00();
                    q = r00Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r00Var;
    }

    public final void c(y11 y11Var) {
        Object obj = y11Var.a;
        nk1 nk1Var = y11Var.b;
        y11Var.a = null;
        y11Var.b = null;
        y11Var.c = null;
        ArrayList arrayList = y11.d;
        synchronized (arrayList) {
            if (arrayList.size() < 10000) {
                arrayList.add(y11Var);
            }
        }
        if (nk1Var.c) {
            d(nk1Var, obj);
        }
    }

    public final void d(nk1 nk1Var, Object obj) {
        try {
            nk1Var.b.a.invoke(nk1Var.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            boolean z = obj instanceof kk1;
            boolean z2 = this.k;
            vp0 vp0Var = this.p;
            if (!z) {
                if (z2) {
                    vp0Var.t(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nk1Var.a.getClass(), cause);
                }
                if (this.m) {
                    e(new kk1(cause, obj, nk1Var.a));
                    return;
                }
                return;
            }
            if (z2) {
                Level level = Level.SEVERE;
                vp0Var.t(level, "SubscriberExceptionEvent subscriber " + nk1Var.a.getClass() + " threw an exception", cause);
                kk1 kk1Var = (kk1) obj;
                vp0Var.t(level, "Initial event " + kk1Var.b + " caused exception in " + kk1Var.c, kk1Var.a);
            }
        }
    }

    public final void e(Object obj) {
        q00 q00Var = (q00) this.d.get();
        ArrayList arrayList = q00Var.a;
        arrayList.add(obj);
        if (q00Var.b) {
            return;
        }
        q00Var.c = this.e == null || Looper.getMainLooper() == Looper.myLooper();
        q00Var.b = true;
        while (!arrayList.isEmpty()) {
            try {
                f(arrayList.remove(0), q00Var);
            } finally {
                q00Var.b = false;
                q00Var.c = false;
            }
        }
    }

    public final void f(Object obj, q00 q00Var) {
        boolean zG;
        List list;
        Class<?> cls = obj.getClass();
        if (this.o) {
            HashMap map = s;
            synchronized (map) {
                try {
                    List list2 = (List) map.get(cls);
                    list = list2;
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                            arrayList.add(superclass);
                            a(arrayList, superclass.getInterfaces());
                        }
                        s.put(cls, arrayList);
                        list = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = list.size();
            zG = false;
            for (int i = 0; i < size; i++) {
                zG |= g(obj, q00Var, (Class) list.get(i));
            }
        } else {
            zG = g(obj, q00Var, cls);
        }
        if (zG) {
            return;
        }
        if (this.l) {
            this.p.c(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.n || cls == nx0.class || cls == kk1.class) {
            return;
        }
        e(new nx0(obj, 0));
    }

    public final boolean g(Object obj, q00 q00Var, Class cls) {
        CopyOnWriteArrayList<nk1> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (nk1 nk1Var : copyOnWriteArrayList) {
            q00Var.d = obj;
            h(nk1Var, obj, q00Var.c);
        }
        return true;
    }

    public final void h(nk1 nk1Var, Object obj, boolean z) {
        int i = p00.a[nk1Var.b.b.ordinal()];
        if (i == 1) {
            d(nk1Var, obj);
            return;
        }
        bb0 bb0Var = this.f;
        if (i == 2) {
            if (z) {
                d(nk1Var, obj);
                return;
            } else {
                bb0Var.a(nk1Var, obj);
                return;
            }
        }
        if (i == 3) {
            if (bb0Var != null) {
                bb0Var.a(nk1Var, obj);
                return;
            } else {
                d(nk1Var, obj);
                return;
            }
        }
        if (i != 4) {
            if (i != 5) {
                throw new IllegalStateException("Unknown thread mode: " + nk1Var.b.b);
            }
            w1 w1Var = this.h;
            w1Var.getClass();
            ((v21) w1Var.h).e(y11.a(nk1Var, obj));
            ((r00) w1Var.i).j.execute(w1Var);
            return;
        }
        if (!z) {
            d(nk1Var, obj);
            return;
        }
        fa faVar = this.g;
        faVar.getClass();
        y11 y11VarA = y11.a(nk1Var, obj);
        synchronized (faVar) {
            try {
                faVar.g.e(y11VarA);
                if (!faVar.i) {
                    faVar.i = true;
                    faVar.h.j.execute(faVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r00.i(java.lang.Object):void");
    }

    public final void j(Object obj, lk1 lk1Var) {
        Object value;
        Class cls = lk1Var.c;
        nk1 nk1Var = new nk1(obj, lk1Var);
        HashMap map = this.a;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) map.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            map.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nk1Var)) {
            throw new wk("Subscriber " + obj.getClass() + " already registered to event " + cls, 2);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i != size) {
                if (lk1Var.d <= ((nk1) copyOnWriteArrayList.get(i)).b.d) {
                }
            }
            copyOnWriteArrayList.add(i, nk1Var);
            break;
        }
        HashMap map2 = this.b;
        List arrayList = (List) map2.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (lk1Var.e) {
            ConcurrentHashMap concurrentHashMap = this.c;
            ka0 ka0Var = this.e;
            if (!this.o) {
                Object obj2 = concurrentHashMap.get(cls);
                if (obj2 != null) {
                    h(nk1Var, obj2, ka0Var == null || Looper.getMainLooper() == Looper.myLooper());
                    return;
                }
                return;
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey()) && (value = entry.getValue()) != null) {
                    h(nk1Var, value, ka0Var == null || Looper.getMainLooper() == Looper.myLooper());
                }
            }
        }
    }

    public final synchronized void k(Object obj) {
        try {
            List list = (List) this.b.get(obj);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    List list2 = (List) this.a.get((Class) it.next());
                    if (list2 != null) {
                        int size = list2.size();
                        int i = 0;
                        while (i < size) {
                            nk1 nk1Var = (nk1) list2.get(i);
                            if (nk1Var.a == obj) {
                                nk1Var.c = false;
                                list2.remove(i);
                                i--;
                                size--;
                            }
                            i++;
                        }
                    }
                }
                this.b.remove(obj);
            } else {
                this.p.c(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.o + "]";
    }
}
