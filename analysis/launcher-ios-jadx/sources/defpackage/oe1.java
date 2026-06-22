package defpackage;

import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class oe1 {
    public static int a(View view, boolean z) {
        int iY;
        int bottom;
        int iB;
        int iD;
        if (view != null) {
            if (!(view instanceof ScrollView)) {
                if (view instanceof ListView) {
                    ListView listView = (ListView) view;
                    if (listView.getChildCount() > 0) {
                        if (listView.getAdapter() != null) {
                            if (!z) {
                                View childAt = listView.getChildAt(listView.getChildCount() - 1);
                                return (childAt.getBottom() + (childAt.getHeight() * ((listView.getAdapter().getCount() - listView.getLastVisiblePosition()) - 1))) - listView.getBottom();
                            }
                            View childAt2 = listView.getChildAt(0);
                            iB = childAt2.getHeight() * listView.getFirstVisiblePosition();
                            iD = childAt2.getTop();
                            return iB - iD;
                        }
                    }
                }
                if (view instanceof RecyclerView) {
                    RecyclerView recyclerView = (RecyclerView) view;
                    if (recyclerView.getChildCount() > 0) {
                        u81 layoutManager = recyclerView.getLayoutManager();
                        if (recyclerView.getAdapter() != null) {
                            if (z) {
                                View childAt3 = recyclerView.getChildAt(0);
                                m91 m91VarQ = RecyclerView.Q(childAt3);
                                int iF = m91VarQ != null ? m91VarQ.f() : -1;
                                layoutManager.getClass();
                                iB = u81.B(childAt3) * iF;
                                iD = u81.D(childAt3);
                                return iB - iD;
                            }
                            View childAt4 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                            int iC = recyclerView.getAdapter().c() - 1;
                            layoutManager.getClass();
                            iY = u81.y(childAt4) + (u81.B(childAt4) * iC);
                            bottom = recyclerView.getBottom();
                        }
                    }
                }
            } else {
                if (z) {
                    return view.getScrollY();
                }
                ScrollView scrollView = (ScrollView) view;
                iY = scrollView.getChildAt(0).getBottom();
                bottom = scrollView.getScrollY() + scrollView.getHeight();
            }
            return iY - bottom;
        }
        return 0;
    }
}
