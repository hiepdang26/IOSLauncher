package defpackage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class f01 extends AbstractList implements RandomAccess {
    public static final /* synthetic */ int i = 0;
    public final df[] g;
    public final int[] h;

    public f01(df[] dfVarArr, int[] iArr) {
        this.g = dfVarArr;
        this.h = iArr;
    }

    public static void a(long j, fe feVar, int i2, ArrayList arrayList, int i3, int i4, ArrayList arrayList2) {
        int i5;
        int i6;
        int i7;
        ArrayList arrayList3;
        long j2;
        int i8;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i3 >= i4) {
            throw new AssertionError();
        }
        for (int i9 = i3; i9 < i4; i9++) {
            if (((df) arrayList4.get(i9)).i() < i2) {
                throw new AssertionError();
            }
        }
        df dfVar = (df) arrayList.get(i3);
        df dfVar2 = (df) arrayList4.get(i4 - 1);
        if (i2 == dfVar.i()) {
            int iIntValue = ((Integer) arrayList5.get(i3)).intValue();
            int i10 = i3 + 1;
            df dfVar3 = (df) arrayList4.get(i10);
            i5 = i10;
            i6 = iIntValue;
            dfVar = dfVar3;
        } else {
            i5 = i3;
            i6 = -1;
        }
        if (dfVar.d(i2) == dfVar2.d(i2)) {
            int iMin = Math.min(dfVar.i(), dfVar2.i());
            int i11 = 0;
            for (int i12 = i2; i12 < iMin && dfVar.d(i12) == dfVar2.d(i12); i12++) {
                i11++;
            }
            long j3 = j + ((long) ((int) (feVar.h / 4))) + 2 + ((long) i11) + 1;
            feVar.N(-i11);
            feVar.N(i6);
            int i13 = i2;
            while (true) {
                i7 = i2 + i11;
                if (i13 >= i7) {
                    break;
                }
                feVar.N(dfVar.d(i13) & 255);
                i13++;
            }
            if (i5 + 1 == i4) {
                if (i7 != ((df) arrayList4.get(i5)).i()) {
                    throw new AssertionError();
                }
                feVar.N(((Integer) arrayList5.get(i5)).intValue());
                return;
            } else {
                fe feVar2 = new fe();
                feVar.N((int) ((((long) ((int) (feVar2.h / 4))) + j3) * (-1)));
                a(j3, feVar2, i7, arrayList4, i5, i4, arrayList5);
                feVar.c(feVar2, feVar2.h);
                return;
            }
        }
        int i14 = 1;
        for (int i15 = i5 + 1; i15 < i4; i15++) {
            if (((df) arrayList4.get(i15 - 1)).d(i2) != ((df) arrayList4.get(i15)).d(i2)) {
                i14++;
            }
        }
        long j4 = j + ((long) ((int) (feVar.h / 4))) + 2 + ((long) (i14 * 2));
        feVar.N(i14);
        feVar.N(i6);
        for (int i16 = i5; i16 < i4; i16++) {
            byte bD = ((df) arrayList4.get(i16)).d(i2);
            if (i16 == i5 || bD != ((df) arrayList4.get(i16 - 1)).d(i2)) {
                feVar.N(bD & 255);
            }
        }
        fe feVar3 = new fe();
        int i17 = i5;
        while (i17 < i4) {
            byte bD2 = ((df) arrayList4.get(i17)).d(i2);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i4) {
                    i19 = i4;
                    break;
                } else if (bD2 != ((df) arrayList4.get(i19)).d(i2)) {
                    break;
                } else {
                    i19++;
                }
            }
            if (i18 == i19 && i2 + 1 == ((df) arrayList4.get(i17)).i()) {
                feVar.N(((Integer) arrayList5.get(i17)).intValue());
                arrayList3 = arrayList5;
                j2 = j4;
                i8 = i19;
            } else {
                feVar.N((int) ((((long) ((int) (feVar3.h / 4))) + j4) * (-1)));
                arrayList3 = arrayList5;
                j2 = j4;
                i8 = i19;
                a(j2, feVar3, i2 + 1, arrayList, i17, i8, arrayList3);
                arrayList4 = arrayList;
            }
            j4 = j2;
            i17 = i8;
            arrayList5 = arrayList3;
        }
        feVar.c(feVar3, feVar3.h);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.g[i2];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.g.length;
    }
}
