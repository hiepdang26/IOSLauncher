package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.n42;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzdhv implements zzbix {
    private final WeakReference zza;

    public /* synthetic */ zzdhv(zzdhy zzdhyVar, zzdhu zzdhuVar) {
        this.zza = new WeakReference(zzdhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzdhy zzdhyVar = (zzdhy) this.zza.get();
        if (zzdhyVar == null) {
            return;
        }
        zzdhyVar.zzh.onAdClicked();
        if (((Boolean) n42.d.c.zza(zzbbw.zzjR)).booleanValue()) {
            zzdhyVar.zzi.zzdG();
            if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                return;
            }
            zzdhyVar.zzi.zzdf();
        }
    }
}
