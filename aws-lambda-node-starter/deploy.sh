#!/usr/bin/env bash

# provide lambda bucket as env variable or script argument
LAMBDA_BUCKET="${LAMBDA_BUCKET:-${1:-}}"
STACK_NAME="node-starter"

if [[ "${LAMBDA_BUCKET}" == "" || "${STACK_NAME}" == "" ]]; then
    echo "You must set LAMBDA_BUCKET and STACK_NAME first."
    echo "LAMBDA_BUCKET must point to an S3 bucket and will be used for uploading the Lambda function artifacts."
    exit 1;
fi

yarn
yarn run build
aws cloudformation package --template-file cfn.yml --s3-bucket ${LAMBDA_BUCKET} --output-template-file cfn.packaged.yml
aws cloudformation deploy --template-file cfn.packaged.yml --stack-name ${STACK_NAME} --capabilities CAPABILITY_IAM

aws cloudformation describe-stacks \
    --stack-name ${STACK_NAME} \
    --query "Stacks[0].Outputs[?OutputKey == 'TestUrl'].OutputValue" \
    --output text
