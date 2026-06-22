package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class kq extends BaseAdapter implements Filterable, lq {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected iq mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected mq mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    public abstract void bindView(View view, Context context, Cursor cursor);

    public abstract void changeCursor(Cursor cursor);

    public abstract CharSequence convertToString(Cursor cursor);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // defpackage.lq
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            mq mqVar = new mq();
            mqVar.a = this;
            this.mCursorFilter = mqVar;
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.mCursor;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null && cursor.moveToPosition(i)) {
            return this.mCursor.getLong(this.mRowIDColumn);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.mCursor.moveToPosition(i)) {
            throw new IllegalStateException(k31.k(i, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = newView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    @Deprecated
    public void init(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public abstract View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public void onContentChanged() {
        Cursor cursor;
        if (!this.mAutoRequery || (cursor = this.mCursor) == null || cursor.isClosed()) {
            return;
        }
        this.mDataValid = this.mCursor.requery();
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            iq iqVar = this.mChangeObserver;
            if (iqVar != null) {
                cursor2.unregisterContentObserver(iqVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor == null) {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        iq iqVar2 = this.mChangeObserver;
        if (iqVar2 != null) {
            cursor.registerContentObserver(iqVar2);
        }
        DataSetObserver dataSetObserver2 = this.mDataSetObserver;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
        this.mDataValid = true;
        notifyDataSetChanged();
        return cursor2;
    }

    public void init(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        boolean z = cursor != null;
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        this.mRowIDColumn = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.mChangeObserver = new iq(this);
            this.mDataSetObserver = new jq(this, 0);
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            iq iqVar = this.mChangeObserver;
            if (iqVar != null) {
                cursor.registerContentObserver(iqVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }
}
