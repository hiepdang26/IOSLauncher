package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzepc implements zzevo {
    private final Executor zza;
    private final zzbze zzb;

    public zzepc(Executor executor, zzbze zzbzeVar) {
        this.zza = executor;
        this.zzb = zzbzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return ((Boolean) n42.d.c.zza(zzbbw.zzcv)).booleanValue() ? zzgcj.zzh(null) : zzgcj.zzm(this.zzb.zzk(), new zzful() { // from class: com.google.android.gms.internal.ads.zzepb
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                final ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new zzevn() { // from class: com.google.android.gms.internal.ads.zzepa
                    @Override // com.google.android.gms.internal.ads.zzevn
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putStringArrayList("android_permissions", arrayList);
                    }
                };
            }
        }, this.zza);
    }
}
