package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;

/* JADX INFO: loaded from: classes.dex */
public final class e62 extends zzaxm implements u62 {
    public e62(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // defpackage.u62
    public final void zzc(String str, String str2) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdc(1, parcelZza);
    }
}
