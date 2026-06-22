package defpackage;

import android.view.KeyEvent;
import android.view.View;
import com.luutinhit.launcher6.Folder;

/* JADX INFO: loaded from: classes.dex */
public final class l40 implements View.OnKeyListener {
    public final /* synthetic */ View g;
    public final /* synthetic */ Folder h;

    public l40(Folder folder, View view) {
        this.h = folder;
        this.g = view;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return i == 61 && keyEvent.hasModifiers(1) && this.h.isFocused() && this.g.requestFocus();
    }
}
