package defpackage;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface oe extends fi1, ReadableByteChannel {
    long f(fe feVar);

    byte[] j();

    int l(f01 f01Var);

    String x(Charset charset);

    InputStream y();
}
