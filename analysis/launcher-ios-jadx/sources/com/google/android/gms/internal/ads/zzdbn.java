package com.google.android.gms.internal.ads;

import defpackage.u6;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbn extends zzdch implements zzbhp {
    public zzdbn(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final synchronized void zzb(final String str, final String str2) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzdbm
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((u6) obj).onAppEvent(str, str2);
            }
        });
    }
}
