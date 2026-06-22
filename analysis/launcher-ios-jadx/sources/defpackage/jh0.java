package defpackage;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public final class jh0 extends m91 implements xh0 {
    public RelativeLayout A;
    public TextView B;
    public AppCompatImageView C;
    public AppCompatImageView D;

    @Override // defpackage.xh0
    public final void a(Context context) {
        ((TransitionDrawable) this.A.getBackground()).startTransition(200);
        this.B.setTextColor(np1.k(context, x41.white));
    }

    @Override // defpackage.xh0
    public final void b(Context context) {
        ((TransitionDrawable) this.A.getBackground()).reverseTransition(200);
        this.B.setTextColor(np1.k(context, x41.textlight));
    }
}
