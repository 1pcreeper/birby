[String]$mavenTarGz = "$PSScriptRoot../../../../package/maven.tar.gz";
[String]$mavenPath = "$PSScriptRoot/../../../package";
if (Test-Path -Path "$mavenPath/apache-maven-3.9.9") {
    Write-Host "maven already existed";
    exit;
}
Invoke-WebRequest -Uri "https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz" -OutFile $mavenTarGz;
tar -xf $mavenTarGz -C $(Resolve-Path -Path $mavenPath).ToString();
Remove-Item $mavenTarGz;

