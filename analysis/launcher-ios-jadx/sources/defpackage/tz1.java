package defpackage;

import android.content.Context;
import androidx.work.WorkerParameters;

/* JADX INFO: loaded from: classes.dex */
public abstract class tz1 {
    public static final /* synthetic */ int a = 0;

    static {
        ka0.r("WorkerFactory");
    }

    public final io0 a(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        io0 io0Var = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(io0.class);
        } catch (Throwable unused) {
            ka0.j().getClass();
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                io0Var = (io0) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable unused2) {
                ka0.j().getClass();
            }
        }
        if (io0Var == null || !io0Var.isUsed()) {
            return io0Var;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
