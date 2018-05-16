/*
 * Copyright 2018-2018 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.aspsp.xs2a.spi.service;

import de.adorsys.aspsp.xs2a.spi.domain.account.SpiAccountDetails;
import de.adorsys.aspsp.xs2a.spi.domain.account.SpiBalances;
import de.adorsys.aspsp.xs2a.spi.domain.account.SpiTransaction;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public interface AccountSpi {
    List<SpiAccountDetails> readAccounts(String consentId, boolean withBalance, boolean psuInvolved);

    List<SpiBalances> readBalances(String accountId, boolean psuInvolved);

    List<SpiTransaction> readTransactionsByPeriod(String accountId, Date dateFrom, Date dateTo, boolean psuInvolved);

    List<SpiTransaction> readTransactionsById(String accountId, String transactionId, boolean psuInvolved);

    SpiAccountDetails readAccountDetails(String accountId, boolean withBalance, boolean psuInvolved);

    SpiAccountDetails readAccountDetailsByIbanAndCurrency(String iban, Currency currency);

}
