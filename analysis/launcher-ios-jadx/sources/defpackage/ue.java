package defpackage;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ue implements ib1 {
    public final /* synthetic */ int a;
    public final kc b;

    public ue(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new kc();
                break;
            default:
                this.b = new kc();
                break;
        }
    }

    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                return this.b.c(ImageDecoder.createSource((ByteBuffer) obj), i, i2, g01Var);
            default:
                return this.b.c(ImageDecoder.createSource(cf.b((InputStream) obj)), i, i2, g01Var);
        }
    }

    @Override // defpackage.ib1
    public final /* bridge */ /* synthetic */ boolean b(Object obj, g01 g01Var) {
        switch (this.a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
