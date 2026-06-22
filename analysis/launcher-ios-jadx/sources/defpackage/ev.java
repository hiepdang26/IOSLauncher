package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b;

/* JADX INFO: loaded from: classes.dex */
public class ev extends w50 implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public final bv Z;
    public final cv a0;
    public int b0;
    public int c0;
    public boolean d0;
    public boolean e0;
    public int f0;
    public boolean g0;
    public final mc1 h0;
    public Dialog i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;

    public ev() {
        new o1(this, 15);
        this.Z = new bv(this, 0);
        this.a0 = new cv(this);
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = true;
        this.e0 = true;
        this.f0 = -1;
        this.h0 = new mc1(this, 9);
        this.m0 = false;
    }

    @Override // defpackage.w50
    public final void B() {
        this.J = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = true;
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!this.k0) {
                onDismiss(this.i0);
            }
            this.i0 = null;
            this.m0 = false;
        }
    }

    @Override // defpackage.w50
    public final void C() {
        this.J = true;
        if (!this.l0 && !this.k0) {
            this.k0 = true;
        }
        mc1 mc1Var = this.h0;
        b bVar = this.V;
        bVar.getClass();
        b.a("removeObserver");
        lo0 lo0Var = (lo0) bVar.b.b(mc1Var);
        if (lo0Var == null) {
            return;
        }
        lo0Var.c();
        lo0Var.b(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x0018, B:14:0x0024, B:24:0x003c, B:26:0x0046, B:29:0x0050, B:20:0x002e, B:22:0x0034, B:23:0x0039, B:30:0x0068), top: B:45:0x0018 }] */
    @Override // defpackage.w50
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater D(android.os.Bundle r7) {
        /*
            r6 = this;
            android.view.LayoutInflater r7 = super.D(r7)
            boolean r0 = r6.e0
            r1 = 2
            if (r0 == 0) goto L87
            boolean r2 = r6.g0
            if (r2 == 0) goto Lf
            goto L87
        Lf:
            if (r0 != 0) goto L12
            goto L71
        L12:
            boolean r0 = r6.m0
            if (r0 != 0) goto L71
            r0 = 0
            r2 = 1
            r6.g0 = r2     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r3 = r6.U()     // Catch: java.lang.Throwable -> L4e
            r6.i0 = r3     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r6.e0     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L68
            int r4 = r6.b0     // Catch: java.lang.Throwable -> L4e
            if (r4 == r2) goto L39
            if (r4 == r1) goto L39
            r5 = 3
            if (r4 == r5) goto L2e
            goto L3c
        L2e:
            android.view.Window r4 = r3.getWindow()     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L39
            r5 = 24
            r4.addFlags(r5)     // Catch: java.lang.Throwable -> L4e
        L39:
            r3.requestWindowFeature(r2)     // Catch: java.lang.Throwable -> L4e
        L3c:
            android.content.Context r3 = r6.p()     // Catch: java.lang.Throwable -> L4e
            boolean r4 = defpackage.uo.r(r3)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L50
            android.app.Dialog r4 = r6.i0     // Catch: java.lang.Throwable -> L4e
            android.app.Activity r3 = (android.app.Activity) r3     // Catch: java.lang.Throwable -> L4e
            r4.setOwnerActivity(r3)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r7 = move-exception
            goto L6e
        L50:
            android.app.Dialog r3 = r6.i0     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r6.d0     // Catch: java.lang.Throwable -> L4e
            r3.setCancelable(r4)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r3 = r6.i0     // Catch: java.lang.Throwable -> L4e
            bv r4 = r6.Z     // Catch: java.lang.Throwable -> L4e
            r3.setOnCancelListener(r4)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r3 = r6.i0     // Catch: java.lang.Throwable -> L4e
            cv r4 = r6.a0     // Catch: java.lang.Throwable -> L4e
            r3.setOnDismissListener(r4)     // Catch: java.lang.Throwable -> L4e
            r6.m0 = r2     // Catch: java.lang.Throwable -> L4e
            goto L6b
        L68:
            r2 = 0
            r6.i0 = r2     // Catch: java.lang.Throwable -> L4e
        L6b:
            r6.g0 = r0
            goto L71
        L6e:
            r6.g0 = r0
            throw r7
        L71:
            boolean r0 = defpackage.h60.E(r1)
            if (r0 == 0) goto L7a
            r6.toString()
        L7a:
            android.app.Dialog r0 = r6.i0
            if (r0 == 0) goto L90
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r7 = r7.cloneInContext(r0)
            return r7
        L87:
            boolean r0 = defpackage.h60.E(r1)
            if (r0 == 0) goto L90
            r6.toString()
        L90:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ev.D(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // defpackage.w50
    public void G(Bundle bundle) {
        Dialog dialog = this.i0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.b0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.c0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.d0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.e0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // defpackage.w50
    public void H() {
        this.J = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = false;
            dialog.show();
            View decorView = this.i0.getWindow().getDecorView();
            qg0.l(decorView, "<this>");
            decorView.setTag(c61.view_tree_lifecycle_owner, this);
            decorView.setTag(d61.view_tree_view_model_store_owner, this);
            decorView.setTag(p51.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // defpackage.w50
    public void I() {
        this.J = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // defpackage.w50
    public final void K(Bundle bundle) {
        Bundle bundle2;
        this.J = true;
        if (this.i0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.i0.onRestoreInstanceState(bundle2);
    }

    @Override // defpackage.w50
    public final void L(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.L(layoutInflater, viewGroup, bundle);
        if (this.L != null || this.i0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.i0.onRestoreInstanceState(bundle2);
    }

    public Dialog U() {
        if (h60.E(3)) {
            toString();
        }
        return new Dialog(N(), this.c0);
    }

    @Override // defpackage.w50
    public final wd e() {
        return new dv(this, new u50(this));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.j0) {
            return;
        }
        if (h60.E(3)) {
            toString();
        }
        if (this.k0) {
            return;
        }
        this.k0 = true;
        this.l0 = false;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
        }
        this.j0 = true;
        if (this.f0 >= 0) {
            h60 h60VarR = r();
            int i = this.f0;
            if (i < 0) {
                throw new IllegalArgumentException(k31.k(i, "Bad id: "));
            }
            h60VarR.v(new g60(h60VarR, i), false);
            this.f0 = -1;
            return;
        }
        ca caVar = new ca(r());
        h60 h60Var = this.y;
        if (h60Var == null || h60Var == caVar.q) {
            caVar.b(new n60(3, this));
            caVar.d(true);
        } else {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
    }

    @Override // defpackage.w50
    public final void x(e6 e6Var) {
        super.x(e6Var);
        this.V.d(this.h0);
        if (this.l0) {
            return;
        }
        this.k0 = false;
    }

    @Override // defpackage.w50
    public void y(Bundle bundle) {
        super.y(bundle);
        new Handler();
        this.e0 = this.D == 0;
        if (bundle != null) {
            this.b0 = bundle.getInt("android:style", 0);
            this.c0 = bundle.getInt("android:theme", 0);
            this.d0 = bundle.getBoolean("android:cancelable", true);
            this.e0 = bundle.getBoolean("android:showsDialog", this.e0);
            this.f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
