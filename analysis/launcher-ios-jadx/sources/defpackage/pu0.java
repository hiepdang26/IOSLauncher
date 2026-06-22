package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public final class pu0 implements Comparable, Parcelable {
    public static final Parcelable.Creator<pu0> CREATOR = new z1(20);
    public final Calendar g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final long l;
    public String m;

    public pu0(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarA = sq1.a(calendar);
        this.g = calendarA;
        this.h = calendarA.get(2);
        this.i = calendarA.get(1);
        this.j = calendarA.getMaximum(7);
        this.k = calendarA.getActualMaximum(5);
        this.l = calendarA.getTimeInMillis();
    }

    public static pu0 b(int i, int i2) {
        Calendar calendarC = sq1.c(null);
        calendarC.set(1, i);
        calendarC.set(2, i2);
        return new pu0(calendarC);
    }

    public static pu0 c(long j) {
        Calendar calendarC = sq1.c(null);
        calendarC.setTimeInMillis(j);
        return new pu0(calendarC);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(pu0 pu0Var) {
        return this.g.compareTo(pu0Var.g);
    }

    public final int d() {
        Calendar calendar = this.g;
        int firstDayOfWeek = calendar.get(7) - calendar.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.j : firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        if (this.m == null) {
            this.m = DateUtils.formatDateTime(null, this.g.getTimeInMillis(), 8228);
        }
        return this.m;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pu0)) {
            return false;
        }
        pu0 pu0Var = (pu0) obj;
        return this.h == pu0Var.h && this.i == pu0Var.i;
    }

    public final int f(pu0 pu0Var) {
        if (!(this.g instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (pu0Var.h - this.h) + ((pu0Var.i - this.i) * 12);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.i)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.i);
        parcel.writeInt(this.h);
    }
}
