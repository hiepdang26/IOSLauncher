package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public final class cq {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;
    public final PointF f;

    static {
        new Matrix();
    }

    public cq(int i, bq bqVar, float f, float f2) {
        float fCenterY;
        float f3;
        float f4;
        PointF pointF = new PointF();
        this.f = pointF;
        this.e = i;
        this.a = Math.max(bqVar.c, bqVar.g / bqVar.k);
        this.b = Math.max(bqVar.d, bqVar.h / bqVar.l);
        this.c = Math.min(bqVar.e, bqVar.i / bqVar.k);
        this.d = Math.min(bqVar.f, bqVar.j / bqVar.l);
        RectF rectFA = bqVar.a();
        float fCenterX = 0.0f;
        switch (uo.v(i)) {
            case 0:
                fCenterX = rectFA.left - f;
                fCenterY = rectFA.top;
                f4 = fCenterY - f2;
                break;
            case 1:
                fCenterX = rectFA.right - f;
                fCenterY = rectFA.top;
                f4 = fCenterY - f2;
                break;
            case 2:
                fCenterX = rectFA.left - f;
                fCenterY = rectFA.bottom;
                f4 = fCenterY - f2;
                break;
            case 3:
                fCenterX = rectFA.right - f;
                fCenterY = rectFA.bottom;
                f4 = fCenterY - f2;
                break;
            case 4:
                f3 = rectFA.left;
                fCenterX = f3 - f;
                f4 = 0.0f;
                break;
            case 5:
                fCenterY = rectFA.top;
                f4 = fCenterY - f2;
                break;
            case 6:
                f3 = rectFA.right;
                fCenterX = f3 - f;
                f4 = 0.0f;
                break;
            case 7:
                fCenterY = rectFA.bottom;
                f4 = fCenterY - f2;
                break;
            case 8:
                fCenterX = rectFA.centerX() - f;
                fCenterY = rectFA.centerY();
                f4 = fCenterY - f2;
                break;
            default:
                f4 = 0.0f;
                break;
        }
        pointF.x = fCenterX;
        pointF.y = f4;
    }

    public static void c(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 < f3) {
            rectF.offset(f3 - f2, 0.0f);
        }
        float f4 = rectF.right;
        float f5 = rectF2.right;
        if (f4 > f5) {
            rectF.offset(f5 - f4, 0.0f);
        }
    }

    public static void f(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        float f2 = rectF.top;
        float f3 = rectF2.top;
        if (f2 < f3) {
            rectF.offset(0.0f, f3 - f2);
        }
        float f4 = rectF.bottom;
        float f5 = rectF2.bottom;
        if (f4 > f5) {
            rectF.offset(0.0f, f5 - f4);
        }
    }

    public final void a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        PointF pointF = this.f;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            pointF.y -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.bottom;
        if (f > f5) {
            pointF.y -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.top;
        float f7 = f - f6;
        float f8 = this.b;
        if (f7 < f8) {
            f = f6 + f8;
        }
        float f9 = f - f6;
        float f10 = this.d;
        if (f9 > f10) {
            f = f6 + f10;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f11 = (f - f6) * f3;
            float f12 = this.a;
            if (f11 < f12) {
                f = Math.min(f5, (f12 / f3) + f6);
                f11 = (f - rectF.top) * f3;
            }
            float f13 = this.c;
            if (f11 > f13) {
                f = Math.min(rectF2.bottom, (f13 / f3) + rectF.top);
                f11 = (f - rectF.top) * f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.bottom, (rectF2.width() / f3) + rectF.top));
            } else {
                if (z) {
                    float f14 = rectF.right;
                    float f15 = f14 - f11;
                    float f16 = rectF2.left;
                    if (f15 < f16) {
                        f = Math.min(rectF2.bottom, ((f14 - f16) / f3) + rectF.top);
                        f11 = (f - rectF.top) * f3;
                    }
                }
                if (z2) {
                    float f17 = rectF.left;
                    float f18 = f11 + f17;
                    float f19 = rectF2.right;
                    if (f18 > f19) {
                        f = Math.min(f, Math.min(rectF2.bottom, ((f19 - f17) / f3) + rectF.top));
                    }
                }
            }
        }
        rectF.bottom = f;
    }

    public final void b(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        PointF pointF = this.f;
        if (f < 0.0f) {
            f /= 1.05f;
            pointF.x -= f / 1.1f;
        }
        float f4 = rectF2.left;
        if (f < f4) {
            pointF.x -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.right;
        float f6 = f5 - f;
        float f7 = this.a;
        if (f6 < f7) {
            f = f5 - f7;
        }
        float f8 = f5 - f;
        float f9 = this.c;
        if (f8 > f9) {
            f = f5 - f9;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f10 = (f5 - f) / f3;
            float f11 = this.b;
            if (f10 < f11) {
                f = Math.max(f4, f5 - (f11 * f3));
                f10 = (rectF.right - f) / f3;
            }
            float f12 = this.d;
            if (f10 > f12) {
                f = Math.max(rectF2.left, rectF.right - (f12 * f3));
                f10 = (rectF.right - f) / f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            } else {
                if (z) {
                    float f13 = rectF.bottom;
                    float f14 = f13 - f10;
                    float f15 = rectF2.top;
                    if (f14 < f15) {
                        f = Math.max(rectF2.left, rectF.right - ((f13 - f15) * f3));
                        f10 = (rectF.right - f) / f3;
                    }
                }
                if (z2) {
                    float f16 = rectF.top;
                    float f17 = f10 + f16;
                    float f18 = rectF2.bottom;
                    if (f17 > f18) {
                        f = Math.max(f, Math.max(rectF2.left, rectF.right - ((f18 - f16) * f3)));
                    }
                }
            }
        }
        rectF.left = f;
    }

    public final void d(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        PointF pointF = this.f;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            pointF.x -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.right;
        if (f > f5) {
            pointF.x -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.left;
        float f7 = f - f6;
        float f8 = this.a;
        if (f7 < f8) {
            f = f6 + f8;
        }
        float f9 = f - f6;
        float f10 = this.c;
        if (f9 > f10) {
            f = f6 + f10;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f11 = (f - f6) / f3;
            float f12 = this.b;
            if (f11 < f12) {
                f = Math.min(f5, (f12 * f3) + f6);
                f11 = (f - rectF.left) / f3;
            }
            float f13 = this.d;
            if (f11 > f13) {
                f = Math.min(rectF2.right, (f13 * f3) + rectF.left);
                f11 = (f - rectF.left) / f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.right, (rectF2.height() * f3) + rectF.left));
            } else {
                if (z) {
                    float f14 = rectF.bottom;
                    float f15 = f14 - f11;
                    float f16 = rectF2.top;
                    if (f15 < f16) {
                        f = Math.min(rectF2.right, ((f14 - f16) * f3) + rectF.left);
                        f11 = (f - rectF.left) / f3;
                    }
                }
                if (z2) {
                    float f17 = rectF.top;
                    float f18 = f11 + f17;
                    float f19 = rectF2.bottom;
                    if (f18 > f19) {
                        f = Math.min(f, Math.min(rectF2.right, ((f19 - f17) * f3) + rectF.left));
                    }
                }
            }
        }
        rectF.right = f;
    }

    public final void e(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        PointF pointF = this.f;
        if (f < 0.0f) {
            f /= 1.05f;
            pointF.y -= f / 1.1f;
        }
        float f4 = rectF2.top;
        if (f < f4) {
            pointF.y -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.bottom;
        float f6 = f5 - f;
        float f7 = this.b;
        if (f6 < f7) {
            f = f5 - f7;
        }
        float f8 = f5 - f;
        float f9 = this.d;
        if (f8 > f9) {
            f = f5 - f9;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f10 = (f5 - f) * f3;
            float f11 = this.a;
            if (f10 < f11) {
                f = Math.max(f4, f5 - (f11 / f3));
                f10 = (rectF.bottom - f) * f3;
            }
            float f12 = this.c;
            if (f10 > f12) {
                f = Math.max(rectF2.top, rectF.bottom - (f12 / f3));
                f10 = (rectF.bottom - f) * f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            } else {
                if (z) {
                    float f13 = rectF.right;
                    float f14 = f13 - f10;
                    float f15 = rectF2.left;
                    if (f14 < f15) {
                        f = Math.max(rectF2.top, rectF.bottom - ((f13 - f15) / f3));
                        f10 = (rectF.bottom - f) * f3;
                    }
                }
                if (z2) {
                    float f16 = rectF.left;
                    float f17 = f10 + f16;
                    float f18 = rectF2.right;
                    if (f17 > f18) {
                        f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((f18 - f16) / f3)));
                    }
                }
            }
        }
        rectF.top = f;
    }
}
