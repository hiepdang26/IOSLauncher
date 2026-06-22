package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.hs0;
import defpackage.os;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxi extends b0 {
    public static final Parcelable.Creator<zzbxi> CREATOR = new zzbxj();
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final List zze;
    public final boolean zzf;
    public final boolean zzg;
    public final List zzh;

    public zzbxi(String str, String str2, boolean z, boolean z2, List list, boolean z3, boolean z4, List list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = z2;
        this.zze = list;
        this.zzf = z3;
        this.zzg = z4;
        this.zzh = list2 == null ? new ArrayList() : list2;
    }

    public static zzbxi zza(JSONObject jSONObject) {
        return new zzbxi(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), hs0.u(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), hs0.u(jSONObject.optJSONArray("webview_permissions"), null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 2, str);
        os.z(parcel, 3, this.zzb);
        boolean z = this.zzc;
        os.G(parcel, 4, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzd;
        os.G(parcel, 5, 4);
        parcel.writeInt(z2 ? 1 : 0);
        os.B(parcel, 6, this.zze);
        boolean z3 = this.zzf;
        os.G(parcel, 7, 4);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.zzg;
        os.G(parcel, 8, 4);
        parcel.writeInt(z4 ? 1 : 0);
        os.B(parcel, 9, this.zzh);
        os.F(iE, parcel);
    }
}
