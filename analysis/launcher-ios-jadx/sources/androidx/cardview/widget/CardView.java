package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.i71;
import defpackage.k41;
import defpackage.ka0;
import defpackage.pc1;
import defpackage.q11;
import defpackage.v41;
import defpackage.y61;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] l = {R.attr.colorBackground};
    public static final ka0 m = new ka0(12);
    public boolean g;
    public boolean h;
    public final Rect i;
    public final Rect j;
    public final q11 k;

    /* JADX WARN: Illegal instructions before constructor call */
    public CardView(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        int i = k41.cardViewStyle;
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.i = rect;
        this.j = new Rect();
        q11 q11Var = new q11(this);
        this.k = q11Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i71.CardView, i, y61.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(i71.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i71.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(l);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(v41.cardview_light_background) : getResources().getColor(v41.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(i71.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(i71.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(i71.CardView_cardMaxElevation, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getBoolean(i71.CardView_cardUseCompatPadding, false);
        this.h = typedArrayObtainStyledAttributes.getBoolean(i71.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(i71.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        ka0 ka0Var = m;
        pc1 pc1Var = new pc1(colorStateListValueOf, dimension);
        q11Var.h = pc1Var;
        setBackgroundDrawable(pc1Var);
        setClipToOutline(true);
        setElevation(dimension2);
        ka0Var.q(q11Var, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((pc1) ((Drawable) this.k.h)).h;
    }

    public float getCardElevation() {
        return ((CardView) this.k.i).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.i.bottom;
    }

    public int getContentPaddingLeft() {
        return this.i.left;
    }

    public int getContentPaddingRight() {
        return this.i.right;
    }

    public int getContentPaddingTop() {
        return this.i.top;
    }

    public float getMaxCardElevation() {
        return ((pc1) ((Drawable) this.k.h)).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.h;
    }

    public float getRadius() {
        return ((pc1) ((Drawable) this.k.h)).a;
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        pc1 pc1Var = (pc1) ((Drawable) this.k.h);
        if (colorStateListValueOf == null) {
            pc1Var.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        pc1Var.h = colorStateListValueOf;
        pc1Var.b.setColor(colorStateListValueOf.getColorForState(pc1Var.getState(), pc1Var.h.getDefaultColor()));
        pc1Var.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.k.i).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        m.q(this.k, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.h) {
            this.h = z;
            ka0 ka0Var = m;
            q11 q11Var = this.k;
            ka0Var.q(q11Var, ((pc1) ((Drawable) q11Var.h)).e);
        }
    }

    public void setRadius(float f) {
        pc1 pc1Var = (pc1) ((Drawable) this.k.h);
        if (f == pc1Var.a) {
            return;
        }
        pc1Var.a = f;
        pc1Var.b(null);
        pc1Var.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.g != z) {
            this.g = z;
            ka0 ka0Var = m;
            q11 q11Var = this.k;
            ka0Var.q(q11Var, ((pc1) ((Drawable) q11Var.h)).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        pc1 pc1Var = (pc1) ((Drawable) this.k.h);
        if (colorStateList == null) {
            pc1Var.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        pc1Var.h = colorStateList;
        pc1Var.b.setColor(colorStateList.getColorForState(pc1Var.getState(), pc1Var.h.getDefaultColor()));
        pc1Var.invalidateSelf();
    }
}
