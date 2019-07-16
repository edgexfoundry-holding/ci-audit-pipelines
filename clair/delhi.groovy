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
    'edgexfoundry/docker-edgex-ui-go-arm64:0.1.1',
    'edgexfoundry/docker-edgex-ui-go:0.1.1',
    'edgexfoundry/docker-edgex-proxy-go-arm64:0.2.0',
    'edgexfoundry/docker-edgex-vault-worker-go-arm64:0.2.0',
    'edgexfoundry/docker-edgex-vault-arm64:0.2.0',
    'edgexfoundry/docker-support-scheduler-go:0.7.0',
    'edgexfoundry/docker-support-notifications-go:0.7.0',
    'edgexfoundry/docker-support-logging-go:0.7.0',
    'edgexfoundry/docker-core-command-go:0.7.0',
    'edgexfoundry/docker-core-metadata-go:0.7.0',
    'edgexfoundry/docker-core-data-go:0.7.0',
    'edgexfoundry/docker-export-distro-go:0.7.0',
    'edgexfoundry/docker-export-client-go:0.7.0',
    'edgexfoundry/docker-core-config-seed-go:0.7.0',
    'edgexfoundry/docker-support-rulesengine-arm64:0.7.0',
    'edgexfoundry/docker-device-mqtt-arm64:0.5.0',
    'edgexfoundry/docker-device-bluetooth-arm64:0.5.0',
    'edgexfoundry/docker-device-bacnet-arm64:0.5.0',
    'edgexfoundry/docker-support-rulesengine:0.7.0',
    'edgexfoundry/docker-device-mqtt:0.5.0',
    'edgexfoundry/docker-device-bluetooth:0.5.0',
    'edgexfoundry/docker-device-bacnet:0.5.0',
    'edgexfoundry/docker-device-modbus-arm64:0.5.0',
    'edgexfoundry/docker-device-modbus:0.5.0',
    'edgexfoundry/docker-device-virtual-arm64:0.5.0',
    'edgexfoundry/docker-device-virtual:0.5.0',
    'edgexfoundry/docker-support-scheduler-go-arm64:0.7.0',
    'edgexfoundry/docker-support-notifications-go-arm64:0.7.0',
    'edgexfoundry/docker-support-logging-go-arm64:0.7.0',
    'edgexfoundry/docker-core-command-go-arm64:0.7.0',
    'edgexfoundry/docker-core-metadata-go-arm64:0.7.0',
    'edgexfoundry/docker-core-data-go-arm64:0.7.0',
    'edgexfoundry/docker-export-distro-go-arm64:0.7.0',
    'edgexfoundry/docker-export-client-go-arm64:0.7.0',
    'edgexfoundry/docker-core-config-seed-go-arm64:0.7.0',
    'edgexfoundry/docker-edgex-proxy-go:0.2.0',
    'edgexfoundry/docker-edgex-vault-worker-go:0.2.0',
    'edgexfoundry/docker-edgex-vault:0.2.0',
    'edgexfoundry/docker-edgex-volume-arm64:0.8.0',
    'edgexfoundry/docker-edgex-volume:0.8.0',
    'edgexfoundry/docker-edgex-mongo-arm64:0.8.0',
    'edgexfoundry/docker-edgex-mongo:0.8.0'
]

imagesToScan.each { image ->
    println edgeXClair(image)
    println "--------------------------------------------"
}