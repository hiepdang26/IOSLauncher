package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public final class hf0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ TextView h;
    public final /* synthetic */ int i;
    public final /* synthetic */ TextView j;
    public final /* synthetic */ jf0 k;

    public hf0(jf0 jf0Var, int i, TextView textView, int i2, TextView textView2) {
        this.k = jf0Var;
        this.g = i;
        this.h = textView;
        this.i = i2;
        this.j = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AppCompatTextView appCompatTextView;
        int i = this.g;
        jf0 jf0Var = this.k;
        jf0Var.h = i;
        jf0Var.f = null;
        TextView textView = this.h;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.i == 1 && (appCompatTextView = jf0Var.l) != null) {
                appCompatTextView.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
