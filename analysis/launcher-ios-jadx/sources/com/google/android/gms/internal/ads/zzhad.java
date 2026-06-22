package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzhad extends zzgwm {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    private final int zzc;
    private final zzgwm zzd;
    private final zzgwm zze;
    private final int zzf;
    private final int zzg;

    public static zzgwm zzC(zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        if (zzgwmVar2.zzd() == 0) {
            return zzgwmVar;
        }
        if (zzgwmVar.zzd() == 0) {
            return zzgwmVar2;
        }
        int iZzd = zzgwmVar2.zzd() + zzgwmVar.zzd();
        if (iZzd < 128) {
            return zzD(zzgwmVar, zzgwmVar2);
        }
        if (zzgwmVar instanceof zzhad) {
            zzhad zzhadVar = (zzhad) zzgwmVar;
            if (zzgwmVar2.zzd() + zzhadVar.zze.zzd() < 128) {
                return new zzhad(zzhadVar.zzd, zzD(zzhadVar.zze, zzgwmVar2));
            }
            if (zzhadVar.zzd.zzf() > zzhadVar.zze.zzf() && zzhadVar.zzg > zzgwmVar2.zzf()) {
                return new zzhad(zzhadVar.zzd, new zzhad(zzhadVar.zze, zzgwmVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzgwmVar.zzf(), zzgwmVar2.zzf()) + 1) ? new zzhad(zzgwmVar, zzgwmVar2) : zzgzz.zza(new zzgzz(null), zzgwmVar, zzgwmVar2);
    }

    private static zzgwm zzD(zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        int iZzd = zzgwmVar.zzd();
        int iZzd2 = zzgwmVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzgwmVar.zzz(bArr, 0, 0, iZzd);
        zzgwmVar2.zzz(bArr, 0, iZzd, iZzd2);
        return new zzgwk(bArr);
    }

    public static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        return i >= 47 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwm)) {
            return false;
        }
        zzgwm zzgwmVar = (zzgwm) obj;
        if (this.zzc != zzgwmVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzr = zzr();
        int iZzr2 = zzgwmVar.zzr();
        if (iZzr != 0 && iZzr2 != 0 && iZzr != iZzr2) {
            return false;
        }
        zzhaa zzhaaVar = null;
        zzhab zzhabVar = new zzhab(this, zzhaaVar);
        zzgwj zzgwjVarZza = zzhabVar.next();
        zzhab zzhabVar2 = new zzhab(zzgwmVar, zzhaaVar);
        zzgwj zzgwjVarZza2 = zzhabVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iZzd = zzgwjVarZza.zzd() - i;
            int iZzd2 = zzgwjVarZza2.zzd() - i2;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i == 0 ? zzgwjVarZza.zzg(zzgwjVarZza2, i2, iMin) : zzgwjVarZza2.zzg(zzgwjVarZza, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.zzc;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzgwjVarZza = zzhabVar.next();
                i = 0;
            } else {
                i += iMin;
                zzgwjVarZza = zzgwjVarZza;
            }
            if (iMin == iZzd2) {
                zzgwjVarZza2 = zzhabVar2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzgzx(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final byte zza(int i) {
        zzgwm.zzy(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgwm zzk(int i, int i2) {
        int iZzq = zzgwm.zzq(i, i2, this.zzc);
        if (iZzq == 0) {
            return zzgwm.zzb;
        }
        if (iZzq == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzgwm zzgwmVar = this.zzd;
        return new zzhad(zzgwmVar.zzk(i, zzgwmVar.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgwm
    public final zzgww zzl() {
        ArrayList arrayList = new ArrayList();
        Object[] objArr = 0;
        zzhab zzhabVar = new zzhab(this, null);
        while (zzhabVar.hasNext()) {
            arrayList.add(zzhabVar.next().zzn());
        }
        int size = arrayList.size();
        int i = 0;
        int iRemaining = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            iRemaining += byteBuffer.remaining();
            i = byteBuffer.hasArray() ? i | 1 : byteBuffer.isDirect() ? i | 2 : i | 4;
        }
        return i == 2 ? new zzgwq(arrayList, iRemaining, true, objArr == true ? 1 : 0) : zzgww.zzG(new zzgyo(arrayList), MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final ByteBuffer zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zzo(zzgwd zzgwdVar) {
        this.zzd.zzo(zzgwdVar);
        this.zze.zzo(zzgwdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final boolean zzp() {
        zzgwm zzgwmVar = this.zzd;
        zzgwm zzgwmVar2 = this.zze;
        return zzgwmVar2.zzj(zzgwmVar.zzj(0, 0, this.zzf), 0, zzgwmVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    /* JADX INFO: renamed from: zzs */
    public final zzgwh iterator() {
        return new zzgzx(this);
    }

    private zzhad(zzgwm zzgwmVar, zzgwm zzgwmVar2) {
        this.zzd = zzgwmVar;
        this.zze = zzgwmVar2;
        int iZzd = zzgwmVar.zzd();
        this.zzf = iZzd;
        this.zzc = zzgwmVar2.zzd() + iZzd;
        this.zzg = Math.max(zzgwmVar.zzf(), zzgwmVar2.zzf()) + 1;
    }
}
