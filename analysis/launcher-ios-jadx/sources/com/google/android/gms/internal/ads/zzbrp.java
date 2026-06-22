package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.x32;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrp extends zzbrq implements zzbix {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcej zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbbe zzk;
    private float zzl;
    private int zzm;

    public zzbrp(zzcej zzcejVar, Context context, zzbbe zzbbeVar) {
        super(zzcejVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcejVar;
        this.zzi = context;
        this.zzk = zzbbeVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        JSONObject jSONObjectPut;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        ka2 ka2Var = x32.f.a;
        this.zzb = Math.round(r10.widthPixels / this.zza.density);
        this.zzc = Math.round(r10.heightPixels / this.zza.density);
        Activity activityZzi = this.zzh.zzi();
        if (activityZzi == null || activityZzi.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            cd2 cd2Var = hd2.B.c;
            int[] iArrM = cd2.m(activityZzi);
            this.zzd = Math.round(iArrM[0] / this.zza.density);
            this.zze = Math.round(iArrM[1] / this.zza.density);
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbro zzbroVar = new zzbro();
        zzbbe zzbbeVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbroVar.zze(zzbbeVar.zza(intent));
        zzbbe zzbbeVar2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbroVar.zzc(zzbbeVar2.zza(intent2));
        zzbroVar.zza(this.zzk.zzb());
        zzbroVar.zzd(this.zzk.zzc());
        zzbroVar.zzb(true);
        boolean z = zzbroVar.zza;
        boolean z2 = zzbroVar.zzb;
        boolean z3 = zzbroVar.zzc;
        boolean z4 = zzbroVar.zzd;
        boolean z5 = zzbroVar.zze;
        zzcej zzcejVar = this.zzh;
        try {
            jSONObjectPut = new JSONObject().put("sms", z).put("tel", z2).put("calendar", z3).put("storePicture", z4).put("inlineVideo", z5);
        } catch (JSONException unused) {
            k92.f();
            jSONObjectPut = null;
        }
        zzcejVar.zze("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        Context context = this.zzi;
        x32 x32Var = x32.f;
        zzb(x32Var.a.e(context, iArr[0]), x32Var.a.e(this.zzi, iArr[1]));
        if (k92.j(2)) {
            k92.g("Dispatching Ready Event.");
        }
        zzi(this.zzh.zzn().g);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006c A[PHI: r3
  0x006c: PHI (r3v1 int) = (r3v0 int), (r3v4 int) binds: [B:11:0x0043, B:17:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.zzi
            boolean r1 = r0 instanceof android.app.Activity
            r2 = 0
            if (r1 == 0) goto L14
            hd2 r1 = defpackage.hd2.B
            cd2 r1 = r1.c
            android.app.Activity r0 = (android.app.Activity) r0
            int[] r0 = defpackage.cd2.n(r0)
            r0 = r0[r2]
            goto L15
        L14:
            r0 = 0
        L15:
            com.google.android.gms.internal.ads.zzcej r1 = r6.zzh
            com.google.android.gms.internal.ads.zzcgd r1 = r1.zzO()
            if (r1 == 0) goto L29
            com.google.android.gms.internal.ads.zzcej r1 = r6.zzh
            com.google.android.gms.internal.ads.zzcgd r1 = r1.zzO()
            boolean r1 = r1.zzi()
            if (r1 != 0) goto L83
        L29:
            com.google.android.gms.internal.ads.zzcej r1 = r6.zzh
            int r3 = r1.getWidth()
            int r1 = r1.getHeight()
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzK
            n42 r5 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r5 = r5.c
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L6c
            if (r3 != 0) goto L59
            com.google.android.gms.internal.ads.zzcej r3 = r6.zzh
            com.google.android.gms.internal.ads.zzcgd r3 = r3.zzO()
            if (r3 == 0) goto L58
            com.google.android.gms.internal.ads.zzcej r3 = r6.zzh
            com.google.android.gms.internal.ads.zzcgd r3 = r3.zzO()
            int r3 = r3.zzb
            goto L59
        L58:
            r3 = 0
        L59:
            if (r1 != 0) goto L6c
            com.google.android.gms.internal.ads.zzcej r1 = r6.zzh
            com.google.android.gms.internal.ads.zzcgd r1 = r1.zzO()
            if (r1 == 0) goto L6d
            com.google.android.gms.internal.ads.zzcej r1 = r6.zzh
            com.google.android.gms.internal.ads.zzcgd r1 = r1.zzO()
            int r2 = r1.zza
            goto L6d
        L6c:
            r2 = r1
        L6d:
            android.content.Context r1 = r6.zzi
            x32 r4 = defpackage.x32.f
            ka2 r5 = r4.a
            int r1 = r5.e(r1, r3)
            r6.zzf = r1
            android.content.Context r1 = r6.zzi
            ka2 r3 = r4.a
            int r1 = r3.e(r1, r2)
            r6.zzg = r1
        L83:
            int r0 = r8 - r0
            int r1 = r6.zzf
            int r2 = r6.zzg
            r6.zzg(r7, r0, r1, r2)
            com.google.android.gms.internal.ads.zzcej r0 = r6.zzh
            com.google.android.gms.internal.ads.zzcgb r0 = r0.zzN()
            r0.zzC(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrp.zzb(int, int):void");
    }
}
