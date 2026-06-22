package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzawt extends zzaxd {
    private List zzh;
    private final Context zzi;

    public zzawt(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, Context context) {
        super(zzavpVar, "/W2ZEuHT/JiI5/Zhh6jV6ATrrvF8IBtmITl+4IJczntAr46Ow/LitCqqOR0RyWN9", "0yxvRSsGg+/BBPRqwe1F54W0T+vv1NRnE+jebtT36Vo=", zzaroVar, i, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        this.zzd.zzW(-1L);
        this.zzd.zzS(-1L);
        Context contextZzb = this.zzi;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, contextZzb);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.zzd) {
            this.zzd.zzW(((Long) this.zzh.get(0)).longValue());
            this.zzd.zzS(((Long) this.zzh.get(1)).longValue());
        }
    }
}
