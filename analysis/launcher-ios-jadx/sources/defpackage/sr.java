package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class sr extends rr0 {
    public final RectF D;

    public sr(wf1 wf1Var) {
        super(wf1Var == null ? new wf1() : wf1Var);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.D = new RectF();
    }

    @Override // defpackage.rr0
    public final void f(Canvas canvas) {
        RectF rectF = this.D;
        if (rectF.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(rectF);
        } else {
            canvas.clipRect(rectF, Region.Op.DIFFERENCE);
        }
        super.f(canvas);
        canvas.restore();
    }

    public final void o(float f, float f2, float f3, float f4) {
        RectF rectF = this.D;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }
}
