package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatCheckBox;

/* JADX INFO: loaded from: classes.dex */
public final class jr0 extends AppCompatCheckBox {
    public static final int j = b71.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[][] k = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList g;
    public boolean h;
    public boolean i;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.g == null) {
            int iE = bf1.e(q41.colorControlActivated, this);
            int iE2 = bf1.e(q41.colorSurface, this);
            int iE3 = bf1.e(q41.colorOnSurface, this);
            this.g = new ColorStateList(k, new int[]{bf1.p(1.0f, iE2, iE), bf1.p(0.54f, iE2, iE3), bf1.p(0.38f, iE2, iE3), bf1.p(0.38f, iE2, iE3)});
        }
        return this.g;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawableS;
        if (!this.i || !TextUtils.isEmpty(getText()) || (drawableS = qg0.s(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableS.getIntrinsicWidth()) / 2) * (qg0.y(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableS.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.i = z;
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.h = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
