# Hidden Apps Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Add an iOS-style Hidden Apps screen from the launcher options menu and hide selected apps from the home screen.

**Architecture:** Keep hidden app state as launcher item ids in SharedPreferences, expose pure filtering/section logic through `HiddenAppsPolicy`, and build a full-screen overlay inside `LauncherActivity`. The overlay edits hidden ids, animates rows between visible/hidden sections, and re-renders the launcher with hidden items filtered out.

**Tech Stack:** Kotlin, Android Views, SharedPreferences, JUnit 4, Gradle `testDebugUnitTest`.

---

### Task 1: Hidden Apps Policy

**Files:**
- Create: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/HiddenAppsPolicy.kt`
- Test: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/HiddenAppsPolicyTest.kt`

- [ ] Write failing tests for filtering desktop/dock apps, removing hidden children from folders, preserving non-hidden folder children, and section ordering.
- [ ] Run the targeted test and confirm it fails because the policy does not exist.
- [ ] Implement the pure policy.
- [ ] Run the targeted test and confirm it passes.

### Task 2: Launcher Integration

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/LauncherActivity.kt`
- Modify: `ios17launcher/src/main/res/values/strings.xml`

- [ ] Add SharedPreferences helpers for hidden app ids.
- [ ] Filter `launcherItems` before `createUI`.
- [ ] Wire popup `hideButton` to open the Hidden Apps overlay.
- [ ] Build overlay rows for hidden and visible apps with plus/minus controls and layout transition animation.
- [ ] Close the overlay from back/home and re-render the home screen after edits.

### Task 3: Verification

- [ ] Run targeted policy tests.
- [ ] Run `:ios17launcher:compileDebugKotlin`.
- [ ] Run `:ios17launcher:testDebugUnitTest` if the current workspace compiles.
