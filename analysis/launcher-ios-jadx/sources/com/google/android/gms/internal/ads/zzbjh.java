package com.google.android.gms.internal.ads;

import defpackage.b22;
import defpackage.sd2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjh implements sd2 {
    boolean zza = false;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ b22 zzc;
    final /* synthetic */ Map zzd;
    final /* synthetic */ Map zze;

    public zzbjh(zzbjj zzbjjVar, boolean z, b22 b22Var, Map map, Map map2) {
        this.zzb = z;
        this.zzc = b22Var;
        this.zzd = map;
        this.zze = map2;
    }

    @Override // defpackage.sd2
    public final void zza(boolean z) {
        if (this.zza) {
            return;
        }
        if (z && this.zzb) {
            ((zzdeq) this.zzc).zzdG();
        }
        this.zza = true;
        this.zzd.put((String) this.zze.get("event_id"), Boolean.valueOf(z));
        ((zzbls) this.zzc).zzd("openIntentAsync", this.zzd);
    }

    @Override // defpackage.sd2
    public final void zzb(int i) {
    }
}
