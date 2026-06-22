package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class nq0 {
    public final Context a;
    public final jq1 b;
    public final rl0 c = jk0.a().a;
    public final SharedPreferences d;
    public final long e;
    public final long f;
    public final String g;
    public ArrayList h;
    public ArrayList i;
    public HashMap j;

    public nq0(Context context, jq1 jq1Var) {
        this.a = context;
        this.b = jq1Var;
        iy iyVarN = iy.n(context);
        long jO = iyVarN.o(jq1Var);
        this.e = jO;
        this.f = iyVarN.q(jq1Var);
        this.g = uo.f("installed_packages_for_user_", jO);
        this.d = context.getSharedPreferences("com.luutinhit.launcher6.managedusers.prefs", 0);
    }

    public static nq0 c(Context context, jq1 jq1Var) {
        if (!ar1.m || jq1.b().equals(jq1Var)) {
            return null;
        }
        return new nq0(context, jq1Var);
    }

    public static void e(Context context, List list) {
        if (ar1.m) {
            iy iyVarN = iy.n(context);
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                long jO = iyVarN.o((jq1) it.next());
                hashSet.add("installed_packages_for_user_" + jO);
                hashSet.add("user_folder_" + jO);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.luutinhit.launcher6.managedusers.prefs", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (String str : sharedPreferences.getAll().keySet()) {
                if (!hashSet.contains(str)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.apply();
        }
    }

    public final void a(boolean z) {
        try {
            b();
            if (!z || this.h.isEmpty()) {
                return;
            }
            Collections.sort(this.h, new a7(this, 2));
            this.c.a(this.a, this.h);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void b() {
        w40 w40Var;
        if (this.i.isEmpty()) {
            return;
        }
        Collections.sort(this.i, new a7(this, 2));
        String str = "user_folder_" + this.e;
        if (this.d.contains(str)) {
            long j = this.d.getLong(str, 0L);
            this.c.getClass();
            synchronized (rl0.A) {
                w40Var = (w40) rl0.E.get(j);
            }
            if (w40Var == null || (2 & w40Var.r) == 0) {
                this.h.addAll(this.i);
                return;
            }
            f(w40Var.x.size(), j);
            new zp0().execute(new el0(this.i, w40Var, 4, false));
            return;
        }
        w40 w40Var2 = new w40();
        w40Var2.u = this.a.getText(w61.work_folder_name);
        w40Var2.h(null, 2, true);
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            w40Var2.f((og1) obj);
        }
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(w40Var2);
        this.c.a(this.a, arrayList2);
        this.d.edit().putLong("user_folder_" + this.e, w40Var2.g).apply();
        f(0, w40Var2.g);
    }

    public final void d(ek0 ek0Var, long j) {
        ArrayList arrayList = j <= this.f + 28800000 ? this.i : this.h;
        og1 og1VarF = og1.f(ek0Var, this.a);
        this.j.put(og1VarF, Long.valueOf(j));
        arrayList.add(og1VarF);
    }

    public final void f(int i, long j) {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            qh0 qh0Var = (qh0) obj;
            qh0Var.q = i;
            rl0.b(this.a, qh0Var, j, 0L, 0, 0);
            i++;
        }
    }
}
