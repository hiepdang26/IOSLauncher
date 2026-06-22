package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zh extends c {
    public static final Parcelable.Creator<zh> CREATOR = new b(2);
    public boolean g;

    public zh(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.g = parcel.readInt() == 1;
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g ? 1 : 0);
    }
}
