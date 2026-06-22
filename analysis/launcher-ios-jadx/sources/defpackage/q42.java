package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class q42 extends zzaxn implements a72 {
    public final a70 g;

    public q42(a70 a70Var) {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
        this.g = a70Var;
    }

    @Override // defpackage.a72
    public final void zzb() {
        a70 a70Var = this.g;
        if (a70Var != null) {
            a70Var.a();
        }
    }

    @Override // defpackage.a72
    public final void zzc() {
        a70 a70Var = this.g;
        if (a70Var != null) {
            a70Var.b();
        }
    }

    @Override // defpackage.a72
    public final void zzd(j92 j92Var) {
        a70 a70Var = this.g;
        if (a70Var != null) {
            j92Var.getClass();
            a70Var.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
            zzaxo.zzc(parcel);
            zzd(j92Var);
        } else if (i == 2) {
            zzf();
        } else if (i == 3) {
            zzc();
        } else if (i == 4) {
            zze();
        } else {
            if (i != 5) {
                return false;
            }
            zzb();
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // defpackage.a72
    public final void zze() {
        a70 a70Var = this.g;
        if (a70Var != null) {
            a70Var.d();
        }
    }

    @Override // defpackage.a72
    public final void zzf() {
        a70 a70Var = this.g;
        if (a70Var != null) {
            a70Var.e();
        }
    }
}
