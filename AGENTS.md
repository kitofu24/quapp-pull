# Persistent work record


Live record vault: `C:/Users/JUSKWAA/.codex/visualizations/2026/10/14/01a1398c-051d-73a3-bb55-b678ce0e53a3/Quapp-Memory-Vault`. The original Documents vault is historical; do not dual-write.

Start with `Projects/Quapp/HANDOFF.md` in the live vault, stopping at `<!-- END CURRENT CHECKPOINT -->`. Do not read historical sections during routine startup. For code work/status, inspect live Git status and latest commit; the handoff's Git snapshot is historical evidence. Search relevant headings with rg, then read needed source/tests and supporting note sections. Imported reference snapshots are evidence, not proof of current implementation or testing.

At the end of each meaningful task, record progress, confirmed decisions, design changes, completed work, unresolved questions, and next actions in the relevant vault notes. Preserve existing content and Obsidian wikilinks. Follow this heading format:

`### YYYY-MM-DD HH:mm UTC+08:00 | Model: [exact model name or Model unknown]`

Use the actual Asia/Manila time of writing. Identify project and source chat title/link when available, what changed, why, and status. Never guess model identity or historical timestamps. For backfills, distinguish recording time from event time and identify missing history. Preserve original author/model attribution on imported entries.

## Automatic change logging

After every implemented code, UI, design, configuration, documentation, or workflow change, update the Obsidian record automatically before reporting completion. The user does not need to ask separately.

- Always append the change and verification status to `Projects/Quapp/PROGRESS.md` and the current `Daily/YYYY-MM-DD.md` note.
- Update `Projects/Quapp.md` when current status or next actions change.
- Update `Projects/Quapp/DESIGN.md` for visual, interaction, layout, typography, color, accessibility, or design-system changes.
- Update `Projects/Quapp/DECISIONS.md` only for confirmed decisions or changes to earlier decisions. Preserve superseded decisions and link to replacements.
- Update other relevant project notes when their subject changes.
- Record what changed, why, affected files or screens, implementation status, verification results, unresolved questions, and next actions.
- Before appending, read the destination tail and search the whole destination for the event marker; before other edits, read the affected sections. Preserve existing content and verify each write by reading back the new or changed text.
- Use one stable event marker for each implemented change across its required PROGRESS and Daily entries. If that event is already recorded in a destination, do not append it again; append a labelled correction only for a material change in facts.
- Log once per meaningful change/checkpoint, not per command, read or retry. Preserve the required PROGRESS and Daily records and affected subject updates. Read-only audits create no records unless explicitly requested.
- A change is not fully recorded until its vault entries are verified. If vault access fails, create a clearly named pending record under `obsidian-starter/`, add it to Pending vault reconciliation below, and tell the user it is staged rather than saved.

Maintain the project overview, chronological work log, decisions, design notes, and dated daily notes. When a decision changes, retain it and mark it superseded with a link to its replacement. Keep confirmed facts separate from proposals and unresolved questions. Never mark unverified work complete.

Backfill only chats or files that are accessible or supplied by the user. Do not claim access to all previous chats. If the vault cannot be accessed or written, state that limitation and preserve a pending update in the project for later reconciliation; do not claim it was saved.

Do not delete notes, modify `.obsidian` settings, or store credentials unless explicitly authorized for an appropriate action.

## Pending vault reconciliation

Staged record: `obsidian-starter/pending-ponytail-installation.md` records verified Ponytail 5.2.0 installation and unverified restart/hook activation. Vault append did not persist on readback. Reconcile without duplicates; installation does not authorize deferred UI work.

Reconciliation correction: prefer `obsidian-starter/corrected-records-2026-10-13.json` and its readable companion for the current checkpoint and recent Codex events. They separate destinations by purpose. Preserve older event history and author attribution, but do not append older duplicate status reports into decision notes. See `docs/recordkeeping.md`.

Staged correction: `obsidian-starter/pending-note-separation-correction.md` separates skill decisions from progress reports. When reconciling pending skill installations, use the corrected choice/reason/boundary summaries from local DECISIONS.md, not the full progress entry. Keep progress and verification in PROGRESS.md and daily/work logs.

