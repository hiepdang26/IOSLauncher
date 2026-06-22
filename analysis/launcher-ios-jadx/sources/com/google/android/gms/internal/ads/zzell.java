package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.a52;
import defpackage.a72;
import defpackage.b62;
import defpackage.b92;
import defpackage.cd2;
import defpackage.f52;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.hg0;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
import defpackage.pd2;
import defpackage.rc2;
import defpackage.ta2;
import defpackage.tb2;
import defpackage.u52;
import defpackage.u62;
import defpackage.u82;
import defpackage.v42;
import defpackage.x82;
import defpackage.y62;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzell extends u52 {
    private final Context zza;
    private final a52 zzb;
    private final zzffg zzc;
    private final zzcpk zzd;
    private final ViewGroup zze;
    private final zzdsk zzf;

    public zzell(Context context, a52 a52Var, zzffg zzffgVar, zzcpk zzcpkVar, zzdsk zzdskVar) {
        this.zza = context;
        this.zzb = a52Var;
        this.zzc = zzffgVar;
        this.zzd = zzcpkVar;
        this.zzf = zzdskVar;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        View viewZzd = zzcpkVar.zzd();
        cd2 cd2Var = hd2.B.c;
        frameLayout.addView(viewZzd, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzg().i);
        frameLayout.setMinimumWidth(zzg().l);
        this.zze = frameLayout;
    }

    @Override // defpackage.v52
    public final void zzA() {
        this.zzd.zzh();
    }

    @Override // defpackage.v52
    public final void zzB() {
        hg0.g("destroy must be called on the main UI thread.");
        this.zzd.zzn().zzc(null);
    }

    @Override // defpackage.v52
    public final void zzC(v42 v42Var) {
        k92.g("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final void zzD(a52 a52Var) {
        k92.g("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final void zzE(b62 b62Var) {
        k92.g("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final void zzF(rc2 rc2Var) {
        hg0.g("setAdSize must be called on the main UI thread.");
        zzcpk zzcpkVar = this.zzd;
        if (zzcpkVar != null) {
            zzcpkVar.zzi(this.zze, rc2Var);
        }
    }

    @Override // defpackage.v52
    public final void zzG(u62 u62Var) {
        zzemk zzemkVar = this.zzc.zzc;
        if (zzemkVar != null) {
            zzemkVar.zzm(u62Var);
        }
    }

    @Override // defpackage.v52
    public final void zzH(zzazs zzazsVar) {
    }

    @Override // defpackage.v52
    public final void zzL(boolean z) {
    }

    @Override // defpackage.v52
    public final void zzM(zzbsw zzbswVar) {
    }

    @Override // defpackage.v52
    public final void zzN(boolean z) {
        k92.g("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final void zzO(zzbcr zzbcrVar) {
        k92.g("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final void zzP(m82 m82Var) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkI)).booleanValue()) {
            k92.g("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
            return;
        }
        zzemk zzemkVar = this.zzc.zzc;
        if (zzemkVar != null) {
            try {
                if (!m82Var.zzf()) {
                    this.zzf.zze();
                }
            } catch (RemoteException unused) {
                k92.j(3);
            }
            zzemkVar.zzl(m82Var);
        }
    }

    @Override // defpackage.v52
    public final void zzQ(zzbsz zzbszVar, String str) {
    }

    @Override // defpackage.v52
    public final void zzR(String str) {
    }

    @Override // defpackage.v52
    public final void zzS(zzbvt zzbvtVar) {
    }

    @Override // defpackage.v52
    public final void zzT(String str) {
    }

    @Override // defpackage.v52
    public final void zzU(ta2 ta2Var) {
        k92.g("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final void zzX() {
    }

    @Override // defpackage.v52
    public final boolean zzY() {
        zzcpk zzcpkVar = this.zzd;
        return zzcpkVar != null && zzcpkVar.zzs();
    }

    @Override // defpackage.v52
    public final boolean zzZ() {
        return false;
    }

    @Override // defpackage.v52
    public final boolean zzaa() {
        return false;
    }

    @Override // defpackage.v52
    public final boolean zzab(tb2 tb2Var) {
        k92.g("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    @Override // defpackage.v52
    public final void zzac(y62 y62Var) {
        k92.g("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // defpackage.v52
    public final Bundle zzd() {
        k92.g("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // defpackage.v52
    public final rc2 zzg() {
        hg0.g("getAdSize must be called on the main UI thread.");
        return zzffm.zza(this.zza, Collections.singletonList(this.zzd.zzf()));
    }

    @Override // defpackage.v52
    public final a52 zzi() {
        return this.zzb;
    }

    @Override // defpackage.v52
    public final u62 zzj() {
        return this.zzc.zzn;
    }

    @Override // defpackage.v52
    public final u82 zzk() {
        return this.zzd.zzm();
    }

    @Override // defpackage.v52
    public final x82 zzl() {
        return this.zzd.zze();
    }

    @Override // defpackage.v52
    public final he0 zzn() {
        return new gy0(this.zze);
    }

    @Override // defpackage.v52
    public final String zzr() {
        return this.zzc.zzf;
    }

    @Override // defpackage.v52
    public final String zzs() {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zzg();
        }
        return null;
    }

    @Override // defpackage.v52
    public final String zzt() {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zzg();
        }
        return null;
    }

    @Override // defpackage.v52
    public final void zzx() {
        hg0.g("destroy must be called on the main UI thread.");
        this.zzd.zzb();
    }

    @Override // defpackage.v52
    public final void zzz() {
        hg0.g("destroy must be called on the main UI thread.");
        this.zzd.zzn().zzb(null);
    }

    @Override // defpackage.v52
    public final void zzI(pd2 pd2Var) {
    }

    @Override // defpackage.v52
    public final void zzJ(a72 a72Var) {
    }

    @Override // defpackage.v52
    public final void zzK(b92 b92Var) {
    }

    @Override // defpackage.v52
    public final void zzW(he0 he0Var) {
    }

    @Override // defpackage.v52
    public final void zzy(tb2 tb2Var, f52 f52Var) {
    }
}
