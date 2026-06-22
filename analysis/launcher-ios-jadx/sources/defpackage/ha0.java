package defpackage;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class ha0 implements Handler.Callback {
    public static final Status v = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status w = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object x = new Object();
    public static ha0 y;
    public long g;
    public boolean h;
    public vm1 i;
    public r12 j;
    public final Context k;
    public final da0 l;
    public final b52 m;
    public final AtomicInteger n;
    public final AtomicInteger o;
    public final ConcurrentHashMap p;
    public t02 q;
    public final g9 r;
    public final g9 s;
    public final t12 t;
    public volatile boolean u;

    public ha0(Context context, Looper looper) {
        da0 da0Var = da0.d;
        this.g = 10000L;
        this.h = false;
        this.n = new AtomicInteger(1);
        this.o = new AtomicInteger(0);
        this.p = new ConcurrentHashMap(5, 0.75f, 1);
        this.q = null;
        this.r = new g9(0);
        this.s = new g9(0);
        this.u = true;
        this.k = context;
        t12 t12Var = new t12(looper, this);
        this.t = t12Var;
        this.l = da0Var;
        this.m = new b52();
        PackageManager packageManager = context.getPackageManager();
        if (bf1.k == null) {
            bf1.k = Boolean.valueOf(os.j() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (bf1.k.booleanValue()) {
            this.u = false;
        }
        t12Var.sendMessage(t12Var.obtainMessage(6));
    }

    public static Status d(b6 b6Var, vl vlVar) {
        String str = (String) b6Var.b.h;
        String strValueOf = String.valueOf(vlVar);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + strValueOf.length());
        sb.append("API: ");
        sb.append(str);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(strValueOf);
        return new Status(17, sb.toString(), vlVar.i, vlVar);
    }

    public static ha0 f(Context context) {
        ha0 ha0Var;
        synchronized (x) {
            try {
                if (y == null) {
                    Looper looper = aa0.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = da0.c;
                    y = new ha0(applicationContext, looper);
                }
                ha0Var = y;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ha0Var;
    }

    public final void a(t02 t02Var) {
        synchronized (x) {
            try {
                if (this.q != t02Var) {
                    this.q = t02Var;
                    this.r.clear();
                }
                this.r.addAll(t02Var.l);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        if (this.h) {
            return false;
        }
        nc1 nc1Var = (nc1) mc1.r().h;
        if (nc1Var != null && !nc1Var.h) {
            return false;
        }
        int i = ((SparseIntArray) this.m.g).get(203400000, -1);
        return i == -1 || i == 0;
    }

    public final boolean c(vl vlVar, int i) {
        da0 da0Var = this.l;
        da0Var.getClass();
        Context context = this.k;
        if (!hg0.s(context)) {
            int i2 = vlVar.h;
            PendingIntent activity = vlVar.i;
            if (!((i2 == 0 || activity == null) ? false : true)) {
                activity = null;
                Intent intentB = da0Var.b(context, null, i2);
                if (intentB != null) {
                    activity = PendingIntent.getActivity(context, 0, intentB, a82.a | 134217728);
                }
            }
            if (activity != null) {
                int i3 = GoogleApiActivity.h;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                da0Var.g(context, i2, PendingIntent.getActivity(context, 0, intent, p12.a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final v02 e(ca0 ca0Var) {
        b6 b6Var = ca0Var.k;
        ConcurrentHashMap concurrentHashMap = this.p;
        v02 v02Var = (v02) concurrentHashMap.get(b6Var);
        if (v02Var == null) {
            v02Var = new v02(this, ca0Var);
            concurrentHashMap.put(b6Var, v02Var);
        }
        if (v02Var.h.requiresSignIn()) {
            this.s.add(b6Var);
        }
        v02Var.k();
        return v02Var;
    }

    public final void g(vl vlVar, int i) {
        if (c(vlVar, i)) {
            return;
        }
        t12 t12Var = this.t;
        t12Var.sendMessage(t12Var.obtainMessage(5, i, 0, vlVar));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        v02 v02Var;
        v20[] v20VarArrB;
        switch (message.what) {
            case 1:
                this.g = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.t.removeMessages(12);
                for (b6 b6Var : this.p.keySet()) {
                    t12 t12Var = this.t;
                    t12Var.sendMessageDelayed(t12Var.obtainMessage(12, b6Var), this.g);
                }
                return true;
            case 2:
                message.obj.getClass();
                throw new ClassCastException();
            case 3:
                for (v02 v02Var2 : this.p.values()) {
                    hg0.f(v02Var2.s.t);
                    v02Var2.q = null;
                    v02Var2.k();
                }
                return true;
            case 4:
            case 8:
            case 13:
                f12 f12Var = (f12) message.obj;
                v02 v02VarE = (v02) this.p.get(f12Var.c.k);
                if (v02VarE == null) {
                    v02VarE = e(f12Var.c);
                }
                if (!v02VarE.h.requiresSignIn() || this.o.get() == f12Var.b) {
                    v02VarE.l(f12Var.a);
                    return true;
                }
                f12Var.a.c(v);
                v02VarE.n();
                return true;
            case 5:
                int i = message.arg1;
                vl vlVar = (vl) message.obj;
                Iterator it = this.p.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        v02Var = (v02) it.next();
                        if (v02Var.m == i) {
                        }
                    } else {
                        v02Var = null;
                    }
                }
                if (v02Var == null) {
                    new Exception();
                    return true;
                }
                int i2 = vlVar.h;
                if (i2 != 13) {
                    v02Var.b(d(v02Var.i, vlVar));
                    return true;
                }
                this.l.getClass();
                int i3 = ja0.c;
                String strA = vl.a(i2);
                String str = vlVar.j;
                StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 69 + String.valueOf(str).length());
                sb.append("Error resolution was canceled by the user, original error message: ");
                sb.append(strA);
                sb.append(": ");
                sb.append(str);
                v02Var.b(new Status(17, sb.toString(), null, null));
                return true;
            case 6:
                if (this.k.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.k.getApplicationContext();
                    ea eaVar = ea.k;
                    synchronized (eaVar) {
                        try {
                            if (!eaVar.j) {
                                application.registerActivityLifecycleCallbacks(eaVar);
                                application.registerComponentCallbacks(eaVar);
                                eaVar.j = true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    eaVar.a(new u02(this));
                    AtomicBoolean atomicBoolean = eaVar.h;
                    boolean z = atomicBoolean.get();
                    AtomicBoolean atomicBoolean2 = eaVar.g;
                    if (!z) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean2.set(true);
                        }
                    }
                    if (!atomicBoolean2.get()) {
                        this.g = 300000L;
                        return true;
                    }
                }
                return true;
            case 7:
                e((ca0) message.obj);
                return true;
            case 9:
                if (this.p.containsKey(message.obj)) {
                    v02 v02Var3 = (v02) this.p.get(message.obj);
                    hg0.f(v02Var3.s.t);
                    if (v02Var3.o) {
                        v02Var3.k();
                        return true;
                    }
                }
                return true;
            case 10:
                g9 g9Var = this.s;
                g9Var.getClass();
                b9 b9Var = new b9(g9Var);
                while (b9Var.hasNext()) {
                    v02 v02Var4 = (v02) this.p.remove((b6) b9Var.next());
                    if (v02Var4 != null) {
                        v02Var4.n();
                    }
                }
                this.s.clear();
                return true;
            case 11:
                if (this.p.containsKey(message.obj)) {
                    v02 v02Var5 = (v02) this.p.get(message.obj);
                    ha0 ha0Var = v02Var5.s;
                    hg0.f(ha0Var.t);
                    boolean z2 = v02Var5.o;
                    if (z2) {
                        if (z2) {
                            ha0 ha0Var2 = v02Var5.s;
                            t12 t12Var2 = ha0Var2.t;
                            b6 b6Var2 = v02Var5.i;
                            t12Var2.removeMessages(11, b6Var2);
                            ha0Var2.t.removeMessages(9, b6Var2);
                            v02Var5.o = false;
                        }
                        v02Var5.b(ha0Var.l.c(ha0Var.k, ea0.a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.", null, null) : new Status(22, "API failed to connect while resuming due to an unknown error.", null, null));
                        v02Var5.h.disconnect("Timing out connection while resuming.");
                        return true;
                    }
                }
                return true;
            case 12:
                if (this.p.containsKey(message.obj)) {
                    v02 v02Var6 = (v02) this.p.get(message.obj);
                    hg0.f(v02Var6.s.t);
                    s5 s5Var = v02Var6.h;
                    if (s5Var.isConnected() && v02Var6.l.size() == 0) {
                        oz1 oz1Var = v02Var6.j;
                        if (((Map) oz1Var.h).isEmpty() && ((Map) oz1Var.i).isEmpty()) {
                            s5Var.disconnect("Timing out service connection.");
                            return true;
                        }
                        v02Var6.h();
                        return true;
                    }
                }
                return true;
            case 14:
                message.obj.getClass();
                throw new ClassCastException();
            case 15:
                w02 w02Var = (w02) message.obj;
                if (this.p.containsKey(w02Var.a)) {
                    v02 v02Var7 = (v02) this.p.get(w02Var.a);
                    if (v02Var7.p.contains(w02Var) && !v02Var7.o) {
                        if (v02Var7.h.isConnected()) {
                            v02Var7.d();
                            return true;
                        }
                        v02Var7.k();
                        return true;
                    }
                }
                return true;
            case 16:
                w02 w02Var2 = (w02) message.obj;
                if (this.p.containsKey(w02Var2.a)) {
                    v02 v02Var8 = (v02) this.p.get(w02Var2.a);
                    if (v02Var8.p.remove(w02Var2)) {
                        ha0 ha0Var3 = v02Var8.s;
                        ha0Var3.t.removeMessages(15, w02Var2);
                        ha0Var3.t.removeMessages(16, w02Var2);
                        v20 v20Var = w02Var2.b;
                        LinkedList<y02> linkedList = v02Var8.g;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        for (y02 y02Var : linkedList) {
                            if (y02Var != null && (v20VarArrB = y02Var.b(v02Var8)) != null) {
                                int length = v20VarArrB.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length) {
                                    }
                                    if (!bf1.c(v20VarArrB[i4], v20Var)) {
                                        i4++;
                                    } else if (i4 >= 0) {
                                        arrayList.add(y02Var);
                                    }
                                    break;
                                }
                            }
                        }
                        int size = arrayList.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            y02 y02Var2 = (y02) arrayList.get(i5);
                            linkedList.remove(y02Var2);
                            y02Var2.d(new dq1(v20Var));
                        }
                    }
                }
                return true;
            case 17:
                vm1 vm1Var = this.i;
                if (vm1Var != null) {
                    if (vm1Var.g > 0 || b()) {
                        if (this.j == null) {
                            this.j = new r12(this.k, null, r12.o, wm1.b, ba0.b);
                        }
                        r12 r12Var = this.j;
                        r12Var.getClass();
                        ld ldVar = new ld();
                        ldVar.b = 0;
                        ldVar.d = new v20[]{p02.j};
                        ldVar.a = false;
                        ldVar.c = new pw1(vm1Var);
                        r12Var.c(2, ldVar.a());
                    }
                    this.i = null;
                    return true;
                }
                return true;
            case 18:
                e12 e12Var = (e12) message.obj;
                if (e12Var.c == 0) {
                    vm1 vm1Var2 = new vm1(e12Var.b, Arrays.asList(e12Var.a));
                    if (this.j == null) {
                        this.j = new r12(this.k, null, r12.o, wm1.b, ba0.b);
                    }
                    r12 r12Var2 = this.j;
                    r12Var2.getClass();
                    ld ldVar2 = new ld();
                    ldVar2.b = 0;
                    ldVar2.d = new v20[]{p02.j};
                    ldVar2.a = false;
                    ldVar2.c = new pw1(vm1Var2);
                    r12Var2.c(2, ldVar2.a());
                    return true;
                }
                vm1 vm1Var3 = this.i;
                if (vm1Var3 != null) {
                    List list = vm1Var3.h;
                    if (vm1Var3.g != e12Var.b || (list != null && list.size() >= e12Var.d)) {
                        this.t.removeMessages(17);
                        vm1 vm1Var4 = this.i;
                        if (vm1Var4 != null) {
                            if (vm1Var4.g > 0 || b()) {
                                if (this.j == null) {
                                    this.j = new r12(this.k, null, r12.o, wm1.b, ba0.b);
                                }
                                r12 r12Var3 = this.j;
                                r12Var3.getClass();
                                ld ldVar3 = new ld();
                                ldVar3.b = 0;
                                ldVar3.d = new v20[]{p02.j};
                                ldVar3.a = false;
                                ldVar3.c = new pw1(vm1Var4);
                                r12Var3.c(2, ldVar3.a());
                            }
                            this.i = null;
                        }
                    } else {
                        vm1 vm1Var5 = this.i;
                        eu0 eu0Var = e12Var.a;
                        if (vm1Var5.h == null) {
                            vm1Var5.h = new ArrayList();
                        }
                        vm1Var5.h.add(eu0Var);
                    }
                }
                if (this.i == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(e12Var.a);
                    this.i = new vm1(e12Var.b, arrayList2);
                    t12 t12Var3 = this.t;
                    t12Var3.sendMessageDelayed(t12Var3.obtainMessage(17), e12Var.c);
                    return true;
                }
                return true;
            case 19:
                this.h = false;
                return true;
            default:
                return false;
        }
    }
}
