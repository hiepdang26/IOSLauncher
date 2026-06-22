package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import com.luutinhit.launcherios.cropper.CropImageView;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class gc extends AsyncTask {
    public final WeakReference a;
    public final Bitmap b;
    public final Uri c;
    public final Context d;
    public final float[] e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final int p;
    public final Uri q;
    public final Bitmap.CompressFormat r;
    public final int s;

    public gc(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, int i4, int i5, boolean z2, boolean z3, int i6, Uri uri, Bitmap.CompressFormat compressFormat, int i7) {
        this.a = new WeakReference(cropImageView);
        this.d = cropImageView.getContext();
        this.b = bitmap;
        this.e = fArr;
        this.c = null;
        this.f = i;
        this.i = z;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.n = z2;
        this.o = z3;
        this.p = i6;
        this.q = uri;
        this.r = compressFormat;
        this.s = i7;
        this.g = 0;
        this.h = 0;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        rc rcVarF;
        try {
            OutputStream outputStreamOpenOutputStream = null;
            if (isCancelled()) {
                return null;
            }
            Uri uri = this.c;
            if (uri != null) {
                rcVarF = sc.d(this.d, uri, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
            } else {
                Bitmap bitmap = this.b;
                if (bitmap == null) {
                    return new fc(1, (Bitmap) null);
                }
                rcVarF = sc.f(bitmap, this.e, this.f, this.i, this.j, this.k, this.n, this.o);
            }
            int i = rcVarF.b;
            Bitmap bitmapR = sc.r(rcVarF.a, this.l, this.m, this.p);
            Uri uri2 = this.q;
            if (uri2 == null) {
                return new fc(i, bitmapR);
            }
            Context context = this.d;
            Bitmap.CompressFormat compressFormat = this.r;
            int i2 = this.s;
            try {
                outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri2);
                bitmapR.compress(compressFormat, i2, outputStreamOpenOutputStream);
                sc.c(outputStreamOpenOutputStream);
                bitmapR.recycle();
                return new fc(uri2, i);
            } catch (Throwable th) {
                sc.c(outputStreamOpenOutputStream);
                throw th;
            }
        } catch (Exception e) {
            return new fc(e);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        CropImageView cropImageView;
        fc fcVar = (fc) obj;
        if (fcVar != null) {
            if (isCancelled() || (cropImageView = (CropImageView) this.a.get()) == null) {
                Bitmap bitmap = fcVar.a;
                if (bitmap != null) {
                    bitmap.recycle();
                    return;
                }
                return;
            }
            cropImageView.O = null;
            cropImageView.g();
            tp tpVar = cropImageView.D;
            if (tpVar != null) {
                cropImageView.getCropPoints();
                cropImageView.getCropRect();
                cropImageView.getWholeImageRect();
                cropImageView.getRotatedDegrees();
                ((CropImageActivity) tpVar).A(fcVar.b, fcVar.c, fcVar.d);
            }
        }
    }

    public gc(CropImageView cropImageView, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, int i8, Uri uri2, Bitmap.CompressFormat compressFormat, int i9) {
        this.a = new WeakReference(cropImageView);
        this.d = cropImageView.getContext();
        this.c = uri;
        this.e = fArr;
        this.f = i;
        this.i = z;
        this.j = i4;
        this.k = i5;
        this.g = i2;
        this.h = i3;
        this.l = i6;
        this.m = i7;
        this.n = z2;
        this.o = z3;
        this.p = i8;
        this.q = uri2;
        this.r = compressFormat;
        this.s = i9;
        this.b = null;
    }
}
