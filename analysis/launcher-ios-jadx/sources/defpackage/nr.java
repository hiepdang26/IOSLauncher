package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class nr implements ServiceConnection {
    private Context mApplicationContext;

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, lr lrVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        vd0 vd0Var;
        if (this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        int i = ud0.g;
        if (iBinder == null) {
            vd0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof vd0)) {
                td0 td0Var = new td0();
                td0Var.g = iBinder;
                vd0Var = td0Var;
            } else {
                vd0Var = (vd0) iInterfaceQueryLocalInterface;
            }
        }
        onCustomTabsServiceConnected(componentName, new mr(vd0Var, componentName));
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}
