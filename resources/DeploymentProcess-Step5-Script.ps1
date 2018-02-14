$greenEnvironmentName = $OctopusParameters["Octopus.Action[Deploy to Staging (Green)].Output.GreenEnvironmentName"];
$blueEnvironmentName = $OctopusParameters["Octopus.Action[Deploy to Staging (Green)].Output.BlueEnvironmentName"];

aws elasticbeanstalk swap-environment-cnames --source-environment-name $greenEnvironmentName --destination-environment-name $blueEnvironmentName