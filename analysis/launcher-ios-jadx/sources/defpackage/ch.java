package defpackage;

import android.graphics.Rect;
import android.view.View;
import com.luutinhit.launcher6.CellLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ch {
    public final ArrayList a;
    public final yg b;
    public final Rect c = new Rect();
    public final int[] d;
    public final int[] e;
    public final int[] f;
    public final int[] g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final bh m;
    public final /* synthetic */ CellLayout n;

    public ch(CellLayout cellLayout, ArrayList arrayList, yg ygVar) {
        this.n = cellLayout;
        int i = cellLayout.m;
        this.d = new int[i];
        this.e = new int[i];
        int i2 = cellLayout.l;
        this.f = new int[i2];
        this.g = new int[i2];
        this.m = new bh(this);
        this.a = (ArrayList) arrayList.clone();
        this.b = ygVar;
        c();
    }

    public final void a(int i, int[] iArr) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            wg wgVar = (wg) this.b.a.get(arrayList.get(i2));
            if (i == 0) {
                int i3 = wgVar.a;
                for (int i4 = wgVar.b; i4 < wgVar.b + wgVar.d; i4++) {
                    int i5 = iArr[i4];
                    if (i3 < i5 || i5 < 0) {
                        iArr[i4] = i3;
                    }
                }
            } else if (i == 1) {
                int i6 = wgVar.b;
                for (int i7 = wgVar.a; i7 < wgVar.a + wgVar.c; i7++) {
                    int i8 = iArr[i7];
                    if (i6 < i8 || i8 < 0) {
                        iArr[i7] = i6;
                    }
                }
            } else if (i == 2) {
                int i9 = wgVar.a + wgVar.c;
                for (int i10 = wgVar.b; i10 < wgVar.b + wgVar.d; i10++) {
                    if (i9 > iArr[i10]) {
                        iArr[i10] = i9;
                    }
                }
            } else if (i == 3) {
                int i11 = wgVar.b + wgVar.d;
                for (int i12 = wgVar.a; i12 < wgVar.a + wgVar.c; i12++) {
                    if (i11 > iArr[i12]) {
                        iArr[i12] = i11;
                    }
                }
            }
        }
    }

    public final Rect b() {
        boolean z = this.l;
        Rect rect = this.c;
        if (z) {
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            boolean z2 = true;
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                wg wgVar = (wg) this.b.a.get((View) obj);
                if (z2) {
                    int i2 = wgVar.a;
                    int i3 = wgVar.b;
                    rect.set(i2, i3, wgVar.c + i2, wgVar.d + i3);
                    z2 = false;
                } else {
                    int i4 = wgVar.a;
                    int i5 = wgVar.b;
                    rect.union(i4, i5, wgVar.c + i4, wgVar.d + i5);
                }
            }
        }
        return rect;
    }

    public final void c() {
        CellLayout cellLayout;
        int i = 0;
        while (true) {
            cellLayout = this.n;
            if (i >= cellLayout.l) {
                break;
            }
            this.f[i] = -1;
            this.g[i] = -1;
            i++;
        }
        for (int i2 = 0; i2 < cellLayout.m; i2++) {
            this.d[i2] = -1;
            this.e[i2] = -1;
        }
        this.h = true;
        this.i = true;
        this.k = true;
        this.j = true;
        this.l = true;
    }
}
