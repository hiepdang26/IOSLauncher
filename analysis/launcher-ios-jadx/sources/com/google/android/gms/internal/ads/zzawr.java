package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzawr extends zzaxd {
    public zzawr(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "WfvM4SeNDVyFarUKUVpVTE2MRQkjnaN4GpgwC5lMrmyQkCennlTSSkgCAZvzOVXK", "Kq6mcF8LH4HqXGyg5/DR3VvLtDExNTPXoCRIPhkdOGM=", zzaroVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        Boolean bool = (Boolean) n42.d.c.zza(zzbbw.zzcu);
        bool.booleanValue();
        zzauv zzauvVar = new zzauv((String) this.zze.invoke(null, this.zza.zzb(), bool));
        synchronized (this.zzd) {
            this.zzd.zzj(zzauvVar.zza);
            this.zzd.zzC(zzauvVar.zzb);
        }
    }
}
