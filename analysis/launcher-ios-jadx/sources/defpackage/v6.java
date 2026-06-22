package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class v6 extends qh0 {
    public final ComponentName A;
    public final ApplicationInfo B;
    public final int C;
    public int D;
    public final Intent x;
    public Bitmap y;
    public boolean z;

    public v6(Context context, ek0 ek0Var, jq1 jq1Var, oe0 oe0Var) {
        this(context, ek0Var, jq1Var, oe0Var, iy.n(context).v(jq1Var));
    }

    public static void f(ArrayList arrayList) {
        arrayList.size();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            v6 v6Var = (v6) obj;
            Objects.toString(v6Var.u);
            Objects.toString(v6Var.y);
            v6Var.A.getPackageName();
        }
    }

    public static int g(ek0 ek0Var) {
        int i = ek0Var.a().flags;
        if ((i & 1) == 0) {
            return (i & 128) != 0 ? 3 : 1;
        }
        return 0;
    }

    public static Intent h(Context context, ek0 ek0Var, jq1 jq1Var) {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setComponent(ek0Var.b()).setFlags(270532608).putExtra("profile", iy.n(context).o(jq1Var));
    }

    @Override // defpackage.qh0
    public final Intent b() {
        return this.x;
    }

    @Override // defpackage.qh0
    public final boolean c() {
        return this.D != 0;
    }

    public final og1 i() {
        og1 og1Var = new og1();
        og1Var.g = -1L;
        og1Var.i = -1L;
        og1Var.j = -1L;
        og1Var.k = -1;
        og1Var.l = -1;
        og1Var.m = 1;
        og1Var.n = 1;
        og1Var.o = 1;
        og1Var.p = 1;
        og1Var.q = 0;
        og1Var.s = 0;
        og1Var.t = false;
        og1Var.a(this);
        HandlerThread handlerThread = rl0.w;
        Objects.toString(og1Var);
        rl0.y(new gl0(og1Var.g, og1Var, new Throwable().getStackTrace()));
        og1Var.D = 0;
        og1Var.G = 0;
        og1Var.u = ar1.B(this.u);
        og1Var.x = new Intent(this.x);
        og1Var.y = false;
        og1Var.G = this.C;
        og1Var.D = this.D;
        return og1Var;
    }

    @Override // defpackage.qh0
    public final String toString() {
        return "ApplicationInfo(title=" + ((Object) this.u) + " id=" + this.g + " type=" + this.h + " container=" + this.i + " screen=" + this.j + " cellX=" + this.k + " cellY=" + this.l + " spanX=" + this.m + " spanY=" + this.n + " dropPos=" + Arrays.toString((int[]) null) + " user=" + this.w + ")";
    }

    public v6(Context context, ek0 ek0Var, jq1 jq1Var, oe0 oe0Var, boolean z) {
        this.C = 0;
        this.D = 0;
        this.B = ek0Var.a();
        this.A = ek0Var.b();
        this.i = -1L;
        this.C = g(ek0Var);
        if (az1.x(ek0Var.a())) {
            this.D |= 4;
        }
        if (z) {
            this.D |= 8;
        }
        oe0Var.t(this, ek0Var);
        this.x = h(context, ek0Var, jq1Var);
        this.w = jq1Var;
    }
}
