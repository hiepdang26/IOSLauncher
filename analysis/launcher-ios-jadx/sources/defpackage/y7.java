package defpackage;

import android.view.View;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y7 implements View.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ t h;

    public /* synthetic */ y7(t tVar, int i) {
        this.g = i;
        this.h = tVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.g) {
            case 0:
                this.h.startAppShortcutOrInfoActivity(view);
                break;
            default:
                this.h.cancelShakingAnimation();
                break;
        }
    }
}
