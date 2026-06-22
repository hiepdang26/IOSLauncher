package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.bn;
import defpackage.en;
import defpackage.fy;
import defpackage.hu1;
import defpackage.iu1;
import defpackage.jt1;
import defpackage.nm;
import defpackage.ou1;
import defpackage.pq;
import defpackage.zf;
import defpackage.zm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionController {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private pq mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, hu1> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, jt1> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private pq[] mSpline;
    private HashMap<String, ou1> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int mMaxDimension = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();

    public MotionController(View view) {
        int i = Key.UNSET;
        this.mPathMotionArc = i;
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.mStaggerScale;
            if (f3 != 1.0d) {
                float f4 = this.mStaggerOffset;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = Math.min((f - f4) * f3, 1.0f);
                }
            }
        }
        fy fyVar = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f5 = Float.NaN;
        int i = 0;
        while (i < size) {
            MotionPaths motionPaths = arrayList.get(i);
            i++;
            MotionPaths motionPaths2 = motionPaths;
            fy fyVar2 = motionPaths2.mKeyFrameEasing;
            if (fyVar2 != null) {
                float f6 = motionPaths2.mTime;
                if (f6 < f) {
                    fyVar = fyVar2;
                    f2 = f6;
                } else if (Float.isNaN(f5)) {
                    f5 = motionPaths2.mTime;
                }
            }
        }
        if (fyVar != null) {
            float f7 = (Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f7;
            f = (((float) fyVar.a(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) fyVar.b(d);
            }
        }
        return f;
    }

    private static Interpolator getInterpolator(Context context, int i, String str, int i2) {
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, i2);
        }
        if (i == -1) {
            final fy fyVarC = fy.c(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    return (float) fyVarC.a(f);
                }
            };
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        float fHypot = 0.0f;
        while (i < 100) {
            float f2 = i * f;
            double dA = f2;
            fy fyVar = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f3 = Float.NaN;
            int i2 = 0;
            float f4 = 0.0f;
            while (i2 < size) {
                MotionPaths motionPaths = arrayList.get(i2);
                i2++;
                MotionPaths motionPaths2 = motionPaths;
                float f5 = f;
                fy fyVar2 = motionPaths2.mKeyFrameEasing;
                if (fyVar2 != null) {
                    float f6 = motionPaths2.mTime;
                    if (f6 < f2) {
                        f4 = f6;
                        fyVar = fyVar2;
                    } else if (Float.isNaN(f3)) {
                        f3 = motionPaths2.mTime;
                    }
                }
                f = f5;
            }
            float f7 = f;
            if (fyVar != null) {
                if (Float.isNaN(f3)) {
                    f3 = 1.0f;
                }
                dA = (((float) fyVar.a((f2 - f4) / r17)) * (f3 - f4)) + f4;
            }
            double d3 = dA;
            this.mSpline[0].c(d3, this.mInterpolateData);
            int i3 = i;
            this.mStartMotionPath.getCenter(d3, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i3 > 0) {
                fHypot += (float) Math.hypot(d2 - ((double) fArr[1]), d - ((double) fArr[0]));
            }
            d = fArr[0];
            d2 = fArr[1];
            i = i3 + 1;
            f = f7;
        }
        return fHypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            float f = motionPaths.mPosition;
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i) {
        float f = 1.0f;
        float f2 = 1.0f / (i - 1);
        HashMap<String, hu1> map = this.mAttributesMap;
        if (map != null) {
            map.get(Key.TRANSLATION_X);
        }
        HashMap<String, hu1> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get(Key.TRANSLATION_Y);
        }
        HashMap<String, jt1> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get(Key.TRANSLATION_X);
        }
        HashMap<String, jt1> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get(Key.TRANSLATION_Y);
        }
        int i2 = 0;
        while (i2 < i) {
            float fMin = i2 * f2;
            float f3 = this.mStaggerScale;
            float f4 = 0.0f;
            if (f3 != f) {
                float f5 = this.mStaggerOffset;
                if (fMin < f5) {
                    fMin = 0.0f;
                }
                if (fMin > f5 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f5) * f3, f);
                }
            }
            double dA = fMin;
            fy fyVar = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f6 = Float.NaN;
            int i3 = 0;
            while (i3 < size) {
                MotionPaths motionPaths = arrayList.get(i3);
                i3++;
                MotionPaths motionPaths2 = motionPaths;
                fy fyVar2 = motionPaths2.mKeyFrameEasing;
                if (fyVar2 != null) {
                    float f7 = motionPaths2.mTime;
                    if (f7 < fMin) {
                        fyVar = fyVar2;
                        f4 = f7;
                    } else if (Float.isNaN(f6)) {
                        f6 = motionPaths2.mTime;
                    }
                }
            }
            if (fyVar != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                dA = (((float) fyVar.a((fMin - f4) / r13)) * (f6 - f4)) + f4;
            }
            this.mSpline[0].c(dA, this.mInterpolateData);
            pq pqVar = this.mArcSpline;
            if (pqVar != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    pqVar.c(dA, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 2);
            i2++;
            f = 1.0f;
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrG = this.mSpline[0].g();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                MotionPaths motionPaths = arrayList.get(i2);
                i2++;
                iArr[i] = motionPaths.mMode;
                i++;
            }
        }
        int i3 = 0;
        for (double d : dArrG) {
            this.mSpline[0].c(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrG = this.mSpline[0].g();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                MotionPaths motionPaths = arrayList.get(i2);
                i2++;
                iArr[i] = motionPaths.mMode;
                i++;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < dArrG.length; i4++) {
            this.mSpline[0].c(dArrG[i4], this.mInterpolateData);
            this.mStartMotionPath.getCenter(dArrG[i4], this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public void buildPath(float[] fArr, int i) {
        int i2 = i;
        float f = 1.0f;
        float f2 = 1.0f / (i2 - 1);
        HashMap<String, hu1> map = this.mAttributesMap;
        hu1 hu1Var = map == null ? null : map.get(Key.TRANSLATION_X);
        HashMap<String, hu1> map2 = this.mAttributesMap;
        hu1 hu1Var2 = map2 == null ? null : map2.get(Key.TRANSLATION_Y);
        HashMap<String, jt1> map3 = this.mCycleMap;
        jt1 jt1Var = map3 == null ? null : map3.get(Key.TRANSLATION_X);
        HashMap<String, jt1> map4 = this.mCycleMap;
        jt1 jt1Var2 = map4 != null ? map4.get(Key.TRANSLATION_Y) : null;
        int i3 = 0;
        while (i3 < i2) {
            float fMin = i3 * f2;
            float f3 = this.mStaggerScale;
            float f4 = 0.0f;
            if (f3 != f) {
                float f5 = this.mStaggerOffset;
                if (fMin < f5) {
                    fMin = 0.0f;
                }
                if (fMin > f5 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f5) * f3, f);
                }
            }
            double dA = fMin;
            fy fyVar = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f6 = Float.NaN;
            int i4 = 0;
            while (i4 < size) {
                MotionPaths motionPaths = arrayList.get(i4);
                i4++;
                MotionPaths motionPaths2 = motionPaths;
                float f7 = f2;
                fy fyVar2 = motionPaths2.mKeyFrameEasing;
                if (fyVar2 != null) {
                    float f8 = motionPaths2.mTime;
                    if (f8 < fMin) {
                        f4 = f8;
                        fyVar = fyVar2;
                    } else if (Float.isNaN(f6)) {
                        f6 = motionPaths2.mTime;
                    }
                }
                f2 = f7;
            }
            float f9 = f2;
            if (fyVar != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                dA = (((float) fyVar.a((fMin - f4) / r17)) * (f6 - f4)) + f4;
            }
            this.mSpline[0].c(dA, this.mInterpolateData);
            pq pqVar = this.mArcSpline;
            if (pqVar != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    pqVar.c(dA, dArr);
                }
            }
            int i5 = i3 * 2;
            this.mStartMotionPath.getCenter(dA, this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
            if (jt1Var != null) {
                fArr[i5] = jt1Var.a(fMin) + fArr[i5];
            } else if (hu1Var != null) {
                fArr[i5] = hu1Var.a(fMin) + fArr[i5];
            }
            if (jt1Var2 != null) {
                int i6 = i5 + 1;
                fArr[i6] = jt1Var2.a(fMin) + fArr[i6];
            } else if (hu1Var2 != null) {
                int i7 = i5 + 1;
                fArr[i7] = hu1Var2.a(fMin) + fArr[i7];
            }
            i3++;
            i2 = i;
            f2 = f9;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].c(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    public void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].c(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    public void endTrigger(boolean z) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i].conditionallyFire(z ? -100.0f : 100.0f, this.mView);
            i++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i) {
        hu1 hu1Var = this.mAttributesMap.get(str);
        if (hu1Var == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = hu1Var.a(i2 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].c(d, dArr);
        this.mSpline[0].f(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        pq[] pqVarArr = this.mSpline;
        int i = 0;
        if (pqVarArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f4 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f5 = f4 - motionPaths2.mX;
            float f6 = motionPaths.mY - motionPaths2.mY;
            float f7 = motionPaths.mWidth - motionPaths2.mWidth;
            float f8 = (motionPaths.mHeight - motionPaths2.mHeight) + f6;
            fArr[0] = ((f7 + f5) * f2) + ((1.0f - f2) * f5);
            fArr[1] = (f8 * f3) + ((1.0f - f3) * f6);
            return;
        }
        double d = adjustedPosition;
        pqVarArr[0].f(d, this.mInterpolateVelocity);
        this.mSpline[0].c(d, this.mInterpolateData);
        float f9 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * ((double) f9);
            i++;
        }
        pq pqVar = this.mArcSpline;
        if (pqVar == null) {
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            pqVar.c(d, dArr2);
            this.mArcSpline.f(d, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            MotionPaths motionPaths = arrayList.get(i);
            i++;
            iMax = Math.max(iMax, motionPaths.mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int i5 = i2 + 1;
            Key key = arrayList.get(i2);
            int i6 = key.mType;
            if (i6 == i || i != -1) {
                iArr[i4] = 0;
                iArr[i4 + 1] = i6;
                int i7 = key.mFramePosition;
                iArr[i4 + 2] = i7;
                double d = i7 / 100.0f;
                this.mSpline[0].c(d, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i4 + 3] = Float.floatToIntBits(fArr[0]);
                int i8 = i4 + 4;
                iArr[i8] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i4 + 5] = keyPosition.mPositionType;
                    iArr[i4 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i8 = i4 + 7;
                    iArr[i8] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i9 = i8 + 1;
                iArr[i4] = i9 - i4;
                i3++;
                i4 = i9;
            }
            i2 = i5;
        }
        return i3;
    }

    public float getKeyFrameParameter(int i, float f, float f2) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f3 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f4 = motionPaths2.mX;
        float f5 = f3 - f4;
        float f6 = motionPaths.mY;
        float f7 = motionPaths2.mY;
        float f8 = f6 - f7;
        float f9 = (motionPaths2.mWidth / 2.0f) + f4;
        float f10 = (motionPaths2.mHeight / 2.0f) + f7;
        float fHypot = (float) Math.hypot(f5, f8);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f11 = f - f9;
        float f12 = f2 - f10;
        if (((float) Math.hypot(f11, f12)) == 0.0f) {
            return 0.0f;
        }
        float f13 = (f12 * f8) + (f11 * f5);
        if (i == 0) {
            return f13 / fHypot;
        }
        if (i == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f13 * f13));
        }
        if (i == 2) {
            return f11 / f5;
        }
        if (i == 3) {
            return f12 / f5;
        }
        if (i == 4) {
            return f11 / f8;
        }
        if (i != 5) {
            return 0.0f;
        }
        return f12 / f8;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4 = i2 + 1;
            Key key = arrayList.get(i2);
            int i5 = key.mFramePosition;
            iArr[i] = (key.mType * zzbbc.zzq.zzf) + i5;
            double d = i5 / 100.0f;
            this.mSpline[0].c(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
            i2 = i4;
            i++;
        }
        return i;
    }

    public double[] getPos(double d) {
        this.mSpline[0].c(d, this.mInterpolateData);
        pq pqVar = this.mArcSpline;
        if (pqVar != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                pqVar.c(d, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public KeyPositionBase getPositionKeyframe(int i, int i2, float f, float f2) {
        int i3;
        int i4;
        float f3;
        float f4;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f5 = motionPaths.mX;
        rectF.left = f5;
        float f6 = motionPaths.mY;
        rectF.top = f6;
        rectF.right = f5 + motionPaths.mWidth;
        rectF.bottom = f6 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f7 = motionPaths2.mX;
        rectF2.left = f7;
        float f8 = motionPaths2.mY;
        rectF2.top = f8;
        rectF2.right = f7 + motionPaths2.mWidth;
        rectF2.bottom = f8 + motionPaths2.mHeight;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            Key key = arrayList.get(i5);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
                if (keyPositionBase.intersects(i3, i4, rectF, rectF2, f3, f4)) {
                    return keyPositionBase;
                }
            } else {
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
            }
            i = i3;
            i2 = i4;
            f = f3;
            f2 = f4;
            i5 = i6;
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        jt1 jt1Var;
        jt1 jt1Var2;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, hu1> map = this.mAttributesMap;
        hu1 hu1Var = map == null ? null : map.get(Key.TRANSLATION_X);
        HashMap<String, hu1> map2 = this.mAttributesMap;
        hu1 hu1Var2 = map2 == null ? null : map2.get(Key.TRANSLATION_Y);
        HashMap<String, hu1> map3 = this.mAttributesMap;
        hu1 hu1Var3 = map3 == null ? null : map3.get(Key.ROTATION);
        HashMap<String, hu1> map4 = this.mAttributesMap;
        hu1 hu1Var4 = map4 == null ? null : map4.get(Key.SCALE_X);
        HashMap<String, hu1> map5 = this.mAttributesMap;
        hu1 hu1Var5 = map5 == null ? null : map5.get(Key.SCALE_Y);
        HashMap<String, jt1> map6 = this.mCycleMap;
        jt1 jt1Var3 = map6 == null ? null : map6.get(Key.TRANSLATION_X);
        HashMap<String, jt1> map7 = this.mCycleMap;
        jt1 jt1Var4 = map7 == null ? null : map7.get(Key.TRANSLATION_Y);
        HashMap<String, jt1> map8 = this.mCycleMap;
        jt1 jt1Var5 = map8 == null ? null : map8.get(Key.ROTATION);
        HashMap<String, jt1> map9 = this.mCycleMap;
        jt1 jt1Var6 = map9 == null ? null : map9.get(Key.SCALE_X);
        HashMap<String, jt1> map10 = this.mCycleMap;
        jt1 jt1Var7 = map10 != null ? map10.get(Key.SCALE_Y) : null;
        zf zfVar = new zf();
        zfVar.e = 0.0f;
        zfVar.d = 0.0f;
        zfVar.c = 0.0f;
        zfVar.b = 0.0f;
        zfVar.a = 0.0f;
        if (hu1Var3 != null) {
            jt1Var = jt1Var3;
            jt1Var2 = jt1Var7;
            zfVar.e = (float) hu1Var3.a.e(adjustedPosition);
            zfVar.f = hu1Var3.a(adjustedPosition);
        } else {
            jt1Var = jt1Var3;
            jt1Var2 = jt1Var7;
        }
        if (hu1Var != null) {
            zfVar.c = (float) hu1Var.a.e(adjustedPosition);
        }
        if (hu1Var2 != null) {
            zfVar.d = (float) hu1Var2.a.e(adjustedPosition);
        }
        if (hu1Var4 != null) {
            zfVar.a = (float) hu1Var4.a.e(adjustedPosition);
        }
        if (hu1Var5 != null) {
            zfVar.b = (float) hu1Var5.a.e(adjustedPosition);
        }
        if (jt1Var5 != null) {
            zfVar.e = jt1Var5.b(adjustedPosition);
        }
        jt1 jt1Var8 = jt1Var;
        if (jt1Var != null) {
            zfVar.c = jt1Var8.b(adjustedPosition);
        }
        if (jt1Var4 != null) {
            zfVar.d = jt1Var4.b(adjustedPosition);
        }
        if (jt1Var6 != null) {
            zfVar.a = jt1Var6.b(adjustedPosition);
        }
        if (jt1Var2 != null) {
            zfVar.b = jt1Var2.b(adjustedPosition);
        }
        pq pqVar = this.mArcSpline;
        if (pqVar != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = adjustedPosition;
                pqVar.c(d, dArr);
                this.mArcSpline.f(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            zfVar.a(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f4 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f5 = f4 - motionPaths2.mX;
            float f6 = motionPaths.mY - motionPaths2.mY;
            float f7 = motionPaths.mWidth - motionPaths2.mWidth;
            float f8 = f6 + (motionPaths.mHeight - motionPaths2.mHeight);
            fArr[0] = ((f7 + f5) * f2) + ((1.0f - f2) * f5);
            fArr[1] = (f8 * f3) + ((1.0f - f3) * f6);
            zfVar.e = 0.0f;
            zfVar.d = 0.0f;
            zfVar.c = 0.0f;
            zfVar.b = 0.0f;
            zfVar.a = 0.0f;
            if (hu1Var3 != null) {
                zfVar.e = (float) hu1Var3.a.e(adjustedPosition);
                zfVar.f = hu1Var3.a(adjustedPosition);
            }
            if (hu1Var != null) {
                zfVar.c = (float) hu1Var.a.e(adjustedPosition);
            }
            if (hu1Var2 != null) {
                zfVar.d = (float) hu1Var2.a.e(adjustedPosition);
            }
            if (hu1Var4 != null) {
                zfVar.a = (float) hu1Var4.a.e(adjustedPosition);
            }
            if (hu1Var5 != null) {
                zfVar.b = (float) hu1Var5.a.e(adjustedPosition);
            }
            if (jt1Var5 != null) {
                zfVar.e = jt1Var5.b(adjustedPosition);
            }
            if (jt1Var8 != null) {
                zfVar.c = jt1Var8.b(adjustedPosition);
            }
            if (jt1Var4 != null) {
                zfVar.d = jt1Var4.b(adjustedPosition);
            }
            if (jt1Var6 != null) {
                zfVar.a = jt1Var6.b(adjustedPosition);
            }
            if (jt1Var2 != null) {
                zfVar.b = jt1Var2.b(adjustedPosition);
            }
            zfVar.a(f2, f3, i, i2, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].f(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].c(adjustedPosition2, this.mInterpolateData);
        float f9 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i3 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                zfVar.a(f2, f3, i, i2, fArr);
                return;
            } else {
                dArr2[i3] = dArr2[i3] * ((double) f9);
                i3++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean interpolate(android.view.View r20, float r21, long r22, defpackage.cj0 r24) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.interpolate(android.view.View, float, long, cj0):boolean");
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f3 = motionPaths.mX;
        rectF.left = f3;
        float f4 = motionPaths.mY;
        rectF.top = f4;
        rectF.right = f3 + motionPaths.mWidth;
        rectF.bottom = f4 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f5 = motionPaths2.mX;
        rectF2.left = f5;
        float f6 = motionPaths2.mY;
        rectF2.top = f6;
        rectF2.right = f5 + motionPaths2.mWidth;
        rectF2.bottom = f6 + motionPaths2.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    public void rotate(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - ((rect.height() + i4) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i == 2) {
            int i5 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i5 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i == 3) {
            int i6 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i6 / 2);
            rect2.top = i3 - ((rect.height() + i6) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i != 4) {
            return;
        }
        int i7 = rect.left + rect.right;
        rect2.left = i2 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i7 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    public void setEndState(Rect rect, en enVar, int i, int i2) {
        MotionController motionController;
        int i3 = enVar.d;
        if (i3 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i3, i, i2);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        motionController.mEndMotionPath.applyParameters(enVar.k(motionController.mId));
        motionController.mEndPoint.setState(rect, enVar, i3, motionController.mId);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(iu1 iu1Var, View view, int i, int i2, int i3) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i == 1) {
            int i4 = iu1Var.b;
            int i5 = iu1Var.d;
            int i6 = iu1Var.c;
            int i7 = iu1Var.e;
            int i8 = ((i6 + i7) - (i5 - i4)) / 2;
            rect.left = i8;
            int i9 = i2 - (((i7 - i6) + (i4 + i5)) / 2);
            rect.top = i9;
            rect.right = (i5 - i4) + i8;
            rect.bottom = (i7 - i6) + i9;
        } else if (i == 2) {
            int i10 = iu1Var.b;
            int i11 = iu1Var.d;
            int i12 = iu1Var.c;
            int i13 = iu1Var.e;
            int i14 = i3 - (((i11 - i10) + (i12 + i13)) / 2);
            rect.left = i14;
            int i15 = ((i10 + i11) - (i13 - i12)) / 2;
            rect.top = i15;
            rect.right = (i11 - i10) + i14;
            rect.bottom = (i13 - i12) + i15;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, view, i, iu1Var.a);
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof nm) {
            this.mConstraintTag = ((nm) layoutParams).Y;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x02d6 A[SYNTHETIC] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setup(int r37, int r38, float r39, long r40) {
        /*
            Method dump skipped, instruction units count: 3534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.setup(int, int, float, long):void");
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    public void setStartState(Rect rect, en enVar, int i, int i2) {
        MotionController motionController;
        Rect rect2;
        int i3 = enVar.d;
        if (i3 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i3, i, i2);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds(rect2.left, rect2.top, rect2.width(), rect2.height());
        zm zmVarK = enVar.k(motionController.mId);
        motionController.mStartMotionPath.applyParameters(zmVarK);
        motionController.mMotionStagger = zmVarK.d.g;
        motionController.mStartPoint.setState(rect2, enVar, i3, motionController.mId);
        motionController.mTransformPivotTarget = zmVarK.f.i;
        bn bnVar = zmVarK.d;
        motionController.mQuantizeMotionSteps = bnVar.j;
        motionController.mQuantizeMotionPhase = bnVar.i;
        motionController.mQuantizeMotionInterpolator = getInterpolator(motionController.mView.getContext(), bnVar.l, bnVar.k, bnVar.m);
    }
}
