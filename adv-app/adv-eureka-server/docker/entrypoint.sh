#!/bin/bash

set -e

CURL_COMMAND_HEALTHCHECK="curl -X GET -s -o /dev/null -I -w %{http_code}";
TENTATIVAS_HEALTHCHECK=60;

verificarNecessidadeHealthCheck(){
    if [ -z $HOST_PARAM_HEALTHCHECK ]; then 
        echo "Host do healthcheck não informado";
        exit 1;
    fi
}

verificarHealthChecks(){
    while [ ! "$($CURL_COMMAND_HEALTHCHECK $HOST_PARAM_HEALTHCHECK)" == "200" ]
    do
        tentativa_healthcheck=$((tentativa_healthcheck+1));
        if [ "$tentativa_healthcheck" -gt "$TENTATIVAS_HEALTHCHECK" ]; then
            exit 1;
        fi
        echo "Esperando o serviço executar, a partir da URL: $HOST_PARAM_HEALTHCHECK, tentativa: $tentativa_healthcheck de $TENTATIVAS_HEALTHCHECK";
        sleep 1;
    done
}

tentativa_healthcheck=0;

verificarNecessidadeHealthCheck "$@"
verificarHealthChecks "$@"

echo "O serviço está conectado, a partir da URL $HOST_PARAM_HEALTHCHECK";

exec "$@"