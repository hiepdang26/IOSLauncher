package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.n42;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyc {
    public static Uri zza(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    public static String zzb(Uri uri, Context context, Map map) {
        hd2 hd2Var = hd2.B;
        if (!hd2Var.x.zzp(context)) {
            return uri.toString();
        }
        String strZza = hd2Var.x.zza(context);
        if (strZza == null) {
            return uri.toString();
        }
        zzbbn zzbbnVar = zzbbw.zzZ;
        n42 n42Var = n42.d;
        String str = (String) n42Var.c.zza(zzbbnVar);
        String string = uri.toString();
        if (((Boolean) n42Var.c.zza(zzbbw.zzY)).booleanValue() && string.contains(str)) {
            hd2Var.x.zzj(context, strZza, (Map) map.get("_ac"));
            return zzd(string, context).replace(str, strZza);
        }
        if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            if (!((Boolean) n42Var.c.zza(zzbbw.zzX)).booleanValue()) {
                String string2 = zza(zzd(string, context), "fbs_aeid", strZza).toString();
                hd2Var.x.zzj(context, strZza, (Map) map.get("_ac"));
                return string2;
            }
        }
        return string;
    }

    public static String zzc(String str, Context context, boolean z, Map map) {
        zzbya zzbyaVar;
        String strZza;
        zzbbn zzbbnVar = zzbbw.zzag;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && !z) {
            return str;
        }
        hd2 hd2Var = hd2.B;
        if (!hd2Var.x.zzp(context) || TextUtils.isEmpty(str) || (strZza = (zzbyaVar = hd2Var.x).zza(context)) == null) {
            return str;
        }
        zzbbn zzbbnVar2 = zzbbw.zzZ;
        zzbbu zzbbuVar = n42Var.c;
        String str2 = (String) zzbbuVar.zza(zzbbnVar2);
        boolean zBooleanValue = ((Boolean) zzbbuVar.zza(zzbbw.zzY)).booleanValue();
        cd2 cd2Var = hd2Var.c;
        if (zBooleanValue && str.contains(str2)) {
            cd2Var.getClass();
            if (cd2.u(str, cd2Var.a, (String) n42Var.c.zza(zzbbw.zzV))) {
                zzbyaVar.zzj(context, strZza, (Map) map.get("_ac"));
                return zzd(str, context).replace(str2, strZza);
            }
            cd2Var.getClass();
            if (!cd2.u(str, cd2Var.b, (String) n42Var.c.zza(zzbbw.zzW))) {
                return str;
            }
            zzbyaVar.zzk(context, strZza, (Map) map.get("_ai"));
            return zzd(str, context).replace(str2, strZza);
        }
        if (str.contains("fbs_aeid") || ((Boolean) zzbbuVar.zza(zzbbw.zzX)).booleanValue()) {
            return str;
        }
        cd2Var.getClass();
        if (cd2.u(str, cd2Var.a, (String) n42Var.c.zza(zzbbw.zzV))) {
            zzbyaVar.zzj(context, strZza, (Map) map.get("_ac"));
            return zza(zzd(str, context), "fbs_aeid", strZza).toString();
        }
        cd2Var.getClass();
        if (!cd2.u(str, cd2Var.b, (String) n42Var.c.zza(zzbbw.zzW))) {
            return str;
        }
        zzbyaVar.zzk(context, strZza, (Map) map.get("_ai"));
        return zza(zzd(str, context), "fbs_aeid", strZza).toString();
    }

    private static String zzd(String str, Context context) {
        hd2 hd2Var = hd2.B;
        String strZzd = hd2Var.x.zzd(context);
        String strZzb = hd2Var.x.zzb(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strZzd)) {
            str = zza(str, "gmp_app_id", strZzd).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strZzb)) ? str : zza(str, "fbs_aiid", strZzb).toString();
    }
}
