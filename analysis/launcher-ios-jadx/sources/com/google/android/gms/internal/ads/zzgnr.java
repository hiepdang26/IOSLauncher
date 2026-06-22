package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnr {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgnr() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgnr zza(zzglc zzglcVar) throws GeneralSecurityException {
        zzgnt zzgntVar = new zzgnt(zzglcVar.zzd(), zzglcVar.zzc(), null);
        if (!this.zzb.containsKey(zzgntVar)) {
            this.zzb.put(zzgntVar, zzglcVar);
            return this;
        }
        zzglc zzglcVar2 = (zzglc) this.zzb.get(zzgntVar);
        if (zzglcVar2.equals(zzglcVar) && zzglcVar.equals(zzglcVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgntVar.toString()));
    }

    public final zzgnr zzb(zzglg zzglgVar) throws GeneralSecurityException {
        zzgnv zzgnvVar = new zzgnv(zzglgVar.zzc(), zzglgVar.zzd(), null);
        if (!this.zza.containsKey(zzgnvVar)) {
            this.zza.put(zzgnvVar, zzglgVar);
            return this;
        }
        zzglg zzglgVar2 = (zzglg) this.zza.get(zzgnvVar);
        if (zzglgVar2.equals(zzglgVar) && zzglgVar.equals(zzglgVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgnvVar.toString()));
    }

    public final zzgnr zzc(zzgmp zzgmpVar) throws GeneralSecurityException {
        zzgnt zzgntVar = new zzgnt(zzgmpVar.zzd(), zzgmpVar.zzc(), null);
        if (!this.zzd.containsKey(zzgntVar)) {
            this.zzd.put(zzgntVar, zzgmpVar);
            return this;
        }
        zzgmp zzgmpVar2 = (zzgmp) this.zzd.get(zzgntVar);
        if (zzgmpVar2.equals(zzgmpVar) && zzgmpVar.equals(zzgmpVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgntVar.toString()));
    }

    public final zzgnr zzd(zzgmt zzgmtVar) throws GeneralSecurityException {
        zzgnv zzgnvVar = new zzgnv(zzgmtVar.zzc(), zzgmtVar.zzd(), null);
        if (!this.zzc.containsKey(zzgnvVar)) {
            this.zzc.put(zzgnvVar, zzgmtVar);
            return this;
        }
        zzgmt zzgmtVar2 = (zzgmt) this.zzc.get(zzgnvVar);
        if (zzgmtVar2.equals(zzgmtVar) && zzgmtVar.equals(zzgmtVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgnvVar.toString()));
    }

    public zzgnr(zzgnx zzgnxVar) {
        this.zza = new HashMap(zzgnxVar.zza);
        this.zzb = new HashMap(zzgnxVar.zzb);
        this.zzc = new HashMap(zzgnxVar.zzc);
        this.zzd = new HashMap(zzgnxVar.zzd);
    }
}
