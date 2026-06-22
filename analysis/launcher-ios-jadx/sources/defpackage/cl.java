package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class cl extends Activity implements en0, fj0 {
    public final a g = new a(this);

    @Override // defpackage.fj0
    public final boolean d(KeyEvent keyEvent) {
        qg0.l(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        qg0.l(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        qg0.k(decorView, "window.decorView");
        if (n90.i(decorView, keyEvent)) {
            return true;
        }
        return n90.j(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        qg0.l(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        qg0.k(decorView, "window.decorView");
        if (n90.i(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = fa1.h;
        da1.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        qg0.l(bundle, "outState");
        this.g.g();
        super.onSaveInstanceState(bundle);
    }
}
