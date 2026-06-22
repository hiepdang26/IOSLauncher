package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgbt extends zzgbi {
    private List zza;

    public zzgbt(zzfxm zzfxmVar, boolean z) {
        super(zzfxmVar, z, true);
        List listZza = zzfxmVar.isEmpty() ? Collections.EMPTY_LIST : zzfyh.zza(zzfxmVar.size());
        for (int i = 0; i < zzfxmVar.size(); i++) {
            listZza.add(null);
        }
        this.zza = listZza;
    }

    public abstract Object zzG(List list);

    @Override // com.google.android.gms.internal.ads.zzgbi
    public final void zzf(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzgbs(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    public final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    public final void zzy(int i) {
        super.zzy(i);
        this.zza = null;
    }
}
