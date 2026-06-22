package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import defpackage.k92;
import defpackage.nj;
import defpackage.us;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkf implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdoa zzd;
    private final nj zze;
    private zzbgx zzf;
    private zzbix zzg;

    public zzdkf(zzdoa zzdoaVar, nj njVar) {
        this.zzd = zzdoaVar;
        this.zze = njVar;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zza != null && this.zzb != null) {
            HashMap map = new HashMap();
            map.put("id", this.zza);
            ((us) this.zze).getClass();
            map.put("time_interval", String.valueOf(System.currentTimeMillis() - this.zzb.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.zzd.zzj("sendMessageToNativeJs", map);
        }
        zzd();
    }

    public final zzbgx zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf == null || this.zzb == null) {
            return;
        }
        zzd();
        try {
            this.zzf.zze();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void zzc(final zzbgx zzbgxVar) {
        this.zzf = zzbgxVar;
        zzbix zzbixVar = this.zzg;
        if (zzbixVar != null) {
            this.zzd.zzn("/unconfirmedClick", zzbixVar);
        }
        zzbix zzbixVar2 = new zzbix() { // from class: com.google.android.gms.internal.ads.zzdke
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                zzdkf zzdkfVar = this.zza;
                try {
                    zzdkfVar.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    k92.e("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzbgx zzbgxVar2 = zzbgxVar;
                zzdkfVar.zza = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzbgxVar2 == null) {
                    k92.d("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzbgxVar2.zzf(str);
                } catch (RemoteException e) {
                    k92.i("#007 Could not call remote method.", e);
                }
            }
        };
        this.zzg = zzbixVar2;
        this.zzd.zzl("/unconfirmedClick", zzbixVar2);
    }
}
