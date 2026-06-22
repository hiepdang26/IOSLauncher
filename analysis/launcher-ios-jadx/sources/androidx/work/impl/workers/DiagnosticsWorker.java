package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import defpackage.av;
import defpackage.cz1;
import defpackage.fz1;
import defpackage.go0;
import defpackage.hg0;
import defpackage.ho0;
import defpackage.ka0;
import defpackage.lc1;
import defpackage.lz1;
import defpackage.mz1;
import defpackage.n90;
import defpackage.nn;
import defpackage.ol1;
import defpackage.oz1;
import defpackage.qg0;
import defpackage.wr;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        qg0.l(context, "context");
        qg0.l(workerParameters, "parameters");
    }

    @Override // androidx.work.Worker
    public final ho0 doWork() throws Throwable {
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
        ol1 ol1Var;
        fz1 fz1Var;
        oz1 oz1Var;
        cz1 cz1VarO = cz1.O(getApplicationContext());
        WorkDatabase workDatabase = cz1VarO.j;
        qg0.k(workDatabase, "workManager.workDatabase");
        mz1 mz1VarU = workDatabase.u();
        fz1 fz1VarS = workDatabase.s();
        oz1 oz1VarV = workDatabase.v();
        ol1 ol1VarR = workDatabase.r();
        cz1VarO.i.c.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        mz1VarU.getClass();
        lc1 lc1VarA = lc1.a(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        lc1VarA.q(1, jCurrentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = mz1VarU.a;
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
            lc1Var = lc1VarA;
        } catch (Throwable th) {
            th = th;
            lc1Var = lc1VarA;
        }
        try {
            int iN12 = hg0.n(cursorL, "backoff_delay_duration");
            int iN13 = hg0.n(cursorL, "last_enqueue_time");
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
            ArrayList arrayListD = mz1VarU.d();
            ArrayList arrayListA = mz1VarU.a();
            if (arrayList.isEmpty()) {
                ol1Var = ol1VarR;
                fz1Var = fz1VarS;
                oz1Var = oz1VarV;
            } else {
                ka0 ka0VarJ = ka0.j();
                int i25 = av.a;
                ka0VarJ.getClass();
                ka0 ka0VarJ2 = ka0.j();
                ol1Var = ol1VarR;
                fz1Var = fz1VarS;
                oz1Var = oz1VarV;
                av.a(fz1Var, oz1Var, ol1Var, arrayList);
                ka0VarJ2.getClass();
            }
            if (!arrayListD.isEmpty()) {
                ka0 ka0VarJ3 = ka0.j();
                int i26 = av.a;
                ka0VarJ3.getClass();
                ka0 ka0VarJ4 = ka0.j();
                av.a(fz1Var, oz1Var, ol1Var, arrayListD);
                ka0VarJ4.getClass();
            }
            if (!arrayListA.isEmpty()) {
                ka0 ka0VarJ5 = ka0.j();
                int i27 = av.a;
                ka0VarJ5.getClass();
                ka0 ka0VarJ6 = ka0.j();
                av.a(fz1Var, oz1Var, ol1Var, arrayListA);
                ka0VarJ6.getClass();
            }
            return new go0(wr.b);
        } catch (Throwable th2) {
            th = th2;
            cursorL.close();
            lc1Var.k();
            throw th;
        }
    }
}
