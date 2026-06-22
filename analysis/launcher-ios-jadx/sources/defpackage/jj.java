package defpackage;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class jj extends c00 {
    public final j8 e;
    public final v3 f;
    public final ej g;
    public final fj h;
    public AnimatorSet i;
    public ValueAnimator j;

    public jj(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.e = new j8(this, 1);
        this.f = new v3(this, 1);
        this.g = new ej(this, 0);
        this.h = new fj(this, 0);
    }

    public static boolean d(jj jjVar) {
        EditText editText = jjVar.a.getEditText();
        if (editText != null) {
            return (editText.hasFocus() || jjVar.c.hasFocus()) && editText.getText().length() > 0;
        }
        return false;
    }

    @Override // defpackage.c00
    public final void a() {
        int i = 1;
        int i2 = 0;
        int i3 = this.d;
        if (i3 == 0) {
            i3 = k51.mtrl_ic_cancel;
        }
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconDrawable(i3);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(v61.clear_text_end_icon_content_description));
        textInputLayout.setEndIconCheckable(false);
        textInputLayout.setEndIconOnClickListener(new gj(this));
        LinkedHashSet linkedHashSet = textInputLayout.h0;
        ej ejVar = this.g;
        linkedHashSet.add(ejVar);
        if (textInputLayout.k != null) {
            ejVar.a(textInputLayout);
        }
        textInputLayout.l0.add(this.h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(n5.d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ij(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = n5.a;
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new ij(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.i = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.i.addListener(new hj(this, i2));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new ij(this, 0));
        this.j = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new hj(this, i));
    }

    @Override // defpackage.c00
    public final void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        e(z);
    }

    public final void e(boolean z) {
        boolean z2 = this.a.g() == z;
        if (z && !this.i.isRunning()) {
            this.j.cancel();
            this.i.start();
            if (z2) {
                this.i.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.i.cancel();
        this.j.start();
        if (z2) {
            this.j.end();
        }
    }
}
