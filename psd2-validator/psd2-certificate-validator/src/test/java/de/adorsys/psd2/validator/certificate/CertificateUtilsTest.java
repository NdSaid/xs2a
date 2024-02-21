/*
 * Copyright 2018-2024 adorsys GmbH & Co KG
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
 * contact us at sales@adorsys.com.
 */

package de.adorsys.psd2.validator.certificate;

import de.adorsys.psd2.validator.certificate.util.CertificateUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.security.cert.X509Certificate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CertificateUtilsTest {

	@Test
	void test_getRootCertificate() {

		X509Certificate[] rootCertList = CertificateUtils.getCertificates("rootcert", "TCA3.crt");
		assertTrue(rootCertList.length >= 1);
	}

	@Test
	void test_getCertificateByName() {

		String encodedCert = CertificateUtils.getCertificateByName("certificateValid.crt");
		assertTrue(StringUtils.isNotBlank(encodedCert));
	}

}
