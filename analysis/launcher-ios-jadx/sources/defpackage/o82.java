package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class o82 extends zzaxm implements q82 {
    public o82(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    @Override // defpackage.q82
    public final void zze(String str, he0 he0Var, he0 he0Var2) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, he0Var2);
        zzdc(1, parcelZza);
    }
}
