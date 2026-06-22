package defpackage;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class mz1 {
    public final WorkDatabase_Impl a;
    public final su b;
    public final pm0 c;
    public final pm0 d;
    public final pm0 e;
    public final pm0 f;
    public final pm0 g;
    public final pm0 h;
    public final pm0 i;
    public final pm0 j;
    public final pm0 k;
    public final pm0 l;
    public final pm0 m;
    public final pm0 n;

    public mz1(WorkDatabase_Impl workDatabase_Impl) {
        this.a = workDatabase_Impl;
        this.b = new su(workDatabase_Impl, 7);
        new om0(workDatabase_Impl, 2);
        this.c = new pm0(workDatabase_Impl, 13);
        this.d = new pm0(workDatabase_Impl, 14);
        this.e = new pm0(workDatabase_Impl, 15);
        this.f = new pm0(workDatabase_Impl, 16);
        this.g = new pm0(workDatabase_Impl, 17);
        this.h = new pm0(workDatabase_Impl, 18);
        this.i = new pm0(workDatabase_Impl, 19);
        this.j = new pm0(workDatabase_Impl, 5);
        new pm0(workDatabase_Impl, 6);
        this.k = new pm0(workDatabase_Impl, 7);
        this.l = new pm0(workDatabase_Impl, 8);
        this.m = new pm0(workDatabase_Impl, 9);
        new pm0(workDatabase_Impl, 10);
        new pm0(workDatabase_Impl, 11);
        this.n = new pm0(workDatabase_Impl, 12);
    }

    public final ArrayList a() throws Throwable {
        lc1 lc1Var;
        lc1 lc1VarA = lc1.a(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        lc1VarA.q(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iN = hg0.n(cursorL, "id");
            int iN2 = hg0.n(cursorL, "state");
            int iN3 = hg0.n(cursorL, "worker_class_name");
            int iN4 = hg0.n(cursorL, "input_merger_class_name");
            int iN5 = hg0.n(cursorL, "input");
            int iN6 = hg0.n(cursorL, "output");
            int iN7 = hg0.n(cursorL, "initial_delay");
            int iN8 = hg0.n(cursorL, "interval_duration");
            int iN9 = hg0.n(cursorL, "flex_duration");
            int iN10 = hg0.n(cursorL, "run_attempt_count");
            int iN11 = hg0.n(cursorL, "backoff_policy");
            int iN12 = hg0.n(cursorL, "backoff_delay_duration");
            int iN13 = hg0.n(cursorL, "last_enqueue_time");
            lc1Var = lc1VarA;
            try {
                int iN14 = hg0.n(cursorL, "minimum_retention_duration");
                int iN15 = hg0.n(cursorL, "schedule_requested_at");
                int iN16 = hg0.n(cursorL, "run_in_foreground");
                int iN17 = hg0.n(cursorL, "out_of_quota_policy");
                int iN18 = hg0.n(cursorL, "period_count");
                int iN19 = hg0.n(cursorL, "generation");
                int iN20 = hg0.n(cursorL, "next_schedule_time_override");
                int iN21 = hg0.n(cursorL, "next_schedule_time_override_generation");
                int iN22 = hg0.n(cursorL, "stop_reason");
                int iN23 = hg0.n(cursorL, "required_network_type");
                int iN24 = hg0.n(cursorL, "requires_charging");
                int iN25 = hg0.n(cursorL, "requires_device_idle");
                int iN26 = hg0.n(cursorL, "requires_battery_not_low");
                int iN27 = hg0.n(cursorL, "requires_storage_not_low");
                int iN28 = hg0.n(cursorL, "trigger_content_update_delay");
                int iN29 = hg0.n(cursorL, "trigger_max_content_delay");
                int iN30 = hg0.n(cursorL, "content_uri_triggers");
                int i = iN14;
                ArrayList arrayList = new ArrayList(cursorL.getCount());
                while (cursorL.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorL.isNull(iN) ? null : cursorL.getString(iN);
                    int iU = n90.u(cursorL.getInt(iN2));
                    String string2 = cursorL.isNull(iN3) ? null : cursorL.getString(iN3);
                    String string3 = cursorL.isNull(iN4) ? null : cursorL.getString(iN4);
                    wr wrVarA = wr.a(cursorL.isNull(iN5) ? null : cursorL.getBlob(iN5));
                    wr wrVarA2 = wr.a(cursorL.isNull(iN6) ? null : cursorL.getBlob(iN6));
                    long j = cursorL.getLong(iN7);
                    long j2 = cursorL.getLong(iN8);
                    long j3 = cursorL.getLong(iN9);
                    int i2 = cursorL.getInt(iN10);
                    int iR = n90.r(cursorL.getInt(iN11));
                    long j4 = cursorL.getLong(iN12);
                    long j5 = cursorL.getLong(iN13);
                    int i3 = i;
                    long j6 = cursorL.getLong(i3);
                    int i4 = iN;
                    int i5 = iN15;
                    long j7 = cursorL.getLong(i5);
                    iN15 = i5;
                    int i6 = iN16;
                    boolean z = cursorL.getInt(i6) != 0;
                    iN16 = i6;
                    int i7 = iN17;
                    int iT = n90.t(cursorL.getInt(i7));
                    iN17 = i7;
                    int i8 = iN18;
                    int i9 = cursorL.getInt(i8);
                    iN18 = i8;
                    int i10 = iN19;
                    int i11 = cursorL.getInt(i10);
                    iN19 = i10;
                    int i12 = iN20;
                    long j8 = cursorL.getLong(i12);
                    iN20 = i12;
                    int i13 = iN21;
                    int i14 = cursorL.getInt(i13);
                    iN21 = i13;
                    int i15 = iN22;
                    int i16 = cursorL.getInt(i15);
                    iN22 = i15;
                    int i17 = iN23;
                    int iS = n90.s(cursorL.getInt(i17));
                    iN23 = i17;
                    int i18 = iN24;
                    boolean z2 = cursorL.getInt(i18) != 0;
                    iN24 = i18;
                    int i19 = iN25;
                    boolean z3 = cursorL.getInt(i19) != 0;
                    iN25 = i19;
                    int i20 = iN26;
                    boolean z4 = cursorL.getInt(i20) != 0;
                    iN26 = i20;
                    int i21 = iN27;
                    boolean z5 = cursorL.getInt(i21) != 0;
                    iN27 = i21;
                    int i22 = iN28;
                    long j9 = cursorL.getLong(i22);
                    iN28 = i22;
                    int i23 = iN29;
                    long j10 = cursorL.getLong(i23);
                    iN29 = i23;
                    int i24 = iN30;
                    if (!cursorL.isNull(i24)) {
                        blob = cursorL.getBlob(i24);
                    }
                    iN30 = i24;
                    arrayList.add(new lz1(string, iU, string2, string3, wrVarA, wrVarA2, j, j2, j3, new nn(iS, z2, z3, z4, z5, j9, j10, n90.c(blob)), i2, iR, j4, j5, j6, j7, z, iT, i9, i11, j8, i14, i16));
                    iN = i4;
                    i = i3;
                }
                cursorL.close();
                lc1Var.k();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorL.close();
                lc1Var.k();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lc1Var = lc1VarA;
        }
    }

    public final ArrayList b(int i) throws Throwable {
        lc1 lc1Var;
        lc1 lc1VarA = lc1.a(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        lc1VarA.q(1, i);
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iN = hg0.n(cursorL, "id");
            int iN2 = hg0.n(cursorL, "state");
            int iN3 = hg0.n(cursorL, "worker_class_name");
            int iN4 = hg0.n(cursorL, "input_merger_class_name");
            int iN5 = hg0.n(cursorL, "input");
            int iN6 = hg0.n(cursorL, "output");
            int iN7 = hg0.n(cursorL, "initial_delay");
            int iN8 = hg0.n(cursorL, "interval_duration");
            int iN9 = hg0.n(cursorL, "flex_duration");
            int iN10 = hg0.n(cursorL, "run_attempt_count");
            int iN11 = hg0.n(cursorL, "backoff_policy");
            int iN12 = hg0.n(cursorL, "backoff_delay_duration");
            int iN13 = hg0.n(cursorL, "last_enqueue_time");
            lc1Var = lc1VarA;
            try {
                int iN14 = hg0.n(cursorL, "minimum_retention_duration");
                int iN15 = hg0.n(cursorL, "schedule_requested_at");
                int iN16 = hg0.n(cursorL, "run_in_foreground");
                int iN17 = hg0.n(cursorL, "out_of_quota_policy");
                int iN18 = hg0.n(cursorL, "period_count");
                int iN19 = hg0.n(cursorL, "generation");
                int iN20 = hg0.n(cursorL, "next_schedule_time_override");
                int iN21 = hg0.n(cursorL, "next_schedule_time_override_generation");
                int iN22 = hg0.n(cursorL, "stop_reason");
                int iN23 = hg0.n(cursorL, "required_network_type");
                int iN24 = hg0.n(cursorL, "requires_charging");
                int iN25 = hg0.n(cursorL, "requires_device_idle");
                int iN26 = hg0.n(cursorL, "requires_battery_not_low");
                int iN27 = hg0.n(cursorL, "requires_storage_not_low");
                int iN28 = hg0.n(cursorL, "trigger_content_update_delay");
                int iN29 = hg0.n(cursorL, "trigger_max_content_delay");
                int iN30 = hg0.n(cursorL, "content_uri_triggers");
                int i2 = iN14;
                ArrayList arrayList = new ArrayList(cursorL.getCount());
                while (cursorL.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorL.isNull(iN) ? null : cursorL.getString(iN);
                    int iU = n90.u(cursorL.getInt(iN2));
                    String string2 = cursorL.isNull(iN3) ? null : cursorL.getString(iN3);
                    String string3 = cursorL.isNull(iN4) ? null : cursorL.getString(iN4);
                    wr wrVarA = wr.a(cursorL.isNull(iN5) ? null : cursorL.getBlob(iN5));
                    wr wrVarA2 = wr.a(cursorL.isNull(iN6) ? null : cursorL.getBlob(iN6));
                    long j = cursorL.getLong(iN7);
                    long j2 = cursorL.getLong(iN8);
                    long j3 = cursorL.getLong(iN9);
                    int i3 = cursorL.getInt(iN10);
                    int iR = n90.r(cursorL.getInt(iN11));
                    long j4 = cursorL.getLong(iN12);
                    long j5 = cursorL.getLong(iN13);
                    int i4 = i2;
                    long j6 = cursorL.getLong(i4);
                    int i5 = iN;
                    int i6 = iN15;
                    long j7 = cursorL.getLong(i6);
                    iN15 = i6;
                    int i7 = iN16;
                    boolean z = cursorL.getInt(i7) != 0;
                    iN16 = i7;
                    int i8 = iN17;
                    int iT = n90.t(cursorL.getInt(i8));
                    iN17 = i8;
                    int i9 = iN18;
                    int i10 = cursorL.getInt(i9);
                    iN18 = i9;
                    int i11 = iN19;
                    int i12 = cursorL.getInt(i11);
                    iN19 = i11;
                    int i13 = iN20;
                    long j8 = cursorL.getLong(i13);
                    iN20 = i13;
                    int i14 = iN21;
                    int i15 = cursorL.getInt(i14);
                    iN21 = i14;
                    int i16 = iN22;
                    int i17 = cursorL.getInt(i16);
                    iN22 = i16;
                    int i18 = iN23;
                    int iS = n90.s(cursorL.getInt(i18));
                    iN23 = i18;
                    int i19 = iN24;
                    boolean z2 = cursorL.getInt(i19) != 0;
                    iN24 = i19;
                    int i20 = iN25;
                    boolean z3 = cursorL.getInt(i20) != 0;
                    iN25 = i20;
                    int i21 = iN26;
                    boolean z4 = cursorL.getInt(i21) != 0;
                    iN26 = i21;
                    int i22 = iN27;
                    boolean z5 = cursorL.getInt(i22) != 0;
                    iN27 = i22;
                    int i23 = iN28;
                    long j9 = cursorL.getLong(i23);
                    iN28 = i23;
                    int i24 = iN29;
                    long j10 = cursorL.getLong(i24);
                    iN29 = i24;
                    int i25 = iN30;
                    if (!cursorL.isNull(i25)) {
                        blob = cursorL.getBlob(i25);
                    }
                    iN30 = i25;
                    arrayList.add(new lz1(string, iU, string2, string3, wrVarA, wrVarA2, j, j2, j3, new nn(iS, z2, z3, z4, z5, j9, j10, n90.c(blob)), i3, iR, j4, j5, j6, j7, z, iT, i10, i12, j8, i15, i17));
                    iN = i5;
                    i2 = i4;
                }
                cursorL.close();
                lc1Var.k();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorL.close();
                lc1Var.k();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lc1Var = lc1VarA;
        }
    }

    public final ArrayList c() throws Throwable {
        lc1 lc1Var;
        lc1 lc1VarA = lc1.a(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iN = hg0.n(cursorL, "id");
            int iN2 = hg0.n(cursorL, "state");
            int iN3 = hg0.n(cursorL, "worker_class_name");
            int iN4 = hg0.n(cursorL, "input_merger_class_name");
            int iN5 = hg0.n(cursorL, "input");
            int iN6 = hg0.n(cursorL, "output");
            int iN7 = hg0.n(cursorL, "initial_delay");
            int iN8 = hg0.n(cursorL, "interval_duration");
            int iN9 = hg0.n(cursorL, "flex_duration");
            int iN10 = hg0.n(cursorL, "run_attempt_count");
            int iN11 = hg0.n(cursorL, "backoff_policy");
            int iN12 = hg0.n(cursorL, "backoff_delay_duration");
            int iN13 = hg0.n(cursorL, "last_enqueue_time");
            lc1Var = lc1VarA;
            try {
                int iN14 = hg0.n(cursorL, "minimum_retention_duration");
                int iN15 = hg0.n(cursorL, "schedule_requested_at");
                int iN16 = hg0.n(cursorL, "run_in_foreground");
                int iN17 = hg0.n(cursorL, "out_of_quota_policy");
                int iN18 = hg0.n(cursorL, "period_count");
                int iN19 = hg0.n(cursorL, "generation");
                int iN20 = hg0.n(cursorL, "next_schedule_time_override");
                int iN21 = hg0.n(cursorL, "next_schedule_time_override_generation");
                int iN22 = hg0.n(cursorL, "stop_reason");
                int iN23 = hg0.n(cursorL, "required_network_type");
                int iN24 = hg0.n(cursorL, "requires_charging");
                int iN25 = hg0.n(cursorL, "requires_device_idle");
                int iN26 = hg0.n(cursorL, "requires_battery_not_low");
                int iN27 = hg0.n(cursorL, "requires_storage_not_low");
                int iN28 = hg0.n(cursorL, "trigger_content_update_delay");
                int iN29 = hg0.n(cursorL, "trigger_max_content_delay");
                int iN30 = hg0.n(cursorL, "content_uri_triggers");
                int i = iN14;
                ArrayList arrayList = new ArrayList(cursorL.getCount());
                while (cursorL.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorL.isNull(iN) ? null : cursorL.getString(iN);
                    int iU = n90.u(cursorL.getInt(iN2));
                    String string2 = cursorL.isNull(iN3) ? null : cursorL.getString(iN3);
                    String string3 = cursorL.isNull(iN4) ? null : cursorL.getString(iN4);
                    wr wrVarA = wr.a(cursorL.isNull(iN5) ? null : cursorL.getBlob(iN5));
                    wr wrVarA2 = wr.a(cursorL.isNull(iN6) ? null : cursorL.getBlob(iN6));
                    long j = cursorL.getLong(iN7);
                    long j2 = cursorL.getLong(iN8);
                    long j3 = cursorL.getLong(iN9);
                    int i2 = cursorL.getInt(iN10);
                    int iR = n90.r(cursorL.getInt(iN11));
                    long j4 = cursorL.getLong(iN12);
                    long j5 = cursorL.getLong(iN13);
                    int i3 = i;
                    long j6 = cursorL.getLong(i3);
                    int i4 = iN;
                    int i5 = iN15;
                    long j7 = cursorL.getLong(i5);
                    iN15 = i5;
                    int i6 = iN16;
                    boolean z = cursorL.getInt(i6) != 0;
                    iN16 = i6;
                    int i7 = iN17;
                    int iT = n90.t(cursorL.getInt(i7));
                    iN17 = i7;
                    int i8 = iN18;
                    int i9 = cursorL.getInt(i8);
                    iN18 = i8;
                    int i10 = iN19;
                    int i11 = cursorL.getInt(i10);
                    iN19 = i10;
                    int i12 = iN20;
                    long j8 = cursorL.getLong(i12);
                    iN20 = i12;
                    int i13 = iN21;
                    int i14 = cursorL.getInt(i13);
                    iN21 = i13;
                    int i15 = iN22;
                    int i16 = cursorL.getInt(i15);
                    iN22 = i15;
                    int i17 = iN23;
                    int iS = n90.s(cursorL.getInt(i17));
                    iN23 = i17;
                    int i18 = iN24;
                    boolean z2 = cursorL.getInt(i18) != 0;
                    iN24 = i18;
                    int i19 = iN25;
                    boolean z3 = cursorL.getInt(i19) != 0;
                    iN25 = i19;
                    int i20 = iN26;
                    boolean z4 = cursorL.getInt(i20) != 0;
                    iN26 = i20;
                    int i21 = iN27;
                    boolean z5 = cursorL.getInt(i21) != 0;
                    iN27 = i21;
                    int i22 = iN28;
                    long j9 = cursorL.getLong(i22);
                    iN28 = i22;
                    int i23 = iN29;
                    long j10 = cursorL.getLong(i23);
                    iN29 = i23;
                    int i24 = iN30;
                    if (!cursorL.isNull(i24)) {
                        blob = cursorL.getBlob(i24);
                    }
                    iN30 = i24;
                    arrayList.add(new lz1(string, iU, string2, string3, wrVarA, wrVarA2, j, j2, j3, new nn(iS, z2, z3, z4, z5, j9, j10, n90.c(blob)), i2, iR, j4, j5, j6, j7, z, iT, i9, i11, j8, i14, i16));
                    iN = i4;
                    i = i3;
                }
                cursorL.close();
                lc1Var.k();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorL.close();
                lc1Var.k();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lc1Var = lc1VarA;
        }
    }

    public final ArrayList d() throws Throwable {
        lc1 lc1Var;
        lc1 lc1VarA = lc1.a(0, "SELECT * FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iN = hg0.n(cursorL, "id");
            int iN2 = hg0.n(cursorL, "state");
            int iN3 = hg0.n(cursorL, "worker_class_name");
            int iN4 = hg0.n(cursorL, "input_merger_class_name");
            int iN5 = hg0.n(cursorL, "input");
            int iN6 = hg0.n(cursorL, "output");
            int iN7 = hg0.n(cursorL, "initial_delay");
            int iN8 = hg0.n(cursorL, "interval_duration");
            int iN9 = hg0.n(cursorL, "flex_duration");
            int iN10 = hg0.n(cursorL, "run_attempt_count");
            int iN11 = hg0.n(cursorL, "backoff_policy");
            int iN12 = hg0.n(cursorL, "backoff_delay_duration");
            int iN13 = hg0.n(cursorL, "last_enqueue_time");
            lc1Var = lc1VarA;
            try {
                int iN14 = hg0.n(cursorL, "minimum_retention_duration");
                int iN15 = hg0.n(cursorL, "schedule_requested_at");
                int iN16 = hg0.n(cursorL, "run_in_foreground");
                int iN17 = hg0.n(cursorL, "out_of_quota_policy");
                int iN18 = hg0.n(cursorL, "period_count");
                int iN19 = hg0.n(cursorL, "generation");
                int iN20 = hg0.n(cursorL, "next_schedule_time_override");
                int iN21 = hg0.n(cursorL, "next_schedule_time_override_generation");
                int iN22 = hg0.n(cursorL, "stop_reason");
                int iN23 = hg0.n(cursorL, "required_network_type");
                int iN24 = hg0.n(cursorL, "requires_charging");
                int iN25 = hg0.n(cursorL, "requires_device_idle");
                int iN26 = hg0.n(cursorL, "requires_battery_not_low");
                int iN27 = hg0.n(cursorL, "requires_storage_not_low");
                int iN28 = hg0.n(cursorL, "trigger_content_update_delay");
                int iN29 = hg0.n(cursorL, "trigger_max_content_delay");
                int iN30 = hg0.n(cursorL, "content_uri_triggers");
                int i = iN14;
                ArrayList arrayList = new ArrayList(cursorL.getCount());
                while (cursorL.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorL.isNull(iN) ? null : cursorL.getString(iN);
                    int iU = n90.u(cursorL.getInt(iN2));
                    String string2 = cursorL.isNull(iN3) ? null : cursorL.getString(iN3);
                    String string3 = cursorL.isNull(iN4) ? null : cursorL.getString(iN4);
                    wr wrVarA = wr.a(cursorL.isNull(iN5) ? null : cursorL.getBlob(iN5));
                    wr wrVarA2 = wr.a(cursorL.isNull(iN6) ? null : cursorL.getBlob(iN6));
                    long j = cursorL.getLong(iN7);
                    long j2 = cursorL.getLong(iN8);
                    long j3 = cursorL.getLong(iN9);
                    int i2 = cursorL.getInt(iN10);
                    int iR = n90.r(cursorL.getInt(iN11));
                    long j4 = cursorL.getLong(iN12);
                    long j5 = cursorL.getLong(iN13);
                    int i3 = i;
                    long j6 = cursorL.getLong(i3);
                    int i4 = iN;
                    int i5 = iN15;
                    long j7 = cursorL.getLong(i5);
                    iN15 = i5;
                    int i6 = iN16;
                    boolean z = cursorL.getInt(i6) != 0;
                    iN16 = i6;
                    int i7 = iN17;
                    int iT = n90.t(cursorL.getInt(i7));
                    iN17 = i7;
                    int i8 = iN18;
                    int i9 = cursorL.getInt(i8);
                    iN18 = i8;
                    int i10 = iN19;
                    int i11 = cursorL.getInt(i10);
                    iN19 = i10;
                    int i12 = iN20;
                    long j8 = cursorL.getLong(i12);
                    iN20 = i12;
                    int i13 = iN21;
                    int i14 = cursorL.getInt(i13);
                    iN21 = i13;
                    int i15 = iN22;
                    int i16 = cursorL.getInt(i15);
                    iN22 = i15;
                    int i17 = iN23;
                    int iS = n90.s(cursorL.getInt(i17));
                    iN23 = i17;
                    int i18 = iN24;
                    boolean z2 = cursorL.getInt(i18) != 0;
                    iN24 = i18;
                    int i19 = iN25;
                    boolean z3 = cursorL.getInt(i19) != 0;
                    iN25 = i19;
                    int i20 = iN26;
                    boolean z4 = cursorL.getInt(i20) != 0;
                    iN26 = i20;
                    int i21 = iN27;
                    boolean z5 = cursorL.getInt(i21) != 0;
                    iN27 = i21;
                    int i22 = iN28;
                    long j9 = cursorL.getLong(i22);
                    iN28 = i22;
                    int i23 = iN29;
                    long j10 = cursorL.getLong(i23);
                    iN29 = i23;
                    int i24 = iN30;
                    if (!cursorL.isNull(i24)) {
                        blob = cursorL.getBlob(i24);
                    }
                    iN30 = i24;
                    arrayList.add(new lz1(string, iU, string2, string3, wrVarA, wrVarA2, j, j2, j3, new nn(iS, z2, z3, z4, z5, j9, j10, n90.c(blob)), i2, iR, j4, j5, j6, j7, z, iT, i9, i11, j8, i14, i16));
                    iN = i4;
                    i = i3;
                }
                cursorL.close();
                lc1Var.k();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorL.close();
                lc1Var.k();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lc1Var = lc1VarA;
        }
    }

    public final ArrayList e() {
        lc1 lc1Var;
        lc1 lc1VarA = lc1.a(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iN = hg0.n(cursorL, "id");
            int iN2 = hg0.n(cursorL, "state");
            int iN3 = hg0.n(cursorL, "worker_class_name");
            int iN4 = hg0.n(cursorL, "input_merger_class_name");
            int iN5 = hg0.n(cursorL, "input");
            int iN6 = hg0.n(cursorL, "output");
            int iN7 = hg0.n(cursorL, "initial_delay");
            int iN8 = hg0.n(cursorL, "interval_duration");
            int iN9 = hg0.n(cursorL, "flex_duration");
            int iN10 = hg0.n(cursorL, "run_attempt_count");
            int iN11 = hg0.n(cursorL, "backoff_policy");
            int iN12 = hg0.n(cursorL, "backoff_delay_duration");
            int iN13 = hg0.n(cursorL, "last_enqueue_time");
            lc1Var = lc1VarA;
            try {
                int iN14 = hg0.n(cursorL, "minimum_retention_duration");
                int iN15 = hg0.n(cursorL, "schedule_requested_at");
                int iN16 = hg0.n(cursorL, "run_in_foreground");
                int iN17 = hg0.n(cursorL, "out_of_quota_policy");
                int iN18 = hg0.n(cursorL, "period_count");
                int iN19 = hg0.n(cursorL, "generation");
                int iN20 = hg0.n(cursorL, "next_schedule_time_override");
                int iN21 = hg0.n(cursorL, "next_schedule_time_override_generation");
                int iN22 = hg0.n(cursorL, "stop_reason");
                int iN23 = hg0.n(cursorL, "required_network_type");
                int iN24 = hg0.n(cursorL, "requires_charging");
                int iN25 = hg0.n(cursorL, "requires_device_idle");
                int iN26 = hg0.n(cursorL, "requires_battery_not_low");
                int iN27 = hg0.n(cursorL, "requires_storage_not_low");
                int iN28 = hg0.n(cursorL, "trigger_content_update_delay");
                int iN29 = hg0.n(cursorL, "trigger_max_content_delay");
                int iN30 = hg0.n(cursorL, "content_uri_triggers");
                int i = iN14;
                ArrayList arrayList = new ArrayList(cursorL.getCount());
                while (cursorL.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorL.isNull(iN) ? null : cursorL.getString(iN);
                    int iU = n90.u(cursorL.getInt(iN2));
                    String string2 = cursorL.isNull(iN3) ? null : cursorL.getString(iN3);
                    String string3 = cursorL.isNull(iN4) ? null : cursorL.getString(iN4);
                    wr wrVarA = wr.a(cursorL.isNull(iN5) ? null : cursorL.getBlob(iN5));
                    wr wrVarA2 = wr.a(cursorL.isNull(iN6) ? null : cursorL.getBlob(iN6));
                    long j = cursorL.getLong(iN7);
                    long j2 = cursorL.getLong(iN8);
                    long j3 = cursorL.getLong(iN9);
                    int i2 = cursorL.getInt(iN10);
                    int iR = n90.r(cursorL.getInt(iN11));
                    long j4 = cursorL.getLong(iN12);
                    long j5 = cursorL.getLong(iN13);
                    int i3 = i;
                    long j6 = cursorL.getLong(i3);
                    int i4 = iN;
                    int i5 = iN15;
                    long j7 = cursorL.getLong(i5);
                    iN15 = i5;
                    int i6 = iN16;
                    boolean z = cursorL.getInt(i6) != 0;
                    iN16 = i6;
                    int i7 = iN17;
                    int iT = n90.t(cursorL.getInt(i7));
                    iN17 = i7;
                    int i8 = iN18;
                    int i9 = cursorL.getInt(i8);
                    iN18 = i8;
                    int i10 = iN19;
                    int i11 = cursorL.getInt(i10);
                    iN19 = i10;
                    int i12 = iN20;
                    long j8 = cursorL.getLong(i12);
                    iN20 = i12;
                    int i13 = iN21;
                    int i14 = cursorL.getInt(i13);
                    iN21 = i13;
                    int i15 = iN22;
                    int i16 = cursorL.getInt(i15);
                    iN22 = i15;
                    int i17 = iN23;
                    int iS = n90.s(cursorL.getInt(i17));
                    iN23 = i17;
                    int i18 = iN24;
                    boolean z2 = cursorL.getInt(i18) != 0;
                    iN24 = i18;
                    int i19 = iN25;
                    boolean z3 = cursorL.getInt(i19) != 0;
                    iN25 = i19;
                    int i20 = iN26;
                    boolean z4 = cursorL.getInt(i20) != 0;
                    iN26 = i20;
                    int i21 = iN27;
                    boolean z5 = cursorL.getInt(i21) != 0;
                    iN27 = i21;
                    int i22 = iN28;
                    long j9 = cursorL.getLong(i22);
                    iN28 = i22;
                    int i23 = iN29;
                    long j10 = cursorL.getLong(i23);
                    iN29 = i23;
                    int i24 = iN30;
                    if (!cursorL.isNull(i24)) {
                        blob = cursorL.getBlob(i24);
                    }
                    iN30 = i24;
                    arrayList.add(new lz1(string, iU, string2, string3, wrVarA, wrVarA2, j, j2, j3, new nn(iS, z2, z3, z4, z5, j9, j10, n90.c(blob)), i2, iR, j4, j5, j6, j7, z, iT, i9, i11, j8, i14, i16));
                    iN = i4;
                    i = i3;
                }
                cursorL.close();
                lc1Var.k();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorL.close();
                lc1Var.k();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lc1Var = lc1VarA;
        }
    }

    public final int f(String str) {
        lc1 lc1VarA = lc1.a(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            lc1VarA.g(1);
        } else {
            lc1VarA.e(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iU = 0;
            if (cursorL.moveToFirst()) {
                Integer numValueOf = cursorL.isNull(0) ? null : Integer.valueOf(cursorL.getInt(0));
                if (numValueOf != null) {
                    iU = n90.u(numValueOf.intValue());
                }
            }
            return iU;
        } finally {
            cursorL.close();
            lc1VarA.k();
        }
    }

    public final ArrayList g() {
        lc1 lc1VarA = lc1.a(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        lc1VarA.g(1);
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            ArrayList arrayList = new ArrayList(cursorL.getCount());
            while (cursorL.moveToNext()) {
                arrayList.add(cursorL.isNull(0) ? null : cursorL.getString(0));
            }
            return arrayList;
        } finally {
            cursorL.close();
            lc1VarA.k();
        }
    }

    public final ArrayList h() {
        lc1 lc1VarA = lc1.a(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
        lc1VarA.e(1, "offline_ping_sender_work");
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            ArrayList arrayList = new ArrayList(cursorL.getCount());
            while (cursorL.moveToNext()) {
                arrayList.add(cursorL.isNull(0) ? null : cursorL.getString(0));
            }
            return arrayList;
        } finally {
            cursorL.close();
            lc1VarA.k();
        }
    }

    public final lz1 i(String str) throws Throwable {
        lc1 lc1Var;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        lc1 lc1VarA = lc1.a(1, "SELECT * FROM workspec WHERE id=?");
        if (str == null) {
            lc1VarA.g(1);
        } else {
            lc1VarA.e(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            iN = hg0.n(cursorL, "id");
            iN2 = hg0.n(cursorL, "state");
            iN3 = hg0.n(cursorL, "worker_class_name");
            iN4 = hg0.n(cursorL, "input_merger_class_name");
            iN5 = hg0.n(cursorL, "input");
            iN6 = hg0.n(cursorL, "output");
            iN7 = hg0.n(cursorL, "initial_delay");
            iN8 = hg0.n(cursorL, "interval_duration");
            iN9 = hg0.n(cursorL, "flex_duration");
            iN10 = hg0.n(cursorL, "run_attempt_count");
            iN11 = hg0.n(cursorL, "backoff_policy");
            iN12 = hg0.n(cursorL, "backoff_delay_duration");
            iN13 = hg0.n(cursorL, "last_enqueue_time");
            lc1Var = lc1VarA;
        } catch (Throwable th) {
            th = th;
            lc1Var = lc1VarA;
        }
        try {
            int iN14 = hg0.n(cursorL, "minimum_retention_duration");
            int iN15 = hg0.n(cursorL, "schedule_requested_at");
            int iN16 = hg0.n(cursorL, "run_in_foreground");
            int iN17 = hg0.n(cursorL, "out_of_quota_policy");
            int iN18 = hg0.n(cursorL, "period_count");
            int iN19 = hg0.n(cursorL, "generation");
            int iN20 = hg0.n(cursorL, "next_schedule_time_override");
            int iN21 = hg0.n(cursorL, "next_schedule_time_override_generation");
            int iN22 = hg0.n(cursorL, "stop_reason");
            int iN23 = hg0.n(cursorL, "required_network_type");
            int iN24 = hg0.n(cursorL, "requires_charging");
            int iN25 = hg0.n(cursorL, "requires_device_idle");
            int iN26 = hg0.n(cursorL, "requires_battery_not_low");
            int iN27 = hg0.n(cursorL, "requires_storage_not_low");
            int iN28 = hg0.n(cursorL, "trigger_content_update_delay");
            int iN29 = hg0.n(cursorL, "trigger_max_content_delay");
            int iN30 = hg0.n(cursorL, "content_uri_triggers");
            lz1 lz1Var = null;
            byte[] blob = null;
            if (cursorL.moveToFirst()) {
                String string = cursorL.isNull(iN) ? null : cursorL.getString(iN);
                int iU = n90.u(cursorL.getInt(iN2));
                String string2 = cursorL.isNull(iN3) ? null : cursorL.getString(iN3);
                String string3 = cursorL.isNull(iN4) ? null : cursorL.getString(iN4);
                wr wrVarA = wr.a(cursorL.isNull(iN5) ? null : cursorL.getBlob(iN5));
                wr wrVarA2 = wr.a(cursorL.isNull(iN6) ? null : cursorL.getBlob(iN6));
                long j = cursorL.getLong(iN7);
                long j2 = cursorL.getLong(iN8);
                long j3 = cursorL.getLong(iN9);
                int i = cursorL.getInt(iN10);
                int iR = n90.r(cursorL.getInt(iN11));
                long j4 = cursorL.getLong(iN12);
                long j5 = cursorL.getLong(iN13);
                long j6 = cursorL.getLong(iN14);
                long j7 = cursorL.getLong(iN15);
                boolean z = cursorL.getInt(iN16) != 0;
                int iT = n90.t(cursorL.getInt(iN17));
                int i2 = cursorL.getInt(iN18);
                int i3 = cursorL.getInt(iN19);
                long j8 = cursorL.getLong(iN20);
                int i4 = cursorL.getInt(iN21);
                int i5 = cursorL.getInt(iN22);
                int iS = n90.s(cursorL.getInt(iN23));
                boolean z2 = cursorL.getInt(iN24) != 0;
                boolean z3 = cursorL.getInt(iN25) != 0;
                boolean z4 = cursorL.getInt(iN26) != 0;
                boolean z5 = cursorL.getInt(iN27) != 0;
                long j9 = cursorL.getLong(iN28);
                long j10 = cursorL.getLong(iN29);
                if (!cursorL.isNull(iN30)) {
                    blob = cursorL.getBlob(iN30);
                }
                lz1Var = new lz1(string, iU, string2, string3, wrVarA, wrVarA2, j, j2, j3, new nn(iS, z2, z3, z4, z5, j9, j10, n90.c(blob)), i, iR, j4, j5, j6, j7, z, iT, i2, i3, j8, i4, i5);
            }
            cursorL.close();
            lc1Var.k();
            return lz1Var;
        } catch (Throwable th2) {
            th = th2;
            cursorL.close();
            lc1Var.k();
            throw th;
        }
    }

    public final void j(String str, long j) {
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        pm0 pm0Var = this.l;
        z60 z60VarA = pm0Var.a();
        z60VarA.q(1, j);
        if (str == null) {
            z60VarA.g(2);
        } else {
            z60VarA.e(2, str);
        }
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }

    public final void k(int i, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        pm0 pm0Var = this.k;
        z60 z60VarA = pm0Var.a();
        if (str == null) {
            z60VarA.g(1);
        } else {
            z60VarA.e(1, str);
        }
        z60VarA.q(2, i);
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }

    public final void l(String str, long j) {
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        pm0 pm0Var = this.h;
        z60 z60VarA = pm0Var.a();
        z60VarA.q(1, j);
        if (str == null) {
            z60VarA.g(2);
        } else {
            z60VarA.e(2, str);
        }
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }

    public final void m(String str, wr wrVar) throws Throwable {
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        pm0 pm0Var = this.g;
        z60 z60VarA = pm0Var.a();
        byte[] bArrC = wr.c(wrVar);
        if (bArrC == null) {
            z60VarA.g(1);
        } else {
            z60VarA.s(1, bArrC);
        }
        if (str == null) {
            z60VarA.g(2);
        } else {
            z60VarA.e(2, str);
        }
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }

    public final void n(int i, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        pm0 pm0Var = this.d;
        z60 z60VarA = pm0Var.a();
        z60VarA.q(1, n90.C(i));
        if (str == null) {
            z60VarA.g(2);
        } else {
            z60VarA.e(2, str);
        }
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }

    public final void o(int i, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.a;
        workDatabase_Impl.b();
        pm0 pm0Var = this.n;
        z60 z60VarA = pm0Var.a();
        z60VarA.q(1, i);
        if (str == null) {
            z60VarA.g(2);
        } else {
            z60VarA.e(2, str);
        }
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }
}
