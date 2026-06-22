package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgzn implements zzhae {
    private final zzgzj zza;
    private final zzhas zzb;
    private final boolean zzc;
    private final zzgxj zzd;

    private zzgzn(zzhas zzhasVar, zzgxj zzgxjVar, zzgzj zzgzjVar) {
        this.zzb = zzhasVar;
        this.zzc = zzgzjVar instanceof zzgxu;
        this.zzd = zzgxjVar;
        this.zza = zzgzjVar;
    }

    public static zzgzn zzc(zzhas zzhasVar, zzgxj zzgxjVar, zzgzj zzgzjVar) {
        return new zzgzn(zzhasVar, zzgxjVar, zzgzjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final int zza(Object obj) {
        int iZzb = ((zzgxy) obj).zzt.zzb();
        return this.zzc ? iZzb + ((zzgxu) obj).zza.zzd() : iZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final int zzb(Object obj) {
        int iHashCode = ((zzgxy) obj).zzt.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzgxu) obj).zza.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final Object zze() {
        zzgzj zzgzjVar = this.zza;
        return zzgzjVar instanceof zzgxy ? ((zzgxy) zzgzjVar).zzbj() : zzgzjVar.zzcZ().zzbs();
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzg(Object obj, Object obj2) {
        zzhag.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhag.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzh(Object obj, zzgzw zzgzwVar, zzgxi zzgxiVar) {
        this.zzb.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgwa zzgwaVar) {
        zzgxy zzgxyVar = (zzgxy) obj;
        if (zzgxyVar.zzt == zzhat.zzc()) {
            zzgxyVar.zzt = zzhat.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzj(Object obj, zzhbh zzhbhVar) {
        Iterator itZzf = ((zzgxu) obj).zza.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzgxm zzgxmVar = (zzgxm) entry.getKey();
            if (zzgxmVar.zzc() != zzhbg.MESSAGE || zzgxmVar.zze() || zzgxmVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzgyr) {
                zzhbhVar.zzw(zzgxmVar.zza(), ((zzgyr) entry).zza().zzb());
            } else {
                zzhbhVar.zzw(zzgxmVar.zza(), entry.getValue());
            }
        }
        ((zzgxy) obj).zzt.zzk(zzhbhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzgxy) obj).zzt.equals(((zzgxy) obj2).zzt)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgxu) obj).zza.equals(((zzgxu) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final boolean zzl(Object obj) {
        return ((zzgxu) obj).zza.zzi();
    }
}
