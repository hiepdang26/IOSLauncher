package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class jx1 implements Comparator {
    public final m7 g;
    public final PackageManager h;
    public final HashMap i = new HashMap();
    public final Collator j = Collator.getInstance();
    public final jq1 k = jq1.b();

    public jx1(Context context) {
        this.g = m7.f(context);
        this.h = context.getPackageManager();
    }

    public final dl a(Object obj) {
        if (obj instanceof rk0) {
            rk0 rk0Var = (rk0) obj;
            return new dl(((AppWidgetProviderInfo) rk0Var).provider, this.g.h(rk0Var));
        }
        ActivityInfo activityInfo = ((ResolveInfo) obj).activityInfo;
        return new dl(new ComponentName(activityInfo.packageName, activityInfo.name), jq1.b());
    }

    public final String b(Object obj) {
        if (obj instanceof rk0) {
            return ar1.B(this.g.j((rk0) obj));
        }
        try {
            return ar1.B(((ResolveInfo) obj).loadLabel(this.h));
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        dl dlVarA = a(obj);
        dl dlVarA2 = a(obj2);
        jq1 jq1Var = dlVarA.b;
        jq1 jq1Var2 = this.k;
        boolean zEquals = jq1Var2.equals(jq1Var);
        boolean zEquals2 = jq1Var2.equals(dlVarA2.b);
        if (!zEquals && zEquals2) {
            return 1;
        }
        if (zEquals && !zEquals2) {
            return -1;
        }
        HashMap map = this.i;
        String strB = (String) map.get(dlVarA);
        String strB2 = (String) map.get(dlVarA2);
        if (strB == null) {
            strB = b(obj);
            map.put(dlVarA, strB);
        }
        if (strB2 == null) {
            strB2 = b(obj2);
            map.put(dlVarA2, strB2);
        }
        return this.j.compare(strB, strB2);
    }
}
