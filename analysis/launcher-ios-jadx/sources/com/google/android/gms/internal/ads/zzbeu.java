package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbeu extends zzaxm implements zzbew {
    public zzbeu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbew
    public final String zzg() {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbew
    public final List zzh() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }
}
