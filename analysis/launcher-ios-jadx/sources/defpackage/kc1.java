package defpackage;

import android.database.Cursor;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class kc1 {
    public volatile s60 a;
    public Executor b;
    public wk1 c;
    public boolean e;
    public ArrayList f;
    public final Map j;
    public final LinkedHashMap k;
    public final vg0 d = d();
    public final LinkedHashMap g = new LinkedHashMap();
    public final ReentrantReadWriteLock h = new ReentrantReadWriteLock();
    public final ThreadLocal i = new ThreadLocal();

    public kc1() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        qg0.k(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.j = mapSynchronizedMap;
        this.k = new LinkedHashMap();
    }

    public static Object o(Class cls, wk1 wk1Var) {
        if (cls.isInstance(wk1Var)) {
            return wk1Var;
        }
        if (wk1Var instanceof nu) {
            return o(cls, ((nu) wk1Var).a());
        }
        return null;
    }

    public final void a() {
        if (!this.e && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!g().v().z() && this.i.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void c() {
        a();
        a();
        s60 s60VarV = g().v();
        this.d.c(s60VarV);
        if (s60VarV.A()) {
            s60VarV.b();
        } else {
            s60VarV.a();
        }
    }

    public abstract vg0 d();

    public abstract wk1 e(ks ksVar);

    public List f(LinkedHashMap linkedHashMap) {
        qg0.l(linkedHashMap, "autoMigrationSpecs");
        return vz.g;
    }

    public final wk1 g() {
        wk1 wk1Var = this.c;
        if (wk1Var != null) {
            return wk1Var;
        }
        qg0.O("internalOpenHelper");
        throw null;
    }

    public Set h() {
        return xz.g;
    }

    public Map i() {
        return wz.g;
    }

    public final void j() {
        g().v().k();
        if (g().v().z()) {
            return;
        }
        vg0 vg0Var = this.d;
        if (vg0Var.e.compareAndSet(false, true)) {
            Executor executor = vg0Var.a.b;
            if (executor != null) {
                executor.execute(vg0Var.l);
            } else {
                qg0.O("internalQueryExecutor");
                throw null;
            }
        }
    }

    public final void k(s60 s60Var) {
        vg0 vg0Var = this.d;
        vg0Var.getClass();
        synchronized (vg0Var.k) {
            if (vg0Var.f) {
                return;
            }
            s60Var.n("PRAGMA temp_store = MEMORY;");
            s60Var.n("PRAGMA recursive_triggers='ON';");
            s60Var.n("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            vg0Var.c(s60Var);
            vg0Var.g = s60Var.h("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            vg0Var.f = true;
        }
    }

    public final Cursor l(yk1 yk1Var) {
        a();
        b();
        return g().v().B(yk1Var);
    }

    public final Object m(Callable callable) {
        c();
        try {
            Object objCall = callable.call();
            n();
            return objCall;
        } finally {
            j();
        }
    }

    public final void n() {
        g().v().D();
    }
}
