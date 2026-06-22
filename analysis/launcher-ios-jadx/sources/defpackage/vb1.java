package defpackage;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class vb1 implements Closeable, AutoCloseable {
    private Reader reader;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(Throwable th, oe oeVar) throws Exception {
        if (th != null) {
            try {
                k31.p(oeVar);
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                return;
            }
        }
        if (oeVar instanceof AutoCloseable) {
            oeVar.close();
            return;
        }
        if (oeVar instanceof ExecutorService) {
            e.y((ExecutorService) oeVar);
            return;
        }
        if (oeVar instanceof TypedArray) {
            ((TypedArray) oeVar).recycle();
            return;
        }
        if (oeVar instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) oeVar).release();
            return;
        }
        if (oeVar instanceof MediaDrm) {
            ((MediaDrm) oeVar).release();
        } else if (oeVar instanceof DrmManagerClient) {
            ((DrmManagerClient) oeVar).release();
        } else {
            if (!(oeVar instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) oeVar).release();
        }
    }

    public static vb1 create(ks0 ks0Var, String str) {
        String str2;
        Charset charset = StandardCharsets.UTF_8;
        if (ks0Var != null) {
            try {
                str2 = ks0Var.c;
            } catch (IllegalArgumentException unused) {
            }
            Charset charsetForName = str2 != null ? Charset.forName(str2) : null;
            if (charsetForName == null) {
                try {
                    ks0Var = ks0.a(ks0Var + "; charset=utf-8");
                } catch (IllegalArgumentException unused2) {
                    ks0Var = null;
                }
            } else {
                charset = charsetForName;
            }
        }
        fe feVar = new fe();
        int length = str.length();
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (length < 0) {
            throw new IllegalArgumentException(k31.j(length, 0, "endIndex < beginIndex: ", " < "));
        }
        if (length > str.length()) {
            StringBuilder sbL = uo.l(length, "endIndex > string.length: ", " > ");
            sbL.append(str.length());
            throw new IllegalArgumentException(sbL.toString());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(xq1.a)) {
            feVar.O(0, length, str);
        } else {
            byte[] bytes = str.substring(0, length).getBytes(charset);
            feVar.J(bytes, 0, bytes.length);
        }
        return create(ks0Var, feVar.h, feVar);
    }

    public final InputStream byteStream() {
        return source().y();
    }

    public final byte[] bytes() throws Exception {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(uo.f("Cannot buffer entire body for content length: ", jContentLength));
        }
        oe oeVarSource = source();
        try {
            byte[] bArrJ = oeVarSource.j();
            a(null, oeVarSource);
            if (jContentLength == -1 || jContentLength == bArrJ.length) {
                return bArrJ;
            }
            StringBuilder sb = new StringBuilder("Content-Length (");
            sb.append(jContentLength);
            sb.append(") and stream length (");
            throw new IOException(uo.j(sb, bArrJ.length, ") disagree"));
        } finally {
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        oe oeVarSource = source();
        ks0 ks0VarContentType = contentType();
        Charset charsetForName = StandardCharsets.UTF_8;
        if (ks0VarContentType != null) {
            try {
                String str = ks0VarContentType.c;
                if (str != null) {
                    charsetForName = Charset.forName(str);
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        ub1 ub1Var = new ub1(oeVarSource, charsetForName);
        this.reader = ub1Var;
        return ub1Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        wq1.c(source());
    }

    public abstract long contentLength();

    public abstract ks0 contentType();

    public abstract oe source();

    public final String string() throws Exception {
        Charset charsetForName;
        oe oeVarSource = source();
        try {
            ks0 ks0VarContentType = contentType();
            if (ks0VarContentType != null) {
                charsetForName = StandardCharsets.UTF_8;
                try {
                    String str = ks0VarContentType.c;
                    if (str != null) {
                        charsetForName = Charset.forName(str);
                    }
                } catch (IllegalArgumentException unused) {
                }
            } else {
                charsetForName = StandardCharsets.UTF_8;
            }
            String strX = oeVarSource.x(wq1.a(oeVarSource, charsetForName));
            a(null, oeVarSource);
            return strX;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (oeVarSource != null) {
                    a(th, oeVarSource);
                }
                throw th2;
            }
        }
    }

    public static vb1 create(ks0 ks0Var, byte[] bArr) {
        fe feVar = new fe();
        if (bArr != null) {
            feVar.J(bArr, 0, bArr.length);
            return create(ks0Var, bArr.length, feVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static vb1 create(ks0 ks0Var, df dfVar) {
        fe feVar = new fe();
        if (dfVar != null) {
            dfVar.m(feVar);
            return create(ks0Var, dfVar.i(), feVar);
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public static vb1 create(ks0 ks0Var, long j, oe oeVar) {
        if (oeVar != null) {
            return new h81(ks0Var, j, oeVar, 1);
        }
        throw new NullPointerException("source == null");
    }
}
