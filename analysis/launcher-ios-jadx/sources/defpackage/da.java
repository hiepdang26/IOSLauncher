package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class da implements Parcelable {
    public static final Parcelable.Creator<da> CREATOR = new z1(1);
    public final int[] g;
    public final ArrayList h;
    public final int[] i;
    public final int[] j;
    public final int k;
    public final String l;
    public final int m;
    public final int n;
    public final CharSequence o;
    public final int p;
    public final CharSequence q;
    public final ArrayList r;
    public final ArrayList s;
    public final boolean t;

    public da(ca caVar) {
        int size = caVar.a.size();
        this.g = new int[size * 5];
        if (!caVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.h = new ArrayList(size);
        this.i = new int[size];
        this.j = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            n60 n60Var = (n60) caVar.a.get(i2);
            int i3 = i + 1;
            this.g[i] = n60Var.a;
            ArrayList arrayList = this.h;
            w50 w50Var = n60Var.b;
            arrayList.add(w50Var != null ? w50Var.l : null);
            int[] iArr = this.g;
            iArr[i3] = n60Var.c;
            iArr[i + 2] = n60Var.d;
            int i4 = i + 4;
            iArr[i + 3] = n60Var.e;
            i += 5;
            iArr[i4] = n60Var.f;
            this.i[i2] = n60Var.g.ordinal();
            this.j[i2] = n60Var.h.ordinal();
        }
        this.k = caVar.f;
        this.l = caVar.i;
        this.m = caVar.s;
        this.n = caVar.j;
        this.o = caVar.k;
        this.p = caVar.l;
        this.q = caVar.m;
        this.r = caVar.n;
        this.s = caVar.o;
        this.t = caVar.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.g);
        parcel.writeStringList(this.h);
        parcel.writeIntArray(this.i);
        parcel.writeIntArray(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        TextUtils.writeToParcel(this.o, parcel, 0);
        parcel.writeInt(this.p);
        TextUtils.writeToParcel(this.q, parcel, 0);
        parcel.writeStringList(this.r);
        parcel.writeStringList(this.s);
        parcel.writeInt(this.t ? 1 : 0);
    }

    public da(Parcel parcel) {
        this.g = parcel.createIntArray();
        this.h = parcel.createStringArrayList();
        this.i = parcel.createIntArray();
        this.j = parcel.createIntArray();
        this.k = parcel.readInt();
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.o = (CharSequence) creator.createFromParcel(parcel);
        this.p = parcel.readInt();
        this.q = (CharSequence) creator.createFromParcel(parcel);
        this.r = parcel.createStringArrayList();
        this.s = parcel.createStringArrayList();
        this.t = parcel.readInt() != 0;
    }
}
