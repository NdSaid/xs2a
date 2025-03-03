/*
 * Copyright 2018-2023 adorsys GmbH & Co KG
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version. This program is distributed in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see https://www.gnu.org/licenses/.
 *
 * This project is also available under a separate commercial license. You can
 * contact us at psd2@adorsys.com.
 */

package de.adorsys.psd2.xs2a.service.authorization.processor;

import de.adorsys.psd2.xs2a.core.sca.ScaStatus;
import de.adorsys.psd2.xs2a.service.authorization.processor.model.AuthorisationProcessorRequest;
import de.adorsys.psd2.xs2a.service.authorization.processor.model.AuthorisationProcessorResponse;
import de.adorsys.psd2.xs2a.service.authorization.processor.service.AuthorisationProcessorService;

public abstract class AuthorisationProcessor {
    private AuthorisationProcessor nextProcessor;
    private final AuthorisationProcessorServiceProvider provider;

    protected AuthorisationProcessor(AuthorisationProcessorServiceProvider provider) {
        this.provider = provider;
    }

    public void setNext(AuthorisationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract ScaStatus getScaStatus();

    protected abstract AuthorisationProcessorResponse execute(AuthorisationProcessorRequest request,
                                                              AuthorisationProcessorService processorService);

    public AuthorisationProcessorResponse apply(AuthorisationProcessorRequest request) {
        AuthorisationProcessorResponse processorResponse = process(request);

        //update authorisation
        getProcessorService(request).updateAuthorisation(request, processorResponse);
        return processorResponse;
    }

    AuthorisationProcessorResponse process(AuthorisationProcessorRequest request) {
        if (getScaStatus() == request.getScaStatus()) {
            AuthorisationProcessorService processorService = getProcessorService(request);
            return execute(request, processorService);
        } else {
            if (hasNext()) {
                return nextProcessor.process(request);
            }
        }
        return null;
    }

    AuthorisationProcessorService getProcessorService(AuthorisationProcessorRequest request) {
        return provider.getProcessorService(request);
    }

    private boolean hasNext() {
        return nextProcessor != null;
    }
}
