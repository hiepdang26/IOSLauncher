package defpackage;

import android.view.View;
import androidx.profileinstaller.DeviceProfileWriter;
import com.luutinhit.launcher6.PageIndicatorSpotlight;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yu implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public /* synthetic */ yu(Object obj, int i, Object obj2, int i2) {
        this.g = i2;
        this.i = obj;
        this.h = i;
        this.j = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ((DeviceProfileWriter) this.i).lambda$result$0(this.h, this.j);
                break;
            case 1:
                ((IOSLauncher) this.i).lambda$checkHideNavigation$0(this.h, (View) this.j);
                break;
            default:
                PageIndicatorSpotlight.g((PageIndicatorSpotlight) this.i, this.h, (v01) this.j);
                break;
        }
    }
}
