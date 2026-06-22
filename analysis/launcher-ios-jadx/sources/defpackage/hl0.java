package defpackage;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public interface hl0 {
    void bindAllApplications(ArrayList arrayList);

    void bindAppInfosRemoved(ArrayList arrayList);

    void bindAppWidget(qk0 qk0Var);

    void bindAppsAdded(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4);

    void bindAppsUpdated(ArrayList arrayList);

    void bindFolders(wp0 wp0Var);

    void bindItems(ArrayList arrayList, int i, int i2, boolean z);

    void bindRestoreItemsChange(HashSet hashSet);

    void bindScreens(ArrayList arrayList);

    void bindShortcutsChanged(ArrayList arrayList, ArrayList arrayList2, jq1 jq1Var);

    void bindShortcutsHidden(ArrayList arrayList, ArrayList arrayList2, jq1 jq1Var);

    void bindWidgetsModel(qx1 qx1Var);

    void bindWidgetsRestored(ArrayList arrayList);

    void bindWorkspaceComponentsRemoved(HashSet hashSet, HashSet hashSet2, jq1 jq1Var);

    void finishBindingItems();

    int getCurrentWorkspaceScreen();

    boolean isAllAppsButtonRank(int i);

    void notifyWidgetProvidersChanged();

    void onAllAppsChanged(ArrayList arrayList);

    void onPageBoundSynchronously(int i);

    boolean setLoadOnResume();

    void startBinding();
}
