//
// Copyright (c) 2019 Intel Corporation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

loadGlobalLibrary()

def images2Scan = [
    'nexus3.edgexfoundry.org:10004/docker-app-service-configurable:master',
    'nexus3.edgexfoundry.org:10004/docker-app-service-configurable-arm64:master',
    'nexus3.edgexfoundry.org:10004/docker-core-command-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-command-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-config-seed-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-config-seed-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-data-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-data-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-metadata-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-core-metadata-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-camera-go:master',
    'nexus3.edgexfoundry.org:10004/docker-device-camera-go-arm64:master',
    'nexus3.edgexfoundry.org:10004/docker-device-grove-c-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-modbus-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-modbus-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-mqtt-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-mqtt-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-random-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-random-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-snmp-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-snmp-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-virtual-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-device-virtual-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-consul:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-consul-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-mongo:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-mongo-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-secret-store-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-secret-store-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-security-proxy-setup-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-security-proxy-setup-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-security-secretstore-setup-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-security-secretstore-setup-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-ui-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-ui-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-volume:1.0.0',
    'nexus3.edgexfoundry.org:10004/docker-edgex-volume-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-export-client-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-export-client-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-export-distro-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-export-distro-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-support-logging-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-support-logging-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-support-notifications-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-support-notifications-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-support-rulesengine:master',
    'nexus3.edgexfoundry.org:10004/docker-support-rulesengine-arm64:master',
    'nexus3.edgexfoundry.org:10004/docker-support-scheduler-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-support-scheduler-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-sys-mgmt-agent-go:1.1.0',
    'nexus3.edgexfoundry.org:10004/docker-sys-mgmt-agent-go-arm64:1.1.0',
    'nexus3.edgexfoundry.org:10004/edgex-ui-clojure:amd64',
    'nexus3.edgexfoundry.org:10004/edgex-ui-clojure:arm64'
]

pipeline {
    agent {
        label 'centos7-docker-4c-2g'
    }

    options {
        timestamps()
    }

    stages {
        stage('EdgeX Fuji Clair Report') {
            steps {
                sh 'docker run --rm ernestoojeda/artii -f slant Fuji Clair Scan v1.1.0'
                script {
                    images2Scan.each {
                        edgeXClair(it)
                    }
                }
            }
        }
    }
}

def loadGlobalLibrary(branch = '*/master') {
    library(identifier: 'edgex-global-pipelines@master', 
        retriever: legacySCM([
            $class: 'GitSCM',
            userRemoteConfigs: [[url: 'https://github.com/edgexfoundry/edgex-global-pipelines.git']],
            branches: [[name: branch]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[
                $class: 'SubmoduleOption',
                recursiveSubmodules: true,
            ]]]
        )
    ) _
}