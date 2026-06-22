package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.luutinhit.launcherios.cropper.CropOverlayView;

/* JADX INFO: loaded from: classes.dex */
public final class pp extends Animation implements Animation.AnimationListener {
    public final ImageView g;
    public final CropOverlayView h;
    public final float[] i = new float[8];
    public final float[] j = new float[8];
    public final RectF k = new RectF();
    public final RectF l = new RectF();
    public final float[] m = new float[9];
    public final float[] n = new float[9];
    public final RectF o = new RectF();
    public final float[] p = new float[8];
    public final float[] q = new float[9];

    public pp(ImageView imageView, CropOverlayView cropOverlayView) {
        this.g = imageView;
        this.h = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        float[] fArr;
        RectF rectF = this.o;
        RectF rectF2 = this.k;
        float f2 = rectF2.left;
        RectF rectF3 = this.l;
        rectF.left = uo.s(rectF3.left, f2, f, f2);
        float f3 = rectF2.top;
        rectF.top = uo.s(rectF3.top, f3, f, f3);
        float f4 = rectF2.right;
        rectF.right = uo.s(rectF3.right, f4, f, f4);
        float f5 = rectF2.bottom;
        rectF.bottom = uo.s(rectF3.bottom, f5, f, f5);
        CropOverlayView cropOverlayView = this.h;
        cropOverlayView.setCropWindowRect(rectF);
        int i = 0;
        int i2 = 0;
        while (true) {
            fArr = this.p;
            if (i2 >= fArr.length) {
                break;
            }
            float f6 = this.i[i2];
            fArr[i2] = uo.s(this.j[i2], f6, f, f6);
            i2++;
        }
        ImageView imageView = this.g;
        cropOverlayView.h(fArr, imageView.getWidth(), imageView.getHeight());
        while (true) {
            float[] fArr2 = this.q;
            if (i >= fArr2.length) {
                Matrix imageMatrix = imageView.getImageMatrix();
                imageMatrix.setValues(fArr2);
                imageView.setImageMatrix(imageMatrix);
                imageView.invalidate();
                cropOverlayView.invalidate();
                return;
            }
            float f7 = this.m[i];
            fArr2[i] = uo.s(this.n[i], f7, f, f7);
            i++;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.g.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
