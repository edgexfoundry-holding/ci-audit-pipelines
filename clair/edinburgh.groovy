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

def imagesToScan = [
    'edgexfoundry/docker-core-command-go:1.0.0',
    'edgexfoundry/docker-core-command-go-arm64:1.0.0',
    'edgexfoundry/docker-core-config-seed-go:1.0.0',
    'edgexfoundry/docker-core-config-seed-go-arm64:1.0.0',
    'edgexfoundry/docker-core-data-go:1.0.0',
    'edgexfoundry/docker-core-data-go-arm64:1.0.0',
    'edgexfoundry/docker-core-metadata-go:1.0.0',
    'edgexfoundry/docker-core-metadata-go-arm64:1.0.0',
    'edgexfoundry/docker-device-grove-c-arm64:1.0.0',
    'edgexfoundry/docker-device-modbus-go:1.0.0',
    'edgexfoundry/docker-device-modbus-go-arm64:1.0.0',
    'edgexfoundry/docker-device-mqtt-go:1.0.0',
    'edgexfoundry/docker-device-mqtt-go-arm64:1.0.0',
    'edgexfoundry/docker-device-random-go:1.0.0',
    'edgexfoundry/docker-device-random-go-arm64:1.0.0',
    'edgexfoundry/docker-device-snmp-go:1.0.0',
    'edgexfoundry/docker-device-snmp-go-arm64:1.0.0',
    'edgexfoundry/docker-device-virtual-go:1.0.0',
    'edgexfoundry/docker-device-virtual-go-arm64:1.0.0',
    'edgexfoundry/docker-edgex-mongo:1.0.0',
    'edgexfoundry/docker-edgex-mongo-arm64:1.0.0',
    'edgexfoundry/docker-edgex-proxy-go:1.0.0',
    'edgexfoundry/docker-edgex-proxy-go-arm64:1.0.0',
    'edgexfoundry/docker-edgex-ui-go:1.0.0',
    'edgexfoundry/docker-edgex-ui-go-arm64:1.0.0',
    'edgexfoundry/docker-edgex-vault:1.0.0',
    'edgexfoundry/docker-edgex-vault-arm64:1.0.0',
    'edgexfoundry/docker-edgex-vault-worker-go:1.0.0',
    'edgexfoundry/docker-edgex-vault-worker-go-arm64:1.0.0',
    'edgexfoundry/docker-edgex-volume:1.0.0',
    'edgexfoundry/docker-edgex-volume-arm64:1.0.0',
    'edgexfoundry/docker-export-client-go:1.0.0',
    'edgexfoundry/docker-export-client-go-arm64:1.0.0',
    'edgexfoundry/docker-export-distro-go:1.0.0',
    'edgexfoundry/docker-export-distro-go-arm64:1.0.0',
    'edgexfoundry/docker-support-logging-go:1.0.0',
    'edgexfoundry/docker-support-logging-go-arm64:1.0.0',
    'edgexfoundry/docker-support-notifications-go:1.0.0',
    'edgexfoundry/docker-support-notifications-go-arm64:1.0.0',
    'edgexfoundry/docker-support-rulesengine:1.0.0',
    'edgexfoundry/docker-support-rulesengine-arm64:1.0.0',
    'edgexfoundry/docker-support-scheduler-go:1.0.0',
    'edgexfoundry/docker-support-scheduler-go-arm64:1.0.0',
    'edgexfoundry/docker-sys-mgmt-agent-go:1.0.0',
    'edgexfoundry/docker-sys-mgmt-agent-go-arm64:1.0.0',
    'nexus3.edgexfoundry.org:10004/edgex-ui-clojure:1.0.0',
    'nexus3.edgexfoundry.org:10004/edgex-ui-clojure:1.0.0-arm64'
]

pipeline {
    agent none

    stages {
        stage('🐳 Edinburgh Clair Scan') {
            steps {
                script {
                    imagesToScan.each { image ->
                        println edgeXClair(image)
                        println "--------------------------------------------"
                    }
                }
            }
        }
    }

}

