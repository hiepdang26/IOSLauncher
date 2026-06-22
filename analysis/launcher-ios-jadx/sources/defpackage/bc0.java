package defpackage;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.activity.HiddenAppsActivity;

/* JADX INFO: loaded from: classes.dex */
public final class bc0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ HiddenAppsActivity h;

    public /* synthetic */ bc0(HiddenAppsActivity hiddenAppsActivity, int i) {
        this.g = i;
        this.h = hiddenAppsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HiddenAppsActivity hiddenAppsActivity = this.h;
        switch (this.g) {
            case 0:
                Handler handler = HiddenAppsActivity.T;
                hiddenAppsActivity.B();
                break;
            case 1:
                Toast.makeText(hiddenAppsActivity.C, w61.application_not_found, 1).show();
                break;
            case 2:
                Toast.makeText(hiddenAppsActivity.C, w61.application_not_found, 1).show();
                hiddenAppsActivity.startActivity(new Intent(hiddenAppsActivity.C, (Class<?>) IOSLauncher.class));
                break;
            default:
                hiddenAppsActivity.I.setVisibility(8);
                hiddenAppsActivity.J.clearAnimation();
                break;
        }
    }
}
