#!/usr/bin/env bash

echo "hello world"
URL="https://test1-v7.7moor.com/base/action/user/create"
GROUP_URL="https://test1-v7.7moor.com/base/action/skillGroup/create"

readonly URL
result=""

addAgent(){
    echo "开始添加1000个坐席。。。"
    agentNumber=8084
    index=0
    arr=""
    for (( i = 0; i < 1; ++i )); do
        agentNumber=$((${agentNumber}+${i}))
        result=`curl --location --request POST ${URL} \
--header 'sessionid: 5ff3cf4e6e75af0021f1f71a' \
--header 'logintoken: 854f0f7a432a42a7982bc6038fce0d08' \
--header 'Content-Type: application/json' \
--data-raw '{
    "agentNumber": "'${agentNumber}'",
    "agentName": "'${agentNumber}'",
    "password": "YW2VcZAhEnsRjDgoMJnKlaaYIyOILbuui1ju/2zKomRNDHx3o6X7EXAK2iR3dnym0JECI1TIWneNxSA535yzKU7XyCSW50KV68BREnZSwbCJQPdkMa7n/0X8UQHZfPmioVCn3R1fuE9v7fPaE0b5GEFanGfkAN2OVa1hQh3P+ew=",
    "mobile": "",
    "agentVersion": "L00001",
    "queueList": [
        "10000046"
    ],
    "roles": [
        "5feaec9eb58ad10011a5fbff"
    ],
    "sipNumber": "",
    "email": "",
    "crmId": "",
    "numbers": [
        "02258834888"
    ],
    "restTime": "30"
}'`
    id=$(echo ${result} | ${JQ_EXEC} .requestInfo.requestId | sed 's/\"//g')
    if ($id); then
        agent_id[index]=$(${id})
        members=$(echo "")
        if (${index} == 50); then
             result=`curl --location --request POST ${GROUP_URL} \
--header 'sessionid: 5ff3cf4e6e75af0021f1f71a' \
--header 'logintoken: 854f0f7a432a42a7982bc6038fce0d08' \
--header 'Content-Type: application/json' \
--data-raw '{
    "members": "'${agentNumber}'",
    "agentName": "'${agentNumber}'",
    "password": "YW2VcZAhEnsRjDgoMJnKlaaYIyOILbuui1ju/2zKomRNDHx3o6X7EXAK2iR3dnym0JECI1TIWneNxSA535yzKU7XyCSW50KV68BREnZSwbCJQPdkMa7n/0X8UQHZfPmioVCn3R1fuE9v7fPaE0b5GEFanGfkAN2OVa1hQh3P+ew=",
    "mobile": "",
    "agentVersion": "L00001",
    "queueList": [
        "10000046"
    ],
    "roles": [
        "5feaec9eb58ad10011a5fbff"
    ],
    "sipNumber": "",
    "email": "",
    "crmId": "",
    "numbers": [
        "02258834888"
    ],
    "restTime": "30"
}'`
        index=0
        fi
        
    fi
    
    index=$((${index}+1))
    done
    echo "添加结束。。。${result}"
    return
}
JQ_EXEC=`which jq`


#parse_json(){
#    echo "1------${result}"
#    id=$(echo ${result} | ${JQ_EXEC} .requestInfo.requestId | sed 's/\"//g')
#    echo "2-------${id}"
#}


addAgent
#parse_json
