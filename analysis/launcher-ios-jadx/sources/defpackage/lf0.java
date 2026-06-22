package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;

/* JADX INFO: loaded from: classes.dex */
public final class lf0 implements View.OnClickListener {
    public final /* synthetic */ IOSLauncher g;

    public lf0(IOSLauncher iOSLauncher) {
        this.g = iOSLauncher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://openweathermap.org/")));
    }
}
