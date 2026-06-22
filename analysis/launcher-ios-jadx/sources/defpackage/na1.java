package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class na1 extends nb {
    public final Class A;
    public final o90 B;
    public dp1 C;
    public Object D;
    public ArrayList E;
    public na1 F;
    public na1 G;
    public Float H;
    public boolean I = true;
    public boolean J;
    public boolean K;
    public final Context y;
    public final sa1 z;

    static {
    }

    public na1(a aVar, sa1 sa1Var, Class cls, Context context) {
        xa1 xa1Var;
        this.z = sa1Var;
        this.A = cls;
        this.y = context;
        e9 e9Var = sa1Var.g.i.f;
        dp1 dp1Var = (dp1) e9Var.get(cls);
        if (dp1Var == null) {
            for (Map.Entry entry : (a9) e9Var.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    dp1Var = (dp1) entry.getValue();
                }
            }
        }
        this.C = dp1Var == null ? o90.k : dp1Var;
        this.B = aVar.i;
        Iterator it = sa1Var.o.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            E();
        }
        synchronized (sa1Var) {
            xa1Var = sa1Var.p;
        }
        a(xa1Var);
    }

    public na1 E() {
        if (this.v) {
            return clone().E();
        }
        s();
        return this;
    }

    @Override // defpackage.nb
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public na1 a(nb nbVar) {
        n90.g(nbVar);
        return (na1) super.a(nbVar);
    }

    public final na1 G(na1 na1Var) {
        PackageInfo packageInfo;
        Context context = this.y;
        na1 na1Var2 = (na1) na1Var.x(context.getTheme());
        ConcurrentHashMap concurrentHashMap = s7.a;
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap2 = s7.a;
        bj0 bj0Var = (bj0) concurrentHashMap2.get(packageName);
        if (bj0Var == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                context.getPackageName();
                packageInfo = null;
            }
            fy0 fy0Var = new fy0(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            bj0 bj0Var2 = (bj0) concurrentHashMap2.putIfAbsent(packageName, fy0Var);
            bj0Var = bj0Var2 == null ? fy0Var : bj0Var2;
        }
        return (na1) na1Var2.u(new v4(context.getResources().getConfiguration().uiMode & 48, bj0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ha1 H(int r17, int r18, defpackage.nb r19, defpackage.j31 r20, defpackage.pa1 r21, defpackage.lm1 r22, defpackage.dp1 r23, java.lang.Object r24) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.na1.H(int, int, nb, j31, pa1, lm1, dp1, java.lang.Object):ha1");
    }

    @Override // defpackage.nb
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public na1 clone() {
        na1 na1Var = (na1) super.clone();
        na1Var.C = na1Var.C.clone();
        if (na1Var.E != null) {
            na1Var.E = new ArrayList(na1Var.E);
        }
        na1 na1Var2 = na1Var.F;
        if (na1Var2 != null) {
            na1Var.F = na1Var2.clone();
        }
        na1 na1Var3 = na1Var.G;
        if (na1Var3 != null) {
            na1Var.G = na1Var3.clone();
        }
        return na1Var;
    }

    public final j31 J(j31 j31Var) {
        int iOrdinal = j31Var.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return j31.g;
        }
        if (iOrdinal == 2) {
            return j31.h;
        }
        if (iOrdinal == 3) {
            return j31.i;
        }
        throw new IllegalArgumentException("unknown priority: " + this.j);
    }

    public final void K(lm1 lm1Var, nb nbVar) {
        n90.g(lm1Var);
        if (!this.J) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        Object obj = new Object();
        dp1 dp1Var = this.C;
        ha1 ha1VarH = H(nbVar.n, nbVar.m, nbVar, nbVar.j, null, lm1Var, dp1Var, obj);
        ha1 ha1VarH2 = lm1Var.h();
        if (ha1VarH.c(ha1VarH2) && (nbVar.l || !ha1VarH2.l())) {
            n90.h(ha1VarH2, "Argument must not be null");
            if (ha1VarH2.isRunning()) {
                return;
            }
            ha1VarH2.k();
            return;
        }
        this.z.n(lm1Var);
        lm1Var.c(ha1VarH);
        sa1 sa1Var = this.z;
        synchronized (sa1Var) {
            sa1Var.l.g.add(lm1Var);
            hh1 hh1Var = sa1Var.j;
            ((Set) hh1Var.d).add(ha1VarH);
            if (hh1Var.c) {
                ha1VarH.clear();
                Log.isLoggable("RequestTracker", 2);
                ((HashSet) hh1Var.b).add(ha1VarH);
            } else {
                ha1VarH.k();
            }
        }
    }

    public final void L(ImageView imageView) {
        nb nbVarL;
        lm1 lcVar;
        vq1.a();
        n90.g(imageView);
        if (!nb.j(this.g, 2048) && imageView.getScaleType() != null) {
            switch (ma1.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    nbVarL = clone().l();
                    break;
                case 2:
                    nbVarL = clone().m();
                    break;
                case 3:
                case 4:
                case 5:
                    nbVarL = clone().n();
                    break;
                case 6:
                    nbVarL = clone().m();
                    break;
                default:
                    nbVarL = this;
                    break;
            }
        } else {
            nbVarL = this;
        }
        this.B.c.getClass();
        Class cls = this.A;
        if (Bitmap.class.equals(cls)) {
            lcVar = new lc(imageView, 0);
        } else {
            if (!Drawable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
            }
            lcVar = new lc(imageView, 1);
        }
        K(lcVar, nbVarL);
    }

    public na1 M(wi1 wi1Var) {
        return S(wi1Var);
    }

    public na1 N(Bitmap bitmap) {
        return S(bitmap).a((xa1) new xa1().f(qv.c));
    }

    public na1 O(Uri uri) {
        na1 na1VarS = S(uri);
        return (uri == null || !"android.resource".equals(uri.getScheme())) ? na1VarS : G(na1VarS);
    }

    public na1 P(File file) {
        return S(file);
    }

    public na1 Q(Integer num) {
        return G(S(num));
    }

    public na1 R(String str) {
        return S(str);
    }

    public final na1 S(Object obj) {
        if (this.v) {
            return clone().S(obj);
        }
        this.D = obj;
        this.J = true;
        s();
        return this;
    }

    public final yg1 T(int i, int i2, nb nbVar, j31 j31Var, pa1 pa1Var, lm1 lm1Var, dp1 dp1Var, Object obj) {
        Object obj2 = this.D;
        ArrayList arrayList = this.E;
        o90 o90Var = this.B;
        return new yg1(this.y, o90Var, obj, obj2, this.A, nbVar, i, i2, j31Var, lm1Var, arrayList, pa1Var, o90Var.g, dp1Var.g);
    }

    public na1 U() {
        if (this.v) {
            return clone().U();
        }
        this.H = Float.valueOf(0.3f);
        s();
        return this;
    }

    public na1 V(fx fxVar) {
        if (this.v) {
            return clone().V(fxVar);
        }
        this.C = fxVar;
        this.I = false;
        s();
        return this;
    }

    @Override // defpackage.nb
    public final boolean equals(Object obj) {
        if (!(obj instanceof na1)) {
            return false;
        }
        na1 na1Var = (na1) obj;
        if (super.equals(na1Var)) {
            return Objects.equals(this.A, na1Var.A) && this.C.equals(na1Var.C) && Objects.equals(this.D, na1Var.D) && Objects.equals(this.E, na1Var.E) && Objects.equals(this.F, na1Var.F) && Objects.equals(this.G, na1Var.G) && Objects.equals(this.H, na1Var.H) && this.I == na1Var.I && this.J == na1Var.J;
        }
        return false;
    }

    @Override // defpackage.nb
    public final int hashCode() {
        return vq1.g(this.J ? 1 : 0, vq1.g(this.I ? 1 : 0, vq1.h(vq1.h(vq1.h(vq1.h(vq1.h(vq1.h(vq1.h(super.hashCode(), this.A), this.C), this.D), this.E), this.F), this.G), this.H)));
    }
}
