package defpackage;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m62 extends b0 {
    public static final Parcelable.Creator<m62> CREATOR = new zb1(19);
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Intent n;
    public final sd2 o;
    public final boolean p;

    public m62(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent, IBinder iBinder, boolean z) {
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = str7;
        this.n = intent;
        this.o = (sd2) gy0.r(gy0.q(iBinder));
        this.p = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 2, this.g);
        os.z(parcel, 3, this.h);
        os.z(parcel, 4, this.i);
        os.z(parcel, 5, this.j);
        os.z(parcel, 6, this.k);
        os.z(parcel, 7, this.l);
        os.z(parcel, 8, this.m);
        os.y(parcel, 9, this.n, i);
        os.x(parcel, 10, new gy0(this.o));
        os.G(parcel, 11, 4);
        parcel.writeInt(this.p ? 1 : 0);
        os.F(iE, parcel);
    }

    public m62(Intent intent, sd2 sd2Var) {
        this(null, null, null, null, null, null, null, intent, new gy0(sd2Var), false);
    }

    public m62(String str, String str2, String str3, String str4, String str5, String str6, String str7, sd2 sd2Var) {
        this(str, str2, str3, str4, str5, str6, str7, null, new gy0(sd2Var), false);
    }
}
