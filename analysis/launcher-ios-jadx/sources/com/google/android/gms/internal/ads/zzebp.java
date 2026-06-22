package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.k92;
import defpackage.n42;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzebp implements zzfio {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfju zzc;
    private final zzfkf zzd;

    public zzebp(String str, zzfkf zzfkfVar, zzfju zzfjuVar) {
        this.zzb = str;
        this.zzd = zzfkfVar;
        this.zzc = zzfjuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfio
    public final Object zza(Object obj) throws zzdwl {
        zzdwl zzdwlVar;
        String strConcat;
        zzebo zzeboVar = (zzebo) obj;
        int iOptInt = zzeboVar.zza.optInt("http_timeout_millis", 60000);
        zzbvd zzbvdVar = zzeboVar.zzb;
        String strJoin = "";
        if (zzbvdVar.zza() != -2) {
            if (zzbvdVar.zza() == 1) {
                if (zzbvdVar.zzh() != null) {
                    strJoin = TextUtils.join(", ", zzbvdVar.zzh());
                    k92.e(strJoin);
                }
                zzdwlVar = new zzdwl(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzdwlVar = new zzdwl(1);
            }
            zzfkf zzfkfVar = this.zzd;
            zzfju zzfjuVar = this.zzc;
            zzfjuVar.zzh(zzdwlVar);
            zzfjuVar.zzg(false);
            zzfkfVar.zza(zzfjuVar);
            throw zzdwlVar;
        }
        HashMap map = new HashMap();
        if (zzeboVar.zzb.zzj() && !TextUtils.isEmpty(this.zzb)) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzaG)).booleanValue()) {
                String str = this.zzb;
                if (TextUtils.isEmpty(str)) {
                    strConcat = "";
                } else {
                    Matcher matcher = zza.matcher(str);
                    strConcat = "";
                    while (matcher.find()) {
                        String strGroup = matcher.group(1);
                        if (strGroup != null) {
                            Locale locale = Locale.ROOT;
                            if (strGroup.toLowerCase(locale).startsWith("id=") || strGroup.toLowerCase(locale).startsWith("ide=")) {
                                if (!TextUtils.isEmpty(strConcat)) {
                                    strConcat = strConcat.concat("; ");
                                }
                                strConcat = strConcat.concat(strGroup);
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(strConcat)) {
                    map.put("Cookie", strConcat);
                }
            } else {
                map.put("Cookie", this.zzb);
            }
        }
        if (zzeboVar.zzb.zzk()) {
            zzebq.zza(map, zzeboVar.zza);
        }
        if (zzeboVar.zzb != null && !TextUtils.isEmpty(zzeboVar.zzb.zzf())) {
            strJoin = zzeboVar.zzb.zzf();
        }
        zzfkf zzfkfVar2 = this.zzd;
        zzfju zzfjuVar2 = this.zzc;
        zzfjuVar2.zzg(true);
        zzfkfVar2.zza(zzfjuVar2);
        return new zzebk(zzeboVar.zzb.zzg(), iOptInt, map, strJoin.getBytes(zzfuj.zzc), "", zzeboVar.zzb.zzk());
    }
}
