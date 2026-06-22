package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class jc1 {
    public final Context a;
    public final Class b;
    public final String c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    public Executor g;
    public Executor h;
    public o5 i;
    public boolean j;
    public final int k;
    public boolean l;
    public boolean m;
    public final long n;
    public final fz1 o;
    public final LinkedHashSet p;
    public HashSet q;

    public jc1(Context context, Class cls, String str) {
        qg0.l(context, "context");
        this.a = context;
        this.b = cls;
        this.c = str;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.k = 1;
        this.l = true;
        this.n = -1L;
        this.o = new fz1(26);
        this.p = new LinkedHashSet();
    }

    public final void a(gu0... gu0VarArr) {
        if (this.q == null) {
            this.q = new HashSet();
        }
        for (gu0 gu0Var : gu0VarArr) {
            HashSet hashSet = this.q;
            qg0.h(hashSet);
            hashSet.add(Integer.valueOf(gu0Var.a));
            HashSet hashSet2 = this.q;
            qg0.h(hashSet2);
            hashSet2.add(Integer.valueOf(gu0Var.b));
        }
        this.o.z((gu0[]) Arrays.copyOf(gu0VarArr, gu0VarArr.length));
    }

    public final kc1 b() {
        boolean zContainsKey;
        Executor executor = this.g;
        if (executor == null && this.h == null) {
            t8 t8Var = u8.n;
            this.h = t8Var;
            this.g = t8Var;
        } else if (executor != null && this.h == null) {
            this.h = executor;
        } else if (executor == null) {
            this.g = this.h;
        }
        HashSet hashSet = this.q;
        LinkedHashSet linkedHashSet = this.p;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (linkedHashSet.contains(Integer.valueOf(iIntValue))) {
                    throw new IllegalArgumentException(k31.k(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ").toString());
                }
            }
        }
        vk1 jl1Var = this.i;
        if (jl1Var == null) {
            jl1Var = new jl1(21);
        }
        vk1 vk1Var = jl1Var;
        if (this.n > 0) {
            if (this.c != null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
        }
        ArrayList arrayList = this.d;
        boolean z = this.j;
        int i = this.k;
        if (i == 0) {
            throw null;
        }
        Context context = this.a;
        qg0.l(context, "context");
        if (i == 1) {
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            i = (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3;
        }
        Executor executor2 = this.g;
        if (executor2 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Executor executor3 = this.h;
        if (executor3 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ks ksVar = new ks(context, this.c, vk1Var, this.o, arrayList, z, i, executor2, executor3, this.l, this.m, linkedHashSet, this.e, this.f);
        Class cls = this.b;
        Package r6 = cls.getPackage();
        qg0.h(r6);
        String name = r6.getName();
        String canonicalName = cls.getCanonicalName();
        qg0.h(canonicalName);
        qg0.k(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            qg0.k(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String strReplace = canonicalName.replace('.', '_');
        qg0.k(strReplace, "replace(...)");
        String strConcat = strReplace.concat("_Impl");
        try {
            Class<?> cls2 = Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, cls.getClassLoader());
            qg0.i(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            kc1 kc1Var = (kc1) cls2.getDeclaredConstructor(null).newInstance(null);
            kc1Var.getClass();
            kc1Var.c = kc1Var.e(ksVar);
            Set setH = kc1Var.h();
            BitSet bitSet = new BitSet();
            Iterator it2 = setH.iterator();
            while (true) {
                boolean zHasNext = it2.hasNext();
                LinkedHashMap linkedHashMap = kc1Var.g;
                ArrayList arrayList2 = ksVar.n;
                if (zHasNext) {
                    Class cls3 = (Class) it2.next();
                    int size = arrayList2.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i2 = size - 1;
                            if (cls3.isAssignableFrom(arrayList2.get(size).getClass())) {
                                bitSet.set(size);
                                break;
                            }
                            if (i2 < 0) {
                                break;
                            }
                            size = i2;
                        }
                        size = -1;
                    } else {
                        size = -1;
                    }
                    if (size < 0) {
                        throw new IllegalArgumentException(("A required auto migration spec (" + cls3.getCanonicalName() + ") is missing in the database configuration.").toString());
                    }
                    linkedHashMap.put(cls3, arrayList2.get(size));
                } else {
                    int size2 = arrayList2.size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            int i3 = size2 - 1;
                            if (!bitSet.get(size2)) {
                                throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                            }
                            if (i3 < 0) {
                                break;
                            }
                            size2 = i3;
                        }
                    }
                    for (gu0 gu0Var : kc1Var.f(linkedHashMap)) {
                        int i4 = gu0Var.a;
                        fz1 fz1Var = ksVar.d;
                        LinkedHashMap linkedHashMap2 = (LinkedHashMap) fz1Var.h;
                        if (linkedHashMap2.containsKey(Integer.valueOf(i4))) {
                            Map map = (Map) linkedHashMap2.get(Integer.valueOf(i4));
                            if (map == null) {
                                map = wz.g;
                            }
                            zContainsKey = map.containsKey(Integer.valueOf(gu0Var.b));
                        } else {
                            zContainsKey = false;
                        }
                        if (!zContainsKey) {
                            fz1Var.z(gu0Var);
                        }
                    }
                    kc1Var.g().setWriteAheadLoggingEnabled(ksVar.g == 3);
                    kc1Var.f = ksVar.e;
                    kc1Var.b = ksVar.h;
                    qg0.l(ksVar.i, "executor");
                    new ArrayDeque();
                    kc1Var.e = ksVar.f;
                    Map mapI = kc1Var.i();
                    BitSet bitSet2 = new BitSet();
                    Iterator it3 = mapI.entrySet().iterator();
                    while (true) {
                        boolean zHasNext2 = it3.hasNext();
                        ArrayList arrayList3 = ksVar.m;
                        if (!zHasNext2) {
                            int size3 = arrayList3.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i5 = size3 - 1;
                                    if (!bitSet2.get(size3)) {
                                        throw new IllegalArgumentException("Unexpected type converter " + arrayList3.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                                    }
                                    if (i5 < 0) {
                                        break;
                                    }
                                    size3 = i5;
                                }
                            }
                            return kc1Var;
                        }
                        Map.Entry entry = (Map.Entry) it3.next();
                        Class cls4 = (Class) entry.getKey();
                        for (Class cls5 : (List) entry.getValue()) {
                            int size4 = arrayList3.size() - 1;
                            if (size4 >= 0) {
                                while (true) {
                                    int i6 = size4 - 1;
                                    if (cls5.isAssignableFrom(arrayList3.get(size4).getClass())) {
                                        bitSet2.set(size4);
                                        break;
                                    }
                                    if (i6 < 0) {
                                        break;
                                    }
                                    size4 = i6;
                                }
                                size4 = -1;
                            } else {
                                size4 = -1;
                            }
                            if (!(size4 >= 0)) {
                                throw new IllegalArgumentException(("A required type converter (" + cls5 + ") for " + cls4.getCanonicalName() + " is missing in the database configuration.").toString());
                            }
                            kc1Var.k.put(cls5, arrayList3.get(size4));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + strConcat + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }
}
