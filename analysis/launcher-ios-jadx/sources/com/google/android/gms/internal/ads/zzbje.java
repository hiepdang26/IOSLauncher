package com.google.android.gms.internal.ads;

import defpackage.e9;
import defpackage.h42;
import defpackage.k92;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbje implements zzbix {
    static final Map zza;
    private final h42 zzb;
    private final zzbrk zzc;
    private final zzbrr zzd;

    static {
        String[] strArr = {"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"};
        Integer[] numArr = {1, 2, 3, 4, 5, 6, 7};
        e9 e9Var = new e9(7);
        for (int i = 0; i < 7; i++) {
            e9Var.put(strArr[i], numArr[i]);
        }
        zza = Collections.unmodifiableMap(e9Var);
    }

    public zzbje(h42 h42Var, zzbrk zzbrkVar, zzbrr zzbrrVar) {
        this.zzb = h42Var;
        this.zzc = zzbrkVar;
        this.zzd = zzbrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        int iIntValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i = 6;
        if (iIntValue != 5) {
            if (iIntValue != 7) {
                if (!this.zzb.b()) {
                    this.zzb.a(null);
                    return;
                }
                if (iIntValue == 1) {
                    this.zzc.zzb(map);
                    return;
                }
                if (iIntValue == 3) {
                    new zzbrn(zzcejVar, map).zzb();
                    return;
                }
                if (iIntValue == 4) {
                    new zzbrh(zzcejVar, map).zzc();
                    return;
                } else if (iIntValue != 5) {
                    if (iIntValue == 6) {
                        this.zzc.zza(true);
                        return;
                    } else if (iIntValue != 7) {
                        k92.g("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean z = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzcejVar == null) {
            k92.h("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            i = z ? -1 : 14;
        }
        zzcejVar.zzau(i);
    }
}
