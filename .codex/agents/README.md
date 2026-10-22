# Quapp frontend agent

`frontend_senior.toml` defines the project-scoped `frontend_senior` custom Codex agent. It inherits your selected model and permissions; it does not allocate a separate usage allowance.

For a focused change:

> Use the frontend_senior agent to update the queue details screen using this reference. Preserve its functionality and verify the affected resources.

For a full redesign:

> Use the frontend_senior agent to redesign the entire Quapp Android UI using [reference and desired direction]. Start with shared styles, then work through the screens in batches. Complete the requested scope and keep a checkpoint of decisions, files, verification, and remaining work.

To avoid delegation overhead, you can instead ask the main chat:

> Read .codex/agents/frontend_senior.toml and follow its frontend workflow directly in this chat without spawning another agent. Change [specific screen or scope].

The agent aims to reduce unnecessary reads and repeated work. Subagents still consume your account's tokens and may use more than doing the same work in one chat. A smaller model can be selected explicitly for simple changes; no model is forced by this configuration.

Open a fresh chat in this project if the current session does not discover the new custom agent. Configuration parsing can be checked locally, but discovery and an actual UI task must be verified in the client.

Supported configuration: https://learn.chatgpt.com/docs/agent-configuration/subagents
