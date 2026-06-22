package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.View;
import defpackage.bn;
import defpackage.cn;
import defpackage.dn;
import defpackage.en;
import defpackage.eu1;
import defpackage.fy;
import defpackage.hm;
import defpackage.hu1;
import defpackage.uo;
import defpackage.zm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    private float mHeight;
    private fy mKeyFrameEasing;
    private float mPosition;
    int mVisibility;
    private float mWidth;
    private float mX;
    private float mY;
    public float rotationY = 0.0f;
    int mVisibilityMode = 0;
    LinkedHashMap<String, hm> mAttributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];
    private float mAlpha = 1.0f;
    private boolean mApplyElevation = false;
    private float mElevation = 0.0f;
    private float mRotation = 0.0f;
    private float mRotationX = 0.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTranslationX = 0.0f;
    private float mTranslationY = 0.0f;
    private float mTranslationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    public void addValues(HashMap<String, hu1> map, int i) {
        for (String str : map.keySet()) {
            hu1 hu1Var = map.get(str);
            if (hu1Var != null) {
                str.getClass();
                switch (str) {
                    case "rotationX":
                        hu1Var.b(Float.isNaN(this.mRotationX) ? 0.0f : this.mRotationX, i);
                        break;
                    case "rotationY":
                        hu1Var.b(Float.isNaN(this.rotationY) ? 0.0f : this.rotationY, i);
                        break;
                    case "translationX":
                        hu1Var.b(Float.isNaN(this.mTranslationX) ? 0.0f : this.mTranslationX, i);
                        break;
                    case "translationY":
                        hu1Var.b(Float.isNaN(this.mTranslationY) ? 0.0f : this.mTranslationY, i);
                        break;
                    case "translationZ":
                        hu1Var.b(Float.isNaN(this.mTranslationZ) ? 0.0f : this.mTranslationZ, i);
                        break;
                    case "progress":
                        hu1Var.b(Float.isNaN(this.mProgress) ? 0.0f : this.mProgress, i);
                        break;
                    case "scaleX":
                        hu1Var.b(Float.isNaN(this.mScaleX) ? 1.0f : this.mScaleX, i);
                        break;
                    case "scaleY":
                        hu1Var.b(Float.isNaN(this.mScaleY) ? 1.0f : this.mScaleY, i);
                        break;
                    case "transformPivotX":
                        hu1Var.b(Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX, i);
                        break;
                    case "transformPivotY":
                        hu1Var.b(Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY, i);
                        break;
                    case "rotation":
                        hu1Var.b(Float.isNaN(this.mRotation) ? 0.0f : this.mRotation, i);
                        break;
                    case "elevation":
                        hu1Var.b(Float.isNaN(this.mElevation) ? 0.0f : this.mElevation, i);
                        break;
                    case "transitionPathRotate":
                        hu1Var.b(Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate, i);
                        break;
                    case "alpha":
                        hu1Var.b(Float.isNaN(this.mAlpha) ? 1.0f : this.mAlpha, i);
                        break;
                    default:
                        if (!str.startsWith(Key.CUSTOM)) {
                            break;
                        } else {
                            String str2 = str.split(",")[1];
                            if (this.mAttributes.containsKey(str2)) {
                                hm hmVar = this.mAttributes.get(str2);
                                if (hu1Var instanceof eu1) {
                                    ((eu1) hu1Var).f.append(i, hmVar);
                                } else {
                                    hmVar.a();
                                    hu1Var.toString();
                                }
                            }
                            break;
                        }
                        break;
                }
            }
        }
    }

    public void applyParameters(View view) {
        this.mVisibility = view.getVisibility();
        this.mAlpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.mApplyElevation = false;
        this.mElevation = view.getElevation();
        this.mRotation = view.getRotation();
        this.mRotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.mScaleX = view.getScaleX();
        this.mScaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.mTranslationX = view.getTranslationX();
        this.mTranslationY = view.getTranslationY();
        this.mTranslationZ = view.getTranslationZ();
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.mAlpha, motionConstrainedPoint.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (diff(this.mElevation, motionConstrainedPoint.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        int i = this.mVisibility;
        int i2 = motionConstrainedPoint.mVisibility;
        if (i != i2 && this.mVisibilityMode == 0 && (i == 0 || i2 == 0)) {
            hashSet.add(Key.ALPHA);
        }
        if (diff(this.mRotation, motionConstrainedPoint.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add(Key.PROGRESS);
        }
        if (diff(this.mRotationX, motionConstrainedPoint.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (diff(this.mScaleX, motionConstrainedPoint.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (diff(this.mScaleY, motionConstrainedPoint.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (diff(this.mTranslationX, motionConstrainedPoint.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (diff(this.mTranslationY, motionConstrainedPoint.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (diff(this.mTranslationZ, motionConstrainedPoint.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        int i = 0;
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mAlpha, this.mElevation, this.mRotation, this.mRotationX, this.rotationY, this.mScaleX, this.mScaleY, this.mPivotX, this.mPivotY, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mPathRotate};
        for (int i2 : iArr) {
            if (i2 < 18) {
                dArr[i] = fArr[r4];
                i++;
            }
        }
    }

    public int getCustomData(String str, double[] dArr, int i) {
        hm hmVar = this.mAttributes.get(str);
        if (hmVar.c() == 1) {
            dArr[i] = hmVar.a();
            return 1;
        }
        int iC = hmVar.c();
        hmVar.b(new float[iC]);
        int i2 = 0;
        while (i2 < iC) {
            dArr[i] = r1[i2];
            i2++;
            i++;
        }
        return iC;
    }

    public int getCustomDataCount(String str) {
        return this.mAttributes.get(str).c();
    }

    public boolean hasCustomData(String str) {
        return this.mAttributes.containsKey(str);
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.mX = f;
        this.mY = f2;
        this.mWidth = f3;
        this.mHeight = f4;
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.mPosition, motionConstrainedPoint.mPosition);
    }

    public void setState(Rect rect, View view, int i, float f) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(view);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i == 1) {
            this.mRotation = f - 90.0f;
        } else {
            if (i != 2) {
                return;
            }
            this.mRotation = f + 90.0f;
        }
    }

    public void setState(Rect rect, en enVar, int i, int i2) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(enVar.k(i2));
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f = this.mRotation + 90.0f;
            this.mRotation = f;
            if (f > 180.0f) {
                this.mRotation = f - 360.0f;
                return;
            }
            return;
        }
        this.mRotation -= 90.0f;
    }

    public void applyParameters(zm zmVar) {
        cn cnVar = zmVar.c;
        int i = cnVar.c;
        this.mVisibilityMode = i;
        int i2 = cnVar.b;
        this.mVisibility = i2;
        this.mAlpha = (i2 == 0 || i != 0) ? cnVar.d : 0.0f;
        dn dnVar = zmVar.f;
        this.mApplyElevation = dnVar.m;
        this.mElevation = dnVar.n;
        this.mRotation = dnVar.b;
        this.mRotationX = dnVar.c;
        this.rotationY = dnVar.d;
        this.mScaleX = dnVar.e;
        this.mScaleY = dnVar.f;
        this.mPivotX = dnVar.g;
        this.mPivotY = dnVar.h;
        this.mTranslationX = dnVar.j;
        this.mTranslationY = dnVar.k;
        this.mTranslationZ = dnVar.l;
        bn bnVar = zmVar.d;
        this.mKeyFrameEasing = fy.c(bnVar.d);
        this.mPathRotate = bnVar.h;
        this.mDrawPath = bnVar.f;
        this.mAnimateRelativeTo = bnVar.b;
        this.mProgress = zmVar.c.e;
        for (String str : zmVar.g.keySet()) {
            hm hmVar = (hm) zmVar.g.get(str);
            int iV = uo.v(hmVar.c);
            if (iV != 4 && iV != 5 && iV != 7) {
                this.mAttributes.put(str, hmVar);
            }
        }
    }

    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.mPosition, motionConstrainedPoint.mPosition);
        zArr[1] = zArr[1] | diff(this.mX, motionConstrainedPoint.mX);
        zArr[2] = zArr[2] | diff(this.mY, motionConstrainedPoint.mY);
        zArr[3] = zArr[3] | diff(this.mWidth, motionConstrainedPoint.mWidth);
        zArr[4] = diff(this.mHeight, motionConstrainedPoint.mHeight) | zArr[4];
    }
}
