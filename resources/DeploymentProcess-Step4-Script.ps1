# Setup blue/green deployment environments
$stagingJson = aws elasticbeanstalk describe-environments --application-name RandomQuotes | ConvertFrom-Json
$tmpStagingEnvironment = $stagingJson.Environments | Where {($_.CNAME.Contains("staging")) -and ($_.Health -eq "Green") } | Select-Object -Property EnvironmentName
$stagingEnvironmentName = $tmpStagingEnvironment."EnvironmentName"

Write-Host "Current Staging (green) env: $stagingEnvironmentName"
Set-OctopusVariable -name "GreenEnvironmentName" -value $stagingEnvironmentName

$prodJson = aws elasticbeanstalk describe-environments --application-name RandomQuotes | ConvertFrom-Json
$tmpProdEnvironment = $prodJson.Environments | Where {($_.CNAME.Contains("prod")) -and ($_.Health -eq "Green") } | Select-Object -Property EnvironmentName
$prodEnvironmentName = $tmpProdEnvironment."EnvironmentName"

Write-Host "Current Prod (blue) env: $prodEnvironmentName"
Set-OctopusVariable -name "BlueEnvironmentName" -value $prodEnvironmentName

# Get latest project release
$application = aws elasticbeanstalk describe-application-versions --application-name RandomQuotes | ConvertFrom-Json
$currentReleaseNumber = $OctopusParameters["Octopus.Release.Number"]
$tmpApplicationVersion = $application.ApplicationVersions | Where {$_.Description -eq $currentReleaseNumber} | Select-Object -Property VersionLabel
$applicationVersion = $tmpApplicationVersion."VersionLabel"

$activeSpringProfile = $OctopusParameters["spring.profile.name"]

Write-Host "Deploying application version $applicationVersion to green environment $stagingEnvironmentName using config: $activeSpringProfile."
aws elasticbeanstalk update-environment --environment-name $stagingEnvironmentName --version-label $applicationVersion --option-settings Namespace=aws:elasticbeanstalk:application:environment,OptionName=SPRING_PROFILES_ACTIVE,Value=$activeSpringProfile

# Wait for deployment to complete
$isComplete = $false
sleep 5

while ($isComplete -ne $true) 
{
  Write-Host "Checking to see if environment is green ..."
  $application = aws elasticbeanstalk describe-environments --application-name RandomQuotes | ConvertFrom-Json
  $tmpApplicationVersion = $application.Environments | Where {$_.EnvironmentName -eq $stagingEnvironmentName } | Select-Object -Property Health
  $isComplete = $tmpApplicationVersion."Health" -eq "Green"

  if ($isComplete -ne $true) { sleep 5 }
}