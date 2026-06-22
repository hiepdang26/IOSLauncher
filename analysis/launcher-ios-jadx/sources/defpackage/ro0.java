package defpackage;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public final class ro0 extends BroadcastReceiver {
    public final /* synthetic */ int a = 0;
    public Object b;
    public final Object c;

    public ro0(tu tuVar) {
        this.c = tuVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                boolean zIsPowerSaveMode = ((PowerManager) this.b).isPowerSaveMode();
                so0 so0Var = (so0) this.c;
                so0Var.q = zIsPowerSaveMode;
                if (so0Var.q && so0Var.isVisible()) {
                    so0Var.n.b();
                    so0Var.m.setOrientationAngle(0.0f, 0.0f);
                    return;
                } else {
                    if (so0Var.q || !so0Var.isVisible()) {
                        return;
                    }
                    so0Var.n.a();
                    return;
                }
            default:
                Uri data = intent.getData();
                if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
                    tu tuVar = (tu) this.c;
                    t02 t02Var = (t02) ((el0) tuVar.i).i;
                    t02Var.i.set(null);
                    t12 t12Var = t02Var.m.t;
                    t12Var.sendMessage(t12Var.obtainMessage(3));
                    AlertDialog alertDialog = (AlertDialog) tuVar.h;
                    if (alertDialog.isShowing()) {
                        alertDialog.dismiss();
                    }
                    synchronized (this) {
                        try {
                            Context context2 = (Context) this.b;
                            if (context2 != null) {
                                context2.unregisterReceiver(this);
                            }
                            this.b = null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                return;
        }
    }

    public ro0(so0 so0Var, PowerManager powerManager) {
        this.c = so0Var;
        this.b = powerManager;
    }
}
