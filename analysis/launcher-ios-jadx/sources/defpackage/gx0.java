package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes.dex */
public final class gx0 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ gx0(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.a) {
            case 1:
                vq1.f().post(new eh1(this, true, 0));
                break;
            default:
                super.onAvailable(network);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        switch (this.a) {
            case 0:
                qg0.l(network, "network");
                qg0.l(networkCapabilities, "capabilities");
                ka0 ka0VarJ = ka0.j();
                int i = ix0.a;
                networkCapabilities.toString();
                ka0VarJ.getClass();
                hx0 hx0Var = (hx0) this.b;
                hx0Var.b(ix0.a(hx0Var.f));
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        boolean z = false;
        Object[] objArr = 0;
        switch (this.a) {
            case 0:
                qg0.l(network, "network");
                ka0 ka0VarJ = ka0.j();
                int i = ix0.a;
                ka0VarJ.getClass();
                hx0 hx0Var = (hx0) this.b;
                hx0Var.b(ix0.a(hx0Var.f));
                break;
            default:
                vq1.f().post(new eh1(this, z, objArr == true ? 1 : 0));
                break;
        }
    }
}