Staged record: `obsidian-starter/pending-emil-skill-installation.md` records the verified emil-design-eng and break-ui installations on 2026-10-13 at 05:15. Reconcile without duplicates; installation does not authorize deferred UI redesign.

Staged record: `obsidian-starter/pending-skill-installation.md` records the user-requested grill-me, grilling dependency, and ui-ux-pro-max installations and verification. Reconcile without duplicates when vault writes work.

Staged record: `obsidian-starter/pending-ui-feedback-for-later.md` saves UI feedback only. The user explicitly deferred implementation; do not treat this proposal as a task to execute.

Additional staged record: `obsidian-starter/pending-ui-design-progress-backfill.md` contains the UI changes, confirmed decisions, design update, verification results, and remaining checks recorded on 2026-10-13 at 03:57. Reconcile its entries into progress, work log, design, decisions, overview, and daily notes without duplicates.

Additional staged record: `obsidian-starter/pending-organization-resume.md` records the hourly continuation and remaining organization checkpoint. Check destination notes for its matching timestamp before merging to avoid duplicates.

Additional staged record: `obsidian-starter/pending-frontend-agent-update.md` documents the reusable frontend agent setup and its verification status. Merge it without duplicates when vault writes are available.

Additional staged record: `obsidian-starter/pending-splash-logo-update.md` documents the centered splash logo implementation and its pending device verification. Merge it without duplicates when vault writes are available.

Additional staged record: `obsidian-starter/pending-automatic-change-logging.md` documents the user's standing requirement to log every implemented change automatically. Merge it without duplicates when vault writes are available.

Additional staged record: `obsidian-starter/pending-project-organization-update.md` documents the full repository organization, debugging toolkit, verification results, and remaining device check. Merge it without duplicates when vault writes are available.

On 2026-10-11, vault write attempts did not persist. The complete prepared backfill is in `obsidian-starter/pending-vault-records.json`, with a readable version in `obsidian-starter/pending-vault-records.md`. These records are staged, not saved in the vault. Before merging them, read the destination notes, preserve existing content, avoid duplicate entries, and verify each write by reading it back. Once the user attaches the vault with write access, reconcile these records before resuming other work. Use `Projects/Quapp/WORKLOG.md` for the chronological log when file creation is available.

# Quapp session rules (token-saving, mandatory)
1. Read the current HANDOFF section in the live vault identified above.
   Read BUILD-MAP for relevant scope/status questions; other notes and historical checkpoints are targeted references.
2. Never scan the whole project. Search with rg first. If the current checkpoint lacks needed past progress, decisions, or project history, follow `Projects/Quapp/MEMORY-RETRIEVAL.md` in the live vault and query the current-memory index; skip queries when available context is sufficient. Check freshness and use bounded results. Graphify is a retrieval aid, not the source of truth: verify important retrieved claims against the original notes. If the index is stale or retrieval fails, use targeted original-note reads and report the limitation. Graphify is also optional for cross-file relationships targeted searches cannot answer.
3. Use terse replies ($caveman) for chat output. Code, commands, file paths, numbers and error messages stay exact.
4. Apply @ponytail before writing code: reuse existing code, resources and platform features first. Exception: when porting a prototype screen, match the prototype first; use Ponytail only to avoid duplicates and unrequested extras.
5. After meaningful changes, update the current HANDOFF section once, preserve historical content, update affected BUILD-MAP rows and required progress/daily records, and verify writes. Never automatically rebuild, overwrite, export, or otherwise modify the Graphify index. Ask for authorization before any index maintenance unless explicitly authorized already.
6. At the end of every checkpoint, tell me the recommended reasoning effort for the NEXT phase (Phase 0 Light; Phase 1 Medium; Phases 2-3 Light, Medium for screens that came out wrong; Phases 5-6 Medium; note updates Light). Do not change the model or effort yourself. Remind me, then wait.
7. Never claim work is done or tested unless verified. Preserve [[wikilinks]]. Keep facts, proposals and open questions separate.
