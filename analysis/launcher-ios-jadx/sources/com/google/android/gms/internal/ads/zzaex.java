package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzaex implements zzack {
    private zzacn zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzagr zzg;
    private zzacl zzh;
    private zzafa zzi;
    private zzaiq zzj;
    private final zzek zza = new zzek(6);
    private long zzf = -1;

    private final int zza(zzacl zzaclVar) {
        this.zza.zzH(2);
        ((zzaby) zzaclVar).zzm(this.zza.zzM(), 0, 2, false);
        return this.zza.zzq();
    }

    private final void zzg() {
        zzacn zzacnVar = this.zzb;
        zzacnVar.getClass();
        zzacnVar.zzD();
        this.zzb.zzO(new zzadh(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010e  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r26, com.google.android.gms.internal.ads.zzadf r27) throws com.google.android.gms.internal.ads.zzbo, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instruction units count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaex.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
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
        this.zzb = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzaiq zzaiqVar = this.zzj;
            zzaiqVar.getClass();
            zzaiqVar.zzi(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        if (zza(zzaclVar) != 65496) {
            return false;
        }
        int iZza = zza(zzaclVar);
        this.zzd = iZza;
        if (iZza == 65504) {
            this.zza.zzH(2);
            zzaby zzabyVar = (zzaby) zzaclVar;
            zzabyVar.zzm(this.zza.zzM(), 0, 2, false);
            zzabyVar.zzl(this.zza.zzq() - 2, false);
            iZza = zza(zzaclVar);
            this.zzd = iZza;
        }
        if (iZza == 65505) {
            zzaby zzabyVar2 = (zzaby) zzaclVar;
            zzabyVar2.zzl(2, false);
            this.zza.zzH(6);
            zzabyVar2.zzm(this.zza.zzM(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
        }
        return false;
    }
}
