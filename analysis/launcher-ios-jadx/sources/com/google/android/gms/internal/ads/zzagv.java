package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzagv implements zzbj {
    public static final Parcelable.Creator<zzagv> CREATOR = new zzags();
    public final List zza;

    public zzagv(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzagu) list.get(0)).zzb;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (((zzagu) list.get(i)).zza < j) {
                    z = true;
                    break;
                } else {
                    j = ((zzagu) list.get(i)).zzb;
                    i++;
                }
            }
        }
        zzdi.zzd(!z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzagv.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzagv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbj
    public final /* synthetic */ void zza(zzbf zzbfVar) {
    }
}
