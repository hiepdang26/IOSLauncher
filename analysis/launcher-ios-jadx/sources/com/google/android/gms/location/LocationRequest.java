package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.b0;
import defpackage.os;
import defpackage.zb1;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends b0 implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zb1(21);
    public int g = 102;
    public long h = 3600000;
    public long i = 600000;
    public boolean j = false;
    public long k = Long.MAX_VALUE;
    public int l = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public float m = 0.0f;
    public long n = 0;
    public boolean o = false;

    @Deprecated
    public LocationRequest() {
    }

    public static void b(long j) {
        if (j >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("invalid interval: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void a() {
        b(10000L);
        this.h = 10000L;
        if (this.j) {
            return;
        }
        this.i = (long) (10000 / 6.0d);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        if (this.g != locationRequest.g) {
            return false;
        }
        long j = this.h;
        long j2 = locationRequest.h;
        if (j != j2 || this.i != locationRequest.i || this.j != locationRequest.j || this.k != locationRequest.k || this.l != locationRequest.l || this.m != locationRequest.m) {
            return false;
        }
        long j3 = this.n;
        if (j3 >= j) {
            j = j3;
        }
        long j4 = locationRequest.n;
        if (j4 >= j2) {
            j2 = j4;
        }
        return j == j2 && this.o == locationRequest.o;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Long.valueOf(this.h), Float.valueOf(this.m), Long.valueOf(this.n)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request[");
        int i = this.g;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.g != 105) {
            sb.append(" requested=");
            sb.append(this.h);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.i);
        sb.append("ms");
        long j = this.h;
        long j2 = this.n;
        if (j2 > j) {
            sb.append(" maxWait=");
            sb.append(j2);
            sb.append("ms");
        }
        float f = this.m;
        if (f > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(f);
            sb.append("m");
        }
        long j3 = this.k;
        if (j3 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j3 - jElapsedRealtime);
            sb.append("ms");
        }
        int i2 = this.l;
        if (i2 != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(i2);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        int i2 = this.g;
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        long j = this.h;
        os.G(parcel, 2, 8);
        parcel.writeLong(j);
        long j2 = this.i;
        os.G(parcel, 3, 8);
        parcel.writeLong(j2);
        boolean z = this.j;
        os.G(parcel, 4, 4);
        parcel.writeInt(z ? 1 : 0);
        os.G(parcel, 5, 8);
        parcel.writeLong(this.k);
        os.G(parcel, 6, 4);
        parcel.writeInt(this.l);
        os.G(parcel, 7, 4);
        parcel.writeFloat(this.m);
        os.G(parcel, 8, 8);
        parcel.writeLong(this.n);
        boolean z2 = this.o;
        os.G(parcel, 9, 4);
        parcel.writeInt(z2 ? 1 : 0);
        os.F(iE, parcel);
    }
}
