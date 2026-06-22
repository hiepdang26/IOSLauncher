package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import defpackage.az1;
import defpackage.hg0;
import defpackage.q71;
import defpackage.qg0;
import defpackage.qs1;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        Drawable drawableS = qg0.s(this.mView);
        if (drawableS != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable drawableMutate = az1.L(drawableS).mutate();
                if (this.mHasButtonTint) {
                    drawableMutate.setTintList(this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    drawableMutate.setTintMode(this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.mView.getDrawableState());
                }
                this.mView.setButtonDrawable(drawableMutate);
            }
        }
    }

    public int getCompoundPaddingLeft(int i) {
        return i;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, q71.CompoundButton, i, 0);
        CompoundButton compoundButton = this.mView;
        qs1.o(compoundButton, compoundButton.getContext(), q71.CompoundButton, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i);
        try {
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CompoundButton_buttonCompat) && (resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(q71.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.mView;
                    compoundButton2.setButtonDrawable(hg0.o(compoundButton2.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CompoundButton_android_button)) {
                        CompoundButton compoundButton3 = this.mView;
                        compoundButton3.setButtonDrawable(hg0.o(compoundButton3.getContext(), resourceId));
                    }
                }
            } else if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CompoundButton_android_button) && (resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(q71.CompoundButton_android_button, 0)) != 0) {
                CompoundButton compoundButton32 = this.mView;
                compoundButton32.setButtonDrawable(hg0.o(compoundButton32.getContext(), resourceId));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CompoundButton_buttonTint)) {
                this.mView.setButtonTintList(tintTypedArrayObtainStyledAttributes.getColorStateList(q71.CompoundButton_buttonTint));
            }
            if (tintTypedArrayObtainStyledAttributes.hasValue(q71.CompoundButton_buttonTintMode)) {
                this.mView.setButtonTintMode(DrawableUtils.parseTintMode(tintTypedArrayObtainStyledAttributes.getInt(q71.CompoundButton_buttonTintMode, -1), null));
            }
            tintTypedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            tintTypedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
