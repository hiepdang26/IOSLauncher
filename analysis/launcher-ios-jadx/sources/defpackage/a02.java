package defpackage;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcherios.searchview.SearchViewLayout;

/* JADX INFO: loaded from: classes.dex */
public final class a02 implements View.OnClickListener {
    public final /* synthetic */ Workspace g;

    public a02(Workspace workspace) {
        this.g = workspace;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        hz0 hz0Var = this.g.S0.pullDetector;
        SearchViewLayout searchViewLayout = hz0Var.l;
        searchViewLayout.A();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(searchViewLayout, (Property<SearchViewLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(368L);
        objectAnimatorOfFloat.start();
        float f = hz0Var.c;
        mi1 mi1Var = hz0Var.j;
        mi1Var.a = f;
        if (mi1Var.e) {
            mi1Var.k = 0.0f;
        } else {
            if (mi1Var.j == null) {
                mi1Var.j = new ni1(0);
            }
            mi1Var.j.i = 0.0f;
            mi1Var.d();
        }
        mi1Var.d();
        t tVar = hz0Var.k;
        if (tVar.isRenderEffectSupport) {
            hz0Var.d(1.0f);
        } else {
            tVar.showFolderBlurBackground(1.0f);
        }
        hz0Var.i = false;
    }
}
