package androidx.constraintlayout.motion.widget;

import android.view.View;
import defpackage.bn;
import defpackage.fy;
import defpackage.hm;
import defpackage.uo;
import defpackage.zm;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    LinkedHashMap<String, hm> mAttributes;
    float mHeight;
    fy mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPosition;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;
    int mDrawPath = 0;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;

    public MotionPaths() {
        int i = Key.UNSET;
        this.mPathMotionArc = i;
        this.mAnimateRelativeTo = i;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    private static float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f6 - f4) * f2) + ((f5 - f3) * f) + f4;
    }

    public void applyParameters(zm zmVar) {
        int iV;
        this.mKeyFrameEasing = fy.c(zmVar.d.d);
        bn bnVar = zmVar.d;
        this.mPathMotionArc = bnVar.e;
        this.mAnimateRelativeTo = bnVar.b;
        this.mPathRotate = bnVar.h;
        this.mDrawPath = bnVar.f;
        this.mAnimateCircleAngleTo = bnVar.c;
        this.mProgress = zmVar.c.e;
        this.mRelativeAngle = zmVar.e.C;
        for (String str : zmVar.g.keySet()) {
            hm hmVar = (hm) zmVar.g.get(str);
            if (hmVar != null && (iV = uo.v(hmVar.c)) != 4 && iV != 5 && iV != 7) {
                this.mAttributes.put(str, hmVar);
            }
        }
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean zDiff = diff(this.mX, motionPaths.mX);
        boolean zDiff2 = diff(this.mY, motionPaths.mY);
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        boolean z2 = zDiff | zDiff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = fArr[r2];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mWidth;
        float f2 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f2 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                fSin = f3;
            } else if (i3 == 2) {
                fCos = f3;
            } else if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            double d2 = f4;
            double d3 = fSin;
            double d4 = fCos;
            fSin = (float) (((Math.sin(d4) * d3) + d2) - ((double) (f / 2.0f)));
            fCos = (float) ((((double) f5) - (Math.cos(d4) * d3)) - ((double) (f2 / 2.0f)));
        }
        fArr[i] = (f / 2.0f) + fSin + 0.0f;
        fArr[i + 1] = (f2 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f2 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                fSin = f3;
            } else if (i3 == 2) {
                fCos = f3;
            } else if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            double d2 = f4;
            double d3 = fSin;
            double d4 = fCos;
            fSin = (float) (((Math.sin(d4) * d3) + d2) - ((double) (f / 2.0f)));
            fCos = (float) ((((double) f5) - (Math.cos(d4) * d3)) - ((double) (f2 / 2.0f)));
        }
        fArr[i] = (f / 2.0f) + fSin + 0.0f;
        fArr[i + 1] = (f2 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        hm hmVar = this.mAttributes.get(str);
        int i2 = 0;
        if (hmVar == null) {
            return 0;
        }
        if (hmVar.c() == 1) {
            dArr[i] = hmVar.a();
            return 1;
        }
        int iC = hmVar.c();
        hmVar.b(new float[iC]);
        while (i2 < iC) {
            dArr[i] = r2[i2];
            i2++;
            i++;
        }
        return iC;
    }

    public int getCustomDataCount(String str) {
        hm hmVar = this.mAttributes.get(str);
        if (hmVar == null) {
            return 0;
        }
        return hmVar.c();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mX;
        float fCos = this.mY;
        float f2 = this.mWidth;
        float f3 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f4 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f4;
            } else if (i3 == 2) {
                fCos = f4;
            } else if (i3 == 3) {
                f2 = f4;
            } else if (i3 == 4) {
                f3 = f4;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = f;
            double d2 = fCos;
            float fSin = (float) (((Math.sin(d2) * d) + ((double) centerX)) - ((double) (f2 / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d2) * d)) - ((double) (f3 / 2.0f)));
            f = fSin;
        }
        float f5 = f2 + f;
        float f6 = f3 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = fCos + 0.0f;
        fArr[i + 2] = f5 + 0.0f;
        fArr[i + 3] = fCos + 0.0f;
        fArr[i + 4] = f5 + 0.0f;
        fArr[i + 5] = f6 + 0.0f;
        fArr[i + 6] = f + 0.0f;
        fArr[i + 7] = f6 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.mAttributes.containsKey(str);
    }

    public void initAxis(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth;
        float f5 = motionPaths.mWidth;
        float f6 = f4 - f5;
        float f7 = motionPaths2.mHeight;
        float f8 = motionPaths.mHeight;
        float f9 = f7 - f8;
        this.mPosition = this.mTime;
        float f10 = (f5 / 2.0f) + motionPaths.mX;
        float f11 = (f8 / 2.0f) + motionPaths.mY;
        float f12 = f;
        float f13 = (f4 / 2.0f) + motionPaths2.mX;
        float f14 = (f7 / 2.0f) + motionPaths2.mY;
        if (f10 > f13) {
            f10 = f13;
            f13 = f10;
        }
        if (f11 <= f14) {
            f11 = f14;
            f14 = f11;
        }
        float f15 = f13 - f10;
        float f16 = f11 - f14;
        float f17 = (f6 * f2) / 2.0f;
        this.mX = (int) (((f15 * f12) + r13) - f17);
        float f18 = (f9 * f3) / 2.0f;
        this.mY = (int) (((f16 * f12) + r14) - f18);
        this.mWidth = (int) (f5 + r9);
        this.mHeight = (int) (f8 + r12);
        float f19 = Float.isNaN(keyPosition.mPercentX) ? f12 : keyPosition.mPercentX;
        float f20 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f12 = keyPosition.mPercentY;
        }
        float f21 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f21 * f16) + ((f19 * f15) + motionPaths.mX)) - f17);
        this.mY = (int) (((f16 * f12) + ((f15 * f20) + motionPaths.mY)) - f18);
        this.mKeyFrameEasing = fy.c(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth;
        float f5 = motionPaths.mWidth;
        float f6 = f4 - f5;
        float f7 = motionPaths2.mHeight;
        float f8 = motionPaths.mHeight;
        float f9 = f7 - f8;
        this.mPosition = this.mTime;
        float f10 = motionPaths.mX;
        float f11 = motionPaths.mY;
        float f12 = f;
        float f13 = ((f4 / 2.0f) + motionPaths2.mX) - ((f5 / 2.0f) + f10);
        float f14 = ((f7 / 2.0f) + motionPaths2.mY) - ((f8 / 2.0f) + f11);
        float f15 = (f6 * f2) / 2.0f;
        this.mX = (int) (((f13 * f12) + f10) - f15);
        float f16 = (f9 * f3) / 2.0f;
        this.mY = (int) (((f14 * f12) + f11) - f16);
        this.mWidth = (int) (f5 + r9);
        this.mHeight = (int) (f8 + r12);
        float f17 = Float.isNaN(keyPosition.mPercentX) ? f12 : keyPosition.mPercentX;
        float f18 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f12 = keyPosition.mPercentY;
        }
        float f19 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f19 * f14) + ((f17 * f13) + motionPaths.mX)) - f15);
        this.mY = (int) (((f14 * f12) + ((f13 * f18) + motionPaths.mY)) - f16);
        this.mKeyFrameEasing = fy.c(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth - motionPaths.mWidth;
        float f5 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f = keyPosition.mPercentX;
        }
        float f6 = motionPaths.mX;
        float f7 = motionPaths.mWidth;
        float f8 = motionPaths.mY;
        float f9 = motionPaths.mHeight;
        float f10 = f;
        float f11 = ((motionPaths2.mWidth / 2.0f) + motionPaths2.mX) - ((f7 / 2.0f) + f6);
        float f12 = ((motionPaths2.mHeight / 2.0f) + motionPaths2.mY) - ((f9 / 2.0f) + f8);
        float f13 = f11 * f10;
        float f14 = (f4 * f2) / 2.0f;
        this.mX = (int) ((f6 + f13) - f14);
        float f15 = f12 * f10;
        float f16 = (f5 * f3) / 2.0f;
        this.mY = (int) ((f8 + f15) - f16);
        this.mWidth = (int) (f7 + r7);
        this.mHeight = (int) (f9 + r8);
        float f17 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f18 = (int) ((motionPaths.mX + f13) - f14);
        float f19 = (int) ((motionPaths.mY + f15) - f16);
        this.mX = f18 + ((-f12) * f17);
        this.mY = f19 + (f11 * f17);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = fy.c(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPolar(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fS;
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth;
        float f5 = motionPaths.mWidth;
        float f6 = motionPaths2.mHeight;
        float f7 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (((f4 - f5) * f2) + f5);
        this.mHeight = (int) (((f6 - f7) * f3) + f7);
        if (keyPosition.mPositionType != 2) {
            float f8 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
            float f9 = motionPaths2.mX;
            float f10 = motionPaths.mX;
            this.mX = uo.s(f9, f10, f8, f10);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f = keyPosition.mPercentY;
            }
            float f11 = motionPaths2.mY;
            float f12 = motionPaths.mY;
            this.mY = uo.s(f11, f12, f, f12);
        } else {
            if (Float.isNaN(keyPosition.mPercentX)) {
                float f13 = motionPaths2.mX;
                float f14 = motionPaths.mX;
                fMin = uo.s(f13, f14, f, f14);
            } else {
                fMin = Math.min(f3, f2) * keyPosition.mPercentX;
            }
            this.mX = fMin;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f15 = motionPaths2.mY;
                float f16 = motionPaths.mY;
                fS = uo.s(f15, f16, f, f16);
            } else {
                fS = keyPosition.mPercentY;
            }
            this.mY = fS;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = fy.c(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.mWidth;
        float f5 = f4 - motionPaths.mWidth;
        float f6 = motionPaths2.mHeight;
        float f7 = f6 - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f8 = motionPaths.mX;
        float f9 = motionPaths.mY;
        float f10 = (f4 / 2.0f) + motionPaths2.mX;
        float f11 = (f6 / 2.0f) + motionPaths2.mY;
        float f12 = f5 * f2;
        this.mX = (int) ((((f10 - ((r8 / 2.0f) + f8)) * f) + f8) - (f12 / 2.0f));
        float f13 = f7 * f3;
        this.mY = (int) ((((f11 - ((r11 / 2.0f) + f9)) * f) + f9) - (f13 / 2.0f));
        this.mWidth = (int) (r8 + f12);
        this.mHeight = (int) (r11 + f13);
        this.mMode = 2;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.mX = (int) (keyPosition.mPercentX * (i - ((int) this.mWidth)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.mY = (int) (keyPosition.mPercentY * (i2 - ((int) this.mHeight)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = fy.c(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.mX = f;
        this.mY = f2;
        this.mWidth = f3;
        this.mHeight = f4;
    }

    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (((f4 * 1.0f) + f8) * f) + ((1.0f - f) * f8) + 0.0f;
        fArr[1] = (((f6 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z) {
        float f2;
        float fSin = this.mX;
        float fCos = this.mY;
        float f3 = this.mWidth;
        float f4 = this.mHeight;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            double[] dArr4 = this.mTempValue;
            int i3 = iArr[i2];
            dArr4[i3] = dArr[i2];
            this.mTempDelta[i3] = dArr2[i2];
        }
        float f5 = Float.NaN;
        int i4 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i4 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                f2 = f5;
            } else {
                double d = dArr3 != null ? dArr3[i4] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d = this.mTempValue[i4] + d;
                }
                f2 = f5;
                float f10 = (float) d;
                float f11 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f5 = f2;
                    f6 = f11;
                    fSin = f10;
                } else if (i4 == 2) {
                    f5 = f2;
                    f7 = f11;
                    fCos = f10;
                } else if (i4 == 3) {
                    f5 = f2;
                    f8 = f11;
                    f3 = f10;
                } else if (i4 == 4) {
                    f5 = f2;
                    f9 = f11;
                    f4 = f10;
                } else if (i4 == 5) {
                    f5 = f10;
                }
                i4++;
            }
            f5 = f2;
            i4++;
        }
        float f12 = f5;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(f, fArr, fArr2);
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr2[0];
            float f16 = fArr2[1];
            double d2 = f13;
            double d3 = fSin;
            double d4 = fCos;
            fSin = (float) (((Math.sin(d4) * d3) + d2) - ((double) (f3 / 2.0f)));
            fCos = (float) ((((double) f14) - (Math.cos(d4) * d3)) - ((double) (f4 / 2.0f)));
            double d5 = f15;
            double d6 = f6;
            double dSin = (Math.sin(d4) * d6) + d5;
            double dCos = Math.cos(d4) * d3;
            double d7 = f7;
            float f17 = (float) ((dCos * d7) + dSin);
            float fSin2 = (float) ((Math.sin(d4) * d3 * d7) + (((double) f16) - (Math.cos(d4) * d6)));
            if (dArr2.length >= 2) {
                dArr2[0] = f17;
                dArr2[1] = fSin2;
            }
            if (!Float.isNaN(f12)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2(fSin2, f17)) + ((double) f12)));
            }
        } else if (!Float.isNaN(f12)) {
            view.setRotation(f12 + ((float) Math.toDegrees(Math.atan2((f9 / 2.0f) + f7, (f8 / 2.0f) + f6))) + 0.0f);
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(fSin, fCos, f3 + fSin, f4 + fCos);
            return;
        }
        float f18 = fSin + 0.5f;
        int i5 = (int) f18;
        float f19 = fCos + 0.5f;
        int i6 = (int) f19;
        int i7 = (int) (f18 + f3);
        int i8 = (int) (f19 + f4);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if (i9 != view.getMeasuredWidth() || i10 != view.getMeasuredHeight() || z) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        }
        view.layout(i5, i6, i7, i8);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d = (((this.mWidth / 2.0f) + this.mX) - motionPaths.mX) - (motionPaths.mWidth / 2.0f);
        double d2 = (((this.mHeight / 2.0f) + this.mY) - motionPaths.mY) - (motionPaths.mHeight / 2.0f);
        this.mRelativeToController = motionController;
        this.mX = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i3 = Key.UNSET;
        this.mPathMotionArc = i3;
        this.mAnimateRelativeTo = i3;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i, i2, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i4 = keyPosition.mPositionType;
        if (i4 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
            return;
        }
        if (i4 == 2) {
            initScreen(i, i2, keyPosition, motionPaths, motionPaths2);
        } else if (i4 != 3) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initAxis(keyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float fSin = this.mX;
        float fCos = this.mY;
        float f2 = this.mWidth;
        float f3 = this.mHeight;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f8 = (float) dArr[i];
            float f9 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                fSin = f8;
                f4 = f9;
            } else if (i2 == 2) {
                fCos = f8;
                f6 = f9;
            } else if (i2 == 3) {
                f2 = f8;
                f5 = f9;
            } else if (i2 == 4) {
                f3 = f8;
                f7 = f9;
            }
        }
        float f10 = (f5 / 2.0f) + f4;
        float fSin2 = (f7 / 2.0f) + f6;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d, fArr3, fArr4);
            float f11 = fArr3[0];
            float f12 = fArr3[1];
            float f13 = fArr4[0];
            float f14 = fArr4[1];
            f = 2.0f;
            double d2 = fSin;
            double d3 = fCos;
            fSin = (float) (((Math.sin(d3) * d2) + ((double) f11)) - ((double) (f2 / 2.0f)));
            fCos = (float) ((((double) f12) - (Math.cos(d3) * d2)) - ((double) (f3 / 2.0f)));
            double d4 = f4;
            double dSin = (Math.sin(d3) * d4) + ((double) f13);
            double d5 = f6;
            float fCos2 = (float) ((Math.cos(d3) * d5) + dSin);
            fSin2 = (float) ((Math.sin(d3) * d5) + (((double) f14) - (Math.cos(d3) * d4)));
            f10 = fCos2;
        } else {
            f = 2.0f;
        }
        fArr[0] = (f2 / f) + fSin + 0.0f;
        fArr[1] = (f3 / f) + fCos + 0.0f;
        fArr2[0] = f10;
        fArr2[1] = fSin2;
    }
}
