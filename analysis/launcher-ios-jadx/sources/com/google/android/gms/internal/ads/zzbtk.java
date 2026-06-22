package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import defpackage.eq1;
import defpackage.fq1;
import defpackage.gy0;
import defpackage.k92;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtk {
    private final View zza;
    private final Map zzb;
    private final zzbym zzc;

    public zzbtk(zzbtj zzbtjVar) {
        View view = zzbtjVar.zza;
        this.zza = view;
        Map map = zzbtjVar.zzb;
        this.zzb = map;
        zzbym zzbymVarZza = zzbte.zza(zzbtjVar.zza.getContext());
        this.zzc = zzbymVarZza;
        if (zzbymVarZza == null || map.isEmpty()) {
            return;
        }
        try {
            zzbymVarZza.zzg(new zzbtl(new gy0(view), new gy0(map)));
        } catch (RemoteException unused) {
            k92.e("Failed to call remote method.");
        }
    }

    public final void zza(List list) {
        if (list == null || list.isEmpty()) {
            k92.h("No click urls were passed to recordClick");
            return;
        }
        if (this.zzc == null) {
            k92.h("Failed to get internal reporting info generator in recordClick.");
        }
        try {
            this.zzc.zzh(list, new gy0(this.zza), new zzbti(this, list));
        } catch (RemoteException e) {
            k92.e("RemoteException recording click: ".concat(e.toString()));
        }
    }

    public final void zzb(List list) {
        if (list == null || list.isEmpty()) {
            k92.h("No impression urls were passed to recordImpression");
            return;
        }
        zzbym zzbymVar = this.zzc;
        if (zzbymVar == null) {
            k92.h("Failed to get internal reporting info generator from recordImpression.");
            return;
        }
        try {
            zzbymVar.zzi(list, new gy0(this.zza), new zzbth(this, list));
        } catch (RemoteException e) {
            k92.e("RemoteException recording impression urls: ".concat(e.toString()));
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzbym zzbymVar = this.zzc;
        if (zzbymVar == null) {
            k92.d("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzbymVar.zzk(new gy0(motionEvent));
        } catch (RemoteException unused) {
            k92.e("Failed to call remote method.");
        }
    }

    public final void zzd(Uri uri, eq1 eq1Var) {
        this.zzc.getClass();
        try {
            this.zzc.zzl(new ArrayList(Arrays.asList(uri)), new gy0(this.zza), new zzbtg(this, eq1Var));
        } catch (RemoteException e) {
            "Internal error: ".concat(e.toString());
            throw null;
        }
    }

    public final void zze(List list, fq1 fq1Var) {
        this.zzc.getClass();
        try {
            this.zzc.zzm(list, new gy0(this.zza), new zzbtf(this, fq1Var));
        } catch (RemoteException e) {
            "Internal error: ".concat(e.toString());
            throw null;
        }
    }
}
