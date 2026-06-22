package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import defpackage.az1;
import defpackage.q71;
import defpackage.qs1;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff.Mode mTickMarkTintMode;
    private final SeekBar mView;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
                Drawable drawableL = az1.L(drawable.mutate());
                this.mTickMark = drawableL;
                if (this.mHasTickMarkTint) {
                    drawableL.setTintList(this.mTickMarkTintList);
                }
                if (this.mHasTickMarkTintMode) {
                    this.mTickMark.setTintMode(this.mTickMarkTintMode);
                }
                if (this.mTickMark.isStateful()) {
                    this.mTickMark.setState(this.mView.getDrawableState());
                }
            }
        }
    }

    public void drawTickMarks(Canvas canvas) {
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.mTickMark.setBounds(-i, -i2, i, i2);
                float width = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void drawableStateChanged() {
        Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    public Drawable getTickMark() {
        return this.mTickMark;
    }

    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, q71.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.mView;
        qs1.o(seekBar, seekBar.getContext(), q71.AppCompatSeekBar, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i);
        Drawable drawableIfKnown = tintTypedArrayObtainStyledAttributes.getDrawableIfKnown(q71.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.mView.setThumb(drawableIfKnown);
        }
        setTickMark(tintTypedArrayObtainStyledAttributes.getDrawable(q71.AppCompatSeekBar_tickMark));
        if (tintTypedArrayObtainStyledAttributes.hasValue(q71.AppCompatSeekBar_tickMarkTintMode)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(q71.AppCompatSeekBar_tickMarkTintMode, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(q71.AppCompatSeekBar_tickMarkTint)) {
            this.mTickMarkTintList = tintTypedArrayObtainStyledAttributes.getColorStateList(q71.AppCompatSeekBar_tickMarkTint);
            this.mHasTickMarkTint = true;
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        applyTickMarkTint();
    }

    public void setTickMark(Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            SeekBar seekBar = this.mView;
            WeakHashMap weakHashMap = qs1.a;
            az1.G(drawable, seekBar.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    public void setTickMarkTintList(ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    public void setTickMarkTintMode(PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
