package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class h81 extends vb1 {
    public final /* synthetic */ int g;
    public final long h;
    public final Object i;
    public final oe j;

    public /* synthetic */ h81(Object obj, long j, oe oeVar, int i) {
        this.g = i;
        this.i = obj;
        this.h = j;
        this.j = oeVar;
    }

    @Override // defpackage.vb1
    public final long contentLength() {
        switch (this.g) {
        }
        return this.h;
    }

    @Override // defpackage.vb1
    public final ks0 contentType() {
        switch (this.g) {
            case 0:
                String str = (String) this.i;
                if (str == null) {
                    return null;
                }
                try {
                    return ks0.a(str);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            default:
                return (ks0) this.i;
        }
    }

    @Override // defpackage.vb1
    public final oe source() {
        switch (this.g) {
            case 0:
                return (b81) this.j;
            default:
                return this.j;
        }
    }
}
