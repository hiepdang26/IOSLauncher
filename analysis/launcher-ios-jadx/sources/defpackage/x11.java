package defpackage;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.FastBitmapDrawable;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class x11 extends pk0 implements View.OnClickListener {
    public static Resources.Theme Q;
    public final Rect C;
    public View D;
    public View.OnClickListener E;
    public final qk0 F;
    public final int G;
    public final Intent H;
    public final boolean I;
    public final t J;
    public Bitmap K;
    public Drawable L;
    public Drawable M;
    public boolean N;
    public final TextPaint O;
    public StaticLayout P;

    public x11(t tVar, qk0 qk0Var, boolean z) {
        super(tVar);
        this.C = new Rect();
        this.J = tVar;
        this.F = qk0Var;
        this.G = qk0Var.z;
        this.H = new Intent().setComponent(qk0Var.y);
        this.I = z;
        TextPaint textPaint = new TextPaint();
        this.O = textPaint;
        textPaint.setColor(-1);
        textPaint.setTextSize(TypedValue.applyDimension(0, tVar.getDeviceProfile().E, getResources().getDisplayMetrics()));
        setBackgroundResource(l51.quantum_panel_dark);
        setWillNotDraw(false);
        if (ar1.m) {
            setElevation(getResources().getDimension(e51.pending_widget_elevation));
        }
    }

    @Override // defpackage.pk0
    public final boolean b() {
        return this.G != this.F.z;
    }

    public final void d() {
        Drawable drawable = this.L;
        if (drawable != null) {
            drawable.setLevel(Math.max(this.F.A, 0));
        }
    }

    public final void e(oe0 oe0Var) throws Throwable {
        qk0 qk0Var = this.F;
        Bitmap bitmapP = oe0Var.p(this.H, qk0Var.w);
        if (this.K == bitmapP) {
            return;
        }
        this.K = bitmapP;
        Drawable drawable = this.L;
        if (drawable != null) {
            drawable.setCallback(null);
            this.L = null;
        }
        Bitmap bitmap = this.K;
        if (bitmap != null) {
            boolean z = this.I;
            t tVar = this.J;
            if (z) {
                FastBitmapDrawable fastBitmapDrawableCreateIconDrawable = tVar.createIconDrawable(bitmap);
                fastBitmapDrawableCreateIconDrawable.f(o20.DISABLED);
                this.L = fastBitmapDrawableCreateIconDrawable;
                this.M = null;
            } else {
                int i = qk0Var.z;
                if ((i & 2) != 0 || (i & 4) == 0) {
                    if (Q == null) {
                        Resources.Theme themeNewTheme = getResources().newTheme();
                        Q = themeNewTheme;
                        themeNewTheme.applyStyle(c71.PreloadIcon, true);
                    }
                    i31 i31Var = new i31(tVar.createIconDrawable(this.K), Q);
                    this.L = i31Var;
                    i31Var.setCallback(this);
                    this.M = null;
                    d();
                } else {
                    this.L = new FastBitmapDrawable(tVar, this.K);
                    this.M = getResources().getDrawable(l51.ic_setting).mutate();
                    float[] fArr = new float[3];
                    Color.colorToHSV(ar1.l(this.K), fArr);
                    fArr[1] = Math.min(fArr[1], 0.7f);
                    fArr[2] = 1.0f;
                    this.M.setColorFilter(Color.HSVToColor(fArr), PorterDuff.Mode.SRC_IN);
                }
            }
            this.N = true;
        }
    }

    @Override // android.appwidget.AppWidgetHostView
    public View getDefaultView() {
        if (this.D == null) {
            View viewInflate = this.g.inflate(m61.appwidget_not_ready, (ViewGroup) this, false);
            this.D = viewInflate;
            viewInflate.setOnClickListener(this);
            d();
        }
        return this.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.E;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.L == null) {
            return;
        }
        boolean z = this.N;
        Rect rect = this.C;
        if (z) {
            xu deviceProfile = this.J.getDeviceProfile();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e51.pending_widget_min_padding);
            int width = (getWidth() - paddingLeft) - paddingRight;
            int i = dimensionPixelSize * 2;
            int i2 = width - i;
            int height = ((getHeight() - paddingTop) - paddingBottom) - i;
            if (this.M == null) {
                Drawable drawable = this.L;
                int i3 = drawable instanceof i31 ? ((i31) drawable).f : 0;
                int iMin = Math.min((i3 * 2) + deviceProfile.D, Math.min(i2, height));
                rect.set(0, 0, iMin, iMin);
                rect.inset(i3, i3);
                rect.offsetTo((getWidth() - rect.width()) / 2, (getHeight() - rect.height()) / 2);
                this.L.setBounds(rect);
            } else {
                float fMax = Math.max(0, Math.min(i2, height));
                float f = fMax * 1.8f;
                float fMax2 = Math.max(i2, height);
                if (f > fMax2) {
                    fMax = fMax2 / 1.8f;
                }
                int iMin2 = (int) Math.min(fMax, deviceProfile.D);
                int height2 = (getHeight() - iMin2) / 2;
                this.P = null;
                if (i2 > 0) {
                    StaticLayout staticLayout = new StaticLayout(getResources().getText(w61.gadget_setup_text), this.O, i2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                    this.P = staticLayout;
                    int height3 = staticLayout.getHeight();
                    if ((iMin2 * 1.8f) + height3 + deviceProfile.G < height) {
                        height2 = (((getHeight() - height3) - deviceProfile.G) - iMin2) / 2;
                    } else {
                        this.P = null;
                    }
                }
                int i4 = height2;
                rect.set(0, 0, iMin2, iMin2);
                rect.offset((getWidth() - iMin2) / 2, i4);
                this.L.setBounds(rect);
                int i5 = paddingLeft + dimensionPixelSize;
                rect.left = i5;
                int i6 = (int) (iMin2 * 0.4f);
                rect.right = i5 + i6;
                int i7 = paddingTop + dimensionPixelSize;
                rect.top = i7;
                rect.bottom = i7 + i6;
                this.M.setBounds(rect);
                if (this.P != null) {
                    rect.left = i5;
                    rect.top = this.L.getBounds().bottom + deviceProfile.G;
                }
            }
            this.N = false;
        }
        this.L.draw(canvas);
        Drawable drawable2 = this.M;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (this.P != null) {
            canvas.save();
            canvas.translate(rect.left, rect.top);
            this.P.draw(canvas);
            canvas.restore();
        }
    }

    @Override // defpackage.pk0, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.N = true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.E = onClickListener;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == this.L || super.verifyDrawable(drawable);
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void updateAppWidgetSize(Bundle bundle, int i, int i2, int i3, int i4) {
    }
}
