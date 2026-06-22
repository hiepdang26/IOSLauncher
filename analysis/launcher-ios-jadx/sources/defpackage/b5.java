package defpackage;

import android.graphics.ImageDecoder;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b5 implements ib1 {
    public final /* synthetic */ int a;
    public final oz1 b;

    public /* synthetic */ b5(oz1 oz1Var, int i) {
        this.a = i;
        this.b = oz1Var;
    }

    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                return oz1.a(ImageDecoder.createSource((ByteBuffer) obj), i, i2, g01Var);
            default:
                return oz1.a(ImageDecoder.createSource(cf.b((InputStream) obj)), i, i2, g01Var);
        }
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) throws IOException {
        switch (this.a) {
            case 0:
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeT = np1.t((ArrayList) this.b.h, (ByteBuffer) obj);
                if (imageHeaderParser$ImageTypeT == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeT == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
            default:
                oz1 oz1Var = this.b;
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeS = np1.s((ArrayList) oz1Var.h, (InputStream) obj, (cq0) oz1Var.i);
                if (imageHeaderParser$ImageTypeS == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeS == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
        }
        return true;
    }
}
