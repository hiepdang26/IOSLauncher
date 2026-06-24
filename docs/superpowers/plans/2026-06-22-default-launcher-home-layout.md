# Default Launcher Home Layout Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Make the first-run iOS 17 launcher home screen show Weather, the launcher app, Play Store, and a Google folder on the first row, then fill all remaining apps from page two onward.

**Architecture:** Add a small pure policy in `features.launcher` that receives default app records, identifies priority apps and Google apps, assigns containers/screen/cell positions, and returns ordered launcher items. `AppProvider.prepareDefaultLauncherItems()` will keep existing dock selection and delegate desktop layout ordering to that policy.

**Tech Stack:** Kotlin, Android launcher model classes, JUnit 4 unit tests, Gradle `testDebugUnitTest`.

---

### Task 1: Default Home Layout Policy

**Files:**
- Create: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/DefaultLauncherHomeLayoutPolicy.kt`
- Test: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/DefaultLauncherHomeLayoutPolicyTest.kt`

- [ ] Write tests for first page ordering, Google folder contents, no duplicate Google apps, and page-two fill.
- [ ] Run targeted tests and confirm they fail because the policy does not exist.
- [ ] Implement the policy with minimal package/title matching.
- [ ] Run targeted tests and confirm they pass.

### Task 2: Wire AppProvider

**Files:**
- Modify: `ios17launcher/src/main/java/com/cloudx/ios17/features/launcher/AppProvider.kt`
- Test: `ios17launcher/src/test/java/com/cloudx/ios17/features/launcher/DefaultLauncherHomeLayoutPolicyTest.kt`

- [ ] Replace the existing alphabetical desktop default list with the policy result.
- [ ] Keep current hotseat intent detection unchanged.
- [ ] Generate the Google folder icon through existing `GraphicsUtil`.
- [ ] Run targeted tests and then the launcher unit test suite.
