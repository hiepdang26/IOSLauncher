package defpackage;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class vc1 {
    public final c3 a;
    public final mc1 b;
    public final iy c;
    public final List d;
    public int e;
    public List f;
    public final ArrayList g;

    public vc1(c3 c3Var, mc1 mc1Var, d81 d81Var, iy iyVar) {
        List list = Collections.EMPTY_LIST;
        this.d = list;
        this.f = list;
        this.g = new ArrayList();
        this.a = c3Var;
        this.b = mc1Var;
        this.c = iyVar;
        List<Proxy> listSelect = c3Var.g.select(c3Var.a.l());
        this.d = (listSelect == null || listSelect.isEmpty()) ? wq1.k(Proxy.NO_PROXY) : wq1.j(listSelect);
        this.e = 0;
    }

    public final t3 a() throws SocketException, UnknownHostException {
        String hostName;
        int port;
        boolean zContains;
        if (this.e >= this.d.size() && this.g.isEmpty()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.e < this.d.size()) {
            boolean z = this.e < this.d.size();
            c3 c3Var = this.a;
            if (!z) {
                throw new SocketException("No route to " + c3Var.a.d + "; exhausted proxy configurations: " + this.d);
            }
            List list = this.d;
            int i = this.e;
            this.e = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            this.f = new ArrayList();
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                od0 od0Var = c3Var.a;
                hostName = od0Var.d;
                port = od0Var.e;
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                hostName = address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
                port = inetSocketAddress.getPort();
            }
            if (port < 1 || port > 65535) {
                throw new SocketException("No route to " + hostName + ":" + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f.add(InetSocketAddress.createUnresolved(hostName, port));
            } else {
                this.c.getClass();
                c3Var.b.getClass();
                if (hostName == null) {
                    throw new UnknownHostException("hostname == null");
                }
                try {
                    List listAsList = Arrays.asList(InetAddress.getAllByName(hostName));
                    if (listAsList.isEmpty()) {
                        throw new UnknownHostException(c3Var.b + " returned no addresses for " + hostName);
                    }
                    int size = listAsList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f.add(new InetSocketAddress((InetAddress) listAsList.get(i2), port));
                    }
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostName));
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
            int size2 = this.f.size();
            for (int i3 = 0; i3 < size2; i3++) {
                tc1 tc1Var = new tc1(this.a, proxy, (InetSocketAddress) this.f.get(i3));
                mc1 mc1Var = this.b;
                synchronized (mc1Var) {
                    zContains = ((LinkedHashSet) mc1Var.h).contains(tc1Var);
                }
                if (zContains) {
                    this.g.add(tc1Var);
                } else {
                    arrayList.add(tc1Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.g);
            this.g.clear();
        }
        return new t3(arrayList);
    }
}
