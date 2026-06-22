package defpackage;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public final class vb implements jp1 {
    public final LinkedHashMap a = new LinkedHashMap();

    public vb(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set linkedHashSet = (Set) this.a.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet(1);
                this.a.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // defpackage.jp1
    public final X509Certificate a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = (Set) this.a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof vb) && ((vb) obj).a.equals(this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
