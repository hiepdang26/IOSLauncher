package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.az1;
import defpackage.hg0;
import defpackage.q71;
import defpackage.qs1;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private int mLevel = 0;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList imageTintList = this.mView.getImageTintList();
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        PorterDuff.Mode imageTintMode = this.mView.getImageTintMode();
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.mInternalImageTint != null : i == 21;
    }

    public void applyImageLevel() {
        if (this.mView.getDrawable() != null) {
            this.mView.getDrawable().setLevel(this.mLevel);
        }
    }

    public void applySupportImageTint() {
        Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null) {
            if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(drawable)) {
                return;
            }
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.mInternalImageTint;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(drawable, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    public ColorStateList getSupportImageTintList() {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return !(this.mView.getBackground() instanceof RippleDrawable);
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        Drawable drawable;
        int resourceId;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, q71.AppCompatImageView, i, 0);
        ImageView imageView = this.mView;
        qs1.o(imageView, imageView.getContext(), q71.AppCompatImageView, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i);
        try {
            Drawable drawable2 = this.mView.getDrawable();
            if (drawable2 == null && (resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(q71.AppCompatImageView_srcCompat, -1)) != -1 && (drawable2 = hg0.o(this.mView.getContext(), resourceId)) != null) {
                this.mView.setImageDrawable(drawable2);
            }
            if (drawable2 != null) {
                DrawableUtils.fixDrawable(drawable2);
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.AppCompatImageView_tint)) {
                az1.F(this.mView, tintTypedArrayObtainStyledAttributes.getColorStateList(q71.AppCompatImageView_tint));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.AppCompatImageView_tintMode)) {
                ImageView imageView2 = this.mView;
                PorterDuff.Mode tintMode = DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(q71.AppCompatImageView_tintMode, -1), null);
                int i2 = Build.VERSION.SDK_INT;
                imageView2.setImageTintMode(tintMode);
                if (i2 == 21 && (drawable = imageView2.getDrawable()) != null && imageView2.getImageTintList() != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView2.getDrawableState());
                    }
                    imageView2.setImageDrawable(drawable);
                }
            }
            tintTypedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            tintTypedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void obtainLevelFromDrawable(Drawable drawable) {
        this.mLevel = drawable.getLevel();
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawableO = hg0.o(this.mView.getContext(), i);
            if (drawableO != null) {
                DrawableUtils.fixDrawable(drawableO);
            }
            this.mView.setImageDrawable(drawableO);
        } else {
            this.mView.setImageDrawable(null);
        }
        applySupportImageTint();
    }

    public void setInternalImageTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new TintInfo();
            }
            TintInfo tintInfo = this.mInternalImageTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        applySupportImageTint();
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportImageTint();
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportImageTint();
    }
}
