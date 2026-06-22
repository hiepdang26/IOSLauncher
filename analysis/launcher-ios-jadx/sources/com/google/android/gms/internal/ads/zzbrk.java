package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import defpackage.g9;
import defpackage.n42;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrk extends zzbrq {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcej zzj;
    private final Activity zzk;
    private zzcgd zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbrr zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        g9 g9Var = new g9(7);
        Collections.addAll(g9Var, "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
        Collections.unmodifiableSet(g9Var);
    }

    public zzbrk(zzcej zzcejVar, zzbrr zzbrrVar) {
        super(zzcejVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzcejVar;
        this.zzk = zzcejVar.zzi();
        this.zzo = zzbrrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzc(boolean z) {
        this.zzp.dismiss();
        this.zzq.removeView((View) this.zzj);
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            this.zzr.addView((View) this.zzj);
            this.zzj.zzaj(this.zzl);
        }
        if (z) {
            zzl("default");
            zzbrr zzbrrVar = this.zzo;
            if (zzbrrVar != null) {
                zzbrrVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    public final void zza(final boolean z) {
        synchronized (this.zzi) {
            try {
                if (this.zzp != null) {
                    if (!((Boolean) n42.d.c.zza(zzbbw.zzjU)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        zzc(z);
                    } else {
                        zzbzo.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbri
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzc(z);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(java.util.Map r20) {
        /*
            Method dump skipped, instruction units count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrk.zzb(java.util.Map):void");
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }
}
