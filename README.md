# aws-lambda-boilerplate
A collection of starter projects for [AWS Lambda](https://aws.amazon.com/lambda/) using [CloudFormation](https://aws.amazon.com/cloudformation/).
Example projects are using NodeJS, Java or NodeJS and Java (in one project).


## aws-lambda-node-starter
**Folder:** [aws-lambda-node-starter](aws-lambda-node-starter)

**Description:** Contains a simple starter project for NodeJS using [yarn](https://yarnpkg.com).

**Run:**
1. Add a [S3 bucket](https://aws.amazon.com/s3/) to [deploy.sh](aws-lambda-node-starter/deploy.sh) where your packaged JS or JAR files are uploaded to.
2. Run `./deploy.sh`
3. Access the NodeJS Lambda function called `node-starter-NodeFunction-XXX` using your [AWS Console](https://console.aws.amazon.com).


## aws-lambda-java-starter
**Folder:** [aws-lambda-java-starter](./aws-lambda-java-starter)

**Description:** Contains a simple starter project for Java using [Maven](https://maven.apache.org/).

**Run:**
1. Add a [S3 bucket](https://aws.amazon.com/s3/) to [deploy.sh](./aws-lambda-java-starter/deploy.sh) where your packaged JS or JAR files are uploaded to.
2. Run `./deploy.sh`
3. Access the Java Lambda function called `java-starter-JavaFunction-XXX` using your [AWS Console](https://console.aws.amazon.com).


## aws-lambda-node-java-starter
**Folder:** [aws-lambda-node-java-starter](aws-lambda-node-java-starter)

**Description:** Contains a simple starter project for NodeJS and Java using [yarn](https://yarnpkg.com) and [Maven](https://maven.apache.org/).

**Run:**
1. Add a [S3 bucket](https://aws.amazon.com/s3/) to [deploy.sh](aws-lambda-node-java-starter/deploy.sh) where your packaged JS or JAR files are uploaded to.
2. Run `./deploy.sh`
3. Access the NodeJS Lambda function called `node-java-starter-NodeFunction-XXX` using your [AWS Console](https://console.aws.amazon.com).
4. Access the Java Lambda function called `node-java-starter-JavaFunction-XXX` using your [AWS Console](https://console.aws.amazon.com).


## License

MIT License

Copyright (c) 2017 [Sebastian Hesse](https://www.sebastianhesse.de)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
