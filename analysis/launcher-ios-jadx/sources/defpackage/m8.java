package defpackage;

import android.widget.Filter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m8 extends Filter {
    public final /* synthetic */ int a;
    public final /* synthetic */ m81 b;

    public /* synthetic */ m8(m81 m81Var, int i) {
        this.a = i;
        this.b = m81Var;
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        CharSequence charSequence2;
        switch (this.a) {
            case 0:
                ArrayList arrayList = new ArrayList();
                q8 q8Var = (q8) this.b;
                if (charSequence != null) {
                    try {
                        if (charSequence.length() == 0) {
                            arrayList.addAll(q8Var.j);
                        } else {
                            String strTrim = charSequence.toString().toLowerCase().trim();
                            q8Var.j.size();
                            ArrayList arrayList2 = q8Var.j;
                            int size = arrayList2.size();
                            int i = 0;
                            while (i < size) {
                                Object obj = arrayList2.get(i);
                                i++;
                                w6 w6Var = (w6) obj;
                                if (w6Var != null && w6Var.b() == 1 && w6Var.a() != null && w6Var.a().toLowerCase().contains(strTrim)) {
                                    arrayList.add(w6Var);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                } else {
                    arrayList.addAll(q8Var.j);
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            default:
                ArrayList arrayList3 = new ArrayList();
                ue1 ue1Var = (ue1) this.b;
                if (charSequence != null) {
                    try {
                        if (charSequence.length() == 0) {
                            arrayList3.addAll(ue1Var.p());
                        } else {
                            String strTrim2 = charSequence.toString().toLowerCase().trim();
                            ue1Var.k.size();
                            ArrayList arrayList4 = ue1Var.k;
                            int size2 = arrayList4.size();
                            int i2 = 0;
                            while (i2 < size2) {
                                Object obj2 = arrayList4.get(i2);
                                i2++;
                                v6 v6Var = (v6) obj2;
                                if (v6Var != null && (charSequence2 = v6Var.u) != null && charSequence2.toString().toLowerCase().contains(strTrim2)) {
                                    arrayList3.add(v6Var);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                } else {
                    arrayList3.addAll(ue1Var.p());
                }
                Filter.FilterResults filterResults2 = new Filter.FilterResults();
                filterResults2.values = arrayList3;
                return filterResults2;
        }
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        switch (this.a) {
            case 0:
                if (filterResults.values != null) {
                    q8 q8Var = (q8) this.b;
                    q8Var.k.clear();
                    q8Var.k.addAll((ArrayList) filterResults.values);
                    q8Var.f();
                }
                break;
            default:
                if (filterResults.values != null) {
                    ue1 ue1Var = (ue1) this.b;
                    ue1Var.l.clear();
                    ue1Var.l.addAll((ArrayList) filterResults.values);
                    ue1Var.f();
                }
                break;
        }
    }
}
