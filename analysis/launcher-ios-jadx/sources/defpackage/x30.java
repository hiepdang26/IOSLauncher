package defpackage;

import android.content.pm.ShortcutInfo;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public final class x30 implements View.OnClickListener {
    public final /* synthetic */ ShortcutInfo g;
    public final /* synthetic */ w1 h;

    public x30(w1 w1Var, ShortcutInfo shortcutInfo) {
        this.h = w1Var;
        this.g = shortcutInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w1 w1Var = this.h;
        ShortcutInfo shortcutInfo = this.g;
        int i = z30.O;
        z30 z30Var = (z30) w1Var.i;
        z30Var.getClass();
        try {
            if (ar1.e) {
                z30Var.G.startShortcut(shortcutInfo, null, null);
                z30Var.postDelayed(new r30(z30Var, 1), 689L);
            }
        } catch (Throwable unused) {
            Toast.makeText(z30Var.x, w61.activity_not_found, 0).show();
        }
    }
}
