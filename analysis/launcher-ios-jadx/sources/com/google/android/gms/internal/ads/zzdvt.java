package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.h82;
import defpackage.hd2;
import defpackage.k92;
import defpackage.m21;
import defpackage.mc2;
import defpackage.n42;
import defpackage.or1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvt implements mc2, zzcfz {
    private final Context zza;
    private final or1 zzb;
    private zzdvi zzc;
    private zzcej zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private h82 zzh;
    private boolean zzi;

    public zzdvt(Context context, or1 or1Var) {
        this.zza = context;
        this.zzb = or1Var;
    }

    private final synchronized boolean zzl(h82 h82Var) {
        zzbbn zzbbnVar = zzbbw.zzia;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            k92.h("Ad inspector had an internal error.");
            try {
                h82Var.zze(zzfgi.zzd(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        }
        if (this.zzc == null) {
            k92.h("Ad inspector had an internal error.");
            try {
                hd2.B.g.zzw(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                h82Var.zze(zzfgi.zzd(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        }
        if (!this.zze && !this.zzf) {
            hd2.B.j.getClass();
            if (System.currentTimeMillis() >= this.zzg + ((long) ((Integer) n42Var.c.zza(zzbbw.zzid)).intValue())) {
                return true;
            }
        }
        k92.h("Ad inspector cannot be opened because it is already open.");
        try {
            h82Var.zze(zzfgi.zzd(19, null, null));
        } catch (RemoteException unused3) {
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfz
    public final synchronized void zza(boolean z, int i, String str, String str2) {
        if (z) {
            k92.a("Ad inspector loaded.");
            this.zze = true;
            zzk("");
            return;
        }
        k92.h("Ad inspector failed to load.");
        try {
            hd2.B.g.zzw(new Exception("Failed to load UI. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2), "InspectorUi.onAdWebViewFinishedLoading 0");
            h82 h82Var = this.zzh;
            if (h82Var != null) {
                h82Var.zze(zzfgi.zzd(17, null, null));
            }
        } catch (RemoteException e) {
            hd2.B.g.zzw(e, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    @Override // defpackage.mc2
    public final void zzdH() {
    }

    @Override // defpackage.mc2
    public final void zzdk() {
    }

    @Override // defpackage.mc2
    public final void zzdq() {
    }

    @Override // defpackage.mc2
    public final synchronized void zzdr() {
        this.zzf = true;
        zzk("");
    }

    @Override // defpackage.mc2
    public final void zzdt() {
    }

    @Override // defpackage.mc2
    public final synchronized void zzdu(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            k92.a("Inspector closed.");
            h82 h82Var = this.zzh;
            if (h82Var != null) {
                try {
                    h82Var.zze(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0L;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzcej zzcejVar = this.zzd;
        if (zzcejVar == null || zzcejVar.zzaE()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzh(zzdvi zzdviVar) {
        this.zzc = zzdviVar;
    }

    public final /* synthetic */ void zzi(String str) {
        JSONObject jSONObjectZze = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObjectZze.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", jSONObjectZze.toString());
    }

    public final synchronized void zzj(h82 h82Var, zzbjr zzbjrVar, zzbjk zzbjkVar, zzbiy zzbiyVar) {
        if (zzl(h82Var)) {
            try {
                hd2 hd2Var = hd2.B;
                zzcew zzcewVar = hd2Var.d;
                zzcej zzcejVarZza = zzcew.zza(this.zza, zzcgd.zza(), "", false, false, null, null, this.zzb, null, null, null, zzbav.zza(), null, null, null, null);
                this.zzd = zzcejVarZza;
                zzcgb zzcgbVarZzN = zzcejVarZza.zzN();
                if (zzcgbVarZzN == null) {
                    k92.h("Failed to obtain a web view for the ad inspector");
                    try {
                        hd2Var.g.zzw(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                        h82Var.zze(zzfgi.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                        return;
                    } catch (RemoteException e) {
                        hd2.B.g.zzw(e, "InspectorUi.openInspector 3");
                        return;
                    }
                }
                this.zzh = h82Var;
                zzcgbVarZzN.zzR(null, null, null, null, null, false, null, null, null, null, null, null, null, zzbjrVar, null, new zzbjq(this.zza), zzbjkVar, zzbiyVar, null);
                zzcgbVarZzN.zzB(this);
                this.zzd.loadUrl((String) n42.d.c.zza(zzbbw.zzib));
                m21.f(this.zza, new AdOverlayInfoParcel(this, this.zzd, this.zzb), true);
                hd2Var.j.getClass();
                this.zzg = System.currentTimeMillis();
            } catch (zzcev e2) {
                k92.j(5);
                try {
                    hd2.B.g.zzw(e2, "InspectorUi.openInspector 0");
                    h82Var.zze(zzfgi.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                } catch (RemoteException e3) {
                    hd2.B.g.zzw(e3, "InspectorUi.openInspector 1");
                }
            }
        }
    }

    public final synchronized void zzk(final String str) {
        if (this.zze && this.zzf) {
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvs
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(str);
                }
            });
        }
    }
}
