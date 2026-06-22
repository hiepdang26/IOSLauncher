package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class q31 {
    static {
        qg0.k(ka0.r("ProcessUtils"), "tagWithPrefix(\"ProcessUtils\")");
    }

    public static final boolean a(Context context, rl rlVar) {
        String strA;
        Object next;
        Object objInvoke;
        qg0.l(context, "context");
        qg0.l(rlVar, "configuration");
        if (Build.VERSION.SDK_INT >= 28) {
            strA = u5.a.a();
        } else {
            strA = null;
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, az1.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, null);
                qg0.h(objInvoke);
            } catch (Throwable unused) {
                ka0.j().getClass();
            }
            if (objInvoke instanceof String) {
                strA = (String) objInvoke;
            } else {
                int iMyPid = Process.myPid();
                Object systemService = context.getSystemService("activity");
                qg0.i(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<T> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((ActivityManager.RunningAppProcessInfo) next).pid == iMyPid) {
                            break;
                        }
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                    if (runningAppProcessInfo != null) {
                        strA = runningAppProcessInfo.processName;
                    }
                }
            }
        }
        return qg0.d(strA, context.getApplicationInfo().processName);
    }
}
