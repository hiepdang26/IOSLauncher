package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.x52;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiw {
    public static final zzbix zza = new zzbix() { // from class: com.google.android.gms.internal.ads.zzbhu
        @Override // com.google.android.gms.internal.ads.zzbix
        public final void zza(Object obj, Map map) {
            zzcfq zzcfqVar = (zzcfq) obj;
            zzbix zzbixVar = zzbiw.zza;
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                k92.h("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzcfqVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                Boolean boolValueOf = Boolean.valueOf(packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) != null);
                map2.put(str2, boolValueOf);
                k92.a("/canOpenURLs;" + str2 + ";" + boolValueOf);
            }
            ((zzbls) zzcfqVar).zzd("openableURLs", map2);
        }
    };
    public static final zzbix zzb = new zzbix() { // from class: com.google.android.gms.internal.ads.zzbhw
        @Override // com.google.android.gms.internal.ads.zzbix
        public final void zza(Object obj, Map map) {
            zzcfq zzcfqVar = (zzcfq) obj;
            zzbix zzbixVar = zzbiw.zza;
            if (!((Boolean) n42.d.c.zza(zzbbw.zzht)).booleanValue()) {
                k92.h("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get("package_name");
            if (TextUtils.isEmpty(str)) {
                k92.h("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap map2 = new HashMap();
            Boolean boolValueOf = Boolean.valueOf(zzcfqVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
            map2.put(str, boolValueOf);
            k92.a("/canOpenApp;" + str + ";" + boolValueOf);
            ((zzbls) zzcfqVar).zzd("openableApp", map2);
        }
    };
    public static final zzbix zzc = new zzbix() { // from class: com.google.android.gms.internal.ads.zzbhz
        @Override // com.google.android.gms.internal.ads.zzbix
        public final void zza(Object obj, Map map) {
            zzbiw.zzb((zzcfq) obj, map);
        }
    };
    public static final zzbix zzd = new zzbio();
    public static final zzbix zze = new zzbip();
    public static final zzbix zzf = new zzbix() { // from class: com.google.android.gms.internal.ads.zzbia
        @Override // com.google.android.gms.internal.ads.zzbix
        public final void zza(Object obj, Map map) {
            zzcfq zzcfqVar = (zzcfq) obj;
            zzbix zzbixVar = zzbiw.zza;
            String str = (String) map.get("u");
            if (str == null) {
                k92.h("URL missing from httpTrack GMSG.");
            } else {
                new x52(zzcfqVar.getContext(), ((zzcfx) zzcfqVar).zzn().g, str).zzb();
            }
        }
    };
    public static final zzbix zzg = new zzbiq();
    public static final zzbix zzh = new zzbir();
    public static final zzbix zzi = new zzbix() { // from class: com.google.android.gms.internal.ads.zzbhy
        @Override // com.google.android.gms.internal.ads.zzbix
        public final void zza(Object obj, Map map) {
            zzcfw zzcfwVar = (zzcfw) obj;
            zzbix zzbixVar = zzbiw.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int i = Integer.parseInt(str);
                int i2 = Integer.parseInt(str2);
                int i3 = Integer.parseInt(str3);
                zzauo zzauoVarZzI = zzcfwVar.zzI();
                if (zzauoVarZzI != null) {
                    zzauoVarZzI.zzc().zzl(i, i2, i3);
                }
            } catch (NumberFormatException unused) {
                k92.h("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbix zzj = new zzbis();
    public static final zzbix zzk = new zzbit();
    public static final zzbix zzl = new zzccj();
    public static final zzbix zzm = new zzcck();
    public static final zzbix zzn = new zzbhq();
    public static final zzbjn zzo = new zzbjn();
    public static final zzbix zzp = new zzbiu();
    public static final zzbix zzq = new zzbiv();
    public static final zzbix zzr = new zzbib();
    public static final zzbix zzs = new zzbic();
    public static final zzbix zzt = new zzbid();
    public static final zzbix zzu = new zzbie();
    public static final zzbix zzv = new zzbif();
    public static final zzbix zzw = new zzbig();
    public static final zzbix zzx = new zzbih();
    public static final zzbix zzy = new zzbii();
    public static final zzbix zzz = new zzbij();
    public static final zzbix zzA = new zzbik();
    public static final zzbix zzB = new zzbim();
    public static final zzbix zzC = new zzbin();

    public static do0 zza(zzcej zzcejVar, String str) {
        Uri uriZza = Uri.parse(str);
        try {
            zzauo zzauoVarZzI = zzcejVar.zzI();
            zzffk zzffkVarZzS = zzcejVar.zzS();
            if (!((Boolean) n42.d.c.zza(zzbbw.zzla)).booleanValue() || zzffkVarZzS == null) {
                if (zzauoVarZzI != null && zzauoVarZzI.zzf(uriZza)) {
                    uriZza = zzauoVarZzI.zza(uriZza, zzcejVar.getContext(), zzcejVar.zzF(), zzcejVar.zzi());
                }
            } else if (zzauoVarZzI != null && zzauoVarZzI.zzf(uriZza)) {
                uriZza = zzffkVarZzS.zza(uriZza, zzcejVar.getContext(), zzcejVar.zzF(), zzcejVar.zzi());
            }
        } catch (zzaup unused) {
            k92.h("Unable to append parameter to URL: ".concat(str));
        }
        Map map = new HashMap();
        if (zzcejVar.zzD() != null) {
            map = zzcejVar.zzD().zzaw;
        }
        final String strZzb = zzbyc.zzb(uriZza, zzcejVar.getContext(), map);
        long jLongValue = ((Long) zzbdr.zze.zze()).longValue();
        if (jLongValue <= 0 || jLongValue > 242402501) {
            return zzgcj.zzh(strZzb);
        }
        zzgca zzgcaVarZzu = zzgca.zzu(zzcejVar.zzT());
        zzful zzfulVar = new zzful() { // from class: com.google.android.gms.internal.ads.zzbhr
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbix zzbixVar = zzbiw.zza;
                if (!((Boolean) zzbdr.zzi.zze()).booleanValue()) {
                    return "failure_click_attok";
                }
                hd2.B.g.zzw(th, "prepareClickUrl.attestation1");
                return "failure_click_attok";
            }
        };
        zzgcu zzgcuVar = zzbzo.zzf;
        return zzgcj.zze(zzgcj.zzm(zzgcj.zze(zzgcaVarZzu, Throwable.class, zzfulVar, zzgcuVar), new zzful() { // from class: com.google.android.gms.internal.ads.zzbhs
            /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
            @Override // com.google.android.gms.internal.ads.zzful
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.String r6 = (java.lang.String) r6
                    com.google.android.gms.internal.ads.zzbix r0 = com.google.android.gms.internal.ads.zzbiw.zza
                    java.lang.String r0 = r1
                    if (r6 != 0) goto L9
                    goto L74
                L9:
                    com.google.android.gms.internal.ads.zzbdc r1 = com.google.android.gms.internal.ads.zzbdr.zzf
                    java.lang.Object r1 = r1.zze()
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r1 = r1.booleanValue()
                    if (r1 != 0) goto L18
                    goto L39
                L18:
                    java.lang.String r1 = ".googleadservices.com"
                    java.lang.String r2 = ".googlesyndication.com"
                    java.lang.String r3 = ".doubleclick.net"
                    java.lang.String[] r1 = new java.lang.String[]{r3, r1, r2}
                    android.net.Uri r2 = android.net.Uri.parse(r0)
                    java.lang.String r2 = r2.getHost()
                    r3 = 0
                L2b:
                    r4 = 3
                    if (r3 >= r4) goto L74
                    r4 = r1[r3]
                    boolean r4 = r2.endsWith(r4)
                    if (r4 != 0) goto L39
                    int r3 = r3 + 1
                    goto L2b
                L39:
                    com.google.android.gms.internal.ads.zzbdc r1 = com.google.android.gms.internal.ads.zzbdr.zza
                    java.lang.Object r1 = r1.zze()
                    java.lang.String r1 = (java.lang.String) r1
                    com.google.android.gms.internal.ads.zzbdc r2 = com.google.android.gms.internal.ads.zzbdr.zzb
                    java.lang.Object r2 = r2.zze()
                    java.lang.String r2 = (java.lang.String) r2
                    boolean r3 = android.text.TextUtils.isEmpty(r1)
                    if (r3 != 0) goto L53
                    java.lang.String r0 = r0.replace(r1, r6)
                L53:
                    boolean r1 = android.text.TextUtils.isEmpty(r2)
                    if (r1 != 0) goto L74
                    android.net.Uri r1 = android.net.Uri.parse(r0)
                    java.lang.String r3 = r1.getQueryParameter(r2)
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 == 0) goto L74
                    android.net.Uri$Builder r0 = r1.buildUpon()
                    android.net.Uri$Builder r6 = r0.appendQueryParameter(r2, r6)
                    java.lang.String r6 = r6.toString()
                    return r6
                L74:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhs.apply(java.lang.Object):java.lang.Object");
            }
        }, zzgcuVar), Throwable.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzbht
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbix zzbixVar = zzbiw.zza;
                if (((Boolean) zzbdr.zzi.zze()).booleanValue()) {
                    hd2.B.g.zzw(th, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzgcuVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zzb(com.google.android.gms.internal.ads.zzcfq r16, java.util.Map r17) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiw.zzb(com.google.android.gms.internal.ads.zzcfq, java.util.Map):void");
    }

    public static void zzc(Map map, zzdeq zzdeqVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzjQ)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdeqVar != null) {
            zzdeqVar.zzdG();
        }
    }
}
