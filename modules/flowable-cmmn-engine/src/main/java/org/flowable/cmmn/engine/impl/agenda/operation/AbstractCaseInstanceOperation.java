/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.cmmn.engine.impl.agenda.operation;

import org.flowable.cmmn.engine.impl.persistence.entity.CaseInstanceEntity;
import org.flowable.cmmn.engine.impl.util.CommandContextUtil;
import org.flowable.engine.common.impl.interceptor.CommandContext;

/**
 * @author Joram Barrez
 */
public abstract class AbstractCaseInstanceOperation extends CmmnOperation {
    
    protected String caseInstanceEntityId;
    protected CaseInstanceEntity caseInstanceEntity;

    public AbstractCaseInstanceOperation(CommandContext commandContext, String caseInstanceId, CaseInstanceEntity caseInstanceEntity) {
        super(commandContext);
        this.caseInstanceEntityId = caseInstanceId;
        this.caseInstanceEntity = caseInstanceEntity;
    }
    
    @Override
    public void run() {
        if (caseInstanceEntity == null) {
            caseInstanceEntity = CommandContextUtil.getCaseInstanceEntityManager(commandContext).findById(caseInstanceEntityId);
        }
        if (caseInstanceEntityId == null) {
            caseInstanceEntityId = caseInstanceEntity.getId();
        }
    }
    
}
