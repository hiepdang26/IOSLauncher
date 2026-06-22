package defpackage;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class zl {
    public final List a;
    public int b = 0;
    public boolean c;
    public boolean d;

    public zl(List list) {
        this.a = list;
    }

    public final yl a(SSLSocket sSLSocket) throws UnknownServiceException {
        yl ylVar;
        boolean z;
        int i = this.b;
        List list = this.a;
        int size = list.size();
        while (true) {
            if (i >= size) {
                ylVar = null;
                break;
            }
            ylVar = (yl) list.get(i);
            if (ylVar.a(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (ylVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + list + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        int i2 = this.b;
        while (true) {
            if (i2 >= list.size()) {
                z = false;
                break;
            }
            if (((yl) list.get(i2)).a(sSLSocket)) {
                z = true;
                break;
            }
            i2++;
        }
        this.c = z;
        ka0 ka0Var = ka0.q;
        boolean z2 = this.d;
        ka0Var.getClass();
        String[] strArr = ylVar.c;
        String[] strArrL = strArr != null ? wq1.l(qi.b, sSLSocket.getEnabledCipherSuites(), strArr) : sSLSocket.getEnabledCipherSuites();
        String[] strArr2 = ylVar.d;
        String[] strArrL2 = strArr2 != null ? wq1.l(wq1.i, sSLSocket.getEnabledProtocols(), strArr2) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        pi piVar = qi.b;
        byte[] bArr = wq1.a;
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (piVar.compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z2 && i3 != -1) {
            String str = supportedCipherSuites[i3];
            int length2 = strArrL.length;
            String[] strArr3 = new String[length2 + 1];
            System.arraycopy(strArrL, 0, strArr3, 0, strArrL.length);
            strArr3[length2] = str;
            strArrL = strArr3;
        }
        xl xlVar = new xl();
        xlVar.a = ylVar.a;
        xlVar.b = strArr;
        xlVar.c = strArr2;
        xlVar.d = ylVar.b;
        xlVar.b(strArrL);
        xlVar.d(strArrL2);
        yl ylVar2 = new yl(xlVar);
        String[] strArr4 = ylVar2.d;
        if (strArr4 != null) {
            sSLSocket.setEnabledProtocols(strArr4);
        }
        String[] strArr5 = ylVar2.c;
        if (strArr5 != null) {
            sSLSocket.setEnabledCipherSuites(strArr5);
        }
        return ylVar;
    }
}
