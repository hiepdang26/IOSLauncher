package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class ra0 {
    public final ArrayList a;
    public final boolean[][] b;
    public final boolean c;
    public float d = Float.MAX_VALUE;
    public float e = Float.MAX_VALUE;
    public ArrayList f;
    public final /* synthetic */ sa0 g;

    public ra0(sa0 sa0Var, boolean[][] zArr, ArrayList arrayList, boolean z) {
        this.g = sa0Var;
        this.b = zArr;
        this.a = arrayList;
        this.c = z;
        Collections.sort(arrayList);
    }

    public final void a(int i, float f, float f2, ArrayList arrayList) {
        float f3;
        float f4;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        float f5;
        int i7;
        int i8;
        float f6 = f;
        float f7 = this.d;
        if (f6 < f7) {
            if (f6 != f7 || f2 < this.e) {
                ArrayList arrayList2 = this.a;
                if (i >= arrayList2.size()) {
                    this.d = f6;
                    this.e = f2;
                    this.f = sa0.c(arrayList);
                    return;
                }
                qa0 qa0Var = (qa0) arrayList2.get(i);
                int i9 = qa0Var.k;
                int i10 = qa0Var.l;
                ArrayList arrayList3 = new ArrayList(arrayList.size() + 1);
                arrayList3.addAll(arrayList);
                arrayList3.add(qa0Var);
                int i11 = qa0Var.m;
                sa0 sa0Var = this.g;
                boolean z2 = this.c;
                boolean[][] zArr = this.b;
                if (i11 <= 1 && qa0Var.n <= 1) {
                    int i12 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    int i13 = 0;
                    int i14 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    int i15 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    while (true) {
                        i5 = sa0Var.k;
                        z = z2;
                        i6 = sa0Var.j;
                        if (i13 >= i5) {
                            break;
                        }
                        int i16 = i15;
                        int i17 = i12;
                        int i18 = 0;
                        while (i18 < i6) {
                            if (zArr[i18][i13]) {
                                i7 = i18;
                            } else {
                                if (z) {
                                    i7 = i18;
                                    i8 = 0;
                                } else {
                                    i7 = i18;
                                    int i19 = qa0Var.k - i7;
                                    int i20 = i19 * i19;
                                    int i21 = qa0Var.l - i13;
                                    i8 = (i21 * i21) + i20;
                                }
                                if (i8 < i16) {
                                    i16 = i8;
                                    i14 = i13;
                                    i17 = i7;
                                }
                            }
                            i18 = i7 + 1;
                        }
                        i13++;
                        i12 = i17;
                        z2 = z;
                        i15 = i16;
                    }
                    if (i12 >= i6 || i14 >= i5) {
                        for (int i22 = i + 1; i22 < arrayList2.size(); i22++) {
                            f6 += ((qa0) arrayList2.get(i22)).x;
                        }
                        a(arrayList2.size(), f6 + qa0Var.x, f2, arrayList);
                        return;
                    }
                    if (i12 != i9) {
                        qa0Var.k = i12;
                        f5 = f2 + 1.0f;
                    } else {
                        f5 = f2;
                    }
                    if (i14 != i10) {
                        qa0Var.l = i14;
                        f5 += 1.0f;
                    }
                    if (z) {
                        f5 = f2;
                    }
                    sa0.f(zArr, qa0Var, true);
                    int i23 = i + 1;
                    a(i23, f6, f5, arrayList3);
                    sa0.f(zArr, qa0Var, false);
                    qa0Var.k = i9;
                    qa0Var.l = i10;
                    if (i23 < arrayList2.size()) {
                        float f8 = ((qa0) arrayList2.get(i23)).x;
                        float f9 = qa0Var.x;
                        if (f8 < f9 || z) {
                            return;
                        }
                        a(i23, f6 + f9, f2, arrayList);
                        return;
                    }
                    return;
                }
                int i24 = qa0Var.n;
                int i25 = 0;
                while (i25 < sa0Var.k) {
                    int i26 = 0;
                    while (i26 < sa0Var.j) {
                        if (i26 != i9) {
                            qa0Var.k = i26;
                            f3 = f2 + 1.0f;
                        } else {
                            f3 = f2;
                        }
                        if (i25 != i10) {
                            qa0Var.l = i25;
                            f3 += 1.0f;
                        }
                        if (z2) {
                            f3 = f2;
                        }
                        int i27 = i25;
                        int i28 = i24;
                        int i29 = i11;
                        boolean[][] zArr2 = zArr;
                        sa0 sa0Var2 = sa0Var;
                        if (sa0.a(sa0Var, this.b, i26, i27, i29, i28)) {
                            sa0.f(zArr2, qa0Var, true);
                            a(i + 1, f6, f3, arrayList3);
                            sa0.f(zArr2, qa0Var, false);
                        }
                        if (i29 > qa0Var.o) {
                            int i30 = i29 - 1;
                            int i31 = i26;
                            i2 = i29;
                            f4 = f3;
                            i26 = i31;
                            i3 = i28;
                            if (sa0.a(this.g, this.b, i31, i27, i30, i28)) {
                                qa0Var.m--;
                                sa0.f(zArr2, qa0Var, true);
                                a(i + 1, f6, f4 + 1.0f, arrayList3);
                                sa0.f(zArr2, qa0Var, false);
                                qa0Var.m++;
                            }
                        } else {
                            f4 = f3;
                            i2 = i29;
                            i3 = i28;
                        }
                        if (i3 > qa0Var.p) {
                            i4 = i2;
                            if (sa0.a(this.g, this.b, i26, i27, i2, i3 - 1)) {
                                qa0Var.n--;
                                sa0.f(zArr2, qa0Var, true);
                                a(i + 1, f6, f4 + 1.0f, arrayList3);
                                sa0.f(zArr2, qa0Var, false);
                                qa0Var.n++;
                            }
                        } else {
                            i4 = i2;
                        }
                        if (i3 > qa0Var.p && i4 > qa0Var.o) {
                            if (sa0.a(this.g, this.b, i26, i27, i4 - 1, i3 - 1)) {
                                qa0Var.m--;
                                qa0Var.n--;
                                sa0.f(zArr2, qa0Var, true);
                                a(i + 1, f6, f4 + 2.0f, arrayList3);
                                sa0.f(zArr2, qa0Var, false);
                                qa0Var.m++;
                                qa0Var.n++;
                            }
                        }
                        qa0Var.k = i9;
                        qa0Var.l = i10;
                        i26++;
                        zArr = zArr2;
                        i24 = i3;
                        i11 = i4;
                        i25 = i27;
                        sa0Var = sa0Var2;
                    }
                    i25++;
                    i24 = i24;
                    sa0Var = sa0Var;
                }
                a(i + 1, f6 + qa0Var.x, f2, arrayList);
            }
        }
    }
}
