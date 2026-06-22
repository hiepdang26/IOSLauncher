package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import defpackage.p72;
import defpackage.s72;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdlc implements zzdjj {
    private final zzbpb zza;
    private final zzcxi zzb;
    private final zzcwo zzc;
    private final zzdeo zzd;
    private final Context zze;
    private final zzfel zzf;
    private final or1 zzg;
    private final zzffg zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbox zzl;
    private final zzboy zzm;

    public zzdlc(zzbox zzboxVar, zzboy zzboyVar, zzbpb zzbpbVar, zzcxi zzcxiVar, zzcwo zzcwoVar, zzdeo zzdeoVar, Context context, zzfel zzfelVar, or1 or1Var, zzffg zzffgVar) {
        this.zzl = zzboxVar;
        this.zzm = zzboyVar;
        this.zza = zzbpbVar;
        this.zzb = zzcxiVar;
        this.zzc = zzcwoVar;
        this.zzd = zzdeoVar;
        this.zze = context;
        this.zzf = zzfelVar;
        this.zzg = or1Var;
        this.zzh = zzffgVar;
    }

    private final void zzb(View view) {
        try {
            zzbpb zzbpbVar = this.zza;
            if (zzbpbVar != null && !zzbpbVar.zzA()) {
                this.zza.zzw(new gy0(view));
                this.zzc.onAdClicked();
                if (((Boolean) n42.d.c.zza(zzbbw.zzjR)).booleanValue()) {
                    this.zzd.zzdG();
                    return;
                }
                return;
            }
            zzbox zzboxVar = this.zzl;
            if (zzboxVar != null && !zzboxVar.zzx()) {
                this.zzl.zzs(new gy0(view));
                this.zzc.onAdClicked();
                if (((Boolean) n42.d.c.zza(zzbbw.zzjR)).booleanValue()) {
                    this.zzd.zzdG();
                    return;
                }
                return;
            }
            zzboy zzboyVar = this.zzm;
            if (zzboyVar == null || zzboyVar.zzv()) {
                return;
            }
            this.zzm.zzq(new gy0(view));
            this.zzc.onAdClicked();
            if (((Boolean) n42.d.c.zza(zzbbw.zzjR)).booleanValue()) {
                this.zzd.zzdG();
            }
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzA() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzB() {
        return this.zzf.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzC(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzj(s72 s72Var) {
        k92.h("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzL) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzm(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzj) {
            k92.h("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzf.zzL) {
            zzb(view2);
        } else {
            k92.h("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = hd2.B.m.l(this.zze, this.zzg.g, this.zzf.zzC.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbpb zzbpbVar = this.zza;
                if (zzbpbVar != null && !zzbpbVar.zzB()) {
                    this.zza.zzx();
                    this.zzb.zza();
                    return;
                }
                zzbox zzboxVar = this.zzl;
                if (zzboxVar != null && !zzboxVar.zzy()) {
                    this.zzl.zzt();
                    this.zzb.zza();
                    return;
                }
                zzboy zzboyVar = this.zzm;
                if (zzboyVar == null || zzboyVar.zzw()) {
                    return;
                }
                this.zzm.zzr();
                this.zzb.zza();
            }
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzs(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzt(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzu(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzv() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzw(p72 p72Var) {
        k92.h("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzx(zzbgx zzbgxVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd A[Catch: JSONException -> 0x0045, RemoteException -> 0x012d, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0045, blocks: (B:48:0x00b4, B:50:0x00cd), top: B:70:0x00b4 }] */
    @Override // com.google.android.gms.internal.ads.zzdjj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzy(android.view.View r10, java.util.Map r11, java.util.Map r12, android.view.View.OnTouchListener r13, android.view.View.OnClickListener r14) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlc.zzy(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzz(View view, Map map) {
        try {
            gy0 gy0Var = new gy0(view);
            zzbpb zzbpbVar = this.zza;
            if (zzbpbVar != null) {
                zzbpbVar.zzz(gy0Var);
                return;
            }
            zzbox zzboxVar = this.zzl;
            if (zzboxVar != null) {
                zzboxVar.zzw(gy0Var);
                return;
            }
            zzboy zzboyVar = this.zzm;
            if (zzboyVar != null) {
                zzboyVar.zzu(gy0Var);
            }
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }
}
