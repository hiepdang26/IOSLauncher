package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hs0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzehp implements zzeez {
    private final Context zza;
    private final zzdhl zzb;
    private final Executor zzc;

    public zzehp(Context context, zzdhl zzdhlVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdhlVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfex zzfexVar, int i) {
        return zzfexVar.zza.zza.zzg.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn, zzeir {
        zzdjb zzdjbVarZzah;
        zzbox zzboxVarZzD = ((zzfge) zzeewVar.zzb).zzD();
        zzboy zzboyVarZzE = ((zzfge) zzeewVar.zzb).zzE();
        zzbpb zzbpbVarZzd = ((zzfge) zzeewVar.zzb).zzd();
        if (zzbpbVarZzd != null && zzc(zzfexVar, 6)) {
            zzdjbVarZzah = zzdjb.zzt(zzbpbVarZzd);
        } else if (zzboxVarZzD != null && zzc(zzfexVar, 6)) {
            zzdjbVarZzah = zzdjb.zzai(zzboxVarZzD);
        } else if (zzboxVarZzD != null && zzc(zzfexVar, 2)) {
            zzdjbVarZzah = zzdjb.zzag(zzboxVarZzD);
        } else if (zzboyVarZzE != null && zzc(zzfexVar, 6)) {
            zzdjbVarZzah = zzdjb.zzaj(zzboyVarZzE);
        } else {
            if (zzboyVarZzE == null || !zzc(zzfexVar, 1)) {
                throw new zzeir(1, "No native ad mappers");
            }
            zzdjbVarZzah = zzdjb.zzah(zzboyVarZzE);
        }
        zzffg zzffgVar = zzfexVar.zza.zza;
        if (!zzffgVar.zzg.contains(Integer.toString(zzdjbVarZzah.zzc()))) {
            throw new zzeir(1, "No corresponding native ad listener");
        }
        zzdjd zzdjdVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdjn(zzdjbVarZzah), new zzdle(zzboyVarZzE, zzboxVarZzD, zzbpbVarZzd));
        ((zzegp) zzeewVar.zzc).zzc(zzdjdVarZze.zzk());
        zzdjdVarZze.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzc);
        return zzdjdVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        zzfge zzfgeVar = (zzfge) zzeewVar.zzb;
        zzffg zzffgVar = zzfexVar.zza.zza;
        String string = zzfelVar.zzv.toString();
        String strB = hs0.B(zzfelVar.zzs);
        zzbos zzbosVar = (zzbos) zzeewVar.zzc;
        zzffg zzffgVar2 = zzfexVar.zza.zza;
        zzfgeVar.zzp(this.zza, zzffgVar.zzd, string, strB, zzbosVar, zzffgVar2.zzi, zzffgVar2.zzg);
    }
}
