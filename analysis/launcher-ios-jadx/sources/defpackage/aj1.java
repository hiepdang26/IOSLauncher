package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aj1 extends LinearLayout {
    public final TextInputLayout g;
    public final AppCompatTextView h;
    public CharSequence i;
    public final CheckableImageButton j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public View.OnLongClickListener m;
    public boolean n;

    public aj1(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.g = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(l61.design_text_input_start_icon, (ViewGroup) this, false);
        this.j = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.h = appCompatTextView;
        if (np1.A(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.m;
        checkableImageButton.setOnClickListener(null);
        z71.p(checkableImageButton, onLongClickListener);
        this.m = null;
        checkableImageButton.setOnLongClickListener(null);
        z71.p(checkableImageButton, null);
        if (tintTypedArray.hasValue(f71.TextInputLayout_startIconTint)) {
            this.k = np1.m(getContext(), tintTypedArray, f71.TextInputLayout_startIconTint);
        }
        if (tintTypedArray.hasValue(f71.TextInputLayout_startIconTintMode)) {
            this.l = qg0.C(tintTypedArray.getInt(f71.TextInputLayout_startIconTintMode, -1), null);
        }
        if (tintTypedArray.hasValue(f71.TextInputLayout_startIconDrawable)) {
            a(tintTypedArray.getDrawable(f71.TextInputLayout_startIconDrawable));
            if (tintTypedArray.hasValue(f71.TextInputLayout_startIconContentDescription) && checkableImageButton.getContentDescription() != (text = tintTypedArray.getText(f71.TextInputLayout_startIconContentDescription))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(tintTypedArray.getBoolean(f71.TextInputLayout_startIconCheckable, true));
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(u51.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = qs1.a;
        appCompatTextView.setAccessibilityLiveRegion(1);
        qg0.K(appCompatTextView, tintTypedArray.getResourceId(f71.TextInputLayout_prefixTextAppearance, 0));
        if (tintTypedArray.hasValue(f71.TextInputLayout_prefixTextColor)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(f71.TextInputLayout_prefixTextColor));
        }
        CharSequence text2 = tintTypedArray.getText(f71.TextInputLayout_prefixText);
        this.i = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        d();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final void a(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.j;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.k;
            PorterDuff.Mode mode = this.l;
            TextInputLayout textInputLayout = this.g;
            z71.b(textInputLayout, checkableImageButton, colorStateList, mode);
            b(true);
            z71.l(textInputLayout, checkableImageButton, this.k);
            return;
        }
        b(false);
        View.OnLongClickListener onLongClickListener = this.m;
        checkableImageButton.setOnClickListener(null);
        z71.p(checkableImageButton, onLongClickListener);
        this.m = null;
        checkableImageButton.setOnLongClickListener(null);
        z71.p(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void b(boolean z) {
        CheckableImageButton checkableImageButton = this.j;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            c();
            d();
        }
    }

    public final void c() {
        int paddingStart;
        EditText editText = this.g.k;
        if (editText == null) {
            return;
        }
        if (this.j.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            WeakHashMap weakHashMap = qs1.a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d51.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = qs1.a;
        this.h.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void d() {
        int i = (this.i == null || this.n) ? 8 : 0;
        setVisibility((this.j.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.h.setVisibility(i);
        this.g.o();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        c();
    }
}
