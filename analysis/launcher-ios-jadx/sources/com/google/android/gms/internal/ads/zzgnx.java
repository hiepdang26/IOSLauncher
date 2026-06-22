package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnx {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzgnx(zzgnr zzgnrVar, zzgnw zzgnwVar) {
        this.zza = new HashMap(zzgnrVar.zza);
        this.zzb = new HashMap(zzgnrVar.zzb);
        this.zzc = new HashMap(zzgnrVar.zzc);
        this.zzd = new HashMap(zzgnrVar.zzd);
    }

    public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) throws GeneralSecurityException {
        zzgnt zzgntVar = new zzgnt(zzgnqVar.getClass(), zzgnqVar.zzd(), null);
        if (this.zzb.containsKey(zzgntVar)) {
            return ((zzglc) this.zzb.get(zzgntVar)).zza(zzgnqVar, zzgerVar);
        }
        throw new GeneralSecurityException(uo.t("No Key Parser for requested key type ", zzgntVar.toString(), " available"));
    }

    public final zzgen zzb(zzgnq zzgnqVar) throws GeneralSecurityException {
        zzgnt zzgntVar = new zzgnt(zzgnqVar.getClass(), zzgnqVar.zzd(), null);
        if (this.zzd.containsKey(zzgntVar)) {
            return ((zzgmp) this.zzd.get(zzgntVar)).zza(zzgnqVar);
        }
        throw new GeneralSecurityException(uo.t("No Parameters Parser for requested key type ", zzgntVar.toString(), " available"));
    }

    public final zzgnq zzc(zzgdy zzgdyVar, Class cls, zzger zzgerVar) throws GeneralSecurityException {
        zzgnv zzgnvVar = new zzgnv(zzgdyVar.getClass(), cls, null);
        if (this.zza.containsKey(zzgnvVar)) {
            return ((zzglg) this.zza.get(zzgnvVar)).zza(zzgdyVar, zzgerVar);
        }
        throw new GeneralSecurityException(uo.t("No Key serializer for ", zzgnvVar.toString(), " available"));
    }

    public final zzgnq zzd(zzgen zzgenVar, Class cls) throws GeneralSecurityException {
        zzgnv zzgnvVar = new zzgnv(zzgenVar.getClass(), cls, null);
        if (this.zzc.containsKey(zzgnvVar)) {
            return ((zzgmt) this.zzc.get(zzgnvVar)).zza(zzgenVar);
        }
        throw new GeneralSecurityException(uo.t("No Key Format serializer for ", zzgnvVar.toString(), " available"));
    }

    public final boolean zzi(zzgnq zzgnqVar) {
        return this.zzb.containsKey(new zzgnt(zzgnqVar.getClass(), zzgnqVar.zzd(), null));
    }

    public final boolean zzj(zzgnq zzgnqVar) {
        return this.zzd.containsKey(new zzgnt(zzgnqVar.getClass(), zzgnqVar.zzd(), null));
    }
}
