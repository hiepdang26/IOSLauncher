package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ca0 {
    public final Context g;
    public final String h;
    public final q11 i;
    public final r5 j;
    public final b6 k;
    public final int l;
    public final iy m;
    public final ha0 n;

    public ca0(Context context, Activity activity, q11 q11Var, r5 r5Var, ba0 ba0Var) {
        hg0.j(context, "Null context is not permitted.");
        hg0.j(q11Var, "Api must not be null.");
        hg0.j(ba0Var, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.g = context.getApplicationContext();
        String str = null;
        if (os.k()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", null).invoke(context, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.h = str;
        this.i = q11Var;
        this.j = r5Var;
        b6 b6Var = new b6(q11Var, r5Var, str);
        this.k = b6Var;
        ha0 ha0VarF = ha0.f(this.g);
        this.n = ha0VarF;
        this.l = ha0VarF.n.getAndIncrement();
        this.m = ba0Var.a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            bn0 bn0VarB = LifecycleCallback.b(activity);
            t02 t02Var = (t02) bn0VarB.c(t02.class, "ConnectionlessLifecycleHelper");
            if (t02Var == null) {
                Object obj = da0.c;
                t02Var = new t02(bn0VarB, ha0VarF);
            }
            t02Var.l.add(b6Var);
            ha0VarF.a(t02Var);
        }
        t12 t12Var = ha0VarF.t;
        t12Var.sendMessage(t12Var.obtainMessage(7, this));
    }

    public final wb2 b() {
        wb2 wb2Var = new wb2(6, false);
        Set set = Collections.EMPTY_SET;
        if (((g9) wb2Var.h) == null) {
            wb2Var.h = new g9(0);
        }
        ((g9) wb2Var.h).addAll(set);
        Context context = this.g;
        wb2Var.j = context.getClass().getName();
        wb2Var.i = context.getPackageName();
        return wb2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.od2 c(int r14, defpackage.ld r15) {
        /*
            r13 = this;
            qm1 r0 = new qm1
            r0.<init>()
            ha0 r2 = r13.n
            r2.getClass()
            t12 r9 = r2.t
            int r3 = r15.b
            od2 r10 = r0.a
            if (r3 == 0) goto L90
            boolean r1 = r2.b()
            r4 = 0
            if (r1 != 0) goto L1a
            goto L75
        L1a:
            mc1 r1 = defpackage.mc1.r()
            java.lang.Object r1 = r1.h
            nc1 r1 = (defpackage.nc1) r1
            r5 = r4
            b6 r4 = r13.k
            r6 = 1
            if (r1 == 0) goto L5e
            boolean r7 = r1.h
            if (r7 != 0) goto L2e
        L2c:
            r4 = r5
            goto L75
        L2e:
            java.util.concurrent.ConcurrentHashMap r7 = r2.p
            java.lang.Object r7 = r7.get(r4)
            v02 r7 = (defpackage.v02) r7
            if (r7 == 0) goto L5c
            s5 r8 = r7.h
            boolean r11 = r8 instanceof defpackage.eb
            if (r11 != 0) goto L3f
            goto L2c
        L3f:
            eb r8 = (defpackage.eb) r8
            boolean r11 = r8.hasConnectionInfo()
            if (r11 == 0) goto L5c
            boolean r11 = r8.isConnecting()
            if (r11 != 0) goto L5c
            am r1 = defpackage.d12.a(r7, r8, r3)
            if (r1 != 0) goto L54
            goto L2c
        L54:
            int r5 = r7.r
            int r5 = r5 + r6
            r7.r = r5
            boolean r6 = r1.i
            goto L5e
        L5c:
            boolean r6 = r1.i
        L5e:
            d12 r1 = new d12
            r7 = 0
            if (r6 == 0) goto L69
            long r11 = java.lang.System.currentTimeMillis()
            goto L6a
        L69:
            r11 = r7
        L6a:
            if (r6 == 0) goto L70
            long r7 = android.os.SystemClock.elapsedRealtime()
        L70:
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r7)
            r4 = r1
        L75:
            if (r4 == 0) goto L90
            r9.getClass()
            dz1 r1 = new dz1
            r3 = 1
            r1.<init>(r9, r3)
            r10.getClass()
            b82 r3 = new b82
            r3.<init>(r1, r4)
            hh1 r1 = r10.b
            r1.f(r3)
            r10.k()
        L90:
            l12 r1 = new l12
            iy r3 = r13.m
            r1.<init>(r14, r15, r0, r3)
            f12 r14 = new f12
            java.util.concurrent.atomic.AtomicInteger r15 = r2.o
            int r15 = r15.get()
            r14.<init>(r1, r15, r13)
            r15 = 4
            android.os.Message r14 = r9.obtainMessage(r15, r14)
            r9.sendMessage(r14)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ca0.c(int, ld):od2");
    }
}
