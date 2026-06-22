package defpackage;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public abstract class d11 {
    public final DataSetObservable a = new DataSetObservable();
    public DataSetObserver b;

    public abstract void a(ViewPager viewPager, Object obj);

    public abstract int c();

    public int d() {
        return -1;
    }

    public abstract Object e(ViewPager viewPager, int i);

    public abstract boolean f(View view, Object obj);

    public final void g() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.notifyChanged();
    }

    public final void i(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    public void b() {
    }

    public void h(Object obj) {
    }

    public void j(ViewPager viewPager) {
    }
}
