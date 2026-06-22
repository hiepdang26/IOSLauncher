package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class pa implements Parcelable {
    public static final Parcelable.Creator<pa> CREATOR = new z1(2);
    public int g;
    public Integer h;
    public Integer i;
    public Locale m;
    public CharSequence n;
    public int o;
    public int p;
    public Integer q;
    public Integer s;
    public Integer t;
    public Integer u;
    public Integer v;
    public Integer w;
    public Integer x;
    public int j = 255;
    public int k = -2;
    public int l = -2;
    public Boolean r = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeSerializable(this.h);
        parcel.writeSerializable(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        CharSequence charSequence = this.n;
        parcel.writeString(charSequence == null ? null : charSequence.toString());
        parcel.writeInt(this.o);
        parcel.writeSerializable(this.q);
        parcel.writeSerializable(this.s);
        parcel.writeSerializable(this.t);
        parcel.writeSerializable(this.u);
        parcel.writeSerializable(this.v);
        parcel.writeSerializable(this.w);
        parcel.writeSerializable(this.x);
        parcel.writeSerializable(this.r);
        parcel.writeSerializable(this.m);
    }
}
