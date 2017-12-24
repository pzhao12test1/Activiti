/*
 * Copyright 2017 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.services.events.converter;

import org.activiti.engine.delegate.event.ActivitiCancelledEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.services.api.events.ProcessEngineEvent;
import org.activiti.services.events.ProcessCancelledEventImpl;
import org.springframework.stereotype.Component;

import static org.activiti.engine.delegate.event.ActivitiEventType.PROCESS_CANCELLED;

@Component
public class ProcessCancelledEventConverter extends AbstractEventConverter {

    @Override
    public ProcessEngineEvent from(ActivitiEvent event) {
        return new ProcessCancelledEventImpl(getApplicationName(),
                                             event.getExecutionId(),
                                             event.getProcessDefinitionId(),
                                             event.getProcessInstanceId(),
                                             ((ActivitiCancelledEvent) event).getCause().toString());
    }

    @Override
    public ActivitiEventType handledType() {
        return PROCESS_CANCELLED;
    }
}
