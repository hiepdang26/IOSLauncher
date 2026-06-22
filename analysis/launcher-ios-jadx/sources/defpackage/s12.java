package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class s12 extends z90 {
    public final wm1 b;

    public s12(Context context, Looper looper, mj mjVar, wm1 wm1Var, v02 v02Var, v02 v02Var2) {
        super(context, looper, 270, mjVar, v02Var, v02Var2);
        this.b = wm1Var;
    }

    @Override // defpackage.eb
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof n12 ? (n12) iInterfaceQueryLocalInterface : new n12(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // defpackage.eb
    public final v20[] getApiFeatures() {
        return p02.k;
    }

    @Override // defpackage.eb
    public final Bundle getGetServiceRequestExtraArgs() {
        this.b.getClass();
        return new Bundle();
    }

    @Override // defpackage.eb
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // defpackage.eb
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
