package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;

/* JADX INFO: loaded from: classes.dex */
public final class r72 extends zzaxm implements s72 {
    @Override // defpackage.s72
    public final String zze() {
        Parcel parcelZzdb = zzdb(1, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // defpackage.s72
    public final String zzf() {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }
}
