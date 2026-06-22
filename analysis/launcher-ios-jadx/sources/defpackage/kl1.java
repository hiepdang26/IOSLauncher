package defpackage;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class kl1 implements qy0, h10 {
    public static final /* synthetic */ int p = 0;
    public final cz1 g;
    public final rm1 h;
    public final Object i = new Object();
    public zy1 j;
    public final LinkedHashMap k;
    public final HashMap l;
    public final HashMap m;
    public final pw1 n;
    public SystemForegroundService o;

    static {
        ka0.r("SystemFgDispatcher");
    }

    public kl1(Context context) {
        cz1 cz1VarO = cz1.O(context);
        this.g = cz1VarO;
        this.h = cz1VarO.k;
        this.j = null;
        this.k = new LinkedHashMap();
        this.m = new HashMap();
        this.l = new HashMap();
        this.n = new pw1(cz1VarO.q);
        cz1VarO.m.a(this);
    }

    public static Intent a(Context context, zy1 zy1Var, o50 o50Var) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", o50Var.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", o50Var.b);
        intent.putExtra("KEY_NOTIFICATION", o50Var.c);
        intent.putExtra("KEY_WORKSPEC_ID", zy1Var.a);
        intent.putExtra("KEY_GENERATION", zy1Var.b);
        return intent;
    }

    public static Intent c(Context context, zy1 zy1Var, o50 o50Var) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", zy1Var.a);
        intent.putExtra("KEY_GENERATION", zy1Var.b);
        intent.putExtra("KEY_NOTIFICATION_ID", o50Var.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", o50Var.b);
        intent.putExtra("KEY_NOTIFICATION", o50Var.c);
        return intent;
    }

    @Override // defpackage.qy0
    public final void b(lz1 lz1Var, sn snVar) {
        if (snVar instanceof rn) {
            ka0.j().getClass();
            zy1 zy1VarI = m90.i(lz1Var);
            cz1 cz1Var = this.g;
            cz1Var.getClass();
            bj1 bj1Var = new bj1(zy1VarI);
            s31 s31Var = cz1Var.m;
            qg0.l(s31Var, "processor");
            ((qm0) cz1Var.k).e(new qj1(s31Var, bj1Var, true, -512));
        }
    }

    @Override // defpackage.h10
    public final void d(zy1 zy1Var, boolean z) {
        Map.Entry entry;
        synchronized (this.i) {
            try {
                fi0 fi0Var = ((lz1) this.l.remove(zy1Var)) != null ? (fi0) this.m.remove(zy1Var) : null;
                if (fi0Var != null) {
                    fi0Var.b(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        o50 o50Var = (o50) this.k.remove(zy1Var);
        if (zy1Var.equals(this.j)) {
            if (this.k.size() > 0) {
                Iterator it = this.k.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.j = (zy1) entry.getKey();
                if (this.o != null) {
                    o50 o50Var2 = (o50) entry.getValue();
                    SystemForegroundService systemForegroundService = this.o;
                    systemForegroundService.h.post(new wj0(systemForegroundService, o50Var2.a, o50Var2.c, o50Var2.b));
                    SystemForegroundService systemForegroundService2 = this.o;
                    systemForegroundService2.h.post(new yf(systemForegroundService2, o50Var2.a, 3));
                }
            } else {
                this.j = null;
            }
        }
        SystemForegroundService systemForegroundService3 = this.o;
        if (o50Var == null || systemForegroundService3 == null) {
            return;
        }
        ka0 ka0VarJ = ka0.j();
        zy1Var.toString();
        ka0VarJ.getClass();
        systemForegroundService3.h.post(new yf(systemForegroundService3, o50Var.a, 3));
    }

    public final void e(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        zy1 zy1Var = new zy1(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        ka0.j().getClass();
        if (notification == null || this.o == null) {
            return;
        }
        o50 o50Var = new o50(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.k;
        linkedHashMap.put(zy1Var, o50Var);
        if (this.j == null) {
            this.j = zy1Var;
            SystemForegroundService systemForegroundService = this.o;
            systemForegroundService.h.post(new wj0(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.o;
        systemForegroundService2.h.post(new s1(systemForegroundService2, intExtra, notification, 9));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i |= ((o50) ((Map.Entry) it.next()).getValue()).b;
        }
        o50 o50Var2 = (o50) linkedHashMap.get(this.j);
        if (o50Var2 != null) {
            SystemForegroundService systemForegroundService3 = this.o;
            systemForegroundService3.h.post(new wj0(systemForegroundService3, o50Var2.a, o50Var2.c, i));
        }
    }

    public final void f() {
        this.o = null;
        synchronized (this.i) {
            try {
                Iterator it = this.m.values().iterator();
                while (it.hasNext()) {
                    ((fi0) it.next()).b(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.g.m.h(this);
    }
}
