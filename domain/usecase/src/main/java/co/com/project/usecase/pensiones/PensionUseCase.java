package co.com.project.usecase.pensiones;

import co.com.project.model.pension.gateways.PensionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PensionUseCase {
    private final PensionRepository pensionRepository;
}
