package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmz {
    private final Map zza;
    private final Map zzb;

    private zzgmz() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgmz zza(zzgmx zzgmxVar) throws GeneralSecurityException {
        if (zzgmxVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzgnb zzgnbVar = new zzgnb(zzgmxVar.zzc(), zzgmxVar.zzd(), null);
        if (!this.zza.containsKey(zzgnbVar)) {
            this.zza.put(zzgnbVar, zzgmxVar);
            return this;
        }
        zzgmx zzgmxVar2 = (zzgmx) this.zza.get(zzgnbVar);
        if (zzgmxVar2.equals(zzgmxVar) && zzgmxVar.equals(zzgmxVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgnbVar.toString()));
    }

    public final zzgmz zzb(zzgnk zzgnkVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class clsZzb = zzgnkVar.zzb();
        if (!map.containsKey(clsZzb)) {
            this.zzb.put(clsZzb, zzgnkVar);
            return this;
        }
        zzgnk zzgnkVar2 = (zzgnk) this.zzb.get(clsZzb);
        if (zzgnkVar2.equals(zzgnkVar) && zzgnkVar.equals(zzgnkVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZzb.toString()));
    }

    public /* synthetic */ zzgmz(zzgmy zzgmyVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public /* synthetic */ zzgmz(zzgnd zzgndVar, zzgmy zzgmyVar) {
        this.zza = new HashMap(zzgndVar.zza);
        this.zzb = new HashMap(zzgndVar.zzb);
    }
}
