package defpackage;

import android.content.Context;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y31 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Context h;

    public /* synthetic */ y31(Context context, int i) {
        this.g = i;
        this.h = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.h);
                break;
            default:
                ProfileInstaller.writeProfile(this.h);
                break;
        }
    }
}
