package defpackage;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class bl0 implements View.OnClickListener {
    public final t g;
    public final LayoutInflater h;
    public boolean i;

    public bl0(t tVar) {
        this.g = tVar;
        this.h = LayoutInflater.from(tVar);
    }

    public final void a(View view, o1 o1Var, String str) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        view.animate().withLayer().alpha(0.0f).setDuration(200).withEndAction(new ng(this, view, str, o1Var, 2));
    }

    public final void b(boolean z) {
        this.i = true;
        int i = v51.launcher;
        t tVar = this.g;
        ViewGroup viewGroup = (ViewGroup) tVar.findViewById(i);
        int i2 = m61.longpress_cling;
        LayoutInflater layoutInflater = this.h;
        View viewInflate = layoutInflater.inflate(i2, viewGroup, false);
        viewInflate.setOnLongClickListener(new al0(this));
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(v51.cling_content);
        layoutInflater.inflate(z ? m61.longpress_cling_welcome_content : m61.longpress_cling_content, viewGroup2);
        viewGroup2.findViewById(v51.cling_dismiss_longpress_info).setOnClickListener(this);
        if ("crop_bg_top_and_sides".equals(viewGroup2.getTag())) {
            Resources resources = tVar.getResources();
            int i3 = l51.cling_background;
            Resources.Theme theme = tVar.getTheme();
            ThreadLocal threadLocal = rb1.a;
            viewGroup2.setBackground(new gd(resources.getDrawable(i3, theme)));
        }
        viewGroup.addView(viewInflate);
        if (z) {
            return;
        }
        viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(new lg(viewGroup2, 1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 1;
        int i2 = 0;
        t tVar = this.g;
        int id = view.getId();
        if (id == v51.cling_dismiss_migration_use_default) {
            tVar.showWorkspaceSearchAndHotseat();
            tVar.getWorkspace().post(new zk0(this, i2));
            return;
        }
        if (id != v51.cling_dismiss_migration_copy_apps) {
            if (id == v51.cling_dismiss_longpress_info) {
                tVar.getWorkspace().post(new zk0(this, i));
                return;
            }
            return;
        }
        rl0 model = tVar.getModel();
        model.w(false);
        model.A(-1001, 3);
        Rect rect = ar1.a;
        SharedPreferences.Editor editorEdit = tVar.getSharedPreferences("com.luutinhit.launcher6.prefs", 0).edit();
        editorEdit.putBoolean(t.USER_HAS_MIGRATED, true);
        editorEdit.apply();
        tVar.showWorkspaceSearchAndHotseat();
        tVar.getWorkspace().post(new zk0(this, i2));
    }
}
