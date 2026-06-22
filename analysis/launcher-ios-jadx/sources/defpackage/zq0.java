package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zq0 extends c {
    public static final Parcelable.Creator<zq0> CREATOR = new b(6);
    public boolean g;

    public zq0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            zq0.class.getClassLoader();
        }
        this.g = parcel.readInt() == 1;
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g ? 1 : 0);
    }
}
