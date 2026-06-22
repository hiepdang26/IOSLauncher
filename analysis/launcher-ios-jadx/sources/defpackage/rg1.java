package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class rg1 extends z90 implements s5 {
    public final boolean b;
    public final mj c;
    public final Bundle d;
    public final Integer e;

    public rg1(Context context, Looper looper, mj mjVar, Bundle bundle, fa0 fa0Var, ga0 ga0Var) {
        super(context, looper, 44, mjVar, fa0Var, ga0Var);
        this.b = true;
        this.c = mjVar;
        this.d = bundle;
        this.e = (Integer) mjVar.g;
    }

    @Override // defpackage.eb
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof j12 ? (j12) iInterfaceQueryLocalInterface : new j12(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // defpackage.eb
    public final Bundle getGetServiceRequestExtraArgs() {
        mj mjVar = this.c;
        boolean zEquals = getContext().getPackageName().equals((String) mjVar.d);
        Bundle bundle = this.d;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) mjVar.d);
        }
        return bundle;
    }

    @Override // defpackage.eb
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // defpackage.eb, defpackage.s5
    public final boolean requiresSignIn() {
        return this.b;
    }
}
