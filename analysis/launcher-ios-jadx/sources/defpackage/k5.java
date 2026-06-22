package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class k5 extends br1 implements Animatable {
    public final Context i;
    public final h5 j = new h5(this);
    public final i5 h = new i5();

    public k5(Context context) {
        this.i = context;
    }

    @Override // defpackage.br1, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        i5 i5Var = this.h;
        i5Var.a.draw(canvas);
        if (i5Var.b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getAlpha() : this.h.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.h.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getColorFilter() : this.h.a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.g == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new j5(this.g.getConstantState(), 0);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getIntrinsicHeight() : this.h.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getIntrinsicWidth() : this.h.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getOpacity() : this.h.a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0164, code lost:
    
        if (r8.b != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0166, code lost:
    
        r8.b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016d, code lost:
    
        r8.b.playTogether(r8.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0174, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r22, org.xmlpull.v1.XmlPullParser r23, android.util.AttributeSet r24, android.content.res.Resources.Theme r25) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k5.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.isAutoMirrored() : this.h.a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.g;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.h.b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.isStateful() : this.h.a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.h.a.setBounds(rect);
        }
    }

    @Override // defpackage.br1, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.g;
        return drawable != null ? drawable.setLevel(i) : this.h.a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.g;
        return drawable != null ? drawable.setState(iArr) : this.h.a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.h.a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.h.a.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.h.a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.g;
        if (drawable != null) {
            az1.I(drawable, i);
        } else {
            this.h.a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.g;
        if (drawable != null) {
            az1.J(drawable, colorStateList);
        } else {
            this.h.a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.g;
        if (drawable != null) {
            az1.K(drawable, mode);
        } else {
            this.h.a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.h.a.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.g;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        i5 i5Var = this.h;
        if (i5Var.b.isStarted()) {
            return;
        }
        i5Var.b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.g;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.h.b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
