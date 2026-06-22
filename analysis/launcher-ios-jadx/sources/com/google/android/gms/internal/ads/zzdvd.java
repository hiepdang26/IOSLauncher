package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvd {
    private final zzdun zza;
    private final zzdpy zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    public zzdvd(zzdun zzdunVar, zzdpy zzdpyVar) {
        this.zza = zzdunVar;
        this.zzb = zzdpyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(List list) {
        zzdpx zzdpxVarZza;
        zzdpx zzdpxVarZza2;
        zzbra zzbraVar;
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbkv zzbkvVar = (zzbkv) it.next();
                    zzbbn zzbbnVar = zzbbw.zziw;
                    n42 n42Var = n42.d;
                    String string = (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || (zzdpxVarZza2 = this.zzb.zza(zzbkvVar.zza)) == null || (zzbraVar = zzdpxVarZza2.zzc) == null) ? "" : zzbraVar.toString();
                    String str = string;
                    boolean z = ((Boolean) n42Var.c.zza(zzbbw.zzix)).booleanValue() && (zzdpxVarZza = this.zzb.zza(zzbkvVar.zza)) != null && zzdpxVarZza.zzd;
                    List list2 = this.zzd;
                    String str2 = zzbkvVar.zza;
                    list2.add(new zzdvc(str2, str, this.zzb.zzb(str2), zzbkvVar.zzb ? 1 : 0, zzbkvVar.zzd, zzbkvVar.zzc, z));
                }
                this.zze = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final JSONArray zza() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            try {
                if (!this.zze) {
                    if (!this.zza.zzt()) {
                        zzc();
                        return jSONArray;
                    }
                    zzd(this.zza.zzg());
                }
                Iterator it = this.zzd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((zzdvc) it.next()).zza());
                }
                return jSONArray;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        this.zza.zzs(new zzdvb(this));
    }
}
