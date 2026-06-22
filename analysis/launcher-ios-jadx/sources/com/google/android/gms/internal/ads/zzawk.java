package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzawk extends zzaxd {
    private final Map zzh;
    private final View zzi;
    private final Context zzj;

    public zzawk(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, Map map, View view, Context context) {
        super(zzavpVar, "SKSJAjN3UKeguXyEasCGg04d/yJuUN8XZYgactMp4rfMtHcIJcD0mydl5RKvI49M", "lnMUlT0qopStslq/RfZHkyvg0xAUTVuMPsMot4SEaYA=", zzaroVar, i, 85);
        this.zzh = map;
        this.zzi = view;
        this.zzj = context;
    }

    private final long zzc(int i) {
        Map map = this.zzh;
        Integer numValueOf = Integer.valueOf(i);
        if (map.containsKey(numValueOf)) {
            return ((Long) this.zzh.get(numValueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        long[] jArr = {zzc(1), zzc(2)};
        Context contextZzb = this.zzj;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        long[] jArr2 = (long[]) this.zze.invoke(null, jArr, contextZzb, this.zzi);
        long j = jArr2[0];
        this.zzh.put(1, Long.valueOf(jArr2[1]));
        long j2 = jArr2[2];
        this.zzh.put(2, Long.valueOf(jArr2[3]));
        synchronized (this.zzd) {
            this.zzd.zzv(j);
            this.zzd.zzu(j2);
        }
    }
}
