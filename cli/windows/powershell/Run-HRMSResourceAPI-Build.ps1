[string]$path = $PSScriptRoot + "/../../../backend/birby-hrms-resource-api/target/hrms_resource_api-0.0.1-SNAPSHOT.jar";
[string]$envPath = $PSScriptRoot + "/../../../backend/birby-hrms-resource-api/src/main/resources/.env";
Get-Content $envPath | ForEach-Object {
    if ($_ -and $_ -notmatch '^\s*#') {
        # Ignore empty lines and comments
        $key, $value = $_ -split '=', 2
        [Environment]::SetEnvironmentVariable($key.Trim(), $value.Trim(), [EnvironmentVariableTarget]::Process)
    }
}
java.exe -jar $path