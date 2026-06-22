package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.hg0;
import defpackage.j71;
import defpackage.xe0;
import defpackage.ye0;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    public final ye0 g;
    public boolean h;
    public Drawable i;
    public Drawable j;
    public float k;
    public float l;
    public float m;
    public Path n;
    public ViewOutlineProvider o;
    public RectF p;
    public final Drawable[] q;
    public LayerDrawable r;
    public float s;
    public float t;
    public float u;
    public float v;

    public ImageFilterView(Context context) {
        super(context);
        this.g = new ye0();
        this.h = true;
        this.i = null;
        this.j = null;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = Float.NaN;
        this.q = new Drawable[2];
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = Float.NaN;
    }

    private void setOverlay(boolean z) {
        this.h = z;
    }

    public final void b() {
        if (Float.isNaN(this.s) && Float.isNaN(this.t) && Float.isNaN(this.u) && Float.isNaN(this.v)) {
            return;
        }
        float f = Float.isNaN(this.s) ? 0.0f : this.s;
        float f2 = Float.isNaN(this.t) ? 0.0f : this.t;
        float f3 = Float.isNaN(this.u) ? 1.0f : this.u;
        float f4 = Float.isNaN(this.v) ? 0.0f : this.v;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f5 = f3 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f5, f5);
        float f6 = intrinsicWidth * f5;
        float f7 = f5 * intrinsicHeight;
        matrix.postTranslate(((((width - f6) * f) + width) - f6) * 0.5f, ((((height - f7) * f2) + height) - f7) * 0.5f);
        matrix.postRotate(f4, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void c() {
        if (Float.isNaN(this.s) && Float.isNaN(this.t) && Float.isNaN(this.u) && Float.isNaN(this.v)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            b();
        }
    }

    public float getBrightness() {
        return this.g.d;
    }

    public float getContrast() {
        return this.g.f;
    }

    public float getCrossfade() {
        return this.k;
    }

    public float getImagePanX() {
        return this.s;
    }

    public float getImagePanY() {
        return this.t;
    }

    public float getImageRotate() {
        return this.v;
    }

    public float getImageZoom() {
        return this.u;
    }

    public float getRound() {
        return this.m;
    }

    public float getRoundPercent() {
        return this.l;
    }

    public float getSaturation() {
        return this.g.e;
    }

    public float getWarmth() {
        return this.g.g;
    }

    @Override // android.view.View
    public final void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        b();
    }

    public void setAltImageDrawable(Drawable drawable) {
        Drawable drawableMutate = drawable.mutate();
        this.i = drawableMutate;
        Drawable drawable2 = this.j;
        Drawable[] drawableArr = this.q;
        drawableArr[0] = drawable2;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.r = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.k);
    }

    public void setAltImageResource(int i) {
        Drawable drawableO = hg0.o(getContext(), i);
        this.i = drawableO;
        setAltImageDrawable(drawableO);
    }

    public void setBrightness(float f) {
        ye0 ye0Var = this.g;
        ye0Var.d = f;
        ye0Var.a(this);
    }

    public void setContrast(float f) {
        ye0 ye0Var = this.g;
        ye0Var.f = f;
        ye0Var.a(this);
    }

    public void setCrossfade(float f) {
        this.k = f;
        if (this.q != null) {
            if (!this.h) {
                this.r.getDrawable(0).setAlpha((int) ((1.0f - this.k) * 255.0f));
            }
            this.r.getDrawable(1).setAlpha((int) (this.k * 255.0f));
            super.setImageDrawable(this.r);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.i == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.j = drawableMutate;
        Drawable[] drawableArr = this.q;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.i;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.r = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.k);
    }

    public void setImagePanX(float f) {
        this.s = f;
        c();
    }

    public void setImagePanY(float f) {
        this.t = f;
        c();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.i == null) {
            super.setImageResource(i);
            return;
        }
        Drawable drawableMutate = hg0.o(getContext(), i).mutate();
        this.j = drawableMutate;
        Drawable[] drawableArr = this.q;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.i;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        this.r = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.k);
    }

    public void setImageRotate(float f) {
        this.v = f;
        c();
    }

    public void setImageZoom(float f) {
        this.u = f;
        c();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.m = f;
            float f2 = this.l;
            this.l = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.m != f;
        this.m = f;
        if (f != 0.0f) {
            if (this.n == null) {
                this.n = new Path();
            }
            if (this.p == null) {
                this.p = new RectF();
            }
            if (this.o == null) {
                xe0 xe0Var = new xe0(this, 1);
                this.o = xe0Var;
                setOutlineProvider(xe0Var);
            }
            setClipToOutline(true);
            this.p.set(0.0f, 0.0f, getWidth(), getHeight());
            this.n.reset();
            Path path = this.n;
            RectF rectF = this.p;
            float f3 = this.m;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.l != f;
        this.l = f;
        if (f != 0.0f) {
            if (this.n == null) {
                this.n = new Path();
            }
            if (this.p == null) {
                this.p = new RectF();
            }
            if (this.o == null) {
                xe0 xe0Var = new xe0(this, 0);
                this.o = xe0Var;
                setOutlineProvider(xe0Var);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.l) / 2.0f;
            this.p.set(0.0f, 0.0f, width, height);
            this.n.reset();
            this.n.addRoundRect(this.p, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        ye0 ye0Var = this.g;
        ye0Var.e = f;
        ye0Var.a(this);
    }

    public void setWarmth(float f) {
        ye0 ye0Var = this.g;
        ye0Var.g = f;
        ye0Var.a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ye0();
        this.h = true;
        this.i = null;
        this.j = null;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = Float.NaN;
        this.q = new Drawable[2];
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = Float.NaN;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j71.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.i = typedArrayObtainStyledAttributes.getDrawable(j71.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == j71.ImageFilterView_crossfade) {
                    this.k = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == j71.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == j71.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == j71.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == j71.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == j71.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == j71.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == j71.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.h));
                } else if (index == j71.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.s));
                } else if (index == j71.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.t));
                } else if (index == j71.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.v));
                } else if (index == j71.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.u));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.j = drawable;
            Drawable drawable2 = this.i;
            Drawable[] drawableArr = this.q;
            if (drawable2 != null && drawable != null) {
                Drawable drawableMutate = getDrawable().mutate();
                this.j = drawableMutate;
                drawableArr[0] = drawableMutate;
                drawableArr[1] = this.i.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
                this.r = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.k * 255.0f));
                if (!this.h) {
                    this.r.getDrawable(0).setAlpha((int) ((1.0f - this.k) * 255.0f));
                }
                super.setImageDrawable(this.r);
                return;
            }
            Drawable drawable3 = getDrawable();
            this.j = drawable3;
            if (drawable3 != null) {
                Drawable drawableMutate2 = drawable3.mutate();
                this.j = drawableMutate2;
                drawableArr[0] = drawableMutate2;
            }
        }
    }
}
