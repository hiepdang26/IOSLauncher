package defpackage;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.allapps.AllAppsContainerView;
import com.luutinhit.launcher6.allapps.AllAppsGridAdapter$AppsGridLayoutManager;
import com.luutinhit.launcher6.t;
import defpackage.c4;
import defpackage.c91;
import defpackage.i91;
import defpackage.nx0;
import defpackage.r0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c4 extends m81 {
    public final String A;
    public final t j;
    public final LayoutInflater k;
    public final m4 l;
    public final AllAppsGridAdapter$AppsGridLayoutManager m;
    public final z3 n;
    public final AllAppsContainerView o;
    public final t p;
    public final AllAppsContainerView q;
    public final Rect r = new Rect();
    public final boolean s;
    public final int t;
    public final int u;
    public final Paint v;
    public final Paint w;
    public final int x;
    public int y;
    public x3 z;

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.recyclerview.widget.GridLayoutManager, com.luutinhit.launcher6.allapps.AllAppsGridAdapter$AppsGridLayoutManager] */
    public c4(t tVar, m4 m4Var, AllAppsContainerView allAppsContainerView, t tVar2, AllAppsContainerView allAppsContainerView2) {
        Resources resources = tVar.getResources();
        this.j = tVar;
        this.l = m4Var;
        this.A = resources.getString(w61.all_apps_loading_message);
        a4 a4Var = new a4(this);
        ?? r1 = new GridLayoutManager() { // from class: com.luutinhit.launcher6.allapps.AllAppsGridAdapter$AppsGridLayoutManager
            {
                super(1, 0);
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager, defpackage.u81
            public final int L(c91 c91Var, i91 i91Var) {
                return super.L(c91Var, i91Var) - t1(-1);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
            public final void V(AccessibilityEvent accessibilityEvent) {
                super.V(accessibilityEvent);
                int iT1 = t1(-1);
                accessibilityEvent.setFromIndex(accessibilityEvent.getFromIndex() - iT1);
                accessibilityEvent.setToIndex(accessibilityEvent.getToIndex() - iT1);
                accessibilityEvent.setItemCount(this.M.l.d.size());
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager, defpackage.u81
            public final void X(c91 c91Var, i91 i91Var, View view, r0 r0Var) {
                int i = RecyclerView.Q(view).l;
                if (i == 1 || i == 2) {
                    super.X(c91Var, i91Var, view, r0Var);
                    AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = r0Var.a.getCollectionItemInfo();
                    nx0 nx0Var = collectionItemInfo != null ? new nx0(collectionItemInfo, 1) : null;
                    if (nx0Var != null) {
                        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo2 = (AccessibilityNodeInfo.CollectionItemInfo) nx0Var.h;
                        r0Var.j(nx0.v(collectionItemInfo2.getRowIndex() - t1(i), collectionItemInfo2.getRowSpan(), collectionItemInfo2.getColumnIndex(), collectionItemInfo2.getColumnSpan(), collectionItemInfo2.isHeading(), collectionItemInfo2.isSelected()));
                    }
                }
            }

            public final int t1(int i) {
                c4 c4Var = this.M;
                c4Var.l.getClass();
                ArrayList arrayList = c4Var.l.h;
                return (arrayList == null || arrayList.size() <= 0 || i == 2 || i != 1) ? 1 : 2;
            }
        };
        this.m = r1;
        r1.K = a4Var;
        this.n = new z3(this);
        this.k = LayoutInflater.from(tVar);
        this.o = allAppsContainerView;
        this.p = tVar2;
        this.q = allAppsContainerView2;
        this.t = resources.getDimensionPixelSize(e51.all_apps_grid_view_start_margin);
        this.u = resources.getDimensionPixelSize(e51.all_apps_grid_section_y_offset);
        this.s = ar1.v(resources);
        Paint paint = new Paint(1);
        this.v = paint;
        paint.setTextSize(resources.getDimensionPixelSize(e51.all_apps_grid_section_text_size));
        paint.setColor(resources.getColor(x41.all_apps_grid_section_text_color));
        Paint paint2 = new Paint(1);
        this.w = paint2;
        paint2.setStrokeWidth(Math.round(TypedValue.applyDimension(1, 1.0f, resources.getDisplayMetrics())));
        paint2.setColor(503316480);
        this.x = (resources.getDimensionPixelSize(e51.all_apps_icon_top_bottom_padding) + (-resources.getDimensionPixelSize(e51.all_apps_prediction_icon_bottom_padding))) / 2;
    }

    @Override // defpackage.m81
    public final int c() {
        return this.l.e.size();
    }

    @Override // defpackage.m81
    public final int e(int i) {
        return ((i4) this.l.e.get(i)).b;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        b4 b4Var = (b4) m91Var;
        int i2 = b4Var.l;
        KeyEvent.Callback callback = b4Var.A;
        m4 m4Var = this.l;
        if (i2 == 1) {
            BubbleTextView bubbleTextView = (BubbleTextView) callback;
            bubbleTextView.l(((i4) m4Var.e.get(i)).g);
            bubbleTextView.setAccessibilityDelegate(jk0.a().f);
        } else if (i2 == 2) {
            BubbleTextView bubbleTextView2 = (BubbleTextView) callback;
            bubbleTextView2.l(((i4) m4Var.e.get(i)).g);
            bubbleTextView2.setAccessibilityDelegate(jk0.a().f);
        } else if (i2 == 3) {
            TextView textView = (TextView) callback;
            textView.setText(this.A);
            m4Var.getClass();
            textView.setGravity(8388627);
        } else if (i2 == 5) {
            ((TextView) callback).setVisibility(8);
        }
        x3 x3Var = this.z;
        if (x3Var != null) {
            if (!(x3Var.d == null && x3Var.e == null) && (callback instanceof kb)) {
                kb kbVar = (kb) callback;
                x3Var.b(kbVar, b4Var.g(), false);
                x3Var.h.add(kbVar);
            }
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new b4(new View(viewGroup.getContext()));
        }
        AllAppsContainerView allAppsContainerView = this.q;
        t tVar = this.p;
        AllAppsContainerView allAppsContainerView2 = this.o;
        LayoutInflater layoutInflater = this.k;
        if (i == 1) {
            BubbleTextView bubbleTextView = (BubbleTextView) layoutInflater.inflate(m61.all_apps_icon, viewGroup, false);
            bubbleTextView.setOnTouchListener(allAppsContainerView2);
            bubbleTextView.setOnClickListener(tVar);
            bubbleTextView.setOnLongClickListener(allAppsContainerView);
            bubbleTextView.setLongPressTimeout(ViewConfiguration.getLongPressTimeout());
            bubbleTextView.setFocusable(true);
            return new b4(bubbleTextView);
        }
        if (i == 2) {
            BubbleTextView bubbleTextView2 = (BubbleTextView) layoutInflater.inflate(m61.all_apps_prediction_bar_icon, viewGroup, false);
            bubbleTextView2.setOnTouchListener(allAppsContainerView2);
            bubbleTextView2.setOnClickListener(tVar);
            bubbleTextView2.setOnLongClickListener(allAppsContainerView);
            bubbleTextView2.setLongPressTimeout(ViewConfiguration.getLongPressTimeout());
            bubbleTextView2.setFocusable(true);
            return new b4(bubbleTextView2);
        }
        if (i == 3) {
            return new b4(layoutInflater.inflate(m61.all_apps_empty_search, viewGroup, false));
        }
        if (i == 4) {
            return new b4(layoutInflater.inflate(m61.all_apps_search_market_divider, viewGroup, false));
        }
        if (i != 5) {
            throw new RuntimeException("Unexpected view type");
        }
        View viewInflate = layoutInflater.inflate(m61.all_apps_search_market, viewGroup, false);
        viewInflate.setOnClickListener(new y3(this));
        return new b4(viewInflate);
    }

    @Override // defpackage.m81
    public final /* bridge */ /* synthetic */ boolean k(m91 m91Var) {
        return true;
    }
}
