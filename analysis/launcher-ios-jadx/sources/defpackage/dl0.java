package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Rect;
import android.os.DeadObjectException;
import android.os.TransactionTooLargeException;
import android.util.LongSparseArray;
import androidx.lifecycle.a;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class dl0 implements Runnable {
    public final /* synthetic */ int g = 1;
    public boolean h;
    public final Object i;
    public final Object j;

    public dl0(a aVar, um0 um0Var) {
        qg0.l(aVar, "registry");
        qg0.l(um0Var, "event");
        this.i = aVar;
        this.j = um0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jq1 jq1VarH;
        String packageName;
        Object obj = this.i;
        Object obj2 = this.j;
        switch (this.g) {
            case 0:
                t tVar = (t) obj;
                rl0 rl0Var = (rl0) obj2;
                if (this.h && !rl0Var.s.h.isEmpty()) {
                    qx1 qx1Var = rl0Var.s;
                    qx1Var.getClass();
                    rl0Var.j.K(new xm(rl0Var, tVar, new qx1(qx1Var), 5, false));
                }
                qx1 qx1Var2 = rl0Var.s;
                rl0Var.h.getClass();
                Context context = jk0.i;
                qx1Var2.getClass();
                Rect rect = ar1.a;
                try {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = m7.f(context).c().iterator();
                    while (it.hasNext()) {
                        rk0 rk0VarA = rk0.a((AppWidgetProviderInfo) it.next());
                        ComponentName componentName = ((AppWidgetProviderInfo) rk0VarA).provider;
                        if (componentName == null || !componentName.getPackageName().equals(context.getPackageName())) {
                            arrayList.add(rk0VarA);
                        } else {
                            arrayList.add(0, rk0VarA);
                        }
                    }
                    arrayList.addAll(context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0));
                    qx1Var2.a(arrayList);
                } catch (Exception e) {
                    WeakReference weakReference = jk0.h;
                    if (!(e.getCause() instanceof TransactionTooLargeException) && !(e.getCause() instanceof DeadObjectException)) {
                        throw e;
                    }
                }
                qx1 qx1Var3 = new qx1(qx1Var2);
                rl0Var.j.K(new xm(rl0Var, tVar, qx1Var3, 5, false));
                gx1 gx1Var = jk0.a().c;
                ArrayList arrayList2 = qx1Var3.h;
                gx1Var.getClass();
                Objects.toString(arrayList2);
                Rect rect2 = ar1.a;
                LongSparseArray longSparseArray = new LongSparseArray();
                int size = arrayList2.size();
                int i = 0;
                while (true) {
                    iy iyVar = gx1Var.e;
                    if (i >= size) {
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        Cursor cursorH = null;
                        try {
                            cursorH = gx1Var.g.h(null, new String[]{"profileId", "packageName", "lastUpdated", "version"}, null);
                            while (cursorH.moveToNext()) {
                                long j = cursorH.getLong(0);
                                String string = cursorH.getString(1);
                                long j2 = cursorH.getLong(2);
                                long j3 = cursorH.getLong(3);
                                HashSet hashSet = (HashSet) longSparseArray.get(j);
                                if (hashSet != null && hashSet.contains(string)) {
                                    long[] jArrB = gx1Var.b(string);
                                    if (jArrB[0] != j3 || jArrB[1] != j2) {
                                    }
                                }
                                HashSet hashSet2 = (HashSet) longSparseArray2.get(j);
                                if (hashSet2 == null) {
                                    hashSet2 = new HashSet();
                                    longSparseArray2.put(j, hashSet2);
                                }
                                hashSet2.add(string);
                            }
                            for (int i2 = 0; i2 < longSparseArray2.size(); i2++) {
                                long jKeyAt = longSparseArray2.keyAt(i2);
                                jq1 jq1VarR = iyVar.r(jKeyAt);
                                Iterator it2 = ((HashSet) longSparseArray2.valueAt(i2)).iterator();
                                while (it2.hasNext()) {
                                    gx1Var.d((String) it2.next(), jq1VarR, jKeyAt);
                                }
                                break;
                            }
                        } catch (SQLException unused) {
                            if (cursorH == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            if (cursorH != null) {
                                cursorH.close();
                            }
                            throw th;
                        }
                        cursorH.close();
                        return;
                    }
                    Object obj3 = arrayList2.get(i);
                    i++;
                    if (obj3 instanceof ResolveInfo) {
                        jq1VarH = jq1.b();
                        packageName = ((ResolveInfo) obj3).activityInfo.packageName;
                    } else {
                        rk0 rk0Var = (rk0) obj3;
                        jq1VarH = gx1Var.f.h(rk0Var);
                        packageName = ((AppWidgetProviderInfo) rk0Var).provider.getPackageName();
                    }
                    long jO = iyVar.o(jq1VarH);
                    HashSet hashSet3 = (HashSet) longSparseArray.get(jO);
                    if (hashSet3 == null) {
                        hashSet3 = new HashSet();
                        longSparseArray.put(jO, hashSet3);
                    }
                    hashSet3.add(packageName);
                }
                break;
            case 1:
                if (this.h) {
                    return;
                }
                ((a) obj).d((um0) obj2);
                this.h = true;
                return;
            default:
                Workspace workspace = (Workspace) obj2;
                if (workspace.J0()) {
                    workspace.z0.remove(-201L);
                    ArrayList arrayList3 = workspace.A0;
                    if (arrayList3 != null) {
                        arrayList3.remove((Object) (-201L));
                        workspace.e1();
                    }
                    workspace.removeView((CellLayout) obj);
                    if (this.h) {
                        workspace.b1();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public dl0(Workspace workspace, CellLayout cellLayout, boolean z) {
        this.j = workspace;
        this.i = cellLayout;
        this.h = z;
    }

    public dl0(rl0 rl0Var, boolean z, t tVar) {
        this.j = rl0Var;
        this.h = z;
        this.i = tVar;
    }
}
