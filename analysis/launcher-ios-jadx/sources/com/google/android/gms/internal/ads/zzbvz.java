package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.bf1;
import defpackage.os;
import java.util.Arrays;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvz extends b0 {
    public static final Parcelable.Creator<zzbvz> CREATOR = new zzbwa();
    public final String zza;
    public final int zzb;

    public zzbvz(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public static zzbvz zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzbvz(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbvz)) {
            zzbvz zzbvzVar = (zzbvz) obj;
            if (bf1.c(this.zza, zzbvzVar.zza)) {
                if (bf1.c(Integer.valueOf(this.zzb), Integer.valueOf(zzbvzVar.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 2, str);
        int i2 = this.zzb;
        os.G(parcel, 3, 4);
        parcel.writeInt(i2);
        os.F(iE, parcel);
    }
}
