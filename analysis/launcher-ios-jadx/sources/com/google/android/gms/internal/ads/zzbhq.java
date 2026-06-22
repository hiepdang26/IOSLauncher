package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.hd2;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhq implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        String str = (String) map.get("action");
        if (!"tick".equals(str)) {
            if ("experiment".equals(str)) {
                String str2 = (String) map.get("value");
                if (TextUtils.isEmpty(str2)) {
                    k92.h("No value given for CSI experiment.");
                    return;
                } else {
                    zzcejVar.zzm().zza().zzd("e", str2);
                    return;
                }
            }
            if ("extra".equals(str)) {
                String str3 = (String) map.get("name");
                String str4 = (String) map.get("value");
                if (TextUtils.isEmpty(str4)) {
                    k92.h("No value given for CSI extra.");
                    return;
                } else if (TextUtils.isEmpty(str3)) {
                    k92.h("No name given for CSI extra.");
                    return;
                } else {
                    zzcejVar.zzm().zza().zzd(str3, str4);
                    return;
                }
            }
            return;
        }
        String str5 = (String) map.get("label");
        String str6 = (String) map.get("start_label");
        String str7 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str5)) {
            k92.h("No label given for CSI tick.");
            return;
        }
        if (TextUtils.isEmpty(str7)) {
            k92.h("No timestamp given for CSI tick.");
            return;
        }
        try {
            long j = Long.parseLong(str7);
            hd2 hd2Var = hd2.B;
            hd2Var.j.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            hd2Var.j.getClass();
            long jElapsedRealtime = (j - jCurrentTimeMillis) + SystemClock.elapsedRealtime();
            if (true == TextUtils.isEmpty(str6)) {
                str6 = "native:view_load";
            }
            zzcejVar.zzm().zzc(str5, str6, jElapsedRealtime);
        } catch (NumberFormatException unused) {
            k92.j(5);
        }
    }
}
