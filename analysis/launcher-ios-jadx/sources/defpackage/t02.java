package defpackage;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class t02 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public volatile boolean h;
    public final AtomicReference i;
    public final t12 j;
    public final da0 k;
    public final g9 l;
    public final ha0 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t02(bn0 bn0Var, ha0 ha0Var) {
        super(bn0Var);
        da0 da0Var = da0.d;
        this.i = new AtomicReference(null);
        this.j = new t12(Looper.getMainLooper());
        this.k = da0Var;
        this.l = new g9(0);
        this.m = ha0Var;
        bn0Var.b("ConnectionlessLifecycleHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void c(int i, int i2, Intent intent) {
        AtomicReference atomicReference = this.i;
        q12 q12Var = (q12) atomicReference.get();
        ha0 ha0Var = this.m;
        if (i != 1) {
            if (i == 2) {
                int iC = this.k.c(a(), ea0.a);
                if (iC == 0) {
                    atomicReference.set(null);
                    t12 t12Var = ha0Var.t;
                    t12Var.sendMessage(t12Var.obtainMessage(3));
                    return;
                } else {
                    if (q12Var == null) {
                        return;
                    }
                    if (q12Var.b.h == 18 && iC == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            atomicReference.set(null);
            t12 t12Var2 = ha0Var.t;
            t12Var2.sendMessage(t12Var2.obtainMessage(3));
            return;
        } else if (i2 == 0) {
            if (q12Var == null) {
                return;
            }
            vl vlVar = new vl(1, intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, q12Var.b.toString());
            atomicReference.set(null);
            ha0Var.g(vlVar, q12Var.a);
            return;
        }
        if (q12Var != null) {
            atomicReference.set(null);
            ha0Var.g(q12Var.b, q12Var.a);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void d(Bundle bundle) {
        if (bundle != null) {
            this.i.set(bundle.getBoolean("resolving_error", false) ? new q12(new vl(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e() {
        if (this.l.isEmpty()) {
            return;
        }
        this.m.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle) {
        q12 q12Var = (q12) this.i.get();
        if (q12Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", q12Var.a);
        vl vlVar = q12Var.b;
        bundle.putInt("failed_status", vlVar.h);
        bundle.putParcelable("failed_resolution", vlVar.i);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void g() {
        this.h = true;
        if (this.l.isEmpty()) {
            return;
        }
        this.m.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        this.h = false;
        ha0 ha0Var = this.m;
        ha0Var.getClass();
        synchronized (ha0.x) {
            try {
                if (ha0Var.q == this) {
                    ha0Var.q = null;
                    ha0Var.r.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        vl vlVar = new vl(13, null);
        AtomicReference atomicReference = this.i;
        q12 q12Var = (q12) atomicReference.get();
        int i = q12Var == null ? -1 : q12Var.a;
        atomicReference.set(null);
        this.m.g(vlVar, i);
    }
}
