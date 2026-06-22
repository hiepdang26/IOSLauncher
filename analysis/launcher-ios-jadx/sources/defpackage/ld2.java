package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ld2 extends LifecycleCallback {
    public final ArrayList h;

    public ld2(bn0 bn0Var) {
        super(bn0Var);
        this.h = new ArrayList();
        bn0Var.b("TaskOnStopCallback", this);
    }

    public static ld2 i(Activity activity) {
        ld2 ld2Var;
        bn0 bn0VarB = LifecycleCallback.b(activity);
        synchronized (bn0VarB) {
            try {
                ld2Var = (ld2) bn0VarB.c(ld2.class, "TaskOnStopCallback");
                if (ld2Var == null) {
                    ld2Var = new ld2(bn0VarB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ld2Var;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        synchronized (this.h) {
            try {
                ArrayList arrayList = this.h;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    b82 b82Var = (b82) ((WeakReference) obj).get();
                    if (b82Var != null) {
                        b82Var.b();
                    }
                }
                this.h.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(b82 b82Var) {
        synchronized (this.h) {
            this.h.add(new WeakReference(b82Var));
        }
    }
}
