package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f91 extends c {
    public static final Parcelable.Creator<f91> CREATOR = new b(9);
    public Parcelable g;

    public f91(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.g = parcel.readParcelable(classLoader == null ? u81.class.getClassLoader() : classLoader);
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.g, 0);
    }
}
