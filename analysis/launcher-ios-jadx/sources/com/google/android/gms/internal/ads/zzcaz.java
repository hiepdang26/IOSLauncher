package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import defpackage.hg0;

/* JADX INFO: loaded from: classes.dex */
public final class zzcaz {
    private final Context zza;
    private final zzcbk zzb;
    private final ViewGroup zzc;
    private zzcay zzd;

    public zzcaz(Context context, ViewGroup viewGroup, zzcej zzcejVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcejVar;
        this.zzd = null;
    }

    public final zzcay zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcay zzcayVar = this.zzd;
        if (zzcayVar != null) {
            return zzcayVar.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        hg0.g("The underlay may only be modified from the UI thread.");
        zzcay zzcayVar = this.zzd;
        if (zzcayVar != null) {
            zzcayVar.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzcbj zzcbjVar) {
        if (this.zzd != null) {
            return;
        }
        zzbcd.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
        Context context = this.zza;
        zzcbk zzcbkVar = this.zzb;
        zzcay zzcayVar = new zzcay(context, zzcbkVar, i5, z, zzcbkVar.zzm().zza(), zzcbjVar);
        this.zzd = zzcayVar;
        this.zzc.addView(zzcayVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzd.zzF(i, i2, i3, i4);
        this.zzb.zzz(false);
    }

    public final void zze() {
        hg0.g("onDestroy must be called from the UI thread.");
        zzcay zzcayVar = this.zzd;
        if (zzcayVar != null) {
            zzcayVar.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        hg0.g("onPause must be called from the UI thread.");
        zzcay zzcayVar = this.zzd;
        if (zzcayVar != null) {
            zzcayVar.zzu();
        }
    }

    public final void zzg(int i) {
        zzcay zzcayVar = this.zzd;
        if (zzcayVar != null) {
            zzcayVar.zzC(i);
        }
    }
}
