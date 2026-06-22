package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s82 extends zzaxm implements u82 {
    public s82(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // defpackage.u82
    public final Bundle zze() {
        Parcel parcelZzdb = zzdb(5, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // defpackage.u82
    public final ed2 zzf() {
        Parcel parcelZzdb = zzdb(4, zza());
        ed2 ed2Var = (ed2) zzaxo.zza(parcelZzdb, ed2.CREATOR);
        parcelZzdb.recycle();
        return ed2Var;
    }

    @Override // defpackage.u82
    public final String zzg() {
        Parcel parcelZzdb = zzdb(1, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // defpackage.u82
    public final String zzh() {
        Parcel parcelZzdb = zzdb(6, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // defpackage.u82
    public final String zzi() {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // defpackage.u82
    public final List zzj() {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzdb.createTypedArrayList(ed2.CREATOR);
        parcelZzdb.recycle();
        return arrayListCreateTypedArrayList;
    }
}
