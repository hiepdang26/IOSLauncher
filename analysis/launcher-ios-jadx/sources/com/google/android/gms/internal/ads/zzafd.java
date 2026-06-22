package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
final class zzafd {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        r7 = -9223372036854775807L;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzaez zza(java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafd.zza(java.lang.String):com.google.android.gms.internal.ads.zzaez");
    }

    private static zzfxr zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        zzfxo zzfxoVar = new zzfxo();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzeu.zzc(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZza = zzeu.zza(xmlPullParser, strConcat2);
                String strZza2 = zzeu.zza(xmlPullParser, strConcat3);
                String strZza3 = zzeu.zza(xmlPullParser, strConcat4);
                String strZza4 = zzeu.zza(xmlPullParser, strConcat5);
                if (strZza == null || strZza2 == null) {
                    return zzfxr.zzm();
                }
                zzfxoVar.zzf(new zzaey(strZza, strZza2, strZza3 != null ? Long.parseLong(strZza3) : 0L, strZza4 != null ? Long.parseLong(strZza4) : 0L));
            }
        } while (!zzeu.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfxoVar.zzi();
    }
}
