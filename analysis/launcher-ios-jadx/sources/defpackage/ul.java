package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ul extends je {
    public final int q;

    public ul(int i, int i2) {
        String str;
        super(i);
        this.q = i2;
        if (i2 != 1) {
            if (i < 1) {
                throw new IllegalArgumentException(uo.d(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
            return;
        }
        StringBuilder sb = new StringBuilder("This implementation does not support suspension for senders, use ");
        u91.a.getClass();
        String simpleName = null;
        if (!je.class.isAnonymousClass()) {
            if (je.class.isLocalClass()) {
                simpleName = je.class.getSimpleName();
                Method enclosingMethod = je.class.getEnclosingMethod();
                if (enclosingMethod == null) {
                    Constructor<?> enclosingConstructor = je.class.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        int iIndexOf = simpleName.indexOf(36, 0);
                        if (iIndexOf != -1) {
                            simpleName = simpleName.substring(iIndexOf + 1, simpleName.length());
                            qg0.k(simpleName, "substring(...)");
                        }
                    } else {
                        simpleName = hk1.J(simpleName, enclosingConstructor.getName() + '$');
                    }
                } else {
                    simpleName = hk1.J(simpleName, enclosingMethod.getName() + '$');
                }
            } else {
                boolean zIsArray = je.class.isArray();
                LinkedHashMap linkedHashMap = zi.c;
                if (zIsArray) {
                    Class<?> componentType = je.class.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                        simpleName = str.concat("Array");
                    }
                    if (simpleName == null) {
                        simpleName = "Array";
                    }
                } else {
                    simpleName = (String) linkedHashMap.get(je.class.getName());
                    if (simpleName == null) {
                        simpleName = je.class.getSimpleName();
                    }
                }
            }
        }
        throw new IllegalArgumentException(uo.k(sb, simpleName, " instead").toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ba, code lost:
    
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(java.lang.Object r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            zp1 r8 = defpackage.zp1.a
            int r1 = r0.q
            r9 = 3
            if (r1 != r9) goto L18
            java.lang.Object r1 = super.f(r17)
            boolean r2 = r1 instanceof defpackage.th
            if (r2 == 0) goto L17
            boolean r2 = r1 instanceof defpackage.sh
            if (r2 == 0) goto L16
            goto L17
        L16:
            return r8
        L17:
            return r1
        L18:
            wg1 r6 = defpackage.le.d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.je.l
            java.lang.Object r1 = r1.get(r0)
            vh r1 = (defpackage.vh) r1
        L22:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = defpackage.je.h
            long r2 = r2.getAndIncrement(r0)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r0.s(r2, r7)
            int r10 = defpackage.le.b
            long r11 = (long) r10
            long r2 = r4 / r11
            long r13 = r4 % r11
            int r14 = (int) r13
            r13 = r10
            long r9 = r1.i
            int r15 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r15 == 0) goto L57
            vh r2 = defpackage.je.a(r0, r2, r1)
            if (r2 != 0) goto L56
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r0.p()
            sh r2 = new sh
            r2.<init>(r1)
            return r2
        L54:
            r9 = 3
            goto L22
        L56:
            r1 = r2
        L57:
            r3 = r17
            r2 = r14
            int r9 = defpackage.je.h(r0, r1, r2, r3, r4, r6, r7)
            if (r9 == 0) goto Lbb
            r3 = 1
            if (r9 == r3) goto Lba
            r3 = 2
            if (r9 == r3) goto L93
            r3 = 3
            if (r9 == r3) goto L8b
            r2 = 4
            if (r9 == r2) goto L74
            r2 = 5
            if (r9 == r2) goto L70
            goto L54
        L70:
            r1.a()
            goto L54
        L74:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = defpackage.je.i
            long r2 = r2.get(r0)
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto L81
            r1.a()
        L81:
            java.lang.Throwable r1 = r0.p()
            sh r2 = new sh
            r2.<init>(r1)
            return r2
        L8b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L93:
            if (r7 == 0) goto La2
            r1.h()
            java.lang.Throwable r1 = r0.p()
            sh r2 = new sh
            r2.<init>(r1)
            return r2
        La2:
            boolean r3 = r6 instanceof defpackage.hv1
            if (r3 == 0) goto La9
            hv1 r6 = (defpackage.hv1) r6
            goto Laa
        La9:
            r6 = 0
        Laa:
            if (r6 == 0) goto Lb1
            int r14 = r2 + r13
            r6.a(r1, r14)
        Lb1:
            long r3 = r1.i
            long r3 = r3 * r11
            long r1 = (long) r2
            long r3 = r3 + r1
            r0.l(r3)
        Lba:
            return r8
        Lbb:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ul.G(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // defpackage.je, defpackage.df1
    public final Object d(ff0 ff0Var, jk jkVar) throws Throwable {
        if (G(ff0Var, true) instanceof sh) {
            throw p();
        }
        return zp1.a;
    }

    @Override // defpackage.je, defpackage.df1
    public final Object f(Object obj) {
        return G(obj, false);
    }

    @Override // defpackage.je
    public final boolean u() {
        return this.q == 2;
    }
}
