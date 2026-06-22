package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.aj1;
import defpackage.an1;
import defpackage.az1;
import defpackage.b71;
import defpackage.bf1;
import defpackage.c00;
import defpackage.cp1;
import defpackage.cr;
import defpackage.d;
import defpackage.d51;
import defpackage.dc;
import defpackage.dg;
import defpackage.ej;
import defpackage.el0;
import defpackage.f0;
import defpackage.f71;
import defpackage.fj;
import defpackage.fn1;
import defpackage.gn1;
import defpackage.hg0;
import defpackage.hn1;
import defpackage.if0;
import defpackage.ik;
import defpackage.j8;
import defpackage.jd;
import defpackage.jf0;
import defpackage.jj;
import defpackage.ks1;
import defpackage.l20;
import defpackage.l61;
import defpackage.mn1;
import defpackage.n5;
import defpackage.np1;
import defpackage.nx0;
import defpackage.q41;
import defpackage.q7;
import defpackage.qg0;
import defpackage.qr0;
import defpackage.qs1;
import defpackage.rr0;
import defpackage.s11;
import defpackage.sr;
import defpackage.to;
import defpackage.tr0;
import defpackage.u51;
import defpackage.uo;
import defpackage.ux;
import defpackage.v61;
import defpackage.vf1;
import defpackage.vj;
import defpackage.w1;
import defpackage.w41;
import defpackage.wf1;
import defpackage.wu;
import defpackage.z71;
import defpackage.zm1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int O0 = b71.Widget_Design_TextInputLayout;
    public ColorStateList A;
    public int A0;
    public int B;
    public ColorStateList B0;
    public l20 C;
    public int C0;
    public l20 D;
    public int D0;
    public ColorStateList E;
    public int E0;
    public ColorStateList F;
    public int F0;
    public CharSequence G;
    public int G0;
    public final AppCompatTextView H;
    public boolean H0;
    public boolean I;
    public final vj I0;
    public CharSequence J;
    public boolean J0;
    public boolean K;
    public boolean K0;
    public rr0 L;
    public ValueAnimator L0;
    public rr0 M;
    public boolean M0;
    public rr0 N;
    public boolean N0;
    public wf1 O;
    public boolean P;
    public final int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int a0;
    public final Rect b0;
    public final Rect c0;
    public final RectF d0;
    public Typeface e0;
    public ColorDrawable f0;
    public final FrameLayout g;
    public int g0;
    public final aj1 h;
    public final LinkedHashSet h0;
    public final LinearLayout i;
    public int i0;
    public final FrameLayout j;
    public final SparseArray j0;
    public EditText k;
    public final CheckableImageButton k0;
    public CharSequence l;
    public final LinkedHashSet l0;
    public int m;
    public ColorStateList m0;
    public int n;
    public PorterDuff.Mode n0;
    public int o;
    public ColorDrawable o0;
    public int p;
    public int p0;
    public final jf0 q;
    public Drawable q0;
    public boolean r;
    public View.OnLongClickListener r0;
    public int s;
    public View.OnLongClickListener s0;
    public boolean t;
    public final CheckableImageButton t0;
    public AppCompatTextView u;
    public ColorStateList u0;
    public int v;
    public PorterDuff.Mode v0;
    public int w;
    public ColorStateList w0;
    public CharSequence x;
    public ColorStateList x0;
    public boolean y;
    public int y0;
    public AppCompatTextView z;
    public int z0;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v52 */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        int i;
        ?? r7;
        int i2 = q41.textInputStyle;
        int i3 = O0;
        super(tr0.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = new jf0(this);
        this.b0 = new Rect();
        this.c0 = new Rect();
        this.d0 = new RectF();
        this.h0 = new LinkedHashSet();
        this.i0 = 0;
        SparseArray sparseArray = new SparseArray();
        this.j0 = sparseArray;
        this.l0 = new LinkedHashSet();
        vj vjVar = new vj(this);
        this.I0 = vjVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.g = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.j = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.i = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.H = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context2);
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(l61.design_text_input_end_icon, (ViewGroup) linearLayout, false);
        this.t0 = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(l61.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.k0 = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        LinearInterpolator linearInterpolator = n5.a;
        vjVar.O = linearInterpolator;
        vjVar.i(false);
        vjVar.N = linearInterpolator;
        vjVar.i(false);
        if (vjVar.h != 8388659) {
            vjVar.h = 8388659;
            vjVar.i(false);
        }
        int[] iArr = f71.TextInputLayout;
        int[] iArr2 = {f71.TextInputLayout_counterTextAppearance, f71.TextInputLayout_counterOverflowTextAppearance, f71.TextInputLayout_errorTextAppearance, f71.TextInputLayout_helperTextTextAppearance, f71.TextInputLayout_hintTextAppearance};
        mn1.a(context2, attributeSet, i2, i3);
        mn1.b(context2, attributeSet, iArr, i2, i3, iArr2);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i2, i3);
        aj1 aj1Var = new aj1(this, tintTypedArrayObtainStyledAttributes);
        this.h = aj1Var;
        this.I = tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_hintEnabled, true);
        setHint(tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_android_hint));
        this.K0 = tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_hintAnimationEnabled, true);
        this.J0 = tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_expandedHintEnabled, true);
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_android_minEms)) {
            i = -1;
            setMinEms(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_android_minEms, -1));
        } else {
            i = -1;
            if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_android_minWidth)) {
                setMinWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.TextInputLayout_android_minWidth, -1));
            }
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_android_maxEms)) {
            setMaxEms(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_android_maxEms, i));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_android_maxWidth)) {
            setMaxWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.TextInputLayout_android_maxWidth, i));
        }
        this.O = wf1.b(context2, attributeSet, i2, i3).a();
        this.Q = context2.getResources().getDimensionPixelOffset(d51.mtrl_textinput_box_label_cutout_padding);
        this.S = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(f71.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.U = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(d51.mtrl_textinput_box_stroke_width_default));
        this.V = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(d51.mtrl_textinput_box_stroke_width_focused));
        this.T = this.U;
        float dimension = tintTypedArrayObtainStyledAttributes.getDimension(f71.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = tintTypedArrayObtainStyledAttributes.getDimension(f71.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = tintTypedArrayObtainStyledAttributes.getDimension(f71.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = tintTypedArrayObtainStyledAttributes.getDimension(f71.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        vf1 vf1VarE = this.O.e();
        if (dimension >= 0.0f) {
            vf1VarE.e = new d(dimension);
        }
        if (dimension2 >= 0.0f) {
            vf1VarE.f = new d(dimension2);
        }
        if (dimension3 >= 0.0f) {
            vf1VarE.g = new d(dimension3);
        }
        if (dimension4 >= 0.0f) {
            vf1VarE.h = new d(dimension4);
        }
        this.O = vf1VarE.a();
        ColorStateList colorStateListM = np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.TextInputLayout_boxBackgroundColor);
        if (colorStateListM != null) {
            int defaultColor = colorStateListM.getDefaultColor();
            this.C0 = defaultColor;
            this.a0 = defaultColor;
            if (colorStateListM.isStateful()) {
                this.D0 = colorStateListM.getColorForState(new int[]{-16842910}, -1);
                this.E0 = colorStateListM.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.F0 = colorStateListM.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.E0 = this.C0;
                ColorStateList colorStateListM2 = hg0.m(context2, w41.mtrl_filled_background_color);
                this.D0 = colorStateListM2.getColorForState(new int[]{-16842910}, -1);
                this.F0 = colorStateListM2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.a0 = 0;
            this.C0 = 0;
            this.D0 = 0;
            this.E0 = 0;
            this.F0 = 0;
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_android_textColorHint);
            this.x0 = colorStateList;
            this.w0 = colorStateList;
        }
        ColorStateList colorStateListM3 = np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.TextInputLayout_boxStrokeColor);
        this.A0 = tintTypedArrayObtainStyledAttributes.getColor(f71.TextInputLayout_boxStrokeColor, 0);
        this.y0 = np1.k(context2, w41.mtrl_textinput_default_box_stroke_color);
        this.G0 = np1.k(context2, w41.mtrl_textinput_disabled_color);
        this.z0 = np1.k(context2, w41.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListM3 != null) {
            setBoxStrokeColorStateList(colorStateListM3);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.TextInputLayout_boxStrokeErrorColor));
        }
        if (tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_hintTextAppearance, -1) != -1) {
            r7 = 0;
            setHintTextAppearance(tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_hintTextAppearance, 0));
        } else {
            r7 = 0;
        }
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_errorTextAppearance, r7);
        CharSequence text = tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_errorContentDescription);
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_errorEnabled, r7);
        checkableImageButton.setId(u51.text_input_error_icon);
        if (np1.A(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(r7);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_errorIconTint)) {
            this.u0 = np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.TextInputLayout_errorIconTint);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_errorIconTintMode)) {
            this.v0 = qg0.C(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(f71.TextInputLayout_errorIconDrawable));
        }
        checkableImageButton.setContentDescription(getResources().getText(v61.error_icon_content_description));
        WeakHashMap weakHashMap = qs1.a;
        checkableImageButton.setImportantForAccessibility(2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_helperTextTextAppearance, 0);
        boolean z2 = tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_helperText);
        int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_placeholderText);
        int resourceId4 = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_suffixTextAppearance, 0);
        CharSequence text4 = tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_suffixText);
        boolean z3 = tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_counterMaxLength, -1));
        int i4 = 0;
        this.w = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_counterTextAppearance, 0);
        this.v = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_boxBackgroundMode, 0));
        if (np1.A(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginStart(0);
        }
        int resourceId5 = tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_endIconDrawable, 0);
        sparseArray.append(-1, new cr(this, resourceId5, i4));
        sparseArray.append(0, new cr(this, 0, 1));
        sparseArray.append(1, new s11(this, resourceId5 == 0 ? tintTypedArrayObtainStyledAttributes.getResourceId(f71.TextInputLayout_passwordToggleDrawable, 0) : resourceId5));
        sparseArray.append(2, new jj(this, resourceId5));
        sparseArray.append(3, new ux(this, resourceId5));
        if (!tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_passwordToggleEnabled)) {
            if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_endIconTint)) {
                this.m0 = np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.TextInputLayout_endIconTint);
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_endIconTintMode)) {
                this.n0 = qg0.C(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_endIconMode)) {
            setEndIconMode(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_endIconMode, 0));
            if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_endIconCheckable, true));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_passwordToggleEnabled)) {
            if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_passwordToggleTint)) {
                this.m0 = np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.TextInputLayout_passwordToggleTint);
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_passwordToggleTintMode)) {
                this.n0 = qg0.C(tintTypedArrayObtainStyledAttributes.getInt(f71.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            setEndIconMode(tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconContentDescription(tintTypedArrayObtainStyledAttributes.getText(f71.TextInputLayout_passwordToggleContentDescription));
        }
        appCompatTextView.setId(u51.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        appCompatTextView.setAccessibilityLiveRegion(1);
        setErrorContentDescription(text);
        setCounterOverflowTextAppearance(this.v);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.w);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setSuffixTextAppearance(resourceId4);
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_errorTextColor)) {
            setErrorTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_errorTextColor));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_helperTextTextColor));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_hintTextColor)) {
            setHintTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_hintTextColor));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_counterTextColor)) {
            setCounterTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_counterTextColor));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_counterOverflowTextColor));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_placeholderTextColor));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(f71.TextInputLayout_suffixTextColor));
        }
        setEnabled(tintTypedArrayObtainStyledAttributes.getBoolean(f71.TextInputLayout_android_enabled, true));
        tintTypedArrayObtainStyledAttributes.recycle();
        setImportantForAccessibility(2);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26 && i5 >= 26) {
            ks1.b(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(aj1Var);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
        setSuffixText(text4);
    }

    private c00 getEndIconDelegate() {
        SparseArray sparseArray = this.j0;
        c00 c00Var = (c00) sparseArray.get(this.i0);
        return c00Var != null ? c00Var : (c00) sparseArray.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        CheckableImageButton checkableImageButton = this.t0;
        if (checkableImageButton.getVisibility() == 0) {
            return checkableImageButton;
        }
        if (this.i0 == 0 || !g()) {
            return null;
        }
        return this.k0;
    }

    public static void j(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                j((ViewGroup) childAt, z);
            }
        }
    }

    public static void k(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = qs1.a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    private void setEditText(EditText editText) {
        if (this.k != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.i0 != 3) {
            boolean z = editText instanceof TextInputEditText;
        }
        this.k = editText;
        int i = this.m;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.o);
        }
        int i2 = this.n;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.p);
        }
        h();
        setTextInputAccessibilityDelegate(new gn1(this));
        Typeface typeface = this.k.getTypeface();
        vj vjVar = this.I0;
        vjVar.n(typeface);
        float textSize = this.k.getTextSize();
        if (vjVar.i != textSize) {
            vjVar.i = textSize;
            vjVar.i(false);
        }
        float letterSpacing = this.k.getLetterSpacing();
        if (vjVar.U != letterSpacing) {
            vjVar.U = letterSpacing;
            vjVar.i(false);
        }
        int gravity = this.k.getGravity();
        int i3 = (gravity & (-113)) | 48;
        if (vjVar.h != i3) {
            vjVar.h = i3;
            vjVar.i(false);
        }
        if (vjVar.g != gravity) {
            vjVar.g = gravity;
            vjVar.i(false);
        }
        this.k.addTextChangedListener(new j8(this, 3));
        if (this.w0 == null) {
            this.w0 = this.k.getHintTextColors();
        }
        if (this.I) {
            if (TextUtils.isEmpty(this.J)) {
                CharSequence hint = this.k.getHint();
                this.l = hint;
                setHint(hint);
                this.k.setHint((CharSequence) null);
            }
            this.K = true;
        }
        if (this.u != null) {
            m(this.k.getText().length());
        }
        p();
        this.q.b();
        this.h.bringToFront();
        this.i.bringToFront();
        this.j.bringToFront();
        this.t0.bringToFront();
        Iterator it = this.h0.iterator();
        while (it.hasNext()) {
            ((ej) it.next()).a(this);
        }
        w();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        t(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.J)) {
            return;
        }
        this.J = charSequence;
        vj vjVar = this.I0;
        if (charSequence == null || !TextUtils.equals(vjVar.A, charSequence)) {
            vjVar.A = charSequence;
            vjVar.B = null;
            Bitmap bitmap = vjVar.D;
            if (bitmap != null) {
                bitmap.recycle();
                vjVar.D = null;
            }
            vjVar.i(false);
        }
        if (this.H0) {
            return;
        }
        i();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.y == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = this.z;
            if (appCompatTextView != null) {
                this.g.addView(appCompatTextView);
                this.z.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.z;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.z = null;
        }
        this.y = z;
    }

    public final void a(float f) {
        vj vjVar = this.I0;
        if (vjVar.c == f) {
            return;
        }
        if (this.L0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.L0 = valueAnimator;
            valueAnimator.setInterpolator(n5.b);
            this.L0.setDuration(167L);
            this.L0.addUpdateListener(new q7(this, 12));
        }
        this.L0.setFloatValues(vjVar.c, f);
        this.L0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.g;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        s();
        setEditText((EditText) view);
    }

    public final void b() {
        int i;
        int i2;
        rr0 rr0Var = this.L;
        if (rr0Var == null) {
            return;
        }
        wf1 wf1Var = rr0Var.g.a;
        wf1 wf1Var2 = this.O;
        if (wf1Var != wf1Var2) {
            rr0Var.setShapeAppearanceModel(wf1Var2);
            if (this.i0 == 3 && this.R == 2) {
                ux uxVar = (ux) this.j0.get(3);
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.k;
                uxVar.getClass();
                if (!ux.h(autoCompleteTextView) && uxVar.a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
                    uxVar.e(autoCompleteTextView);
                }
            }
        }
        if (this.R == 2 && (i = this.T) > -1 && (i2 = this.W) != 0) {
            rr0 rr0Var2 = this.L;
            rr0Var2.g.j = i;
            rr0Var2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
            qr0 qr0Var = rr0Var2.g;
            if (qr0Var.d != colorStateListValueOf) {
                qr0Var.d = colorStateListValueOf;
                rr0Var2.onStateChange(rr0Var2.getState());
            }
        }
        int iF = this.a0;
        if (this.R == 1) {
            iF = ik.f(this.a0, bf1.f(getContext(), q41.colorSurface, 0));
        }
        this.a0 = iF;
        this.L.k(ColorStateList.valueOf(iF));
        if (this.i0 == 3) {
            this.k.getBackground().invalidateSelf();
        }
        rr0 rr0Var3 = this.M;
        if (rr0Var3 != null && this.N != null) {
            if (this.T > -1 && this.W != 0) {
                rr0Var3.k(this.k.isFocused() ? ColorStateList.valueOf(this.y0) : ColorStateList.valueOf(this.W));
                this.N.k(ColorStateList.valueOf(this.W));
            }
            invalidate();
        }
        invalidate();
    }

    public final int c() {
        float fD;
        if (!this.I) {
            return 0;
        }
        int i = this.R;
        vj vjVar = this.I0;
        if (i == 0) {
            fD = vjVar.d();
        } else {
            if (i != 2) {
                return 0;
            }
            fD = vjVar.d() / 2.0f;
        }
        return (int) fD;
    }

    public final boolean d() {
        return this.I && !TextUtils.isEmpty(this.J) && (this.L instanceof sr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.k;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.l != null) {
            boolean z = this.K;
            this.K = false;
            CharSequence hint = editText.getHint();
            this.k.setHint(this.l);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.k.setHint(hint);
                this.K = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.g;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.k) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.N0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.N0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        rr0 rr0Var;
        super.draw(canvas);
        boolean z = this.I;
        vj vjVar = this.I0;
        if (z) {
            vjVar.getClass();
            int iSave = canvas.save();
            if (vjVar.B != null && vjVar.b) {
                vjVar.L.setTextSize(vjVar.F);
                float f = vjVar.q;
                float f2 = vjVar.r;
                float f3 = vjVar.E;
                if (f3 != 1.0f) {
                    canvas.scale(f3, f3, f, f2);
                }
                canvas.translate(f, f2);
                vjVar.W.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.N == null || (rr0Var = this.M) == null) {
            return;
        }
        rr0Var.draw(canvas);
        if (this.k.isFocused()) {
            Rect bounds = this.N.getBounds();
            Rect bounds2 = this.M.getBounds();
            float f4 = vjVar.c;
            int iCenterX = bounds2.centerX();
            bounds.left = n5.c(f4, iCenterX, bounds2.left);
            bounds.right = n5.c(f4, iCenterX, bounds2.right);
            this.N.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.M0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.M0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            vj r3 = r4.I0
            if (r3 == 0) goto L2f
            r3.J = r1
            android.content.res.ColorStateList r1 = r3.l
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.k
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.i(r2)
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            android.widget.EditText r3 = r4.k
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = defpackage.qs1.a
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = 0
        L44:
            r4.t(r0, r2)
        L47:
            r4.p()
            r4.y()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.M0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e(int i, boolean z) {
        int compoundPaddingLeft = this.k.getCompoundPaddingLeft() + i;
        if (getPrefixText() == null || z) {
            return compoundPaddingLeft;
        }
        return getPrefixTextView().getPaddingLeft() + (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth());
    }

    public final int f(int i, boolean z) {
        int compoundPaddingRight = i - this.k.getCompoundPaddingRight();
        return (getPrefixText() == null || !z) ? compoundPaddingRight : (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight()) + compoundPaddingRight;
    }

    public final boolean g() {
        return this.j.getVisibility() == 0 && this.k0.getVisibility() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.k;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public rr0 getBoxBackground() {
        int i = this.R;
        if (i == 1 || i == 2) {
            return this.L;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.a0;
    }

    public int getBoxBackgroundMode() {
        return this.R;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.S;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zY = qg0.y(this);
        RectF rectF = this.d0;
        return zY ? this.O.h.a(rectF) : this.O.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zY = qg0.y(this);
        RectF rectF = this.d0;
        return zY ? this.O.g.a(rectF) : this.O.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zY = qg0.y(this);
        RectF rectF = this.d0;
        return zY ? this.O.e.a(rectF) : this.O.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zY = qg0.y(this);
        RectF rectF = this.d0;
        return zY ? this.O.f.a(rectF) : this.O.e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.A0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.B0;
    }

    public int getBoxStrokeWidth() {
        return this.U;
    }

    public int getBoxStrokeWidthFocused() {
        return this.V;
    }

    public int getCounterMaxLength() {
        return this.s;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.r && this.t && (appCompatTextView = this.u) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.E;
    }

    public ColorStateList getCounterTextColor() {
        return this.E;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.w0;
    }

    public EditText getEditText() {
        return this.k;
    }

    public CharSequence getEndIconContentDescription() {
        return this.k0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.k0.getDrawable();
    }

    public int getEndIconMode() {
        return this.i0;
    }

    public CheckableImageButton getEndIconView() {
        return this.k0;
    }

    public CharSequence getError() {
        jf0 jf0Var = this.q;
        if (jf0Var.k) {
            return jf0Var.j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.q.m;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.q.l;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.t0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        AppCompatTextView appCompatTextView = this.q.l;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHelperText() {
        jf0 jf0Var = this.q;
        if (jf0Var.q) {
            return jf0Var.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.q.r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.I) {
            return this.J;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.I0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        vj vjVar = this.I0;
        return vjVar.e(vjVar.l);
    }

    public ColorStateList getHintTextColor() {
        return this.x0;
    }

    public int getMaxEms() {
        return this.n;
    }

    public int getMaxWidth() {
        return this.p;
    }

    public int getMinEms() {
        return this.m;
    }

    public int getMinWidth() {
        return this.o;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.k0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.k0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.y) {
            return this.x;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.B;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.A;
    }

    public CharSequence getPrefixText() {
        return this.h.i;
    }

    public ColorStateList getPrefixTextColor() {
        return this.h.h.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.h.h;
    }

    public CharSequence getStartIconContentDescription() {
        return this.h.j.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.h.j.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.G;
    }

    public ColorStateList getSuffixTextColor() {
        return this.H.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.H;
    }

    public Typeface getTypeface() {
        return this.e0;
    }

    public final void h() {
        int i = this.R;
        if (i == 0) {
            this.L = null;
            this.M = null;
            this.N = null;
        } else if (i == 1) {
            this.L = new rr0(this.O);
            this.M = new rr0();
            this.N = new rr0();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(uo.j(new StringBuilder(), this.R, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.I || (this.L instanceof sr)) {
                this.L = new rr0(this.O);
            } else {
                this.L = new sr(this.O);
            }
            this.M = null;
            this.N = null;
        }
        EditText editText = this.k;
        if (editText != null && this.L != null && editText.getBackground() == null && this.R != 0) {
            EditText editText2 = this.k;
            rr0 rr0Var = this.L;
            WeakHashMap weakHashMap = qs1.a;
            editText2.setBackground(rr0Var);
        }
        y();
        if (this.R == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.S = getResources().getDimensionPixelSize(d51.material_font_2_0_box_collapsed_padding_top);
            } else if (np1.A(getContext())) {
                this.S = getResources().getDimensionPixelSize(d51.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.k != null && this.R == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText3 = this.k;
                WeakHashMap weakHashMap2 = qs1.a;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(d51.material_filled_edittext_font_2_0_padding_top), this.k.getPaddingEnd(), getResources().getDimensionPixelSize(d51.material_filled_edittext_font_2_0_padding_bottom));
            } else if (np1.A(getContext())) {
                EditText editText4 = this.k;
                WeakHashMap weakHashMap3 = qs1.a;
                editText4.setPaddingRelative(editText4.getPaddingStart(), getResources().getDimensionPixelSize(d51.material_filled_edittext_font_1_3_padding_top), this.k.getPaddingEnd(), getResources().getDimensionPixelSize(d51.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.R != 0) {
            s();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.i():void");
    }

    public final void l(AppCompatTextView appCompatTextView, int i) {
        try {
            qg0.K(appCompatTextView, i);
            if (Build.VERSION.SDK_INT < 23) {
                return;
            }
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        qg0.K(appCompatTextView, b71.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(np1.k(getContext(), w41.design_error));
    }

    public final void m(int i) {
        boolean z = this.t;
        int i2 = this.s;
        String string = null;
        if (i2 == -1) {
            this.u.setText(String.valueOf(i));
            this.u.setContentDescription(null);
            this.t = false;
        } else {
            this.t = i > i2;
            Context context = getContext();
            this.u.setContentDescription(context.getString(this.t ? v61.character_counter_overflowed_content_description : v61.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.s)));
            if (z != this.t) {
                n();
            }
            String str = dc.b;
            dc dcVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? dc.e : dc.d;
            AppCompatTextView appCompatTextView = this.u;
            String string2 = getContext().getString(v61.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.s));
            if (string2 == null) {
                dcVar.getClass();
            } else {
                dcVar.getClass();
                jd jdVar = an1.a;
                string = dcVar.c(string2).toString();
            }
            appCompatTextView.setText(string);
        }
        if (this.k == null || z == this.t) {
            return;
        }
        t(false, false);
        y();
        p();
    }

    public final void n() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.u;
        if (appCompatTextView != null) {
            l(appCompatTextView, this.t ? this.v : this.w);
            if (!this.t && (colorStateList2 = this.E) != null) {
                this.u.setTextColor(colorStateList2);
            }
            if (!this.t || (colorStateList = this.F) == null) {
                return;
            }
            this.u.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o() {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.o():boolean");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.I0.g(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.k;
        if (editText != null) {
            ThreadLocal threadLocal = wu.a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.b0;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = wu.a;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            wu.a(this, editText, matrix);
            ThreadLocal threadLocal3 = wu.b;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            rr0 rr0Var = this.M;
            if (rr0Var != null) {
                int i5 = rect.bottom;
                rr0Var.setBounds(rect.left, i5 - this.U, rect.right, i5);
            }
            rr0 rr0Var2 = this.N;
            if (rr0Var2 != null) {
                int i6 = rect.bottom;
                rr0Var2.setBounds(rect.left, i6 - this.V, rect.right, i6);
            }
            if (this.I) {
                float textSize = this.k.getTextSize();
                vj vjVar = this.I0;
                if (vjVar.i != textSize) {
                    vjVar.i = textSize;
                    vjVar.i(false);
                }
                int gravity = this.k.getGravity();
                int i7 = (gravity & (-113)) | 48;
                if (vjVar.h != i7) {
                    vjVar.h = i7;
                    vjVar.i(false);
                }
                if (vjVar.g != gravity) {
                    vjVar.g = gravity;
                    vjVar.i(false);
                }
                if (this.k == null) {
                    throw new IllegalStateException();
                }
                boolean zY = qg0.y(this);
                int i8 = rect.bottom;
                Rect rect2 = this.c0;
                rect2.bottom = i8;
                int i9 = this.R;
                if (i9 == 1) {
                    rect2.left = e(rect.left, zY);
                    rect2.top = rect.top + this.S;
                    rect2.right = f(rect.right, zY);
                } else if (i9 != 2) {
                    rect2.left = e(rect.left, zY);
                    rect2.top = getPaddingTop();
                    rect2.right = f(rect.right, zY);
                } else {
                    rect2.left = this.k.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.k.getPaddingRight();
                }
                int i10 = rect2.left;
                int i11 = rect2.top;
                int i12 = rect2.right;
                int i13 = rect2.bottom;
                Rect rect3 = vjVar.e;
                if (rect3.left != i10 || rect3.top != i11 || rect3.right != i12 || rect3.bottom != i13) {
                    rect3.set(i10, i11, i12, i13);
                    vjVar.K = true;
                    vjVar.h();
                }
                if (this.k == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = vjVar.M;
                textPaint.setTextSize(vjVar.i);
                textPaint.setTypeface(vjVar.v);
                textPaint.setLetterSpacing(vjVar.U);
                float f = -textPaint.ascent();
                rect2.left = this.k.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.R != 1 || this.k.getMinLines() > 1) ? rect.top + this.k.getCompoundPaddingTop() : (int) (rect.centerY() - (f / 2.0f));
                rect2.right = rect.right - this.k.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.R != 1 || this.k.getMinLines() > 1) ? rect.bottom - this.k.getCompoundPaddingBottom() : (int) (rect2.top + f);
                rect2.bottom = compoundPaddingBottom;
                int i14 = rect2.left;
                int i15 = rect2.top;
                int i16 = rect2.right;
                Rect rect4 = vjVar.d;
                if (rect4.left != i14 || rect4.top != i15 || rect4.right != i16 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i14, i15, i16, compoundPaddingBottom);
                    vjVar.K = true;
                    vjVar.h();
                }
                vjVar.i(false);
                if (!d() || this.H0) {
                    return;
                }
                i();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        EditText editText;
        int iMax;
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.k != null && this.k.getMeasuredHeight() < (iMax = Math.max(this.i.getMeasuredHeight(), this.h.getMeasuredHeight()))) {
            this.k.setMinimumHeight(iMax);
            z = true;
        }
        boolean zO = o();
        if (z || zO) {
            this.k.post(new fn1(this, 1));
        }
        if (this.z != null && (editText = this.k) != null) {
            this.z.setGravity(editText.getGravity());
            this.z.setPadding(this.k.getCompoundPaddingLeft(), this.k.getCompoundPaddingTop(), this.k.getCompoundPaddingRight(), this.k.getCompoundPaddingBottom());
        }
        w();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof hn1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        hn1 hn1Var = (hn1) parcelable;
        super.onRestoreInstanceState(hn1Var.getSuperState());
        setError(hn1Var.g);
        if (hn1Var.h) {
            this.k0.post(new fn1(this, 0));
        }
        setHint(hn1Var.i);
        setHelperText(hn1Var.j);
        setPlaceholderText(hn1Var.k);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = false;
        boolean z2 = i == 1;
        boolean z3 = this.P;
        if (z2 != z3) {
            if (z2 && !z3) {
                z = true;
            }
            to toVar = this.O.e;
            RectF rectF = this.d0;
            float fA = toVar.a(rectF);
            float fA2 = this.O.f.a(rectF);
            float fA3 = this.O.h.a(rectF);
            float fA4 = this.O.g.a(rectF);
            float f = z ? fA : fA2;
            if (z) {
                fA = fA2;
            }
            float f2 = z ? fA3 : fA4;
            if (z) {
                fA3 = fA4;
            }
            boolean zY = qg0.y(this);
            this.P = zY;
            float f3 = zY ? fA : f;
            if (!zY) {
                f = fA;
            }
            float f4 = zY ? fA3 : f2;
            if (!zY) {
                f2 = fA3;
            }
            rr0 rr0Var = this.L;
            if (rr0Var != null && rr0Var.g.a.e.a(rr0Var.g()) == f3) {
                rr0 rr0Var2 = this.L;
                if (rr0Var2.g.a.f.a(rr0Var2.g()) == f) {
                    rr0 rr0Var3 = this.L;
                    if (rr0Var3.g.a.h.a(rr0Var3.g()) == f4) {
                        rr0 rr0Var4 = this.L;
                        if (rr0Var4.g.a.g.a(rr0Var4.g()) == f2) {
                            return;
                        }
                    }
                }
            }
            vf1 vf1VarE = this.O.e();
            vf1VarE.e = new d(f3);
            vf1VarE.f = new d(f);
            vf1VarE.h = new d(f4);
            vf1VarE.g = new d(f2);
            this.O = vf1VarE.a();
            b();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        hn1 hn1Var = new hn1(super.onSaveInstanceState());
        if (this.q.e()) {
            hn1Var.g = getError();
        }
        hn1Var.h = this.i0 != 0 && this.k0.g;
        hn1Var.i = getHint();
        hn1Var.j = getHelperText();
        hn1Var.k = getPlaceholderText();
        return hn1Var;
    }

    public final void p() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.k;
        if (editText == null || this.R != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        jf0 jf0Var = this.q;
        if (jf0Var.e()) {
            AppCompatTextView appCompatTextView2 = jf0Var.l;
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1, PorterDuff.Mode.SRC_IN));
        } else if (this.t && (appCompatTextView = this.u) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            az1.d(background);
            this.k.refreshDrawableState();
        }
    }

    public final void q() {
        int visibility = this.k0.getVisibility();
        CheckableImageButton checkableImageButton = this.t0;
        this.j.setVisibility((visibility != 0 || checkableImageButton.getVisibility() == 0) ? 8 : 0);
        this.i.setVisibility((g() || checkableImageButton.getVisibility() == 0 || ((this.G == null || this.H0) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            r2 = this;
            android.graphics.drawable.Drawable r0 = r2.getErrorIconDrawable()
            if (r0 == 0) goto L14
            jf0 r0 = r2.q
            boolean r1 = r0.k
            if (r1 == 0) goto L14
            boolean r0 = r0.e()
            if (r0 == 0) goto L14
            r0 = 0
            goto L16
        L14:
            r0 = 8
        L16:
            com.google.android.material.internal.CheckableImageButton r1 = r2.t0
            r1.setVisibility(r0)
            r2.q()
            r2.w()
            int r0 = r2.i0
            if (r0 == 0) goto L26
            return
        L26:
            r2.o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.r():void");
    }

    public final void s() {
        if (this.R != 1) {
            FrameLayout frameLayout = this.g;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iC = c();
            if (iC != layoutParams.topMargin) {
                layoutParams.topMargin = iC;
                frameLayout.requestLayout();
            }
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.a0 != i) {
            this.a0 = i;
            this.C0 = i;
            this.E0 = i;
            this.F0 = i;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(np1.k(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.C0 = defaultColor;
        this.a0 = defaultColor;
        this.D0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.F0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.R) {
            return;
        }
        this.R = i;
        if (this.k != null) {
            h();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.S = i;
    }

    public void setBoxStrokeColor(int i) {
        if (this.A0 != i) {
            this.A0 = i;
            y();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.y0 = colorStateList.getDefaultColor();
            this.G0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.z0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.A0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.A0 != colorStateList.getDefaultColor()) {
            this.A0 = colorStateList.getDefaultColor();
        }
        y();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.B0 != colorStateList) {
            this.B0 = colorStateList;
            y();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.U = i;
        y();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.V = i;
        y();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.r != z) {
            jf0 jf0Var = this.q;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.u = appCompatTextView;
                appCompatTextView.setId(u51.textinput_counter);
                Typeface typeface = this.e0;
                if (typeface != null) {
                    this.u.setTypeface(typeface);
                }
                this.u.setMaxLines(1);
                jf0Var.a(this.u, 2);
                ((ViewGroup.MarginLayoutParams) this.u.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(d51.mtrl_textinput_counter_margin_start));
                n();
                if (this.u != null) {
                    EditText editText = this.k;
                    m(editText == null ? 0 : editText.getText().length());
                }
            } else {
                jf0Var.h(this.u, 2);
                this.u = null;
            }
            this.r = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.s != i) {
            if (i > 0) {
                this.s = i;
            } else {
                this.s = -1;
            }
            if (!this.r || this.u == null) {
                return;
            }
            EditText editText = this.k;
            m(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.v != i) {
            this.v = i;
            n();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            n();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.w != i) {
            this.w = i;
            n();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            n();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.w0 = colorStateList;
        this.x0 = colorStateList;
        if (this.k != null) {
            t(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        j(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.k0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.k0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? hg0.o(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.i0;
        if (i2 == i) {
            return;
        }
        this.i0 = i;
        for (fj fjVar : this.l0) {
            switch (fjVar.a) {
                case 0:
                    EditText editText = getEditText();
                    if (editText != null && i2 == 2) {
                        editText.post(new w1(fjVar, editText, 8, false));
                        View.OnFocusChangeListener onFocusChangeListener = editText.getOnFocusChangeListener();
                        jj jjVar = (jj) fjVar.b;
                        if (onFocusChangeListener == jjVar.f) {
                            editText.setOnFocusChangeListener(null);
                        }
                        if (jjVar.c.getOnFocusChangeListener() == jjVar.f) {
                            jjVar.c.setOnFocusChangeListener(null);
                        }
                    }
                    break;
                case 1:
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) getEditText();
                    ux uxVar = (ux) fjVar.b;
                    if (autoCompleteTextView != null && i2 == 3) {
                        autoCompleteTextView.post(new w1(fjVar, autoCompleteTextView, 13, false));
                        if (autoCompleteTextView.getOnFocusChangeListener() == uxVar.f) {
                            autoCompleteTextView.setOnFocusChangeListener(null);
                        }
                        autoCompleteTextView.setOnTouchListener(null);
                        autoCompleteTextView.setOnDismissListener(null);
                    }
                    if (i2 == 3) {
                        removeOnAttachStateChangeListener(uxVar.j);
                        AccessibilityManager accessibilityManager = uxVar.q;
                        if (accessibilityManager != null) {
                            accessibilityManager.removeTouchExplorationStateChangeListener(new f0(uxVar.k));
                        }
                    }
                    break;
                default:
                    EditText editText2 = getEditText();
                    if (editText2 != null && i2 == 1) {
                        editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        editText2.post(new el0(fjVar, editText2, 7));
                    }
                    break;
            }
        }
        setEndIconVisible(i != 0);
        if (!getEndIconDelegate().b(this.R)) {
            throw new IllegalStateException("The current box background mode " + this.R + " is not supported by the end icon mode " + i);
        }
        getEndIconDelegate().a();
        z71.b(this, this.k0, this.m0, this.n0);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.r0;
        CheckableImageButton checkableImageButton = this.k0;
        checkableImageButton.setOnClickListener(onClickListener);
        k(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.r0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.k0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        k(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.m0 != colorStateList) {
            this.m0 = colorStateList;
            z71.b(this, this.k0, colorStateList, this.n0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.n0 != mode) {
            this.n0 = mode;
            z71.b(this, this.k0, this.m0, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        if (g() != z) {
            this.k0.setVisibility(z ? 0 : 8);
            q();
            w();
            o();
        }
    }

    public void setError(CharSequence charSequence) {
        jf0 jf0Var = this.q;
        if (!jf0Var.k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            jf0Var.g();
            return;
        }
        jf0Var.c();
        jf0Var.j = charSequence;
        jf0Var.l.setText(charSequence);
        int i = jf0Var.h;
        if (i != 1) {
            jf0Var.i = 1;
        }
        jf0Var.j(i, jf0Var.i, jf0Var.i(jf0Var.l, charSequence));
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        jf0 jf0Var = this.q;
        jf0Var.m = charSequence;
        AppCompatTextView appCompatTextView = jf0Var.l;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        jf0 jf0Var = this.q;
        if (jf0Var.k == z) {
            return;
        }
        jf0Var.c();
        TextInputLayout textInputLayout = jf0Var.b;
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(jf0Var.a);
            jf0Var.l = appCompatTextView;
            appCompatTextView.setId(u51.textinput_error);
            jf0Var.l.setTextAlignment(5);
            Typeface typeface = jf0Var.u;
            if (typeface != null) {
                jf0Var.l.setTypeface(typeface);
            }
            int i = jf0Var.n;
            jf0Var.n = i;
            AppCompatTextView appCompatTextView2 = jf0Var.l;
            if (appCompatTextView2 != null) {
                textInputLayout.l(appCompatTextView2, i);
            }
            ColorStateList colorStateList = jf0Var.o;
            jf0Var.o = colorStateList;
            AppCompatTextView appCompatTextView3 = jf0Var.l;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = jf0Var.m;
            jf0Var.m = charSequence;
            AppCompatTextView appCompatTextView4 = jf0Var.l;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            jf0Var.l.setVisibility(4);
            AppCompatTextView appCompatTextView5 = jf0Var.l;
            WeakHashMap weakHashMap = qs1.a;
            appCompatTextView5.setAccessibilityLiveRegion(1);
            jf0Var.a(jf0Var.l, 0);
        } else {
            jf0Var.g();
            jf0Var.h(jf0Var.l, 0);
            jf0Var.l = null;
            textInputLayout.p();
            textInputLayout.y();
        }
        jf0Var.k = z;
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? hg0.o(getContext(), i) : null);
        z71.l(this, this.t0, this.u0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.s0;
        CheckableImageButton checkableImageButton = this.t0;
        checkableImageButton.setOnClickListener(onClickListener);
        k(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.s0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.t0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        k(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.u0 != colorStateList) {
            this.u0 = colorStateList;
            z71.b(this, this.t0, colorStateList, this.v0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.v0 != mode) {
            this.v0 = mode;
            z71.b(this, this.t0, this.u0, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        jf0 jf0Var = this.q;
        jf0Var.n = i;
        AppCompatTextView appCompatTextView = jf0Var.l;
        if (appCompatTextView != null) {
            jf0Var.b.l(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        jf0 jf0Var = this.q;
        jf0Var.o = colorStateList;
        AppCompatTextView appCompatTextView = jf0Var.l;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.J0 != z) {
            this.J0 = z;
            t(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        jf0 jf0Var = this.q;
        if (zIsEmpty) {
            if (jf0Var.q) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!jf0Var.q) {
            setHelperTextEnabled(true);
        }
        jf0Var.c();
        jf0Var.p = charSequence;
        jf0Var.r.setText(charSequence);
        int i = jf0Var.h;
        if (i != 2) {
            jf0Var.i = 2;
        }
        jf0Var.j(i, jf0Var.i, jf0Var.i(jf0Var.r, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        jf0 jf0Var = this.q;
        jf0Var.t = colorStateList;
        AppCompatTextView appCompatTextView = jf0Var.r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        jf0 jf0Var = this.q;
        if (jf0Var.q == z) {
            return;
        }
        jf0Var.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(jf0Var.a);
            jf0Var.r = appCompatTextView;
            appCompatTextView.setId(u51.textinput_helper_text);
            jf0Var.r.setTextAlignment(5);
            Typeface typeface = jf0Var.u;
            if (typeface != null) {
                jf0Var.r.setTypeface(typeface);
            }
            jf0Var.r.setVisibility(4);
            AppCompatTextView appCompatTextView2 = jf0Var.r;
            WeakHashMap weakHashMap = qs1.a;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i = jf0Var.s;
            jf0Var.s = i;
            AppCompatTextView appCompatTextView3 = jf0Var.r;
            if (appCompatTextView3 != null) {
                qg0.K(appCompatTextView3, i);
            }
            ColorStateList colorStateList = jf0Var.t;
            jf0Var.t = colorStateList;
            AppCompatTextView appCompatTextView4 = jf0Var.r;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            jf0Var.a(jf0Var.r, 1);
            jf0Var.r.setAccessibilityDelegate(new if0(jf0Var));
        } else {
            jf0Var.c();
            int i2 = jf0Var.h;
            if (i2 == 2) {
                jf0Var.i = 0;
            }
            jf0Var.j(i2, jf0Var.i, jf0Var.i(jf0Var.r, ""));
            jf0Var.h(jf0Var.r, 1);
            jf0Var.r = null;
            TextInputLayout textInputLayout = jf0Var.b;
            textInputLayout.p();
            textInputLayout.y();
        }
        jf0Var.q = z;
    }

    public void setHelperTextTextAppearance(int i) {
        jf0 jf0Var = this.q;
        jf0Var.s = i;
        AppCompatTextView appCompatTextView = jf0Var.r;
        if (appCompatTextView != null) {
            qg0.K(appCompatTextView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.I) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.K0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.I) {
            this.I = z;
            if (z) {
                CharSequence hint = this.k.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.J)) {
                        setHint(hint);
                    }
                    this.k.setHint((CharSequence) null);
                }
                this.K = true;
            } else {
                this.K = false;
                if (!TextUtils.isEmpty(this.J) && TextUtils.isEmpty(this.k.getHint())) {
                    this.k.setHint(this.J);
                }
                setHintInternal(null);
            }
            if (this.k != null) {
                s();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        vj vjVar = this.I0;
        TextInputLayout textInputLayout = vjVar.a;
        zm1 zm1Var = new zm1(textInputLayout.getContext(), i);
        ColorStateList colorStateList = zm1Var.j;
        if (colorStateList != null) {
            vjVar.l = colorStateList;
        }
        float f = zm1Var.k;
        if (f != 0.0f) {
            vjVar.j = f;
        }
        ColorStateList colorStateList2 = zm1Var.a;
        if (colorStateList2 != null) {
            vjVar.S = colorStateList2;
        }
        vjVar.Q = zm1Var.e;
        vjVar.R = zm1Var.f;
        vjVar.P = zm1Var.g;
        vjVar.T = zm1Var.i;
        dg dgVar = vjVar.z;
        if (dgVar != null) {
            dgVar.o = true;
        }
        nx0 nx0Var = new nx0(vjVar, 8);
        zm1Var.a();
        vjVar.z = new dg(nx0Var, zm1Var.n);
        zm1Var.c(textInputLayout.getContext(), vjVar.z);
        vjVar.i(false);
        this.x0 = vjVar.l;
        if (this.k != null) {
            t(false, false);
            s();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            if (this.w0 == null) {
                this.I0.j(colorStateList);
            }
            this.x0 = colorStateList;
            if (this.k != null) {
                t(false, false);
            }
        }
    }

    public void setMaxEms(int i) {
        this.n = i;
        EditText editText = this.k;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.p = i;
        EditText editText = this.k;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.m = i;
        EditText editText = this.k;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.o = i;
        EditText editText = this.k;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? hg0.o(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.i0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.m0 = colorStateList;
        z71.b(this, this.k0, colorStateList, this.n0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.n0 = mode;
        z71.b(this, this.k0, this.m0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.z == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.z = appCompatTextView;
            appCompatTextView.setId(u51.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.z;
            WeakHashMap weakHashMap = qs1.a;
            appCompatTextView2.setImportantForAccessibility(2);
            l20 l20Var = new l20();
            l20Var.i = 87L;
            LinearInterpolator linearInterpolator = n5.a;
            l20Var.j = linearInterpolator;
            this.C = l20Var;
            l20Var.h = 67L;
            l20 l20Var2 = new l20();
            l20Var2.i = 87L;
            l20Var2.j = linearInterpolator;
            this.D = l20Var2;
            setPlaceholderTextAppearance(this.B);
            setPlaceholderTextColor(this.A);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.y) {
                setPlaceholderTextEnabled(true);
            }
            this.x = charSequence;
        }
        EditText editText = this.k;
        u(editText != null ? editText.getText().length() : 0);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.B = i;
        AppCompatTextView appCompatTextView = this.z;
        if (appCompatTextView != null) {
            qg0.K(appCompatTextView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            AppCompatTextView appCompatTextView = this.z;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        aj1 aj1Var = this.h;
        aj1Var.getClass();
        aj1Var.i = TextUtils.isEmpty(charSequence) ? null : charSequence;
        aj1Var.h.setText(charSequence);
        aj1Var.d();
    }

    public void setPrefixTextAppearance(int i) {
        qg0.K(this.h.h, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.h.h.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.h.j.setCheckable(z);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.h.j;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? hg0.o(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        aj1 aj1Var = this.h;
        View.OnLongClickListener onLongClickListener = aj1Var.m;
        CheckableImageButton checkableImageButton = aj1Var.j;
        checkableImageButton.setOnClickListener(onClickListener);
        z71.p(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        aj1 aj1Var = this.h;
        aj1Var.m = onLongClickListener;
        CheckableImageButton checkableImageButton = aj1Var.j;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        z71.p(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        aj1 aj1Var = this.h;
        if (aj1Var.k != colorStateList) {
            aj1Var.k = colorStateList;
            z71.b(aj1Var.g, aj1Var.j, colorStateList, aj1Var.l);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        aj1 aj1Var = this.h;
        if (aj1Var.l != mode) {
            aj1Var.l = mode;
            z71.b(aj1Var.g, aj1Var.j, aj1Var.k, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.h.b(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.G = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.H.setText(charSequence);
        x();
    }

    public void setSuffixTextAppearance(int i) {
        qg0.K(this.H, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.H.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(gn1 gn1Var) {
        EditText editText = this.k;
        if (editText != null) {
            qs1.p(editText, gn1Var);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.e0) {
            this.e0 = typeface;
            this.I0.n(typeface);
            jf0 jf0Var = this.q;
            if (typeface != jf0Var.u) {
                jf0Var.u = typeface;
                AppCompatTextView appCompatTextView = jf0Var.l;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = jf0Var.r;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.u;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t(boolean z, boolean z2) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.k;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.k;
        boolean z4 = editText2 != null && editText2.hasFocus();
        jf0 jf0Var = this.q;
        boolean zE = jf0Var.e();
        ColorStateList colorStateList2 = this.w0;
        vj vjVar = this.I0;
        if (colorStateList2 != null) {
            vjVar.j(colorStateList2);
            ColorStateList colorStateList3 = this.w0;
            if (vjVar.k != colorStateList3) {
                vjVar.k = colorStateList3;
                vjVar.i(false);
            }
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList4 = this.w0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.G0) : this.G0;
            vjVar.j(ColorStateList.valueOf(colorForState));
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(colorForState);
            if (vjVar.k != colorStateListValueOf) {
                vjVar.k = colorStateListValueOf;
                vjVar.i(false);
            }
        } else if (zE) {
            AppCompatTextView appCompatTextView2 = jf0Var.l;
            vjVar.j(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.t && (appCompatTextView = this.u) != null) {
            vjVar.j(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.x0) != null) {
            vjVar.j(colorStateList);
        }
        aj1 aj1Var = this.h;
        if (z3 || !this.J0 || (isEnabled() && z4)) {
            if (z2 || this.H0) {
                ValueAnimator valueAnimator = this.L0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.L0.cancel();
                }
                if (z && this.K0) {
                    a(1.0f);
                } else {
                    vjVar.l(1.0f);
                }
                this.H0 = false;
                if (d()) {
                    i();
                }
                EditText editText3 = this.k;
                u(editText3 == null ? 0 : editText3.getText().length());
                aj1Var.n = false;
                aj1Var.d();
                x();
                return;
            }
            return;
        }
        if (z2 || !this.H0) {
            ValueAnimator valueAnimator2 = this.L0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.L0.cancel();
            }
            if (z && this.K0) {
                a(0.0f);
            } else {
                vjVar.l(0.0f);
            }
            if (d() && !((sr) this.L).D.isEmpty() && d()) {
                ((sr) this.L).o(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.H0 = true;
            AppCompatTextView appCompatTextView3 = this.z;
            if (appCompatTextView3 != null && this.y) {
                appCompatTextView3.setText((CharSequence) null);
                cp1.a(this.g, this.D);
                this.z.setVisibility(4);
            }
            aj1Var.n = true;
            aj1Var.d();
            x();
        }
    }

    public final void u(int i) {
        FrameLayout frameLayout = this.g;
        if (i != 0 || this.H0) {
            AppCompatTextView appCompatTextView = this.z;
            if (appCompatTextView == null || !this.y) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            cp1.a(frameLayout, this.D);
            this.z.setVisibility(4);
            return;
        }
        if (this.z == null || !this.y || TextUtils.isEmpty(this.x)) {
            return;
        }
        this.z.setText(this.x);
        cp1.a(frameLayout, this.C);
        this.z.setVisibility(0);
        this.z.bringToFront();
        announceForAccessibility(this.x);
    }

    public final void v(boolean z, boolean z2) {
        int defaultColor = this.B0.getDefaultColor();
        int colorForState = this.B0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.B0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.W = colorForState2;
        } else if (z2) {
            this.W = colorForState;
        } else {
            this.W = defaultColor;
        }
    }

    public final void w() {
        int paddingEnd;
        if (this.k == null) {
            return;
        }
        if (g() || this.t0.getVisibility() == 0) {
            paddingEnd = 0;
        } else {
            EditText editText = this.k;
            WeakHashMap weakHashMap = qs1.a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d51.material_input_text_to_prefix_suffix_padding);
        int paddingTop = this.k.getPaddingTop();
        int paddingBottom = this.k.getPaddingBottom();
        WeakHashMap weakHashMap2 = qs1.a;
        this.H.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void x() {
        AppCompatTextView appCompatTextView = this.H;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.G == null || this.H0) ? 8 : 0;
        if (visibility != i) {
            getEndIconDelegate().c(i == 0);
        }
        q();
        appCompatTextView.setVisibility(i);
        o();
    }

    public final void y() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.L == null || this.R == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.k) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.k) != null && editText.isHovered())) {
            z = true;
        }
        boolean zIsEnabled = isEnabled();
        jf0 jf0Var = this.q;
        if (!zIsEnabled) {
            this.W = this.G0;
        } else if (jf0Var.e()) {
            if (this.B0 != null) {
                v(z2, z);
            } else {
                AppCompatTextView appCompatTextView2 = jf0Var.l;
                this.W = appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1;
            }
        } else if (!this.t || (appCompatTextView = this.u) == null) {
            if (z2) {
                this.W = this.A0;
            } else if (z) {
                this.W = this.z0;
            } else {
                this.W = this.y0;
            }
        } else if (this.B0 != null) {
            v(z2, z);
        } else {
            this.W = appCompatTextView.getCurrentTextColor();
        }
        r();
        z71.l(this, this.t0, this.u0);
        aj1 aj1Var = this.h;
        z71.l(aj1Var.g, aj1Var.j, aj1Var.k);
        ColorStateList colorStateList = this.m0;
        CheckableImageButton checkableImageButton = this.k0;
        z71.l(this, checkableImageButton, colorStateList);
        c00 endIconDelegate = getEndIconDelegate();
        endIconDelegate.getClass();
        if (endIconDelegate instanceof ux) {
            if (!jf0Var.e() || getEndIconDrawable() == null) {
                z71.b(this, checkableImageButton, this.m0, this.n0);
            } else {
                Drawable drawableMutate = az1.L(getEndIconDrawable()).mutate();
                AppCompatTextView appCompatTextView3 = jf0Var.l;
                drawableMutate.setTint(appCompatTextView3 != null ? appCompatTextView3.getCurrentTextColor() : -1);
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        if (this.R == 2) {
            int i = this.T;
            if (z2 && isEnabled()) {
                this.T = this.V;
            } else {
                this.T = this.U;
            }
            if (this.T != i && d() && !this.H0) {
                if (d()) {
                    ((sr) this.L).o(0.0f, 0.0f, 0.0f, 0.0f);
                }
                i();
            }
        }
        if (this.R == 1) {
            if (!isEnabled()) {
                this.a0 = this.D0;
            } else if (z && !z2) {
                this.a0 = this.F0;
            } else if (z2) {
                this.a0 = this.E0;
            } else {
                this.a0 = this.C0;
            }
        }
        b();
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.k0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.k0;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            z71.b(this, checkableImageButton, this.m0, this.n0);
            z71.l(this, checkableImageButton, this.m0);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.h.a(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.t0;
        checkableImageButton.setImageDrawable(drawable);
        r();
        z71.b(this, checkableImageButton, this.u0, this.v0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.k0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.k0.setImageDrawable(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }
}
