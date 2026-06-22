package com.google.android.gms.internal.ads;

import defpackage.b22;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwo extends zzdch implements b22 {
    public zzcwo(Set set) {
        super(set);
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcwn
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((b22) obj).onAdClicked();
            }
        });
    }
}
