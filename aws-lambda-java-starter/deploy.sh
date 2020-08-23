#!/usr/bin/env bash

# provide lambda bucket as env variable or script argument
LAMBDA_BUCKET="${LAMBDA_BUCKET:-${1:-}}"
STACK_NAME="java-starter"

if [[ "${LAMBDA_BUCKET}" == "" || "${STACK_NAME}" == "" ]]; then
    echo "You must set LAMBDA_BUCKET and STACK_NAME first."
    echo "LAMBDA_BUCKET must point to an S3 bucket and will be used for uploading the Lambda function artifacts."
    exit 1;
fi

mvn verify install -DskipTests
aws cloudformation package --template-file cfn.yml --s3-bucket "${LAMBDA_BUCKET}" --output-template-file cfn.packaged.yml
aws cloudformation deploy --template-file cfn.packaged.yml --stack-name "${STACK_NAME}" --capabilities CAPABILITY_IAM

aws cloudformation describe-stacks \
    --stack-name ${STACK_NAME} \
    --query "Stacks[0].Outputs[?OutputKey == 'TestUrlOne'].OutputValue" \
    --output text

aws cloudformation describe-stacks \
    --stack-name ${STACK_NAME} \
    --query "Stacks[0].Outputs[?OutputKey == 'TestUrlTwo'].OutputValue" \
    --output text

aws cloudformation describe-stacks \
    --stack-name ${STACK_NAME} \
    --query "Stacks[0].Outputs[?OutputKey == 'TestEvent'].OutputValue" \
    --output text
