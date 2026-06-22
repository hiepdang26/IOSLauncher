package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgbr extends zzgbt {
    public zzgbr(zzfxm zzfxmVar, boolean z) {
        super(zzfxmVar, z);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgbt
    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList arrayListZza = zzfyh.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgbs zzgbsVar = (zzgbs) it.next();
            arrayListZza.add(zzgbsVar != null ? zzgbsVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZza);
    }
}
