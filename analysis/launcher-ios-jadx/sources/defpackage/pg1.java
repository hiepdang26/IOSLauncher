package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.util.TextViewCustomFont;

/* JADX INFO: loaded from: classes.dex */
public final class pg1 extends LinearLayout {
    public final AppCompatImageView g;
    public final TextViewCustomFont h;
    public final boolean i;
    public boolean j;

    public pg1(Context context, boolean z, boolean z2) {
        super(context);
        this.i = z2;
        this.j = z;
        setClickable(true);
        setFocusable(true);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(l51.item_button_state);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.g = appCompatImageView;
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.shortcut_info_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(e51.shortcut_info_item_margin);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        addView(appCompatImageView, layoutParams);
        TextViewCustomFont textViewCustomFont = new TextViewCustomFont(context);
        this.h = textViewCustomFont;
        textViewCustomFont.setLines(1);
        textViewCustomFont.setGravity(8388629);
        textViewCustomFont.setEllipsize(TextUtils.TruncateAt.END);
        textViewCustomFont.setTextAlignment(3);
        textViewCustomFont.setTextColor(z2 ? -65536 : this.j ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.leftMargin = dimensionPixelSize2;
        addView(textViewCustomFont, layoutParams2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        this.h.setTextAlignment(i == 1 ? 2 : 3);
    }

    public void setDarkMode(boolean z) {
        this.j = z;
        TextViewCustomFont textViewCustomFont = this.h;
        boolean z2 = this.i;
        int i = -16777216;
        textViewCustomFont.setTextColor(z2 ? -65536 : z ? -1 : -16777216);
        AppCompatImageView appCompatImageView = this.g;
        if (z2) {
            i = -65536;
        } else if (this.j) {
            i = -1;
        }
        az1.F(appCompatImageView, ColorStateList.valueOf(i));
    }

    public void setIcon(int i) {
        AppCompatImageView appCompatImageView = this.g;
        appCompatImageView.setImageResource(i);
        az1.F(appCompatImageView, ColorStateList.valueOf(this.i ? -65536 : this.j ? -1 : -16777216));
    }

    public void setText(int i) {
        this.h.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.h.setText(charSequence);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            this.g.setImageDrawable(drawable);
        }
    }
}
