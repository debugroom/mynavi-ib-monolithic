package org.debugroom.mynavi.ib.monolithic.domain.model.ordinary.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransferOrder implements Serializable {

    private Transfer transfer;

    public Transfer createTransfer(){
        return Transfer.builder().build();
    }

}
