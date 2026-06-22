package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class g92 implements ServiceConnection {
    public final int a;
    public final /* synthetic */ eb b;

    public g92(eb ebVar, int i) {
        this.b = ebVar;
        this.a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        eb ebVar = this.b;
        if (iBinder == null) {
            eb.zzk(ebVar, 16);
            return;
        }
        synchronized (ebVar.zzq) {
            try {
                eb ebVar2 = this.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                ebVar2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof wd0)) ? new n22(iBinder) : (wd0) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b.zzl(0, null, this.a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.b.zzq) {
            this.b.zzr = null;
        }
        eb ebVar = this.b;
        int i = this.a;
        Handler handler = ebVar.zzb;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
