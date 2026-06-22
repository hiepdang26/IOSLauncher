package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzeoj implements zzevo {
    private final Set zza;

    public zzeoj(Set set) {
        this.zza = set;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzeoi
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", arrayList);
            }
        });
    }
}
