package defpackage;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class w40 extends qh0 {
    public boolean y;
    public final ArrayList x = new ArrayList();
    public final ArrayList z = new ArrayList();

    public w40() {
        this.h = 2;
        this.w = jq1.b();
    }

    @Override // defpackage.qh0
    public final void d(Context context, ContentValues contentValues) {
        super.d(context, contentValues);
        contentValues.put("title", this.u.toString());
        contentValues.put("options", Integer.valueOf(this.r));
    }

    @Override // defpackage.qh0
    public final void e() {
        this.z.clear();
    }

    public final void f(og1 og1Var) {
        this.x.add(og1Var);
        int i = 0;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.z;
            if (i2 >= arrayList.size()) {
                break;
            }
            ((v40) arrayList.get(i2)).e(og1Var);
            i2++;
        }
        while (true) {
            ArrayList arrayList2 = this.z;
            if (i >= arrayList2.size()) {
                return;
            }
            ((v40) arrayList2.get(i)).n();
            i++;
        }
    }

    public final void g(og1 og1Var) {
        this.x.remove(og1Var);
        int i = 0;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.z;
            if (i2 >= arrayList.size()) {
                break;
            }
            ((v40) arrayList.get(i2)).k(og1Var);
            i2++;
        }
        while (true) {
            ArrayList arrayList2 = this.z;
            if (i >= arrayList2.size()) {
                return;
            }
            ((v40) arrayList2.get(i)).n();
            i++;
        }
    }

    public final void h(Context context, int i, boolean z) {
        int i2 = this.r;
        if (z) {
            this.r = i | i2;
        } else {
            this.r = (~i) & i2;
        }
        if (context == null || i2 == this.r) {
            return;
        }
        rl0.E(context, this);
    }

    @Override // defpackage.qh0
    public final String toString() {
        return "FolderInfo(id=" + this.g + " type=" + this.h + " container=" + this.i + " screen=" + this.j + " cellX=" + this.k + " cellY=" + this.l + " spanX=" + this.m + " spanY=" + this.n + " dropPos=" + Arrays.toString((int[]) null) + ")";
    }
}
