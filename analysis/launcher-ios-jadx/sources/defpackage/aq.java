package defpackage;

import android.graphics.RectF;
import android.view.ScaleGestureDetector;
import com.luutinhit.launcherios.cropper.CropOverlayView;

/* JADX INFO: loaded from: classes.dex */
public final class aq extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public final /* synthetic */ CropOverlayView a;

    public aq(CropOverlayView cropOverlayView) {
        this.a = cropOverlayView;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        CropOverlayView cropOverlayView = this.a;
        RectF rectFA = cropOverlayView.i.a();
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
        float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
        float f = focusY - currentSpanY;
        float f2 = focusX - currentSpanX;
        float f3 = focusX + currentSpanX;
        float f4 = focusY + currentSpanY;
        if (f2 >= f3 || f > f4 || f2 < 0.0f) {
            return true;
        }
        bq bqVar = cropOverlayView.i;
        if (f3 > Math.min(bqVar.e, bqVar.i / bqVar.k) || f < 0.0f || f4 > Math.min(bqVar.f, bqVar.j / bqVar.l)) {
            return true;
        }
        rectFA.set(f2, f, f3, f4);
        bqVar.a.set(rectFA);
        cropOverlayView.invalidate();
        return true;
    }
}
