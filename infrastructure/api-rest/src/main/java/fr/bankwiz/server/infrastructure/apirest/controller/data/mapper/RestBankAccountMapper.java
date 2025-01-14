package fr.bankwiz.server.infrastructure.apirest.controller.data.mapper;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountCreationRequestDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestBankAccountMapper {
    BankAccountCreationRequest toBankAccountCreationRequest(BankAccountCreationRequestDTO bankAccountCreationRequestDTO);
    BankAccountDTO toBankAccountDTO(BankAccountDomain bankAccountDomain);
}
