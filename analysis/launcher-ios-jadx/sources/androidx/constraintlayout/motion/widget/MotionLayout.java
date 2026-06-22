package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.a;
import defpackage.b40;
import defpackage.c21;
import defpackage.cj0;
import defpackage.en;
import defpackage.gm;
import defpackage.in;
import defpackage.iu1;
import defpackage.j71;
import defpackage.jn;
import defpackage.k31;
import defpackage.kn;
import defpackage.mn;
import defpackage.nm;
import defpackage.oj1;
import defpackage.om;
import defpackage.sa;
import defpackage.sm;
import defpackage.uo;
import defpackage.va0;
import defpackage.vu1;
import defpackage.x51;
import defpackage.xb0;
import defpackage.xw0;
import defpackage.zb0;
import defpackage.zm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements xw0 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private ArrayList<MotionHelper> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    private boolean mInRotation;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private cj0 mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mLastY;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, iu1> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    MotionScene mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private oj1 mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    public class DecelerateInterpolator extends MotionInterpolator {
        float mMaxA;
        float mInitialV = 0.0f;
        float mCurrentP = 0.0f;

        public DecelerateInterpolator() {
        }

        public void config(float f, float f2, float f3) {
            this.mInitialV = f;
            this.mCurrentP = f2;
            this.mMaxA = f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.mInitialV;
            if (f2 > 0.0f) {
                float f3 = this.mMaxA;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                MotionLayout.this.mLastVelocity = f2 - (f3 * f);
                return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.mCurrentP;
            }
            float f4 = this.mMaxA;
            if ((-f2) / f4 < f) {
                f = (-f2) / f4;
            }
            MotionLayout.this.mLastVelocity = (f4 * f) + f2;
            return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.mCurrentP;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    public class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final int mRedColor = -21965;
        final int mKeyframeColor = -2067046;
        final int mGraphColor = -13391360;
        final int mShadowColor = 1996488704;
        final int mDiamondSize = 10;
        Rect mBounds = new Rect();
        boolean mPresentationMode = false;

        public DevModeDraw() {
            this.mShadowTranslate = 1;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            Paint paint2 = this.mPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.mPaintKeyframes = paint3;
            paint3.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(style);
            Paint paint4 = new Paint();
            this.mPaintGraph = paint4;
            paint4.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(style);
            Paint paint5 = new Paint();
            this.mTextPaint = paint5;
            paint5.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint6 = new Paint();
            this.mFillPaint = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.mKeyFrameCount; i++) {
                int i2 = this.mPathMode[i];
                if (i2 == 1) {
                    z = true;
                }
                if (i2 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                drawPathRelative(canvas);
            }
            if (z2) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
            float[] fArr = this.mPoints;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float fMin = Math.min(f3, f5);
            float fMax = Math.max(f4, f6);
            float fMin2 = f - Math.min(f3, f5);
            float fMax2 = Math.max(f4, f6) - f2;
            String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.mBounds.width() / 2)) + fMin, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
            String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f + 5.0f, fMax - ((fMax2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
            float[] fArr = this.mPoints;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f2 - f4) * f8) + ((f - f3) * f7)) / (fHypot * fHypot);
            float f10 = f3 + (f7 * f9);
            float f11 = (f9 * f8) + f4;
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float fHypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f, float f2, int i, int i2) {
            String str = "" + (((int) (((double) (((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i))) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
            String str2 = "" + (((int) (((double) (((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2))) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, 5.0f + f, 0.0f - ((f2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i = 0; i <= 50; i++) {
                motionController.buildRect(i / 50, this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(-65536);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i, int i2, MotionController motionController) {
            int width;
            int height;
            View view = motionController.mView;
            if (view != null) {
                width = view.getWidth();
                height = motionController.mView.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i3 = 1; i3 < i2 - 1; i3++) {
                if (i != 4 || this.mPathMode[i3 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i4 = i3 * 2;
                    float f = fArr[i4];
                    float f2 = fArr[i4 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f, f2 + 10.0f);
                    this.mPath.lineTo(f + 10.0f, f2);
                    this.mPath.lineTo(f, f2 - 10.0f);
                    this.mPath.lineTo(f - 10.0f, f2);
                    this.mPath.close();
                    int i5 = i3 - 1;
                    motionController.getKeyFrame(i5);
                    if (i == 4) {
                        int i6 = this.mPathMode[i5];
                        if (i6 == 1) {
                            drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                        } else if (i6 == 0) {
                            drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                        } else if (i6 == 2) {
                            drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    }
                    if (i == 2) {
                        drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 3) {
                        drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 6) {
                        drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
            canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> map, int i, int i2) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.mTextPaint);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.mPaint);
            }
            for (MotionController motionController : map.values()) {
                int drawPath = motionController.getDrawPath();
                if (i2 > 0 && drawPath == 0) {
                    drawPath = 1;
                }
                if (drawPath != 0) {
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (drawPath >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.mPoints;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.mPoints = new float[i3 * 2];
                            this.mPath = new Path();
                        }
                        int i4 = this.mShadowTranslate;
                        canvas.translate(i4, i4);
                        this.mPaint.setColor(1996488704);
                        this.mFillPaint.setColor(1996488704);
                        this.mPaintKeyframes.setColor(1996488704);
                        this.mPaintGraph.setColor(1996488704);
                        motionController.buildPath(this.mPoints, i3);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        this.mPaint.setColor(-21965);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(-13391360);
                        int i5 = this.mShadowTranslate;
                        canvas.translate(-i5, -i5);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        if (drawPath == 5) {
                            drawRectangle(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void drawAll(Canvas canvas, int i, int i2, MotionController motionController) {
            if (i == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i == 2) {
                drawPathRelative(canvas);
            }
            if (i == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i, i2, motionController);
        }

        public void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    public class Model {
        int mEndId;
        int mStartId;
        kn mLayoutStart = new kn();
        kn mLayoutEnd = new kn();
        en mStart = null;
        en mEnd = null;

        public Model() {
        }

        private void computeStartEndSize(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.mCurrentState == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                kn knVar = this.mLayoutEnd;
                en enVar = this.mEnd;
                motionLayout2.resolveSystem(knVar, optimizationLevel, (enVar == null || enVar.d == 0) ? i : i2, (enVar == null || enVar.d == 0) ? i2 : i);
                en enVar2 = this.mStart;
                if (enVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    kn knVar2 = this.mLayoutStart;
                    int i3 = enVar2.d;
                    int i4 = i3 == 0 ? i : i2;
                    if (i3 == 0) {
                        i = i2;
                    }
                    motionLayout3.resolveSystem(knVar2, optimizationLevel, i4, i);
                    return;
                }
                return;
            }
            en enVar3 = this.mStart;
            if (enVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                kn knVar3 = this.mLayoutStart;
                int i5 = enVar3.d;
                motionLayout4.resolveSystem(knVar3, optimizationLevel, i5 == 0 ? i : i2, i5 == 0 ? i2 : i);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            kn knVar4 = this.mLayoutEnd;
            en enVar4 = this.mEnd;
            int i6 = (enVar4 == null || enVar4.d == 0) ? i : i2;
            if (enVar4 == null || enVar4.d == 0) {
                i = i2;
            }
            motionLayout5.resolveSystem(knVar4, optimizationLevel, i6, i);
        }

        private void debugLayout(String str, kn knVar) {
            k31.m(str, " ").append(Debug.getName(knVar.g0));
            knVar.toString();
            int size = knVar.t0.size();
            for (int i = 0; i < size; i++) {
                jn jnVar = (jn) knVar.t0.get(i);
                uo.m((jnVar.J.f != null ? "T" : "_").concat(jnVar.L.f != null ? "B" : "_")).append(jnVar.I.f != null ? "L" : "_");
                gm gmVar = jnVar.K.f;
                View view = jnVar.g0;
                Debug.getName(view);
                if (view instanceof TextView) {
                    Objects.toString(((TextView) view).getText());
                }
                jnVar.toString();
            }
        }

        private void debugLayoutParam(String str, nm nmVar) {
            StringBuilder sbM = uo.m(" ".concat(nmVar.t != -1 ? "SS" : "__"));
            sbM.append(nmVar.s != -1 ? "|SE" : "|__");
            StringBuilder sbM2 = uo.m(sbM.toString());
            sbM2.append(nmVar.u != -1 ? "|ES" : "|__");
            StringBuilder sbM3 = uo.m(sbM2.toString());
            sbM3.append(nmVar.v != -1 ? "|EE" : "|__");
            StringBuilder sbM4 = uo.m(sbM3.toString());
            sbM4.append(nmVar.e != -1 ? "|LL" : "|__");
            StringBuilder sbM5 = uo.m(sbM4.toString());
            sbM5.append(nmVar.f != -1 ? "|LR" : "|__");
            StringBuilder sbM6 = uo.m(sbM5.toString());
            sbM6.append(nmVar.g != -1 ? "|RL" : "|__");
            StringBuilder sbM7 = uo.m(sbM6.toString());
            sbM7.append(nmVar.h != -1 ? "|RR" : "|__");
            StringBuilder sbM8 = uo.m(sbM7.toString());
            sbM8.append(nmVar.i != -1 ? "|TT" : "|__");
            StringBuilder sbM9 = uo.m(sbM8.toString());
            sbM9.append(nmVar.j != -1 ? "|TB" : "|__");
            StringBuilder sbM10 = uo.m(sbM9.toString());
            sbM10.append(nmVar.k != -1 ? "|BT" : "|__");
            uo.m(sbM10.toString()).append(nmVar.l != -1 ? "|BB" : "|__");
        }

        private void debugWidget(String str, jn jnVar) {
            String strConcat;
            String strConcat2;
            StringBuilder sb = new StringBuilder(" ");
            gm gmVar = jnVar.J.f;
            String strConcat3 = "__";
            if (gmVar != null) {
                strConcat = "T".concat(gmVar.e == 3 ? "T" : "B");
            } else {
                strConcat = "__";
            }
            sb.append(strConcat);
            StringBuilder sbM = uo.m(sb.toString());
            gm gmVar2 = jnVar.L.f;
            if (gmVar2 != null) {
                strConcat2 = "B".concat(gmVar2.e != 3 ? "B" : "T");
            } else {
                strConcat2 = "__";
            }
            sbM.append(strConcat2);
            StringBuilder sbM2 = uo.m(sbM.toString());
            gm gmVar3 = jnVar.I.f;
            if (gmVar3 != null) {
                strConcat3 = "L".concat(gmVar3.e == 2 ? "L" : "R");
            }
            sbM2.append(strConcat3);
            gm gmVar4 = jnVar.K.f;
            if (gmVar4 != null) {
                "R".concat(gmVar4.e != 2 ? "R" : "L");
            }
            jnVar.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(kn knVar, en enVar) {
            zm zmVar;
            zm zmVar2;
            SparseArray<jn> sparseArray = new SparseArray<>();
            mn mnVar = new mn(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, knVar);
            sparseArray.put(MotionLayout.this.getId(), knVar);
            if (enVar != null && enVar.d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.mLayoutEnd, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            ArrayList arrayList = knVar.t0;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jn jnVar = (jn) obj;
                jnVar.i0 = true;
                sparseArray.put(jnVar.g0.getId(), jnVar);
            }
            ArrayList arrayList2 = knVar.t0;
            int size2 = arrayList2.size();
            int i2 = 0;
            while (i2 < size2) {
                int i3 = i2 + 1;
                jn jnVar2 = (jn) arrayList2.get(i2);
                View view = jnVar2.g0;
                int id = view.getId();
                HashMap map = enVar.g;
                if (map.containsKey(Integer.valueOf(id)) && (zmVar2 = (zm) map.get(Integer.valueOf(id))) != null) {
                    zmVar2.b(mnVar);
                }
                jnVar2.N(enVar.k(view.getId()).e.c);
                jnVar2.K(enVar.k(view.getId()).e.d);
                if (view instanceof a) {
                    a aVar = (a) view;
                    int id2 = aVar.getId();
                    HashMap map2 = enVar.g;
                    if (map2.containsKey(Integer.valueOf(id2)) && (zmVar = (zm) map2.get(Integer.valueOf(id2))) != null && (jnVar2 instanceof zb0)) {
                        aVar.loadParameters(zmVar, (zb0) jnVar2, mnVar, sparseArray);
                    }
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                mnVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, jnVar2, mnVar, sparseArray);
                if (enVar.k(view.getId()).c.c == 1) {
                    jnVar2.h0 = view.getVisibility();
                } else {
                    jnVar2.h0 = enVar.k(view.getId()).c.b;
                }
                i2 = i3;
            }
            ArrayList arrayList3 = knVar.t0;
            int size3 = arrayList3.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj2 = arrayList3.get(i4);
                i4++;
                jn jnVar3 = (jn) obj2;
                if (jnVar3 instanceof vu1) {
                    a aVar2 = (a) jnVar3.g0;
                    xb0 xb0Var = (xb0) jnVar3;
                    aVar2.updatePreLayout(knVar, xb0Var, sparseArray);
                    vu1 vu1Var = (vu1) xb0Var;
                    for (int i5 = 0; i5 < vu1Var.u0; i5++) {
                        jn jnVar4 = vu1Var.t0[i5];
                        if (jnVar4 != null) {
                            jnVar4.F = true;
                        }
                    }
                }
            }
        }

        public void build() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i = 0; i < childCount; i++) {
                View childAt = MotionLayout.this.getChildAt(i);
                MotionController motionController = new MotionController(childAt);
                int id = childAt.getId();
                iArr[i] = id;
                sparseArray.put(id, motionController);
                MotionLayout.this.mFrameArrayList.put(childAt, motionController);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = MotionLayout.this.getChildAt(i2);
                MotionController motionController2 = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController2 != null) {
                    if (this.mStart != null) {
                        jn widget = getWidget(this.mLayoutStart, childAt2);
                        if (widget != null) {
                            motionController2.setStartState(MotionLayout.this.toRect(widget), this.mStart, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass();
                        }
                    } else if (MotionLayout.this.mInRotation) {
                        iu1 iu1Var = MotionLayout.this.mPreRotate.get(childAt2);
                        MotionLayout motionLayout = MotionLayout.this;
                        motionController2.setStartState(iu1Var, childAt2, motionLayout.mRotatMode, motionLayout.mPreRotateWidth, MotionLayout.this.mPreRotateHeight);
                    }
                    if (this.mEnd != null) {
                        jn widget2 = getWidget(this.mLayoutEnd, childAt2);
                        if (widget2 != null) {
                            motionController2.setEndState(MotionLayout.this.toRect(widget2), this.mEnd, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass();
                        }
                    }
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                MotionController motionController3 = (MotionController) sparseArray.get(iArr[i3]);
                int animateRelativeTo = motionController3.getAnimateRelativeTo();
                if (animateRelativeTo != -1) {
                    motionController3.setupRelative((MotionController) sparseArray.get(animateRelativeTo));
                }
            }
        }

        public void copy(kn knVar, kn knVar2) {
            jn c21Var;
            ArrayList arrayList = knVar.t0;
            HashMap map = new HashMap();
            map.put(knVar, knVar2);
            knVar2.t0.clear();
            knVar2.g(knVar, map);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                jn jnVar = (jn) obj;
                if (jnVar instanceof sa) {
                    c21Var = new sa();
                } else if (jnVar instanceof va0) {
                    c21Var = new va0();
                } else if (jnVar instanceof b40) {
                    b40 b40Var = new b40();
                    b40Var.v0 = new ArrayList();
                    c21Var = b40Var;
                } else {
                    c21Var = jnVar instanceof c21 ? new c21() : jnVar instanceof xb0 ? new zb0() : new jn();
                }
                knVar2.t0.add(c21Var);
                jn jnVar2 = c21Var.U;
                if (jnVar2 != null) {
                    ((kn) jnVar2).t0.remove(c21Var);
                    c21Var.D();
                }
                c21Var.U = knVar2;
                map.put(jnVar, c21Var);
            }
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                jn jnVar3 = (jn) obj2;
                ((jn) map.get(jnVar3)).g(jnVar3, map);
            }
        }

        public jn getWidget(kn knVar, View view) {
            if (knVar.g0 == view) {
                return knVar;
            }
            ArrayList arrayList = knVar.t0;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                jn jnVar = (jn) arrayList.get(i);
                if (jnVar.g0 == view) {
                    return jnVar;
                }
            }
            return null;
        }

        public void initFrom(kn knVar, en enVar, en enVar2) {
            this.mStart = enVar;
            this.mEnd = enVar2;
            this.mLayoutStart = new kn();
            this.mLayoutEnd = new kn();
            kn knVar2 = this.mLayoutStart;
            om omVar = ((ConstraintLayout) MotionLayout.this).mLayoutWidget.x0;
            knVar2.x0 = omVar;
            knVar2.v0.f = omVar;
            kn knVar3 = this.mLayoutEnd;
            om omVar2 = ((ConstraintLayout) MotionLayout.this).mLayoutWidget.x0;
            knVar3.x0 = omVar2;
            knVar3.v0.f = omVar2;
            this.mLayoutStart.t0.clear();
            this.mLayoutEnd.t0.clear();
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutStart);
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutEnd);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (enVar != null) {
                    setupConstraintWidget(this.mLayoutStart, enVar);
                }
                setupConstraintWidget(this.mLayoutEnd, enVar2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, enVar2);
                if (enVar != null) {
                    setupConstraintWidget(this.mLayoutStart, enVar);
                }
            }
            this.mLayoutStart.y0 = MotionLayout.this.isRtl();
            kn knVar4 = this.mLayoutStart;
            knVar4.u0.D(knVar4);
            this.mLayoutEnd.y0 = MotionLayout.this.isRtl();
            kn knVar5 = this.mLayoutEnd;
            knVar5.u0.D(knVar5);
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                int i = layoutParams.width;
                in inVar = in.h;
                if (i == -2) {
                    this.mLayoutStart.L(inVar);
                    this.mLayoutEnd.L(inVar);
                }
                if (layoutParams.height == -2) {
                    this.mLayoutStart.M(inVar);
                    this.mLayoutEnd.M(inVar);
                }
            }
        }

        public boolean isNotConfiguredWith(int i, int i2) {
            return (i == this.mStartId && i2 == this.mEndId) ? false : true;
        }

        public void measure(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            computeStartEndSize(i, i2);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                computeStartEndSize(i, i2);
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.r();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.l();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.r();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.l();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.mMeasureDuringTransition = (motionLayout2.mStartWrapWidth == motionLayout2.mEndWrapWidth && motionLayout2.mStartWrapHeight == motionLayout2.mEndWrapHeight) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i3 = motionLayout3.mStartWrapWidth;
            int i4 = motionLayout3.mStartWrapHeight;
            int i5 = motionLayout3.mWidthMeasureMode;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                i3 = (int) ((motionLayout3.mPostInterpolationPosition * (motionLayout3.mEndWrapWidth - i3)) + i3);
            }
            int i6 = i3;
            int i7 = motionLayout3.mHeightMeasureMode;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i4 = (int) ((motionLayout3.mPostInterpolationPosition * (motionLayout3.mEndWrapHeight - i4)) + i4);
            }
            int i8 = i4;
            kn knVar = this.mLayoutStart;
            motionLayout3.resolveMeasuredDimension(i, i2, i6, i8, knVar.H0 || this.mLayoutEnd.H0, knVar.I0 || this.mLayoutEnd.I0);
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i, int i2) {
            this.mStartId = i;
            this.mEndId = i2;
        }
    }

    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    public class StateCache {
        float mProgress = Float.NaN;
        float mVelocity = Float.NaN;
        int mStartState = -1;
        int mEndState = -1;
        final String mKeyProgress = "motion.progress";
        final String mKeyVelocity = "motion.velocity";
        final String mKeyStartState = "motion.StartState";
        final String mKeyEndState = "motion.EndState";

        public StateCache() {
        }

        public void apply() {
            int i = this.mStartState;
            if (i != -1 || this.mEndState != -1) {
                if (i == -1) {
                    MotionLayout.this.transitionToState(this.mEndState);
                } else {
                    int i2 = this.mEndState;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.mVelocity)) {
                if (Float.isNaN(this.mProgress)) {
                    return;
                }
                MotionLayout.this.setProgress(this.mProgress);
            } else {
                MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.mStartState = -1;
                this.mEndState = -1;
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.mStartState);
            bundle.putInt("motion.EndState", this.mEndState);
            return bundle;
        }

        public void recordState() {
            this.mEndState = MotionLayout.this.mEndState;
            this.mStartState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i) {
            this.mEndState = i;
        }

        public void setProgress(float f) {
            this.mProgress = f;
        }

        public void setStartState(int i) {
            this.mStartState = i;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.mStartState = bundle.getInt("motion.StartState");
            this.mEndState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f) {
            this.mVelocity = f;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new oj1();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new cj0();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(null);
    }

    private boolean callTransformedTouchEvent(View view, MotionEvent motionEvent, float f, float f2) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f, f2);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f, -f2);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f, f2);
        if (this.mInverseMatrix == null) {
            this.mInverseMatrix = new Matrix();
        }
        matrix.invert(this.mInverseMatrix);
        motionEventObtain.transform(this.mInverseMatrix);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList<MotionScene.Transition> definedTransitions = this.mScene.getDefinedTransitions();
        int size = definedTransitions.size();
        int i = 0;
        while (i < size) {
            MotionScene.Transition transition = definedTransitions.get(i);
            i++;
            MotionScene.Transition transition2 = transition;
            MotionScene.Transition transition3 = this.mScene.mCurrentTransition;
            checkStructure(transition2);
            int startConstraintSetId = transition2.getStartConstraintSetId();
            int endConstraintSetId = transition2.getEndConstraintSetId();
            Debug.getName(getContext(), startConstraintSetId);
            Debug.getName(getContext(), endConstraintSetId);
            sparseIntArray.get(startConstraintSetId);
            sparseIntArray2.get(endConstraintSetId);
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            this.mScene.getConstraintSet(startConstraintSetId);
            this.mScene.getConstraintSet(endConstraintSetId);
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Debug.getLocation();
            Debug.getName(this);
            Debug.getName(getContext(), this.mCurrentState);
            Debug.getName(childAt);
            childAt.getLeft();
            childAt.getTop();
        }
    }

    private void evaluateLayout() {
        boolean z;
        float fSignum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        float interpolation = this.mTransitionLastPosition + (!(interpolator instanceof oj1) ? (((nanoTime - this.mTransitionLastTime) * fSignum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            interpolation = this.mTransitionGoalPosition;
        }
        if ((fSignum <= 0.0f || interpolation < this.mTransitionGoalPosition) && (fSignum > 0.0f || interpolation > this.mTransitionGoalPosition)) {
            z = false;
        } else {
            interpolation = this.mTransitionGoalPosition;
            z = true;
        }
        if (interpolator != null && !z) {
            interpolation = this.mTemporalInterpolator ? interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.mTransitionGoalPosition) || (fSignum <= 0.0f && interpolation <= this.mTransitionGoalPosition)) {
            interpolation = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.mProgressInterpolator;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        float f = interpolation;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener == null && ((copyOnWriteArrayList = this.mTransitionListeners) == null || copyOnWriteArrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
            return;
        }
        if (this.mListenerState != -1) {
            fireTransitionStarted();
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        float f = this.mTransitionPosition;
        this.mListenerPosition = f;
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionChange(this, this.mBeginState, this.mEndState, f);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
        if (copyOnWriteArrayList2 != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
            while (it.hasNext()) {
                it.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted() {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
        }
    }

    private boolean handlesTouchEvent(float f, float f2, View view, MotionEvent motionEvent) {
        boolean z;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (handlesTouchEvent((r3.getLeft() + f) - view.getScrollX(), (r3.getTop() + f2) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            this.mBoundsCheck.set(f, f2, (view.getRight() + f) - view.getLeft(), (view.getBottom() + f2) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY())) && callTransformedTouchEvent(view, motionEvent, -f, -f2)) {
                return true;
            }
        }
        return z;
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j71.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == j71.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == j71.MotionLayout_currentState) {
                    this.mCurrentState = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == j71.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == j71.MotionLayout_applyMotionScene) {
                    z = typedArrayObtainStyledAttributes.getBoolean(index, z);
                } else if (index == j71.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == j71.MotionLayout_motionDebug) {
                    this.mDebugPath = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (!z) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState != -1 || (motionScene = this.mScene) == null) {
            return;
        }
        this.mCurrentState = motionScene.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
    }

    private void processTransitionCompleted() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.mTransitionListener == null && ((copyOnWriteArrayList = this.mTransitionListeners) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        int i = 0;
        this.mIsAnimating = false;
        ArrayList<Integer> arrayList = this.mTransitionCompleted;
        int size = arrayList.size();
        while (i < size) {
            Integer num = arrayList.get(i);
            i++;
            Integer num2 = num;
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, num2.intValue());
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionCompleted(this, num2.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        int childCount = getChildCount();
        this.mModel.build();
        this.mInTransition = true;
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iGatPathMotionArc = this.mScene.gatPathMotionArc();
        if (iGatPathMotionArc != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i3));
                if (motionController != null) {
                    motionController.setPathMotionArc(iGatPathMotionArc);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.mFrameArrayList.size()];
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i5));
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i4] = motionController2.getAnimateRelativeTo();
                i4++;
            }
        }
        if (this.mDecoratorsHelpers != null) {
            for (int i6 = 0; i6 < i4; i6++) {
                MotionController motionController3 = this.mFrameArrayList.get(findViewById(iArr[i6]));
                if (motionController3 != null) {
                    this.mScene.getKeyFrames(motionController3);
                }
            }
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                MotionHelper motionHelper = arrayList.get(i7);
                i7++;
                motionHelper.onPreSetup(this, this.mFrameArrayList);
            }
            for (int i8 = 0; i8 < i4; i8++) {
                MotionController motionController4 = this.mFrameArrayList.get(findViewById(iArr[i8]));
                if (motionController4 != null) {
                    motionController4.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i9 = 0; i9 < i4; i9++) {
                MotionController motionController5 = this.mFrameArrayList.get(findViewById(iArr[i9]));
                if (motionController5 != null) {
                    this.mScene.getKeyFrames(motionController5);
                    motionController5.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            MotionController motionController6 = this.mFrameArrayList.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.mScene.getKeyFrames(motionController6);
                motionController6.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            boolean z = ((double) staggered) < 0.0d;
            float fAbs = Math.abs(staggered);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMin2 = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController7 = this.mFrameArrayList.get(getChildAt(i11));
                if (!Float.isNaN(motionController7.mMotionStagger)) {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        MotionController motionController8 = this.mFrameArrayList.get(getChildAt(i12));
                        if (!Float.isNaN(motionController8.mMotionStagger)) {
                            fMin = Math.min(fMin, motionController8.mMotionStagger);
                            fMax = Math.max(fMax, motionController8.mMotionStagger);
                        }
                    }
                    while (i < childCount) {
                        MotionController motionController9 = this.mFrameArrayList.get(getChildAt(i));
                        if (!Float.isNaN(motionController9.mMotionStagger)) {
                            motionController9.mStaggerScale = 1.0f / (1.0f - fAbs);
                            if (z) {
                                motionController9.mStaggerOffset = fAbs - (((fMax - motionController9.mMotionStagger) / (fMax - fMin)) * fAbs);
                            } else {
                                motionController9.mStaggerOffset = fAbs - (((motionController9.mMotionStagger - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i++;
                    }
                    return;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                float f = z ? finalY - finalX : finalY + finalX;
                fMin2 = Math.min(fMin2, f);
                fMax2 = Math.max(fMax2, f);
            }
            while (i < childCount) {
                MotionController motionController10 = this.mFrameArrayList.get(getChildAt(i));
                float finalX2 = motionController10.getFinalX();
                float finalY2 = motionController10.getFinalY();
                float f2 = z ? finalY2 - finalX2 : finalY2 + finalX2;
                motionController10.mStaggerScale = 1.0f / (1.0f - fAbs);
                motionController10.mStaggerOffset = fAbs - (((f2 - fMin2) * fAbs) / (fMax2 - fMin2));
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect toRect(jn jnVar) {
        this.mTempRect.top = jnVar.t();
        this.mTempRect.left = jnVar.s();
        Rect rect = this.mTempRect;
        int iR = jnVar.r();
        Rect rect2 = this.mTempRect;
        rect.right = iR + rect2.left;
        int iL = jnVar.l();
        Rect rect3 = this.mTempRect;
        rect2.bottom = iL + rect3.top;
        return rect3;
    }

    private static boolean willJump(float f, float f2, float f3) {
        if (f > 0.0f) {
            float f4 = f / f3;
            return ((f * f4) - (((f3 * f4) * f4) / 2.0f)) + f2 > 1.0f;
        }
        float f5 = (-f) / f3;
        return ((((f3 * f5) * f5) / 2.0f) + (f * f5)) + f2 < 0.0f;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new CopyOnWriteArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    public void animateTo(float f) {
        if (this.mScene == null) {
            return;
        }
        float f2 = this.mTransitionLastPosition;
        float f3 = this.mTransitionPosition;
        if (f2 != f3 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f3;
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 == f) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f4;
        this.mTransitionLastPosition = f4;
        invalidate();
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i, motionController);
        }
        return false;
    }

    public en cloneConstraintSet(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        en constraintSet = motionScene.getConstraintSet(i);
        en enVar = new en();
        enVar.e(constraintSet);
        return enVar;
    }

    public void disableAutoTransition(boolean z) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ViewTransitionController viewTransitionController;
        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
        int i = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                MotionHelper motionHelper = arrayList.get(i2);
                i2++;
                motionHelper.onPreDraw(canvas);
            }
        }
        evaluate(false);
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (viewTransitionController = motionScene.mViewTransitionController) != null) {
            viewTransitionController.animate();
        }
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j = this.mLastDrawTime;
            if (j != -1) {
                if (nanoTime - j > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            StringBuilder sbM = uo.m(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
            sbM.append(Debug.getState(this, this.mEndState));
            sbM.append(" (progress: ");
            sbM.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sbM.append(" ) state=");
            int i3 = this.mCurrentState;
            sbM.append(i3 == -1 ? "undefined" : Debug.getState(this, i3));
            String string = sbM.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new DevModeDraw();
            }
            this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
        ArrayList<MotionHelper> arrayList2 = this.mDecoratorsHelpers;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            while (i < size2) {
                MotionHelper motionHelper2 = arrayList2.get(i);
                i++;
                motionHelper2.onPostDraw(canvas);
            }
        }
    }

    public void enableTransition(int i, boolean z) {
        MotionScene.Transition transition = getTransition(i);
        if (z) {
            transition.setEnabled(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i, boolean z) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.enableViewTransition(i, z);
        }
    }

    public void endTrigger(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i));
            if (motionController != null) {
                motionController.endTrigger(z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9 A[PHI: r5
  0x00e9: PHI (r5v34 float) = (r5v33 float), (r5v35 float), (r5v35 float) binds: [B:47:0x00b3, B:58:0x00dd, B:60:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void evaluate(boolean r21) {
        /*
            Method dump skipped, instruction units count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.evaluate(boolean):void");
    }

    public void fireTransitionCompleted() {
        int iIntValue;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.mTransitionCompleted;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i = this.mCurrentState;
            if (iIntValue != i && i != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i));
            }
        }
        processTransitionCompleted();
        Runnable runnable = this.mOnComplete;
        if (runnable != null) {
            runnable.run();
            this.mOnComplete = null;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null || this.mScheduledTransitions <= 0) {
            return;
        }
        transitionToState(iArr[0]);
        int[] iArr2 = this.mScheduledTransitionTo;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.mScheduledTransitions--;
    }

    public void fireTrigger(int i, boolean z, float f) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z, f);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i, z, f);
            }
        }
    }

    public void getAnchorDpDt(int i, float f, float f2, float f3, float[] fArr) {
        HashMap<View, MotionController> map = this.mFrameArrayList;
        View viewById = getViewById(i);
        MotionController motionController = map.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f, f2, f3, fArr);
            float y = viewById.getY();
            this.mLastPos = f;
            this.mLastY = y;
            return;
        }
        if (viewById == null) {
            new StringBuilder("").append(i);
        } else {
            viewById.getContext().getResources().getResourceName(i);
        }
    }

    public en getConstraintSet(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public String getConstraintSetNames(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public int[] getMatchingConstraintSetIds(String... strArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getMatchingStateLabels(strArr);
    }

    public MotionController getMotionController(int i) {
        return this.mFrameArrayList.get(findViewById(i));
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i) {
        return this.mScene.getTransitionById(i);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = r0.getDuration() / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArr, int i) {
        float interpolation;
        float[] fArr2;
        float velocity = this.mLastVelocity;
        float f3 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float fSignum = Math.signum(this.mTransitionGoalPosition - f3);
            float interpolation2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            velocity = (((interpolation2 - interpolation) / EPSILON) * fSignum) / this.mTransitionDuration;
        } else {
            interpolation = f3;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            velocity = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i & 1) == 0) {
            fArr2 = fArr;
            motionController.getPostLayoutDvDp(interpolation, view.getWidth(), view.getHeight(), f, f2, fArr2);
        } else {
            fArr2 = fArr;
            motionController.getDpDt(interpolation, f, f2, fArr2);
        }
        if (i < 2) {
            fArr2[0] = fArr2[0] * velocity;
            fArr2[1] = fArr2[1] * velocity;
        }
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public boolean isViewTransitionEnabled(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i);
        }
        return false;
    }

    public void jumpToState(int i) {
        if (!isAttachedToWindow()) {
            this.mCurrentState = i;
        }
        if (this.mBeginState == i) {
            setProgress(0.0f);
        } else if (this.mEndState == i) {
            setProgress(1.0f);
        } else {
            setTransition(i, i);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        MotionScene.Transition transition;
        if (i == 0) {
            this.mScene = null;
            return;
        }
        try {
            MotionScene motionScene = new MotionScene(getContext(), this, i);
            this.mScene = motionScene;
            if (this.mCurrentState == -1) {
                this.mCurrentState = motionScene.getStartId();
                this.mBeginState = this.mScene.getStartId();
                this.mEndState = this.mScene.getEndId();
            }
            if (!isAttachedToWindow()) {
                this.mScene = null;
                return;
            }
            try {
                Display display = getDisplay();
                int i2 = 0;
                this.mPreviouseRotation = display == null ? 0 : display.getRotation();
                MotionScene motionScene2 = this.mScene;
                if (motionScene2 != null) {
                    en constraintSet = motionScene2.getConstraintSet(this.mCurrentState);
                    this.mScene.readFallback(this);
                    ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        while (i2 < size) {
                            MotionHelper motionHelper = arrayList.get(i2);
                            i2++;
                            motionHelper.onFinishedMotionScene(this);
                        }
                    }
                    if (constraintSet != null) {
                        constraintSet.b(this);
                    }
                    this.mBeginState = this.mCurrentState;
                }
                onNewStateAttachHandlers();
                StateCache stateCache = this.mStateCache;
                if (stateCache != null) {
                    if (this.mDelayedApply) {
                        post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MotionLayout.this.mStateCache.apply();
                            }
                        });
                        return;
                    } else {
                        stateCache.apply();
                        return;
                    }
                }
                MotionScene motionScene3 = this.mScene;
                if (motionScene3 == null || (transition = motionScene3.mCurrentTransition) == null || transition.getAutoTransition() != 4) {
                    return;
                }
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e);
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e2);
        }
    }

    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.mPreviouseRotation = display.getRotation();
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (i = this.mCurrentState) != -1) {
            en constraintSet = motionScene.getConstraintSet(i);
            this.mScene.readFallback(this);
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            if (arrayList != null) {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    MotionHelper motionHelper = arrayList.get(i2);
                    i2++;
                    motionHelper.onFinishedMotionScene(this);
                }
            }
            if (constraintSet != null) {
                constraintSet.b(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            if (this.mDelayedApply) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.mStateCache.apply();
                    }
                });
                return;
            } else {
                stateCache.apply();
                return;
            }
        }
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 == null || (transition = motionScene2.mCurrentTransition) == null || transition.getAutoTransition() != 4) {
            return;
        }
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled) {
            ViewTransitionController viewTransitionController = motionScene.mViewTransitionController;
            if (viewTransitionController != null) {
                viewTransitionController.touchEvent(motionEvent);
            }
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
                View view = this.mRegionView;
                if (view == null || view.getId() != touchRegionId) {
                    this.mRegionView = findViewById(touchRegionId);
                }
                if (this.mRegionView != null) {
                    this.mBoundsCheck.set(r0.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) throws Throwable {
        MotionLayout motionLayout;
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z, i, i2, i3, i4);
                this.mInLayout = false;
                return;
            }
            motionLayout = this;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            try {
                if (motionLayout.mLastLayoutWidth != i5 || motionLayout.mLastLayoutHeight != i6) {
                    rebuildScene();
                    evaluate(true);
                }
                motionLayout.mLastLayoutWidth = i5;
                motionLayout.mLastLayoutHeight = i6;
                motionLayout.mOldWidth = i5;
                motionLayout.mOldHeight = i6;
                motionLayout.mInLayout = false;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            motionLayout = this;
        }
        Throwable th3 = th;
        motionLayout.mInLayout = false;
        throw th3;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mScene == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z = false;
        boolean z2 = (this.mLastWidthMeasureSpec == i && this.mLastHeightMeasureSpec == i2) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z2 = true;
        }
        if (this.mDirtyHierarchy) {
            z2 = true;
        }
        this.mLastWidthMeasureSpec = i;
        this.mLastHeightMeasureSpec = i2;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z2 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i, i2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            if (z2) {
                super.onMeasure(i, i2);
            }
            z = true;
        }
        if (this.mMeasureDuringTransition || z) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int iR = this.mLayoutWidget.r() + getPaddingRight() + getPaddingLeft();
            int iL = this.mLayoutWidget.l() + paddingBottom;
            int i3 = this.mWidthMeasureMode;
            if (i3 == Integer.MIN_VALUE || i3 == 0) {
                iR = (int) ((this.mPostInterpolationPosition * (this.mEndWrapWidth - r8)) + this.mStartWrapWidth);
                requestLayout();
            }
            int i4 = this.mHeightMeasureMode;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                iL = (int) ((this.mPostInterpolationPosition * (this.mEndWrapHeight - r9)) + this.mStartWrapHeight);
                requestLayout();
            }
            setMeasuredDimension(iR, iL);
        }
        evaluateLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // defpackage.ww0
    public void onNestedPreScroll(final View view, int i, int i2, int[] iArr, int i3) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        int i4 = -1;
        if (!transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view.getId() == touchRegionId) {
            if (motionScene.getMoveWhenScrollAtTop()) {
                TouchResponse touchResponse2 = transition.getTouchResponse();
                if (touchResponse2 != null && (touchResponse2.getFlags() & 4) != 0) {
                    i4 = i2;
                }
                float f = this.mTransitionPosition;
                if ((f == 1.0f || f == 0.0f) && view.canScrollVertically(i4)) {
                    return;
                }
            }
            if (transition.getTouchResponse() != null && (transition.getTouchResponse().getFlags() & 1) != 0) {
                float progressDirection = motionScene.getProgressDirection(i, i2);
                float f2 = this.mTransitionLastPosition;
                if ((f2 <= 0.0f && progressDirection < 0.0f) || (f2 >= 1.0f && progressDirection > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f3 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f4 = i;
            this.mScrollTargetDX = f4;
            float f5 = i2;
            this.mScrollTargetDY = f5;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            motionScene.processScrollMove(f4, f5);
            if (f3 != this.mTransitionPosition) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // defpackage.ww0
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // defpackage.ww0
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    public void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i = this.mCurrentState;
        if (i != -1) {
            this.mScene.addOnClickListeners(this, i);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // defpackage.ww0
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        return (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) ? false : true;
    }

    @Override // defpackage.ww0
    public void onStopNestedScroll(View view, int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f = this.mScrollTargetDT;
            if (f == 0.0f) {
                return;
            }
            motionScene.processScrollUp(this.mScrollTargetDX / f, this.mScrollTargetDY / f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        if (this.mScene.mCurrentTransition.isTransitionFlag(4)) {
            return this.mScene.mCurrentTransition.getTouchResponse().isDragStarted();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && (transition = motionScene.mCurrentTransition) != null) {
            int layoutDuringTransition = transition.getLayoutDuringTransition();
            if (layoutDuringTransition == 0) {
                return;
            }
            if (layoutDuringTransition == 2) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    this.mFrameArrayList.get(getChildAt(i)).remeasure();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i, int i2) {
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int rotation = getDisplay().getRotation();
        this.mRotatMode = (rotation + 1) % 4 <= (this.mPreviouseRotation + 1) % 4 ? 2 : 1;
        this.mPreviouseRotation = rotation;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            iu1 iu1Var = this.mPreRotate.get(childAt);
            if (iu1Var == null) {
                iu1Var = new iu1();
                this.mPreRotate.put(childAt, iu1Var);
            }
            iu1Var.b = childAt.getLeft();
            iu1Var.c = childAt.getTop();
            iu1Var.d = childAt.getRight();
            iu1Var.e = childAt.getBottom();
            iu1Var.a = childAt.getRotation();
        }
        this.mBeginState = -1;
        this.mEndState = i;
        this.mScene.setTransition(-1, i);
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MotionLayout.this.mInRotation = false;
            }
        });
        if (i2 > 0) {
            this.mTransitionDuration = i2 / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i) {
        if (getCurrentState() == -1) {
            transitionToState(i);
            return;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null) {
            this.mScheduledTransitionTo = new int[4];
        } else if (iArr.length <= this.mScheduledTransitions) {
            this.mScheduledTransitionTo = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mScheduledTransitionTo;
        int i2 = this.mScheduledTransitions;
        this.mScheduledTransitions = i2 + 1;
        iArr2[i2] = i;
    }

    public void setDebugMode(int i) {
        this.mDebugPath = i;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.mDelayedApply = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.mInteractionEnabled = z;
    }

    public void setInterpolatedProgress(float f) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnHideHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnShowHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setProgress(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f);
            this.mStateCache.setVelocity(f2);
            return;
        }
        setProgress(f);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f2;
        if (f2 != 0.0f) {
            animateTo(f2 <= 0.0f ? 0.0f : 1.0f);
        } else {
            if (f == 0.0f || f == 1.0f) {
                return;
            }
            animateTo(f <= 0.5f ? 0.0f : 1.0f);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    public void setStartState(int i) {
        if (isAttachedToWindow()) {
            this.mCurrentState = i;
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setStartState(i);
        this.mStateCache.setEndState(i);
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState3 = this.mTransitionState;
        this.mTransitionState = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            fireTransitionChange();
        }
        int iOrdinal = transitionState3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && transitionState == transitionState2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            fireTransitionChange();
        }
        if (transitionState == transitionState2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i);
            this.mStateCache.setEndState(i2);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i;
            this.mEndState = i2;
            motionScene.setTransition(i, i2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i), this.mScene.getConstraintSet(i2));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.setDuration(i);
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void touchAnimateTo(int r10, float r11, float r12) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f, float f2) {
        if (this.mScene == null || this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        this.mStopLogic.b(this.mTransitionLastPosition, f, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
        int i = this.mCurrentState;
        this.mTransitionGoalPosition = f;
        this.mCurrentState = i;
        this.mInterpolator = this.mStopLogic;
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i) {
        if (isAttachedToWindow()) {
            transitionToState(i, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setEndState(i);
    }

    public void updateState(int i, en enVar) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i, enVar);
        }
        updateState();
        if (this.mCurrentState == i) {
            enVar.b(this);
        }
    }

    public void updateStateAnimate(int i, en enVar, int i2) {
        if (this.mScene != null && this.mCurrentState == i) {
            updateState(x51.view_transition, getConstraintSet(i));
            setState(x51.view_transition, -1, -1);
            updateState(i, enVar);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.mScene, x51.view_transition, i);
            transition.setDuration(i2);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i, View... viewArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.viewTransition(i, viewArr);
        }
    }

    public static class MyTracker implements MotionTracker {
        private static MyTracker sMe = new MyTracker();
        VelocityTracker mTracker;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            sMe.mTracker = VelocityTracker.obtain();
            return sMe;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mTracker = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i, float f) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i, f);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i) {
            if (this.mTracker != null) {
                return getYVelocity(i);
            }
            return 0.0f;
        }
    }

    @Override // defpackage.xw0
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.mUndergoingMotion || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.mUndergoingMotion = false;
    }

    public void transitionToStart(Runnable runnable) {
        animateTo(0.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToEnd(Runnable runnable) {
        animateTo(1.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToState(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i);
            return;
        }
        transitionToState(i, -1, -1, i2);
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i;
        this.mBeginState = -1;
        this.mEndState = -1;
        sm smVar = this.mConstraintLayoutSpec;
        if (smVar != null) {
            smVar.b(i, i2, i3);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i).b(this);
        }
    }

    public void setProgress(float f) {
        if (f >= 0.0f) {
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f);
            return;
        }
        if (f <= 0.0f) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f;
        this.mTransitionPosition = f;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    public void transitionToState(int i, int i2, int i3) {
        transitionToState(i, i2, i3, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void transitionToState(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.transitionToState(int, int, int, int):void");
    }

    public void setTransition(int i) {
        float f;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i2 = this.mCurrentState;
            if (i2 == this.mBeginState) {
                f = 0.0f;
            } else {
                f = i2 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (this.mTransitionLastPosition != f) {
                if (f == 0.0f) {
                    endTrigger(true);
                    this.mScene.getConstraintSet(this.mBeginState).b(this);
                } else if (f == 1.0f) {
                    endTrigger(false);
                    this.mScene.getConstraintSet(this.mEndState).b(this);
                }
            }
            this.mTransitionLastPosition = Float.isNaN(f) ? 0.0f : f;
            if (Float.isNaN(f)) {
                Debug.getLocation();
                transitionToStart();
            } else {
                setProgress(f);
            }
        }
    }

    private void checkStructure(int i, en enVar) {
        Debug.getName(getContext(), i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (enVar.l(childAt.getId()) == null) {
                Debug.getName(childAt);
            }
        }
        Integer[] numArr = (Integer[]) enVar.g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            Debug.getName(getContext(), i5);
            findViewById(iArr[i4]);
            int i6 = enVar.k(i5).e.d;
            int i7 = enVar.k(i5).e.c;
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        transition.getStartConstraintSetId();
        transition.getEndConstraintSetId();
    }

    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId == this.mBeginState && endId == this.mEndState) {
            return;
        }
        this.mBeginState = startId;
        this.mEndState = endId;
        this.mScene.setTransition(startId, endId);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new oj1();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new cj0();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new oj1();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new cj0();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap<>();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }
}
