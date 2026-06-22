package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import defpackage.b22;
import defpackage.h42;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.sd2;
import defpackage.tc2;
import defpackage.x32;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjj implements zzbix {
    private final h42 zza;
    private final zzdsk zzb;
    private final zzbrk zzd;
    private final zzedh zze;
    private final zzcni zzf;
    private sd2 zzg = null;
    private final zzgcu zzh = zzbzo.zzf;
    private final tc2 zzc = new tc2(null);

    public zzbjj(h42 h42Var, zzbrk zzbrkVar, zzedh zzedhVar, zzdsk zzdskVar, zzcni zzcniVar) {
        this.zza = h42Var;
        this.zzd = zzbrkVar;
        this.zze = zzedhVar;
        this.zzb = zzdskVar;
        this.zzf = zzcniVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    public static Uri zzc(Context context, zzauo zzauoVar, Uri uri, View view, Activity activity, zzffk zzffkVar) {
        if (zzauoVar != null) {
            try {
                if (!((Boolean) n42.d.c.zza(zzbbw.zzla)).booleanValue() || zzffkVar == null) {
                    if (zzauoVar.zze(uri)) {
                        return zzauoVar.zza(uri, context, view, activity);
                    }
                } else if (zzauoVar.zze(uri)) {
                    return zzffkVar.zza(uri, context, view, activity);
                }
            } catch (zzaup unused) {
            } catch (Exception e) {
                hd2.B.g.zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            }
        }
        return uri;
    }

    public static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException unused) {
            "Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString()));
            k92.f();
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.String r26, defpackage.b22 r27, java.util.Map r28, java.lang.String r29) {
        /*
            Method dump skipped, instruction units count: 980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzh(java.lang.String, b22, java.util.Map, java.lang.String):void");
    }

    private final void zzi(Context context, String str, String str2) {
        this.zze.zzc(str);
        zzdsk zzdskVar = this.zzb;
        if (zzdskVar != null) {
            zzeds.zzd(context, zzdskVar, this.zze, str, "dialog_not_shown", zzfxu.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0140, code lost:
    
        r12 = r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzj(defpackage.b22 r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzj(b22, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbrk zzbrkVar = this.zzd;
        if (zzbrkVar != null) {
            zzbrkVar.zza(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) r6.zza(com.google.android.gms.internal.ads.zzbbw.zzhE)).booleanValue() : ((java.lang.Boolean) r6.zza(com.google.android.gms.internal.ads.zzbbw.zzhD)).booleanValue()) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzl(defpackage.b22 r10, android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjj.zzl(b22, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        String str;
        zzdsk zzdskVar = this.zzb;
        if (zzdskVar == null) {
            return;
        }
        zzdsj zzdsjVarZza = zzdskVar.zza();
        zzdsjVarZza.zzb("action", "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            default:
                str = "WRONG_EXP_SETUP";
                break;
        }
        zzdsjVarZza.zzb("cct_open_status", str);
        zzdsjVarZza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        b22 b22Var = (b22) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcej zzcejVar = (zzcej) b22Var;
        if (zzcejVar.zzD() != null) {
            map2 = zzcejVar.zzD().zzaw;
        }
        String strZzc = zzbyc.zzc(str, zzcejVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            k92.h("Action missing from an open GMSG.");
            return;
        }
        h42 h42Var = this.zza;
        if (h42Var == null || h42Var.b()) {
            zzgcj.zzr((((Boolean) n42.d.c.zza(zzbbw.zzjg)).booleanValue() && this.zzf != null && zzcni.zzj(strZzc)) ? this.zzf.zzb(strZzc, x32.f.e) : zzgcj.zzh(strZzc), new zzbjf(this, map, b22Var, str2), this.zzh);
        } else {
            this.zza.a(strZzc);
        }
    }
}
