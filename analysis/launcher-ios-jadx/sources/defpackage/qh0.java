package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class qh0 {
    public int h;
    public int r;
    public CharSequence u;
    public CharSequence v;
    public long g = -1;
    public long i = -1;
    public long j = -1;
    public int k = -1;
    public int l = -1;
    public int m = 1;
    public int n = 1;
    public int o = 1;
    public int p = 1;
    public int q = 0;
    public int s = 0;
    public boolean t = false;
    public jq1 w = jq1.b();

    public final void a(qh0 qh0Var) {
        this.g = qh0Var.g;
        this.k = qh0Var.k;
        this.l = qh0Var.l;
        this.m = qh0Var.m;
        this.n = qh0Var.n;
        this.q = qh0Var.q;
        this.j = qh0Var.j;
        this.h = qh0Var.h;
        this.i = qh0Var.i;
        this.w = qh0Var.w;
        this.v = qh0Var.v;
    }

    public Intent b() {
        throw new RuntimeException("Unexpected Intent");
    }

    public boolean c() {
        return false;
    }

    public void d(Context context, ContentValues contentValues) {
        contentValues.put("itemType", Integer.valueOf(this.h));
        contentValues.put("container", Long.valueOf(this.i));
        contentValues.put("screen", Long.valueOf(this.j));
        contentValues.put("cellX", Integer.valueOf(this.k));
        contentValues.put("cellY", Integer.valueOf(this.l));
        contentValues.put("spanX", Integer.valueOf(this.m));
        contentValues.put("spanY", Integer.valueOf(this.n));
        contentValues.put("rank", Integer.valueOf(this.q));
        contentValues.put("profileId", Long.valueOf(iy.n(context).o(this.w)));
        if (this.j == -201) {
            throw new RuntimeException("Screen id should not be EXTRA_EMPTY_SCREEN_ID");
        }
    }

    public String toString() {
        return "Item(id=" + this.g + " type=" + this.h + " container=" + this.i + " screen=" + this.j + " cellX=" + this.k + " cellY=" + this.l + " spanX=" + this.m + " spanY=" + this.n + " dropPos=" + Arrays.toString((int[]) null) + " user=" + this.w + ")";
    }

    public void e() {
    }
}
