package defpackage;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.a;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class sg extends m81 {
    public final /* synthetic */ int j;
    public ArrayList k;
    public ua l;

    public static String p(int i, Resources resources) {
        switch (i) {
            case 1:
                return resources.getString(w61.game);
            case 2:
                return resources.getString(w61.audio);
            case 3:
                return resources.getString(w61.video);
            case 4:
                return resources.getString(w61.image);
            case 5:
                return resources.getString(w61.social);
            case 6:
                return resources.getString(w61.news);
            case 7:
                return resources.getString(w61.maps);
            case 8:
                return resources.getString(w61.productivity);
            default:
                return resources.getString(w61.other);
        }
    }

    @Override // defpackage.m81
    public final int c() {
        switch (this.j) {
            case 0:
                try {
                    ArrayList arrayList = this.k;
                    if (arrayList != null) {
                        return arrayList.size();
                    }
                    return 0;
                } catch (Throwable unused) {
                    return 0;
                }
            case 1:
                try {
                    ArrayList arrayList2 = this.k;
                    if (arrayList2 != null) {
                        return arrayList2.size();
                    }
                    return 0;
                } catch (Throwable unused2) {
                    return 0;
                }
            default:
                try {
                    ArrayList arrayList3 = this.k;
                    if (arrayList3 != null) {
                        return arrayList3.size();
                    }
                    return 0;
                } catch (Throwable unused3) {
                    return 0;
                }
        }
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        switch (this.j) {
            case 0:
                rg rgVar = (rg) m91Var;
                AppsLibraryCategoryActivity appsLibraryCategoryActivity = (AppsLibraryCategoryActivity) this.l;
                View view = rgVar.g;
                AppCompatImageView appCompatImageView = rgVar.B;
                sg sgVar = rgVar.D;
                try {
                    rgVar.A.setText(((y6) sgVar.k.get(i)).c);
                    a.f(appCompatImageView).p(((y6) sgVar.k.get(i)).b).L(appCompatImageView);
                    rgVar.C.setText(p(((y6) sgVar.k.get(i)).e, view.getResources()));
                    view.setOnClickListener(new qg(rgVar, i, appsLibraryCategoryActivity));
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 1:
                se0 se0Var = (se0) m91Var;
                try {
                    TextView textView = se0Var.A;
                    AppCompatImageView appCompatImageView2 = se0Var.B;
                    textView.setText(((y6) this.k.get(i)).c);
                    a.f(appCompatImageView2).p(((y6) this.k.get(i)).b).L(appCompatImageView2);
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
                break;
            default:
                ij0 ij0Var = (ij0) m91Var;
                try {
                    TextViewCustomFont textViewCustomFont = ij0Var.A;
                    AppCompatImageView appCompatImageView3 = ij0Var.B;
                    textViewCustomFont.setText(((y6) this.k.get(i)).c);
                    a.f(appCompatImageView3).p(((y6) this.k.get(i)).b).L(appCompatImageView3);
                } catch (Throwable th3) {
                    th3.getMessage();
                }
                break;
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        switch (this.j) {
            case 0:
                return new rg(this, LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_change_category, viewGroup, false));
            case 1:
                return new se0(this, LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_change_icon, viewGroup, false));
            default:
                return new ij0(this, LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_change_label, viewGroup, false));
        }
    }
}
