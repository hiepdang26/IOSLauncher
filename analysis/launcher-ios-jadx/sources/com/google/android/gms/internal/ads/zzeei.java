package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzeei implements zzeej {
    public static /* synthetic */ zzeeo zzc(String str, String str2, String str3, zzeek zzeekVar, String str4, WebView webView, String str5, String str6, zzeel zzeelVar) {
        zzfmd zzfmdVarZza = zzfmd.zza("Google", str2);
        zzfmc zzfmcVarZzp = zzp("javascript");
        zzflv zzflvVarZzn = zzn(zzeekVar.toString());
        zzfmc zzfmcVar = zzfmc.NONE;
        if (zzfmcVarZzp == zzfmcVar) {
            k92.h("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzflvVarZzn == null) {
            k92.h("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(zzeekVar)));
            return null;
        }
        zzfmc zzfmcVarZzp2 = zzp(str4);
        if (zzflvVarZzn == zzflv.VIDEO && zzfmcVarZzp2 == zzfmcVar) {
            k92.h("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        }
        zzfls zzflsVarZzb = zzfls.zzb(zzfmdVarZza, webView, str5, "");
        return new zzeeo(zzflq.zza(zzflr.zza(zzflvVarZzn, zzo(zzeelVar.toString()), zzfmcVarZzp, zzfmcVarZzp2, true), zzflsVarZzb), zzflsVarZzb);
    }

    public static /* synthetic */ zzeeo zzd(String str, String str2, String str3, String str4, zzeek zzeekVar, WebView webView, String str5, String str6, zzeel zzeelVar) {
        zzfmd zzfmdVarZza = zzfmd.zza(str, str2);
        zzfmc zzfmcVarZzp = zzp("javascript");
        zzfmc zzfmcVarZzp2 = zzp(str4);
        zzflv zzflvVarZzn = zzn(zzeekVar.toString());
        zzfmc zzfmcVar = zzfmc.NONE;
        if (zzfmcVarZzp == zzfmcVar) {
            k92.h("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzflvVarZzn == null) {
            k92.h("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(zzeekVar)));
            return null;
        }
        if (zzflvVarZzn == zzflv.VIDEO && zzfmcVarZzp2 == zzfmcVar) {
            k92.h("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        }
        zzfls zzflsVarZzc = zzfls.zzc(zzfmdVarZza, webView, str5, "");
        return new zzeeo(zzflq.zza(zzflr.zza(zzflvVarZzn, zzo(zzeelVar.toString()), zzfmcVarZzp, zzfmcVarZzp2, true), zzflsVarZzc), zzflsVarZzc);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzflv zzn(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L20
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 1
            goto L35
        L20:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 2
            goto L35
        L2a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = -1
        L35:
            if (r4 == 0) goto L43
            if (r4 == r3) goto L40
            if (r4 == r2) goto L3d
            r4 = 0
            return r4
        L3d:
            com.google.android.gms.internal.ads.zzflv r4 = com.google.android.gms.internal.ads.zzflv.VIDEO
            return r4
        L40:
            com.google.android.gms.internal.ads.zzflv r4 = com.google.android.gms.internal.ads.zzflv.NATIVE_DISPLAY
            return r4
        L43:
            com.google.android.gms.internal.ads.zzflv r4 = com.google.android.gms.internal.ads.zzflv.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeei.zzn(java.lang.String):com.google.android.gms.internal.ads.zzflv");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzfly zzo(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 1
            r3 = 2
            if (r0 == r1) goto L2a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L20
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 2
            goto L35
        L20:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 1
            goto L35
        L2a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = -1
        L35:
            if (r4 == 0) goto L44
            if (r4 == r2) goto L41
            if (r4 == r3) goto L3e
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.UNSPECIFIED
            return r4
        L3e:
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.ONE_PIXEL
            return r4
        L41:
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.DEFINED_BY_JAVASCRIPT
            return r4
        L44:
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeei.zzo(java.lang.String):com.google.android.gms.internal.ads.zzfly");
    }

    private static zzfmc zzp(String str) {
        return "native".equals(str) ? zzfmc.NATIVE : "javascript".equals(str) ? zzfmc.JAVASCRIPT : zzfmc.NONE;
    }

    private static final Object zzq(zzeeh zzeehVar) {
        try {
            return zzeehVar.zza();
        } catch (RuntimeException e) {
            hd2.B.g.zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            hd2.B.g.zzv(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final zzeeo zza(final String str, final WebView webView, String str2, String str3, final String str4, final zzeel zzeelVar, final zzeek zzeekVar, final String str5) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue() || !zzflo.zzb()) {
            return null;
        }
        final String str6 = "javascript";
        final String str7 = "Google";
        final String str8 = "";
        return (zzeeo) zzq(new zzeeh(str7, str, str6, zzeekVar, str4, webView, str5, str8, zzeelVar) { // from class: com.google.android.gms.internal.ads.zzedx
            public final /* synthetic */ String zzb;
            public final /* synthetic */ zzeek zzd;
            public final /* synthetic */ String zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeel zzi;
            public final /* synthetic */ String zza = "Google";
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzeekVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzeelVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeeh
            public final Object zza() {
                return zzeei.zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final zzeeo zzb(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzeel zzeelVar, final zzeek zzeekVar, final String str6) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue() || !zzflo.zzb()) {
            return null;
        }
        final String str7 = "";
        final String str8 = "javascript";
        return (zzeeo) zzq(new zzeeh(str5, str, str8, str4, zzeekVar, webView, str6, str7, zzeelVar) { // from class: com.google.android.gms.internal.ads.zzeea
            public final /* synthetic */ String zza;
            public final /* synthetic */ String zzb;
            public final /* synthetic */ String zzd;
            public final /* synthetic */ zzeek zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeel zzi;
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzeekVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzeelVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeeh
            public final Object zza() {
                return zzeei.zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final zzfmb zze(final or1 or1Var, final WebView webView, boolean z) {
        final boolean z2 = true;
        return (zzfmb) zzq(new zzeeh(webView, z2) { // from class: com.google.android.gms.internal.ads.zzeef
            public final /* synthetic */ WebView zzb;

            @Override // com.google.android.gms.internal.ads.zzeeh
            public final Object zza() {
                or1 or1Var2 = this.zza;
                return zzfmb.zza(zzfmd.zza("Google", or1Var2.h + "." + or1Var2.i), this.zzb, true);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final String zzf(Context context) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue()) {
            return (String) zzq(new zzeeh() { // from class: com.google.android.gms.internal.ads.zzeed
                @Override // com.google.android.gms.internal.ads.zzeeh
                public final Object zza() {
                    return "a.1.4.10-google_20240110";
                }
            });
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final void zzg(final zzflq zzflqVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedw
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
                    zzflqVar.zzb(view, zzflx.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final void zzh(final zzfmb zzfmbVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeec
            @Override // java.lang.Runnable
            public final void run() {
                zzfmbVar.zze(view, zzflx.NOT_VISIBLE, "Ad overlay");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final void zzi(final zzflq zzflqVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeeg
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
                    zzflqVar.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final void zzj(final zzflq zzflqVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedy
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
                    zzflqVar.zzd(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final void zzk(final zzflq zzflqVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
            Objects.requireNonNull(zzflqVar);
            zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedz
                @Override // java.lang.Runnable
                public final void run() {
                    zzflqVar.zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final boolean zzl(final Context context) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzez)).booleanValue()) {
            Boolean bool = (Boolean) zzq(new zzeeh() { // from class: com.google.android.gms.internal.ads.zzeeb
                @Override // com.google.android.gms.internal.ads.zzeeh
                public final Object zza() {
                    if (zzflo.zzb()) {
                        return Boolean.TRUE;
                    }
                    zzflo.zza(context);
                    return Boolean.valueOf(zzflo.zzb());
                }
            });
            return bool != null && bool.booleanValue();
        }
        k92.h("Omid flag is disabled");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeej
    public final void zzm(final zzfmb zzfmbVar, final zzcey zzceyVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeee
            @Override // java.lang.Runnable
            public final void run() {
                zzfmbVar.zzf(zzceyVar);
            }
        });
    }
}
