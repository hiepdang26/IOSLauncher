package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.util.DeleteCircleView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class mm0 extends td {
    public final wq j;
    public final ArrayList k;
    public wq l;

    public mm0(wq wqVar, ArrayList arrayList) {
        this.j = wqVar;
        this.k = arrayList;
    }

    @Override // defpackage.m81
    public final int c() {
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            return arrayList.size() + 1;
        }
        return 1;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        ArrayList arrayList = this.k;
        if (arrayList == null) {
            return 0;
        }
        if (i == c() - 1) {
            return 100;
        }
        return ((hm0) arrayList.get(i)).e;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, final int i) {
        if (m91Var instanceof km0) {
            m91Var.g.setOnClickListener(new g7(this, 8));
            ((ri1) ((km0) m91Var).g.getLayoutParams()).f = true;
            return;
        }
        if (m91Var instanceof lm0) {
            lm0 lm0Var = (lm0) m91Var;
            DeleteCircleView deleteCircleView = lm0Var.A;
            if (deleteCircleView != null) {
                deleteCircleView.setOnClickListener(new View.OnClickListener() { // from class: im0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        mm0 mm0Var;
                        mm0 mm0Var2 = this.g;
                        if (mm0Var2.l != null) {
                            ArrayList arrayList = mm0Var2.k;
                            int size = arrayList.size();
                            int i2 = i;
                            if (i2 < size) {
                                wq wqVar = mm0Var2.l;
                                hm0 hm0Var = (hm0) arrayList.get(i2);
                                if (wqVar.r == null || (mm0Var = wqVar.u) == null) {
                                    return;
                                }
                                ArrayList arrayList2 = mm0Var.k;
                                arrayList2.remove(i2);
                                n81 n81Var = mm0Var.g;
                                n81Var.f(i2, 1);
                                n81Var.d(i2, arrayList2.size(), null);
                                new Thread(new sq(wqVar, hm0Var, 0)).start();
                            }
                        }
                    }
                });
            }
            if (((hm0) this.k.get(i)).e % 10 >= 1) {
                ((ri1) lm0Var.g.getLayoutParams()).f = true;
            }
            wq wqVar = this.j;
            if (wqVar != null) {
                if (wqVar.w) {
                    lm0Var.w();
                } else {
                    lm0Var.v();
                }
            }
            m91Var.g.setOnLongClickListener(new View.OnLongClickListener() { // from class: jm0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    wq wqVar2 = this.g.l;
                    if (wqVar2 == null || wqVar2.w) {
                        return true;
                    }
                    wqVar2.o.setVisibility(0);
                    wqVar2.n.setVisibility(0);
                    wqVar2.o();
                    return true;
                }
            });
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        View viewInflate;
        if (i == 10) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_weather_2x2, viewGroup, false);
        } else if (i == 11) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_weather_2x4, viewGroup, false);
        } else if (i == 20) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_clock_2x2, viewGroup, false);
        } else if (i == 21) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_clock_2x4, viewGroup, false);
        } else if (i == 30) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_photo_2x2, viewGroup, false);
        } else {
            if (i == 100) {
                return new km0(LayoutInflater.from(viewGroup.getContext()).inflate(m61.edit_widget_button, viewGroup, false));
            }
            viewInflate = i != 40 ? i != 41 ? (i == 50 || i == 51) ? LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_favorite_contact_2x4, viewGroup, false) : i != 60 ? i != 61 ? (i == 70 || i == 71) ? LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_suggestion_2x4, viewGroup, false) : null : LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_battery_2x4, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_battery_2x2, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_calendar_2x4, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(m61.widget_calendar_2x2, viewGroup, false);
        }
        return new lm0(viewInflate);
    }

    @Override // defpackage.m81
    public final void l(m91 m91Var) {
        wq wqVar;
        if (!(m91Var instanceof lm0) || (wqVar = this.j) == null) {
            return;
        }
        if (wqVar.w) {
            ((lm0) m91Var).w();
        } else {
            ((lm0) m91Var).v();
        }
    }

    @Override // defpackage.m81
    public final void m(m91 m91Var) {
        if (m91Var instanceof lm0) {
            ((lm0) m91Var).v();
        }
    }

    @Override // defpackage.m81
    public final void n(m91 m91Var) {
    }
}
