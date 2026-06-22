package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import com.luutinhit.launcherios.cropper.CropImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class nc extends AsyncTask {
    public final WeakReference a;
    public final Uri b;
    public final Context c;
    public final int d;
    public final int e;

    public nc(CropImageView cropImageView, Uri uri) {
        this.b = uri;
        this.a = new WeakReference(cropImageView);
        this.c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        double d = displayMetrics.density > 1.0f ? 1.0f / r6 : 1.0d;
        this.d = (int) (((double) displayMetrics.widthPixels) * d);
        this.e = (int) (((double) displayMetrics.heightPixels) * d);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Void[] r6 = (java.lang.Void[]) r6
            android.content.Context r6 = r5.c
            android.net.Uri r0 = r5.b
            boolean r1 = r5.isCancelled()     // Catch: java.lang.Exception -> L72
            r2 = 0
            if (r1 != 0) goto L74
            int r1 = r5.d     // Catch: java.lang.Exception -> L72
            int r3 = r5.e     // Catch: java.lang.Exception -> L72
            rc r1 = defpackage.sc.j(r6, r0, r1, r3)     // Catch: java.lang.Exception -> L72
            boolean r3 = r5.isCancelled()     // Catch: java.lang.Exception -> L72
            if (r3 != 0) goto L74
            android.graphics.Bitmap r3 = r1.a     // Catch: java.lang.Exception -> L72
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Exception -> L33
            java.io.InputStream r6 = r6.openInputStream(r0)     // Catch: java.lang.Exception -> L33
            if (r6 == 0) goto L34
            s10 r4 = new s10     // Catch: java.lang.Exception -> L33
            r4.<init>(r6)     // Catch: java.lang.Exception -> L33
            r6.close()     // Catch: java.lang.Exception -> L31
        L2f:
            r2 = r4
            goto L34
        L31:
            goto L2f
        L33:
        L34:
            r6 = 0
            if (r2 == 0) goto L61
            java.lang.String r4 = "Orientation"
            o10 r4 = r2.c(r4)     // Catch: java.lang.Exception -> L72
            if (r4 != 0) goto L40
            goto L47
        L40:
            java.nio.ByteOrder r2 = r2.f     // Catch: java.lang.NumberFormatException -> L47 java.lang.Exception -> L72
            int r2 = r4.e(r2)     // Catch: java.lang.NumberFormatException -> L47 java.lang.Exception -> L72
            goto L48
        L47:
            r2 = 1
        L48:
            r4 = 3
            if (r2 == r4) goto L59
            r4 = 6
            if (r2 == r4) goto L56
            r4 = 8
            if (r2 == r4) goto L53
            goto L5b
        L53:
            r6 = 270(0x10e, float:3.78E-43)
            goto L5b
        L56:
            r6 = 90
            goto L5b
        L59:
            r6 = 180(0xb4, float:2.52E-43)
        L5b:
            rc r2 = new rc     // Catch: java.lang.Exception -> L72
            r2.<init>(r6, r3)     // Catch: java.lang.Exception -> L72
            goto L66
        L61:
            rc r2 = new rc     // Catch: java.lang.Exception -> L72
            r2.<init>(r6, r3)     // Catch: java.lang.Exception -> L72
        L66:
            mc r6 = new mc     // Catch: java.lang.Exception -> L72
            android.graphics.Bitmap r3 = r2.a     // Catch: java.lang.Exception -> L72
            int r1 = r1.b     // Catch: java.lang.Exception -> L72
            int r2 = r2.b     // Catch: java.lang.Exception -> L72
            r6.<init>(r0, r3, r1, r2)     // Catch: java.lang.Exception -> L72
            goto L7b
        L72:
            r6 = move-exception
            goto L75
        L74:
            return r2
        L75:
            mc r1 = new mc
            r1.<init>(r0, r6)
            r6 = r1
        L7b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nc.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        CropImageView cropImageView;
        mc mcVar = (mc) obj;
        if (mcVar != null) {
            if (isCancelled() || (cropImageView = (CropImageView) this.a.get()) == null) {
                Bitmap bitmap = mcVar.b;
                if (bitmap != null) {
                    bitmap.recycle();
                    return;
                }
                return;
            }
            cropImageView.N = null;
            cropImageView.g();
            Exception exc = mcVar.e;
            if (exc == null) {
                int i = mcVar.d;
                cropImageView.p = i;
                cropImageView.e(mcVar.b, 0, mcVar.a, mcVar.c, i);
            }
            xp xpVar = cropImageView.C;
            if (xpVar != null) {
                CropImageActivity cropImageActivity = (CropImageActivity) xpVar;
                if (exc != null) {
                    cropImageActivity.A(null, exc, 1);
                    return;
                }
                Rect rect = cropImageActivity.D.S;
                if (rect != null) {
                    cropImageActivity.B.setCropRect(rect);
                }
                int i2 = cropImageActivity.D.T;
                if (i2 > -1) {
                    cropImageActivity.B.setRotatedDegrees(i2);
                }
            }
        }
    }
}
