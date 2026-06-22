package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.appcompat.widget.TooltipCompat;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class em1 extends LinearLayout {
    public static final /* synthetic */ int r = 0;
    public bm1 g;
    public TextView h;
    public ImageView i;
    public View j;
    public oa k;
    public View l;
    public TextView m;
    public ImageView n;
    public Drawable o;
    public int p;
    public final /* synthetic */ TabLayout q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em1(TabLayout tabLayout, Context context) {
        super(context);
        int i = 19;
        this.q = tabLayout;
        this.p = 2;
        f(context);
        int i2 = tabLayout.j;
        WeakHashMap weakHashMap = qs1.a;
        setPaddingRelative(i2, tabLayout.k, tabLayout.l, tabLayout.m);
        setGravity(17);
        setOrientation(!tabLayout.G ? 1 : 0);
        setClickable(true);
        Context context2 = getContext();
        int i3 = Build.VERSION.SDK_INT;
        mc1 mc1Var = i3 >= 24 ? new mc1(sl.e(context2), i) : new mc1((Object) null, i);
        if (i3 >= 24) {
            js1.a(this, ep0.j((PointerIcon) mc1Var.h));
        }
    }

    private oa getBadge() {
        return this.k;
    }

    private oa getOrCreateBadge() {
        if (this.k == null) {
            this.k = new oa(getContext());
        }
        c();
        oa oaVar = this.k;
        if (oaVar != null) {
            return oaVar;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    public final void a(View view) {
        if (this.k == null || view == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
        oa oaVar = this.k;
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        oaVar.setBounds(rect);
        oaVar.e(view, null);
        WeakReference weakReference = oaVar.s;
        if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
            WeakReference weakReference2 = oaVar.s;
            (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(oaVar);
        } else {
            view.getOverlay().add(oaVar);
        }
        this.j = view;
    }

    public final void b() {
        if (this.k != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.j;
            if (view != null) {
                oa oaVar = this.k;
                if (oaVar != null) {
                    WeakReference weakReference = oaVar.s;
                    if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                        WeakReference weakReference2 = oaVar.s;
                        (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                    } else {
                        view.getOverlay().remove(oaVar);
                    }
                }
                this.j = null;
            }
        }
    }

    public final void c() {
        bm1 bm1Var;
        if (this.k != null) {
            if (this.l != null) {
                b();
                return;
            }
            ImageView imageView = this.i;
            if (imageView != null && (bm1Var = this.g) != null && bm1Var.a != null) {
                if (this.j == imageView) {
                    d(imageView);
                    return;
                } else {
                    b();
                    a(this.i);
                    return;
                }
            }
            TextView textView = this.h;
            if (textView == null || this.g == null) {
                b();
            } else if (this.j == textView) {
                d(textView);
            } else {
                b();
                a(this.h);
            }
        }
    }

    public final void d(View view) {
        oa oaVar = this.k;
        if (oaVar == null || view != this.j) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        oaVar.setBounds(rect);
        oaVar.e(view, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        if ((drawable == null || !drawable.isStateful()) ? false : this.o.setState(drawableState)) {
            invalidate();
            this.q.invalidate();
        }
    }

    public final void e() {
        bm1 bm1Var = this.g;
        View view = bm1Var != null ? bm1Var.e : null;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
            }
            this.l = view;
            TextView textView = this.h;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.i;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.i.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.m = textView2;
            if (textView2 != null) {
                this.p = textView2.getMaxLines();
            }
            this.n = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view2 = this.l;
            if (view2 != null) {
                removeView(view2);
                this.l = null;
            }
            this.m = null;
            this.n = null;
        }
        boolean z = false;
        if (this.l == null) {
            if (this.i == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(l61.design_layout_tab_icon, (ViewGroup) this, false);
                this.i = imageView2;
                addView(imageView2, 0);
            }
            if (this.h == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(l61.design_layout_tab_text, (ViewGroup) this, false);
                this.h = textView3;
                addView(textView3);
                this.p = this.h.getMaxLines();
            }
            TextView textView4 = this.h;
            TabLayout tabLayout = this.q;
            qg0.K(textView4, tabLayout.n);
            ColorStateList colorStateList = tabLayout.o;
            if (colorStateList != null) {
                this.h.setTextColor(colorStateList);
            }
            g(this.h, this.i);
            c();
            ImageView imageView3 = this.i;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new dm1(this, imageView3));
            }
            TextView textView5 = this.h;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new dm1(this, textView5));
            }
        } else {
            TextView textView6 = this.m;
            if (textView6 != null || this.n != null) {
                g(textView6, this.n);
            }
        }
        if (bm1Var != null && !TextUtils.isEmpty(bm1Var.c)) {
            setContentDescription(bm1Var.c);
        }
        if (bm1Var != null) {
            TabLayout tabLayout2 = bm1Var.f;
            if (tabLayout2 == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout2.getSelectedTabPosition();
            if (selectedTabPosition != -1 && selectedTabPosition == bm1Var.d) {
                z = true;
            }
        }
        setSelected(z);
    }

    public final void f(Context context) {
        TabLayout tabLayout = this.q;
        int i = tabLayout.w;
        if (i != 0) {
            Drawable drawableO = hg0.o(context, i);
            this.o = drawableO;
            if (drawableO != null && drawableO.isStateful()) {
                this.o.setState(getDrawableState());
            }
        } else {
            this.o = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        Drawable rippleDrawable = gradientDrawable;
        if (tabLayout.q != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateList = tabLayout.q;
            int colorForState = colorStateList != null ? colorStateList.getColorForState(wd.u, colorStateList.getDefaultColor()) : 0;
            int iH = ik.h(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
            int[][] iArr = {wd.v, StateSet.NOTHING};
            int colorForState2 = colorStateList != null ? colorStateList.getColorForState(wd.t, colorStateList.getDefaultColor()) : 0;
            ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{iH, ik.h(colorForState2, Math.min(Color.alpha(colorForState2) * 2, 255))});
            boolean z = tabLayout.K;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (z) {
                gradientDrawable3 = null;
            }
            rippleDrawable = new RippleDrawable(colorStateList2, gradientDrawable3, z ? null : gradientDrawable2);
        }
        WeakHashMap weakHashMap = qs1.a;
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void g(TextView textView, ImageView imageView) {
        Drawable drawable;
        bm1 bm1Var = this.g;
        Drawable drawableMutate = (bm1Var == null || (drawable = bm1Var.a) == null) ? null : az1.L(drawable).mutate();
        TabLayout tabLayout = this.q;
        if (drawableMutate != null) {
            drawableMutate.setTintList(tabLayout.p);
            PorterDuff.Mode mode = tabLayout.t;
            if (mode != null) {
                drawableMutate.setTintMode(mode);
            }
        }
        bm1 bm1Var2 = this.g;
        CharSequence charSequence = bm1Var2 != null ? bm1Var2.b : null;
        if (imageView != null) {
            if (drawableMutate != null) {
                imageView.setImageDrawable(drawableMutate);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                textView.setVisibility(8);
                textView.setText((CharSequence) null);
            } else {
                textView.setText(charSequence);
                this.g.getClass();
                textView.setVisibility(0);
                setVisibility(0);
            }
        }
        if (imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iQ = (zIsEmpty || imageView.getVisibility() != 0) ? 0 : (int) qg0.q(getContext(), 8);
            if (tabLayout.G) {
                if (iQ != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iQ);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iQ != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iQ;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        bm1 bm1Var3 = this.g;
        CharSequence charSequence2 = bm1Var3 != null ? bm1Var3.c : null;
        if (Build.VERSION.SDK_INT > 23) {
            if (zIsEmpty) {
                charSequence = charSequence2;
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.h, this.i, this.l};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.h, this.i, this.l};
        int iMax = 0;
        int iMin = 0;
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                z = true;
            }
        }
        return iMax - iMin;
    }

    public bm1 getTab() {
        return this.g;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Context context;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        oa oaVar = this.k;
        if (oaVar != null && oaVar.isVisible()) {
            CharSequence contentDescription = getContentDescription();
            StringBuilder sb = new StringBuilder();
            sb.append((Object) contentDescription);
            sb.append(", ");
            oa oaVar2 = this.k;
            Object quantityString = null;
            if (oaVar2.isVisible()) {
                boolean zD = oaVar2.d();
                qa qaVar = oaVar2.k;
                if (!zD) {
                    quantityString = qaVar.b.n;
                } else if (qaVar.b.o != 0 && (context = (Context) oaVar2.g.get()) != null) {
                    int iC = oaVar2.c();
                    int i = oaVar2.n;
                    pa paVar = qaVar.b;
                    quantityString = iC <= i ? context.getResources().getQuantityString(paVar.o, oaVar2.c(), Integer.valueOf(oaVar2.c())) : context.getString(paVar.p, Integer.valueOf(i));
                }
            }
            sb.append(quantityString);
            accessibilityNodeInfo.setContentDescription(sb.toString());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) nx0.v(0, 1, this.g.d, 1, false, isSelected()).h);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) n0.g.a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(v61.item_view_role_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.q;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.x, RtlSpacingHelper.UNDEFINED);
        }
        super.onMeasure(i, i2);
        if (this.h != null) {
            float f = tabLayout.u;
            int i3 = this.p;
            ImageView imageView = this.i;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.h;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.v;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.h.getTextSize();
            int lineCount = this.h.getLineCount();
            int maxLines = this.h.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (tabLayout.F == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.h.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.h.setTextSize(0, f);
                this.h.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.g == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        this.g.a();
        return true;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        isSelected();
        super.setSelected(z);
        TextView textView = this.h;
        if (textView != null) {
            textView.setSelected(z);
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setSelected(z);
        }
        View view = this.l;
        if (view != null) {
            view.setSelected(z);
        }
    }

    public void setTab(bm1 bm1Var) {
        if (bm1Var != this.g) {
            this.g = bm1Var;
            e();
        }
    }
}
