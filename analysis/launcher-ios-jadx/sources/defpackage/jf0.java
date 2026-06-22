package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class jf0 {
    public final Context a;
    public final TextInputLayout b;
    public LinearLayout c;
    public int d;
    public FrameLayout e;
    public AnimatorSet f;
    public final float g;
    public int h;
    public int i;
    public CharSequence j;
    public boolean k;
    public AppCompatTextView l;
    public CharSequence m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public AppCompatTextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    public jf0(TextInputLayout textInputLayout) {
        this.a = textInputLayout.getContext();
        this.b = textInputLayout;
        this.g = r0.getResources().getDimensionPixelSize(d51.design_textinput_caption_translate_y);
    }

    public final void a(AppCompatTextView appCompatTextView, int i) {
        if (this.c == null && this.e == null) {
            Context context = this.a;
            LinearLayout linearLayout = new LinearLayout(context);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.c;
            TextInputLayout textInputLayout = this.b;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.e = new FrameLayout(context);
            this.c.addView(this.e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.e.setVisibility(0);
            this.e.addView(appCompatTextView);
        } else {
            this.c.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.c.setVisibility(0);
        this.d++;
    }

    public final void b() {
        if (this.c != null) {
            TextInputLayout textInputLayout = this.b;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.a;
                boolean zA = np1.A(context);
                LinearLayout linearLayout = this.c;
                int i = d51.material_helper_text_font_1_3_padding_horizontal;
                WeakHashMap weakHashMap = qs1.a;
                int paddingStart = editText.getPaddingStart();
                if (zA) {
                    paddingStart = context.getResources().getDimensionPixelSize(i);
                }
                int i2 = d51.material_helper_text_font_1_3_padding_top;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(d51.material_helper_text_default_padding_top);
                if (zA) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
                }
                int i3 = d51.material_helper_text_font_1_3_padding_horizontal;
                int paddingEnd = editText.getPaddingEnd();
                if (zA) {
                    paddingEnd = context.getResources().getDimensionPixelSize(i3);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z, AppCompatTextView appCompatTextView, int i, int i2, int i3) {
        if (appCompatTextView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, i3 == i ? 1.0f : 0.0f);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(n5.a);
            arrayList.add(objectAnimatorOfFloat);
            if (i3 == i) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.g, 0.0f);
                objectAnimatorOfFloat2.setDuration(217L);
                objectAnimatorOfFloat2.setInterpolator(n5.d);
                arrayList.add(objectAnimatorOfFloat2);
            }
        }
    }

    public final boolean e() {
        return (this.i != 1 || this.l == null || TextUtils.isEmpty(this.j)) ? false : true;
    }

    public final TextView f(int i) {
        if (i == 1) {
            return this.l;
        }
        if (i != 2) {
            return null;
        }
        return this.r;
    }

    public final void g() {
        this.j = null;
        c();
        if (this.h == 1) {
            if (!this.q || TextUtils.isEmpty(this.p)) {
                this.i = 0;
            } else {
                this.i = 2;
            }
        }
        j(this.h, this.i, i(this.l, ""));
    }

    public final void h(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.c;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.e) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i2 = this.d - 1;
        this.d = i2;
        LinearLayout linearLayout2 = this.c;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean i(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        WeakHashMap weakHashMap = qs1.a;
        TextInputLayout textInputLayout = this.b;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.i == this.h && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void j(int i, int i2, boolean z) {
        TextView textViewF;
        TextView textViewF2;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.q, this.r, 2, i, i2);
            d(arrayList, this.k, this.l, 1, i, i2);
            m90.n(animatorSet, arrayList);
            animatorSet.addListener(new hf0(this, i2, f(i), i, f(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (textViewF2 = f(i2)) != null) {
                textViewF2.setVisibility(0);
                textViewF2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewF = f(i)) != null) {
                textViewF.setVisibility(4);
                if (i == 1) {
                    textViewF.setText((CharSequence) null);
                }
            }
            this.h = i2;
        }
        TextInputLayout textInputLayout = this.b;
        textInputLayout.p();
        textInputLayout.t(z, false);
        textInputLayout.y();
    }
}
