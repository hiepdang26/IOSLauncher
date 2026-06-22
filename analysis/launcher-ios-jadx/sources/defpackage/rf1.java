package defpackage;

import android.content.DialogInterface;
import com.luutinhit.launcherios.customsettings.SettingsView;

/* JADX INFO: loaded from: classes.dex */
public final class rf1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ SettingsView h;

    public rf1(SettingsView settingsView, int i) {
        this.h = settingsView;
        this.g = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsView.r(this.h, this.g);
    }
}
