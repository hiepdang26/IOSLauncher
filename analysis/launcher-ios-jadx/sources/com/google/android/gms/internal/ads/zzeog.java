package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.hg0;
import defpackage.rc2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzeog implements zzevn {
    public final rc2 zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzeog(rc2 rc2Var, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        hg0.j(rc2Var, "the adSize must not be null");
        this.zza = rc2Var;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = f;
        this.zzf = i;
        this.zzg = i2;
        this.zzh = str3;
        this.zzi = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzffu.zzf(bundle, "smart_w", "full", this.zza.k == -1);
        zzffu.zzf(bundle, "smart_h", "auto", this.zza.h == -2);
        zzffu.zzg(bundle, "ene", true, this.zza.p);
        zzffu.zzf(bundle, "rafmt", "102", this.zza.s);
        zzffu.zzf(bundle, "rafmt", "103", this.zza.t);
        zzffu.zzf(bundle, "rafmt", "105", this.zza.u);
        zzffu.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzffu.zzg(bundle, "interscroller_slot", true, this.zza.u);
        zzffu.zzc(bundle, "format", this.zzb);
        zzffu.zzf(bundle, "fluid", "height", this.zzc);
        zzffu.zzf(bundle, "sz", this.zzd, !TextUtils.isEmpty(this.zzd));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        zzffu.zzf(bundle, "sc", this.zzh, !TextUtils.isEmpty(this.zzh));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        rc2[] rc2VarArr = this.zza.m;
        if (rc2VarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.h);
            bundle2.putInt("width", this.zza.k);
            bundle2.putBoolean("is_fluid_height", this.zza.o);
            arrayList.add(bundle2);
        } else {
            for (rc2 rc2Var : rc2VarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", rc2Var.o);
                bundle3.putInt("height", rc2Var.h);
                bundle3.putInt("width", rc2Var.k);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
