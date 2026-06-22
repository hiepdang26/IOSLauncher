package defpackage;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class b12 extends Binder implements IInterface {
    public final /* synthetic */ int g;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.g;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (this.g) {
            case 0:
                if (i > 16777215) {
                    if (!super.onTransact(i, parcel, parcel2, i2)) {
                    }
                    return true;
                }
                parcel.enforceInterface(getInterfaceDescriptor());
                switch (i) {
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        o12 o12Var = (o12) a12.a(parcel, o12.CREATOR);
                        g12 g12Var = (g12) this;
                        g12Var.i.post(new el0(g12Var, o12Var, 21));
                        break;
                    case 9:
                        break;
                }
                parcel2.writeNoException();
                return true;
            case 1:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return p(i, parcel, parcel2);
            default:
                if (i > 16777215) {
                    if (!super.onTransact(i, parcel, parcel2, i2)) {
                    }
                    return true;
                }
                parcel.enforceInterface(getInterfaceDescriptor());
                d62 d62Var = (d62) this;
                if (i != 1) {
                    return false;
                }
                Parcelable.Creator creator = Bundle.CREATOR;
                int i3 = m52.a;
                Bundle bundle = (Bundle) (parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel));
                int iDataAvail = parcel.dataAvail();
                if (iDataAvail <= 0) {
                    d62Var.r(bundle);
                    parcel2.writeNoException();
                    return true;
                }
                StringBuilder sb = new StringBuilder(56);
                sb.append("Parcel data not fully consumed, unread size: ");
                sb.append(iDataAvail);
                throw new BadParcelableException(sb.toString());
        }
    }

    public boolean p(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    public b12(String str) {
        this.g = 1;
        attachInterface(this, str);
    }
}
