package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnd {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzgnd(zzgmz zzgmzVar, zzgnc zzgncVar) {
        this.zza = new HashMap(zzgmzVar.zza);
        this.zzb = new HashMap(zzgmzVar.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzgnk) this.zzb.get(cls)).zza();
        }
        throw new GeneralSecurityException(uo.t("No input primitive class for ", cls.toString(), " available"));
    }

    public final Object zzb(zzgdy zzgdyVar, Class cls) throws GeneralSecurityException {
        zzgnb zzgnbVar = new zzgnb(zzgdyVar.getClass(), cls, null);
        if (this.zza.containsKey(zzgnbVar)) {
            return ((zzgmx) this.zza.get(zzgnbVar)).zza(zzgdyVar);
        }
        throw new GeneralSecurityException(uo.t("No PrimitiveConstructor for ", zzgnbVar.toString(), " available"));
    }

    public final Object zzc(zzgnj zzgnjVar, Class cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzgnk zzgnkVar = (zzgnk) this.zzb.get(cls);
        if (zzgnjVar.zzd().equals(zzgnkVar.zza()) && zzgnkVar.zza().equals(zzgnjVar.zzd())) {
            return zzgnkVar.zzc(zzgnjVar);
        }
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    }
}
