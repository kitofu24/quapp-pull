# Pending UI and design backfill

Append the progress entry below to Projects/Quapp/PROGRESS.md, Projects/Quapp/WORKLOG.md, and Daily/2026-10-13.md. Append the decision and design entries to their matching notes. Update Projects/Quapp.md with current status and next actions. Read destinations first, preserve wikilinks, check duplicates, and verify each write.

### 2026-10-13 03:57 UTC+08:00 | Model: Model unknown

Project: Quapp. Source: current Codex conversation; chat title/link unavailable. Backfill recorded now from accessible chat history and current files. Earlier changes occurred before this entry; exact event times and writer model are unavailable.

Changes:
- Open queuer queue cards now show estimated wait as the main 26sp value, with people in line and serving number as wrapping supporting text. Owner and non-open cards retain compact metrics.
- Queue-list card rotation was removed to reduce visual clutter. Existing texture remains; this was not a complete texture redesign.
- LoadingStateHelper announces loading, empty, and error transitions, with attachment/visibility guards. Duplicate live-region announcements were removed. The error icon is decorative.
- Browse keeps cached content on refresh errors and offers Retry and last-updated information in a multiline Snackbar. Successful refresh and view destruction dismiss the error.
- Six queue-list artboards and design notes were updated in the 64-screen export. The offline gallery and ZIP were rebuilt with embedded fonts. Added tools/rebuild-gallery.ps1.
- Earlier centered splash implementation was visually checked on Xiaomi. Folder navigation and debugging guides were added; the later navigation pass checked 30 local links.

Why: make queues easier to compare, reduce crowded lists, improve recovery and accessibility, keep visual references current, and make project files easier to find.

Affected areas: QueueCards.java, QueueAdapter.java, item_queue_card.xml, LoadingStateHelper.java, view_loading_state.xml, view_error_state.xml, fragment_browse.xml, BrowseFragment.java, strings.xml, DESIGN.md, artifacts/quapp-civic-paper/, standalone gallery/ZIP, tools/rebuild-gallery.ps1, README.md, docs/, app/README.md, and obsidian-starter/README.md.

Verification:
- Final Android unit tests, lint, and debug APK assembly passed using temporary Gradle build/cache directories after locked workspace outputs prevented the ordinary build.
- Rebuilt ZIP passed archive integrity checks and contains 64 artboards. The gallery rebuild PowerShell script has not been verified end to end; generated outputs were rebuilt through the equivalent file-generation workflow.
- Earlier Xiaomi screenshots verified the centered splash and Browse at normal and 200% text. The final Android revision was not reinstalled after subsequent accessibility fixes.
- Pixel testing, spoken TalkBack announcements, complete app-flow testing, and final gallery visual review remain pending. Build success does not establish these checks.

Current status: implementation and build verification complete for the changes described; device/accessibility checks remain partial. Older entries remain historical snapshots and are superseded by this checkpoint only where their status differs.

Next actions: install the final APK; check Pixel and Xiaomi at normal/200% text with TalkBack; inspect the final gallery; verify the gallery rebuild script; reconcile staged Obsidian records without duplicates.

Vault status: previous append attempt returned Windows Access denied. A matching pending record is staged under obsidian-starter/pending-ui-design-progress-backfill.md until vault destination reads verify successful saves.

### 2026-10-13 03:57 UTC+08:00 | Model: Model unknown

Project: Quapp. Source: current Codex conversation; chat title/link unavailable. Backfill recorded now from accessible chat history and current files. Earlier changes occurred before this entry; exact event times and writer model are unavailable.

Confirmed decisions from the user's six-point UI request:
- Make estimated wait the main comparison value on open queuer cards.
- Keep cards straight in scrolling lists to reduce visual density.
- Keep the exported screen reference aligned with the newer catalogue-card direction.
- Announce loading/empty/error transitions and make the redundant error icon decorative.
- Preserve cached Browse results during refresh failure and provide Retry plus last-updated information.
- Require normal/200% text, centered splash, Pixel/Xiaomi, and TalkBack checks before claiming device/accessibility verification complete.

Status: implemented as described in [the latest progress checkpoint](PROGRESS.md); device verification is partial. This supersedes earlier equal-weight queue metrics and tilted-list presentation where those conflict. Earlier decision history is retained; current card details are in [DESIGN.md](DESIGN.md).

Additional confirmed workflow: continue unfinished organization through the hourly follow-up when usage permits, following the user's latest continue request. It cannot bypass usage limits.

### 2026-10-13 03:57 UTC+08:00 | Model: Model unknown

Project: Quapp. Source: current Codex conversation; chat title/link unavailable. Backfill recorded now from accessible chat history and current files. Earlier changes occurred before this entry; exact event times and writer model are unavailable.

Current implemented design update:
- Open queuer catalogue cards: estimated wait is the main 26sp value; people in line and serving number sit below as wrapping supporting text. Owner/non-open cards use compact metrics.
- Queue lists use straight cards. Texture was not removed across the design system.
- Loading, empty, and error states trigger explicit accessibility announcements; redundant error artwork is decorative. Spoken behavior still needs TalkBack verification.
- Cached Browse errors retain content and show Retry and last-updated text; the Snackbar allows multiple lines for large text.
- Six queue-list artboards in the 64-screen export were updated and the offline gallery/ZIP rebuilt. These are a visual reference, not proof of Android behavior.

Verification: earlier Xiaomi normal/200% Browse and centered splash screenshots were inspected. Pixel, spoken TalkBack, final-revision device checks, and final gallery visual inspection remain pending. See [PROGRESS.md](PROGRESS.md) for build results and next actions.
