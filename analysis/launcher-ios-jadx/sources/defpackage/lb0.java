package defpackage;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes.dex */
public final class lb0 extends mb0 {
    public final View b;
    public final float c;
    public final float d;

    public lb0(View view) {
        this.b = view;
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        Resources resources = view.getContext().getResources();
        this.c = resources.getDimension(e51.all_apps_header_max_elevation);
        this.d = resources.getDimension(e51.all_apps_header_scroll_to_elevation);
    }

    @Override // defpackage.mb0
    public final void c(int i) {
        float f = this.d;
        float fMin = this.c * (Math.min(i, f) / f);
        View view = this.b;
        if (Float.compare(view.getElevation(), fMin) != 0) {
            view.setElevation(fMin);
        }
    }
}
