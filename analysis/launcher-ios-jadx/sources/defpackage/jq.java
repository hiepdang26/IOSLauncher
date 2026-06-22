package defpackage;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes.dex */
public final class jq extends DataSetObserver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ jq(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.a) {
            case 0:
                kq kqVar = (kq) this.b;
                kqVar.mDataValid = true;
                kqVar.notifyDataSetChanged();
                break;
            case 1:
                ((TabLayout) this.b).i();
                break;
            default:
                ((ViewPager) this.b).e();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.a) {
            case 0:
                kq kqVar = (kq) this.b;
                kqVar.mDataValid = false;
                kqVar.notifyDataSetInvalidated();
                break;
            case 1:
                ((TabLayout) this.b).i();
                break;
            default:
                ((ViewPager) this.b).e();
                break;
        }
    }
}
