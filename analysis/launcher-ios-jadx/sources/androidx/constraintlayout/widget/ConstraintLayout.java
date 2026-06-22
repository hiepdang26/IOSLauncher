package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.en;
import defpackage.fu0;
import defpackage.j71;
import defpackage.jg1;
import defpackage.jn;
import defpackage.kn;
import defpackage.nm;
import defpackage.om;
import defpackage.on;
import defpackage.pm;
import defpackage.qn0;
import defpackage.sm;
import defpackage.va0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static jg1 sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<a> mConstraintHelpers;
    protected sm mConstraintLayoutSpec;
    private en mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected kn mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    om mMeasurer;
    private fu0 mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private ArrayList<pm> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<jn> mTempMapIdToWidget;

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new kn();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new om(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        d(null, 0);
    }

    public static /* synthetic */ fu0 access$000(ConstraintLayout constraintLayout) {
        constraintLayout.getClass();
        return null;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static jg1 getSharedValues() {
        if (sSharedValues == null) {
            jg1 jg1Var = new jg1();
            new SparseIntArray();
            jg1Var.a = new HashMap();
            sSharedValues = jg1Var;
        }
        return sSharedValues;
    }

    public void addValueModifier(pm pmVar) {
        if (this.mModifiers == null) {
            this.mModifiers = new ArrayList<>();
        }
        this.mModifiers.add(pmVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x02b0 -> B:163:0x02b1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void applyConstraintsFromLayoutParams(boolean r19, android.view.View r20, defpackage.jn r21, defpackage.nm r22, android.util.SparseArray<defpackage.jn> r23) {
        /*
            Method dump skipped, instruction units count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, jn, nm, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof nm;
    }

    public final void d(AttributeSet attributeSet, int i) {
        kn knVar = this.mLayoutWidget;
        knVar.g0 = this;
        om omVar = this.mMeasurer;
        knVar.x0 = omVar;
        knVar.v0.f = omVar;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j71.ConstraintLayout_Layout, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == j71.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == j71.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == j71.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == j71.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == j71.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == j71.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == j71.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        en enVar = new en();
                        this.mConstraintSet = enVar;
                        enVar.m(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        kn knVar2 = this.mLayoutWidget;
        knVar2.G0 = this.mOptimizationLevel;
        qn0.q = knVar2.V(512);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<a> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public boolean dynamicUpdateConstraints(int i, int i2) {
        if (this.mModifiers != null) {
            View.MeasureSpec.getSize(i);
            View.MeasureSpec.getSize(i2);
            ArrayList<pm> arrayList = this.mModifiers;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                pm pmVar = arrayList.get(i3);
                i3++;
                if (pmVar != null) {
                    throw new ClassCastException();
                }
                Iterator it = this.mLayoutWidget.t0.iterator();
                if (it.hasNext()) {
                    View view = ((jn) it.next()).g0;
                    view.getId();
                    throw null;
                }
            }
        }
        return false;
    }

    public final void e(jn jnVar, nm nmVar, SparseArray sparseArray, int i, int i2) {
        View view = this.mChildrenByIds.get(i);
        jn jnVar2 = (jn) sparseArray.get(i);
        if (jnVar2 == null || view == null || !(view.getLayoutParams() instanceof nm)) {
            return;
        }
        nmVar.c0 = USE_CONSTRAINTS_HELPER;
        if (i2 == 6) {
            nm nmVar2 = (nm) view.getLayoutParams();
            nmVar2.c0 = USE_CONSTRAINTS_HELPER;
            nmVar2.p0.E = USE_CONSTRAINTS_HELPER;
        }
        jnVar.j(6).b(jnVar2.j(i2), nmVar.D, nmVar.C, USE_CONSTRAINTS_HELPER);
        jnVar.E = USE_CONSTRAINTS_HELPER;
        jnVar.j(3).j();
        jnVar.j(5).j();
    }

    public void fillMetrics(fu0 fu0Var) {
        this.mLayoutWidget.z0.getClass();
    }

    @Override // android.view.View
    public void forceLayout() {
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        super.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.mDesignIds;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.G0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.j == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.j = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.j = "parent";
            }
        }
        kn knVar = this.mLayoutWidget;
        if (knVar.j0 == null) {
            knVar.j0 = knVar.j;
        }
        ArrayList arrayList = knVar.t0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            jn jnVar = (jn) obj;
            View view = jnVar.g0;
            if (view != null) {
                if (jnVar.j == null && (id = view.getId()) != -1) {
                    jnVar.j = getContext().getResources().getResourceEntryName(id);
                }
                if (jnVar.j0 == null) {
                    jnVar.j0 = jnVar.j;
                }
            }
        }
        this.mLayoutWidget.o(sb);
        return sb.toString();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final jn getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof nm) {
            return ((nm) view.getLayoutParams()).p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof nm) {
            return ((nm) view.getLayoutParams()).p0;
        }
        return null;
    }

    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0 || 1 != getLayoutDirection()) {
            return false;
        }
        return USE_CONSTRAINTS_HELPER;
    }

    public void loadLayoutDescription(int i) {
        if (i == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new sm(getContext(), this, i);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            nm nmVar = (nm) childAt.getLayoutParams();
            jn jnVar = nmVar.p0;
            if (childAt.getVisibility() != 8 || nmVar.d0 || nmVar.e0 || zIsInEditMode) {
                int iS = jnVar.s();
                int iT = jnVar.t();
                childAt.layout(iS, iT, jnVar.r() + iS, jnVar.l() + iT);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        jn jnVar;
        boolean zDynamicUpdateConstraints = this.mDirtyHierarchy | dynamicUpdateConstraints(i, i2);
        this.mDirtyHierarchy = zDynamicUpdateConstraints;
        if (!zDynamicUpdateConstraints) {
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                if (getChildAt(i3).isLayoutRequested()) {
                    this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
                    break;
                }
                i3++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.y0 = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            int childCount2 = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount2) {
                    z = false;
                    break;
                } else {
                    if (getChildAt(i4).isLayoutRequested()) {
                        z = USE_CONSTRAINTS_HELPER;
                        break;
                    }
                    i4++;
                }
            }
            if (z) {
                boolean zIsInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i5 = 0; i5 < childCount3; i5++) {
                    jn viewWidget = getViewWidget(getChildAt(i5));
                    if (viewWidget != null) {
                        viewWidget.D();
                    }
                }
                if (zIsInEditMode) {
                    for (int i6 = 0; i6 < childCount3; i6++) {
                        View childAt = getChildAt(i6);
                        try {
                            String resourceName = getResources().getResourceName(childAt.getId());
                            setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                            int iIndexOf = resourceName.indexOf(47);
                            if (iIndexOf != -1) {
                                resourceName = resourceName.substring(iIndexOf + 1);
                            }
                            int id = childAt.getId();
                            if (id == 0) {
                                jnVar = this.mLayoutWidget;
                            } else {
                                View viewFindViewById = this.mChildrenByIds.get(id);
                                if (viewFindViewById == null && (viewFindViewById = findViewById(id)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
                                    onViewAdded(viewFindViewById);
                                }
                                jnVar = viewFindViewById == this ? this.mLayoutWidget : viewFindViewById == null ? null : ((nm) viewFindViewById.getLayoutParams()).p0;
                            }
                            jnVar.j0 = resourceName;
                        } catch (Resources.NotFoundException unused) {
                        }
                    }
                }
                if (this.mConstraintSetId != -1) {
                    for (int i7 = 0; i7 < childCount3; i7++) {
                        getChildAt(i7).getId();
                    }
                }
                en enVar = this.mConstraintSet;
                if (enVar != null) {
                    enVar.c(this);
                }
                this.mLayoutWidget.t0.clear();
                int size = this.mConstraintHelpers.size();
                if (size > 0) {
                    for (int i8 = 0; i8 < size; i8++) {
                        this.mConstraintHelpers.get(i8).updatePreLayout(this);
                    }
                }
                for (int i9 = 0; i9 < childCount3; i9++) {
                    getChildAt(i9);
                }
                this.mTempMapIdToWidget.clear();
                this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
                this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
                for (int i10 = 0; i10 < childCount3; i10++) {
                    View childAt2 = getChildAt(i10);
                    this.mTempMapIdToWidget.put(childAt2.getId(), getViewWidget(childAt2));
                }
                for (int i11 = 0; i11 < childCount3; i11++) {
                    View childAt3 = getChildAt(i11);
                    jn viewWidget2 = getViewWidget(childAt3);
                    if (viewWidget2 != null) {
                        nm nmVar = (nm) childAt3.getLayoutParams();
                        kn knVar = this.mLayoutWidget;
                        knVar.t0.add(viewWidget2);
                        jn jnVar2 = viewWidget2.U;
                        if (jnVar2 != null) {
                            ((kn) jnVar2).t0.remove(viewWidget2);
                            viewWidget2.D();
                        }
                        viewWidget2.U = knVar;
                        applyConstraintsFromLayoutParams(zIsInEditMode, childAt3, viewWidget2, nmVar, this.mTempMapIdToWidget);
                    }
                }
            }
            if (z) {
                kn knVar2 = this.mLayoutWidget;
                knVar2.u0.D(knVar2);
            }
        }
        this.mLayoutWidget.z0.getClass();
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        int iR = this.mLayoutWidget.r();
        int iL = this.mLayoutWidget.l();
        kn knVar3 = this.mLayoutWidget;
        resolveMeasuredDimension(i, i2, iR, iL, knVar3.H0, knVar3.I0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        jn viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof va0)) {
            nm nmVar = (nm) view.getLayoutParams();
            va0 va0Var = new va0();
            nmVar.p0 = va0Var;
            nmVar.d0 = USE_CONSTRAINTS_HELPER;
            va0Var.R(nmVar.V);
        }
        if (view instanceof a) {
            a aVar = (a) view;
            aVar.validateParams();
            ((nm) view.getLayoutParams()).e0 = USE_CONSTRAINTS_HELPER;
            if (!this.mConstraintHelpers.contains(aVar)) {
                this.mConstraintHelpers.add(aVar);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        jn viewWidget = getViewWidget(view);
        this.mLayoutWidget.t0.remove(viewWidget);
        viewWidget.D();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new sm(getContext(), this, i);
    }

    public void removeValueModifier(pm pmVar) {
        if (pmVar == null) {
            return;
        }
        this.mModifiers.remove(pmVar);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        om omVar = this.mMeasurer;
        int i5 = omVar.e;
        int iResolveSizeAndState = View.resolveSizeAndState(i3 + omVar.d, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i4 + i5, i2, 0) & 16777215;
        int iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
        if (z) {
            iMin |= 16777216;
        }
        if (z2) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.mLastMeasureWidth = iMin;
        this.mLastMeasureHeight = iMin2;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f8 A[PHI: r6
  0x00f8: PHI (r6v3 boolean) = (r6v2 boolean), (r6v61 boolean) binds: [B:18:0x009d, B:337:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void resolveSystem(defpackage.kn r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 1578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.resolveSystem(kn, int, int, int):void");
    }

    public void setConstraintSet(en enVar) {
        this.mConstraintSet = enVar;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(strSubstring, num);
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(on onVar) {
        sm smVar = this.mConstraintLayoutSpec;
        if (smVar != null) {
            smVar.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        kn knVar = this.mLayoutWidget;
        knVar.G0 = i;
        qn0.q = knVar.V(512);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSelfDimensionBehaviour(defpackage.kn r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            om r0 = r8.mMeasurer
            int r1 = r0.e
            int r0 = r0.d
            in r2 = defpackage.in.g
            int r3 = r8.getChildCount()
            in r4 = defpackage.in.h
            r5 = 0
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == r7) goto L31
            if (r10 == 0) goto L25
            if (r10 == r6) goto L1c
            r10 = r2
        L1a:
            r11 = 0
            goto L3a
        L1c:
            int r10 = r8.mMaxWidth
            int r10 = r10 - r0
            int r11 = java.lang.Math.min(r10, r11)
            r10 = r2
            goto L3a
        L25:
            if (r3 != 0) goto L2f
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r5, r10)
        L2d:
            r10 = r4
            goto L3a
        L2f:
            r10 = r4
            goto L1a
        L31:
            if (r3 != 0) goto L2d
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r5, r10)
            goto L2d
        L3a:
            if (r12 == r7) goto L56
            if (r12 == 0) goto L4a
            if (r12 == r6) goto L42
        L40:
            r13 = 0
            goto L5f
        L42:
            int r12 = r8.mMaxHeight
            int r12 = r12 - r1
            int r13 = java.lang.Math.min(r12, r13)
            goto L5f
        L4a:
            if (r3 != 0) goto L54
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r5, r12)
        L52:
            r2 = r4
            goto L5f
        L54:
            r2 = r4
            goto L40
        L56:
            if (r3 != 0) goto L52
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r5, r12)
            goto L52
        L5f:
            int r12 = r9.r()
            r3 = 1
            if (r11 != r12) goto L6c
            int r12 = r9.l()
            if (r13 == r12) goto L70
        L6c:
            uu r12 = r9.v0
            r12.c = r3
        L70:
            r9.Z = r5
            r9.a0 = r5
            int r12 = r8.mMaxWidth
            int r12 = r12 - r0
            int[] r4 = r9.C
            r4[r5] = r12
            int r12 = r8.mMaxHeight
            int r12 = r12 - r1
            r4[r3] = r12
            r9.c0 = r5
            r9.d0 = r5
            r9.L(r10)
            r9.N(r11)
            r9.M(r2)
            r9.K(r13)
            int r10 = r8.mMinWidth
            int r10 = r10 - r0
            if (r10 >= 0) goto L98
            r9.c0 = r5
            goto L9a
        L98:
            r9.c0 = r10
        L9a:
            int r10 = r8.mMinHeight
            int r10 = r10 - r1
            if (r10 >= 0) goto La2
            r9.d0 = r5
            return
        La2:
            r9.d0 = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(kn, int, int, int, int):void");
    }

    public void setState(int i, int i2, int i3) {
        sm smVar = this.mConstraintLayoutSpec;
        if (smVar != null) {
            smVar.b(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public nm generateDefaultLayoutParams() {
        return new nm(-2, -2);
    }

    @Override // android.view.ViewGroup
    public nm generateLayoutParams(AttributeSet attributeSet) {
        return new nm(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new nm(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new kn();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new om(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        d(attributeSet, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new kn();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new om(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        d(attributeSet, i);
    }
}
