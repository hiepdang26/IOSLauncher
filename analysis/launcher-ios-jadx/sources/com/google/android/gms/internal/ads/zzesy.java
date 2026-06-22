package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzesy implements zzevn {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;

    public zzesy(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zza.isEmpty()) {
            bundle.putString("inspector_extras", this.zza);
        }
        bundle.putInt("test_mode", this.zzb ? 1 : 0);
        bundle.putInt("linked_device", this.zzc ? 1 : 0);
        if (this.zzb || this.zzc) {
            zzbbn zzbbnVar = zzbbw.zziq;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                bundle.putInt("risd", !this.zzd ? 1 : 0);
            }
            if (((Boolean) n42Var.c.zza(zzbbw.zziu)).booleanValue()) {
                bundle.putBoolean("collect_response_logs", this.zze);
            }
        }
    }
}
