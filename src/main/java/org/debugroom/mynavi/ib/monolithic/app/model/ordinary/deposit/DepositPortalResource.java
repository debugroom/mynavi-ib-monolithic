package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DepositPortalResource implements PortalResource {

    private User user;


}
