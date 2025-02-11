[string]$hrmsAccountDb = $PSScriptRoot + "/../../../docker/volume/database/hrms_account_db/*";
[string]$hrmsDb = $PSScriptRoot + "/../../../docker/volume/database/hrms_db/*";

Remove-Item $hrmsAccountDb;
Remove-Item $hrmsDb;