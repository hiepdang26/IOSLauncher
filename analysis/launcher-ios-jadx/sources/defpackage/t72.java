package defpackage;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class t72 implements lv0 {
    public final String a;
    public final s72 b;

    public t72(s72 s72Var) {
        String strZze;
        this.b = s72Var;
        try {
            strZze = s72Var.zze();
        } catch (RemoteException unused) {
            k92.f();
            strZze = null;
        }
        this.a = strZze;
    }

    public final String toString() {
        return this.a;
    }
}
