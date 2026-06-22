package defpackage;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Message;
import com.luutinhit.launcher6.Workspace;

/* JADX INFO: loaded from: classes.dex */
public final class tv1 extends BroadcastReceiver {
    public static final int[] h = new int[2];
    public final Workspace a;
    public final boolean b;
    public final sv1 c;
    public boolean d = false;
    public IBinder e;
    public boolean f;
    public int g;

    public tv1(Workspace workspace) {
        this.a = workspace;
        this.b = ar1.v(workspace.getResources());
        this.c = new sv1(workspace.getContext());
    }

    public final void a(IBinder iBinder) {
        this.e = iBinder;
        Workspace workspace = this.a;
        if (iBinder == null && this.d) {
            workspace.getContext().unregisterReceiver(this);
            this.d = false;
        } else {
            if (iBinder == null || this.d) {
                return;
            }
            if (ar1.j) {
                workspace.getContext().registerReceiver(this, new IntentFilter("android.intent.action.WALLPAPER_CHANGED"), 2);
            } else {
                workspace.getContext().registerReceiver(this, new IntentFilter("android.intent.action.WALLPAPER_CHANGED"));
            }
            onReceive(workspace.getContext(), null);
            this.d = true;
        }
    }

    public final void b() {
        Workspace workspace = this.a;
        int childCount = workspace.getChildCount();
        if (childCount >= 4 && workspace.J0()) {
            childCount--;
        }
        int scrollX = workspace.getScrollX();
        int[] iArr = h;
        c(iArr, scrollX, childCount);
        int i = iArr[0];
        int i2 = iArr[1];
        IBinder iBinder = this.e;
        sv1 sv1Var = this.c;
        Message messageObtain = Message.obtain(sv1Var, 2, i, i2, iBinder);
        int i3 = this.g;
        if (childCount != i3) {
            if (i3 > 0) {
                messageObtain.what = 1;
            }
            this.g = childCount;
            if (!this.f) {
                childCount = Math.max(4, childCount);
            }
            Message.obtain(sv1Var, 4, childCount, 0, this.e).sendToTarget();
        }
        messageObtain.sendToTarget();
    }

    public final void c(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        iArr[1] = 1;
        boolean z = this.b;
        if (i2 <= 1) {
            iArr[0] = z ? 1 : 0;
            return;
        }
        int iMax = this.f ? i2 : Math.max(4, i2);
        if (z) {
            i4 = i2 - 1;
            i3 = 0;
        } else {
            i3 = i2 - 1;
            i4 = 0;
        }
        Workspace workspace = this.a;
        int iE = workspace.E(i4);
        int iE2 = workspace.E(i3) - iE;
        if (iE2 <= 0) {
            iArr[0] = 0;
            return;
        }
        int iB = (i - iE) - workspace.B(0);
        Rect rect = ar1.a;
        int iMax2 = Math.max(0, Math.min(iB, iE2));
        int i5 = (iMax - 1) * iE2;
        iArr[1] = i5;
        iArr[0] = ((i2 - 1) * iMax2) + (z ? i5 - ((i2 - 1) * iE2) : 0);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z = WallpaperManager.getInstance(this.a.getContext()).getWallpaperInfo() != null;
        this.f = z;
        Message.obtain(this.c, 4, z ? this.g : Math.max(4, this.g), 0, this.e).sendToTarget();
    }
}
