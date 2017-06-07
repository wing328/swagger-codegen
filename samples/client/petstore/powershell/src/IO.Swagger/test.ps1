[CmdletBinding()]
Param()

'API', 'Model', 'Private' | Get-ChildItem -Path {
    Join-Path $PSScriptRoot $_
} -Filter '*.ps1' | ForEach-Object {
    Write-Host "Importing file: $($_.BaseName)"
    try {
        . $_.FullName
    } catch {
        Write-Host "Can't import function: $($_.BaseName)"
    }
}