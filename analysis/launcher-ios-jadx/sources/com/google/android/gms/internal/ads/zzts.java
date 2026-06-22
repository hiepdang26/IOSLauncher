package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzts implements zzvz {
    private final zzfxr zza;
    private long zzb;

    public zzts(List list, List list2) {
        zzfxo zzfxoVar = new zzfxo();
        zzdi.zzd(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            zzfxoVar.zzf(new zztr((zzvz) list.get(i), (List) list2.get(i)));
        }
        this.zza = zzfxoVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            zztr zztrVar = (zztr) this.zza.get(i);
            long jZzb = zztrVar.zzb();
            if ((zztrVar.zza().contains(1) || zztrVar.zza().contains(2) || zztrVar.zza().contains(4)) && jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
            if (jZzb != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzb);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.zzb;
        return j != -9223372036854775807L ? j : jMin2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            long jZzc = ((zztr) this.zza.get(i)).zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j) {
        for (int i = 0; i < this.zza.size(); i++) {
            ((zztr) this.zza.get(i)).zzm(j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        boolean zZzo;
        boolean z = false;
        do {
            long jZzc = zzc();
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            zZzo = false;
            for (int i = 0; i < this.zza.size(); i++) {
                long jZzc2 = ((zztr) this.zza.get(i)).zzc();
                boolean z2 = jZzc2 != Long.MIN_VALUE && jZzc2 <= zzkfVar.zza;
                if (jZzc2 == jZzc || z2) {
                    zZzo |= ((zztr) this.zza.get(i)).zzo(zzkfVar);
                }
            }
            z |= zZzo;
        } while (zZzo);
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        for (int i = 0; i < this.zza.size(); i++) {
            if (((zztr) this.zza.get(i)).zzp()) {
                return true;
            }
        }
        return false;
    }
}
