package defpackage;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n21 {
    public final TextPaint a;
    public final TextDirectionHeuristic b;
    public final int c;
    public final int d;

    public n21(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            ut.i(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
        }
        this.a = textPaint;
        this.b = textDirectionHeuristic;
        this.c = i;
        this.d = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r7.d != r8.d) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L5
            goto Lc3
        L5:
            boolean r1 = r8 instanceof defpackage.n21
            r2 = 0
            if (r1 != 0) goto Lc
            goto Lc4
        Lc:
            n21 r8 = (defpackage.n21) r8
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 < r3) goto L24
            int r3 = r8.c
            int r4 = r7.c
            if (r4 == r3) goto L1c
            goto Lb7
        L1c:
            int r3 = r7.d
            int r4 = r8.d
            if (r3 == r4) goto L24
            goto Lb7
        L24:
            android.text.TextPaint r3 = r7.a
            float r4 = r3.getTextSize()
            android.text.TextPaint r5 = r8.a
            float r5 = r5.getTextSize()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L36
            goto Lb7
        L36:
            float r4 = r3.getTextScaleX()
            android.text.TextPaint r5 = r8.a
            float r6 = r5.getTextScaleX()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L46
            goto Lb7
        L46:
            float r4 = r3.getTextSkewX()
            float r6 = r5.getTextSkewX()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L53
            goto Lb7
        L53:
            float r4 = r3.getLetterSpacing()
            float r6 = r5.getLetterSpacing()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L60
            goto Lb7
        L60:
            java.lang.String r4 = r3.getFontFeatureSettings()
            java.lang.String r6 = r5.getFontFeatureSettings()
            boolean r4 = android.text.TextUtils.equals(r4, r6)
            if (r4 != 0) goto L6f
            goto Lb7
        L6f:
            int r4 = r3.getFlags()
            int r6 = r5.getFlags()
            if (r4 == r6) goto L7a
            goto Lb7
        L7a:
            r4 = 24
            if (r1 < r4) goto L8d
            android.os.LocaleList r1 = defpackage.ep0.h(r3)
            android.os.LocaleList r4 = defpackage.ep0.h(r5)
            boolean r1 = defpackage.e.z(r1, r4)
            if (r1 != 0) goto L9c
            goto Lb7
        L8d:
            java.util.Locale r1 = r3.getTextLocale()
            java.util.Locale r4 = r5.getTextLocale()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L9c
            goto Lb7
        L9c:
            android.graphics.Typeface r1 = r3.getTypeface()
            if (r1 != 0) goto La9
            android.graphics.Typeface r1 = r5.getTypeface()
            if (r1 == 0) goto Lb9
            goto Lb7
        La9:
            android.graphics.Typeface r1 = r3.getTypeface()
            android.graphics.Typeface r3 = r5.getTypeface()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto Lb9
        Lb7:
            r1 = 0
            goto Lba
        Lb9:
            r1 = 1
        Lba:
            if (r1 != 0) goto Lbd
            goto Lc4
        Lbd:
            android.text.TextDirectionHeuristic r1 = r7.b
            android.text.TextDirectionHeuristic r8 = r8.b
            if (r1 != r8) goto Lc4
        Lc3:
            return r0
        Lc4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n21.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        TextDirectionHeuristic textDirectionHeuristic = this.b;
        int i = Build.VERSION.SDK_INT;
        int i2 = this.d;
        int i3 = this.c;
        TextPaint textPaint = this.a;
        return i >= 24 ? Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i3), Integer.valueOf(i2)) : Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        int i = Build.VERSION.SDK_INT;
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        if (i >= 24) {
            sb.append(", textLocale=" + textPaint.getTextLocales());
        } else {
            sb.append(", textLocale=" + textPaint.getTextLocale());
        }
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i >= 26) {
            sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        }
        sb.append(", textDir=" + this.b);
        sb.append(", breakStrategy=" + this.c);
        sb.append(", hyphenationFrequency=" + this.d);
        sb.append("}");
        return sb.toString();
    }

    public n21(PrecomputedText.Params params) {
        this.a = params.getTextPaint();
        this.b = params.getTextDirection();
        this.c = params.getBreakStrategy();
        this.d = params.getHyphenationFrequency();
    }
}
