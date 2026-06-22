package defpackage;

import com.luutinhit.launcherios.customsettings.SettingsView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class tf1 extends pg0 {
    public final /* synthetic */ SettingsView a;

    public tf1(SettingsView settingsView) {
        this.a = settingsView;
    }

    @Override // defpackage.k2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        Objects.toString(xo0Var);
        this.a.f0 = null;
    }

    @Override // defpackage.k2
    public final void onAdLoaded(Object obj) {
        og0 og0Var = (og0) obj;
        this.a.f0 = og0Var;
        og0Var.setFullScreenContentCallback(new sf1(this, 0));
    }
}
