package defpackage;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public final class u5 {
    public static final u5 a = new u5();

    public final String a() {
        String processName = Application.getProcessName();
        qg0.k(processName, "getProcessName()");
        return processName;
    }
}
