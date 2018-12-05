package org.debugroom.mynavi.ib.monolithic.domain.service.common;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskAnswer;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskQuestion;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.User;

public interface RiskManager {

    public void updateRiskConceptOfUser(User user, RiskQuestion riskQuestion, RiskAnswer updateAnswer);

}
