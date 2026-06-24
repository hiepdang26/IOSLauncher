# Folder Drag/Drop Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Make an opened folder behave like a mini homescreen while dragging apps: hover-open, drag inside, page-scroll at folder edges, live reorder, full-page overflow, drag back out, cancel safely, and commit only on drop.

**Architecture:** Keep pure placement and transition decisions in small policy objects with unit tests, then wire them into `LauncherActivity`. During drag, maintain an explicit folder drag session that can temporarily preview changes in memory, then either commit them to `FolderItem.items`/DB on drop or restore the original state on cancel/exit. Reuse existing launcher patterns: `Alarm` for delayed actions, `ViewPager` folder pages, `LauncherHomeCellPolicy`-style cell math, `makeAppWobble`, `updateIcon`, and `DatabaseManager.saveLayouts`.

**Tech Stack:** Kotlin, Android Views, `ViewPager`, `GridLayout`, existing launcher `Alarm`, JUnit unit tests, Gradle `ios17launcher` module.

---

## File Structure

- Create: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/FolderDragSessionPolicy.kt`
  - Pure decisions for folder page/cell mapping, full-page overflow, edge paging, exit threshold, and collision preview.
- Create: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/FolderDragSessionPolicyTest.kt`
  - Unit tests for every policy rule before UI wiring.
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`
  - Add folder drag session state, folder drag-location/drop handling, page scrolling, preview reorder, commit/cancel/restore paths.
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/FolderHoverOpenPolicy.kt`
  - Keep hover-open checks, add any small origin/inside/outside checks only if they remain pure.
- Modify: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/FolderHoverOpenPolicyTest.kt`
  - Extend only if hover/open origin rules change.

---

### Task 1: Folder Drag Policy Tests

**Files:**
- Create: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/FolderDragSessionPolicyTest.kt`
- Create: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/FolderDragSessionPolicy.kt`

- [ ] **Step 1: Write failing tests for page capacity and first available slot**

Add tests that prove:
- A folder page has 9 slots.
- If page 0 has 9 occupied cells, a new dragged app previews on page 1, cell 0.
- If pages 0 and 1 are full, preview goes to page 2, cell 0.

Expected command:
`rtk sh ./gradlew :ios17launcher:testDebugUnitTest --tests 'com.cloudx.ios17.features.launcher.FolderDragSessionPolicyTest'`

Expected result before implementation:
`Unresolved reference 'FolderDragSessionPolicy'`.

- [ ] **Step 2: Implement minimal page placement policy**

Create `FolderDragSessionPolicy` with:
- `const val FOLDER_COLUMNS = 3`
- `const val FOLDER_ROWS = 3`
- `const val ITEMS_PER_PAGE = 9`
- `data class FolderPlacement(val page: Int, val cell: Int)`
- `fun absoluteCell(page: Int, cell: Int): Int`
- `fun pageForCell(cell: Int): Int`
- `fun cellInPage(cell: Int): Int`
- `fun firstAvailablePlacement(occupiedCells: Set<Int>, startPage: Int): FolderPlacement`

- [ ] **Step 3: Write failing tests for edge paging**

Add tests that prove:
- Drag near left edge on page 1 returns page 0.
- Drag near right edge on page 0 returns page 1.
- Drag in center returns current page.
- Drag right on last page does not exceed last page unless caller explicitly creates a preview page.

- [ ] **Step 4: Implement edge paging policy**

Add:
- `fun edgeTargetPage(x: Float, width: Int, currentPage: Int, pageCount: Int, edgeSizePx: Int): Int`

- [ ] **Step 5: Write failing tests for folder exit threshold**

Add tests that prove:
- A point barely outside the folder panel does not exit.
- A point outside by more than threshold exits.

- [ ] **Step 6: Implement exit threshold policy**

Add:
- `fun shouldExitFolder(x: Float, y: Float, left: Int, top: Int, right: Int, bottom: Int, thresholdPx: Int): Boolean`

- [ ] **Step 7: Write failing tests for collision preview**

Add tests that prove:
- Moving into an occupied folder cell shifts the occupied app forward.
- If the current page is full, shifting can push an item to the next folder page.
- Moving to an empty cell does not shift unrelated items.

- [ ] **Step 8: Implement collision preview policy**

Add a pure result type:
- `data class FolderCollisionPreview(val movingCell: Int, val displacedCells: Map<Int, Int>)`
- `fun collisionPreview(movingCell: Int?, targetCell: Int, occupiedCells: Set<Int>, maxCells: Int): FolderCollisionPreview`

Use deterministic forward shifting to find the next free cell. If no free cell exists inside `maxCells`, use `maxCells` as the new overflow cell so the caller can create a new page.

- [ ] **Step 9: Run policy tests**

Run:
`rtk sh ./gradlew :ios17launcher:testDebugUnitTest --tests 'com.cloudx.ios17.features.launcher.FolderDragSessionPolicyTest'`

Expected:
`BUILD SUCCESSFUL`.

---

### Task 2: Add Explicit Folder Drag Session State

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`

