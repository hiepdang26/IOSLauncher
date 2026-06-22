package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class y32 extends z90 {
    public final String b;
    public final wb2 c;

    public y32(Context context, Looper looper, v02 v02Var, v02 v02Var2, mj mjVar) {
        super(context, looper, 23, mjVar, v02Var, v02Var2);
        m21 m21Var = new m21();
        this.b = "locationServices";
        this.c = new wb2(m21Var);
    }

    @Override // defpackage.eb
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof b32 ? (b32) iInterfaceQueryLocalInterface : new b32(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // defpackage.eb, defpackage.s5
    public final void disconnect() {
        synchronized (this.c) {
            if (isConnected()) {
                try {
                    this.c.H();
                    this.c.getClass();
                } catch (Exception unused) {
                }
            }
            super.disconnect();
        }
    }

    @Override // defpackage.eb
    public final v20[] getApiFeatures() {
        return n90.g;
    }

    @Override // defpackage.eb
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.b);
        return bundle;
    }

    @Override // defpackage.eb
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // defpackage.eb
    public final boolean usesClientTelemetry() {
        return true;
    }
}
