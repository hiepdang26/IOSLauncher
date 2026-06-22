package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;

/* JADX INFO: loaded from: classes.dex */
public final class yu0 extends Binder implements zd0 {
    public final /* synthetic */ MultiInstanceInvalidationService g;

    public yu0(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.g = multiInstanceInvalidationService;
        attachInterface(this, zd0.d);
    }

    public final void f(int i, String[] strArr) {
        qg0.l(strArr, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.g;
        synchronized (multiInstanceInvalidationService.i) {
            try {
                String str = (String) multiInstanceInvalidationService.h.get(Integer.valueOf(i));
                if (str == null) {
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.i.beginBroadcast();
                for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.i.getBroadcastCookie(i2);
                        qg0.i(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.h.get(num);
                        if (i != iIntValue && str.equals(str2)) {
                            try {
                                ((yd0) multiInstanceInvalidationService.i.getBroadcastItem(i2)).e(strArr);
                            } catch (RemoteException unused) {
                            }
                        }
                    } finally {
                        multiInstanceInvalidationService.i.finishBroadcast();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        String str = zd0.d;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        yd0 yd0Var = null;
        yd0 yd0Var2 = null;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(yd0.c);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof yd0)) {
                    xd0 xd0Var = new xd0();
                    xd0Var.g = strongBinder;
                    yd0Var = xd0Var;
                } else {
                    yd0Var = (yd0) iInterfaceQueryLocalInterface;
                }
            }
            int iP = p(yd0Var, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iP);
            return true;
        }
        if (i != 2) {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            f(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        IBinder strongBinder2 = parcel.readStrongBinder();
        if (strongBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(yd0.c);
            if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof yd0)) {
                xd0 xd0Var2 = new xd0();
                xd0Var2.g = strongBinder2;
                yd0Var2 = xd0Var2;
            } else {
                yd0Var2 = (yd0) iInterfaceQueryLocalInterface2;
            }
        }
        int i3 = parcel.readInt();
        qg0.l(yd0Var2, "callback");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.g;
        synchronized (multiInstanceInvalidationService.i) {
            multiInstanceInvalidationService.i.unregister(yd0Var2);
        }
        parcel2.writeNoException();
        return true;
    }

    public final int p(yd0 yd0Var, String str) {
        qg0.l(yd0Var, "callback");
        int i = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.g;
        synchronized (multiInstanceInvalidationService.i) {
            try {
                int i2 = multiInstanceInvalidationService.g + 1;
                multiInstanceInvalidationService.g = i2;
                if (multiInstanceInvalidationService.i.register(yd0Var, Integer.valueOf(i2))) {
                    multiInstanceInvalidationService.h.put(Integer.valueOf(i2), str);
                    i = i2;
                } else {
                    multiInstanceInvalidationService.g--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
