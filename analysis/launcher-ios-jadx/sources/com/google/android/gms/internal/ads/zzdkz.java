package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzdkz implements zzgcf {
    final /* synthetic */ zzdla zza;

    public zzdkz(zzdla zzdlaVar) {
        this.zza = zzdlaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzeI)).booleanValue()) {
            hd2.B.g.zzw(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcej zzcejVar = (zzcej) list.get(0);
            if (zzcejVar != null) {
                this.zza.zzb(zzcejVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzeI)).booleanValue()) {
                hd2.B.g.zzw(e, "omid native display exp");
            }
        }
    }
}
