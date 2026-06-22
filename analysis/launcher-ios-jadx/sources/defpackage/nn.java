package defpackage;

import android.os.Build;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class nn {
    public static final nn i = new nn(1, false, false, false, false, -1, -1, xz.g);
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final Set h;

    public nn(int i2, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, Set set) {
        uo.p(i2, "requiredNetworkType");
        qg0.l(set, "contentUriTriggers");
        this.a = i2;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j;
        this.g = j2;
        this.h = set;
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT < 24 || !this.h.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !nn.class.equals(obj.getClass())) {
            return false;
        }
        nn nnVar = (nn) obj;
        if (this.b == nnVar.b && this.c == nnVar.c && this.d == nnVar.d && this.e == nnVar.e && this.f == nnVar.f && this.g == nnVar.g && this.a == nnVar.a) {
            return qg0.d(this.h, nnVar.h);
        }
        return false;
    }

    public final int hashCode() {
        int iV = ((((((((uo.v(this.a) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        long j = this.f;
        int i2 = (iV + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.g;
        return this.h.hashCode() + ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + uo.x(this.a) + ", requiresCharging=" + this.b + ", requiresDeviceIdle=" + this.c + ", requiresBatteryNotLow=" + this.d + ", requiresStorageNotLow=" + this.e + ", contentTriggerUpdateDelayMillis=" + this.f + ", contentTriggerMaxDelayMillis=" + this.g + ", contentUriTriggers=" + this.h + ", }";
    }

    public nn(nn nnVar) {
        qg0.l(nnVar, "other");
        this.b = nnVar.b;
        this.c = nnVar.c;
        this.a = nnVar.a;
        this.d = nnVar.d;
        this.e = nnVar.e;
        this.h = nnVar.h;
        this.f = nnVar.f;
        this.g = nnVar.g;
    }
}
