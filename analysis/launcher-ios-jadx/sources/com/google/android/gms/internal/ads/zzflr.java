package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzflr {
    private final zzfmc zza;
    private final zzfmc zzb;
    private final boolean zzc;
    private final zzflv zzd;
    private final zzfly zze;

    private zzflr(zzflv zzflvVar, zzfly zzflyVar, zzfmc zzfmcVar, zzfmc zzfmcVar2, boolean z) {
        this.zzd = zzflvVar;
        this.zze = zzflyVar;
        this.zza = zzfmcVar;
        if (zzfmcVar2 == null) {
            this.zzb = zzfmc.NONE;
        } else {
            this.zzb = zzfmcVar2;
        }
        this.zzc = z;
    }

    public static zzflr zza(zzflv zzflvVar, zzfly zzflyVar, zzfmc zzfmcVar, zzfmc zzfmcVar2, boolean z) {
        zzfnj.zzc(zzflvVar, "CreativeType is null");
        zzfnj.zzc(zzflyVar, "ImpressionType is null");
        zzfnj.zzc(zzfmcVar, "Impression owner is null");
        if (zzfmcVar == zzfmc.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (zzflvVar == zzflv.DEFINED_BY_JAVASCRIPT && zzfmcVar == zzfmc.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (zzflyVar == zzfly.DEFINED_BY_JAVASCRIPT && zzfmcVar == zzfmc.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new zzflr(zzflvVar, zzflyVar, zzfmcVar, zzfmcVar2, z);
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfnf.zze(jSONObject, "impressionOwner", this.zza);
        zzfnf.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfnf.zze(jSONObject, "creativeType", this.zzd);
        zzfnf.zze(jSONObject, "impressionType", this.zze);
        zzfnf.zze(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.zzc));
        return jSONObject;
    }
}
