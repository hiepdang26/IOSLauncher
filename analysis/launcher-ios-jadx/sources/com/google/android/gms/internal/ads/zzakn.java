package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzakn implements zzaka {
    private static final byte[] zza = {0, 7, 8, 15};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakg zzg;
    private final zzakf zzh;
    private final zzakm zzi;
    private Bitmap zzj;

    public zzakn(List list) {
        zzek zzekVar = new zzek((byte[]) list.get(0));
        int iZzq = zzekVar.zzq();
        int iZzq2 = zzekVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakg(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakf(0, zzh(), zzi(), zzj());
        this.zzi = new zzakm(iZzq, iZzq2);
    }

    private static int zzc(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakf zzd(zzej zzejVar, int i) {
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i2 = 8;
        int iZzd5 = zzejVar.zzd(8);
        zzejVar.zzn(8);
        int[] iArrZzh = zzh();
        int[] iArrZzi = zzi();
        int[] iArrZzj = zzj();
        int i3 = i - 2;
        while (i3 > 0) {
            int iZzd6 = zzejVar.zzd(i2);
            int iZzd7 = zzejVar.zzd(i2);
            int[] iArr = (iZzd7 & 128) != 0 ? iArrZzh : (iZzd7 & 64) != 0 ? iArrZzi : iArrZzj;
            if ((iZzd7 & 1) != 0) {
                iZzd3 = zzejVar.zzd(i2);
                iZzd4 = zzejVar.zzd(i2);
                iZzd = zzejVar.zzd(i2);
                iZzd2 = zzejVar.zzd(i2);
                i3 -= 6;
            } else {
                int iZzd8 = zzejVar.zzd(6) << 2;
                int iZzd9 = zzejVar.zzd(4) << 4;
                i3 -= 4;
                iZzd = zzejVar.zzd(4) << 4;
                iZzd2 = zzejVar.zzd(2) << 6;
                iZzd3 = iZzd8;
                iZzd4 = iZzd9;
            }
            if (iZzd3 == 0) {
                iZzd2 = 255;
            }
            if (iZzd3 == 0) {
                iZzd = 0;
            }
            if (iZzd3 == 0) {
                iZzd4 = 0;
            }
            double d = iZzd3;
            double d2 = iZzd4 - 128;
            double d3 = iZzd - 128;
            iArr[iZzd6] = zzc((byte) (255 - (iZzd2 & 255)), Math.max(0, Math.min((int) ((1.402d * d2) + d), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) ((d3 * 1.772d) + d), 255)));
            iZzd5 = iZzd5;
            i2 = 8;
        }
        return new zzakf(iZzd5, iArrZzh, iArrZzi, iArrZzj);
    }

    private static zzakh zze(zzej zzejVar) {
        byte[] bArr;
        int iZzd = zzejVar.zzd(16);
        zzejVar.zzn(4);
        int iZzd2 = zzejVar.zzd(2);
        boolean zZzp = zzejVar.zzp();
        zzejVar.zzn(1);
        byte[] bArr2 = zzet.zzf;
        if (iZzd2 != 1) {
            if (iZzd2 == 0) {
                int iZzd3 = zzejVar.zzd(16);
                int iZzd4 = zzejVar.zzd(16);
                if (iZzd3 > 0) {
                    bArr2 = new byte[iZzd3];
                    zzejVar.zzi(bArr2, 0, iZzd3);
                }
                if (iZzd4 > 0) {
                    bArr = new byte[iZzd4];
                    zzejVar.zzi(bArr, 0, iZzd4);
                }
            }
            return new zzakh(iZzd, zZzp, bArr2, bArr);
        }
        zzejVar.zzn(zzejVar.zzd(8) * 16);
        bArr = bArr2;
        return new zzakh(iZzd, zZzp, bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fd A[LOOP:3: B:87:0x0161->B:119:0x01fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0140 A[LOOP:2: B:40:0x00a6->B:74:0x0140, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzf(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakn.zzf(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzg(int i, int i2, zzej zzejVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzejVar.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzh() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] zzi() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzc(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                iArr[i] = zzc(255, 1 != i4 ? 0 : 127, i3 != 0 ? 127 : 0, i2 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzj() {
        int[] iArr = new int[MotionScene.Transition.TransitionOnClick.JUMP_TO_END];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzc(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = zzc(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzc(127, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzc(255, (1 != (i & 1) ? 0 : 43) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzc(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdn zzdnVar) {
        zzajs zzajsVar;
        float f;
        float f2;
        zzakk zzakkVar;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i3;
        int iZzd5;
        zzej zzejVar = new zzej(bArr, i + i2);
        zzejVar.zzl(i);
        while (zzejVar.zza() >= 48 && zzejVar.zzd(8) == 15) {
            zzakm zzakmVar = this.zzi;
            int iZzd6 = zzejVar.zzd(8);
            int iZzd7 = zzejVar.zzd(16);
            int iZzd8 = zzejVar.zzd(16);
            int iZzb = zzejVar.zzb() + iZzd8;
            if (iZzd8 * 8 > zzejVar.zza()) {
                zzea.zzf("DvbParser", "Data field length exceeds limit");
                zzejVar.zzn(zzejVar.zza());
            } else {
                switch (iZzd6) {
                    case 16:
                        if (iZzd7 == zzakmVar.zza) {
                            zzaki zzakiVar = zzakmVar.zzi;
                            int iZzd9 = zzejVar.zzd(8);
                            int iZzd10 = zzejVar.zzd(4);
                            int iZzd11 = zzejVar.zzd(2);
                            zzejVar.zzn(2);
                            SparseArray sparseArray = new SparseArray();
                            for (int i4 = iZzd8 - 2; i4 > 0; i4 -= 6) {
                                int iZzd12 = zzejVar.zzd(8);
                                zzejVar.zzn(8);
                                sparseArray.put(iZzd12, new zzakj(zzejVar.zzd(16), zzejVar.zzd(16)));
                            }
                            zzaki zzakiVar2 = new zzaki(iZzd9, iZzd10, iZzd11, sparseArray);
                            if (zzakiVar2.zzb != 0) {
                                zzakmVar.zzi = zzakiVar2;
                                zzakmVar.zzc.clear();
                                zzakmVar.zzd.clear();
                                zzakmVar.zze.clear();
                            } else if (zzakiVar != null) {
                                if (zzakiVar.zza != zzakiVar2.zza) {
                                    zzakmVar.zzi = zzakiVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzaki zzakiVar3 = zzakmVar.zzi;
                        if (iZzd7 == zzakmVar.zza && zzakiVar3 != null) {
                            int iZzd13 = zzejVar.zzd(8);
                            zzejVar.zzn(4);
                            boolean zZzp = zzejVar.zzp();
                            zzejVar.zzn(3);
                            int iZzd14 = zzejVar.zzd(16);
                            int iZzd15 = zzejVar.zzd(16);
                            int iZzd16 = zzejVar.zzd(3);
                            int iZzd17 = zzejVar.zzd(3);
                            zzejVar.zzn(2);
                            int iZzd18 = zzejVar.zzd(8);
                            int iZzd19 = zzejVar.zzd(8);
                            int iZzd20 = zzejVar.zzd(4);
                            int iZzd21 = zzejVar.zzd(2);
                            zzejVar.zzn(2);
                            int i5 = iZzd8 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while (i5 > 0) {
                                int iZzd22 = zzejVar.zzd(16);
                                int iZzd23 = zzejVar.zzd(2);
                                int iZzd24 = zzejVar.zzd(2);
                                int iZzd25 = zzejVar.zzd(12);
                                zzejVar.zzn(4);
                                int iZzd26 = zzejVar.zzd(12);
                                int i6 = i5 - 6;
                                if (iZzd23 == 1) {
                                    i5 -= 8;
                                    iZzd = zzejVar.zzd(8);
                                    iZzd2 = zzejVar.zzd(8);
                                } else if (iZzd23 == 2) {
                                    iZzd23 = 2;
                                    i5 -= 8;
                                    iZzd = zzejVar.zzd(8);
                                    iZzd2 = zzejVar.zzd(8);
                                } else {
                                    i5 = i6;
                                    iZzd = 0;
                                    iZzd2 = 0;
                                }
                                sparseArray2.put(iZzd22, new zzakl(iZzd23, iZzd24, iZzd25, iZzd26, iZzd, iZzd2));
                            }
                            zzakk zzakkVar2 = new zzakk(iZzd13, zZzp, iZzd14, iZzd15, iZzd16, iZzd17, iZzd18, iZzd19, iZzd20, iZzd21, sparseArray2);
                            if (zzakiVar3.zzb == 0 && (zzakkVar = (zzakk) zzakmVar.zzc.get(zzakkVar2.zza)) != null) {
                                int i7 = 0;
                                while (true) {
                                    SparseArray sparseArray3 = zzakkVar.zzj;
                                    if (i7 < sparseArray3.size()) {
                                        zzakkVar2.zzj.put(sparseArray3.keyAt(i7), (zzakl) sparseArray3.valueAt(i7));
                                        i7++;
                                    }
                                }
                            }
                            zzakmVar.zzc.put(zzakkVar2.zza, zzakkVar2);
                        }
                        break;
                    case 18:
                        if (iZzd7 == zzakmVar.zza) {
                            zzakf zzakfVarZzd = zzd(zzejVar, iZzd8);
                            zzakmVar.zzd.put(zzakfVarZzd.zza, zzakfVarZzd);
                        } else if (iZzd7 == zzakmVar.zzb) {
                            zzakf zzakfVarZzd2 = zzd(zzejVar, iZzd8);
                            zzakmVar.zzf.put(zzakfVarZzd2.zza, zzakfVarZzd2);
                        }
                        break;
                    case 19:
                        if (iZzd7 == zzakmVar.zza) {
                            zzakh zzakhVarZze = zze(zzejVar);
                            zzakmVar.zze.put(zzakhVarZze.zza, zzakhVarZze);
                        } else if (iZzd7 == zzakmVar.zzb) {
                            zzakh zzakhVarZze2 = zze(zzejVar);
                            zzakmVar.zzg.put(zzakhVarZze2.zza, zzakhVarZze2);
                        }
                        break;
                    case 20:
                        if (iZzd7 == zzakmVar.zza) {
                            zzejVar.zzn(4);
                            boolean zZzp2 = zzejVar.zzp();
                            zzejVar.zzn(3);
                            int iZzd27 = zzejVar.zzd(16);
                            int iZzd28 = zzejVar.zzd(16);
                            if (zZzp2) {
                                int iZzd29 = zzejVar.zzd(16);
                                iZzd3 = zzejVar.zzd(16);
                                iZzd5 = zzejVar.zzd(16);
                                iZzd4 = zzejVar.zzd(16);
                                i3 = iZzd29;
                            } else {
                                iZzd3 = iZzd27;
                                iZzd4 = iZzd28;
                                i3 = 0;
                                iZzd5 = 0;
                            }
                            zzakmVar.zzh = new zzakg(iZzd27, iZzd28, i3, iZzd3, iZzd5, iZzd4);
                        }
                        break;
                }
                zzejVar.zzo(iZzb - zzejVar.zzb());
            }
        }
        zzakm zzakmVar2 = this.zzi;
        zzaki zzakiVar4 = zzakmVar2.zzi;
        if (zzakiVar4 == null) {
            zzajsVar = new zzajs(zzfxr.zzm(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakg zzakgVar = zzakmVar2.zzh;
            if (zzakgVar == null) {
                zzakgVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakgVar.zza + 1 != bitmap.getWidth() || zzakgVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzakgVar.zza + 1, zzakgVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzakiVar4.zzc;
            for (int i8 = 0; i8 < sparseArray4.size(); i8++) {
                this.zzf.save();
                zzakj zzakjVar = (zzakj) sparseArray4.valueAt(i8);
                zzakk zzakkVar3 = (zzakk) this.zzi.zzc.get(sparseArray4.keyAt(i8));
                int i9 = zzakjVar.zza + zzakgVar.zzc;
                int i10 = zzakjVar.zzb + zzakgVar.zze;
                this.zzf.clipRect(i9, i10, Math.min(zzakkVar3.zzc + i9, zzakgVar.zzd), Math.min(zzakkVar3.zzd + i10, zzakgVar.zzf));
                zzakf zzakfVar = (zzakf) this.zzi.zzd.get(zzakkVar3.zzf);
                if (zzakfVar == null) {
                    zzakfVar = (zzakf) this.zzi.zzf.get(zzakkVar3.zzf);
                    if (zzakfVar == null) {
                        zzakfVar = this.zzh;
                    }
                }
                SparseArray sparseArray5 = zzakkVar3.zzj;
                for (int i11 = 0; i11 < sparseArray5.size(); i11++) {
                    int iKeyAt = sparseArray5.keyAt(i11);
                    zzakl zzaklVar = (zzakl) sparseArray5.valueAt(i11);
                    zzakh zzakhVar = (zzakh) this.zzi.zze.get(iKeyAt);
                    if (zzakhVar == null) {
                        zzakhVar = (zzakh) this.zzi.zzg.get(iKeyAt);
                    }
                    if (zzakhVar != null) {
                        Paint paint = zzakhVar.zzb ? null : this.zzd;
                        int i12 = zzakkVar3.zze;
                        int i13 = i9 + zzaklVar.zza;
                        int i14 = i10 + zzaklVar.zzb;
                        Canvas canvas = this.zzf;
                        int[] iArr = i12 == 3 ? zzakfVar.zzd : i12 == 2 ? zzakfVar.zzc : zzakfVar.zzb;
                        zzf(zzakhVar.zzc, iArr, i12, i13, i14, paint, canvas);
                        zzf(zzakhVar.zzd, iArr, i12, i13, i14 + 1, paint, canvas);
                    }
                }
                float f3 = i10;
                float f4 = i9;
                if (zzakkVar3.zzb) {
                    int i15 = zzakkVar3.zze;
                    this.zze.setColor(i15 == 3 ? zzakfVar.zzd[zzakkVar3.zzg] : i15 == 2 ? zzakfVar.zzc[zzakkVar3.zzh] : zzakfVar.zzb[zzakkVar3.zzi]);
                    f = f3;
                    f2 = f4;
                    this.zzf.drawRect(f2, f, zzakkVar3.zzc + i9, zzakkVar3.zzd + i10, this.zze);
                } else {
                    f = f3;
                    f2 = f4;
                }
                zzcz zzczVar = new zzcz();
                zzczVar.zzc(Bitmap.createBitmap(this.zzj, i9, i10, zzakkVar3.zzc, zzakkVar3.zzd));
                zzczVar.zzh(f2 / zzakgVar.zza);
                zzczVar.zzi(0);
                zzczVar.zze(f / zzakgVar.zzb, 0);
                zzczVar.zzf(0);
                zzczVar.zzk(zzakkVar3.zzc / zzakgVar.zza);
                zzczVar.zzd(zzakkVar3.zzd / zzakgVar.zzb);
                arrayList.add(zzczVar.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
            }
            zzajsVar = new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdnVar.zza(zzajsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zzb() {
        zzakm zzakmVar = this.zzi;
        zzakmVar.zzc.clear();
        zzakmVar.zzd.clear();
        zzakmVar.zze.clear();
        zzakmVar.zzf.clear();
        zzakmVar.zzg.clear();
        zzakmVar.zzh = null;
        zzakmVar.zzi = null;
    }
}
