package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d20 extends c {
    public static final Parcelable.Creator<d20> CREATOR = new b(5);
    public final ug1 g;

    public d20(Parcelable parcelable) {
        super(parcelable);
        this.g = new ug1(0);
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.g + "}";
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        ug1 ug1Var = this.g;
        int i2 = ug1Var.i;
        parcel.writeInt(i2);
        String[] strArr = new String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = (String) ug1Var.f(i3);
            bundleArr[i3] = (Bundle) ug1Var.j(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public d20(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.g = new ug1(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.g.put(strArr[i2], bundleArr[i2]);
        }
    }
}
