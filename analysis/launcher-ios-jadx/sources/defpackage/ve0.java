package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public abstract class ve0 {
    public static final Path a = new Path();
    public static final Matrix b = new Matrix();

    static {
        new Paint(1);
    }

    public static void a(Canvas canvas, float f, float f2, Paint paint) {
        int iSave = canvas.save();
        float fMin = Math.min(f / 320.0f, f2 / 320.0f);
        float f3 = 320.0f * fMin;
        float f4 = 0;
        canvas.translate(((f - f3) / 2.0f) + f4, ((f2 - f3) / 2.0f) + f4);
        Matrix matrix = b;
        matrix.reset();
        matrix.setScale(fMin, fMin);
        Path path = a;
        path.reset();
        path.moveTo(110.1f, 0.0f);
        path.lineTo(210.0f, 0.0f);
        path.cubicTo(241.7f, 0.0f, 257.5f, 0.0f, 274.6f, 5.4f);
        path.cubicTo(293.2f, 12.2f, 307.9f, 26.8f, 314.7f, 45.5f);
        path.cubicTo(320.1f, 62.6f, 320.1f, 78.4f, 320.1f, 110.1f);
        path.lineTo(320.1f, 210.0f);
        path.cubicTo(320.1f, 241.7f, 320.1f, 257.5f, 314.7f, 274.6f);
        path.cubicTo(307.9f, 293.2f, 293.3f, 307.9f, 274.6f, 314.7f);
        path.cubicTo(257.5f, 320.1f, 241.7f, 320.1f, 210.0f, 320.1f);
        path.lineTo(110.1f, 320.1f);
        path.cubicTo(78.4f, 320.1f, 62.6f, 320.1f, 45.5f, 314.7f);
        path.cubicTo(26.9f, 307.9f, 12.2f, 293.3f, 5.4f, 274.6f);
        path.cubicTo(0.0f, 257.5f, 0.0f, 241.6f, 0.0f, 209.9f);
        path.lineTo(0.0f, 110.0f);
        path.cubicTo(0.0f, 78.3f, 0.0f, 62.5f, 5.4f, 45.4f);
        path.cubicTo(12.2f, 26.8f, 26.8f, 12.1f, 45.5f, 5.3f);
        path.cubicTo(62.5f, 0.0f, 78.4f, 0.0f, 110.1f, 0.0f);
        path.lineTo(110.1f, 0.0f);
        path.transform(matrix);
        canvas.drawPath(path, paint);
        canvas.restoreToCount(iSave);
    }

    public static void b(Canvas canvas, RectF rectF, float f, float f2, Paint paint) {
        canvas.save();
        canvas.translate(rectF.left, rectF.top);
        Matrix matrix = b;
        matrix.reset();
        matrix.setScale(f / 258.0f, f2 / 69.0f);
        Path path = a;
        path.reset();
        path.moveTo(223.48f, 0.17f);
        path.cubicTo(228.62f, 0.17f, 236.48f, 0.17f, 242.49f, 3.23f);
        path.cubicTo(247.77f, 5.92f, 252.06f, 10.21f, 254.75f, 15.49f);
        path.cubicTo(257.81f, 21.5f, 257.81f, 29.36f, 257.81f, 34.5f);
        path.cubicTo(257.81f, 39.64f, 257.81f, 47.5f, 254.75f, 53.51f);
        path.cubicTo(252.06f, 58.79f, 247.77f, 63.08f, 242.49f, 65.77f);
        path.cubicTo(236.48f, 68.83f, 228.62f, 68.83f, 223.48f, 68.83f);
        path.lineTo(34.52f, 68.83f);
        path.cubicTo(29.38f, 68.83f, 21.52f, 68.83f, 15.51f, 65.77f);
        path.cubicTo(10.23f, 63.08f, 5.94f, 58.79f, 3.25f, 53.51f);
        path.cubicTo(0.19f, 47.5f, 0.19f, 39.64f, 0.19f, 34.5f);
        path.cubicTo(0.19f, 29.36f, 0.19f, 21.5f, 3.25f, 15.49f);
        path.cubicTo(5.94f, 10.21f, 10.23f, 5.92f, 15.51f, 3.23f);
        path.cubicTo(21.52f, 0.17f, 29.38f, 0.17f, 34.52f, 0.17f);
        path.lineTo(223.48f, 0.17f);
        path.transform(matrix);
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    public static Path c(float f, float f2) {
        float fMin = Math.min(f / 320.0f, f2 / 320.0f);
        Matrix matrix = b;
        matrix.reset();
        matrix.setScale(fMin, fMin);
        Path path = a;
        path.reset();
        path.moveTo(110.1f, 0.0f);
        path.lineTo(210.0f, 0.0f);
        path.cubicTo(241.7f, 0.0f, 257.5f, 0.0f, 274.6f, 5.4f);
        path.cubicTo(293.2f, 12.2f, 307.9f, 26.8f, 314.7f, 45.5f);
        path.cubicTo(320.1f, 62.6f, 320.1f, 78.4f, 320.1f, 110.1f);
        path.lineTo(320.1f, 210.0f);
        path.cubicTo(320.1f, 241.7f, 320.1f, 257.5f, 314.7f, 274.6f);
        path.cubicTo(307.9f, 293.2f, 293.3f, 307.9f, 274.6f, 314.7f);
        path.cubicTo(257.5f, 320.1f, 241.7f, 320.1f, 210.0f, 320.1f);
        path.lineTo(110.1f, 320.1f);
        path.cubicTo(78.4f, 320.1f, 62.6f, 320.1f, 45.5f, 314.7f);
        path.cubicTo(26.9f, 307.9f, 12.2f, 293.3f, 5.4f, 274.6f);
        path.cubicTo(0.0f, 257.5f, 0.0f, 241.6f, 0.0f, 209.9f);
        path.lineTo(0.0f, 110.0f);
        path.cubicTo(0.0f, 78.3f, 0.0f, 62.5f, 5.4f, 45.4f);
        path.cubicTo(12.2f, 26.8f, 26.8f, 12.1f, 45.5f, 5.3f);
        path.cubicTo(62.5f, 0.0f, 78.4f, 0.0f, 110.1f, 0.0f);
        path.lineTo(110.1f, 0.0f);
        path.transform(matrix);
        return path;
    }
}
