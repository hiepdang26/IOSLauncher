package defpackage;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.a;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b8 extends m81 {
    public final /* synthetic */ int j;
    public ArrayList k;
    public Activity l;
    public Object m;
    public KeyEvent.Callback n;

    public /* synthetic */ b8() {
        this.j = 1;
    }

    @Override // defpackage.m81
    public final int c() {
        switch (this.j) {
            case 0:
                ArrayList arrayList = this.k;
                if (arrayList != null) {
                    return arrayList.size() + 1;
                }
                return 0;
            default:
                ArrayList arrayList2 = this.k;
                if (arrayList2 != null) {
                    return 4 + arrayList2.size();
                }
                return 4;
        }
    }

    @Override // defpackage.m81
    public final int e(int i) {
        switch (this.j) {
            case 0:
                if (i == 0) {
                }
                break;
            default:
                if (i == 0) {
                }
                break;
        }
        return 1;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        int i2;
        switch (this.j) {
            case 0:
                if (m91Var instanceof z7) {
                    z7 z7Var = (z7) m91Var;
                    z7Var.A.setText((String) this.m);
                    z7Var.g.setOnClickListener(new g7(this, 1));
                } else if (m91Var instanceof a8) {
                    a8 a8Var = (a8) m91Var;
                    BubbleTextView bubbleTextView = a8Var.A;
                    ArrayList arrayList = this.k;
                    int i3 = i - 1;
                    bubbleTextView.setTag(arrayList.get(i3));
                    a8Var.A.l((v6) arrayList.get(i3));
                    BubbleTextView bubbleTextView2 = a8Var.A;
                    t tVar = (t) this.l;
                    Objects.requireNonNull(tVar);
                    bubbleTextView2.setOnClickListener(new y7(tVar, 0));
                }
                break;
            default:
                if (m91Var instanceof s91) {
                    WallpaperActivity wallpaperActivity = (WallpaperActivity) this.l;
                    if (i > 3) {
                        ArrayList arrayList2 = this.k;
                        if (arrayList2 != null && arrayList2.size() > i - 4) {
                            ((na1) a.e(wallpaperActivity).s(((qv1) this.k.get(i2)).b).U().V(fx.b(250)).c()).L(((s91) m91Var).A);
                            break;
                        }
                    } else if (i == 1) {
                        ((s91) m91Var).A.setImageResource(l51.ic_add_image);
                        break;
                    } else if (i == 2) {
                        ((na1) a.e(wallpaperActivity).r(Integer.valueOf(q61.wallpaper_default_1)).c()).L(((s91) m91Var).A);
                        break;
                    } else if (i == 3) {
                        ((na1) a.e(wallpaperActivity).r(Integer.valueOf(q61.wallpaper_default_3)).c()).L(((s91) m91Var).A);
                        break;
                    }
                }
                break;
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        switch (this.j) {
            case 0:
                if (i == 0) {
                    View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.apps_library_folder_header, viewGroup, false);
                    z7 z7Var = new z7(viewInflate);
                    z7Var.A = (TextViewCustomFont) viewInflate;
                    return z7Var;
                }
                if (i != 1) {
                    throw new RuntimeException(uo.d(i, "No match for ", "."));
                }
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(m61.apps_library_folder_item, viewGroup, false);
                a8 a8Var = new a8(viewInflate2);
                if (!(viewInflate2 instanceof BubbleTextView)) {
                    return a8Var;
                }
                a8Var.A = (BubbleTextView) viewInflate2;
                return a8Var;
            default:
                LayoutInflater layoutInflater = (LayoutInflater) this.m;
                if (i != 0) {
                    return new s91(this, layoutInflater.inflate(m61.recyclerview_wallpaper_item, viewGroup, false));
                }
                View viewInflate3 = layoutInflater.inflate(m61.wallpaper_item_header_emty_view, viewGroup, false);
                r91 r91Var = new r91(viewInflate3);
                r91Var.A = viewInflate3;
                return r91Var;
        }
    }

    public b8(t tVar) {
        this.j = 0;
        this.k = new ArrayList();
        this.l = tVar;
    }
}
