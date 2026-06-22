package defpackage;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class ij1 {
    public static final int l;
    public static boolean m;
    public static Constructor n;
    public static TextDirectionHeuristic o;
    public CharSequence a;
    public final TextPaint b;
    public final int c;
    public int d;
    public boolean j;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;
    public int f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public float g = 1.0f;
    public int h = l;
    public boolean i = true;
    public TextUtils.TruncateAt k = null;

    static {
        l = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public ij1(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i;
        this.d = charSequence.length();
    }

    public final StaticLayout a() throws hj1 {
        char c;
        if (this.a == null) {
            this.a = "";
        }
        int iMax = Math.max(0, this.c);
        CharSequence charSequenceEllipsize = this.a;
        int i = this.f;
        TextPaint textPaint = this.b;
        if (i == 1) {
            c = '\t';
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.k);
        } else {
            c = '\t';
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.d);
        this.d = iMin;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.j && this.f == 1) {
                this.e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
            builderObtain.setAlignment(this.e);
            builderObtain.setIncludePad(this.i);
            builderObtain.setTextDirection(this.j ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.k;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.f);
            float f = this.g;
            if (f != 1.0f) {
                builderObtain.setLineSpacing(0.0f, f);
            }
            if (this.f > 1) {
                builderObtain.setHyphenationFrequency(this.h);
            }
            return builderObtain.build();
        }
        if (!m) {
            try {
                o = this.j && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class[] clsArr = new Class[13];
                clsArr[0] = CharSequence.class;
                Class cls = Integer.TYPE;
                clsArr[1] = cls;
                clsArr[2] = cls;
                clsArr[3] = TextPaint.class;
                clsArr[4] = cls;
                clsArr[5] = Layout.Alignment.class;
                clsArr[6] = TextDirectionHeuristic.class;
                Class cls2 = Float.TYPE;
                clsArr[7] = cls2;
                clsArr[8] = cls2;
                clsArr[c] = Boolean.TYPE;
                clsArr[10] = TextUtils.TruncateAt.class;
                clsArr[11] = cls;
                clsArr[12] = cls;
                Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(clsArr);
                n = declaredConstructor;
                declaredConstructor.setAccessible(true);
                m = true;
            } catch (Exception e) {
                throw new hj1(e);
            }
        }
        try {
            Constructor constructor = n;
            constructor.getClass();
            Integer numValueOf = Integer.valueOf(this.d);
            Integer numValueOf2 = Integer.valueOf(iMax);
            Layout.Alignment alignment = this.e;
            TextDirectionHeuristic textDirectionHeuristic = o;
            textDirectionHeuristic.getClass();
            Float fValueOf = Float.valueOf(1.0f);
            Float fValueOf2 = Float.valueOf(0.0f);
            Boolean boolValueOf = Boolean.valueOf(this.i);
            Integer numValueOf3 = Integer.valueOf(iMax);
            Integer numValueOf4 = Integer.valueOf(this.f);
            Object[] objArr = new Object[13];
            objArr[0] = charSequenceEllipsize;
            objArr[1] = 0;
            objArr[2] = numValueOf;
            objArr[3] = textPaint;
            objArr[4] = numValueOf2;
            objArr[5] = alignment;
            objArr[6] = textDirectionHeuristic;
            objArr[7] = fValueOf;
            objArr[8] = fValueOf2;
            objArr[c] = boolValueOf;
            objArr[10] = null;
            objArr[11] = numValueOf3;
            objArr[12] = numValueOf4;
            return (StaticLayout) constructor.newInstance(objArr);
        } catch (Exception e2) {
            throw new hj1(e2);
        }
    }
}
