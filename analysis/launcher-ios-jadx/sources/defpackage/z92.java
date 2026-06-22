package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class z92 extends i52 {
    public final /* synthetic */ ba2 g;

    public /* synthetic */ z92(ba2 ba2Var) {
        this.g = ba2Var;
    }

    @Override // defpackage.k52
    public final String zze() {
        return null;
    }

    @Override // defpackage.k52
    public final String zzf() {
        return null;
    }

    @Override // defpackage.k52
    public final void zzg(tb2 tb2Var) {
        zzh(tb2Var, 1);
    }

    @Override // defpackage.k52
    public final void zzh(tb2 tb2Var, int i) {
        k92.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        ka2.b.post(new fl0(this, 28));
    }

    @Override // defpackage.k52
    public final boolean zzi() {
        return false;
    }
}
