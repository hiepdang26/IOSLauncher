package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzama implements zzack {
    private final zzamb zza;
    private final zzek zzb;
    private final zzek zzc;
    private final zzej zzd;
    private zzacn zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzama() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) {
        zzdi.zzb(this.zze);
        int iZza = zzaclVar.zza(this.zzb.zzM(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzO(new zzadh(-9223372036854775807L, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        this.zzb.zzK(0);
        this.zzb.zzJ(iZza);
        if (!this.zzh) {
            this.zza.zzd(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zza(this.zzb);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zze = zzacnVar;
        this.zza.zzb(zzacnVar, new zzans(RtlSpacingHelper.UNDEFINED, 0, 1));
        zzacnVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzh = false;
        this.zza.zze();
        this.zzf = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        int i = 0;
        while (true) {
            zzaby zzabyVar = (zzaby) zzaclVar;
            zzabyVar.zzm(this.zzc.zzM(), 0, 10, false);
            this.zzc.zzK(0);
            if (this.zzc.zzo() != 4801587) {
                break;
            }
            this.zzc.zzL(3);
            int iZzl = this.zzc.zzl();
            i += iZzl + 10;
            zzabyVar.zzl(iZzl, false);
        }
        zzaclVar.zzj();
        zzaby zzabyVar2 = (zzaby) zzaclVar;
        zzabyVar2.zzl(i, false);
        if (this.zzg == -1) {
            this.zzg = i;
        }
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        do {
            zzabyVar2.zzm(this.zzc.zzM(), 0, 2, false);
            this.zzc.zzK(0);
            if (zzamb.zzf(this.zzc.zzq())) {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                zzabyVar2.zzm(this.zzc.zzM(), 0, 4, false);
                this.zzd.zzl(14);
                int iZzd = this.zzd.zzd(13);
                if (iZzd <= 6) {
                    i2++;
                    zzaclVar.zzj();
                    zzabyVar2.zzl(i2, false);
                } else {
                    zzabyVar2.zzl(iZzd - 6, false);
                    i4 += iZzd;
                }
            } else {
                i2++;
                zzaclVar.zzj();
                zzabyVar2.zzl(i2, false);
            }
            i3 = 0;
            i4 = 0;
        } while (i2 - i < 8192);
        return false;
    }

    public zzama(int i) {
        this.zza = new zzamb(true, null, 0);
        this.zzb = new zzek(2048);
        this.zzg = -1L;
        zzek zzekVar = new zzek(10);
        this.zzc = zzekVar;
        byte[] bArrZzM = zzekVar.zzM();
        this.zzd = new zzej(bArrZzM, bArrZzM.length);
    }
}
