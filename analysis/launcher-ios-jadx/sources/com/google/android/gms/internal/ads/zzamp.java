package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzamp implements zzamf {
    private zzadp zzb;
    private boolean zzc;
    private int zze;
    private int zzf;
    private final zzek zza = new zzek(10);
    private long zzd = -9223372036854775807L;

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zza(zzek zzekVar) {
        zzdi.zzb(this.zzb);
        if (this.zzc) {
            int iZzb = zzekVar.zzb();
            int i = this.zzf;
            if (i < 10) {
                int iMin = Math.min(iZzb, 10 - i);
                System.arraycopy(zzekVar.zzM(), zzekVar.zzd(), this.zza.zzM(), this.zzf, iMin);
                if (this.zzf + iMin == 10) {
                    this.zza.zzK(0);
                    if (this.zza.zzm() != 73 || this.zza.zzm() != 68 || this.zza.zzm() != 51) {
                        zzea.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    } else {
                        this.zza.zzL(3);
                        this.zze = this.zza.zzl() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZzb, this.zze - this.zzf);
            this.zzb.zzq(zzekVar, iMin2);
            this.zzf += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 5);
        this.zzb = zzadpVarZzw;
        zzad zzadVar = new zzad();
        zzadVar.zzK(zzansVar.zzb());
        zzadVar.zzX("application/id3");
        zzadpVarZzw.zzl(zzadVar.zzad());
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
        int i;
        zzdi.zzb(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            zzdi.zzf(this.zzd != -9223372036854775807L);
            this.zzb.zzs(this.zzd, 1, this.zze, 0, null);
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzc = true;
        this.zzd = j;
        this.zze = 0;
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }
}
