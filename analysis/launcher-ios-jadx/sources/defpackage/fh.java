package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class fh {
    public static final fh c = new fh(new LinkedHashSet(new ArrayList()), null);
    public final LinkedHashSet a;
    public final p02 b;

    public fh(LinkedHashSet linkedHashSet, p02 p02Var) {
        this.a = linkedHashSet;
        this.b = p02Var;
    }

    public static String b(X509Certificate x509Certificate) {
        if (!uo.r(x509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        StringBuilder sb = new StringBuilder("sha256/");
        try {
            df dfVarF = df.f(MessageDigest.getInstance("SHA-256").digest(df.f(x509Certificate.getPublicKey().getEncoded()).g));
            byte[] bArr = m90.a;
            byte[] bArr2 = dfVarF.g;
            byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
            int length = bArr2.length - (bArr2.length % 3);
            int i = 0;
            for (int i2 = 0; i2 < length; i2 += 3) {
                bArr3[i] = bArr[(bArr2[i2] & 255) >> 2];
                int i3 = i2 + 1;
                bArr3[i + 1] = bArr[((bArr2[i2] & 3) << 4) | ((bArr2[i3] & 255) >> 4)];
                int i4 = i + 3;
                int i5 = (bArr2[i3] & 15) << 2;
                int i6 = i2 + 2;
                bArr3[i + 2] = bArr[i5 | ((bArr2[i6] & 255) >> 6)];
                i += 4;
                bArr3[i4] = bArr[bArr2[i6] & 63];
            }
            int length2 = bArr2.length % 3;
            if (length2 == 1) {
                bArr3[i] = bArr[(bArr2[length] & 255) >> 2];
                bArr3[i + 1] = bArr[(bArr2[length] & 3) << 4];
                bArr3[i + 2] = 61;
                bArr3[i + 3] = 61;
            } else if (length2 == 2) {
                bArr3[i] = bArr[(bArr2[length] & 255) >> 2];
                int i7 = (bArr2[length] & 3) << 4;
                int i8 = length + 1;
                bArr3[i + 1] = bArr[((bArr2[i8] & 255) >> 4) | i7];
                bArr3[i + 2] = bArr[(bArr2[i8] & 15) << 2];
                bArr3[i + 3] = 61;
            }
            try {
                sb.append(new String(bArr3, "US-ASCII"));
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(String str, List list) throws SSLPeerUnverifiedException {
        List list2 = Collections.EMPTY_LIST;
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        if (list2.isEmpty()) {
            return;
        }
        p02 p02Var = this.b;
        if (p02Var != null) {
            list = p02Var.c(str, list);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list2.size() > 0) {
                list2.get(0).getClass();
                throw new ClassCastException();
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            sb.append("\n    ");
            sb.append(b(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            if (list2.get(i3) != null) {
                throw new ClassCastException();
            }
            sb.append("\n    null");
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        return Objects.equals(this.b, fhVar.b) && this.a.equals(fhVar.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (Objects.hashCode(this.b) * 31);
    }
}
