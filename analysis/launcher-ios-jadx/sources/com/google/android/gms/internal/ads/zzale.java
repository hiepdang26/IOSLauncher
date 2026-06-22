package com.google.android.gms.internal.ads;

import android.text.Layout;

/* JADX INFO: loaded from: classes.dex */
final class zzale {
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private float zzk;
    private String zzl;
    private Layout.Alignment zzo;
    private Layout.Alignment zzp;
    private zzakx zzr;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private int zzm = -1;
    private int zzn = -1;
    private int zzq = -1;
    private float zzs = Float.MAX_VALUE;

    public final zzale zzA(boolean z) {
        this.zzq = z ? 1 : 0;
        return this;
    }

    public final zzale zzB(zzakx zzakxVar) {
        this.zzr = zzakxVar;
        return this;
    }

    public final zzale zzC(boolean z) {
        this.zzg = z ? 1 : 0;
        return this;
    }

    public final String zzD() {
        return this.zza;
    }

    public final String zzE() {
        return this.zzl;
    }

    public final boolean zzF() {
        return this.zzq == 1;
    }

    public final boolean zzG() {
        return this.zze;
    }

    public final boolean zzH() {
        return this.zzc;
    }

    public final boolean zzI() {
        return this.zzf == 1;
    }

    public final boolean zzJ() {
        return this.zzg == 1;
    }

    public final float zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzs;
    }

    public final int zzc() {
        if (this.zze) {
            return this.zzd;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int zzd() {
        if (this.zzc) {
            return this.zzb;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final int zze() {
        return this.zzj;
    }

    public final int zzf() {
        return this.zzn;
    }

    public final int zzg() {
        return this.zzm;
    }

    public final int zzh() {
        int i = this.zzh;
        if (i == -1 && this.zzi == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.zzi == 1 ? 2 : 0);
    }

    public final Layout.Alignment zzi() {
        return this.zzp;
    }

    public final Layout.Alignment zzj() {
        return this.zzo;
    }

    public final zzakx zzk() {
        return this.zzr;
    }

    public final zzale zzl(zzale zzaleVar) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzaleVar != null) {
            if (!this.zzc && zzaleVar.zzc) {
                zzo(zzaleVar.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzaleVar.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzaleVar.zzi;
            }
            if (this.zza == null && (str = zzaleVar.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzaleVar.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzaleVar.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzaleVar.zzn;
            }
            if (this.zzo == null && (alignment2 = zzaleVar.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzaleVar.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzaleVar.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzaleVar.zzj;
                this.zzk = zzaleVar.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzaleVar.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzaleVar.zzs;
            }
            if (!this.zze && zzaleVar.zze) {
                zzm(zzaleVar.zzd);
            }
            if (this.zzm == -1 && (i = zzaleVar.zzm) != -1) {
                this.zzm = i;
            }
        }
        return this;
    }

    public final zzale zzm(int i) {
        this.zzd = i;
        this.zze = true;
        return this;
    }

    public final zzale zzn(boolean z) {
        this.zzh = z ? 1 : 0;
        return this;
    }

    public final zzale zzo(int i) {
        this.zzb = i;
        this.zzc = true;
        return this;
    }

    public final zzale zzp(String str) {
        this.zza = str;
        return this;
    }

    public final zzale zzq(float f) {
        this.zzk = f;
        return this;
    }

    public final zzale zzr(int i) {
        this.zzj = i;
        return this;
    }

    public final zzale zzs(String str) {
        this.zzl = str;
        return this;
    }

    public final zzale zzt(boolean z) {
        this.zzi = z ? 1 : 0;
        return this;
    }

    public final zzale zzu(boolean z) {
        this.zzf = z ? 1 : 0;
        return this;
    }

    public final zzale zzv(Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final zzale zzw(int i) {
        this.zzn = i;
        return this;
    }

    public final zzale zzx(int i) {
        this.zzm = i;
        return this;
    }

    public final zzale zzy(float f) {
        this.zzs = f;
        return this;
    }

    public final zzale zzz(Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }
}
