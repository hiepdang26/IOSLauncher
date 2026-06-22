package defpackage;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class oh0 extends m91 implements xh0 {
    public final RelativeLayout A;
    public final TextView B;
    public final AppCompatImageView C;
    public final AppCompatImageView D;
    public final AppCompatImageView E;
    public final /* synthetic */ y00 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh0(y00 y00Var, View view) {
        super(view);
        this.F = y00Var;
        this.A = (RelativeLayout) view.findViewById(v51.container);
        this.B = (TextView) view.findViewById(v51.tvItemName);
        this.C = (AppCompatImageView) view.findViewById(v51.remove_icon);
        this.D = (AppCompatImageView) view.findViewById(v51.icon_app);
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(v51.ivReorder);
        this.E = appCompatImageView;
        if (y00Var.o) {
            appCompatImageView.setVisibility(0);
        }
    }

    @Override // defpackage.xh0
    public final void a(Context context) {
        ((TransitionDrawable) this.A.getBackground()).startTransition(t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT);
        this.B.setTextColor(np1.k(context, x41.white));
    }

    @Override // defpackage.xh0
    public final void b(Context context) {
        ((TransitionDrawable) this.A.getBackground()).reverseTransition(t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT);
        this.B.setTextColor(np1.k(context, x41.textlight));
        bz0 bz0Var = (bz0) this.F.l;
        if (bz0Var != null) {
            bz0Var.c();
        }
    }
}
