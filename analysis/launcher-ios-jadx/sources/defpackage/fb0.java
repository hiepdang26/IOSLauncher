package defpackage;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class fb0 {
    public final do1 a;
    public final qi b;
    public final List c;
    public final List d;

    public fb0(do1 do1Var, qi qiVar, List list, List list2) {
        this.a = do1Var;
        this.b = qiVar;
        this.c = list;
        this.d = list2;
    }

    public static fb0 a(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        qi qiVarA = qi.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        do1 do1VarA = do1.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listK = peerCertificates != null ? wq1.k(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new fb0(do1VarA, qiVarA, listK, localCertificates != null ? wq1.k(localCertificates) : Collections.EMPTY_LIST);
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Certificate certificate = (Certificate) it.next();
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof fb0)) {
            return false;
        }
        fb0 fb0Var = (fb0) obj;
        return this.a.equals(fb0Var.a) && this.b.equals(fb0Var.b) && this.c.equals(fb0Var.c) && this.d.equals(fb0Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Handshake{tlsVersion=" + this.a + " cipherSuite=" + this.b + " peerCertificates=" + b(this.c) + " localCertificates=" + b(this.d) + '}';
    }
}
