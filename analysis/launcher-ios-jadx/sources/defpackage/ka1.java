package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ka1 extends la1 {
    public final /* synthetic */ ks0 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ int d;

    public ka1(ks0 ks0Var, byte[] bArr, int i, int i2) {
        this.a = ks0Var;
        this.b = i;
        this.c = bArr;
        this.d = i2;
    }

    @Override // defpackage.la1
    public final long contentLength() {
        return this.b;
    }

    @Override // defpackage.la1
    public final ks0 contentType() {
        return this.a;
    }

    @Override // defpackage.la1
    public final void writeTo(ne neVar) {
        neVar.p(this.d, this.c, this.b);
    }
}
