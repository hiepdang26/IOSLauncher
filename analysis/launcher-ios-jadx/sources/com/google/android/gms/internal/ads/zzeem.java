package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzeem {
    private final Context zza;
    private final or1 zzb;
    private final zzfel zzc;
    private final zzcej zzd;
    private zzfmb zze;

    public zzeem(Context context, or1 or1Var, zzfel zzfelVar, zzcej zzcejVar) {
        this.zza = context;
        this.zzb = or1Var;
        this.zzc = zzfelVar;
        this.zzd = zzcejVar;
    }

    public final synchronized void zza(View view) {
        zzfmb zzfmbVar = this.zze;
        if (zzfmbVar != null) {
            hd2.B.w.zzh(zzfmbVar, view);
        }
    }

    public final synchronized void zzb() {
        zzcej zzcejVar;
        if (this.zze == null || (zzcejVar = this.zzd) == null) {
            return;
        }
        zzcejVar.zzd("onSdkImpression", zzfxu.zzd());
    }

    public final synchronized void zzc() {
        zzcej zzcejVar;
        try {
            zzfmb zzfmbVar = this.zze;
            if (zzfmbVar == null || (zzcejVar = this.zzd) == null) {
                return;
            }
            Iterator it = zzcejVar.zzV().iterator();
            while (it.hasNext()) {
                hd2.B.w.zzh(zzfmbVar, (View) it.next());
            }
            this.zzd.zzd("onSdkLoaded", zzfxu.zzd());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzd() {
        return this.zze != null;
    }

    public final synchronized boolean zze(boolean z) {
        if (this.zzc.zzT) {
            zzbbn zzbbnVar = zzbbw.zzez;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                if (((Boolean) n42Var.c.zza(zzbbw.zzeC)).booleanValue() && this.zzd != null) {
                    if (this.zze != null) {
                        k92.h("Omid javascript session service already started for ad.");
                        return false;
                    }
                    Context context = this.zza;
                    hd2 hd2Var = hd2.B;
                    if (!hd2Var.w.zzl(context)) {
                        k92.h("Unable to initialize omid.");
                        return false;
                    }
                    if (this.zzc.zzV.zzb()) {
                        zzfmb zzfmbVarZze = hd2Var.w.zze(this.zzb, this.zzd.zzG(), true);
                        if (zzfmbVarZze == null) {
                            k92.h("Unable to create javascript session service.");
                            return false;
                        }
                        k92.g("Created omid javascript session service.");
                        this.zze = zzfmbVarZze;
                        this.zzd.zzas(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized void zzf(zzcey zzceyVar) {
        zzfmb zzfmbVar = this.zze;
        if (zzfmbVar == null || this.zzd == null) {
            return;
        }
        hd2.B.w.zzm(zzfmbVar, zzceyVar);
        this.zze = null;
        this.zzd.zzas(null);
    }
}
