package org.debugroom.mynavi.ib.monolithic.domain.service.common.impl;

import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.BusinessDayRepository;
import org.debugroom.mynavi.ib.monolithic.domain.service.common.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    BusinessDayRepository businessDayRepository;

    @Override
    public boolean isBusinessDay(String yyyymmdd) {
        return businessDayRepository.getOne(yyyymmdd).getBusinessDay();
    }

}
