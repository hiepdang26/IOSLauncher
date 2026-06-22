package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class zzazh implements Comparator {
    public zzazh(zzazi zzaziVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzayw zzaywVar = (zzayw) obj;
        zzayw zzaywVar2 = (zzayw) obj2;
        if (zzaywVar.zzd() < zzaywVar2.zzd()) {
            return -1;
        }
        if (zzaywVar.zzd() > zzaywVar2.zzd()) {
            return 1;
        }
        if (zzaywVar.zzb() < zzaywVar2.zzb()) {
            return -1;
        }
        if (zzaywVar.zzb() > zzaywVar2.zzb()) {
            return 1;
        }
        float fZza = (zzaywVar.zza() - zzaywVar.zzd()) * (zzaywVar.zzc() - zzaywVar.zzb());
        float fZza2 = (zzaywVar2.zza() - zzaywVar2.zzd()) * (zzaywVar2.zzc() - zzaywVar2.zzb());
        if (fZza > fZza2) {
            return -1;
        }
        return fZza < fZza2 ? 1 : 0;
    }
}
