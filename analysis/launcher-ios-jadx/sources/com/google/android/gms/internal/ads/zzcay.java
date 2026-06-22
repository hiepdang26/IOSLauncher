package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.hg0;
import defpackage.k92;
import defpackage.n42;
import defpackage.s61;
import defpackage.uo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzcay extends FrameLayout implements zzcap {
    final zzcbm zza;
    private final zzcbk zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbcl zze;
    private final long zzf;
    private final zzcaq zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcay(Context context, zzcbk zzcbkVar, int i, boolean z, zzbcl zzbclVar, zzcbj zzcbjVar) {
        zzcaq zzcaoVar;
        zzbcl zzbclVar2;
        super(context);
        this.zzb = zzcbkVar;
        this.zze = zzbclVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        hg0.i(zzcbkVar.zzj());
        zzcbc zzcbcVar = zzcbkVar.zzj().a;
        zzcbl zzcblVar = new zzcbl(context, zzcbkVar.zzn(), zzcbkVar.zzdi(), zzbclVar, zzcbkVar.zzk());
        if (i == 2) {
            zzcaoVar = new zzccc(context, zzcblVar, zzcbkVar, z, zzcar.zza(zzcbkVar), zzcbjVar);
            zzbclVar2 = zzbclVar;
        } else {
            zzbclVar2 = zzbclVar;
            zzcaoVar = new zzcao(context, zzcbkVar, z, zzcar.zza(zzcbkVar), zzcbjVar, new zzcbl(context, zzcbkVar.zzn(), zzcbkVar.zzdi(), zzbclVar, zzcbkVar.zzk()));
        }
        this.zzg = zzcaoVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcaoVar, new FrameLayout.LayoutParams(-1, -1, 17));
        zzbbn zzbbnVar = zzbbw.zzz;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzw)).booleanValue()) {
            zzn();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) n42Var.c.zza(zzbbw.zzB)).longValue();
        boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbw.zzy)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbclVar2 != null) {
            zzbclVar.zzd("spinner_used", true != zBooleanValue ? "0" : "1");
        }
        this.zza = new zzcbm(this);
        zzcaoVar.zzr(this);
    }

    private final void zzJ() {
        if (this.zzb.zzi() == null || !this.zzi || this.zzj) {
            return;
        }
        this.zzb.zzi().getWindow().clearFlags(128);
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", map);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcaq zzcaqVar = this.zzg;
            if (zzcaqVar != null) {
                zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcas
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcaqVar.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcau
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzq(z);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcap
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        cd2.l.post(new zzcax(this, z));
    }

    public final void zzA(int i) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzz(i);
    }

    public final void zzB(int i) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzA(i);
    }

    public final void zzC(int i) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzz)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzB(i);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (k92.b()) {
            StringBuilder sbN = uo.n("Set video bounds to x:", i, ";y:", i2, ";w:");
            sbN.append(i3);
            sbN.append(";h:");
            sbN.append(i4);
            k92.a(sbN.toString());
        }
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzG(float f) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzb.zze(f);
        zzcaqVar.zzn();
    }

    public final void zzH(float f, float f2) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null) {
            zzcaqVar.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzb.zzd(false);
        zzcaqVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zza() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbI)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzb(String str, String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zze() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbI)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            boolean z = (this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzf() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null && this.zzm == 0) {
            float fZzc = zzcaqVar.zzc();
            zzcaq zzcaqVar2 = this.zzg;
            zzK("canplaythrough", "duration", String.valueOf(fZzc / 1000.0f), "videoWidth", String.valueOf(zzcaqVar2.zze()), "videoHeight", String.valueOf(zzcaqVar2.zzd()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzg() {
        this.zzd.setVisibility(4);
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcat
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzp();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzh() {
        this.zza.zzb();
        cd2.l.post(new zzcav(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        cd2.l.post(new zzcaw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzj(int i, int i2) {
        if (this.zzk) {
            zzbbn zzbbnVar = zzbbw.zzA;
            n42 n42Var = n42.d;
            int iMax = Math.max(i / ((Integer) n42Var.c.zza(zzbbnVar)).intValue(), 1);
            int iMax2 = Math.max(i2 / ((Integer) n42Var.c.zza(zzbbnVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg == null || this.zzp == null) {
            return;
        }
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzg.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        hd2Var.j.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (k92.b()) {
            k92.a("Spinner frame grab took " + jElapsedRealtime2 + "ms");
        }
        if (jElapsedRealtime2 > this.zzf) {
            k92.h("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbcl zzbclVar = this.zze;
            if (zzbclVar != null) {
                zzbclVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    public final Integer zzl() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null) {
            return zzcaqVar.zzw();
        }
        return null;
    }

    public final void zzn() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        TextView textView = new TextView(zzcaqVar.getContext());
        Resources resourcesZze = hd2.B.g.zze();
        textView.setText(String.valueOf(resourcesZze == null ? "AdMob - " : resourcesZze.getString(s61.watermark_label_prefix)).concat(this.zzg.zzj()));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzc.bringChildToFront(textView);
    }

    public final void zzo() {
        this.zza.zza();
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null) {
            zzcaqVar.zzt();
        }
        zzJ();
    }

    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    public final /* synthetic */ void zzq(boolean z) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzr(Integer num) {
        if (this.zzg == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzK("no_src", new String[0]);
        } else {
            this.zzg.zzC(this.zzn, this.zzo, num);
        }
    }

    public final void zzs() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzb.zzd(true);
        zzcaqVar.zzn();
    }

    public final void zzt() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        long jZza = zzcaqVar.zza();
        if (this.zzl == jZza || jZza <= 0) {
            return;
        }
        float f = jZza / 1000.0f;
        if (((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue()) {
            String strValueOf = String.valueOf(f);
            String strValueOf2 = String.valueOf(this.zzg.zzh());
            String strValueOf3 = String.valueOf(this.zzg.zzf());
            String strValueOf4 = String.valueOf(this.zzg.zzg());
            String strValueOf5 = String.valueOf(this.zzg.zzb());
            hd2.B.j.getClass();
            zzK("timeupdate", "time", strValueOf, "totalBytes", strValueOf2, "qoeCachedBytes", strValueOf3, "qoeLoadedBytes", strValueOf4, "droppedFrames", strValueOf5, "reportTime", String.valueOf(System.currentTimeMillis()));
        } else {
            zzK("timeupdate", "time", String.valueOf(f));
        }
        this.zzl = jZza;
    }

    public final void zzu() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzo();
    }

    public final void zzv() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzp();
    }

    public final void zzw(int i) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzq(i);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzx(i);
    }

    public final void zzz(int i) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzy(i);
    }
}