- [ ] **Step 1: Add session fields**

Add state near current drag fields:
- `private var folderDragSession: FolderDragSession? = null`
- `private val mFolderPageScrollAlarm = Alarm()`

Add a private data class inside `LauncherActivity`:
- `FolderDragSession`
- fields: `folder`, `folderView`, `moving`, `origin`, `originParent`, `originIndex`, `originContainer`, `originScreenId`, `originCell`, `previewAddedToFolder`, `lastPreviewCell`

Use origin values:
- `FROM_HOME_TO_FOLDER`
- `FROM_FOLDER_TO_HOME`
- `WITHIN_FOLDER`

- [ ] **Step 2: Initialize session when folder opens by hover**

In `FolderHoverOpenAlarmListener.onAlarm`, after `displayFolder`, create a session with origin `FROM_HOME_TO_FOLDER` if the moving app is external to `targetItem`.

- [ ] **Step 3: Initialize session when dragging an existing folder app**

At drag start, if `mFolderWindowContainer.visibility == VISIBLE` and `activeFolder` owns `moving.launcherItem.container`, create origin `WITHIN_FOLDER`.

- [ ] **Step 4: Add reset/cancel helpers**

Add:
- `cancelFolderDragSession(restoreOriginal: Boolean)`
- `restoreFolderDragOrigin(session: FolderDragSession)`
- `finishFolderDragSession()`

These helpers must restore `container`, `screenId`, `cell`, parent view, adapter state, and folder icon if a drag is canceled.

---

### Task 3: Route Folder Drag Location Before Generic Folder Drop

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`

- [ ] **Step 1: Replace simple folder-visible location handling**

Current logic only calls `handleOpenFolderDragLocation(cX, cY)` and returns. Replace it with:
- `handleFolderDragLocation(cX, cY)`
- return true when folder is visible and a session exists.

- [ ] **Step 2: Convert screen coordinates to folder page coordinates**

Add:
- `folderBoundsOnScreen(): Rect`
- `folderDropCellForCurrentPage(x: Float, y: Float): Int`

Use the current folder page grid from `mFolderAppsViewPager.currentItem`.

- [ ] **Step 3: Detect inside/exit**

Inside `handleFolderDragLocation`:
- If point is inside folder panel, mark session as inside.
- If point exits beyond threshold, call `handleFolderDragExitToHome(cX, cY)`.
- If point is barely outside threshold, do nothing to prevent flicker.

---

### Task 4: Full Page Overflow and Edge Paging Inside Folder

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`

- [ ] **Step 1: Ensure folder preview page exists**

Add:
- `ensureFolderPageForCell(folder: FolderItem, absoluteCell: Int)`

If the target cell belongs to a page beyond current adapter count, refresh adapter and set `mFolderAppsViewPager.currentItem`.

- [ ] **Step 2: Auto-pick next available page on first folder enter**

When an external app first enters the folder:
- Build `occupiedCells` from `folder.items`.
- Use `FolderDragSessionPolicy.firstAvailablePlacement`.
- If current page is full, switch to the returned page.

- [ ] **Step 3: Edge-scroll left/right inside folder**

Add:
- `scheduleFolderPageScrollIfNeeded(targetPage: Int)`
- `cancelFolderPageScroll()`

Use `mFolderPageScrollAlarm` to avoid repeated rapid page switches. When the drag is near left/right edge of the folder panel, scroll `mFolderAppsViewPager` to the target page, then continue previewing reorder on the new page.

---

