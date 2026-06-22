package defpackage;

import android.database.Observable;
import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public final class n81 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((o81) ((Observable) this).mObservers.get(size)).a();
        }
    }

    public final void c(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((o81) ((Observable) this).mObservers.get(size)).d(i, i2);
        }
    }

    public final void d(int i, int i2, Preference preference) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((o81) ((Observable) this).mObservers.get(size)).b(i, i2, preference);
        }
    }

    public final void e(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((o81) ((Observable) this).mObservers.get(size)).c(i, i2);
        }
    }

    public final void f(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((o81) ((Observable) this).mObservers.get(size)).e(i, i2);
        }
    }
}
