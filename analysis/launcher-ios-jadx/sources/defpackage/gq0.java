package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class gq0 {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final lp0 lock;
    private final hq0 map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public gq0(int i) {
        this.maxSize = i;
        if (i <= 0) {
            p02.C("maxSize <= 0");
            throw null;
        }
        this.map = new hq0();
        this.lock = new lp0();
    }

    public final int a(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        String str = "Negative size: " + obj + '=' + obj2;
        qg0.l(str, "message");
        throw new IllegalStateException(str);
    }

    public Object create(Object obj) {
        qg0.l(obj, "key");
        return null;
    }

    public final int createCount() {
        int i;
        synchronized (this.lock) {
            i = this.createCount;
        }
        return i;
    }

    public void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        qg0.l(obj, "key");
        qg0.l(obj2, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this.lock) {
            i = this.evictionCount;
        }
        return i;
    }

    public final Object get(Object obj) {
        Object objPut;
        qg0.l(obj, "key");
        synchronized (this.lock) {
            hq0 hq0Var = this.map;
            hq0Var.getClass();
            Object obj2 = hq0Var.a.get(obj);
            if (obj2 != null) {
                this.hitCount++;
                return obj2;
            }
            this.missCount++;
            Object objCreate = create(obj);
            if (objCreate == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    objPut = this.map.a.put(obj, objCreate);
                    if (objPut != null) {
                        this.map.a.put(obj, objPut);
                    } else {
                        this.size += a(obj, objCreate);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objPut != null) {
                entryRemoved(false, obj, objCreate, objPut);
                return objPut;
            }
            trimToSize(this.maxSize);
            return objCreate;
        }
    }

    public final int hitCount() {
        int i;
        synchronized (this.lock) {
            i = this.hitCount;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.lock) {
            i = this.maxSize;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.lock) {
            i = this.missCount;
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        qg0.l(obj, "key");
        qg0.l(obj2, "value");
        synchronized (this.lock) {
            this.putCount++;
            this.size += a(obj, obj2);
            objPut = this.map.a.put(obj, obj2);
            if (objPut != null) {
                this.size -= a(obj, objPut);
            }
        }
        if (objPut != null) {
            entryRemoved(false, obj, objPut, obj2);
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public final int putCount() {
        int i;
        synchronized (this.lock) {
            i = this.putCount;
        }
        return i;
    }

    public final Object remove(Object obj) {
        Object objRemove;
        qg0.l(obj, "key");
        synchronized (this.lock) {
            hq0 hq0Var = this.map;
            hq0Var.getClass();
            objRemove = hq0Var.a.remove(obj);
            if (objRemove != null) {
                this.size -= a(obj, objRemove);
            }
        }
        if (objRemove != null) {
            entryRemoved(false, obj, objRemove, null);
        }
        return objRemove;
    }

    public void resize(int i) {
        if (!(i > 0)) {
            p02.C("maxSize <= 0");
            throw null;
        }
        synchronized (this.lock) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    public final int size() {
        int i;
        synchronized (this.lock) {
            i = this.size;
        }
        return i;
    }

    public int sizeOf(Object obj, Object obj2) {
        qg0.l(obj, "key");
        qg0.l(obj2, "value");
        return 1;
    }

    public final Map<Object, Object> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.lock) {
            Set setEntrySet = this.map.a.entrySet();
            qg0.k(setEntrySet, "map.entries");
            linkedHashMap = new LinkedHashMap(setEntrySet.size());
            Set<Map.Entry> setEntrySet2 = this.map.a.entrySet();
            qg0.k(setEntrySet2, "map.entries");
            for (Map.Entry entry : setEntrySet2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i = this.hitCount;
                int i2 = this.missCount + i;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r8) {
        /*
            r7 = this;
        L0:
            lp0 r0 = r7.lock
            monitor-enter(r0)
            int r1 = r7.size     // Catch: java.lang.Throwable -> L18
            r2 = 0
            r3 = 1
            if (r1 < 0) goto L1d
            hq0 r1 = r7.map     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L1b
            int r1 = r7.size     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1d
            goto L1b
        L18:
            r8 = move-exception
            goto L9c
        L1b:
            r1 = 1
            goto L1e
        L1d:
            r1 = 0
        L1e:
            if (r1 == 0) goto L94
            int r1 = r7.size     // Catch: java.lang.Throwable -> L18
            if (r1 <= r8) goto L92
            hq0 r1 = r7.map     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L2f
            goto L92
        L2f:
            hq0 r1 = r7.map     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L18
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "map.entries"
            defpackage.qg0.k(r1, r4)     // Catch: java.lang.Throwable -> L18
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L18
            boolean r4 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L18
            r5 = 0
            if (r4 == 0) goto L52
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L18
            boolean r4 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L4d
        L4b:
            r1 = r5
            goto L61
        L4d:
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L18
            goto L61
        L52:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L18
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L5d
            goto L4b
        L5d:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L18
        L61:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L67
            monitor-exit(r0)
            return
        L67:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L18
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L18
            hq0 r4 = r7.map     // Catch: java.lang.Throwable -> L18
            r4.getClass()     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = "key"
            defpackage.qg0.l(r2, r6)     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r4 = r4.a     // Catch: java.lang.Throwable -> L18
            r4.remove(r2)     // Catch: java.lang.Throwable -> L18
            int r4 = r7.size     // Catch: java.lang.Throwable -> L18
            int r6 = r7.a(r2, r1)     // Catch: java.lang.Throwable -> L18
            int r4 = r4 - r6
            r7.size = r4     // Catch: java.lang.Throwable -> L18
            int r4 = r7.evictionCount     // Catch: java.lang.Throwable -> L18
            int r4 = r4 + r3
            r7.evictionCount = r4     // Catch: java.lang.Throwable -> L18
            monitor-exit(r0)
            r7.entryRemoved(r3, r2, r1, r5)
            goto L0
        L92:
            monitor-exit(r0)
            return
        L94:
            java.lang.String r8 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L18
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L18
            throw r1     // Catch: java.lang.Throwable -> L18
        L9c:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gq0.trimToSize(int):void");
    }
}
