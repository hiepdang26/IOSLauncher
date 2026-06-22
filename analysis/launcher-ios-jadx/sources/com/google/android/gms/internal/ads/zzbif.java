package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hd2;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbif implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            k92.a("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzftj zzftjVarZzl = zzftk.zzl();
        zzftjVarZzl.zzb((String) map.get("appId"));
        zzftjVarZzl.zzh(zzcejVar.getWidth());
        zzftjVarZzl.zzg(zzcejVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzftjVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzftjVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzftjVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzftjVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzftjVarZzl.zza((String) map.get("enifd"));
        }
        try {
            hd2.B.q.d(zzcejVar, zzftjVarZzl.zzi());
        } catch (NullPointerException e) {
            hd2.B.g.zzw(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            k92.a("Missing parameters for LMD Overlay show request");
        }
    }
}
