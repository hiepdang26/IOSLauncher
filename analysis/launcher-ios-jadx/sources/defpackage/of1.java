package defpackage;

import com.google.android.gms.ads.MobileAds;
import com.luutinhit.launcherios.customsettings.SettingsView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class of1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ SettingsView h;

    public /* synthetic */ of1(SettingsView settingsView, int i) {
        this.g = i;
        this.h = settingsView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SettingsView settingsView = this.h;
        switch (this.g) {
            case 0:
                int i = SettingsView.g0;
                MobileAds.a(settingsView.c0, new pf1(0));
                settingsView.b0.runOnUiThread(new of1(settingsView, 1));
                break;
            default:
                int i2 = SettingsView.g0;
                settingsView.u();
                break;
        }
    }
}
