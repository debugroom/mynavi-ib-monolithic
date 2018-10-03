package org.debugroom.mynavi.ib.monolithic.app.service.common;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskAnswer;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskQuestion;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.User;

import java.util.List;

public interface RiskQuestionService {

    public List<RiskAnswer> getRiskAnswers(String userId);
    public List<RiskQuestion> getRiskQuestions();
    public List<RiskAnswer> updateRiskAnswers(User user, List<RiskAnswer> updateRiskAnswers);

}
