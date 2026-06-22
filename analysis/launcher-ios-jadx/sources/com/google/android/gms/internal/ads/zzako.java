package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzako {
    private final zzek zza = new zzek();
    private final int[] zzb = new int[MotionScene.Transition.TransitionOnClick.JUMP_TO_END];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    public static /* bridge */ /* synthetic */ void zzb(zzako zzakoVar, zzek zzekVar, int i) {
        int iZzo;
        if (i < 4) {
            return;
        }
        zzekVar.zzL(3);
        int i2 = i - 4;
        if ((zzekVar.zzm() & 128) != 0) {
            if (i2 < 7 || (iZzo = zzekVar.zzo()) < 4) {
                return;
            }
            zzakoVar.zzh = zzekVar.zzq();
            zzakoVar.zzi = zzekVar.zzq();
            zzakoVar.zza.zzH(iZzo - 4);
            i2 = i - 11;
        }
        zzek zzekVar2 = zzakoVar.zza;
        int iZzd = zzekVar2.zzd();
        int iZze = zzekVar2.zze();
        if (iZzd >= iZze || i2 <= 0) {
            return;
        }
        int iMin = Math.min(i2, iZze - iZzd);
        zzekVar.zzG(zzekVar2.zzM(), iZzd, iMin);
        zzakoVar.zza.zzK(iZzd + iMin);
    }

    public static /* bridge */ /* synthetic */ void zzc(zzako zzakoVar, zzek zzekVar, int i) {
        if (i < 19) {
            return;
        }
        zzakoVar.zzd = zzekVar.zzq();
        zzakoVar.zze = zzekVar.zzq();
        zzekVar.zzL(11);
        zzakoVar.zzf = zzekVar.zzq();
        zzakoVar.zzg = zzekVar.zzq();
    }

    public static /* bridge */ /* synthetic */ void zzd(zzako zzakoVar, zzek zzekVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzekVar.zzL(2);
        int i2 = 0;
        Arrays.fill(zzakoVar.zzb, 0);
        int i3 = i / 5;
        int i4 = 0;
        while (i4 < i3) {
            int iZzm = zzekVar.zzm();
            int iZzm2 = zzekVar.zzm();
            int iZzm3 = zzekVar.zzm();
            int iZzm4 = zzekVar.zzm();
            int iZzm5 = zzekVar.zzm();
            double d = iZzm2;
            int[] iArr = zzakoVar.zzb;
            double d2 = iZzm3 - 128;
            int iMax = Math.max(i2, Math.min((int) ((1.402d * d2) + d), 255)) << 16;
            double d3 = iZzm4 - 128;
            iArr[iZzm] = Math.max(0, Math.min((int) ((d3 * 1.772d) + d), 255)) | (iZzm5 << 24) | iMax | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8);
            i4++;
            i2 = 0;
        }
        zzakoVar.zzc = true;
    }

    public final zzdb zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzek zzekVar = this.zza;
        if (zzekVar.zze() == 0 || zzekVar.zzd() != zzekVar.zze() || !this.zzc) {
            return null;
        }
        zzekVar.zzK(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iZzm = this.zza.zzm();
            if (iZzm != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[iZzm];
            } else {
                int iZzm2 = this.zza.zzm();
                if (iZzm2 != 0) {
                    int iZzm3 = iZzm2 & 63;
                    if ((iZzm2 & 64) != 0) {
                        iZzm3 = (iZzm3 << 8) | this.zza.zzm();
                    }
                    i = iZzm3 + i3;
                    Arrays.fill(iArr, i3, i, (iZzm2 & 128) == 0 ? this.zzb[0] : this.zzb[this.zza.zzm()]);
                }
            }
            i3 = i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcz zzczVar = new zzcz();
        zzczVar.zzc(bitmapCreateBitmap);
        zzczVar.zzh(this.zzf / this.zzd);
        zzczVar.zzi(0);
        zzczVar.zze(this.zzg / this.zze, 0);
        zzczVar.zzf(0);
        zzczVar.zzk(this.zzh / this.zzd);
        zzczVar.zzd(this.zzi / this.zze);
        return zzczVar.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzH(0);
        this.zzc = false;
    }
}
