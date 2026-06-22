package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class m6 extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m6(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    private final void a(Context context, Intent intent) {
        xh xhVar = (xh) this.b;
        synchronized (xhVar) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : ((WeakHashMap) xhVar.d).entrySet()) {
                    if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                        arrayList.add((BroadcastReceiver) entry.getKey());
                    }
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((BroadcastReceiver) arrayList.get(i)).onReceive(context, intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                ((n6) this.b).h();
                return;
            case 1:
                qg0.l(context, "context");
                qg0.l(intent, "intent");
                ((yd) this.b).f(intent);
                return;
            case 2:
                Objects.toString(context);
                Objects.toString(intent);
                ((t) this.b).closeSystemDialogs();
                return;
            case 3:
                String action = intent.getAction();
                jq1 jq1VarB = jq1.b();
                boolean zEquals = "android.intent.action.PACKAGE_CHANGED".equals(action);
                tk0 tk0Var = (tk0) this.b;
                int i = 0;
                if (!zEquals && !"android.intent.action.PACKAGE_REMOVED".equals(action) && !"android.intent.action.PACKAGE_ADDED".equals(action)) {
                    if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action)) {
                        intent.getBooleanExtra("android.intent.extra.REPLACING", !ar1.n);
                        String[] stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
                        ArrayList arrayListV = tk0Var.V();
                        int size = arrayListV.size();
                        while (i < size) {
                            Object obj = arrayListV.get(i);
                            i++;
                            rl0 rl0Var = (rl0) ((sk0) obj);
                            rl0Var.getClass();
                            Objects.toString(jq1VarB);
                            rl0.g(new ql0(rl0Var, 2, stringArrayExtra, jq1VarB));
                        }
                        return;
                    }
                    if ("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(action)) {
                        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                        String[] stringArrayExtra2 = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
                        ArrayList arrayListV2 = tk0Var.V();
                        int size2 = arrayListV2.size();
                        while (i < size2) {
                            Object obj2 = arrayListV2.get(i);
                            i++;
                            rl0 rl0Var2 = (rl0) ((sk0) obj2);
                            rl0Var2.getClass();
                            Objects.toString(jq1VarB);
                            if (!booleanExtra) {
                                rl0.g(new ql0(rl0Var2, 4, stringArrayExtra2, jq1VarB));
                            }
                        }
                        return;
                    }
                    return;
                }
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                boolean booleanExtra2 = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (schemeSpecificPart == null || schemeSpecificPart.length() == 0) {
                    return;
                }
                if ("android.intent.action.PACKAGE_CHANGED".equals(action)) {
                    ArrayList arrayListV3 = tk0Var.V();
                    int size3 = arrayListV3.size();
                    while (i < size3) {
                        Object obj3 = arrayListV3.get(i);
                        i++;
                        rl0 rl0Var3 = (rl0) ((sk0) obj3);
                        rl0Var3.getClass();
                        Objects.toString(jq1VarB);
                        rl0.g(new ql0(rl0Var3, 2, new String[]{schemeSpecificPart}, jq1VarB));
                    }
                    return;
                }
                if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    if (booleanExtra2) {
                        return;
                    }
                    ArrayList arrayListV4 = tk0Var.V();
                    int size4 = arrayListV4.size();
                    while (i < size4) {
                        Object obj4 = arrayListV4.get(i);
                        i++;
                        rl0 rl0Var4 = (rl0) ((sk0) obj4);
                        rl0Var4.getClass();
                        Objects.toString(jq1VarB);
                        rl0.g(new ql0(rl0Var4, 3, new String[]{schemeSpecificPart}, jq1VarB));
                    }
                    return;
                }
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    if (booleanExtra2) {
                        ArrayList arrayListV5 = tk0Var.V();
                        int size5 = arrayListV5.size();
                        while (i < size5) {
                            Object obj5 = arrayListV5.get(i);
                            i++;
                            rl0 rl0Var5 = (rl0) ((sk0) obj5);
                            rl0Var5.getClass();
                            Objects.toString(jq1VarB);
                            rl0.g(new ql0(rl0Var5, 2, new String[]{schemeSpecificPart}, jq1VarB));
                        }
                        return;
                    }
                    ArrayList arrayListV6 = tk0Var.V();
                    int size6 = arrayListV6.size();
                    while (i < size6) {
                        Object obj6 = arrayListV6.get(i);
                        i++;
                        rl0 rl0Var6 = (rl0) ((sk0) obj6);
                        rl0Var6.getClass();
                        Objects.toString(jq1VarB);
                        rl0.g(new ql0(rl0Var6, 1, new String[]{schemeSpecificPart}, jq1VarB));
                    }
                    return;
                }
                return;
            case 4:
                Objects.toString(context);
                Objects.toString(intent);
                synchronized (rl0.A) {
                    try {
                        ((rl0) this.b).h.getClass();
                        qg0 qg0VarT = qg0.t(jk0.i);
                        PackageManager packageManager = context.getPackageManager();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (Map.Entry entry : rl0.H.entrySet()) {
                            jq1 jq1Var = (jq1) entry.getKey();
                            arrayList.clear();
                            arrayList2.clear();
                            for (String str : (HashSet) entry.getValue()) {
                                if (!qg0VarT.A(str, jq1Var)) {
                                    if (az1.v(packageManager, str, 8192)) {
                                        arrayList2.add(str);
                                    } else {
                                        t.addDumpLog("LauncherModel", "Package not found: " + str, true);
                                        arrayList.add(str);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                rl0 rl0Var7 = (rl0) this.b;
                                ql0 ql0Var = new ql0(rl0Var7, 3, (String[]) arrayList.toArray(new String[0]), jq1Var);
                                rl0Var7.getClass();
                                rl0.g(ql0Var);
                            }
                            if (!arrayList2.isEmpty()) {
                                rl0 rl0Var8 = (rl0) this.b;
                                ql0 ql0Var2 = new ql0(rl0Var8, 4, (String[]) arrayList2.toArray(new String[0]), jq1Var);
                                rl0Var8.getClass();
                                rl0.g(ql0Var2);
                            }
                        }
                        rl0.H.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            case 5:
                gh1 gh1Var = (gh1) this.b;
                gh1Var.getClass();
                gh1.m.execute(new fh1(gh1Var, 2));
                return;
            case 6:
                WallpaperActivity wallpaperActivity = (WallpaperActivity) this.b;
                wallpaperActivity.R.postDelayed(wallpaperActivity.S, 6000L);
                return;
            case 7:
                a(context, intent);
                return;
            default:
                boolean zEquals2 = "android.intent.action.USER_PRESENT".equals(intent.getAction());
                cd2 cd2Var = (cd2) this.b;
                if (zEquals2) {
                    cd2Var.e = true;
                    return;
                } else {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        cd2Var.e = false;
                        return;
                    }
                    return;
                }
        }
    }
}
