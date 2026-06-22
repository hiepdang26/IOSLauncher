package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class x72 extends b12 {
    public eb h;
    public final int i;

    public x72(eb ebVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.h = ebVar;
        this.i = i;
    }

    @Override // defpackage.b12
    public final boolean p(int i, Parcel parcel, Parcel parcel2) {
        int i2 = this.i;
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) i62.a(parcel, Bundle.CREATOR);
            i62.b(parcel);
            hg0.j(this.h, "onPostInitComplete can be called only once per call to getRemoteService");
            this.h.onPostInitHandler(i3, strongBinder, bundle, i2);
            this.h = null;
        } else if (i == 2) {
            parcel.readInt();
            i62.b(parcel);
            new Exception();
        } else {
            if (i != 3) {
                return false;
            }
            int i4 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            qb2 qb2Var = (qb2) i62.a(parcel, qb2.CREATOR);
            i62.b(parcel);
            eb ebVar = this.h;
            hg0.j(ebVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            hg0.i(qb2Var);
            eb.zzj(ebVar, qb2Var);
            Bundle bundle2 = qb2Var.g;
            hg0.j(this.h, "onPostInitComplete can be called only once per call to getRemoteService");
            this.h.onPostInitHandler(i4, strongBinder2, bundle2, i2);
            this.h = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
