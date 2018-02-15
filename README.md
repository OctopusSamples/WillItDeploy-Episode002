# Deploying a Spring Boot web app - Will it Deploy? Episode 2

Will it deploy is a video series where we try to automate the deployment of different technologies with Octopus Deploy. Episode 2 is a great video where we try to deploy an Spring Boot web app to the AWS platform. We also explore how to automate the provisioning of our cloud infrastructure and ensure we have a zero-downtime production deployment. 

[![Deploying a Spring Boot web app - Will it Deploy? Episode 2](will-it-deploy.png)](https://youtu.be/tQb8PJ0jzvk "Deploying a Spring Boot web app - Will it Deploy? Episode 2")

## Problem

### Tech Stack

Our app is a quote generator called Random Quotes. The application is pretty simple but it allows us to illustrate how to deploy a Java web app to Amazon Web Services platform.

![Spring Boot logo](spring-boot-logo.png)

* [Spring Boot](https://projects.spring.io/spring-boot/) web app.
* [JUnit](http://junit.org/) unit testing framework, Mokito and Hamcrest.

Kudos to our marketing manager [Andrew](https://twitter.com/andrewmaherbne) who has been learning to code and built the first cut of this app. Great work! 

### Deployment Target

![Amazon web services logo](aws-logo.png)

* AWS - [Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/).
* Provision our cloud infrastructure with an AWS [CloudFormation Template](https://aws.amazon.com/cloudformation/).
* Zero-downtime production deploy - [applying the blue-green deployment pattern](https://octopus.com/docs/deployment-patterns/blue-green-deployments).

## Solution

So will it deploy? **Yes it will!** Our deployment process looks like the following.

![Octopus deployment process](deployment-process.png)

The first step is to add an Octopus AWS account, which includes our has all the details required to enable me to connect to the AWS platform, safely and securely. It is used to authenticate with AWS when deploying or executing scripts.

![AWS Account details](aws-account.png)

Then we add the following steps to successfully deploy our app including cloud infrastructure provisioning and a zero downtime production deployment.

- Octopus **Transfer a Package** step to transfer the Spring Boot jar package to the Octopus Server.
- Octopus **Run an AWS CLI Script** step to copy the web app package to an S3 bucket.
- Octopus **Deploy an AWS CloudFormation template** step to provision our cloud infrastructure including creating our Elastic Beanstalk application and two environments.
- Octopus **Run an AWS CLI Script** step to deploy our web app to the green or staging environment.
- Octopus **Run an AWS CLI Script** step to swap the Elastic Beanstalk app environment URLs so our green (staging) environment receives our blue (production) URL. This is only executed during a production deployment so that we achieve zero-downtime!

This project uses the following variables to store our resource group name, website name, and app settings. Nice and simple!

![Project variables](project-variables.png)