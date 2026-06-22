package defpackage;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class t10 implements af0 {
    @Override // defpackage.af0
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // defpackage.af0
    public final int b(InputStream inputStream, cq0 cq0Var) throws Throwable {
        int iE;
        s10 s10Var = new s10(inputStream);
        o10 o10VarC = s10Var.c("Orientation");
        if (o10VarC == null) {
            iE = 1;
        } else {
            try {
                iE = o10VarC.e(s10Var.f);
            } catch (NumberFormatException unused) {
                iE = 1;
            }
        }
        if (iE == 0) {
            return -1;
        }
        return iE;
    }

    @Override // defpackage.af0
    public final int c(ByteBuffer byteBuffer, cq0 cq0Var) {
        AtomicReference atomicReference = cf.a;
        return b(new af(byteBuffer), cq0Var);
    }

    @Override // defpackage.af0
    public final ImageHeaderParser$ImageType d(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
