package defpackage;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class or {
    public final Object a = new Object();
    public final vd0 b;
    public final kr c;
    public final ComponentName d;

    public or(vd0 vd0Var, kr krVar, ComponentName componentName) {
        this.b = vd0Var;
        this.c = krVar;
        this.d = componentName;
    }

    public final void a(String str) {
        Bundle bundle = new Bundle();
        synchronized (this.a) {
            try {
                try {
                    ((td0) this.b).p(this.c, str, bundle);
                } catch (RemoteException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
