param([string]$VaultPath = 'C:\Users\JUSKWAA\Documents\Obsidian Vault')

$ErrorActionPreference = 'Stop'
if (-not (Test-Path -LiteralPath $VaultPath -PathType Container)) {
    throw "Vault folder does not exist: $VaultPath"
}

$sourceRoot = $PSScriptRoot
$notes = @(Get-ChildItem -LiteralPath $sourceRoot -Recurse -File -Filter '*.md')

# Check every destination before copying anything. Never overwrite a different note.
foreach ($note in $notes) {
    $relativePath = $note.FullName.Substring($sourceRoot.Length + 1)
    $destination = Join-Path $VaultPath $relativePath
    if (Test-Path -LiteralPath $destination) {
        if ((Get-FileHash -LiteralPath $note.FullName).Hash -ne (Get-FileHash -LiteralPath $destination).Hash) {
            throw "Existing note differs; merge it manually before retrying: $destination"
        }
    }
}

foreach ($note in $notes) {
    $relativePath = $note.FullName.Substring($sourceRoot.Length + 1)
    $destination = Join-Path $VaultPath $relativePath
    if (-not (Test-Path -LiteralPath $destination)) {
        $parentDirectory = Split-Path -Parent $destination
        New-Item -ItemType Directory -Path $parentDirectory -Force | Out-Null
        Copy-Item -LiteralPath $note.FullName -Destination $destination -ErrorAction Stop
    }
    if ((Get-FileHash -LiteralPath $note.FullName).Hash -ne (Get-FileHash -LiteralPath $destination).Hash) {
        throw "Verification failed: $destination"
    }
    Write-Output "Verified: $relativePath"
}

Write-Output 'Vault notes installed. Add the vault folder as a local Codex project to use it.'
