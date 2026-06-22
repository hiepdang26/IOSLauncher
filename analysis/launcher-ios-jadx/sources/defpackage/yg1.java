package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class yg1 implements ha1, mh1 {
    public static final boolean A = Log.isLoggable("GlideRequest", 2);
    public final gj1 a;
    public final Object b;
    public final Object c;
    public final Context d;
    public final o90 e;
    public final Object f;
    public final Class g;
    public final nb h;
    public final int i;
    public final int j;
    public final j31 k;
    public final lm1 l;
    public final ArrayList m;
    public final yo1 n;
    public final l10 o;
    public eb1 p;
    public wb2 q;
    public volatile d00 r;
    public Drawable s;
    public Drawable t;
    public Drawable u;
    public int v;
    public int w;
    public boolean x;
    public final RuntimeException y;
    public int z;

    public yg1(Context context, o90 o90Var, Object obj, Object obj2, Class cls, nb nbVar, int i, int i2, j31 j31Var, lm1 lm1Var, ArrayList arrayList, pa1 pa1Var, d00 d00Var, yo1 yo1Var) {
        l10 l10Var = wd.r;
        if (A) {
            String.valueOf(hashCode());
        }
        this.a = new gj1();
        this.b = obj;
        this.d = context;
        this.e = o90Var;
        this.f = obj2;
        this.g = cls;
        this.h = nbVar;
        this.i = i;
        this.j = i2;
        this.k = j31Var;
        this.l = lm1Var;
        this.m = arrayList;
        this.c = pa1Var;
        this.r = d00Var;
        this.n = yo1Var;
        this.o = l10Var;
        this.z = 1;
        if (this.y == null && ((Map) o90Var.h.h).containsKey(n90.class)) {
            this.y = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // defpackage.ha1
    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.z == 4;
        }
        return z;
    }

    public final void b() {
        if (this.x) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.a.a();
        this.l.d(this);
        wb2 wb2Var = this.q;
        if (wb2Var != null) {
            synchronized (((d00) wb2Var.j)) {
                ((h00) wb2Var.h).j((yg1) wb2Var.i);
            }
            this.q = null;
        }
    }

    @Override // defpackage.ha1
    public final boolean c(ha1 ha1Var) {
        int i;
        int i2;
        Object obj;
        Class cls;
        nb nbVar;
        j31 j31Var;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class cls2;
        nb nbVar2;
        j31 j31Var2;
        int size2;
        if (!(ha1Var instanceof yg1)) {
            return false;
        }
        synchronized (this.b) {
            try {
                i = this.i;
                i2 = this.j;
                obj = this.f;
                cls = this.g;
                nbVar = this.h;
                j31Var = this.k;
                ArrayList arrayList = this.m;
                size = arrayList != null ? arrayList.size() : 0;
            } finally {
            }
        }
        yg1 yg1Var = (yg1) ha1Var;
        synchronized (yg1Var.b) {
            try {
                i3 = yg1Var.i;
                i4 = yg1Var.j;
                obj2 = yg1Var.f;
                cls2 = yg1Var.g;
                nbVar2 = yg1Var.h;
                j31Var2 = yg1Var.k;
                ArrayList arrayList2 = yg1Var.m;
                size2 = arrayList2 != null ? arrayList2.size() : 0;
            } finally {
            }
        }
        if (i != i3 || i2 != i4) {
            return false;
        }
        char[] cArr = vq1.a;
        if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
            return (nbVar == null ? nbVar2 == null : nbVar.i(nbVar2)) && j31Var == j31Var2 && size == size2;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, pa1] */
    @Override // defpackage.ha1
    public final void clear() {
        synchronized (this.b) {
            try {
                if (this.x) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.a.a();
                if (this.z == 6) {
                    return;
                }
                b();
                eb1 eb1Var = this.p;
                if (eb1Var != null) {
                    this.p = null;
                } else {
                    eb1Var = null;
                }
                ?? r3 = this.c;
                if (r3 == 0 || r3.h(this)) {
                    this.l.i(d());
                }
                this.z = 6;
                if (eb1Var != null) {
                    this.r.getClass();
                    d00.f(eb1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable d() {
        if (this.t == null) {
            this.h.getClass();
            this.t = null;
        }
        return this.t;
    }

    @Override // defpackage.ha1
    public final boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.z == 6;
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, pa1] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, pa1] */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.lang.Object, pa1] */
    public final void f(q90 q90Var, int i) {
        Drawable drawableD;
        this.a.a();
        synchronized (this.b) {
            try {
                q90Var.getClass();
                int i2 = this.e.i;
                if (i2 <= i) {
                    Objects.toString(this.f);
                    if (i2 <= 4) {
                        ArrayList arrayList = new ArrayList();
                        q90.a(q90Var, arrayList);
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            int i4 = i3 + 1;
                            i3 = i4;
                        }
                    }
                }
                this.q = null;
                this.z = 5;
                ?? r6 = this.c;
                if (r6 != 0) {
                    r6.g(this);
                }
                boolean z = true;
                this.x = true;
                try {
                    ArrayList arrayList2 = this.m;
                    if (arrayList2 != null) {
                        Iterator it = arrayList2.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            ?? r62 = this.c;
                            if (r62 == 0) {
                                throw null;
                            }
                            r62.i().a();
                            throw null;
                        }
                    }
                    ?? r1 = this.c;
                    if (r1 != 0 && !r1.b(this)) {
                        z = false;
                    }
                    if (z) {
                        if (this.f == null) {
                            if (this.u == null) {
                                this.h.getClass();
                                this.u = null;
                            }
                            drawableD = this.u;
                        } else {
                            drawableD = null;
                        }
                        if (drawableD == null) {
                            if (this.s == null) {
                                nb nbVar = this.h;
                                nbVar.getClass();
                                this.s = null;
                                int i5 = nbVar.k;
                                if (i5 > 0) {
                                    Resources.Theme theme = this.h.u;
                                    Context context = this.d;
                                    if (theme == null) {
                                        theme = context.getTheme();
                                    }
                                    this.s = p02.k(context, context, i5, theme);
                                }
                            }
                            drawableD = this.s;
                        }
                        if (drawableD == null) {
                            drawableD = d();
                        }
                        this.l.a(drawableD);
                    }
                } finally {
                    this.x = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v14, types: [java.lang.Object, pa1] */
    public final void g(eb1 eb1Var, int i, boolean z) {
        this.a.a();
        eb1 eb1Var2 = null;
        try {
            synchronized (this.b) {
                try {
                    this.q = null;
                    if (eb1Var == null) {
                        f(new q90("Expected to receive a Resource<R> with an object of " + this.g + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = eb1Var.get();
                    try {
                        if (obj == null || !this.g.isAssignableFrom(obj.getClass())) {
                            this.p = null;
                            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                            sb.append(this.g);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(eb1Var);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            f(new q90(sb.toString()), 5);
                        } else {
                            ?? r9 = this.c;
                            if (r9 == 0 || r9.f(this)) {
                                h(eb1Var, obj, i);
                                return;
                            } else {
                                this.p = null;
                                this.z = 4;
                            }
                        }
                        this.r.getClass();
                        d00.f(eb1Var);
                    } catch (Throwable th) {
                        eb1Var2 = eb1Var;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (eb1Var2 != null) {
                this.r.getClass();
                d00.f(eb1Var2);
            }
            throw th3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, pa1] */
    public final void h(eb1 eb1Var, Object obj, int i) {
        ?? r0 = this.c;
        if (r0 != 0) {
            r0.i().a();
        }
        this.z = 4;
        this.p = eb1Var;
        if (this.e.i <= 3) {
            Objects.toString(this.f);
            int i2 = tp0.a;
            SystemClock.elapsedRealtimeNanos();
        }
        if (r0 != 0) {
            r0.d(this);
        }
        this.x = true;
        try {
            ArrayList arrayList = this.m;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            this.l.e(obj, this.n.c(i));
            this.x = false;
        } catch (Throwable th) {
            this.x = false;
            throw th;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void i(int i, int i2) {
        Object obj;
        o90 o90Var;
        Object obj2;
        bj0 bj0Var;
        int i3;
        int i4;
        Class cls;
        Class cls2;
        j31 j31Var;
        qv qvVar;
        jf jfVar;
        boolean z;
        boolean z2;
        g01 g01Var;
        boolean z3;
        boolean z4;
        l10 l10Var;
        Object obj3;
        yg1 yg1Var = this;
        int iRound = i;
        yg1Var.a.a();
        Object obj4 = yg1Var.b;
        synchronized (obj4) {
            try {
                try {
                    boolean z5 = A;
                    if (z5) {
                        int i5 = tp0.a;
                        SystemClock.elapsedRealtimeNanos();
                    }
                    if (yg1Var.z == 3) {
                        yg1Var.z = 2;
                        float f = yg1Var.h.h;
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * f);
                        }
                        yg1Var.v = iRound;
                        yg1Var.w = i2 == Integer.MIN_VALUE ? i2 : Math.round(f * i2);
                        if (z5) {
                            int i6 = tp0.a;
                            SystemClock.elapsedRealtimeNanos();
                        }
                        d00 d00Var = yg1Var.r;
                        try {
                            o90Var = yg1Var.e;
                            obj2 = yg1Var.f;
                            nb nbVar = yg1Var.h;
                            try {
                                bj0Var = nbVar.o;
                                i3 = yg1Var.v;
                                try {
                                    i4 = yg1Var.w;
                                    cls = nbVar.s;
                                    try {
                                        cls2 = yg1Var.g;
                                        j31Var = yg1Var.k;
                                        try {
                                            qvVar = nbVar.i;
                                            jfVar = nbVar.r;
                                            try {
                                                z = nbVar.p;
                                                z2 = nbVar.w;
                                                try {
                                                    g01Var = nbVar.q;
                                                    z3 = nbVar.l;
                                                    z4 = nbVar.x;
                                                    l10Var = yg1Var.o;
                                                    obj3 = obj4;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    obj = obj4;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                obj = obj4;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj = obj4;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj = obj4;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    obj = obj4;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                obj = obj4;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            obj = obj4;
                        }
                        try {
                            yg1Var.q = d00Var.a(o90Var, obj2, bj0Var, i3, i4, cls, cls2, j31Var, qvVar, jfVar, z, z2, g01Var, z3, z4, yg1Var, l10Var);
                            if (yg1Var.z != 2) {
                                yg1Var.q = null;
                            }
                            if (z5) {
                                int i7 = tp0.a;
                                SystemClock.elapsedRealtimeNanos();
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            obj = obj3;
                            throw th;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    obj = yg1Var;
                }
            } catch (Throwable th10) {
                th = th10;
                obj = obj4;
            }
        }
    }

    @Override // defpackage.ha1
    public final boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            int i = this.z;
            z = i == 2 || i == 3;
        }
        return z;
    }

    @Override // defpackage.ha1
    public final void j() {
        synchronized (this.b) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, pa1] */
    @Override // defpackage.ha1
    public final void k() {
        boolean z = true;
        synchronized (this.b) {
            try {
                if (this.x) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.a.a();
                int i = tp0.a;
                SystemClock.elapsedRealtimeNanos();
                if (this.f == null) {
                    if (vq1.i(this.i, this.j)) {
                        this.v = this.i;
                        this.w = this.j;
                    }
                    if (this.u == null) {
                        this.h.getClass();
                        this.u = null;
                    }
                    f(new q90("Received null model"), this.u == null ? 5 : 3);
                    return;
                }
                int i2 = this.z;
                if (i2 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i2 == 4) {
                    g(this.p, 5, false);
                    return;
                }
                ArrayList arrayList = this.m;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                    }
                }
                this.z = 3;
                if (vq1.i(this.i, this.j)) {
                    i(this.i, this.j);
                } else {
                    this.l.f(this);
                }
                int i4 = this.z;
                if (i4 == 2 || i4 == 3) {
                    ?? r2 = this.c;
                    if (r2 != 0 && !r2.b(this)) {
                        z = false;
                    }
                    if (z) {
                        this.l.g(d());
                    }
                }
                if (A) {
                    SystemClock.elapsedRealtimeNanos();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ha1
    public final boolean l() {
        boolean z;
        synchronized (this.b) {
            z = this.z == 4;
        }
        return z;
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.b) {
            obj = this.f;
            cls = this.g;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
