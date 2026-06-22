package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import defpackage.e9;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.k92;
import defpackage.ug1;
import defpackage.x82;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzdni extends zzbfw {
    private final Context zza;
    private final zzdjb zzb;
    private zzdkb zzc;
    private zzdiw zzd;

    public zzdni(Context context, zzdjb zzdjbVar, zzdkb zzdkbVar, zzdiw zzdiwVar) {
        this.zza = context;
        this.zzb = zzdjbVar;
        this.zzc = zzdkbVar;
        this.zzd = zzdiwVar;
    }

    private final zzber zzd(String str) {
        return new zzdnh(this, "_videoMediaView");
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final x82 zze() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final zzbfa zzf() {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            hd2.B.g.zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final zzbfd zzg(String str) {
        return (zzbfd) this.zzb.zzh().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final he0 zzh() {
        return new gy0(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final String zzi() {
        return this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final List zzk() {
        try {
            ug1 ug1VarZzh = this.zzb.zzh();
            ug1 ug1VarZzi = this.zzb.zzi();
            String[] strArr = new String[ug1VarZzh.i + ug1VarZzi.i];
            int i = 0;
            for (int i2 = 0; i2 < ug1VarZzh.i; i2++) {
                strArr[i] = (String) ug1VarZzh.f(i2);
                i++;
            }
            for (int i3 = 0; i3 < ug1VarZzi.i; i3++) {
                strArr[i] = (String) ug1VarZzi.f(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            hd2.B.g.zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzl() {
        zzdiw zzdiwVar = this.zzd;
        if (zzdiwVar != null) {
            zzdiwVar.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzm() {
        try {
            String strZzC = this.zzb.zzC();
            if (Objects.equals(strZzC, "Google")) {
                k92.h("Illegal argument specified for omid partner name.");
                return;
            }
            if (TextUtils.isEmpty(strZzC)) {
                k92.h("Not starting OMID session. OM partner name has not been configured.");
                return;
            }
            zzdiw zzdiwVar = this.zzd;
            if (zzdiwVar != null) {
                zzdiwVar.zzf(strZzC, false);
            }
        } catch (NullPointerException e) {
            hd2.B.g.zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzn(String str) {
        zzdiw zzdiwVar = this.zzd;
        if (zzdiwVar != null) {
            zzdiwVar.zzF(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzo() {
        zzdiw zzdiwVar = this.zzd;
        if (zzdiwVar != null) {
            zzdiwVar.zzI();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzp(he0 he0Var) {
        zzdiw zzdiwVar;
        Object objR = gy0.r(he0Var);
        if (!(objR instanceof View) || this.zzb.zzu() == null || (zzdiwVar = this.zzd) == null) {
            return;
        }
        zzdiwVar.zzJ((View) objR);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzq() {
        zzdiw zzdiwVar = this.zzd;
        return (zzdiwVar == null || zzdiwVar.zzW()) && this.zzb.zzr() != null && this.zzb.zzs() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzr(he0 he0Var) {
        zzdkb zzdkbVar;
        Object objR = gy0.r(he0Var);
        if (!(objR instanceof ViewGroup) || (zzdkbVar = this.zzc) == null || !zzdkbVar.zzf((ViewGroup) objR)) {
            return false;
        }
        this.zzb.zzq().zzar(zzd("_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzs(he0 he0Var) {
        zzdkb zzdkbVar;
        Object objR = gy0.r(he0Var);
        if (!(objR instanceof ViewGroup) || (zzdkbVar = this.zzc) == null || !zzdkbVar.zzg((ViewGroup) objR)) {
            return false;
        }
        this.zzb.zzs().zzar(zzd("_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzt() {
        zzeeo zzeeoVarZzu = this.zzb.zzu();
        if (zzeeoVarZzu == null) {
            k92.h("Trying to start OMID session before creation.");
            return false;
        }
        hd2.B.w.zzk(zzeeoVarZzu.zza());
        if (this.zzb.zzr() == null) {
            return true;
        }
        this.zzb.zzr().zzd("onSdkLoaded", new e9(0));
        return true;
    }
}
