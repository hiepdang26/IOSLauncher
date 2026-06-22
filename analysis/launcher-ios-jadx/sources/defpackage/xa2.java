package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class xa2 extends y42 {
    public final j2 g;

    public xa2(j2 j2Var) {
        this.g = j2Var;
    }

    @Override // defpackage.a52
    public final void zzc() {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdClicked();
        }
    }

    @Override // defpackage.a52
    public final void zzd() {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdClosed();
        }
    }

    @Override // defpackage.a52
    public final void zzf(j92 j92Var) {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdFailedToLoad(j92Var.b());
        }
    }

    @Override // defpackage.a52
    public final void zzg() {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdImpression();
        }
    }

    @Override // defpackage.a52
    public final void zzi() {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdLoaded();
        }
    }

    @Override // defpackage.a52
    public final void zzj() {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdOpened();
        }
    }

    @Override // defpackage.a52
    public final void zzk() {
        j2 j2Var = this.g;
        if (j2Var != null) {
            j2Var.onAdSwipeGestureClicked();
        }
    }

    @Override // defpackage.a52
    public final void zzh() {
    }

    @Override // defpackage.a52
    public final void zze(int i) {
    }
}
