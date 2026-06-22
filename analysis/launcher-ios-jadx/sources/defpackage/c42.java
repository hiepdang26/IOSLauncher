package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class c42 extends t12 {
    public final /* synthetic */ eb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c42(eb ebVar, Looper looper) {
        super(looper);
        this.a = ebVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.a.zzd.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 7) {
                x12 x12Var = (x12) message.obj;
                x12Var.getClass();
                x12Var.d();
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !this.a.enableLocalFallback()) || message.what == 5)) && !this.a.isConnecting()) {
            x12 x12Var2 = (x12) message.obj;
            x12Var2.getClass();
            x12Var2.d();
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            this.a.zzB = new vl(message.arg2);
            if (eb.zzo(this.a)) {
                eb ebVar = this.a;
                if (!ebVar.zzC) {
                    ebVar.b(3, null);
                    return;
                }
            }
            eb ebVar2 = this.a;
            vl vlVar = ebVar2.zzB != null ? ebVar2.zzB : new vl(8);
            this.a.zzc.o(vlVar);
            this.a.onConnectionFailed(vlVar);
            return;
        }
        if (i3 == 5) {
            eb ebVar3 = this.a;
            vl vlVar2 = ebVar3.zzB != null ? ebVar3.zzB : new vl(8);
            this.a.zzc.o(vlVar2);
            this.a.onConnectionFailed(vlVar2);
            return;
        }
        if (i3 == 3) {
            Object obj = message.obj;
            vl vlVar3 = new vl(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.a.zzc.o(vlVar3);
            this.a.onConnectionFailed(vlVar3);
            return;
        }
        if (i3 == 6) {
            this.a.b(5, null);
            eb ebVar4 = this.a;
            if (ebVar4.zzw != null) {
                ebVar4.zzw.onConnectionSuspended(message.arg2);
            }
            this.a.onConnectionSuspended(message.arg2);
            eb.zzn(this.a, 5, 1, null);
            return;
        }
        if (i3 == 2 && !this.a.isConnected()) {
            x12 x12Var3 = (x12) message.obj;
            x12Var3.getClass();
            x12Var3.d();
            return;
        }
        int i4 = message.what;
        if (i4 != 2 && i4 != 1 && i4 != 7) {
            new Exception();
            return;
        }
        x12 x12Var4 = (x12) message.obj;
        synchronized (x12Var4) {
            try {
                bool = x12Var4.a;
                if (x12Var4.b) {
                    x12Var4.toString();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            eb ebVar5 = x12Var4.f;
            int i5 = x12Var4.d;
            if (i5 != 0) {
                ebVar5.b(1, null);
                Bundle bundle = x12Var4.e;
                x12Var4.a(new vl(i5, bundle != null ? (PendingIntent) bundle.getParcelable(eb.KEY_PENDING_INTENT) : null));
            } else if (!x12Var4.b()) {
                ebVar5.b(1, null);
                x12Var4.a(new vl(8, null));
            }
        }
        synchronized (x12Var4) {
            x12Var4.b = true;
        }
        x12Var4.d();
    }
}
