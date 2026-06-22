package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhm implements zzle, zzlh {
    private final int zzb;
    private zzli zzd;
    private int zze;
    private zznz zzf;
    private zzdj zzg;
    private int zzh;
    private zzvx zzi;
    private zzaf[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzlg zzq;
    private final Object zza = new Object();
    private final zzjz zzc = new zzjz();
    private long zzm = Long.MIN_VALUE;
    private zzcc zzp = zzcc.zza;

    public zzhm(int i) {
        this.zzb = i;
    }

    private final void zzZ(long j, boolean z) {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    public void zzA() {
    }

    public final void zzB() {
        zzlg zzlgVar;
        synchronized (this.zza) {
            zzlgVar = this.zzq;
        }
        if (zzlgVar != null) {
            zzlgVar.zza(this);
        }
    }

    public void zzC() {
    }

    public void zzD() {
    }

    public void zzE() {
    }

    public void zzF(zzaf[] zzafVarArr, long j, long j2, zzui zzuiVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzG() {
        zzdi.zzf(this.zzh == 0);
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzH(zzaf[] zzafVarArr, zzvx zzvxVar, long j, long j2, zzui zzuiVar) {
        zzdi.zzf(!this.zzn);
        this.zzi = zzvxVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzafVarArr;
        this.zzk = j2;
        zzF(zzafVarArr, j, j2, zzuiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzI() {
        zzdi.zzf(this.zzh == 0);
        zzjz zzjzVar = this.zzc;
        zzjzVar.zzb = null;
        zzjzVar.zza = null;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzJ(long j) {
        zzZ(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzK() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzL(zzlg zzlgVar) {
        synchronized (this.zza) {
            this.zzq = zzlgVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public /* synthetic */ void zzM(float f, float f2) {
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzN(zzcc zzccVar) {
        if (zzet.zzG(this.zzp, zzccVar)) {
            return;
        }
        this.zzp = zzccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzO() {
        zzdi.zzf(this.zzh == 1);
        this.zzh = 2;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzP() {
        zzdi.zzf(this.zzh == 2);
        this.zzh = 1;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final boolean zzQ() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final boolean zzR() {
        return this.zzn;
    }

    public final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        return zzvxVar.zze();
    }

    public final zzaf[] zzT() {
        zzaf[] zzafVarArr = this.zzj;
        zzafVarArr.getClass();
        return zzafVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzle, com.google.android.gms.internal.ads.zzlh
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final int zzcV() {
        return this.zzh;
    }

    public final int zzcW(zzjz zzjzVar, zzhd zzhdVar, int i) {
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        int iZza = zzvxVar.zza(zzjzVar, zzhdVar, i);
        if (iZza == -4) {
            if (zzhdVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhdVar.zze + this.zzk;
            zzhdVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
            return iZza;
        }
        if (iZza == -5) {
            zzaf zzafVar = zzjzVar.zza;
            zzafVar.getClass();
            long j2 = zzafVar.zzq;
            if (j2 != Long.MAX_VALUE) {
                zzad zzadVarZzb = zzafVar.zzb();
                zzadVarZzb.zzab(j2 + this.zzk);
                zzjzVar.zza = zzadVarZzb.zzad();
                return -5;
            }
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final long zzcX() {
        return this.zzm;
    }

    public final zzjz zzcY() {
        zzjz zzjzVar = this.zzc;
        zzjzVar.zzb = null;
        zzjzVar.zza = null;
        return zzjzVar;
    }

    public final int zzd(long j) {
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        return zzvxVar.zzb(j - this.zzk);
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public int zze() {
        return 0;
    }

    public final long zzf() {
        return this.zzl;
    }

    public final zzdj zzh() {
        zzdj zzdjVar = this.zzg;
        zzdjVar.getClass();
        return zzdjVar;
    }

    public final zzhw zzi(Throwable th, zzaf zzafVar, boolean z, int i) {
        int i2;
        if (zzafVar == null || this.zzo) {
            i2 = 4;
        } else {
            this.zzo = true;
            try {
                int iZzY = zzY(zzafVar) & 7;
                this.zzo = false;
                i2 = iZzY;
            } catch (zzhw unused) {
                this.zzo = false;
                i2 = 4;
            } catch (Throwable th2) {
                this.zzo = false;
                throw th2;
            }
        }
        return zzhw.zzb(th, zzU(), this.zze, zzafVar, i2, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public zzkg zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final zzlh zzl() {
        return this;
    }

    public final zzli zzm() {
        zzli zzliVar = this.zzd;
        zzliVar.getClass();
        return zzliVar;
    }

    public final zznz zzn() {
        zznz zznzVar = this.zzf;
        zznzVar.getClass();
        return zznzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final zzvx zzo() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzq() {
        zzdi.zzf(this.zzh == 1);
        zzjz zzjzVar = this.zzc;
        zzjzVar.zzb = null;
        zzjzVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzr(zzli zzliVar, zzaf[] zzafVarArr, zzvx zzvxVar, long j, boolean z, boolean z2, long j2, long j3, zzui zzuiVar) {
        zzdi.zzf(this.zzh == 0);
        this.zzd = zzliVar;
        this.zzh = 1;
        zzx(z, z2);
        zzH(zzafVarArr, zzvxVar, j2, j3, zzuiVar);
        zzZ(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public /* synthetic */ void zzs() {
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public void zzt(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzu(int i, zznz zznzVar, zzdj zzdjVar) {
        this.zze = i;
        this.zzf = zznzVar;
        this.zzg = zzdjVar;
        zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public final void zzv() {
        zzvx zzvxVar = this.zzi;
        zzvxVar.getClass();
        zzvxVar.zzd();
    }

    public void zzw() {
        throw null;
    }

    public void zzx(boolean z, boolean z2) {
    }

    public void zzy() {
    }

    public void zzz(long j, boolean z) {
        throw null;
    }
}
