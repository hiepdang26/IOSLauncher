package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bb2 extends x12 {
    public final /* synthetic */ eb g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb2(eb ebVar, int i) {
        super(ebVar, i, null);
        this.g = ebVar;
    }

    @Override // defpackage.x12
    public final void a(vl vlVar) {
        eb ebVar = this.g;
        if (ebVar.enableLocalFallback() && eb.zzo(ebVar)) {
            eb.zzk(ebVar, 16);
        } else {
            ebVar.zzc.o(vlVar);
            ebVar.onConnectionFailed(vlVar);
        }
    }

    @Override // defpackage.x12
    public final boolean b() {
        this.g.zzc.o(vl.k);
        return true;
    }
}
