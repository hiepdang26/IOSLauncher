package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class kx extends c {
    public static final Parcelable.Creator<kx> CREATOR = new b(4);
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    public kx(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.g = 0;
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
    }

    @Override // defpackage.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
    }
}
