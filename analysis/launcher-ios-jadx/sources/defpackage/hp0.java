package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class hp0 extends b0 {
    public static final Parcelable.Creator<hp0> CREATOR = new zb1(23);
    public final ArrayList g;
    public final boolean h;
    public final boolean i;
    public final d52 j;

    public hp0(ArrayList arrayList, boolean z, boolean z2, d52 d52Var) {
        this.g = arrayList;
        this.h = z;
        this.i = z2;
        this.j = d52Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.D(parcel, 1, Collections.unmodifiableList(this.g));
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h ? 1 : 0);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i ? 1 : 0);
        os.y(parcel, 5, this.j, i);
        os.F(iE, parcel);
    }
}
