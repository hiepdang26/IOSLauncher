package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import defpackage.hm;
import defpackage.hu1;
import defpackage.j71;
import defpackage.lu1;
import defpackage.ou1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyTimeCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;
    private int mWaveShape = 0;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static final int WAVE_OFFSET = 21;
        private static final int WAVE_PERIOD = 20;
        private static final int WAVE_SHAPE = 19;
        private static SparseIntArray sAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sAttrMap = sparseIntArray;
            sparseIntArray.append(j71.KeyTimeCycle_android_alpha, 1);
            sAttrMap.append(j71.KeyTimeCycle_android_elevation, 2);
            sAttrMap.append(j71.KeyTimeCycle_android_rotation, 4);
            sAttrMap.append(j71.KeyTimeCycle_android_rotationX, 5);
            sAttrMap.append(j71.KeyTimeCycle_android_rotationY, 6);
            sAttrMap.append(j71.KeyTimeCycle_android_scaleX, 7);
            sAttrMap.append(j71.KeyTimeCycle_transitionPathRotate, 8);
            sAttrMap.append(j71.KeyTimeCycle_transitionEasing, 9);
            sAttrMap.append(j71.KeyTimeCycle_motionTarget, 10);
            sAttrMap.append(j71.KeyTimeCycle_framePosition, 12);
            sAttrMap.append(j71.KeyTimeCycle_curveFit, 13);
            sAttrMap.append(j71.KeyTimeCycle_android_scaleY, 14);
            sAttrMap.append(j71.KeyTimeCycle_android_translationX, 15);
            sAttrMap.append(j71.KeyTimeCycle_android_translationY, 16);
            sAttrMap.append(j71.KeyTimeCycle_android_translationZ, 17);
            sAttrMap.append(j71.KeyTimeCycle_motionProgress, 18);
            sAttrMap.append(j71.KeyTimeCycle_wavePeriod, 20);
            sAttrMap.append(j71.KeyTimeCycle_waveOffset, 21);
            sAttrMap.append(j71.KeyTimeCycle_waveShape, 19);
        }

        private Loader() {
        }

        public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (sAttrMap.get(index)) {
                    case 1:
                        keyTimeCycle.mAlpha = typedArray.getFloat(index, keyTimeCycle.mAlpha);
                        break;
                    case 2:
                        keyTimeCycle.mElevation = typedArray.getDimension(index, keyTimeCycle.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Integer.toHexString(index);
                        sAttrMap.get(index);
                        break;
                    case 4:
                        keyTimeCycle.mRotation = typedArray.getFloat(index, keyTimeCycle.mRotation);
                        break;
                    case 5:
                        keyTimeCycle.mRotationX = typedArray.getFloat(index, keyTimeCycle.mRotationX);
                        break;
                    case 6:
                        keyTimeCycle.mRotationY = typedArray.getFloat(index, keyTimeCycle.mRotationY);
                        break;
                    case 7:
                        keyTimeCycle.mScaleX = typedArray.getFloat(index, keyTimeCycle.mScaleX);
                        break;
                    case 8:
                        keyTimeCycle.mTransitionPathRotate = typedArray.getFloat(index, keyTimeCycle.mTransitionPathRotate);
                        break;
                    case 9:
                        keyTimeCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                            keyTimeCycle.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTimeCycle.mTargetString = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.mTargetString = typedArray.getString(index);
                        } else {
                            keyTimeCycle.mTargetId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                        }
                        break;
                    case 12:
                        keyTimeCycle.mFramePosition = typedArray.getInt(index, keyTimeCycle.mFramePosition);
                        break;
                    case 13:
                        keyTimeCycle.mCurveFit = typedArray.getInteger(index, keyTimeCycle.mCurveFit);
                        break;
                    case 14:
                        keyTimeCycle.mScaleY = typedArray.getFloat(index, keyTimeCycle.mScaleY);
                        break;
                    case 15:
                        keyTimeCycle.mTranslationX = typedArray.getDimension(index, keyTimeCycle.mTranslationX);
                        break;
                    case 16:
                        keyTimeCycle.mTranslationY = typedArray.getDimension(index, keyTimeCycle.mTranslationY);
                        break;
                    case 17:
                        keyTimeCycle.mTranslationZ = typedArray.getDimension(index, keyTimeCycle.mTranslationZ);
                        break;
                    case 18:
                        keyTimeCycle.mProgress = typedArray.getFloat(index, keyTimeCycle.mProgress);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.mCustomWaveShape = typedArray.getString(index);
                            keyTimeCycle.mWaveShape = 7;
                        } else {
                            keyTimeCycle.mWaveShape = typedArray.getInt(index, keyTimeCycle.mWaveShape);
                        }
                        break;
                    case 20:
                        keyTimeCycle.mWavePeriod = typedArray.getFloat(index, keyTimeCycle.mWavePeriod);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            keyTimeCycle.mWaveOffset = typedArray.getDimension(index, keyTimeCycle.mWaveOffset);
                        } else {
                            keyTimeCycle.mWaveOffset = typedArray.getFloat(index, keyTimeCycle.mWaveOffset);
                        }
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addTimeValues(HashMap<String, ou1> map) {
        for (String str : map.keySet()) {
            ou1 ou1Var = map.get(str);
            if (ou1Var != null) {
                if (!str.startsWith(Key.CUSTOM)) {
                    switch (str) {
                        case "rotationX":
                            if (Float.isNaN(this.mRotationX)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "rotationY":
                            if (Float.isNaN(this.mRotationY)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "translationX":
                            if (Float.isNaN(this.mTranslationX)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "translationY":
                            if (Float.isNaN(this.mTranslationY)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "translationZ":
                            if (Float.isNaN(this.mTranslationZ)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "progress":
                            if (Float.isNaN(this.mProgress)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "scaleX":
                            if (Float.isNaN(this.mScaleX)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "scaleY":
                            if (Float.isNaN(this.mScaleY)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "rotation":
                            if (Float.isNaN(this.mRotation)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "elevation":
                            if (Float.isNaN(this.mElevation)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "transitionPathRotate":
                            if (Float.isNaN(this.mTransitionPathRotate)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                        case "alpha":
                            if (Float.isNaN(this.mAlpha)) {
                                break;
                            } else {
                                ou1Var.c(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                            break;
                    }
                } else {
                    hm hmVar = this.mCustomConstraints.get(str.substring(7));
                    if (hmVar != null) {
                        lu1 lu1Var = (lu1) ou1Var;
                        int i = this.mFramePosition;
                        float f = this.mWavePeriod;
                        int i2 = this.mWaveShape;
                        float f2 = this.mWaveOffset;
                        lu1Var.l.append(i, hmVar);
                        lu1Var.m.append(i, new float[]{f, f2});
                        lu1Var.b = Math.max(lu1Var.b, i2);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, hu1> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.mTransitionEasing = keyTimeCycle.mTransitionEasing;
        this.mCurveFit = keyTimeCycle.mCurveFit;
        this.mWaveShape = keyTimeCycle.mWaveShape;
        this.mWavePeriod = keyTimeCycle.mWavePeriod;
        this.mWaveOffset = keyTimeCycle.mWaveOffset;
        this.mProgress = keyTimeCycle.mProgress;
        this.mAlpha = keyTimeCycle.mAlpha;
        this.mElevation = keyTimeCycle.mElevation;
        this.mRotation = keyTimeCycle.mRotation;
        this.mTransitionPathRotate = keyTimeCycle.mTransitionPathRotate;
        this.mRotationX = keyTimeCycle.mRotationX;
        this.mRotationY = keyTimeCycle.mRotationY;
        this.mScaleX = keyTimeCycle.mScaleX;
        this.mScaleY = keyTimeCycle.mScaleY;
        this.mTranslationX = keyTimeCycle.mTranslationX;
        this.mTranslationY = keyTimeCycle.mTranslationY;
        this.mTranslationZ = keyTimeCycle.mTranslationZ;
        this.mCustomWaveShape = keyTimeCycle.mCustomWaveShape;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add(Key.PROGRESS);
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, j71.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> map) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            map.put(Key.ALPHA, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            map.put(Key.ELEVATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            map.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            map.put(Key.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            map.put(Key.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            map.put(Key.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            map.put(Key.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            map.put(Key.TRANSLATION_Z, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            map.put(Key.TRANSITION_PATH_ROTATE, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            map.put(Key.PROGRESS, Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.getClass();
        switch (str) {
            case "motionProgress":
                this.mProgress = toFloat(obj);
                break;
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "rotationX":
                this.mRotationX = toFloat(obj);
                break;
            case "rotationY":
                this.mRotationY = toFloat(obj);
                break;
            case "translationX":
                this.mTranslationX = toFloat(obj);
                break;
            case "translationY":
                this.mTranslationY = toFloat(obj);
                break;
            case "translationZ":
                this.mTranslationZ = toFloat(obj);
                break;
            case "scaleX":
                this.mScaleX = toFloat(obj);
                break;
            case "scaleY":
                this.mScaleY = toFloat(obj);
                break;
            case "rotation":
                this.mRotation = toFloat(obj);
                break;
            case "elevation":
                this.mElevation = toFloat(obj);
                break;
            case "transitionPathRotate":
                this.mTransitionPathRotate = toFloat(obj);
                break;
            case "alpha":
                this.mAlpha = toFloat(obj);
                break;
            case "waveOffset":
                this.mWaveOffset = toFloat(obj);
                break;
            case "wavePeriod":
                this.mWavePeriod = toFloat(obj);
                break;
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "waveShape":
                if (!(obj instanceof Integer)) {
                    this.mWaveShape = 7;
                    this.mCustomWaveShape = obj.toString();
                    break;
                } else {
                    this.mWaveShape = toInt(obj);
                    break;
                }
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public Key mo0clone() {
        return new KeyTimeCycle().copy(this);
    }
}
