package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class up1 extends ReplacementSpan {
    public final hz b;
    public final Paint.FontMetricsInt a = new Paint.FontMetricsInt();
    public float c = 1.0f;

    public up1(hz hzVar) {
        qg0.j(hzVar, "metadata cannot be null");
        this.b = hzVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        zy.a().getClass();
        hz hzVar = this.b;
        hz1 hz1Var = hzVar.b;
        Typeface typeface = (Typeface) hz1Var.d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) hz1Var.b, hzVar.a * 2, 2, f, i4, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        hz hzVar = this.b;
        this.c = fAbs / (hzVar.b().a(14) != 0 ? ((ByteBuffer) r8.j).getShort(r1 + r8.g) : (short) 0);
        bu0 bu0VarB = hzVar.b();
        int iA = bu0VarB.a(14);
        if (iA != 0) {
            ((ByteBuffer) bu0VarB.j).getShort(iA + bu0VarB.g);
        }
        short s = (short) ((hzVar.b().a(12) != 0 ? ((ByteBuffer) r5.j).getShort(r7 + r5.g) : (short) 0) * this.c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
