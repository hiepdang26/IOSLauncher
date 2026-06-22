package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.appcompat.widget.RtlSpacingHelper;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzalr {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.SpannedString zza(java.lang.String r18, java.lang.String r19, java.util.List r20) {
        /*
            Method dump skipped, instruction units count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zza(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    public static zzcz zzb(String str) {
        zzalq zzalqVar = new zzalq();
        zzh(str, zzalqVar);
        return zzalqVar.zza();
    }

    public static zzalk zzc(zzek zzekVar, List list) {
        Charset charset = zzfuj.zzc;
        String strZzy = zzekVar.zzy(charset);
        if (strZzy != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(strZzy);
            if (matcher.matches()) {
                return zze(null, matcher, zzekVar, list);
            }
            String strZzy2 = zzekVar.zzy(charset);
            if (strZzy2 != null) {
                Matcher matcher2 = pattern.matcher(strZzy2);
                if (matcher2.matches()) {
                    return zze(strZzy.trim(), matcher2, zzekVar, list);
                }
            }
        }
        return null;
    }

    private static int zzd(List list, String str, zzalo zzaloVar) {
        List listZzf = zzf(list, str, zzaloVar);
        for (int i = 0; i < listZzf.size(); i++) {
            zzalj zzaljVar = ((zzalp) listZzf.get(i)).zzb;
            if (zzaljVar.zze() != -1) {
                return zzaljVar.zze();
            }
        }
        return -1;
    }

    private static zzalk zze(String str, Matcher matcher, zzek zzekVar, List list) {
        zzalq zzalqVar = new zzalq();
        try {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw null;
            }
            zzalqVar.zza = zzalt.zzb(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                throw null;
            }
            zzalqVar.zzb = zzalt.zzb(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            zzh(strGroup3, zzalqVar);
            StringBuilder sb = new StringBuilder();
            String strZzy = zzekVar.zzy(zzfuj.zzc);
            while (!TextUtils.isEmpty(strZzy)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strZzy.trim());
                strZzy = zzekVar.zzy(zzfuj.zzc);
            }
            zzalqVar.zzc = zza(str, sb.toString(), list);
            return new zzalk(zzalqVar.zza().zzp(), zzalqVar.zza, zzalqVar.zzb);
        } catch (NumberFormatException unused) {
            zzea.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, String str, zzalo zzaloVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzalj zzaljVar = (zzalj) list.get(i);
            int iZzf = zzaljVar.zzf(str, zzaloVar.zza, zzaloVar.zzd, zzaloVar.zzc);
            if (iZzf > 0) {
                arrayList.add(new zzalp(iZzf, zzaljVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzg(java.lang.String r18, com.google.android.gms.internal.ads.zzalo r19, java.util.List r20, android.text.SpannableStringBuilder r21, java.util.List r22) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zzg(java.lang.String, com.google.android.gms.internal.ads.zzalo, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void zzh(String str, zzalq zzalqVar) {
        Matcher matcher = zzb.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i2 = 2;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                byte b = -1;
                if ("line".equals(strGroup)) {
                    int iIndexOf = strGroup2.indexOf(44);
                    if (iIndexOf != -1) {
                        String strSubstring = strGroup2.substring(iIndexOf + 1);
                        switch (strSubstring.hashCode()) {
                            case -1364013995:
                                if (strSubstring.equals("center")) {
                                    b = 1;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring.equals("middle")) {
                                    b = 2;
                                }
                                break;
                            case 100571:
                                if (strSubstring.equals("end")) {
                                    b = 3;
                                }
                                break;
                            case 109757538:
                                if (strSubstring.equals("start")) {
                                    b = 0;
                                }
                                break;
                        }
                        if (b == 0) {
                            i2 = 0;
                        } else if (b == 1 || b == 2) {
                            i2 = 1;
                        } else if (b != 3) {
                            zzea.zzf("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                            i2 = RtlSpacingHelper.UNDEFINED;
                        }
                        zzalqVar.zzg = i2;
                        strGroup2 = strGroup2.substring(0, iIndexOf);
                    }
                    if (strGroup2.endsWith("%")) {
                        zzalqVar.zze = zzalt.zza(strGroup2);
                        zzalqVar.zzf = 0;
                    } else {
                        zzalqVar.zze = Integer.parseInt(strGroup2);
                        zzalqVar.zzf = 1;
                    }
                } else if ("align".equals(strGroup)) {
                    switch (strGroup2.hashCode()) {
                        case -1364013995:
                            if (strGroup2.equals("center")) {
                                b = 2;
                            }
                            break;
                        case -1074341483:
                            if (strGroup2.equals("middle")) {
                                b = 3;
                            }
                            break;
                        case 100571:
                            if (strGroup2.equals("end")) {
                                b = 4;
                            }
                            break;
                        case 3317767:
                            if (strGroup2.equals("left")) {
                                b = 1;
                            }
                            break;
                        case 108511772:
                            if (strGroup2.equals("right")) {
                                b = 5;
                            }
                            break;
                        case 109757538:
                            if (strGroup2.equals("start")) {
                                b = 0;
                            }
                            break;
                    }
                    if (b != 0) {
                        if (b == 1) {
                            i = 4;
                        } else if (b == 2 || b == 3) {
                            i = 2;
                        } else if (b == 4) {
                            i = 3;
                        } else if (b != 5) {
                            zzea.zzf("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                            i = 2;
                        } else {
                            i = 5;
                        }
                    }
                    zzalqVar.zzd = i;
                } else if ("position".equals(strGroup)) {
                    int iIndexOf2 = strGroup2.indexOf(44);
                    if (iIndexOf2 != -1) {
                        String strSubstring2 = strGroup2.substring(iIndexOf2 + 1);
                        switch (strSubstring2.hashCode()) {
                            case -1842484672:
                                if (strSubstring2.equals("line-left")) {
                                    b = 0;
                                }
                                break;
                            case -1364013995:
                                if (strSubstring2.equals("center")) {
                                    b = 2;
                                }
                                break;
                            case -1276788989:
                                if (strSubstring2.equals("line-right")) {
                                    b = 4;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring2.equals("middle")) {
                                    b = 3;
                                }
                                break;
                            case 100571:
                                if (strSubstring2.equals("end")) {
                                    b = 5;
                                }
                                break;
                            case 109757538:
                                if (strSubstring2.equals("start")) {
                                    b = 1;
                                }
                                break;
                        }
                        if (b == 0 || b == 1) {
                            i = 0;
                        } else if (b != 2 && b != 3) {
                            if (b == 4 || b == 5) {
                                i = 2;
                            } else {
                                zzea.zzf("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring2));
                                i = RtlSpacingHelper.UNDEFINED;
                            }
                        }
                        zzalqVar.zzi = i;
                        strGroup2 = strGroup2.substring(0, iIndexOf2);
                    }
                    zzalqVar.zzh = zzalt.zza(strGroup2);
                } else if ("size".equals(strGroup)) {
                    zzalqVar.zzj = zzalt.zza(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    int iHashCode = strGroup2.hashCode();
                    if (iHashCode != 3462) {
                        if (iHashCode == 3642 && strGroup2.equals("rl")) {
                            b = 0;
                        }
                    } else if (strGroup2.equals("lr")) {
                        b = 1;
                    }
                    if (b != 0) {
                        if (b != 1) {
                            zzea.zzf("WebvttCueParser", "Invalid 'vertical' value: ".concat(strGroup2));
                            i = RtlSpacingHelper.UNDEFINED;
                        } else {
                            i = 2;
                        }
                    }
                    zzalqVar.zzk = i;
                } else {
                    zzea.zzf("WebvttCueParser", "Unknown cue setting " + strGroup + ":" + strGroup2);
                }
            } catch (NumberFormatException unused) {
                zzea.zzf("WebvttCueParser", "Skipping bad cue setting: ".concat(String.valueOf(matcher.group())));
            }
        }
    }
}
