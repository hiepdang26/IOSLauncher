package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class na2 extends x12 {
    public final IBinder g;
    public final /* synthetic */ eb h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public na2(eb ebVar, int i, IBinder iBinder, Bundle bundle) {
        super(ebVar, i, bundle);
        this.h = ebVar;
        this.g = iBinder;
    }

    @Override // defpackage.x12
    public final void a(vl vlVar) {
        eb ebVar = this.h;
        if (ebVar.zzx != null) {
            ebVar.zzx.onConnectionFailed(vlVar);
        }
        ebVar.onConnectionFailed(vlVar);
    }

    @Override // defpackage.x12
    public final boolean b() {
        String interfaceDescriptor;
        eb ebVar;
        IBinder iBinder = this.g;
        try {
            hg0.i(iBinder);
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
            ebVar = this.h;
        } catch (RemoteException unused) {
        }
        if (!ebVar.getServiceDescriptor().equals(interfaceDescriptor)) {
            ebVar.getServiceDescriptor();
            return false;
        }
        IInterface iInterfaceCreateServiceInterface = ebVar.createServiceInterface(iBinder);
        if (iInterfaceCreateServiceInterface != null && (eb.zzn(ebVar, 2, 4, iInterfaceCreateServiceInterface) || eb.zzn(ebVar, 3, 4, iInterfaceCreateServiceInterface))) {
            ebVar.zzB = null;
            Bundle connectionHint = ebVar.getConnectionHint();
            if (ebVar.zzw == null) {
                return true;
            }
            ebVar.zzw.onConnected(connectionHint);
            return true;
        }
        return false;
    }
}
