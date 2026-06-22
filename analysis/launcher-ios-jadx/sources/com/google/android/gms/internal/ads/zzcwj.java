package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import defpackage.ed2;
import defpackage.hd2;
import defpackage.n42;
import defpackage.t82;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwj extends t82 {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzeey zzh;
    private final Bundle zzi;

    public zzcwj(zzfel zzfelVar, String str, zzeey zzeeyVar, zzfeo zzfeoVar, String str2) {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
        String string = null;
        this.zzb = zzfelVar == null ? null : zzfelVar.zzab;
        this.zzc = str2;
        this.zzd = zzfeoVar == null ? null : zzfeoVar.zzb;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                string = zzfelVar.zzv.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = string != null ? string : str;
        this.zze = zzeeyVar.zzc();
        this.zzh = zzeeyVar;
        hd2.B.j.getClass();
        this.zzf = System.currentTimeMillis() / 1000;
        zzbbn zzbbnVar = zzbbw.zzgf;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || zzfeoVar == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfeoVar.zzk;
        }
        this.zzg = (!((Boolean) n42Var.c.zza(zzbbw.zzir)).booleanValue() || zzfeoVar == null || TextUtils.isEmpty(zzfeoVar.zzi)) ? "" : zzfeoVar.zzi;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    @Override // defpackage.u82
    public final Bundle zze() {
        return this.zzi;
    }

    @Override // defpackage.u82
    public final ed2 zzf() {
        zzeey zzeeyVar = this.zzh;
        if (zzeeyVar != null) {
            return zzeeyVar.zza();
        }
        return null;
    }

    @Override // defpackage.u82
    public final String zzg() {
        return this.zza;
    }

    @Override // defpackage.u82
    public final String zzh() {
        return this.zzc;
    }

    @Override // defpackage.u82
    public final String zzi() {
        return this.zzb;
    }

    @Override // defpackage.u82
    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
