package defpackage;

import android.R;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class pr0 extends AppCompatRadioButton {
    public static final int i = b71.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] j = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList g;
    public boolean h;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.g == null) {
            int iE = bf1.e(q41.colorControlActivated, this);
            int iE2 = bf1.e(q41.colorOnSurface, this);
            int iE3 = bf1.e(q41.colorSurface, this);
            this.g = new ColorStateList(j, new int[]{bf1.p(1.0f, iE3, iE), bf1.p(0.54f, iE3, iE2), bf1.p(0.38f, iE3, iE2), bf1.p(0.38f, iE3, iE2)});
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

    public void setUseMaterialThemeColors(boolean z) {
        this.h = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
