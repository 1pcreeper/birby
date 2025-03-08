[string]$maven = Resolve-Path "$PSScriptRoot/../../../package/apache-maven-3.9.9/bin/mvn.cmd";
[string]$path = $PSScriptRoot + "/../../../backend/birby-hrms-account-api/target/hrms_account_api-0.0.1-SNAPSHOT.jar";
[string]$envPath = $PSScriptRoot + "/../../../backend/birby-hrms-account-api/src/main/resources/.env";
& $maven clean install -f "$PSScriptRoot/../../../backend/birby-hrms-account-api/pom.xml";
Get-Content $envPath | ForEach-Object {
    if ($_ -and $_ -notmatch '^\s*#') {
        # Ignore empty lines and comments
        $key, $value = $_ -split '=', 2
        [Environment]::SetEnvironmentVariable($key.Trim(), $value.Trim(), [EnvironmentVariableTarget]::Process)
    }
}
java.exe -jar $path;
