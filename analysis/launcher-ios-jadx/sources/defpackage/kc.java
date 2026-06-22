package defpackage;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class kc implements ib1 {
    public final /* synthetic */ int a;
    public final oc b;

    public kc() {
        this.a = 0;
        this.b = new jl1(9);
    }

    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                return c(h0.d(obj), i, i2, g01Var);
            default:
                return pc.b(this.b, ((wi1) obj).b());
        }
    }

    @Override // defpackage.ib1
    public final /* bridge */ /* synthetic */ boolean b(Object obj, g01 g01Var) {
        switch (this.a) {
            case 0:
                h0.u(obj);
                break;
            default:
                break;
        }
        return true;
    }

    public pc c(ImageDecoder.Source source, int i, int i2, g01 g01Var) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new wt(i, i2, g01Var));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            bitmapDecodeBitmap.getWidth();
            bitmapDecodeBitmap.getHeight();
        }
        return new pc((jl1) this.b, bitmapDecodeBitmap);
    }

    public kc(oc ocVar) {
        this.a = 1;
        this.b = ocVar;
    }
}
