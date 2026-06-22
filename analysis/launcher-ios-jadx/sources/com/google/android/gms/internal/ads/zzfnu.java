package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfnu extends zzfnv {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfnu(zzfnn zzfnnVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnnVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
