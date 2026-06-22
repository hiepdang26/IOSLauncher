package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.en;
import defpackage.jg1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ViewTransitionController {
    ArrayList<ViewTransition.Animate> mAnimations;
    private final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    private ArrayList<ViewTransition> mViewTransitions = new ArrayList<>();
    private String mTAG = "ViewTransitionController";
    ArrayList<ViewTransition.Animate> mRemoveList = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private void listenForSharedVariable(final ViewTransition viewTransition, final boolean z) {
        final int sharedValueID = viewTransition.getSharedValueID();
        final int sharedValue = viewTransition.getSharedValue();
        jg1 sharedValues = ConstraintLayout.getSharedValues();
        int sharedValueID2 = viewTransition.getSharedValueID();
        Object obj = new Object() { // from class: androidx.constraintlayout.motion.widget.ViewTransitionController.1
            public void onNewValue(int i, int i2, int i3) {
                int sharedValueCurrent = viewTransition.getSharedValueCurrent();
                viewTransition.setSharedValueCurrent(i2);
                if (sharedValueID != i || sharedValueCurrent == i2) {
                    return;
                }
                if (z) {
                    if (sharedValue == i2) {
                        int childCount = ViewTransitionController.this.mMotionLayout.getChildCount();
                        for (int i4 = 0; i4 < childCount; i4++) {
                            View childAt = ViewTransitionController.this.mMotionLayout.getChildAt(i4);
                            if (viewTransition.matchesView(childAt)) {
                                int currentState = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                en constraintSet = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState);
                                ViewTransition viewTransition2 = viewTransition;
                                ViewTransitionController viewTransitionController = ViewTransitionController.this;
                                viewTransition2.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, childAt);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (sharedValue != i2) {
                    int childCount2 = ViewTransitionController.this.mMotionLayout.getChildCount();
                    for (int i5 = 0; i5 < childCount2; i5++) {
                        View childAt2 = ViewTransitionController.this.mMotionLayout.getChildAt(i5);
                        if (viewTransition.matchesView(childAt2)) {
                            int currentState2 = ViewTransitionController.this.mMotionLayout.getCurrentState();
                            en constraintSet2 = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState2);
                            ViewTransition viewTransition3 = viewTransition;
                            ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                            viewTransition3.applyTransition(viewTransitionController2, viewTransitionController2.mMotionLayout, currentState2, constraintSet2, childAt2);
                        }
                    }
                }
            }
        };
        HashMap map = sharedValues.a;
        HashSet hashSet = (HashSet) map.get(Integer.valueOf(sharedValueID2));
        if (hashSet == null) {
            hashSet = new HashSet();
            map.put(Integer.valueOf(sharedValueID2), hashSet);
        }
        hashSet.add(new WeakReference(obj));
    }

    private void viewTransition(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (viewTransition.mViewTransitionMode == 2) {
            viewTransition.applyTransition(this, this.mMotionLayout, currentState, null, viewArr);
            return;
        }
        if (currentState == -1) {
            this.mMotionLayout.toString();
            return;
        }
        en constraintSet = this.mMotionLayout.getConstraintSet(currentState);
        if (constraintSet == null) {
            return;
        }
        viewTransition.applyTransition(this, this.mMotionLayout, currentState, constraintSet, viewArr);
    }

    public void add(ViewTransition viewTransition) {
        this.mViewTransitions.add(viewTransition);
        this.mRelatedViews = null;
        if (viewTransition.getStateTransition() == 4) {
            listenForSharedVariable(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            listenForSharedVariable(viewTransition, false);
        }
    }

    public void addAnimation(ViewTransition.Animate animate) {
        if (this.mAnimations == null) {
            this.mAnimations = new ArrayList<>();
        }
        this.mAnimations.add(animate);
    }

    public void animate() {
        ArrayList<ViewTransition.Animate> arrayList = this.mAnimations;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            ViewTransition.Animate animate = arrayList.get(i);
            i++;
            animate.mutate();
        }
        this.mAnimations.removeAll(this.mRemoveList);
        this.mRemoveList.clear();
        if (this.mAnimations.isEmpty()) {
            this.mAnimations = null;
        }
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            ViewTransition viewTransition = arrayList.get(i2);
            i2++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i) {
                viewTransition2.mKeyFrames.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    public void enableViewTransition(int i, boolean z) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            ViewTransition viewTransition = arrayList.get(i2);
            i2++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i) {
                viewTransition2.setEnabled(z);
                return;
            }
        }
    }

    public void invalidate() {
        this.mMotionLayout.invalidate();
    }

    public boolean isViewTransitionEnabled(int i) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            ViewTransition viewTransition = arrayList.get(i2);
            i2++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i) {
                return viewTransition2.isEnabled();
            }
        }
        return false;
    }

    public void remove(int i) {
        ViewTransition viewTransition;
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewTransition = null;
                break;
            }
            ViewTransition viewTransition2 = arrayList.get(i2);
            i2++;
            viewTransition = viewTransition2;
            if (viewTransition.getId() == i) {
                break;
            }
        }
        if (viewTransition != null) {
            this.mRelatedViews = null;
            this.mViewTransitions.remove(viewTransition);
        }
    }

    public void removeAnimation(ViewTransition.Animate animate) {
        this.mRemoveList.add(animate);
    }

    public void touchEvent(MotionEvent motionEvent) {
        ViewTransitionController viewTransitionController = this;
        int currentState = viewTransitionController.mMotionLayout.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (viewTransitionController.mRelatedViews == null) {
            viewTransitionController.mRelatedViews = new HashSet<>();
            ArrayList<ViewTransition> arrayList = viewTransitionController.mViewTransitions;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                ViewTransition viewTransition = arrayList.get(i);
                i++;
                ViewTransition viewTransition2 = viewTransition;
                int childCount = viewTransitionController.mMotionLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewTransitionController.mMotionLayout.getChildAt(i2);
                    if (viewTransition2.matchesView(childAt)) {
                        childAt.getId();
                        viewTransitionController.mRelatedViews.add(childAt);
                    }
                }
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<ViewTransition.Animate> arrayList2 = viewTransitionController.mAnimations;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            ArrayList<ViewTransition.Animate> arrayList3 = viewTransitionController.mAnimations;
            int size2 = arrayList3.size();
            int i3 = 0;
            while (i3 < size2) {
                ViewTransition.Animate animate = arrayList3.get(i3);
                i3++;
                animate.reactTo(action, x, y);
            }
        }
        if (action == 0 || action == 1) {
            en constraintSet = viewTransitionController.mMotionLayout.getConstraintSet(currentState);
            ArrayList<ViewTransition> arrayList4 = viewTransitionController.mViewTransitions;
            int size3 = arrayList4.size();
            int i4 = 0;
            while (i4 < size3) {
                int i5 = i4 + 1;
                ViewTransition viewTransition3 = arrayList4.get(i4);
                if (viewTransition3.supports(action)) {
                    for (View view : viewTransitionController.mRelatedViews) {
                        if (viewTransition3.matchesView(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x, (int) y)) {
                                viewTransition3.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, view);
                            }
                            viewTransitionController = this;
                        }
                    }
                }
                viewTransitionController = this;
                i4 = i5;
            }
        }
    }

    public void viewTransition(int i, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ViewTransition> arrayList2 = this.mViewTransitions;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            ViewTransition viewTransition = arrayList2.get(i2);
            i2++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i) {
                for (View view : viewArr) {
                    if (viewTransition2.checkTags(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    viewTransition(viewTransition2, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
            }
        }
    }
}
