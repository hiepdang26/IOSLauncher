package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaeq implements zzack {
    private zzacn zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzaep zzo;
    private zzaeu zzp;
    private final zzek zza = new zzek(4);
    private final zzek zzb = new zzek(9);
    private final zzek zzc = new zzek(11);
    private final zzek zzd = new zzek();
    private final zzaer zze = new zzaer();
    private int zzg = 1;

    private final zzek zza(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        if (this.zzl > this.zzd.zzc()) {
            zzek zzekVar = this.zzd;
            int iZzc = zzekVar.zzc();
            zzekVar.zzI(new byte[Math.max(iZzc + iZzc, this.zzl)], 0);
        } else {
            this.zzd.zzK(0);
        }
        this.zzd.zzJ(this.zzl);
        ((zzaby) zzaclVar).zzn(this.zzd.zzM(), 0, this.zzl, false);
        return this.zzd;
    }

    private final void zzg() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzO(new zzadh(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r15, com.google.android.gms.internal.ads.zzadf r16) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeq.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
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
        this.zzf = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzm(this.zza.zzM(), 0, 3, false);
        this.zza.zzK(0);
        if (this.zza.zzo() != 4607062) {
            return false;
        }
        zzabyVar.zzm(this.zza.zzM(), 0, 2, false);
        this.zza.zzK(0);
        if ((this.zza.zzq() & 250) != 0) {
            return false;
        }
        zzabyVar.zzm(this.zza.zzM(), 0, 4, false);
        this.zza.zzK(0);
        int iZzg = this.zza.zzg();
        zzaclVar.zzj();
        zzaby zzabyVar2 = (zzaby) zzaclVar;
        zzabyVar2.zzl(iZzg, false);
        zzabyVar2.zzm(this.zza.zzM(), 0, 4, false);
        this.zza.zzK(0);
        return this.zza.zzg() == 0;
    }
}
