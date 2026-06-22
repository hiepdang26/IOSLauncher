package defpackage;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
public final class mq extends Filter {
    public kq a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return this.a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorRunQueryOnBackgroundThread = this.a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorRunQueryOnBackgroundThread != null) {
            filterResults.count = cursorRunQueryOnBackgroundThread.getCount();
            filterResults.values = cursorRunQueryOnBackgroundThread;
            return filterResults;
        }
        filterResults.count = 0;
        filterResults.values = null;
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        kq kqVar = this.a;
        Cursor cursor = kqVar.getCursor();
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        kqVar.changeCursor((Cursor) obj);
    }
}
