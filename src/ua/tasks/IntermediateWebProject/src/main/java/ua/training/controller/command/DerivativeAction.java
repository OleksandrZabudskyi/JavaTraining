package ua.training.controller.command;

import ua.training.model.service.DerivativeService;
import ua.training.model.service.DerivativeServiceImpl;

abstract class DerivativeAction {
    private DerivativeService derivativeService;

    DerivativeAction() {
        this.derivativeService = new DerivativeServiceImpl();
    }

    DerivativeService getDerivativeService() {
        return derivativeService;
    }
}
