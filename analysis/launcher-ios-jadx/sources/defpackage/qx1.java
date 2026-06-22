package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class qx1 {
    public final ArrayList a;
    public final ArrayList b;
    public final HashMap c;
    public final HashMap d;
    public final m7 e;
    public final jx1 f;
    public final oe0 g;
    public ArrayList h;

    public qx1(Context context, oe0 oe0Var) {
        this.e = m7.f(context);
        this.f = new jx1(context);
        this.g = oe0Var;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new HashMap();
        this.d = new HashMap();
        this.h = new ArrayList();
    }

    public final void a(ArrayList arrayList) {
        ComponentName componentName;
        String packageName;
        jq1 jq1VarB;
        this.h = arrayList;
        arrayList.size();
        HashMap map = new HashMap();
        HashMap map2 = this.c;
        map2.clear();
        this.b.clear();
        this.f.i.clear();
        xg0 xg0Var = jk0.a().e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj instanceof rk0) {
                rk0 rk0Var = (rk0) obj;
                int iMin = Math.min(rk0Var.g, rk0Var.i);
                int iMin2 = Math.min(rk0Var.h, rk0Var.j);
                if (iMin > xg0Var.d || iMin2 > xg0Var.c) {
                    String.format("Widget %s : (%d X %d) can't fit on this device", ((AppWidgetProviderInfo) rk0Var).provider, Integer.valueOf(iMin), Integer.valueOf(iMin2));
                } else {
                    componentName = ((AppWidgetProviderInfo) rk0Var).provider;
                    packageName = componentName.getPackageName();
                    jq1VarB = this.e.h(rk0Var);
                }
            } else if (obj instanceof ResolveInfo) {
                ResolveInfo resolveInfo = (ResolveInfo) obj;
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                packageName = resolveInfo.activityInfo.packageName;
                jq1VarB = jq1.b();
            } else {
                componentName = null;
                packageName = "";
                jq1VarB = null;
            }
            if (componentName == null || jq1VarB == null) {
                obj.getClass().toString();
            } else {
                ArrayList arrayList2 = (ArrayList) map2.get((s01) map.get(packageName));
                if (arrayList2 != null) {
                    arrayList2.add(obj);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(obj);
                    s01 s01Var = new s01();
                    s01Var.z = packageName;
                    this.g.w(packageName, jq1VarB, true, s01Var);
                    map2.put(s01Var, arrayList3);
                    map.put(packageName, s01Var);
                    this.a.add(s01Var);
                }
            }
        }
    }

    public final Object clone() {
        return new qx1(this);
    }

    public qx1(qx1 qx1Var) {
        this.e = qx1Var.e;
        this.a = (ArrayList) qx1Var.a.clone();
        this.b = (ArrayList) qx1Var.a.clone();
        this.c = (HashMap) qx1Var.c.clone();
        this.d = (HashMap) qx1Var.c.clone();
        this.f = qx1Var.f;
        this.g = qx1Var.g;
        this.h = (ArrayList) qx1Var.h.clone();
    }
}
