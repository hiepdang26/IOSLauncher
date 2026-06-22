package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class re implements lu0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ re(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        switch (this.a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new ku0(new fy0(bArr), new is0(bArr, (qe) this.b, 1));
            case 1:
                return new ku0(new fy0(obj), new js(0, obj.toString(), (iy) this.b));
            default:
                File file = (File) obj;
                return new ku0(new fy0(file), new js(1, file, (z20) this.b));
        }
    }
}
