package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import defpackage.k92;
import defpackage.n42;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqb {
    private final zzfgc zza;
    private final zzdpy zzb;

    public zzdqb(zzfgc zzfgcVar, zzdpy zzdpyVar) {
        this.zza = zzfgcVar;
        this.zzb = zzdpyVar;
    }

    public final zzbom zza() throws RemoteException {
        zzbom zzbomVarZzb = this.zza.zzb();
        if (zzbomVarZzb != null) {
            return zzbomVarZzb;
        }
        k92.h("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbql zzb(String str) {
        zzbql zzbqlVarZzc = zza().zzc(str);
        this.zzb.zzd(str, zzbqlVarZzc);
        return zzbqlVarZzc;
    }

    public final zzfge zzc(String str, JSONObject jSONObject) {
        zzbop zzbopVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbopVarZzb = new zzbpn(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbopVarZzb = new zzbpn(new zzbre());
            } else {
                zzbom zzbomVarZza = zza();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        zzbopVarZzb = zzbomVarZza.zze(string) ? zzbomVarZza.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzbomVarZza.zzd(string) ? zzbomVarZza.zzb(string) : zzbomVarZza.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                    } catch (JSONException unused) {
                        k92.f();
                        zzbopVarZzb = zzbomVarZza.zzb(str);
                    }
                } else {
                    zzbopVarZzb = zzbomVarZza.zzb(str);
                }
            }
            zzfge zzfgeVar = new zzfge(zzbopVarZzb);
            this.zzb.zzc(str, zzfgeVar);
            return zzfgeVar;
        } catch (Throwable th) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzix)).booleanValue()) {
                this.zzb.zzc(str, null);
            }
            throw new zzffn(th);
        }
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
