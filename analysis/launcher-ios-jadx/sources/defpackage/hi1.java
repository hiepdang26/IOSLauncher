package defpackage;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class hi1 implements TextWatcher, SpanWatcher {
    public final Object g;
    public final AtomicInteger h = new AtomicInteger(0);

    public hi1(Object obj) {
        this.g = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.g).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.g).beforeTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (this.h.get() <= 0 || !(obj instanceof up1)) {
            ((SpanWatcher) this.g).onSpanAdded(spannable, obj, i, i2);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        if (this.h.get() <= 0 || !(obj instanceof up1)) {
            ((SpanWatcher) this.g).onSpanChanged(spannable, obj, i, i2, i3, i4);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (this.h.get() <= 0 || !(obj instanceof up1)) {
            ((SpanWatcher) this.g).onSpanRemoved(spannable, obj, i, i2);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.g).onTextChanged(charSequence, i, i2, i3);
    }
}
