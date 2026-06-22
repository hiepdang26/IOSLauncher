package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.appcompat.widget.ActivityChooserView;
import com.luutinhit.launcher6.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class gx1 {
    public final Context c;
    public final oe0 d;
    public final iy e;
    public final m7 f;
    public final me0 g;
    public final int h;
    public final HashMap a = new HashMap();
    public final Set b = Collections.newSetFromMap(new WeakHashMap());
    public final zp0 i = new zp0();
    public final Handler j = new Handler(rl0.w.getLooper());

    public gx1(Context context, oe0 oe0Var) {
        this.c = context;
        this.d = oe0Var;
        this.f = m7.f(context);
        this.e = iy.n(context);
        this.g = new me0(context, "widgetpreviews.db", 4, "shortcut_and_widget_previews", 1);
        this.h = context.getResources().getDimensionPixelSize(e51.profile_badge_margin);
    }

    public final Bitmap a(t tVar, rk0 rk0Var, int i, Bitmap bitmap, int[] iArr) {
        Drawable drawableK;
        int height;
        Bitmap bitmap2;
        int width;
        int i2;
        Bitmap bitmap3;
        rk0 rk0Var2;
        Bitmap bitmapCreateBitmap = bitmap;
        Objects.toString(tVar);
        Objects.toString(rk0Var);
        Objects.toString(bitmapCreateBitmap);
        int i3 = i < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i;
        int i4 = ((AppWidgetProviderInfo) rk0Var).previewImage;
        m7 m7Var = this.f;
        if (i4 != 0) {
            drawableK = m7Var.k(rk0Var);
            if (drawableK != null) {
                drawableK = c(drawableK);
            } else {
                Integer.toHexString(((AppWidgetProviderInfo) rk0Var).previewImage);
                Objects.toString(((AppWidgetProviderInfo) rk0Var).provider);
            }
        } else {
            drawableK = null;
        }
        boolean z = drawableK != null;
        int i5 = rk0Var.g;
        int i6 = rk0Var.h;
        Context context = this.c;
        if (z) {
            width = drawableK.getIntrinsicWidth();
            height = drawableK.getIntrinsicHeight();
            bitmap2 = null;
        } else {
            Resources resources = context.getResources();
            int i7 = l51.widget_tile;
            Resources.Theme theme = context.getTheme();
            ThreadLocal threadLocal = rb1.a;
            Bitmap bitmap4 = ((BitmapDrawable) resources.getDrawable(i7, theme)).getBitmap();
            int width2 = bitmap4.getWidth() * i5;
            height = bitmap4.getHeight() * i6;
            bitmap2 = bitmap4;
            width = width2;
        }
        if (iArr != null) {
            iArr[0] = width;
        }
        int i8 = this.h;
        float f = width > i3 ? (i3 - (i8 * 2)) / width : 1.0f;
        if (f != 1.0f) {
            width = (int) (width * f);
            height = (int) (height * f);
        }
        if (width <= 0 || height <= 0) {
            Resources resources2 = context.getResources();
            int i9 = l51.widget_tile;
            Resources.Theme theme2 = context.getTheme();
            ThreadLocal threadLocal2 = rb1.a;
            bitmap2 = ((BitmapDrawable) resources2.getDrawable(i9, theme2)).getBitmap();
            width = bitmap2.getWidth() * i5;
            height = bitmap2.getHeight() * i6;
        }
        Canvas canvas = new Canvas();
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            canvas.setBitmap(bitmapCreateBitmap);
        } else {
            canvas.setBitmap(bitmapCreateBitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        int width3 = (bitmapCreateBitmap.getWidth() - width) / 2;
        if (z) {
            drawableK.setBounds(width3, 0, width3 + width, height);
            drawableK.draw(canvas);
            rk0Var2 = rk0Var;
            bitmap3 = bitmapCreateBitmap;
            i2 = i8;
        } else {
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            int i10 = tVar.getDeviceProfile().D;
            i2 = i8;
            bitmap3 = bitmapCreateBitmap;
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            float width4 = bitmap2.getWidth() * f;
            float height2 = bitmap2.getHeight() * f;
            RectF rectF = new RectF(0.0f, 0.0f, width4, height2);
            float f2 = width3;
            int i11 = 0;
            while (i11 < i5) {
                int i12 = i11;
                float f3 = height2;
                int i13 = 0;
                float f4 = 0.0f;
                while (i13 < i6) {
                    rectF.offsetTo(f2, f4);
                    canvas.drawBitmap(bitmap2, rect, rectF, paint);
                    i13++;
                    f4 += f3;
                }
                i11 = i12 + 1;
                f2 += width4;
                height2 = f3;
            }
            float f5 = height2;
            float f6 = i10;
            float fMin = Math.min(Math.min(width, height) / ((((int) (0.25f * f6)) * 2) + i10), f);
            try {
                rk0Var2 = rk0Var;
                m7Var = m7Var;
                try {
                    Drawable drawableI = m7Var.i(rk0Var2, this.d);
                    if (drawableI != null) {
                        Drawable drawableC = c(drawableI);
                        float f7 = f6 * fMin;
                        int i14 = ((int) ((width4 - f7) / 2.0f)) + width3;
                        int i15 = (int) ((f5 - f7) / 2.0f);
                        int i16 = (int) f7;
                        drawableC.setBounds(i14, i15, i14 + i16, i16 + i15);
                        drawableC.draw(canvas);
                    }
                } catch (Resources.NotFoundException unused) {
                }
            } catch (Resources.NotFoundException unused2) {
                rk0Var2 = rk0Var;
                m7Var = m7Var;
            }
            canvas.setBitmap(null);
        }
        return m7Var.e(rk0Var2, bitmap3, Math.min(bitmap3.getWidth(), width + i2), Math.min(bitmap3.getHeight(), height + i2));
    }

    public final long[] b(String str) {
        long[] jArr;
        synchronized (this.a) {
            jArr = (long[]) this.a.get(str);
            if (jArr == null) {
                jArr = new long[2];
                try {
                    PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo(str, 0);
                    jArr[0] = packageInfo.versionCode;
                    jArr[1] = packageInfo.lastUpdateTime;
                } catch (PackageManager.NameNotFoundException unused) {
                }
                this.a.put(str, jArr);
            }
        }
        return jArr;
    }

    public final Drawable c(Drawable drawable) {
        Objects.toString(drawable);
        try {
            return (Drawable) this.i.submit(new sv(drawable, 2)).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void d(String str, jq1 jq1Var, long j) {
        Objects.toString(jq1Var);
        synchronized (this.a) {
            this.a.remove(str);
        }
        this.g.a("packageName = ? AND profileId = ?", new String[]{str, Long.toString(j)});
    }
}
