package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaeb implements zzack {
    private final zzek zza;
    private final zzaea zzb;
    private final boolean zzc;
    private final zzajy zzd;
    private int zze;
    private zzacn zzf;
    private zzaec zzg;
    private long zzh;
    private zzaee[] zzi;
    private long zzj;
    private zzaee zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaeb() {
        this(1, zzajy.zza);
    }

    private final zzaee zzg(int i) {
        for (zzaee zzaeeVar : this.zzi) {
            if (zzaeeVar.zzg(i)) {
                return zzaeeVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0306  */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r30, com.google.android.gms.internal.ads.zzadf r31) throws com.google.android.gms.internal.ads.zzbo, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instruction units count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeb.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
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
        this.zze = 0;
        if (this.zzc) {
            zzacnVar = new zzakc(zzacnVar, this.zzd);
        }
        this.zzf = zzacnVar;
        this.zzj = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzaee zzaeeVar : this.zzi) {
            zzaeeVar.zzf(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        ((zzaby) zzaclVar).zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzL(4);
        return this.zza.zzi() == 541677121;
    }

    public zzaeb(int i, zzajy zzajyVar) {
        this.zzd = zzajyVar;
        this.zzc = 1 == (i ^ 1);
        this.zza = new zzek(12);
        this.zzb = new zzaea(null);
        this.zzf = new zzaci();
        this.zzi = new zzaee[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }
}
