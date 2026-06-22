package defpackage;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.activity.EditWidgetActivity;

/* JADX INFO: loaded from: classes.dex */
public final class py implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ EditWidgetActivity h;

    public /* synthetic */ py(EditWidgetActivity editWidgetActivity, int i) {
        this.g = i;
        this.h = editWidgetActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditWidgetActivity editWidgetActivity = this.h;
        switch (this.g) {
            case 0:
                Handler handler = EditWidgetActivity.S;
                editWidgetActivity.C();
                break;
            case 1:
                Toast.makeText(editWidgetActivity.B, w61.application_not_found, 1).show();
                break;
            case 2:
                Toast.makeText(editWidgetActivity.B, w61.application_not_found, 1).show();
                editWidgetActivity.startActivity(new Intent(editWidgetActivity.B, (Class<?>) IOSLauncher.class));
                break;
            default:
                editWidgetActivity.H.setVisibility(8);
                editWidgetActivity.I.clearAnimation();
                break;
        }
    }
}
