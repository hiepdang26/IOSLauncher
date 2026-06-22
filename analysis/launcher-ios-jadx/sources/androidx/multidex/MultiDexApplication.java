package androidx.multidex;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import defpackage.uu0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class MultiDexApplication extends Application {
    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        ApplicationInfo applicationInfo;
        super.attachBaseContext(context);
        if (uu0.b) {
            return;
        }
        try {
            try {
                applicationInfo = getApplicationInfo();
            } catch (RuntimeException unused) {
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                return;
            }
            uu0.b(this, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir));
        } catch (Exception e) {
            throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
        }
    }
}
