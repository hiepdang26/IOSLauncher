package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzdeq;

/* JADX INFO: loaded from: classes.dex */
public final class vd2 extends zzbsm {
    public final AdOverlayInfoParcel g;
    public final Activity h;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;

    public vd2(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.g = adOverlayInfoParcel;
        this.h = activity;
    }

    public final synchronized void f() {
        try {
            if (this.j) {
                return;
            }
            mc2 mc2Var = this.g.i;
            if (mc2Var != null) {
                mc2Var.zzdu(4);
            }
            this.j = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean zzH() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzl(Bundle bundle) {
        mc2 mc2Var;
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzhY)).booleanValue();
        Activity activity = this.h;
        if (zBooleanValue && !this.k) {
            activity.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.g;
        if (adOverlayInfoParcel == null) {
            activity.finish();
            return;
        }
        if (z) {
            activity.finish();
            return;
        }
        if (bundle == null) {
            b22 b22Var = adOverlayInfoParcel.h;
            if (b22Var != null) {
                b22Var.onAdClicked();
            }
            zzdeq zzdeqVar = adOverlayInfoParcel.A;
            if (zzdeqVar != null) {
                zzdeqVar.zzdG();
            }
            if (activity.getIntent() != null && activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (mc2Var = adOverlayInfoParcel.i) != null) {
                mc2Var.zzdr();
            }
        }
        m21 m21Var = hd2.B.a;
        m62 m62Var = adOverlayInfoParcel.g;
        if (m21.h(activity, m62Var, adOverlayInfoParcel.o, m62Var.o)) {
            return;
        }
        activity.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzm() {
        if (this.h.isFinishing()) {
            f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzo() {
        mc2 mc2Var = this.g.i;
        if (mc2Var != null) {
            mc2Var.zzdk();
        }
        if (this.h.isFinishing()) {
            f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzr() {
        if (this.i) {
            this.h.finish();
            return;
        }
        this.i = true;
        mc2 mc2Var = this.g.i;
        if (mc2Var != null) {
            mc2Var.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.i);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzu() {
        if (this.h.isFinishing()) {
            f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzv() {
        mc2 mc2Var = this.g.i;
        if (mc2Var != null) {
            mc2Var.zzdt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzx() {
        this.k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzt() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzk(he0 he0Var) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzh(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzp(int i, String[] strArr, int[] iArr) {
    }
}
