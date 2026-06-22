package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.a;
import defpackage.an;
import defpackage.bn;
import defpackage.cn;
import defpackage.dn;
import defpackage.en;
import defpackage.fj1;
import defpackage.fy;
import defpackage.hm;
import defpackage.j71;
import defpackage.k31;
import defpackage.nm;
import defpackage.uo;
import defpackage.x51;
import defpackage.zm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DESKTOP = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;
    fj1 mStateSet = null;
    Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<en> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
    }

    private int getId(Context context, String str) {
        int identifier = str.contains("/") ? context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName()) : -1;
        return (identifier != -1 || str.length() <= 1) ? identifier : Integer.parseInt(str.substring(1));
    }

    private int getIndex(Transition transition) {
        int i = transition.mId;
        if (i == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i2 = 0; i2 < this.mTransitionList.size(); i2++) {
            if (this.mTransitionList.get(i2).mId == i) {
                return i2;
            }
        }
        return -1;
    }

    public static String getLine(Context context, int i, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    private int getRealID(int i) {
        int iA;
        fj1 fj1Var = this.mStateSet;
        return (fj1Var == null || (iA = fj1Var.a(i, -1, -1)) == -1) ? i : iA;
    }

    private boolean hasCycleDependency(int i) {
        int i2 = this.mDeriveMap.get(i);
        int size = this.mDeriveMap.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.mDeriveMap.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void load(android.content.Context r8, int r9) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.load(android.content.Context, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseConstraintSet(android.content.Context r18, org.xmlpull.v1.XmlPullParser r19) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j71.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == j71.include_constraintSet) {
                parseInclude(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j71.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == j71.MotionScene_defaultDuration) {
                int i2 = typedArrayObtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i2;
                if (i2 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == j71.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i, MotionLayout motionLayout) {
        en enVar = this.mConstraintSetMap.get(i);
        enVar.b = enVar.a;
        int i2 = this.mDeriveMap.get(i);
        HashMap map = enVar.g;
        if (i2 > 0) {
            readConstraintChain(i2, motionLayout);
            en enVar2 = this.mConstraintSetMap.get(i2);
            if (enVar2 == null) {
                Debug.getName(this.mMotionLayout.getContext(), i2);
                return;
            }
            enVar.b += "/" + enVar2.b;
            HashMap map2 = enVar2.g;
            for (Integer num : map2.keySet()) {
                num.getClass();
                zm zmVar = (zm) map2.get(num);
                if (!map.containsKey(num)) {
                    map.put(num, new zm());
                }
                zm zmVar2 = (zm) map.get(num);
                if (zmVar2 != null) {
                    an anVar = zmVar2.e;
                    if (!anVar.b) {
                        anVar.a(zmVar.e);
                    }
                    cn cnVar = zmVar2.c;
                    if (!cnVar.a) {
                        cn cnVar2 = zmVar.c;
                        cnVar.a = cnVar2.a;
                        cnVar.b = cnVar2.b;
                        cnVar.d = cnVar2.d;
                        cnVar.e = cnVar2.e;
                        cnVar.c = cnVar2.c;
                    }
                    dn dnVar = zmVar2.f;
                    if (!dnVar.a) {
                        dnVar.a(zmVar.f);
                    }
                    bn bnVar = zmVar2.d;
                    if (!bnVar.a) {
                        bnVar.a(zmVar.d);
                    }
                    for (String str : zmVar.g.keySet()) {
                        if (!zmVar2.g.containsKey(str)) {
                            zmVar2.g.put(str, (hm) zmVar.g.get(str));
                        }
                    }
                }
            }
        } else {
            enVar.b = uo.k(new StringBuilder(), enVar.b, "  layout");
            int childCount = motionLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = motionLayout.getChildAt(i3);
                nm nmVar = (nm) childAt.getLayoutParams();
                int id = childAt.getId();
                if (enVar.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!map.containsKey(Integer.valueOf(id))) {
                    map.put(Integer.valueOf(id), new zm());
                }
                zm zmVar3 = (zm) map.get(Integer.valueOf(id));
                if (zmVar3 != null) {
                    an anVar2 = zmVar3.e;
                    if (!anVar2.b) {
                        zm.a(zmVar3, id, nmVar);
                        if (childAt instanceof a) {
                            anVar2.j0 = ((a) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                anVar2.o0 = barrier.getAllowsGoneWidget();
                                anVar2.g0 = barrier.getType();
                                anVar2.h0 = barrier.getMargin();
                            }
                        }
                        anVar2.b = true;
                    }
                    cn cnVar3 = zmVar3.c;
                    if (!cnVar3.a) {
                        cnVar3.b = childAt.getVisibility();
                        cnVar3.d = childAt.getAlpha();
                        cnVar3.a = true;
                    }
                    dn dnVar2 = zmVar3.f;
                    if (!dnVar2.a) {
                        dnVar2.a = true;
                        dnVar2.b = childAt.getRotation();
                        dnVar2.c = childAt.getRotationX();
                        dnVar2.d = childAt.getRotationY();
                        dnVar2.e = childAt.getScaleX();
                        dnVar2.f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != 0.0d || pivotY != 0.0d) {
                            dnVar2.g = pivotX;
                            dnVar2.h = pivotY;
                        }
                        dnVar2.j = childAt.getTranslationX();
                        dnVar2.k = childAt.getTranslationY();
                        dnVar2.l = childAt.getTranslationZ();
                        if (dnVar2.m) {
                            dnVar2.n = childAt.getElevation();
                        }
                    }
                }
            }
        }
        for (zm zmVar4 : map.values()) {
            if (zmVar4.h != null) {
                if (zmVar4.b == null) {
                    zmVar4.h.e(enVar.l(zmVar4.a));
                } else {
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        zm zmVarL = enVar.l(((Integer) it.next()).intValue());
                        String str2 = zmVarL.e.l0;
                        if (str2 != null && zmVar4.b.matches(str2)) {
                            zmVar4.h.e(zmVarL);
                            zmVarL.g.putAll((HashMap) zmVar4.g.clone());
                        }
                    }
                }
            }
        }
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Transition transition = arrayList.get(i2);
            i2++;
            Transition transition2 = transition;
            if (transition2.mOnClicks.size() > 0) {
                ArrayList arrayList2 = transition2.mOnClicks;
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    ((Transition.TransitionOnClick) obj).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList3 = this.mAbstractTransitionList;
        int size3 = arrayList3.size();
        int i4 = 0;
        while (i4 < size3) {
            Transition transition3 = arrayList3.get(i4);
            i4++;
            Transition transition4 = transition3;
            if (transition4.mOnClicks.size() > 0) {
                ArrayList arrayList4 = transition4.mOnClicks;
                int size4 = arrayList4.size();
                int i5 = 0;
                while (i5 < size4) {
                    Object obj2 = arrayList4.get(i5);
                    i5++;
                    ((Transition.TransitionOnClick) obj2).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList5 = this.mTransitionList;
        int size5 = arrayList5.size();
        int i6 = 0;
        while (i6 < size5) {
            Transition transition5 = arrayList5.get(i6);
            i6++;
            Transition transition6 = transition5;
            if (transition6.mOnClicks.size() > 0) {
                ArrayList arrayList6 = transition6.mOnClicks;
                int size6 = arrayList6.size();
                int i7 = 0;
                while (i7 < size6) {
                    Object obj3 = arrayList6.get(i7);
                    i7++;
                    ((Transition.TransitionOnClick) obj3).addOnClickListeners(motionLayout, i, transition6);
                }
            }
        }
        ArrayList<Transition> arrayList7 = this.mAbstractTransitionList;
        int size7 = arrayList7.size();
        int i8 = 0;
        while (i8 < size7) {
            Transition transition7 = arrayList7.get(i8);
            i8++;
            Transition transition8 = transition7;
            if (transition8.mOnClicks.size() > 0) {
                ArrayList arrayList8 = transition8.mOnClicks;
                int size8 = arrayList8.size();
                int i9 = 0;
                while (i9 < size8) {
                    Object obj4 = arrayList8.get(i9);
                    i9++;
                    ((Transition.TransitionOnClick) obj4).addOnClickListeners(motionLayout, i, transition8);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(i, motionController);
    }

    public boolean autoTransition(MotionLayout motionLayout, int i) {
        Transition transition;
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Transition transition2 = arrayList.get(i2);
            i2++;
            Transition transition3 = transition2;
            if (transition3.mAutoTransition != 0 && ((transition = this.mCurrentTransition) != transition3 || !transition.isTransitionFlag(2))) {
                if (i == transition3.mConstraintSetStart && (transition3.mAutoTransition == 4 || transition3.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i == transition3.mConstraintSetEnd && (transition3.mAutoTransition == 3 || transition3.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        if (i == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i);
        RectF rectF = new RectF();
        float f3 = 0.0f;
        Transition transition = null;
        for (Transition transition2 : transitionsWithState) {
            if (!transition2.mDisable && transition2.mTouchResponse != null) {
                transition2.mTouchResponse.setRTL(this.mRtl);
                RectF touchRegion = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF limitBoundsTo = transition2.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo == null || motionEvent == null || limitBoundsTo.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fDot = transition2.mTouchResponse.dot(f, f2);
                        if (transition2.mTouchResponse.mIsRotateMode && motionEvent != null) {
                            fDot = ((float) (Math.atan2(f2 + r10, f + r9) - Math.atan2(motionEvent.getX() - transition2.mTouchResponse.mRotateCenterX, motionEvent.getY() - transition2.mTouchResponse.mRotateCenterY))) * 10.0f;
                        }
                        float f4 = fDot * (transition2.mConstraintSetEnd == i ? -1.0f : 1.1f);
                        if (f4 > f3) {
                            transition = transition2;
                            f3 = f4;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z) {
        this.mDisableAutoTransition = z;
    }

    public void enableViewTransition(int i, boolean z) {
        this.mViewTransitionController.enableViewTransition(i, z);
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public int getAutoCompleteMode() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getAutoCompleteMode();
    }

    public en getConstraintSet(Context context, String str) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i);
            if (str.equals(context.getResources().getResourceName(iKeyAt))) {
                return this.mConstraintSetMap.get(iKeyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        return transition != null ? transition.mDuration : this.mDefaultDuration;
    }

    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        int i = this.mCurrentTransition.mDefaultInterpolator;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (i == -1) {
            final fy fyVarC = fy.c(this.mCurrentTransition.mDefaultInterpolatorString);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
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
        if (i == 5) {
            return new OvershootInterpolator();
        }
        if (i != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public Key getKeyFrame(Context context, int i, int i2, int i3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        ArrayList arrayList = transition.mKeyFramesList;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            KeyFrames keyFrames = (KeyFrames) obj;
            for (Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(num.intValue());
                    int size2 = keyFramesForView.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Key key = keyFramesForView.get(i5);
                        i5++;
                        Key key2 = key;
                        if (key2.mFramePosition == i3 && key2.mType == i) {
                            return key2;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        int i = 0;
        if (transition != null) {
            ArrayList arrayList = transition.mKeyFramesList;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((KeyFrames) obj).addFrames(motionController);
            }
            return;
        }
        Transition transition2 = this.mDefaultTransition;
        if (transition2 != null) {
            ArrayList arrayList2 = transition2.mKeyFramesList;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((KeyFrames) obj2).addFrames(motionController);
            }
        }
    }

    public int[] getMatchingStateLabels(String... strArr) {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            en enVarValueAt = this.mConstraintSetMap.valueAt(i2);
            int iKeyAt = this.mConstraintSetMap.keyAt(i2);
            enVarValueAt.getClass();
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    String[] strArr2 = enVarValueAt.c;
                    iArr[i] = iKeyAt;
                    i++;
                    break;
                }
                String str = strArr[i3];
                for (String str2 : enVarValueAt.c) {
                    if (str2.equals(str)) {
                        break;
                    }
                }
                i3++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i) {
        return 0.0f;
    }

    public float getProgressDirection(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f, f2);
    }

    public int getSpringBoundary() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringBoundary();
    }

    public float getSpringDamping() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringDamping();
    }

    public float getSpringMass() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringMass();
    }

    public float getSpringStiffiness() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStiffness();
    }

    public float getSpringStopThreshold() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Transition transition = arrayList.get(i2);
            i2++;
            Transition transition2 = transition;
            if (transition2.mId == i) {
                return transition2;
            }
        }
        return null;
    }

    public int getTransitionDirection(int i) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Transition transition = arrayList.get(i2);
            i2++;
            if (transition.mConstraintSetStart == i) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i) {
        int realID = getRealID(i);
        ArrayList arrayList = new ArrayList();
        ArrayList<Transition> arrayList2 = this.mTransitionList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Transition transition = arrayList2.get(i2);
            i2++;
            Transition transition2 = transition;
            if (transition2.mConstraintSetStart == realID || transition2.mConstraintSetEnd == realID) {
                arrayList.add(transition2);
            }
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(View view, int i) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        ArrayList arrayList = transition.mKeyFramesList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ArrayList<Key> keyFramesForView = ((KeyFrames) obj).getKeyFramesForView(view.getId());
            int size2 = keyFramesForView.size();
            int i3 = 0;
            while (i3 < size2) {
                Key key = keyFramesForView.get(i3);
                i3++;
                if (key.mFramePosition == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isViewTransitionEnabled(int i) {
        return this.mViewTransitionController.isViewTransitionEnabled(i);
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void processScrollMove(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollMove(f, f2);
    }

    public void processScrollUp(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollUp(f, f2);
    }

    public void processTouchEvent(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = false;
                    } else {
                        this.mMotionOutsideRegion = true;
                    }
                    this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
            if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                    return;
                }
                Transition transitionBestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                if (transitionBestTransitionFor != null) {
                    motionLayout.setTransition(transitionBestTransitionFor);
                    RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        z = true;
                    }
                    this.mMotionOutsideRegion = z;
                    this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null && !this.mMotionOutsideRegion) {
            this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.mVelocityTracker) == null) {
            return;
        }
        motionTracker.recycle();
        this.mVelocityTracker = null;
        int i2 = motionLayout.mCurrentState;
        if (i2 != -1) {
            autoTransition(motionLayout, i2);
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(iKeyAt)) {
                return;
            }
            readConstraintChain(iKeyAt, motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i, en enVar) {
        this.mConstraintSetMap.put(i, enVar);
    }

    public void setDuration(int i) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i);
        } else {
            this.mDefaultDuration = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return;
        }
        ArrayList arrayList = transition.mKeyFramesList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            ArrayList<Key> keyFramesForView = ((KeyFrames) obj2).getKeyFramesForView(view.getId());
            int size2 = keyFramesForView.size();
            int i3 = 0;
            while (i3 < size2) {
                Key key = keyFramesForView.get(i3);
                i3++;
                if (key.mFramePosition == i && obj != null) {
                }
            }
        }
    }

    public void setRtl(boolean z) {
        this.mRtl = z;
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTransition(int r10, int r11) {
        /*
            r9 = this;
            fj1 r0 = r9.mStateSet
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.a(r10, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r10
        Ld:
            fj1 r2 = r9.mStateSet
            int r2 = r2.a(r11, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r11
            goto L1a
        L18:
            r0 = r10
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r3)
            if (r3 != r11) goto L2d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r3)
            if (r3 != r10) goto L2d
            goto L6c
        L2d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList
            int r4 = r3.size()
            r5 = 0
            r6 = 0
        L35:
            if (r6 >= r4) goto L6d
            java.lang.Object r7 = r3.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r7
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r7)
            if (r8 != r2) goto L4b
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r7)
            if (r8 == r0) goto L57
        L4b:
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r7)
            if (r8 != r11) goto L35
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r7)
            if (r8 != r10) goto L35
        L57:
            r9.mCurrentTransition = r7
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.TouchResponse r10 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$200(r7)
            if (r10 == 0) goto L6c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r10 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$200(r10)
            boolean r11 = r9.mRtl
            r10.setRTL(r11)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList
            int r4 = r3.size()
        L75:
            if (r5 >= r4) goto L87
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r6
            int r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r6)
            if (r7 != r11) goto L75
            r10 = r6
            goto L75
        L87:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r11 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r11.<init>(r9, r10)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.access$102(r11, r0)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.access$002(r11, r2)
            if (r0 == r1) goto L99
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r10 = r9.mTransitionList
            r10.add(r11)
        L99:
            r9.mCurrentTransition = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setupTouch();
    }

    public boolean supportTouch() {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Transition transition = arrayList.get(i);
            i++;
            if (transition.mTouchResponse != null) {
                return true;
            }
        }
        Transition transition2 = this.mCurrentTransition;
        return (transition2 == null || transition2.mTouchResponse == null) ? false : true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }

    public void viewTransition(int i, View... viewArr) {
        this.mViewTransitionController.viewTransition(i, viewArr);
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public Transition(MotionScene motionScene, Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == j71.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if ("layout".equals(resourceTypeName)) {
                        en enVar = new en();
                        enVar.m(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, enVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == j71.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if ("layout".equals(resourceTypeName2)) {
                        en enVar2 = new en();
                        enVar2.m(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, enVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == j71.Transition_motionInterpolator) {
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i2 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == j71.Transition_duration) {
                    int i3 = typedArray.getInt(index, this.mDuration);
                    this.mDuration = i3;
                    if (i3 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == j71.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == j71.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == j71.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == j71.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == j71.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == j71.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == j71.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j71.Transition);
            fill(motionScene, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i, int i2) {
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                TransitionOnClick transitionOnClick = arrayList.get(i3);
                i3++;
                TransitionOnClick transitionOnClick2 = transitionOnClick;
                if (transitionOnClick2.mTargetId == i) {
                    transitionOnClick2.mMode = i2;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i, i2));
        }

        public String debugString(Context context) {
            String resourceEntryName = this.mConstraintSetStart == -1 ? "null" : context.getResources().getResourceEntryName(this.mConstraintSetStart);
            if (this.mConstraintSetEnd == -1) {
                return uo.h(resourceEntryName, " -> null");
            }
            StringBuilder sbM = k31.m(resourceEntryName, " -> ");
            sbM.append(context.getResources().getResourceEntryName(this.mConstraintSetEnd));
            return sbM.toString();
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i) {
            return (i & this.mTransitionFlags) != 0;
        }

        public void removeOnClick(int i) {
            TransitionOnClick transitionOnClick;
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    transitionOnClick = null;
                    break;
                }
                TransitionOnClick transitionOnClick2 = arrayList.get(i2);
                i2++;
                transitionOnClick = transitionOnClick2;
                if (transitionOnClick.mTargetId == i) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i) {
            this.mAutoTransition = i;
        }

        public void setDuration(int i) {
            this.mDuration = Math.max(i, 8);
        }

        public void setEnabled(boolean z) {
            this.mDisable = !z;
        }

        public void setInterpolatorInfo(int i, String str, int i2) {
            this.mDefaultInterpolator = i;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i2;
        }

        public void setLayoutDuringTransition(int i) {
            this.mLayoutDuringTransition = i;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            this.mTouchResponse = onSwipe == null ? null : new TouchResponse(this.mMotionScene.mMotionLayout, onSwipe);
        }

        public void setOnTouchUp(int i) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i);
            }
        }

        public void setPathMotionArc(int i) {
            this.mPathMotionArc = i;
        }

        public void setStagger(float f) {
            this.mStagger = f;
        }

        public void setTransitionFlag(int i) {
            this.mTransitionFlags = i;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j71.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == j71.OnClick_targetId) {
                        this.mTargetId = typedArrayObtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == j71.OnClick_clickAction) {
                        this.mMode = typedArrayObtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                int i2 = this.mTargetId;
                View viewFindViewById = motionLayout;
                if (i2 != -1) {
                    viewFindViewById = motionLayout.findViewById(i2);
                }
                if (viewFindViewById == null) {
                    return;
                }
                int i3 = transition.mConstraintSetStart;
                int i4 = transition.mConstraintSetEnd;
                if (i3 == -1) {
                    viewFindViewById.setOnClickListener(this);
                    return;
                }
                int i5 = this.mMode;
                boolean z = false;
                boolean z2 = ((i5 & 1) != 0 && i == i3) | ((i5 & 1) != 0 && i == i3) | ((i5 & JUMP_TO_END) != 0 && i == i3) | ((i5 & 16) != 0 && i == i4);
                if ((i5 & JUMP_TO_START) != 0 && i == i4) {
                    z = true;
                }
                if (z2 || z) {
                    viewFindViewById.setOnClickListener(this);
                }
            }

            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int i = transition2.mConstraintSetEnd;
                int i2 = this.mTransition.mConstraintSetStart;
                if (i2 == -1) {
                    return motionLayout.mCurrentState != i;
                }
                int i3 = motionLayout.mCurrentState;
                return i3 == i2 || i3 == i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.mTransition.mMotionScene.mMotionLayout;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        Transition transition = new Transition(this.mTransition.mMotionScene, this.mTransition);
                        transition.mConstraintSetStart = currentState;
                        transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                    int i = this.mMode;
                    boolean z = false;
                    boolean z2 = ((i & 1) == 0 && (i & JUMP_TO_END) == 0) ? false : true;
                    boolean z3 = ((i & 16) == 0 && (i & JUMP_TO_START) == 0) ? false : true;
                    if (z2 && z3) {
                        Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                        Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            motionLayout.setTransition(transition4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z = z2;
                            z3 = false;
                        }
                    } else {
                        z = z2;
                    }
                    if (isTransitionViable(transition2, motionLayout)) {
                        if (z && (this.mMode & 1) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToEnd();
                            return;
                        }
                        if (z3 && (this.mMode & 16) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToStart();
                        } else if (z && (this.mMode & JUMP_TO_END) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z3 || (this.mMode & JUMP_TO_START) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                View viewFindViewById;
                int i = this.mTargetId;
                if (i == -1 || (viewFindViewById = motionLayout.findViewById(i)) == null) {
                    return;
                }
                viewFindViewById.setOnClickListener(null);
            }

            public TransitionOnClick(Transition transition, int i, int i2) {
                this.mTransition = transition;
                this.mTargetId = i;
                this.mMode = i2;
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    public en getConstraintSet(int i) {
        return getConstraintSet(i, -1, -1);
    }

    public en getConstraintSet(int i, int i2, int i3) {
        int iA;
        fj1 fj1Var = this.mStateSet;
        if (fj1Var != null && (iA = fj1Var.a(i, i2, i3)) != -1) {
            i = iA;
        }
        if (this.mConstraintSetMap.get(i) == null) {
            Debug.getName(this.mMotionLayout.getContext(), i);
            SparseArray<en> sparseArray = this.mConstraintSetMap;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.mConstraintSetMap.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseInclude(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name)) {
                    return parseConstraintSet(context, xml);
                }
            }
            return -1;
        } catch (IOException | XmlPullParserException unused) {
            return -1;
        }
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
        load(context, i);
        this.mConstraintSetMap.put(x51.motion_base, new en());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(x51.motion_base));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }
}
