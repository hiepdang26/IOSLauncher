package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.hg0;
import defpackage.k92;
import defpackage.x82;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnb extends zzblj implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbep {
    private View zza;
    private x82 zzb;
    private zzdiw zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdnb(zzdiw zzdiwVar, zzdjb zzdjbVar) {
        this.zza = zzdjbVar.zzf();
        this.zzb = zzdjbVar.zzj();
        this.zzc = zzdiwVar;
        if (zzdjbVar.zzs() != null) {
            zzdjbVar.zzs().zzap(this);
        }
    }

    private final void zzg() {
        View view;
        zzdiw zzdiwVar = this.zzc;
        if (zzdiwVar == null || (view = this.zza) == null) {
            return;
        }
        Map map = Collections.EMPTY_MAP;
        zzdiwVar.zzB(view, map, map, zzdiw.zzX(view));
    }

    private final void zzh() {
        View view = this.zza;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zza);
        }
    }

    private static final void zzi(zzbln zzblnVar, int i) {
        try {
            zzblnVar.zze(i);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzg();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final x82 zzb() {
        hg0.g("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        k92.e("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final zzbfa zzc() {
        hg0.g("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            k92.e("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdiw zzdiwVar = this.zzc;
        if (zzdiwVar == null || zzdiwVar.zzc() == null) {
            return null;
        }
        return zzdiwVar.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zzd() {
        hg0.g("#008 Must be called on the main UI thread.");
        zzh();
        zzdiw zzdiwVar = this.zzc;
        if (zzdiwVar != null) {
            zzdiwVar.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zze(he0 he0Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        zzf(he0Var, new zzdna(this));
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zzf(he0 he0Var, zzbln zzblnVar) {
        hg0.g("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            k92.e("Instream ad can not be shown after destroy().");
            zzi(zzblnVar, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            k92.e("Instream internal error: ".concat(view == null ? "can not get video view." : "can not get video controller."));
            zzi(zzblnVar, 0);
            return;
        }
        if (this.zze) {
            k92.e("Instream ad should not be used again.");
            zzi(zzblnVar, 1);
            return;
        }
        this.zze = true;
        zzh();
        ((ViewGroup) gy0.r(he0Var)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
        zzcab zzcabVar = hd2.B.A;
        zzcab.zza(this.zza, this);
        zzcab.zzb(this.zza, this);
        zzg();
        try {
            zzblnVar.zzf();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
