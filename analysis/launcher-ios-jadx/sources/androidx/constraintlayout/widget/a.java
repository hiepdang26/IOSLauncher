package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import defpackage.an;
import defpackage.j71;
import defpackage.jn;
import defpackage.kn;
import defpackage.nm;
import defpackage.x51;
import defpackage.xb0;
import defpackage.zb0;
import defpackage.zm;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends View {
    protected static final String CHILD_TAG = "CONSTRAINT_LAYOUT_HELPER_CHILD";
    protected int mCount;
    protected xb0 mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public a(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    public static boolean isChildOfHelper(View view) {
        return CHILD_TAG == view.getTag();
    }

    public final void a(String str) {
        String strTrim;
        int iE;
        if (str == null || str.length() == 0 || this.myContext == null || (iE = e((strTrim = str.trim()))) == 0) {
            return;
        }
        this.mMap.put(Integer.valueOf(iE), strTrim);
        b(iE);
    }

    public void addView(View view) {
        if (view == this || view.getId() == -1 || view.getParent() == null) {
            return;
        }
        this.mReferenceIds = null;
        b(view.getId());
        requestLayout();
    }

    public void applyHelperParams() {
    }

    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = constraintLayout.getViewById(this.mIds[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
    }

    public final void b(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.mCount + 1;
        int[] iArr = this.mIds;
        if (i2 > iArr.length) {
            this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i3 = this.mCount;
        iArr2[i3] = i;
        this.mCount = i3 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof nm) && strTrim.equals(((nm) layoutParams).Y) && childAt.getId() != -1) {
                b(childAt.getId());
            }
        }
    }

    public boolean containsId(int i) {
        for (int i2 : this.mIds) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.myContext.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                if (childAt.getId() != -1) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        resourceEntryName = null;
                    }
                    if (str.equals(resourceEntryName)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public final int e(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iD = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                iD = ((Integer) designInformation).intValue();
            }
        }
        if (iD == 0 && constraintLayout != null) {
            iD = d(constraintLayout, str);
        }
        if (iD == 0) {
            try {
                iD = x51.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iD == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : iD;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            this.mViews[i] = constraintLayout.getViewById(this.mIds[i]);
        }
        return this.mViews;
    }

    public int indexFromId(int i) {
        int i2 = -1;
        for (int i3 : this.mIds) {
            i2++;
            if (i3 == i) {
                return i2;
            }
        }
        return i2;
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j71.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == j71.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                } else if (index == j71.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.mReferenceTags = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void loadParameters(zm zmVar, zb0 zb0Var, nm nmVar, SparseArray<jn> sparseArray) {
        an anVar = zmVar.e;
        int[] iArr = anVar.j0;
        int i = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = anVar.k0;
            if (str != null) {
                if (str.length() > 0) {
                    String[] strArrSplit = anVar.k0.split(",");
                    int[] iArrCopyOf = new int[strArrSplit.length];
                    int i2 = 0;
                    for (String str2 : strArrSplit) {
                        int iE = e(str2.trim());
                        if (iE != 0) {
                            iArrCopyOf[i2] = iE;
                            i2++;
                        }
                    }
                    if (i2 != strArrSplit.length) {
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i2);
                    }
                    anVar.j0 = iArrCopyOf;
                } else {
                    anVar.j0 = null;
                }
            }
        }
        if (zb0Var == null) {
            return;
        }
        zb0Var.u0 = 0;
        Arrays.fill(zb0Var.t0, (Object) null);
        if (anVar.j0 == null) {
            return;
        }
        while (true) {
            int[] iArr2 = anVar.j0;
            if (i >= iArr2.length) {
                return;
            }
            jn jnVar = sparseArray.get(iArr2[i]);
            if (jnVar != null) {
                zb0Var.Q(jnVar);
            }
            i++;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.mReferenceTags;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int removeView(View view) {
        int i;
        int id = view.getId();
        int i2 = -1;
        if (id == -1) {
            return -1;
        }
        this.mReferenceIds = null;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mCount) {
                break;
            }
            if (this.mIds[i3] == id) {
                int i4 = i3;
                while (true) {
                    i = this.mCount;
                    if (i4 >= i - 1) {
                        break;
                    }
                    int[] iArr = this.mIds;
                    int i5 = i4 + 1;
                    iArr[i4] = iArr[i5];
                    i4 = i5;
                }
                this.mIds[i - 1] = 0;
                this.mCount = i - 1;
                i2 = i3;
            } else {
                i3++;
            }
        }
        requestLayout();
        return i2;
    }

    public void setIds(String str) {
        this.mReferenceIds = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.mReferenceTags = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                c(str.substring(i));
                return;
            } else {
                c(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.mReferenceIds == null) {
            b(i);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int iD;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        xb0 xb0Var = this.mHelperWidget;
        if (xb0Var == null) {
            return;
        }
        zb0 zb0Var = (zb0) xb0Var;
        zb0Var.u0 = 0;
        Arrays.fill(zb0Var.t0, (Object) null);
        for (int i = 0; i < this.mCount; i++) {
            int i2 = this.mIds[i];
            View viewById = constraintLayout.getViewById(i2);
            if (viewById == null && (iD = d(constraintLayout, (str = this.mMap.get(Integer.valueOf(i2))))) != 0) {
                this.mIds[i] = iD;
                this.mMap.put(Integer.valueOf(iD), str);
                viewById = constraintLayout.getViewById(iD);
            }
            if (viewById != null) {
                ((zb0) this.mHelperWidget).Q(constraintLayout.getViewWidget(viewById));
            }
        }
        xb0 xb0Var2 = this.mHelperWidget;
        kn knVar = constraintLayout.mLayoutWidget;
        xb0Var2.a();
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof nm) {
            ((nm) layoutParams).p0 = (jn) this.mHelperWidget;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((ConstraintLayout) parent);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public void updatePreLayout(kn knVar, xb0 xb0Var, SparseArray<jn> sparseArray) {
        zb0 zb0Var = (zb0) xb0Var;
        zb0Var.u0 = 0;
        Arrays.fill(zb0Var.t0, (Object) null);
        for (int i = 0; i < this.mCount; i++) {
            zb0Var.Q(sparseArray.get(this.mIds[i]));
        }
    }

    public void resolveRtl(jn jnVar, boolean z) {
    }
}
