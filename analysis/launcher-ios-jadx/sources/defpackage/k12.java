package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k12 extends b0 {
    public static final Parcelable.Creator<k12> CREATOR = new zb1(9);
    public final ArrayList g;
    public final String h;

    public k12(String str, ArrayList arrayList) {
        this.g = arrayList;
        this.h = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.B(parcel, 1, this.g);
        os.z(parcel, 2, this.h);
        os.F(iE, parcel);
    }
}
