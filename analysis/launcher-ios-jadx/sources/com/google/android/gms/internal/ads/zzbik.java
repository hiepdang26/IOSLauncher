package com.google.android.gms.internal.ads;

import defpackage.hd2;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbik implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfuf.zzc("true", str) && !zzfuf.zzc("false", str)) {
                return;
            }
            zzfsc.zzi(zzcejVar.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e) {
            hd2.B.g.zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