### Task 5: Live Reorder Preview Inside Folder

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`

- [ ] **Step 1: Add preview insertion for external app**

When dragging from homescreen into folder:
- Remove `moving` from its original parent only after folder entry is confirmed.
- Temporarily set app `container = activeFolder.id`.
- Temporarily add app to `activeFolder.items`.
- Store all original metadata in the session for cancel/exit restore.

- [ ] **Step 2: Add preview reorder**

Add:
- `previewFolderDrop(session: FolderDragSession, targetPage: Int, targetCell: Int)`

This updates in-memory `cell` values using `FolderDragSessionPolicy.collisionPreview`, refreshes the folder adapter, keeps folder icons wobbling, and does not save DB.

- [ ] **Step 3: Keep folder items ordered**

Add:
- `normalizeFolderItemOrder(folder: FolderItem)`

Sort by `cell`, then assign cells `0..n-1` after final commit. During preview, preserve computed cells so page transitions render correctly.

---

### Task 6: Drag Out of Folder Like iOS

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`

- [ ] **Step 1: External app dragged out after hover-open**

If origin is `FROM_HOME_TO_FOLDER` and user exits folder:
- Remove temporary preview item from `activeFolder.items`.
- Restore app metadata and original parent/index.
- Close folder.
- Continue drag over homescreen using existing homescreen reorder logic.

- [ ] **Step 2: Existing folder app dragged out**

If origin is `WITHIN_FOLDER` and user exits folder:
- Remove the item from `activeFolder.items` in memory.
- Refresh folder adapter and folder icon preview.
- Close folder.
- Attach the moving view to the current homescreen page under the drag position.
- Continue homescreen reorder/edge-scroll/drop.

- [ ] **Step 3: Cancel after dragging out**

If drag ends with `dragEvent.result == false`:
- Restore the item to original folder for `WITHIN_FOLDER`.
- Restore original home/dock position for `FROM_HOME_TO_FOLDER`.
- Refresh folder icon and save nothing.

- [ ] **Step 4: Commit after dragging out**

If app from folder is dropped on homescreen:
- Remove it from folder permanently.
- If folder becomes empty, remove folder view and DB item.
- If folder has one item left, follow existing one-item folder collapse behavior.
- If folder has multiple items left, update folder icon and save layout.

---

### Task 7: Drop Commit Inside Folder

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`

- [ ] **Step 1: Replace `commitExternalDropIntoOpenFolder`**

Rename/split into:
- `commitFolderDrop(session: FolderDragSession)`
- `commitFolderDropInside(session: FolderDragSession)`
- `commitFolderDropOutside(session: FolderDragSession, cX: Float, cY: Float)`

- [ ] **Step 2: Save only on real drop**

On successful inside-folder drop:
- Normalize folder item order.
- Set each item `container = folder.id`, `screenId = -1`, `cell = index`.
- Refresh adapter, icon, badge.
- Save `DatabaseManager.getManager(this).saveLayouts(pages, mDock)`.

---

### Task 8: Verification

**Files:**
- Test: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/FolderDragSessionPolicyTest.kt`
- Existing test: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/FolderHoverOpenPolicyTest.kt`

- [ ] **Step 1: Run focused tests**

Run:
`rtk sh ./gradlew :ios17launcher:testDebugUnitTest --tests 'com.cloudx.ios17.features.launcher.FolderDragSessionPolicyTest' --tests 'com.cloudx.ios17.features.launcher.FolderHoverOpenPolicyTest'`

Expected:
`BUILD SUCCESSFUL`.

- [ ] **Step 2: Compile/build launcher module**

Run:
`rtk sh ./gradlew :ios17launcher:assembleDebug`

Expected:
`BUILD SUCCESSFUL`.

- [ ] **Step 3: Manual QA on device/emulator**

Verify these flows:
- Drag app onto folder and hold: folder opens.
- If first folder page is full, app previews on next page.
- Drag near folder right edge: folder page advances.
- Drag near folder left edge: folder page goes back.
- Drag app over another folder app: target app shifts live before drop.
- Drop inside folder: item stays and persists after restart.
- Drag external app out before drop: folder closes, app remains on homescreen.
- Drag existing folder app out: folder closes, app can be dropped on homescreen.
- Cancel drag after entering/exiting: layout restores.
- Folder empty/one-item cleanup still matches existing launcher behavior.

---

## Self-Review

- Coverage: Plan covers hover-open continuation, full folder pages, edge paging, live reorder, drag out to homescreen, cancel restore, commit persistence, and verification.
- Placeholder scan: No `TBD`, `TODO`, or unresolved task names are intentionally left.
- Scope check: All changes stay in `ios17launcher` launcher UI and pure policy tests; no module `app` changes.
- Risk: `LauncherActivity.kt` is large, so implementation should be done in small tested steps and avoid unrelated refactors.
