package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcxd;
import com.google.android.gms.internal.ads.zzdeq;
import com.google.android.gms.internal.ads.zzedt;
import com.google.android.gms.internal.ads.zzedu;
import com.google.android.gms.internal.ads.zzeem;
import com.google.android.gms.internal.ads.zzeeo;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class yb2 extends zzbsm {
    public static final int C = Color.argb(0, 0, 0, 0);
    public Toolbar A;
    public final Activity g;
    public AdOverlayInfoParcel h;
    public zzcej i;
    public bn1 j;
    public yc2 k;
    public FrameLayout m;
    public WebChromeClient.CustomViewCallback n;
    public eb2 q;
    public fl0 u;
    public boolean v;
    public boolean w;
    public boolean l = false;
    public boolean o = false;
    public boolean p = false;
    public boolean r = false;
    public int B = 1;
    public final Object s = new Object();
    public final ia2 t = new ia2(this);
    public boolean x = false;
    public boolean y = false;
    public boolean z = true;

    public yb2(Activity activity) {
        this.g = activity;
    }

    public static final void s(View view, zzeeo zzeeoVar) {
        if (zzeeoVar == null || view == null) {
            return;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzeB)).booleanValue() && zzeeoVar.zzb()) {
            return;
        }
        hd2.B.w.zzj(zzeeoVar.zza(), view);
    }

    public final void f(int i) {
        Activity activity = this.g;
        int i2 = activity.getApplicationInfo().targetSdkVersion;
        zzbbn zzbbnVar = zzbbw.zzfq;
        n42 n42Var = n42.d;
        if (i2 >= ((Integer) n42Var.c.zza(zzbbnVar)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) n42Var.c.zza(zzbbw.zzfr)).intValue()) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= ((Integer) n42Var.c.zza(zzbbw.zzfs)).intValue()) {
                    if (i3 <= ((Integer) n42Var.c.zza(zzbbw.zzft)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i);
        } catch (Throwable th) {
            hd2.B.g.zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(boolean r33) throws defpackage.ya2 {
        /*
            Method dump skipped, instruction units count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb2.p(boolean):void");
    }

    public final void q(View view) {
        zzeeo zzeeoVarZzQ;
        zzeem zzeemVarZzP;
        zzbbn zzbbnVar = zzbbw.zzeC;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && (zzeemVarZzP = this.i.zzP()) != null) {
            zzeemVarZzP.zza(view);
        } else if (((Boolean) n42Var.c.zza(zzbbw.zzeB)).booleanValue() && (zzeeoVarZzQ = this.i.zzQ()) != null && zzeeoVarZzQ.zzb()) {
            hd2.B.w.zzg(zzeeoVarZzQ.zza(), view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.h
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            sb2 r0 = r0.u
            if (r0 == 0) goto L10
            boolean r0 = r0.h
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            hd2 r3 = defpackage.hd2.B
            fd2 r3 = r3.e
            android.app.Activity r4 = r5.g
            boolean r6 = r3.a(r4, r6)
            boolean r3 = r5.p
            if (r3 == 0) goto L36
            if (r0 != 0) goto L36
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzax
            n42 r3 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r3 = r3.c
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L34
            goto L36
        L34:
            r1 = 0
            goto L57
        L36:
            if (r6 == 0) goto L4a
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzaw
            n42 r0 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r0 = r0.c
            java.lang.Object r6 = r0.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L34
        L4a:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.h
            if (r6 == 0) goto L57
            sb2 r6 = r6.u
            if (r6 == 0) goto L57
            boolean r6 = r6.m
            if (r6 == 0) goto L57
            r2 = 1
        L57:
            android.view.Window r6 = r4.getWindow()
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzaV
            n42 r3 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r3 = r3.c
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L81
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L7b
            if (r2 == 0) goto L78
            r0 = 5894(0x1706, float:8.259E-42)
            goto L7d
        L78:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L7d
        L7b:
            r0 = 256(0x100, float:3.59E-43)
        L7d:
            r6.setSystemUiVisibility(r0)
            return
        L81:
            r0 = 2048(0x800, float:2.87E-42)
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L99
            r6.addFlags(r3)
            r6.clearFlags(r0)
            if (r2 == 0) goto L98
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L98:
            return
        L99:
            r6.addFlags(r0)
            r6.clearFlags(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb2.r(android.content.res.Configuration):void");
    }

    public final void t(boolean z) {
        if (this.h.C) {
            return;
        }
        zzbbn zzbbnVar = zzbbw.zzes;
        n42 n42Var = n42.d;
        int iIntValue = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
        boolean z2 = ((Boolean) n42Var.c.zza(zzbbw.zzaR)).booleanValue() || z;
        nq nqVar = new nq();
        nqVar.a = 0;
        nqVar.b = 0;
        nqVar.c = 0;
        nqVar.d = 50;
        nqVar.a = true != z2 ? 0 : iIntValue;
        nqVar.b = true != z2 ? iIntValue : 0;
        nqVar.c = iIntValue;
        this.k = new yc2(this.g, nqVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        u(z, this.h.m);
        this.q.addView(this.k, layoutParams);
        q(this.k);
    }

    public final void u(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        sb2 sb2Var;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        sb2 sb2Var2;
        zzbbn zzbbnVar = zzbbw.zzaP;
        n42 n42Var = n42.d;
        boolean z3 = true;
        boolean z4 = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && (adOverlayInfoParcel2 = this.h) != null && (sb2Var2 = adOverlayInfoParcel2.u) != null && sb2Var2.n;
        boolean z5 = ((Boolean) n42Var.c.zza(zzbbw.zzaQ)).booleanValue() && (adOverlayInfoParcel = this.h) != null && (sb2Var = adOverlayInfoParcel.u) != null && sb2Var.o;
        if (z && z2 && z4 && !z5) {
            new zzbrq(this.i, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        yc2 yc2Var = this.k;
        if (yc2Var != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            ImageButton imageButton = yc2Var.g;
            if (!z3) {
                imageButton.setVisibility(0);
                return;
            }
            imageButton.setVisibility(8);
            if (((Long) n42Var.c.zza(zzbbw.zzaT)).longValue() > 0) {
                imageButton.animate().cancel();
                imageButton.clearAnimation();
            }
        }
    }

    public final void zzE() {
        synchronized (this.s) {
            try {
                this.v = true;
                fl0 fl0Var = this.u;
                if (fl0Var != null) {
                    ja2 ja2Var = cd2.l;
                    ja2Var.removeCallbacks(fl0Var);
                    ja2Var.post(this.u);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        mc2 mc2Var;
        if (!this.g.isFinishing() || this.x) {
            return;
        }
        this.x = true;
        zzcej zzcejVar = this.i;
        if (zzcejVar != null) {
            zzcejVar.zzZ(this.B - 1);
            synchronized (this.s) {
                try {
                    if (!this.v && this.i.zzaC()) {
                        zzbbn zzbbnVar = zzbbw.zzen;
                        n42 n42Var = n42.d;
                        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && !this.y && (adOverlayInfoParcel = this.h) != null && (mc2Var = adOverlayInfoParcel.i) != null) {
                            mc2Var.zzdq();
                        }
                        fl0 fl0Var = new fl0(this, 27);
                        this.u = fl0Var;
                        cd2.l.postDelayed(fl0Var, ((Long) n42Var.c.zza(zzbbw.zzaO)).longValue());
                        return;
                    }
                } finally {
                }
            }
        }
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean zzH() {
        this.B = 1;
        if (this.i == null) {
            return true;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzia)).booleanValue() && this.i.canGoBack()) {
            this.i.goBack();
            return false;
        }
        boolean zZzaH = this.i.zzaH();
        if (!zZzaH) {
            this.i.zzd("onbackblocked", Collections.EMPTY_MAP);
        }
        return zZzaH;
    }

    public final void zzb() {
        this.B = 3;
        Activity activity = this.g;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.h;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.q != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public final void zzc() {
        zzcej zzcejVar;
        mc2 mc2Var;
        if (this.y) {
            return;
        }
        this.y = true;
        zzcej zzcejVar2 = this.i;
        if (zzcejVar2 != null) {
            this.q.removeView(zzcejVar2.zzF());
            bn1 bn1Var = this.j;
            if (bn1Var != null) {
                this.i.zzan((Context) bn1Var.d);
                this.i.zzaq(false);
                if (((Boolean) n42.d.c.zza(zzbbw.zzlJ)).booleanValue() && this.i.getParent() != null) {
                    ((ViewGroup) this.i.getParent()).removeView(this.i.zzF());
                }
                ViewGroup viewGroup = (ViewGroup) this.j.c;
                View viewZzF = this.i.zzF();
                bn1 bn1Var2 = this.j;
                viewGroup.addView(viewZzF, bn1Var2.a, (ViewGroup.LayoutParams) bn1Var2.b);
                this.j = null;
            } else {
                Activity activity = this.g;
                if (activity.getApplicationContext() != null) {
                    this.i.zzan(activity.getApplicationContext());
                }
            }
            this.i = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.h;
        if (adOverlayInfoParcel != null && (mc2Var = adOverlayInfoParcel.i) != null) {
            mc2Var.zzdu(this.B);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.h;
        if (adOverlayInfoParcel2 == null || (zzcejVar = adOverlayInfoParcel2.j) == null) {
            return;
        }
        s(this.h.j.zzF(), zzcejVar.zzQ());
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.h;
        if (adOverlayInfoParcel != null && this.l) {
            f(adOverlayInfoParcel.p);
        }
        if (this.m != null) {
            this.g.setContentView(this.q);
            this.w = true;
            this.m.removeAllViews();
            this.m = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.n;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.n = null;
        }
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzi() {
        this.B = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzk(he0 he0Var) {
        r((Configuration) gy0.r(he0Var));
    }

    public void zzl(Bundle bundle) {
        boolean z = this.w;
        Activity activity = this.g;
        if (!z) {
            activity.requestWindowFeature(1);
        }
        this.o = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel adOverlayInfoParcelA = AdOverlayInfoParcel.a(activity.getIntent());
            this.h = adOverlayInfoParcelA;
            if (adOverlayInfoParcelA == null) {
                throw new ya2("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelA.C) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.setShowWhenLocked(true);
                } else {
                    activity.getWindow().addFlags(524288);
                }
            }
            if (this.h.s.i > 7500000) {
                this.B = 4;
            }
            if (activity.getIntent() != null) {
                this.z = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.h;
            sb2 sb2Var = adOverlayInfoParcel.u;
            int i = adOverlayInfoParcel.q;
            if (sb2Var != null) {
                boolean z2 = sb2Var.g;
                this.p = z2;
                if (z2) {
                    if (i != 5 && sb2Var.l != -1) {
                        new n62(this).zzb();
                    }
                }
            } else if (i == 5) {
                this.p = true;
                if (i != 5) {
                    new n62(this).zzb();
                }
            } else {
                this.p = false;
            }
            if (bundle == null) {
                if (this.z) {
                    zzcxd zzcxdVar = this.h.z;
                    if (zzcxdVar != null) {
                        zzcxdVar.zze();
                    }
                    mc2 mc2Var = this.h.i;
                    if (mc2Var != null) {
                        mc2Var.zzdr();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.h;
                if (adOverlayInfoParcel2.q != 1) {
                    b22 b22Var = adOverlayInfoParcel2.h;
                    if (b22Var != null) {
                        b22Var.onAdClicked();
                    }
                    zzdeq zzdeqVar = this.h.A;
                    if (zzdeqVar != null) {
                        zzdeqVar.zzdG();
                    }
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.h;
            eb2 eb2Var = new eb2(activity, adOverlayInfoParcel3.t, adOverlayInfoParcel3.s.g, adOverlayInfoParcel3.y);
            this.q = eb2Var;
            eb2Var.setId(zzbbc.zzq.zzf);
            hd2.B.e.g(activity);
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.h;
            int i2 = adOverlayInfoParcel4.q;
            if (i2 == 1) {
                p(false);
                return;
            }
            if (i2 == 2) {
                this.j = new bn1(adOverlayInfoParcel4.j);
                p(false);
            } else if (i2 == 3) {
                p(true);
            } else {
                if (i2 != 5) {
                    throw new ya2("Could not determine ad overlay type.");
                }
                p(false);
            }
        } catch (ya2 e) {
            k92.h(e.getMessage());
            this.B = 4;
            activity.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzm() {
        zzcej zzcejVar = this.i;
        if (zzcejVar != null) {
            try {
                this.q.removeView(zzcejVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzo() {
        mc2 mc2Var;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.h;
        if (adOverlayInfoParcel != null && (mc2Var = adOverlayInfoParcel.i) != null) {
            mc2Var.zzdk();
        }
        if (!((Boolean) n42.d.c.zza(zzbbw.zzep)).booleanValue() && this.i != null && (!this.g.isFinishing() || this.j == null)) {
            this.i.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzp(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            zzedt zzedtVarZze = zzedu.zze();
            zzedtVarZze.zza(this.g);
            zzedtVarZze.zzb(this.h.q == 5 ? this : null);
            try {
                this.h.B.zzf(strArr, iArr, new gy0(zzedtVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzr() {
        mc2 mc2Var;
        AdOverlayInfoParcel adOverlayInfoParcel = this.h;
        if (adOverlayInfoParcel != null && (mc2Var = adOverlayInfoParcel.i) != null) {
            mc2Var.zzdH();
        }
        r(this.g.getResources().getConfiguration());
        if (((Boolean) n42.d.c.zza(zzbbw.zzep)).booleanValue()) {
            return;
        }
        zzcej zzcejVar = this.i;
        if (zzcejVar == null || zzcejVar.zzaE()) {
            k92.h("The webview does not exist. Ignoring action.");
        } else {
            this.i.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.o);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzt() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzep)).booleanValue()) {
            zzcej zzcejVar = this.i;
            if (zzcejVar == null || zzcejVar.zzaE()) {
                k92.h("The webview does not exist. Ignoring action.");
            } else {
                this.i.onResume();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzu() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzep)).booleanValue() && this.i != null && (!this.g.isFinishing() || this.j == null)) {
            this.i.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzv() {
        mc2 mc2Var;
        AdOverlayInfoParcel adOverlayInfoParcel = this.h;
        if (adOverlayInfoParcel == null || (mc2Var = adOverlayInfoParcel.i) == null) {
            return;
        }
        mc2Var.zzdt();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzx() {
        this.w = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzh(int i, int i2, Intent intent) {
    }
}
