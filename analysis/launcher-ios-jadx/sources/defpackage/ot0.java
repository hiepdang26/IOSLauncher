package defpackage;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public final class ot0 extends FrameLayout implements uj {
    public final CollapsibleActionView g;

    /* JADX WARN: Multi-variable type inference failed */
    public ot0(View view) {
        super(view.getContext());
        this.g = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // defpackage.uj
    public final void onActionViewCollapsed() {
        this.g.onActionViewCollapsed();
    }

    @Override // defpackage.uj
    public final void onActionViewExpanded() {
        this.g.onActionViewExpanded();
    }
}
