package defpackage;

import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.internal.ads.zzazx;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbxa;
import com.google.android.gms.internal.ads.zzdsf;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.UninstallDropTarget;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ng implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;

    public /* synthetic */ ng(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.g = i;
        this.k = obj;
        this.h = obj2;
        this.i = obj3;
        this.j = obj4;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x0010, B:30:0x0081, B:13:0x003a, B:16:0x0044, B:17:0x004d, B:22:0x0060, B:24:0x0068, B:25:0x0070, B:27:0x0074, B:29:0x007a), top: B:34:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.h
            android.content.ContentResolver r0 = (android.content.ContentResolver) r0
            android.net.Uri r1 = defpackage.wl0.a
            java.lang.Object r2 = r7.i
            android.content.ContentValues r2 = (android.content.ContentValues) r2
            r0.insert(r1, r2)
            java.lang.Object r0 = defpackage.rl0.A
            monitor-enter(r0)
            java.lang.Object r1 = r7.j     // Catch: java.lang.Throwable -> L42
            qh0 r1 = (defpackage.qh0) r1     // Catch: java.lang.Throwable -> L42
            long r2 = r1.g     // Catch: java.lang.Throwable -> L42
            java.lang.Object r4 = r7.k     // Catch: java.lang.Throwable -> L42
            java.lang.StackTraceElement[] r4 = (java.lang.StackTraceElement[]) r4     // Catch: java.lang.Throwable -> L42
            defpackage.rl0.d(r2, r1, r4)     // Catch: java.lang.Throwable -> L42
            wp0 r1 = defpackage.rl0.B     // Catch: java.lang.Throwable -> L42
            java.lang.Object r2 = r7.j     // Catch: java.lang.Throwable -> L42
            qh0 r2 = (defpackage.qh0) r2     // Catch: java.lang.Throwable -> L42
            long r3 = r2.g     // Catch: java.lang.Throwable -> L42
            r1.put(r3, r2)     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r7.j     // Catch: java.lang.Throwable -> L42
            qh0 r1 = (defpackage.qh0) r1     // Catch: java.lang.Throwable -> L42
            int r2 = r1.h     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L4d
            r3 = 1
            if (r2 == r3) goto L4d
            r3 = 2
            if (r2 == r3) goto L44
            r3 = 4
            if (r2 == r3) goto L3a
            goto L81
        L3a:
            java.util.ArrayList r2 = defpackage.rl0.D     // Catch: java.lang.Throwable -> L42
            qk0 r1 = (defpackage.qk0) r1     // Catch: java.lang.Throwable -> L42
            r2.add(r1)     // Catch: java.lang.Throwable -> L42
            goto L81
        L42:
            r1 = move-exception
            goto L83
        L44:
            wp0 r2 = defpackage.rl0.E     // Catch: java.lang.Throwable -> L42
            long r3 = r1.g     // Catch: java.lang.Throwable -> L42
            w40 r1 = (defpackage.w40) r1     // Catch: java.lang.Throwable -> L42
            r2.put(r3, r1)     // Catch: java.lang.Throwable -> L42
        L4d:
            java.lang.Object r1 = r7.j     // Catch: java.lang.Throwable -> L42
            qh0 r1 = (defpackage.qh0) r1     // Catch: java.lang.Throwable -> L42
            long r2 = r1.i     // Catch: java.lang.Throwable -> L42
            r4 = -100
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L70
            r4 = -101(0xffffffffffffff9b, double:NaN)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L60
            goto L70
        L60:
            wp0 r1 = defpackage.rl0.E     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.b(r2)     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L81
            java.lang.Object r1 = r7.j     // Catch: java.lang.Throwable -> L42
            qh0 r1 = (defpackage.qh0) r1     // Catch: java.lang.Throwable -> L42
            java.util.Objects.toString(r1)     // Catch: java.lang.Throwable -> L42
            goto L81
        L70:
            java.util.ArrayList r2 = defpackage.rl0.C     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L81
            boolean r1 = r2.contains(r1)     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L81
            java.lang.Object r1 = r7.j     // Catch: java.lang.Throwable -> L42
            qh0 r1 = (defpackage.qh0) r1     // Catch: java.lang.Throwable -> L42
            r2.add(r1)     // Catch: java.lang.Throwable -> L42
        L81:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            return
        L83:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ng.a():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                og ogVar = (og) this.h;
                if (ogVar != null) {
                    mc1 mc1Var = (mc1) this.k;
                    ((pg) mc1Var.h).G = true;
                    ogVar.b.c(false);
                    ((pg) mc1Var.h).G = false;
                }
                MenuItem menuItem = (MenuItem) this.i;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    ((gt0) this.j).q(menuItem, null, 4);
                    return;
                }
                return;
            case 1:
                ((t) this.k).bindWorkspaceComponentsRemoved((HashSet) this.h, (HashSet) this.i, (jq1) this.j);
                return;
            case 2:
                ((View) this.h).setVisibility(8);
                bl0 bl0Var = (bl0) this.k;
                bl0Var.g.getSharedPrefs().edit().putBoolean((String) this.i, true).apply();
                bl0Var.i = false;
                o1 o1Var = (o1) this.j;
                if (o1Var != null) {
                    o1Var.run();
                    return;
                }
                return;
            case 3:
                hl0 hl0VarL = ((rl0) this.k).l();
                if (hl0VarL == null || ((hl0) this.h) != hl0VarL) {
                    return;
                }
                hl0VarL.bindShortcutsChanged((ArrayList) this.i, new ArrayList(), (jq1) this.j);
                return;
            case 4:
                int i = 0;
                ng ngVar = (ng) this.k;
                hl0 hl0VarL2 = ((rl0) ngVar.k).l();
                hl0 hl0Var = (hl0) ngVar.j;
                if (hl0Var != hl0VarL2 || hl0VarL2 == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = (ArrayList) this.h;
                if (!arrayList3.isEmpty()) {
                    long j = ((qh0) arrayList3.get(arrayList3.size() - 1)).j;
                    int size = arrayList3.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList3.get(i2);
                        i2++;
                        qh0 qh0Var = (qh0) obj;
                        if (qh0Var.j == j) {
                            arrayList.add(qh0Var);
                        } else {
                            arrayList2.add(qh0Var);
                        }
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = (ArrayList) this.i;
                int size2 = arrayList5.size();
                while (i < size2) {
                    Object obj2 = arrayList5.get(i);
                    i++;
                    qh0 qh0Var2 = (qh0) obj2;
                    if (qh0Var2 instanceof v6) {
                        arrayList4.add((v6) qh0Var2);
                    }
                }
                hl0Var.bindAppsAdded((ArrayList) this.j, arrayList2, arrayList, arrayList4);
                return;
            case 5:
                try {
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    ArrayList arrayList8 = new ArrayList((ArrayList) this.h);
                    ArrayList arrayListR = rl0.r((Context) this.i);
                    synchronized (rl0.A) {
                        try {
                            int size3 = arrayList8.size();
                            int i3 = 0;
                            while (i3 < size3) {
                                Object obj3 = arrayList8.get(i3);
                                i3++;
                                qh0 qh0VarI = (qh0) obj3;
                                if (rl0.G == null || qh0VarI == null || qh0VarI.b() == null || qh0VarI.b().getComponent() == null || !rl0.G.contains(qh0VarI.b().getComponent().flattenToString())) {
                                    if (qh0VarI != null) {
                                        rl0 rl0Var = (rl0) this.k;
                                        Intent intentB = qh0VarI.b();
                                        jq1 jq1Var = qh0VarI.w;
                                        rl0Var.getClass();
                                        if (rl0.z(intentB, jq1Var)) {
                                        }
                                    }
                                    rl0 rl0Var2 = (rl0) this.k;
                                    Context context = (Context) this.i;
                                    rl0Var2.getClass();
                                    Pair pairJ = rl0.j(context, arrayListR, arrayList7);
                                    long jLongValue = ((Long) pairJ.first).longValue();
                                    int[] iArr = (int[]) pairJ.second;
                                    if (!(qh0VarI instanceof og1) && !(qh0VarI instanceof w40)) {
                                        if (!(qh0VarI instanceof v6)) {
                                            throw new RuntimeException("Unexpected info type");
                                        }
                                        qh0VarI = ((v6) qh0VarI).i();
                                    }
                                    qh0 qh0Var3 = qh0VarI;
                                    rl0.b((Context) this.i, qh0Var3, -100L, jLongValue, iArr[0], iArr[1]);
                                    arrayList6.add(qh0Var3);
                                }
                            }
                        } finally {
                        }
                    }
                    rl0 rl0Var3 = (rl0) this.k;
                    Context context2 = (Context) this.i;
                    rl0Var3.getClass();
                    rl0.G(context2, arrayListR);
                    if (arrayList6.isEmpty()) {
                        return;
                    }
                    ((rl0) this.k).x(new ng(this, arrayList6, arrayList8, arrayList7, 4));
                    return;
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            case 6:
                ArrayList<ContentProviderOperation> arrayList9 = new ArrayList<>();
                ArrayList arrayList10 = (ArrayList) this.h;
                int size4 = arrayList10.size();
                while (i < size4) {
                    qh0 qh0Var4 = (qh0) arrayList10.get(i);
                    long j2 = qh0Var4.g;
                    arrayList9.add(ContentProviderOperation.newUpdate(wl0.a(j2)).withValues((ContentValues) ((ArrayList) this.i).get(i)).build());
                    rl0.D(j2, qh0Var4, (StackTraceElement[]) this.j);
                    i++;
                }
                try {
                    ((ContentResolver) this.k).applyBatch("com.luutinhit.launcherios.settings", arrayList9);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 7:
                a();
                return;
            case 8:
                ql0 ql0Var = (ql0) this.k;
                hl0 hl0VarL3 = ql0Var.p.l();
                hl0 hl0Var2 = (hl0) this.h;
                if (hl0Var2 != hl0VarL3 || hl0VarL3 == null) {
                    return;
                }
                hl0Var2.bindShortcutsChanged((ArrayList) this.i, (ArrayList) this.j, ql0Var.o);
                return;
            case 9:
                ql0 ql0Var2 = (ql0) this.k;
                hl0 hl0VarL4 = ql0Var2.p.l();
                hl0 hl0Var3 = (hl0) this.h;
                if (hl0Var3 != hl0VarL4 || hl0VarL4 == null) {
                    return;
                }
                hl0Var3.bindWorkspaceComponentsRemoved((HashSet) this.i, (HashSet) this.j, ql0Var2.o);
                return;
            case 10:
                boolean z = (qg0.t(((UninstallDropTarget) this.k).getContext()).r(((ComponentName) ((Pair) this.h).first).getPackageName(), (jq1) this.i).size() > 0 ? 1 : 0) ^ 1;
                xw xwVar = ((nx) this.j).h;
                int i4 = UninstallDropTarget.t;
                if (xwVar instanceof yp1) {
                    ((yp1) xwVar).o(z);
                    return;
                }
                return;
            case 11:
                nf1 nf1Var = (nf1) this.j;
                UUID uuid = (UUID) this.h;
                String string = uuid.toString();
                ka0 ka0VarJ = ka0.j();
                int i5 = iz1.c;
                Objects.toString(uuid);
                wr wrVar = (wr) this.i;
                Objects.toString(wrVar);
                ka0VarJ.getClass();
                iz1 iz1Var = (iz1) this.k;
                WorkDatabase workDatabase = iz1Var.a;
                WorkDatabase workDatabase2 = iz1Var.a;
                workDatabase.c();
                try {
                    lz1 lz1VarI = workDatabase2.u().i(string);
                    if (lz1VarI == null) {
                        throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    if (lz1VarI.b == 2) {
                        gz1 gz1Var = new gz1(string, wrVar);
                        hz1 hz1VarT = workDatabase2.t();
                        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) hz1VarT.a;
                        workDatabase_Impl.b();
                        workDatabase_Impl.c();
                        try {
                            ((su) hz1VarT.b).f(gz1Var);
                            workDatabase_Impl.n();
                            workDatabase_Impl.j();
                        } catch (Throwable th2) {
                            workDatabase_Impl.j();
                            throw th2;
                        }
                    } else {
                        ka0.j().getClass();
                    }
                    nf1Var.i(null);
                    workDatabase2.n();
                } finally {
                    try {
                    } finally {
                    }
                    break;
                }
                return;
            case 12:
                DragLayer dragLayer = ((Workspace) this.k).S0.getDragLayer();
                if (dragLayer != null) {
                    dragLayer.addResizeFrame((qh0) this.h, (pk0) this.i, (CellLayout) this.j);
                    return;
                }
                return;
            case 13:
                Context context3 = (Context) this.h;
                try {
                    new zzblr(context3, (String) this.i).zza(((s2) this.j).a, (pg0) this.k);
                    return;
                } catch (IllegalStateException e2) {
                    zzbtq.zza(context3).zzh(e2, "InterstitialAd.load");
                    return;
                }
            case 14:
                Context context4 = (Context) this.h;
                try {
                    new zzazx(context4, (String) this.i, ((s2) this.j).a, 3, (b7) this.k).zza();
                    return;
                } catch (IllegalStateException e3) {
                    zzbtq.zza(context4).zzh(e3, "AppOpenAd.load");
                    return;
                }
            case 15:
                Context context5 = (Context) this.h;
                try {
                    new zzbxa(context5, (String) this.i).zza(((s2) this.j).a, (gc1) this.k);
                    return;
                } catch (IllegalStateException e4) {
                    zzbtq.zza(context5).zzh(e4, "RewardedInterstitialAd.load");
                    return;
                }
            case 16:
                Context context6 = (Context) this.h;
                try {
                    new zzbwp(context6, (String) this.i).zza(((s2) this.j).a, (ec1) this.k);
                    return;
                } catch (IllegalStateException e5) {
                    zzbtq.zza(context6).zzh(e5, "RewardedAd.load");
                    return;
                }
            default:
                vb2 vb2Var = (vb2) this.h;
                zzdsf zzdsfVar = (zzdsf) this.i;
                vb2Var.f(zzdsfVar, (ArrayDeque) this.j, "to");
                vb2Var.f(zzdsfVar, (ArrayDeque) this.k, "of");
                return;
        }
    }

    public /* synthetic */ ng(Object obj, Object obj2, Object obj3, Object obj4, int i, boolean z) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
        this.k = obj4;
    }
}
