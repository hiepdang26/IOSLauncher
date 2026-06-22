package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class vm1 extends b0 {
    public static final Parcelable.Creator<vm1> CREATOR = new zb1(6);
    public final int g;
    public List h;

    public vm1(int i, List list) {
        this.g = i;
        this.h = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.D(parcel, 2, this.h);
        os.F(iE, parcel);
    }
}
