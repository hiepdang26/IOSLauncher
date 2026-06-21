# iOS17 Drag Drop Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Make home, dock, folder, page, and drag animation behavior match the relevant parts of `iOS17-master` without copying design or folder-click UI.

**Architecture:** Add a pure hover/drop decision policy and reuse it from existing RecyclerView callbacks. Keep current `ViewPager2` and adapter structure.

**Tech Stack:** Kotlin, Android RecyclerView, ViewPager2, ItemTouchHelper, JUnit4.

---

### Task 1: Hover Drop Policy

**Files:**
- Create: `app/src/main/java/com/vhmsoft/launcherios26/ui/launcher/workspace/LauncherHomeHoverDropPolicy.kt`
- Create: `app/src/test/java/com/vhmsoft/launcherios26/ui/launcher/workspace/LauncherHomeHoverDropPolicyTest.kt`

- [ ] Write tests for center app-to-app, center app-to-folder, edge reorder, folder drag, and placeholder target.
- [ ] Run `./gradlew testDebugUnitTest --tests com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeHoverDropPolicyTest` and verify it fails because the policy does not exist.
- [ ] Implement the policy.
- [ ] Run the same test and verify it passes.

### Task 2: Home Drag Callback

**Files:**
- Modify: `app/src/main/java/com/vhmsoft/launcherios26/ui/launcher/workspace/LauncherDragCallback.kt`

- [ ] Wire `findHomeHoverTarget` through `LauncherHomeHoverDropPolicy`.
- [ ] Update release-time folder target detection so app targets and folder targets both work, but only in the center zone.
- [ ] Run `./gradlew testDebugUnitTest --tests com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeHoverDropPolicyTest --tests com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherFolderDropCommitResolverTest`.

### Task 3: Dock And Home-to-Dock Targeting

**Files:**
- Modify: `app/src/main/java/com/vhmsoft/launcherios26/ui/launcher/workspace/LauncherDockDragCallback.kt`
- Modify: `app/src/main/java/com/vhmsoft/launcherios26/ui/launcher/IOSLauncherActivity.kt`

- [ ] Use the same policy for dock drag hover targets.
- [ ] Use the same policy for home-to-dock preview and commit target selection.
- [ ] Keep dock overflow and home insertion handled by existing resolvers.
- [ ] Run dock/home resolver tests.

### Task 4: Verification

**Files:**
- No new files.

- [ ] Run `./gradlew testDebugUnitTest`.
- [ ] If available, build with `./gradlew assembleDebug`.
- [ ] Report any pre-existing dirty files and any verification limitations.
