package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import defpackage.ib2;
import defpackage.k92;
import defpackage.n42;
import defpackage.z71;
import defpackage.za2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkb {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final za2 zzb;
    private final zzffg zzc;
    private final zzdjg zzd;
    private final zzdjb zze;
    private final zzdkn zzf;
    private final zzdkv zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbes zzj;
    private final zzdiy zzk;

    public zzdkb(za2 za2Var, zzffg zzffgVar, zzdjg zzdjgVar, zzdjb zzdjbVar, zzdkn zzdknVar, zzdkv zzdkvVar, Executor executor, Executor executor2, zzdiy zzdiyVar) {
        this.zzb = za2Var;
        this.zzc = zzffgVar;
        this.zzj = zzffgVar.zzi;
        this.zzd = zzdjgVar;
        this.zze = zzdjbVar;
        this.zzf = zzdknVar;
        this.zzg = zzdkvVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdiyVar;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View viewZzf = z ? this.zze.zzf() : this.zze.zzg();
        if (viewZzf == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzf.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzf.getParent()).removeView(viewZzf);
        }
        viewGroup.addView(viewZzf, ((Boolean) n42.d.c.zza(zzbbw.zzdw)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        zzdjb zzdjbVar = this.zze;
        if (zzdjbVar.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzdjbVar.zzc() == 2 || zzdjbVar.zzc() == 1) {
                za2 za2Var = this.zzb;
                ib2 ib2Var = (ib2) za2Var;
                ib2Var.i(this.zzc.zzf, String.valueOf(zzdjbVar.zzc()), z);
                return;
            }
            if (zzdjbVar.zzc() == 6) {
                ((ib2) this.zzb).i(this.zzc.zzf, "2", z);
                ((ib2) this.zzb).i(this.zzc.zzf, "1", z);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(com.google.android.gms.internal.ads.zzdkx r10) {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdkb.zzb(com.google.android.gms.internal.ads.zzdkx):void");
    }

    public final void zzc(zzdkx zzdkxVar) {
        if (zzdkxVar == null || this.zzf == null || zzdkxVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdkxVar.zzh().addView(this.zzf.zza());
        } catch (zzcev unused) {
            k92.b();
        }
    }

    public final void zzd(zzdkx zzdkxVar) {
        if (zzdkxVar == null) {
            return;
        }
        Context context = zzdkxVar.zzf().getContext();
        if (z71.w(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                k92.d("Activity context is needed for policy validator.");
                return;
            }
            if (this.zzg == null || zzdkxVar.zzh() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(this.zzg.zza(zzdkxVar.zzh(), windowManager), z71.q());
            } catch (zzcev unused) {
                k92.b();
            }
        }
    }

    public final void zze(final zzdkx zzdkxVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzdkxVar);
            }
        });
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }
}
