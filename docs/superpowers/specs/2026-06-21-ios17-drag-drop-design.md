# iOS17 Drag Drop Behavior Design

## Goal

Port only the home-screen drag/drop behavior from `/Users/hiepdang26/Downloads/iOS17-master` into this launcher while keeping the current design and current folder-click overlay.

## Scope

- Keep existing `ViewPager2`, `RecyclerView`, XML layouts, drawable styling, and `LauncherFolderController`.
- Match the relevant `iOS17-master` behavior for home app drag/drop, folder merge, dock movement, page-edge movement, and drop animations.
- Do not replace the current launcher UI with `HorizontalPager`, `GridLayout`, `BlissFrameLayout`, or source-project design assets.
- Do not change what happens when the user taps a folder.

## Behavior

- Dragging an app over the center of another app creates a folder containing target app first, dragged app second.
- Dragging an app over the center of an existing folder adds the app to that folder.
- Dragging near the edge of an icon remains reorder/push behavior, not folder creation.
- Dragging a folder does not merge it into another app or folder.
- Dragging between home pages can switch pages and create a temporary new page when needed.
- Dragging between home and dock keeps the dock limited to four visible items and moves overflow back to the home grid.
- Drop animations keep the current app's visual style but follow the source behavior: active target scales, dragged icon is hidden/replaced by a preview, then absorbs into the target.

## Architecture

The source project does most of this in `LauncherActivity.java` drag listeners. This project already has the right architecture split across `LauncherDragCallback`, `LauncherDockDragCallback`, `LauncherPageAdapter`, `LauncherDockAdapter`, and `IOSLauncherActivity`. The port should therefore extract reusable decision logic into a small tested Kotlin policy, then wire that policy into the existing callbacks and activity helpers.

## Test Strategy

Unit tests cover the pure decision logic and existing resolver behavior. Android UI drag mechanics remain integration behavior, but the risky branch that decides "folder target vs reorder target" is tested without requiring instrumentation.
