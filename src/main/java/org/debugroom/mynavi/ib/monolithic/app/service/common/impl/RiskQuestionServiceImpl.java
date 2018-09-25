package org.debugroom.mynavi.ib.monolithic.app.service.common.impl;

import java.util.List;

import org.debugroom.mynavi.ib.monolithic.app.service.common.RiskQuestionService;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskAnswer;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskQuestion;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.User;
import org.springframework.stereotype.Service;

@Service("riskQuestionService")
public class RiskQuestionServiceImpl implements RiskQuestionService {

    @Override
    public List<RiskAnswer> getRiskAnswers(String userId) {
        return null;
    }

    @Override
    public List<RiskQuestion> getRiskQuestions() {
        return null;
    }

    @Override
    public List<RiskAnswer> updateRiskAnswers(
            User user, List<RiskAnswer> updateRiskAnswers) {
        return null;
    }

}
