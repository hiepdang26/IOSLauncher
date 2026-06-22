package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.b0;
import defpackage.bf1;
import defpackage.n90;
import defpackage.os;
import defpackage.tu;
import defpackage.vl;
import defpackage.zb1;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends b0 implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zb1(17);
    public final int g;
    public final String h;
    public final PendingIntent i;
    public final vl j;

    public Status(int i, String str, PendingIntent pendingIntent, vl vlVar) {
        this.g = i;
        this.h = str;
        this.i = pendingIntent;
        this.j = vlVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.g == status.g && bf1.c(this.h, status.h) && bf1.c(this.i, status.i) && bf1.c(this.j, status.j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), this.h, this.i, this.j});
    }

    public final String toString() {
        tu tuVar = new tu(this);
        String strP = this.h;
        if (strP == null) {
            strP = n90.p(this.g);
        }
        tuVar.c(strP, "statusCode");
        tuVar.c(this.i, "resolution");
        return tuVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.z(parcel, 2, this.h);
        os.y(parcel, 3, this.i, i);
        os.y(parcel, 4, this.j, i);
        os.F(iE, parcel);
    }
}
