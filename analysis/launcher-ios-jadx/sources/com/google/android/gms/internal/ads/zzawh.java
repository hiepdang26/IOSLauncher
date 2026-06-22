package com.google.android.gms.internal.ads;

import defpackage.e3;
import defpackage.f3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzawh extends zzaxd {
    public zzawh(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzaroVar, i, 24);
    }

    private final void zzc() {
        f3 f3VarZzh = this.zza.zzh();
        if (f3VarZzh == null) {
            return;
        }
        try {
            e3 e3VarF = f3VarZzh.f();
            String strZza = e3VarF.a;
            int i = zzavs.zza;
            if (strZza != null && strZza.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
                UUID uuidFromString = UUID.fromString(strZza);
                byte[] bArr = new byte[16];
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
                byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
                strZza = zzasz.zza(bArr, true);
            }
            if (strZza != null) {
                synchronized (this.zzd) {
                    this.zzd.zzs(strZza);
                    this.zzd.zzr(e3VarF.b);
                    this.zzd.zzab(6);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxd, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzk();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        if (this.zza.zzq()) {
            zzc();
            return;
        }
        synchronized (this.zzd) {
            this.zzd.zzs((String) this.zze.invoke(null, this.zza.zzb()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final Void zzk() {
        if (this.zza.zzr()) {
            super.zzk();
            return null;
        }
        if (this.zza.zzq()) {
            zzc();
        }
        return null;
    }
}
