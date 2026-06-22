package defpackage;

import android.database.sqlite.SQLiteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public final class vg0 {
    public static final String[] m = {"UPDATE", "DELETE", "INSERT"};
    public final kc1 a;
    public final HashMap b;
    public final LinkedHashMap c;
    public final String[] d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public volatile boolean f;
    public volatile z60 g;
    public final uv h;
    public final gd1 i;
    public final Object j;
    public final Object k;
    public final o1 l;

    public vg0(kc1 kc1Var, HashMap map, HashMap map2, String... strArr) {
        String lowerCase;
        this.a = kc1Var;
        this.b = map;
        this.h = new uv(strArr.length);
        qg0.k(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
        this.i = new gd1();
        this.j = new Object();
        this.k = new Object();
        this.c = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            qg0.k(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            qg0.k(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.c.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.b.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                qg0.k(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.d = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            qg0.k(locale2, "US");
            String lowerCase3 = str3.toLowerCase(locale2);
            qg0.k(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.c.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                qg0.k(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.c;
                qg0.l(linkedHashMap, "<this>");
                Object obj = linkedHashMap.get(lowerCase3);
                if (obj == null && !linkedHashMap.containsKey(lowerCase3)) {
                    throw new NoSuchElementException("Key " + ((Object) lowerCase3) + " is missing in the map.");
                }
                linkedHashMap.put(lowerCase4, obj);
            }
        }
        this.l = new o1(this, 27);
    }

    public final boolean a() {
        s60 s60Var = this.a.a;
        if (s60Var != null && s60Var.g.isOpen()) {
            if (!this.f) {
                this.a.g().v();
            }
            if (this.f) {
                return true;
            }
        }
        return false;
    }

    public final void b(s60 s60Var, int i) {
        s60Var.n("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.d[i];
        String[] strArr = m;
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = strArr[i2];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + wd.t(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i + " AND invalidated = 0; END";
            qg0.k(str3, "StringBuilder().apply(builderAction).toString()");
            s60Var.n(str3);
        }
    }

    public final void c(s60 s60Var) {
        qg0.l(s60Var, "database");
        if (s60Var.z()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.a.h.readLock();
            qg0.k(lock, "readWriteLock.readLock()");
            lock.lock();
            try {
                synchronized (this.j) {
                    int[] iArrE = this.h.e();
                    if (iArrE != null) {
                        if (s60Var.A()) {
                            s60Var.b();
                        } else {
                            s60Var.a();
                        }
                        try {
                            int length = iArrE.length;
                            int i = 0;
                            int i2 = 0;
                            while (i < length) {
                                int i3 = iArrE[i];
                                int i4 = i2 + 1;
                                if (i3 == 1) {
                                    b(s60Var, i2);
                                } else if (i3 == 2) {
                                    String str = this.d[i2];
                                    String[] strArr = m;
                                    for (int i5 = 0; i5 < 3; i5++) {
                                        String str2 = "DROP TRIGGER IF EXISTS " + wd.t(str, strArr[i5]);
                                        qg0.k(str2, "StringBuilder().apply(builderAction).toString()");
                                        s60Var.n(str2);
                                    }
                                }
                                i++;
                                i2 = i4;
                            }
                            s60Var.D();
                            s60Var.k();
                        } catch (Throwable th) {
                            s60Var.k();
                            throw th;
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        } catch (SQLiteException | IllegalStateException unused) {
        }
    }
}
