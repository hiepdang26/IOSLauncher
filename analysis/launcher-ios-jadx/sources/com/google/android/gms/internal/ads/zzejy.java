package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.k92;
import defpackage.n42;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzejy implements zzeev {
    private final zzelc zza;
    private final zzdqb zzb;

    public zzejy(zzelc zzelcVar, zzdqb zzdqbVar) {
        this.zza = zzelcVar;
        this.zzb = zzdqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeev
    public final zzeew zza(String str, JSONObject jSONObject) {
        zzbql zzbqlVarZzb;
        if (((Boolean) n42.d.c.zza(zzbbw.zzbu)).booleanValue()) {
            try {
                zzbqlVarZzb = this.zzb.zzb(str);
            } catch (RemoteException unused) {
                k92.f();
                zzbqlVarZzb = null;
            }
        } else {
            zzbqlVarZzb = this.zza.zza(str);
        }
        if (zzbqlVarZzb == null) {
            return null;
        }
        return new zzeew(zzbqlVarZzb, new zzegp(), str);
    }
}
