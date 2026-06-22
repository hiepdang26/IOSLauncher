package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.ly0;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyk extends zzdch implements zzbhn {
    private final Bundle zzb;

    public zzcyk(Set set) {
        super(set);
        this.zzb = new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcyj
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((ly0) obj).onAdMetadataChanged();
            }
        });
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
