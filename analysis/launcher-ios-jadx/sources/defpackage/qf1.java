package defpackage;

import android.view.View;
import com.luutinhit.launcherios.customsettings.SettingsView;

/* JADX INFO: loaded from: classes.dex */
public final class qf1 implements View.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ SettingsView h;

    public qf1(SettingsView settingsView, int i) {
        this.h = settingsView;
        this.g = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingsView.r(this.h, this.g);
    }
}
