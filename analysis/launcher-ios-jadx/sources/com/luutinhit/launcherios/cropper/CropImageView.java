package com.luutinhit.launcherios.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import defpackage.bq;
import defpackage.e51;
import defpackage.g71;
import defpackage.gc;
import defpackage.m61;
import defpackage.nc;
import defpackage.ow1;
import defpackage.pp;
import defpackage.qp;
import defpackage.rp;
import defpackage.sc;
import defpackage.sp;
import defpackage.tp;
import defpackage.up;
import defpackage.v51;
import defpackage.vp;
import defpackage.wp;
import defpackage.xp;
import defpackage.yp;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CropImageView extends FrameLayout {
    public static final /* synthetic */ int P = 0;
    public boolean A;
    public int B;
    public xp C;
    public tp D;
    public Uri E;
    public int F;
    public float G;
    public float H;
    public float I;
    public RectF J;
    public int K;
    public boolean L;
    public Uri M;
    public WeakReference N;
    public WeakReference O;
    public final ImageView g;
    public final CropOverlayView h;
    public final Matrix i;
    public final Matrix j;
    public final ProgressBar k;
    public final float[] l;
    public final float[] m;
    public pp n;
    public Bitmap o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public yp w;
    public boolean x;
    public boolean y;
    public boolean z;

    public CropImageView(Context context, AttributeSet attributeSet) {
        Bundle bundleExtra;
        super(context, attributeSet);
        this.i = new Matrix();
        this.j = new Matrix();
        this.l = new float[8];
        this.m = new float[8];
        this.x = false;
        this.y = true;
        this.z = true;
        this.A = true;
        this.F = 1;
        this.G = 1.0f;
        qp qpVar = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (intent != null && (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) != null) {
            qpVar = (qp) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (qpVar == null) {
            qpVar = new qp();
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.CropImageView, 0, 0);
                try {
                    qpVar.s = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropFixAspectRatio, qpVar.s);
                    qpVar.t = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropAspectRatioX, qpVar.t);
                    qpVar.u = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropAspectRatioY, qpVar.u);
                    qpVar.l = yp.values()[typedArrayObtainStyledAttributes.getInt(g71.CropImageView_cropScaleType, qpVar.l.ordinal())];
                    qpVar.o = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropAutoZoomEnabled, qpVar.o);
                    qpVar.p = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropMultiTouchEnabled, qpVar.p);
                    qpVar.q = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropMaxZoom, qpVar.q);
                    qpVar.g = rp.values()[typedArrayObtainStyledAttributes.getInt(g71.CropImageView_cropShape, qpVar.g.ordinal())];
                    qpVar.k = sp.values()[typedArrayObtainStyledAttributes.getInt(g71.CropImageView_cropGuidelines, qpVar.k.ordinal())];
                    qpVar.i = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropSnapRadius, qpVar.i);
                    qpVar.j = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropTouchRadius, qpVar.j);
                    qpVar.r = typedArrayObtainStyledAttributes.getFloat(g71.CropImageView_cropInitialCropWindowPaddingRatio, qpVar.r);
                    qpVar.v = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropBorderLineThickness, qpVar.v);
                    qpVar.w = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropBorderLineColor, qpVar.w);
                    qpVar.x = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropBorderCornerThickness, qpVar.x);
                    qpVar.y = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropBorderCornerOffset, qpVar.y);
                    qpVar.z = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropBorderCornerLength, qpVar.z);
                    qpVar.A = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropBorderCornerColor, qpVar.A);
                    qpVar.B = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropGuidelinesThickness, qpVar.B);
                    qpVar.C = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropGuidelinesColor, qpVar.C);
                    qpVar.D = typedArrayObtainStyledAttributes.getInteger(g71.CropImageView_cropBackgroundColor, qpVar.D);
                    qpVar.m = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropShowCropOverlay, this.y);
                    qpVar.n = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropShowProgressBar, this.z);
                    qpVar.x = typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropBorderCornerThickness, qpVar.x);
                    qpVar.E = (int) typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropMinCropWindowWidth, qpVar.E);
                    qpVar.F = (int) typedArrayObtainStyledAttributes.getDimension(g71.CropImageView_cropMinCropWindowHeight, qpVar.F);
                    qpVar.G = (int) typedArrayObtainStyledAttributes.getFloat(g71.CropImageView_cropMinCropResultWidthPX, qpVar.G);
                    qpVar.H = (int) typedArrayObtainStyledAttributes.getFloat(g71.CropImageView_cropMinCropResultHeightPX, qpVar.H);
                    qpVar.I = (int) typedArrayObtainStyledAttributes.getFloat(g71.CropImageView_cropMaxCropResultWidthPX, qpVar.I);
                    qpVar.J = (int) typedArrayObtainStyledAttributes.getFloat(g71.CropImageView_cropMaxCropResultHeightPX, qpVar.J);
                    qpVar.Y = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropFlipHorizontally, qpVar.Y);
                    qpVar.Z = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropFlipHorizontally, qpVar.Z);
                    this.x = typedArrayObtainStyledAttributes.getBoolean(g71.CropImageView_cropSaveBitmapToInstanceState, this.x);
                    if (typedArrayObtainStyledAttributes.hasValue(g71.CropImageView_cropAspectRatioX) && typedArrayObtainStyledAttributes.hasValue(g71.CropImageView_cropAspectRatioX) && !typedArrayObtainStyledAttributes.hasValue(g71.CropImageView_cropFixAspectRatio)) {
                        qpVar.s = true;
                    }
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
        qpVar.a();
        this.w = qpVar.l;
        this.A = qpVar.o;
        this.B = qpVar.q;
        this.y = qpVar.m;
        this.z = qpVar.n;
        this.r = qpVar.Y;
        this.s = qpVar.Z;
        View viewInflate = LayoutInflater.from(context).inflate(m61.crop_image_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) viewInflate.findViewById(v51.ImageView_image);
        this.g = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) viewInflate.findViewById(v51.CropOverlayView);
        this.h = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new ow1(this, 9));
        cropOverlayView.setInitialAttributeValues(qpVar);
        this.k = (ProgressBar) viewInflate.findViewById(v51.CropProgressBar);
        g();
    }

    public final void a(float f, float f2, boolean z, boolean z2) {
        if (this.o != null) {
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            Matrix matrix = this.i;
            Matrix matrix2 = this.j;
            matrix.invert(matrix2);
            CropOverlayView cropOverlayView = this.h;
            RectF cropWindowRect = cropOverlayView.getCropWindowRect();
            matrix2.mapRect(cropWindowRect);
            matrix.reset();
            matrix.postTranslate((f - this.o.getWidth()) / 2.0f, (f2 - this.o.getHeight()) / 2.0f);
            d();
            int i = this.q;
            float[] fArr = this.l;
            if (i > 0) {
                matrix.postRotate(i, (sc.o(fArr) + sc.p(fArr)) / 2.0f, (sc.q(fArr) + sc.m(fArr)) / 2.0f);
                d();
            }
            float fMin = Math.min(f / (sc.p(fArr) - sc.o(fArr)), f2 / (sc.m(fArr) - sc.q(fArr)));
            yp ypVar = this.w;
            if (ypVar == yp.g || ((ypVar == yp.h && fMin < 1.0f) || (fMin > 1.0f && this.A))) {
                matrix.postScale(fMin, fMin, (sc.o(fArr) + sc.p(fArr)) / 2.0f, (sc.q(fArr) + sc.m(fArr)) / 2.0f);
                d();
            }
            float f3 = this.r ? -this.G : this.G;
            float f4 = this.s ? -this.G : this.G;
            matrix.postScale(f3, f4, (sc.o(fArr) + sc.p(fArr)) / 2.0f, (sc.q(fArr) + sc.m(fArr)) / 2.0f);
            d();
            matrix.mapRect(cropWindowRect);
            if (z) {
                this.H = f > sc.p(fArr) - sc.o(fArr) ? 0.0f : Math.max(Math.min((f / 2.0f) - cropWindowRect.centerX(), -sc.o(fArr)), getWidth() - sc.p(fArr)) / f3;
                this.I = f2 <= sc.m(fArr) - sc.q(fArr) ? Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerY(), -sc.q(fArr)), getHeight() - sc.m(fArr)) / f4 : 0.0f;
            } else {
                this.H = Math.min(Math.max(this.H * f3, -cropWindowRect.left), (-cropWindowRect.right) + f) / f3;
                this.I = Math.min(Math.max(this.I * f4, -cropWindowRect.top), (-cropWindowRect.bottom) + f2) / f4;
            }
            matrix.postTranslate(this.H * f3, this.I * f4);
            cropWindowRect.offset(this.H * f3, this.I * f4);
            cropOverlayView.setCropWindowRect(cropWindowRect);
            d();
            cropOverlayView.invalidate();
            ImageView imageView = this.g;
            if (z2) {
                pp ppVar = this.n;
                System.arraycopy(fArr, 0, ppVar.j, 0, 8);
                ppVar.l.set(ppVar.h.getCropWindowRect());
                matrix.getValues(ppVar.n);
                imageView.startAnimation(this.n);
            } else {
                imageView.setImageMatrix(matrix);
            }
            i(false);
        }
    }

    public final void b() {
        Bitmap bitmap = this.o;
        if (bitmap != null && (this.v > 0 || this.E != null)) {
            bitmap.recycle();
        }
        this.o = null;
        this.v = 0;
        this.E = null;
        this.F = 1;
        this.q = 0;
        this.G = 1.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.i.reset();
        this.M = null;
        this.g.setImageBitmap(null);
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.cropper.CropImageView.c(boolean, boolean):void");
    }

    public final void d() {
        float[] fArr = this.l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.o.getWidth();
        fArr[3] = 0.0f;
        fArr[4] = this.o.getWidth();
        fArr[5] = this.o.getHeight();
        fArr[6] = 0.0f;
        fArr[7] = this.o.getHeight();
        Matrix matrix = this.i;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.m;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 100.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 100.0f;
        fArr2[5] = 100.0f;
        fArr2[6] = 0.0f;
        fArr2[7] = 100.0f;
        matrix.mapPoints(fArr2);
    }

    public final void e(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        Bitmap bitmap2 = this.o;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            ImageView imageView = this.g;
            imageView.clearAnimation();
            b();
            this.o = bitmap;
            imageView.setImageBitmap(bitmap);
            this.E = uri;
            this.v = i;
            this.F = i2;
            this.q = i3;
            a(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.h;
            if (cropOverlayView != null) {
                cropOverlayView.g();
                f();
            }
        }
    }

    public final void f() {
        CropOverlayView cropOverlayView = this.h;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.y || this.o == null) ? 4 : 0);
        }
    }

    public final void g() {
        this.k.setVisibility(this.z && ((this.o == null && this.N != null) || this.O != null) ? 0 : 4);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        CropOverlayView cropOverlayView = this.h;
        return new Pair<>(Integer.valueOf(cropOverlayView.getAspectRatioX()), Integer.valueOf(cropOverlayView.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.h.getCropWindowRect();
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.crop_delete_edge);
        float[] fArr = new float[8];
        float f = cropWindowRect.left;
        float f2 = dimensionPixelSize;
        fArr[0] = f + f2;
        float f3 = cropWindowRect.top;
        fArr[1] = f3 + f2;
        float f4 = cropWindowRect.right;
        fArr[2] = f4 - f2;
        fArr[3] = f3 + f2;
        fArr[4] = f4 - f2;
        float f5 = cropWindowRect.bottom;
        fArr[5] = f5 - f2;
        fArr[6] = f + f2;
        fArr[7] = f5 - f2;
        Matrix matrix = this.i;
        Matrix matrix2 = this.j;
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        for (int i = 0; i < 8; i++) {
            fArr[i] = fArr[i] * this.F;
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i = this.F;
        Bitmap bitmap = this.o;
        if (bitmap == null) {
            return null;
        }
        float[] cropPoints = getCropPoints();
        int width = bitmap.getWidth() * i;
        int height = bitmap.getHeight() * i;
        CropOverlayView cropOverlayView = this.h;
        return sc.n(cropPoints, width, height, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY());
    }

    public rp getCropShape() {
        return this.h.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.h;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        Bitmap bitmap;
        if (this.o == null) {
            return null;
        }
        this.g.clearAnimation();
        Uri uri = this.E;
        CropOverlayView cropOverlayView = this.h;
        if (uri == null || this.F <= 1) {
            bitmap = sc.f(this.o, getCropPoints(), this.q, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), this.r, this.s).a;
        } else {
            bitmap = sc.d(getContext(), this.E, getCropPoints(), this.q, this.o.getWidth() * this.F, this.o.getHeight() * this.F, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), 0, 0, this.r, this.s).a;
        }
        return sc.r(bitmap, 0, 0, 1);
    }

    public void getCroppedImageAsync() {
        if (this.D == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        h(0, 0, 1, null, null, 0);
    }

    public sp getGuidelines() {
        return this.h.getGuidelines();
    }

    public int getImageResource() {
        return this.v;
    }

    public Uri getImageUri() {
        return this.E;
    }

    public int getMaxZoom() {
        return this.B;
    }

    public int getRotatedDegrees() {
        return this.q;
    }

    public yp getScaleType() {
        return this.w;
    }

    public Rect getWholeImageRect() {
        int i = this.F;
        Bitmap bitmap = this.o;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public final void h(int i, int i2, int i3, Uri uri, Bitmap.CompressFormat compressFormat, int i4) {
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            this.g.clearAnimation();
            WeakReference weakReference = this.O;
            gc gcVar = weakReference != null ? (gc) weakReference.get() : null;
            if (gcVar != null) {
                gcVar.cancel(true);
            }
            int i5 = i3 != 1 ? i : 0;
            int i6 = i3 != 1 ? i2 : 0;
            int width = this.F * bitmap.getWidth();
            int height = bitmap.getHeight();
            int i7 = this.F;
            int i8 = height * i7;
            Uri uri2 = this.E;
            CropOverlayView cropOverlayView = this.h;
            if (uri2 == null || (i7 <= 1 && i3 != 2)) {
                this.O = new WeakReference(new gc(this, bitmap, getCropPoints(), this.q, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), i5, i6, this.r, this.s, i3, uri, compressFormat, i4));
            } else {
                this.O = new WeakReference(new gc(this, this.E, getCropPoints(), this.q, width, i8, cropOverlayView.A, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), i5, i6, this.r, this.s, i3, uri, compressFormat, i4));
            }
            ((gc) this.O.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            g();
        }
    }

    public final void i(boolean z) {
        Bitmap bitmap = this.o;
        CropOverlayView cropOverlayView = this.h;
        if (bitmap != null && !z) {
            float[] fArr = this.m;
            float fP = (this.F * 100.0f) / (sc.p(fArr) - sc.o(fArr));
            float fM = (this.F * 100.0f) / (sc.m(fArr) - sc.q(fArr));
            float width = getWidth();
            float height = getHeight();
            bq bqVar = cropOverlayView.i;
            bqVar.e = width;
            bqVar.f = height;
            bqVar.k = fP;
            bqVar.l = fM;
        }
        cropOverlayView.h(z ? null : this.l, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.t <= 0 || this.u <= 0) {
            i(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.t;
        layoutParams.height = this.u;
        setLayoutParams(layoutParams);
        if (this.o == null) {
            i(true);
            return;
        }
        float f = i3 - i;
        float f2 = i4 - i2;
        a(f, f2, true, false);
        if (this.J == null) {
            if (this.L) {
                this.L = false;
                c(false, false);
                return;
            }
            return;
        }
        int i5 = this.K;
        if (i5 != this.p) {
            this.q = i5;
            a(f, f2, true, false);
        }
        this.i.mapRect(this.J);
        RectF rectF = this.J;
        CropOverlayView cropOverlayView = this.h;
        cropOverlayView.setCropWindowRect(rectF);
        c(false, false);
        RectF cropWindowRect = cropOverlayView.getCropWindowRect();
        cropOverlayView.d(cropWindowRect);
        cropOverlayView.i.a.set(cropWindowRect);
        this.J = null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int width;
        int height;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.o;
        if (bitmap == null) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size2 == 0) {
            size2 = bitmap.getHeight();
        }
        double width2 = size < this.o.getWidth() ? ((double) size) / ((double) this.o.getWidth()) : Double.POSITIVE_INFINITY;
        double height2 = size2 < this.o.getHeight() ? ((double) size2) / ((double) this.o.getHeight()) : Double.POSITIVE_INFINITY;
        if (width2 == Double.POSITIVE_INFINITY && height2 == Double.POSITIVE_INFINITY) {
            width = this.o.getWidth();
            height = this.o.getHeight();
        } else if (width2 <= height2) {
            height = (int) (((double) this.o.getHeight()) * width2);
            width = size;
        } else {
            width = (int) (((double) this.o.getWidth()) * height2);
            height = size2;
        }
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(width, size) : width;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(height, size2) : height;
        }
        this.t = size;
        this.u = size2;
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onRestoreInstanceState(android.os.Parcelable r8) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.cropper.CropImageView.onRestoreInstanceState(android.os.Parcelable):void");
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() throws Throwable {
        nc ncVar;
        OutputStream outputStreamOpenOutputStream;
        boolean z = true;
        if (this.E == null && this.o == null && this.v < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.E;
        if (this.x && uri == null && this.v < 1) {
            Context context = getContext();
            Bitmap bitmap = this.o;
            Uri uriFromFile = this.M;
            Rect rect = sc.a;
            try {
                if (uriFromFile == null) {
                    uriFromFile = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
                } else if (new File(uriFromFile.getPath()).exists()) {
                    z = false;
                }
                if (z) {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    try {
                        outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriFromFile);
                        try {
                            bitmap.compress(compressFormat, 95, outputStreamOpenOutputStream);
                            sc.c(outputStreamOpenOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            sc.c(outputStreamOpenOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStreamOpenOutputStream = null;
                    }
                }
                uri = uriFromFile;
            } catch (Exception unused) {
                uri = null;
            }
            this.M = uri;
        }
        if (uri != null && this.o != null) {
            String string = UUID.randomUUID().toString();
            sc.g = new Pair(string, new WeakReference(this.o));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", string);
        }
        WeakReference weakReference = this.N;
        if (weakReference != null && (ncVar = (nc) weakReference.get()) != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", ncVar.b);
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.v);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.F);
        bundle.putInt("DEGREES_ROTATED", this.q);
        CropOverlayView cropOverlayView = this.h;
        bundle.putParcelable("INITIAL_CROP_RECT", cropOverlayView.getInitialCropWindowRect());
        RectF rectF = sc.c;
        rectF.set(cropOverlayView.getCropWindowRect());
        Matrix matrix = this.i;
        Matrix matrix2 = this.j;
        matrix.invert(matrix2);
        matrix2.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", cropOverlayView.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.A);
        bundle.putInt("CROP_MAX_ZOOM", this.B);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.r);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.s);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.L = i3 > 0 && i4 > 0;
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.A != z) {
            this.A = z;
            c(false, false);
            this.h.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.h.setInitialCropWindowRect(rect);
    }

    public void setCropShape(rp rpVar) {
        this.h.setCropShape(rpVar);
    }

    public void setFixedAspectRatio(boolean z) {
        this.h.setFixedAspectRatio(z);
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.r != z) {
            this.r = z;
            a(getWidth(), getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z) {
        if (this.s != z) {
            this.s = z;
            a(getWidth(), getHeight(), true, false);
        }
    }

    public void setGuidelines(sp spVar) {
        this.h.setGuidelines(spVar);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.h.setInitialCropWindowRect(null);
        e(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.h.setInitialCropWindowRect(null);
            e(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference weakReference = this.N;
            nc ncVar = weakReference != null ? (nc) weakReference.get() : null;
            if (ncVar != null) {
                ncVar.cancel(true);
            }
            b();
            this.J = null;
            this.K = 0;
            this.h.setInitialCropWindowRect(null);
            WeakReference weakReference2 = new WeakReference(new nc(this, uri));
            this.N = weakReference2;
            ((nc) weakReference2.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            g();
        }
    }

    public void setMaxZoom(int i) {
        if (this.B == i || i <= 0) {
            return;
        }
        this.B = i;
        c(false, false);
        this.h.invalidate();
    }

    public void setMultiTouchEnabled(boolean z) {
        CropOverlayView cropOverlayView = this.h;
        if (cropOverlayView.i(z)) {
            c(false, false);
            cropOverlayView.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(tp tpVar) {
        this.D = tpVar;
    }

    public void setOnSetImageUriCompleteListener(xp xpVar) {
        this.C = xpVar;
    }

    public void setRotatedDegrees(int i) {
        int i2 = this.q;
        if (i2 != i) {
            int i3 = i - i2;
            if (this.o != null) {
                int i4 = i3 < 0 ? (i3 % 360) + 360 : i3 % 360;
                CropOverlayView cropOverlayView = this.h;
                boolean z = !cropOverlayView.A && ((i4 > 45 && i4 < 135) || (i4 > 215 && i4 < 305));
                RectF rectF = sc.c;
                rectF.set(cropOverlayView.getCropWindowRect());
                float fHeight = (z ? rectF.height() : rectF.width()) / 2.0f;
                float fWidth = (z ? rectF.width() : rectF.height()) / 2.0f;
                if (z) {
                    boolean z2 = this.r;
                    this.r = this.s;
                    this.s = z2;
                }
                Matrix matrix = this.i;
                Matrix matrix2 = this.j;
                matrix.invert(matrix2);
                float[] fArr = sc.d;
                fArr[0] = rectF.centerX();
                fArr[1] = rectF.centerY();
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 1.0f;
                fArr[5] = 0.0f;
                matrix2.mapPoints(fArr);
                this.q = (this.q + i4) % 360;
                a(getWidth(), getHeight(), true, false);
                float[] fArr2 = sc.e;
                matrix.mapPoints(fArr2, fArr);
                float fSqrt = (float) (((double) this.G) / Math.sqrt(Math.pow(fArr2[5] - fArr2[3], 2.0d) + Math.pow(fArr2[4] - fArr2[2], 2.0d)));
                this.G = fSqrt;
                this.G = Math.max(fSqrt, 1.0f);
                a(getWidth(), getHeight(), true, false);
                matrix.mapPoints(fArr2, fArr);
                double dSqrt = Math.sqrt(Math.pow(fArr2[5] - fArr2[3], 2.0d) + Math.pow(fArr2[4] - fArr2[2], 2.0d));
                float f = (float) (((double) fHeight) * dSqrt);
                float f2 = (float) (((double) fWidth) * dSqrt);
                float f3 = fArr2[0];
                float f4 = fArr2[1];
                rectF.set(f3 - f, f4 - f2, f3 + f, f4 + f2);
                cropOverlayView.g();
                cropOverlayView.setCropWindowRect(rectF);
                a(getWidth(), getHeight(), true, false);
                c(false, false);
                RectF cropWindowRect = cropOverlayView.getCropWindowRect();
                cropOverlayView.d(cropWindowRect);
                cropOverlayView.i.a.set(cropWindowRect);
            }
        }
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.x = z;
    }

    public void setScaleType(yp ypVar) {
        if (ypVar != this.w) {
            this.w = ypVar;
            this.G = 1.0f;
            this.I = 0.0f;
            this.H = 0.0f;
            this.h.g();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z) {
        if (this.y != z) {
            this.y = z;
            f();
        }
    }

    public void setShowProgressBar(boolean z) {
        if (this.z != z) {
            this.z = z;
            g();
        }
    }

    public void setSnapRadius(float f) {
        if (f >= 0.0f) {
            this.h.setSnapRadius(f);
        }
    }

    public void setOnCropWindowChangedListener(wp wpVar) {
    }

    public void setOnSetCropOverlayMovedListener(up upVar) {
    }

    public void setOnSetCropOverlayReleasedListener(vp vpVar) {
    }
}
