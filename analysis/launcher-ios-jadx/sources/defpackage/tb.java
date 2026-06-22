package defpackage;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class tb extends p02 {
    public final jp1 m;

    public tb(jp1 jp1Var) {
        this.m = jp1Var;
    }

    @Override // defpackage.p02
    public final List c(String str, List list) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Certificate) arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateA = this.m.a(x509Certificate);
            if (x509CertificateA == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate2.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate2);
                        } catch (GeneralSecurityException unused) {
                        }
                    }
                }
                if (!z) {
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateA)) {
                arrayList.add(x509CertificateA);
            }
            if (x509CertificateA.getIssuerDN().equals(x509CertificateA.getSubjectDN())) {
                try {
                    x509CertificateA.verify(x509CertificateA.getPublicKey());
                    return arrayList;
                } catch (GeneralSecurityException unused2) {
                }
            }
            z = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof tb) && ((tb) obj).m.equals(this.m);
    }

    public final int hashCode() {
        return this.m.hashCode();
    }
}
