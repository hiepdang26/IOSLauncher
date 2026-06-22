package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.k92;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzccw implements zzbix {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            k92.h("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzccv zzccyVar;
        int i;
        zzcbk zzcbkVar = (zzcbk) obj;
        if (k92.j(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            k92.d("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcco zzccoVar = hd2.B.z;
        if (map.containsKey("abort")) {
            if (zzccoVar.zzd(zzcbkVar)) {
                return;
            }
            k92.h("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcbj zzcbjVar = new zzcbj((String) map.get("flags"));
        boolean z = zzcbjVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            zzccn zzccnVarZza = null;
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    i = 0;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            strArr2[i2] = jSONArray.getString(i2);
                        } catch (JSONException unused) {
                            k92.h("Malformed demuxed URL list for precache: ".concat(str2));
                            strArr = null;
                        }
                    }
                    strArr = strArr2;
                } catch (JSONException unused2) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (strArr == null) {
                strArr = new String[1];
                strArr[i] = str;
            }
            if (z) {
                Iterator it = zzccoVar.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zzccn zzccnVar = (zzccn) it.next();
                    if (zzccnVar.zza == zzcbkVar && str.equals(zzccnVar.zze())) {
                        zzccnVarZza = zzccnVar;
                        break;
                    }
                }
            } else {
                zzccnVarZza = zzccoVar.zza(zzcbkVar);
            }
            if (zzccnVarZza != null) {
                k92.h("Precache task is already running.");
                return;
            }
            if (zzcbkVar.zzj() == null) {
                k92.h("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = Integer.valueOf(i);
            }
            if (numZzb != null) {
                zzcbkVar.zzA(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzcbkVar.zzy(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzcbkVar.zzx(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzcch zzcchVar = zzcbkVar.zzj().b;
            if (iIntValue > 0) {
                int i3 = zzcbjVar.zzg;
                int iZzu = zzcbb.zzu();
                zzccyVar = iZzu < i3 ? new zzcde(zzcbkVar, zzcbjVar) : iZzu < zzcbjVar.zzb ? new zzcdb(zzcbkVar, zzcbjVar) : new zzccz(zzcbkVar);
            } else {
                zzccyVar = new zzccy(zzcbkVar);
            }
            new zzccn(zzcbkVar, zzccyVar, str, strArr).zzb();
        } else {
            zzccn zzccnVarZza2 = zzccoVar.zza(zzcbkVar);
            if (zzccnVarZza2 == null) {
                k92.h("Precache must specify a source.");
                return;
            }
            zzccyVar = zzccnVarZza2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzccyVar.zzs(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzccyVar.zzr(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzccyVar.zzp(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzccyVar.zzq(numZzb8.intValue());
        }
    }
}
