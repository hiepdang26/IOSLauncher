package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
final class zzaep extends zzaet {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzaep(zzadp zzadpVar) {
        super(zzadpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final boolean zza(zzek zzekVar) throws zzaes {
        if (this.zzc) {
            zzekVar.zzL(1);
        } else {
            int iZzm = zzekVar.zzm();
            int i = iZzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzm >> 2) & 3];
                zzad zzadVar = new zzad();
                zzadVar.zzX("audio/mpeg");
                zzadVar.zzy(1);
                zzadVar.zzY(i2);
                this.zza.zzl(zzadVar.zzad());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzad zzadVar2 = new zzad();
                zzadVar2.zzX(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzadVar2.zzy(1);
                zzadVar2.zzY(8000);
                this.zza.zzl(zzadVar2.zzad());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzaes(k31.k(i, "Audio format not supported: "));
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final boolean zzb(zzek zzekVar, long j) {
        if (this.zze == 2) {
            int iZzb = zzekVar.zzb();
            this.zza.zzq(zzekVar, iZzb);
            this.zza.zzs(j, 1, iZzb, 0, null);
            return true;
        }
        int iZzm = zzekVar.zzm();
        if (iZzm != 0 || this.zzd) {
            if (this.zze == 10 && iZzm != 1) {
                return false;
            }
            int iZzb2 = zzekVar.zzb();
            this.zza.zzq(zzekVar, iZzb2);
            this.zza.zzs(j, 1, iZzb2, 0, null);
            return true;
        }
        int iZzb3 = zzekVar.zzb();
        byte[] bArr = new byte[iZzb3];
        zzekVar.zzG(bArr, 0, iZzb3);
        zzabf zzabfVarZza = zzabg.zza(bArr);
        zzad zzadVar = new zzad();
        zzadVar.zzX("audio/mp4a-latm");
        zzadVar.zzz(zzabfVarZza.zzc);
        zzadVar.zzy(zzabfVarZza.zzb);
        zzadVar.zzY(zzabfVarZza.zza);
        zzadVar.zzL(Collections.singletonList(bArr));
        this.zza.zzl(zzadVar.zzad());
        this.zzd = true;
        return false;
    }
}
