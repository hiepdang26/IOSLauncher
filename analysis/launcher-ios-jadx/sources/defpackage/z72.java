package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class z72 extends z90 {
    @Override // defpackage.eb
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService");
        return iInterfaceQueryLocalInterface instanceof ua2 ? (ua2) iInterfaceQueryLocalInterface : new ua2(iBinder);
    }

    @Override // defpackage.eb
    public final v20[] getApiFeatures() {
        return os.e;
    }

    @Override // defpackage.eb
    public final int getMinApkVersion() {
        return 212800000;
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.appset.service.START";
    }

    @Override // defpackage.eb
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // defpackage.eb
    public final boolean usesClientTelemetry() {
        return true;
    }
}
