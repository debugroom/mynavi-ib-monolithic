package org.debugroom.mynavi.ib.monolithic.app.model.common;

import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BusinessDay implements Serializable {

    private String yyyymmdd;
    private boolean isBusinessDay;
    private ZonedDateTime lastUpdatedAt;

}
