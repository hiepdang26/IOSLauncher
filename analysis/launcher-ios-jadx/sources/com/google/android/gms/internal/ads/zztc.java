package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zztc {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01e2, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e5, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01f1, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01fd, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0209, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0215, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0221, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x022d, code lost:
    
        r20 = 32;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0239 A[PHI: r20
  0x0239: PHI (r20v9 int) = (r20v1 int), (r20v2 int), (r20v3 int), (r20v4 int), (r20v5 int), (r20v6 int), (r20v7 int), (r20v10 int) binds: [B:131:0x0235, B:128:0x0229, B:125:0x021d, B:122:0x0211, B:119:0x0205, B:116:0x01f9, B:113:0x01ed, B:111:0x01e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzaf r26) {
        /*
            Method dump skipped, instruction units count: 2214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztc.zza(com.google.android.gms.internal.ads.zzaf):android.util.Pair");
    }

    public static zzsf zzb() {
        List listZze = zze("audio/raw", false, false);
        if (listZze.isEmpty()) {
            return null;
        }
        return (zzsf) listZze.get(0);
    }

    public static String zzc(zzaf zzafVar) {
        Pair pairZza;
        if ("audio/eac3-joc".equals(zzafVar.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzafVar.zzm) || (pairZza = zza(zzafVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairZza.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        if (iIntValue == 1024) {
            return "video/av01";
        }
        return null;
    }

    public static List zzd(zzsq zzsqVar, zzaf zzafVar, boolean z, boolean z2) {
        String strZzc = zzc(zzafVar);
        return strZzc == null ? zzfxr.zzm() : zze(strZzc, z, z2);
    }

    public static synchronized List zze(String str, boolean z, boolean z2) {
        try {
            zzsu zzsuVar = new zzsu(str, z, z2);
            HashMap map = zzc;
            List list = (List) map.get(zzsuVar);
            if (list != null) {
                return list;
            }
            int i = zzet.zza;
            ArrayList arrayListZzh = zzh(zzsuVar, new zzta(z, z2));
            if (z && arrayListZzh.isEmpty() && zzet.zza <= 23) {
                arrayListZzh = zzh(zzsuVar, new zzsz(null));
                if (!arrayListZzh.isEmpty()) {
                    zzea.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzsf) arrayListZzh.get(0)).zza);
                }
            }
            if ("audio/raw".equals(str)) {
                if (zzet.zza < 26 && zzet.zzb.equals("R9") && arrayListZzh.size() == 1 && ((zzsf) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    arrayListZzh.add(zzsf.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
                }
                zzi(arrayListZzh, new zztb() { // from class: com.google.android.gms.internal.ads.zzss
                    @Override // com.google.android.gms.internal.ads.zztb
                    public final int zza(Object obj) {
                        int i2 = zztc.zza;
                        String str2 = ((zzsf) obj).zza;
                        if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                            return 1;
                        }
                        return (zzet.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                    }
                });
            }
            if (zzet.zza < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsf) arrayListZzh.get(0)).zza)) {
                arrayListZzh.add((zzsf) arrayListZzh.remove(0));
            }
            zzfxr zzfxrVarZzk = zzfxr.zzk(arrayListZzh);
            map.put(zzsuVar, zzfxrVarZzk);
            return zzfxrVarZzk;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static List zzf(zzsq zzsqVar, zzaf zzafVar, boolean z, boolean z2) {
        List listZze = zze(zzafVar.zzm, z, z2);
        List listZzd = zzd(zzsqVar, zzafVar, z, z2);
        zzfxo zzfxoVar = new zzfxo();
        zzfxoVar.zzh(listZze);
        zzfxoVar.zzh(listZzd);
        return zzfxoVar.zzi();
    }

    public static List zzg(List list, final zzaf zzafVar) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zztb() { // from class: com.google.android.gms.internal.ads.zzst
            @Override // com.google.android.gms.internal.ads.zztb
            public final int zza(Object obj) {
                int i = zztc.zza;
                return ((zzsf) obj).zzd(zzafVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x017f A[Catch: Exception -> 0x0173, TRY_LEAVE, TryCatch #2 {Exception -> 0x0173, blocks: (B:85:0x013b, B:91:0x0152, B:97:0x0166, B:99:0x016c, B:103:0x017f), top: B:157:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0194 A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:108:0x018a, B:110:0x0194, B:122:0x01c5, B:113:0x01a0, B:115:0x01b0, B:117:0x01b8), top: B:155:0x018a }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a0 A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:108:0x018a, B:110:0x0194, B:122:0x01c5, B:113:0x01a0, B:115:0x01b0, B:117:0x01b8), top: B:155:0x018a }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0220 A[Catch: Exception -> 0x0033, TRY_ENTER, TryCatch #3 {Exception -> 0x0033, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:13:0x0036, B:17:0x0044, B:23:0x0054, B:25:0x005c, B:27:0x0064, B:29:0x006e, B:31:0x0078, B:33:0x0080, B:35:0x0088, B:37:0x0090, B:39:0x0098, B:41:0x00a0, B:43:0x00a8, B:47:0x00b4, B:49:0x00bc, B:51:0x00c4, B:53:0x00cc, B:141:0x021a, B:144:0x0220, B:146:0x0226, B:147:0x0242, B:148:0x0265, B:56:0x00d5, B:57:0x00d8, B:59:0x00e0, B:62:0x00eb, B:64:0x00f3, B:69:0x0101, B:71:0x0109, B:74:0x0114, B:76:0x011c, B:79:0x0127, B:81:0x012f), top: B:159:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0242 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016c A[Catch: Exception -> 0x0173, TryCatch #2 {Exception -> 0x0173, blocks: (B:85:0x013b, B:91:0x0152, B:97:0x0166, B:99:0x016c, B:103:0x017f), top: B:157:0x013b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzsu r23, com.google.android.gms.internal.ads.zzsx r24) throws com.google.android.gms.internal.ads.zzsw {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztc.zzh(com.google.android.gms.internal.ads.zzsu, com.google.android.gms.internal.ads.zzsx):java.util.ArrayList");
    }

    private static void zzi(List list, final zztb zztbVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzsr
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zztc.zza;
                zztb zztbVar2 = zztbVar;
                return zztbVar2.zza(obj2) - zztbVar2.zza(obj);
            }
        });
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzet.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzbn.zzg(str)) {
            return true;
        }
        String strZza = zzfuf.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }
}
