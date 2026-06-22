package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public final class jz {
    public int a;
    public int b;
    public int c;
    public final Object d;
    public Object e;
    public Object f;

    public jz(du0 du0Var) {
        this.a = 1;
        this.d = du0Var;
        this.e = du0Var;
    }

    public int a(int i) {
        SparseArray sparseArray = ((du0) this.e).a;
        du0 du0Var = sparseArray == null ? null : (du0) sparseArray.get(i);
        int i2 = 1;
        if (this.a == 2) {
            if (du0Var != null) {
                this.e = du0Var;
                this.c++;
            } else if (i == 65038) {
                d();
            } else if (i != 65039) {
                du0 du0Var2 = (du0) this.e;
                if (du0Var2.b != null) {
                    if (this.c != 1) {
                        this.f = du0Var2;
                        d();
                    } else if (e()) {
                        this.f = (du0) this.e;
                        d();
                    } else {
                        d();
                    }
                    i2 = 3;
                } else {
                    d();
                }
            }
            i2 = 2;
        } else if (du0Var == null) {
            d();
        } else {
            this.a = 2;
            this.e = du0Var;
            this.c = 1;
            i2 = 2;
        }
        this.b = i;
        return i2;
    }

    public m11 b() {
        int iMax;
        dk dkVar;
        int i;
        Bitmap bitmap = (Bitmap) this.d;
        if (bitmap == null) {
            throw new AssertionError();
        }
        int i2 = this.b;
        double dSqrt = -1.0d;
        if (i2 > 0) {
            int height = bitmap.getHeight() * bitmap.getWidth();
            if (height > i2) {
                dSqrt = Math.sqrt(((double) i2) / ((double) height));
            }
        } else {
            int i3 = this.c;
            if (i3 > 0 && (iMax = Math.max(bitmap.getWidth(), bitmap.getHeight())) > i3) {
                dSqrt = ((double) i3) / ((double) iMax);
            }
        }
        Bitmap bitmapCreateScaledBitmap = dSqrt <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dSqrt), (int) Math.ceil(((double) bitmap.getHeight()) * dSqrt), false);
        int width = bitmapCreateScaledBitmap.getWidth();
        int height2 = bitmapCreateScaledBitmap.getHeight();
        int[] iArr = new int[width * height2];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height2);
        ArrayList arrayList = (ArrayList) this.f;
        j11[] j11VarArr = arrayList.isEmpty() ? null : (j11[]) arrayList.toArray(new j11[arrayList.size()]);
        int i4 = this.a;
        ek ekVar = new ek();
        ekVar.k = new float[3];
        ekVar.j = j11VarArr;
        int[] iArr2 = new int[32768];
        ekVar.i = iArr2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            int iC = (ek.c(Color.red(i6), 8, 5) << 10) | (ek.c(Color.green(i6), 8, 5) << 5) | ek.c(Color.blue(i6), 8, 5);
            iArr[i5] = iC;
            iArr2[iC] = iArr2[iC] + 1;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                int iRgb = Color.rgb(ek.c((i8 >> 10) & 31, 5, 8), ek.c((i8 >> 5) & 31, 5, 8), ek.c(i8 & 31, 5, 8));
                ThreadLocal threadLocal = ik.a;
                int iRed = Color.red(iRgb);
                int iGreen = Color.green(iRgb);
                int iBlue = Color.blue(iRgb);
                float[] fArr = (float[]) ekVar.k;
                ik.a(iRed, iGreen, iBlue, fArr);
                if (ekVar.d(fArr)) {
                    iArr2[i8] = 0;
                }
            }
            if (iArr2[i8] > 0) {
                i7++;
            }
        }
        int[] iArr3 = new int[i7];
        ekVar.h = iArr3;
        int i9 = 0;
        for (int i10 = 0; i10 < 32768; i10++) {
            if (iArr2[i10] > 0) {
                iArr3[i9] = i10;
                i9++;
            }
        }
        if (i7 <= i4) {
            ekVar.g = new ArrayList();
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = iArr3[i11];
                ((ArrayList) ekVar.g).add(new l11(Color.rgb(ek.c((i12 >> 10) & 31, 5, 8), ek.c((i12 >> 5) & 31, 5, 8), ek.c(i12 & 31, 5, 8)), iArr2[i12]));
            }
        } else {
            PriorityQueue<dk> priorityQueue = new PriorityQueue(i4, ek.l);
            priorityQueue.offer(new dk(ekVar, 0, ((int[]) ekVar.h).length - 1));
            while (priorityQueue.size() < i4 && (dkVar = (dk) priorityQueue.poll()) != null) {
                int i13 = dkVar.b;
                int iMin = dkVar.a;
                if ((i13 + 1) - iMin <= 1) {
                    break;
                }
                if ((i13 + 1) - iMin <= 1) {
                    throw new IllegalStateException("Can not split a box with only 1 color");
                }
                int i14 = dkVar.e - dkVar.d;
                int i15 = dkVar.g - dkVar.f;
                int i16 = dkVar.i - dkVar.h;
                int i17 = (i14 < i15 || i14 < i16) ? (i15 < i14 || i15 < i16) ? -1 : -2 : -3;
                ek ekVar2 = dkVar.j;
                int[] iArr4 = (int[]) ekVar2.h;
                ek.b(iArr4, i17, iMin, i13);
                Arrays.sort(iArr4, iMin, dkVar.b + 1);
                ek.b(iArr4, i17, iMin, dkVar.b);
                int i18 = dkVar.c / 2;
                int i19 = iMin;
                int i20 = 0;
                while (true) {
                    int i21 = dkVar.b;
                    if (i19 <= i21) {
                        i20 += ((int[]) ekVar2.i)[iArr4[i19]];
                        if (i20 >= i18) {
                            iMin = Math.min(i21 - 1, i19);
                            break;
                        }
                        i19++;
                    }
                }
                dk dkVar2 = new dk(ekVar2, iMin + 1, dkVar.b);
                dkVar.b = iMin;
                dkVar.a();
                priorityQueue.offer(dkVar2);
                priorityQueue.offer(dkVar);
            }
            ArrayList arrayList2 = new ArrayList(priorityQueue.size());
            for (dk dkVar3 : priorityQueue) {
                ek ekVar3 = dkVar3.j;
                int[] iArr5 = (int[]) ekVar3.h;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                for (int i26 = dkVar3.a; i26 <= dkVar3.b; i26++) {
                    int i27 = iArr5[i26];
                    int i28 = ((int[]) ekVar3.i)[i27];
                    i23 += i28;
                    i22 = (((i27 >> 10) & 31) * i28) + i22;
                    i24 = (((i27 >> 5) & 31) * i28) + i24;
                    i25 += i28 * (i27 & 31);
                }
                float f = i23;
                l11 l11Var = new l11(Color.rgb(ek.c(Math.round(i22 / f), 5, 8), ek.c(Math.round(i24 / f), 5, 8), ek.c(Math.round(i25 / f), 5, 8)), i23);
                if (!ekVar.d(l11Var.b())) {
                    arrayList2.add(l11Var);
                }
            }
            ekVar.g = arrayList2;
        }
        if (bitmapCreateScaledBitmap != bitmap) {
            bitmapCreateScaledBitmap.recycle();
        }
        ArrayList arrayList3 = (ArrayList) ekVar.g;
        ArrayList arrayList4 = (ArrayList) this.e;
        m11 m11Var = new m11(arrayList3, arrayList4);
        int size = arrayList4.size();
        int i29 = 0;
        while (true) {
            SparseBooleanArray sparseBooleanArray = m11Var.c;
            if (i29 >= size) {
                sparseBooleanArray.clear();
                return m11Var;
            }
            mm1 mm1Var = (mm1) arrayList4.get(i29);
            float[] fArr2 = mm1Var.c;
            float f2 = 0.0f;
            for (float f3 : fArr2) {
                if (f3 > 0.0f) {
                    f2 += f3;
                }
            }
            if (f2 != 0.0f) {
                int length = fArr2.length;
                for (int i30 = 0; i30 < length; i30++) {
                    float f4 = fArr2[i30];
                    if (f4 > 0.0f) {
                        fArr2[i30] = f4 / f2;
                    }
                }
            }
            e9 e9Var = m11Var.b;
            ArrayList arrayList5 = m11Var.a;
            int size2 = arrayList5.size();
            int i31 = 0;
            l11 l11Var2 = null;
            float f5 = 0.0f;
            while (i31 < size2) {
                l11 l11Var3 = (l11) arrayList5.get(i31);
                float[] fArrB = l11Var3.b();
                float f6 = fArrB[1];
                float[] fArr3 = mm1Var.a;
                if (f6 < fArr3[0] || f6 > fArr3[2]) {
                    i = size;
                } else {
                    float f7 = fArrB[2];
                    float[] fArr4 = mm1Var.b;
                    if (f7 < fArr4[0] || f7 > fArr4[2] || sparseBooleanArray.get(l11Var3.d)) {
                        i = size;
                    } else {
                        float[] fArrB2 = l11Var3.b();
                        l11 l11Var4 = m11Var.d;
                        int i32 = l11Var4 != null ? l11Var4.e : 1;
                        i = size;
                        float[] fArr5 = mm1Var.c;
                        float f8 = fArr5[0];
                        float fAbs = f8 > 0.0f ? (1.0f - Math.abs(fArrB2[1] - fArr3[1])) * f8 : 0.0f;
                        float f9 = fArr5[1];
                        float fAbs2 = f9 > 0.0f ? (1.0f - Math.abs(fArrB2[2] - fArr4[1])) * f9 : 0.0f;
                        float f10 = fArr5[2];
                        float f11 = fAbs + fAbs2 + (f10 > 0.0f ? (l11Var3.e / i32) * f10 : 0.0f);
                        if (l11Var2 == null || f11 > f5) {
                            f5 = f11;
                            l11Var2 = l11Var3;
                        }
                    }
                }
                i31++;
                size = i;
            }
            int i33 = size;
            if (l11Var2 != null) {
                sparseBooleanArray.append(l11Var2.d, true);
            }
            e9Var.put(mm1Var, l11Var2);
            i29++;
            size = i33;
        }
    }

    public void c(k11 k11Var) {
        new pj0(this, k11Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Bitmap) this.d);
    }

    public void d() {
        this.a = 1;
        this.e = (du0) this.d;
        this.c = 0;
    }

    public boolean e() {
        bu0 bu0VarB = ((du0) this.e).b.b();
        int iA = bu0VarB.a(6);
        return !(iA == 0 || ((ByteBuffer) bu0VarB.j).get(iA + bu0VarB.g) == 0) || this.b == 65039;
    }

    public jz(Bitmap bitmap) {
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.a = 16;
        this.b = 12544;
        this.c = -1;
        ArrayList arrayList2 = new ArrayList();
        this.f = arrayList2;
        if (bitmap != null && !bitmap.isRecycled()) {
            arrayList2.add(m11.e);
            this.d = bitmap;
            arrayList.add(mm1.d);
            arrayList.add(mm1.e);
            arrayList.add(mm1.f);
            arrayList.add(mm1.g);
            arrayList.add(mm1.h);
            arrayList.add(mm1.i);
            return;
        }
        throw new IllegalArgumentException("Bitmap is not valid");
    }
}
