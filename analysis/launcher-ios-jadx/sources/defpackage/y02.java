package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class y02 {
    public final int a;

    public y02(int i) {
        this.a = i;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(v02 v02Var);

    public abstract v20[] b(v02 v02Var);

    public abstract void c(Status status);

    public abstract void d(RuntimeException runtimeException);

    public abstract void e(v02 v02Var);

    public abstract void f(oz1 oz1Var, boolean z);
}
