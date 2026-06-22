package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.k31;
import defpackage.n42;
import defpackage.nj;
import defpackage.or1;
import defpackage.ub2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzflh {
    private final zzein zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfey zzf;
    private final zzfez zzg;
    private final nj zzh;
    private final zzauo zzi;

    public zzflh(zzein zzeinVar, or1 or1Var, String str, String str2, Context context, zzfey zzfeyVar, zzfez zzfezVar, nj njVar, zzauo zzauoVar) {
        this.zza = zzeinVar;
        this.zzb = or1Var.g;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfeyVar;
        this.zzg = zzfezVar;
        this.zzh = njVar;
        this.zzi = zzauoVar;
    }

    public static final List zzf(int i, int i2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_mpe@", k31.k(i2, "2.")));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    public static final List zzh(List list, long j) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_ttr@", Long.toString(j, 10)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzi(String str) {
        return TextUtils.isEmpty(str) ? "" : ub2.c() ? "fakeForAdDebugLog" : str;
    }

    private static String zzj(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzfex zzfexVar, zzfel zzfelVar, List list) {
        return zzd(zzfexVar, zzfelVar, false, "", "", list);
    }

    public final List zzd(zzfex zzfexVar, zzfel zzfelVar, boolean z, String str, String str2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String strZzj = zzj(zzj(zzj((String) it.next(), "@gw_adlocid@", zzfexVar.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? "0" : "1"), "@gw_sdkver@", this.zzb);
            if (zzfelVar != null) {
                strZzj = zzbyc.zzc(zzj(zzj(zzj(strZzj, "@gw_qdata@", zzfelVar.zzy), "@gw_adnetid@", zzfelVar.zzx), "@gw_allocid@", zzfelVar.zzw), this.zze, zzfelVar.zzW, zzfelVar.zzaw);
            }
            String strZzj2 = zzj(zzj(zzj(zzj(strZzj, "@gw_adnetstatus@", this.zza.zzg()), "@gw_ttr@", Long.toString(this.zza.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z3 = false;
            if (((Boolean) n42.d.c.zza(zzbbw.zzdf)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean z4 = !zIsEmpty;
            if (z3) {
                z2 = z4;
            } else {
                if (!zIsEmpty) {
                }
                arrayList.add(strZzj2);
            }
            if (this.zzi.zzf(Uri.parse(strZzj2))) {
                Uri.Builder builderBuildUpon = Uri.parse(strZzj2).buildUpon();
                if (z3) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                }
                strZzj2 = builderBuildUpon.build().toString();
            }
            arrayList.add(strZzj2);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[LOOP:0: B:13:0x0065->B:15:0x006b, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zze(com.google.android.gms.internal.ads.zzfel r11, java.util.List r12, com.google.android.gms.internal.ads.zzbvn r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            nj r1 = r10.zzh
            us r1 = (defpackage.us) r1
            r1.getClass()
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = r13.zzc()     // Catch: android.os.RemoteException -> Lb6
            int r13 = r13.zzb()     // Catch: android.os.RemoteException -> Lb6
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch: android.os.RemoteException -> Lb6
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzdg
            n42 r5 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r5 = r5.c
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3e
            com.google.android.gms.internal.ads.zzfez r4 = r10.zzg
            if (r4 != 0) goto L37
            com.google.android.gms.internal.ads.zzfus r4 = com.google.android.gms.internal.ads.zzfus.zzc()
            goto L41
        L37:
            com.google.android.gms.internal.ads.zzfey r4 = r4.zza
        L39:
            com.google.android.gms.internal.ads.zzfus r4 = com.google.android.gms.internal.ads.zzfus.zzd(r4)
            goto L41
        L3e:
            com.google.android.gms.internal.ads.zzfey r4 = r10.zzf
            goto L39
        L41:
            com.google.android.gms.internal.ads.zzflf r5 = new com.google.android.gms.internal.ads.zzflf
            r5.<init>()
            com.google.android.gms.internal.ads.zzfus r5 = r4.zza(r5)
            java.lang.String r6 = ""
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzflg r7 = new com.google.android.gms.internal.ads.zzflg
            r7.<init>()
            com.google.android.gms.internal.ads.zzfus r4 = r4.zza(r7)
            java.lang.Object r4 = r4.zzb(r6)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Iterator r12 = r12.iterator()
        L65:
            boolean r6 = r12.hasNext()
            if (r6 == 0) goto Lb5
            java.lang.Object r6 = r12.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = android.net.Uri.encode(r5)
            java.lang.String r8 = "@gw_rwd_userid@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r4)
            java.lang.String r8 = "@gw_rwd_custom_data@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = java.lang.Long.toString(r1)
            java.lang.String r8 = "@gw_tmstmp@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r3)
            java.lang.String r8 = "@gw_rwd_itm@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = "@gw_rwd_amt@"
            java.lang.String r6 = zzj(r6, r7, r13)
            java.lang.String r7 = r10.zzb
            java.lang.String r8 = "@gw_sdkver@"
            java.lang.String r6 = zzj(r6, r8, r7)
            android.content.Context r7 = r10.zze
            boolean r8 = r11.zzW
            java.util.Map r9 = r11.zzaw
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbyc.zzc(r6, r7, r8, r9)
            r0.add(r6)
            goto L65
        Lb5:
            return r0
        Lb6:
            defpackage.k92.f()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzflh.zze(com.google.android.gms.internal.ads.zzfel, java.util.List, com.google.android.gms.internal.ads.zzbvn):java.util.List");
    }
}
