package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ue0 extends BaseAdapter {
    public List g;

    @Override // android.widget.Adapter
    public final int getCount() {
        List list = this.g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List list = this.g;
        if (list != null) {
            return (Integer) list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_icon, viewGroup, false);
            view.setTag(new te0((AppCompatImageView) view.findViewById(v51.icon_choose)));
        }
        te0 te0Var = (te0) view.getTag();
        a.f(te0Var.a).r((Integer) this.g.get(i)).L(te0Var.a);
        return view;
    }
}
