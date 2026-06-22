package defpackage;

import android.os.Message;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzfru;

/* JADX INFO: loaded from: classes.dex */
public final class ja2 extends zzfru {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            hd2.B.g.zzw(e, "AdMobHandler.handleMessage");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th) {
            hd2 hd2Var = hd2.B;
            cd2 cd2Var = hd2Var.c;
            if (hd2Var.g.zzd() != null) {
                try {
                    ((Boolean) zzbeb.zzb.zze()).booleanValue();
                } catch (IllegalStateException unused) {
                }
            }
            throw th;
        }
    }
}
