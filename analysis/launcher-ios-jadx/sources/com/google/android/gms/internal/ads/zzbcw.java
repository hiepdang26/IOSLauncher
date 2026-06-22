package com.google.android.gms.internal.ads;

import defpackage.e41;
import defpackage.f41;
import defpackage.k92;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
final class zzbcw extends f41 {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbcx zzb;

    public zzbcw(zzbcx zzbcxVar, String str) {
        this.zza = str;
        this.zzb = zzbcxVar;
    }

    @Override // defpackage.f41
    public final void onFailure(String str) {
        k92.h("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbcx zzbcxVar = this.zzb;
            zzbcxVar.zze.a(zzbcxVar.zzc(this.zza, str).toString());
        } catch (JSONException unused) {
            k92.f();
        }
    }

    @Override // defpackage.f41
    public final void onSuccess(e41 e41Var) {
        String str = (String) e41Var.a.g;
        try {
            zzbcx zzbcxVar = this.zzb;
            zzbcxVar.zze.a(zzbcxVar.zzd(this.zza, str).toString());
        } catch (JSONException unused) {
            k92.f();
        }
    }
}
