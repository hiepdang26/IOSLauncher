package defpackage;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return c.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new kd(parcel, null);
            case 2:
                return new zh(parcel, null);
            case 3:
                return new ro(parcel, null);
            case 4:
                return new kx(parcel, null);
            case 5:
                return new d20(parcel, null);
            case 6:
                return new zq0(parcel, null);
            case 7:
                return new rw0(parcel, null);
            case 8:
                return new o11(parcel, null);
            case 9:
                return new f91(parcel, null);
            case 10:
                return new hn1(parcel, null);
            case 11:
                return new ot1(parcel, null);
            default:
                if (Build.VERSION.SDK_INT >= 24) {
                    return new xt1(parcel, null);
                }
                xt1 xt1Var = new xt1(parcel);
                xt1Var.g = parcel.readInt();
                xt1Var.h = parcel.readInt();
                xt1Var.i = parcel.readParcelable(null);
                return xt1Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new c[i];
            case 1:
                return new kd[i];
            case 2:
                return new zh[i];
            case 3:
                return new ro[i];
            case 4:
                return new kx[i];
            case 5:
                return new d20[i];
            case 6:
                return new zq0[i];
            case 7:
                return new rw0[i];
            case 8:
                return new o11[i];
            case 9:
                return new f91[i];
            case 10:
                return new hn1[i];
            case 11:
                return new ot1[i];
            default:
                return new xt1[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new kd(parcel, classLoader);
            case 2:
                return new zh(parcel, classLoader);
            case 3:
                return new ro(parcel, classLoader);
            case 4:
                return new kx(parcel, classLoader);
            case 5:
                return new d20(parcel, classLoader);
            case 6:
                return new zq0(parcel, classLoader);
            case 7:
                return new rw0(parcel, classLoader);
            case 8:
                return new o11(parcel, classLoader);
            case 9:
                return new f91(parcel, classLoader);
            case 10:
                return new hn1(parcel, classLoader);
            case 11:
                return new ot1(parcel, classLoader);
            default:
                if (Build.VERSION.SDK_INT >= 24) {
                    return new xt1(parcel, classLoader);
                }
                xt1 xt1Var = new xt1(parcel);
                xt1Var.g = parcel.readInt();
                xt1Var.h = parcel.readInt();
                xt1Var.i = parcel.readParcelable(null);
                return xt1Var;
        }
    }
}
