package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public final class ne0 implements Runnable {
    public final /* synthetic */ int g;
    public final long h;
    public final Object i;
    public final Object j;
    public final Object k;
    public final Object l;
    public final /* synthetic */ Object m;

    public ne0(ContentResolver contentResolver, Uri uri, ContentValues contentValues, qh0 qh0Var, long j, StackTraceElement[] stackTraceElementArr) {
        this.g = 1;
        this.i = contentResolver;
        this.j = uri;
        this.k = contentValues;
        this.l = qh0Var;
        this.h = j;
        this.m = stackTraceElementArr;
    }

    public void a() {
        ((oe0) this.m).d.postAtTime(this, oe0.t, SystemClock.uptimeMillis() + 1);
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.g) {
            case 0:
                Objects.toString((Stack) this.k);
                Objects.toString((Stack) this.j);
                if (!((Stack) this.k).isEmpty()) {
                    ek0 ek0Var = (ek0) ((Stack) this.k).pop();
                    String strFlattenToString = ek0Var.b().flattenToString();
                    ((oe0) this.m).c.i(((oe0) this.m).I(ek0Var), new String[]{strFlattenToString, Long.toString(this.h)});
                    ((HashSet) this.l).add(ek0Var.b().getPackageName());
                    if (((Stack) this.k).isEmpty()) {
                        jk0.a().a.u((HashSet) this.l, ((oe0) this.m).b.r(this.h));
                    }
                    a();
                    return;
                }
                if (((Stack) this.j).isEmpty()) {
                    return;
                }
                ek0 ek0Var2 = (ek0) ((Stack) this.j).pop();
                PackageInfo packageInfo = (PackageInfo) ((HashMap) this.i).get(ek0Var2.b().getPackageName());
                if (packageInfo != null) {
                    synchronized (((oe0) this.m)) {
                        oe0 oe0Var = (oe0) this.m;
                        long j = this.h;
                        oe0Var.getClass();
                        Objects.toString(ek0Var2);
                        Objects.toString(packageInfo);
                        oe0Var.c(oe0Var.I(ek0Var2), ek0Var2.b(), packageInfo, j);
                        break;
                    }
                }
                if (((Stack) this.j).isEmpty()) {
                    return;
                }
                a();
                return;
            default:
                ((ContentResolver) this.i).update((Uri) this.j, (ContentValues) this.k, null, null);
                rl0.D(this.h, (qh0) this.l, (StackTraceElement[]) this.m);
                return;
        }
    }

    public ne0(oe0 oe0Var, long j, HashMap map, Stack stack, Stack stack2) {
        this.g = 0;
        this.m = oe0Var;
        this.l = new HashSet();
        this.h = j;
        this.i = map;
        this.j = stack;
        this.k = stack2;
    }
}
