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

package de.adorsys.psd2.xs2a.web.filter;

import de.adorsys.psd2.xs2a.service.RequestProviderService;
import de.adorsys.psd2.xs2a.web.Xs2aEndpointChecker;
import de.adorsys.psd2.xs2a.web.filter.holder.QwacCertificateService;
import no.difi.certvalidator.api.CertificateValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QwacCertificateFilterTest {
    private static final String TEST_QWAC_CERTIFICATE_VALID = "-----BEGIN CERTIFICATE-----MIIFNjCCAx6gAwIBAgIERd3y8TANBgkqhkiG9w0BAQsFADB4MQswCQYDVQQGEwJERTEQMA4GA1UECAwHQkFWQVJJQTESMBAGA1UEBwwJTnVyZW1iZXJnMSIwIAYDVQQKDBlUcnVzdCBTZXJ2aWNlIFByb3ZpZGVyIEFHMR8wHQYDVQQLDBZJbmZvcm1hdGlvbiBUZWNobm9sb2d5MB4XDTIwMDMwNTEzMzk1MFoXDTMwMDMwMzAwMDAwMFowgcExITAfBgNVBAoMGEZpY3Rpb25hbCBDb3Jwb3JhdGlvbiBBRzElMCMGCgmSJomT8ixkARkWFXB1YmxpYy5jb3Jwb3JhdGlvbi5kZTEfMB0GA1UECwwWSW5mb3JtYXRpb24gVGVjaG5vbG9neTEQMA4GA1UEBhMHR2VybWFueTEPMA0GA1UECAwGQmF5ZXJuMRIwEAYDVQQHDAlOdXJlbWJlcmcxHTAbBgNVBGEMFFBTRERFLUZBS0VOQ0EtODdCMkFDMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsHAdLWn7pEAlD5daEjKv7hE4FW+vMJRrA/Bw2M/Zsu8VFfW1ARmbTgTy7rGLFBK/Y2SToEj60+5GEkCgCvi+vI/Bdykk8XqjpVsJjTW67np1b2Av8F61zvCnn2UOxBtXBHCzR1j2yz2om1IMYieGu/cDTWLNkbuoGSnj0dq4CbHp2f8ch++goffqLRXr642j8cVlqZYsapB8y+Z8IydbtNBd/XAmRTAprmdRv9B4PC7P+lIYX8QbXw77f+9/2Kty7oVHtjle+GnTR8wH5nCiMQsA9V564/34lKwuEkzuryV1HzitQ/X7FSZoiSQRTxbxjVO+xdzI3hjF2FZjVvkqywIDAQABo34wfDB6BggrBgEFBQcBAwRuMGwGBgQAgZgnAjBiMDkwEQYHBACBmCcBAwwGUFNQX0FJMBEGBwQAgZgnAQIMBlBTUF9QSTARBgcEAIGYJwEEDAZQU1BfSUMMGVRydXN0IFNlcnZpY2UgUHJvdmlkZXIgQUcMCkRFLUZBS0VOQ0EwDQYJKoZIhvcNAQELBQADggIBACKUQc3O3TOFG8tWk4sQd3f9SGlOcBOMekSXCxRgskcYkjhWW4+EN1FYzlGuXPfq1yngKaM3ss9yCDVep0MFa4hDJ/hzSSD5upExzwWDkUa97AHCjZd39W6kLaCMAc5vTbR9r7zBvMKBcAmhZ9mWCvrvbHUOURv5yBfrrEk4AM1Vakf5l+fWP4JhA779+7JlwpQRpy5dgqROwKQ2L634d2osgXUV4CkqhSUQ5LcYI4uBFyKnM0pyGaNYdKhBC95J0y5GYa7NpKJNZXf+clTbe33gCt2SFSOMa7CV5NYpnohS201uNd/ffWLzGtFBnHLNpX8qTfFc16mtIcJo6Iiof2CYgfYAyJByBC1gZHf1wAtfQzAn6JcEaJzmehXKKl9x7X62aaGan7l+MblUT65Gd+Yed+rXLF6svefbrcIbZwt/W+v1fbfnip9QEFPV3VLjg0vk9Y30ftZCcFRSHLD3mdxcVEtmVxDDxyzDUwXF7J/mi4RQhZBb3OtwwEIWC2zUaycNMZWJRI+RqfLvanlDFFMoYeSZKTFf8jS/PPcfpKOAiTGu21iuuv+gYxh/rgjW419w26ya+Q3jabaz3E9Im/opSU5sQ9W92ALA14J9VZs6v8BVmqKTB5APKfeTYoXg9MjP9fjVM/hP26kIgQVs5Bz15ov8uQlQC+OTO+2y5ozs-----END CERTIFICATE-----";

    @InjectMocks
    private QwacCertificateFilter qwacCertificateFilter;
    @Mock
    private QwacCertificateService qwacCertificateService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private FilterChain chain;
    @Mock
    private RequestProviderService requestProviderService;
    @Mock
    private Xs2aEndpointChecker xs2aEndpointChecker;

    @Test
    void doFilter_success() throws IOException, ServletException, CertificateValidationException {
        //Given
        when(xs2aEndpointChecker.isXs2aEndpoint(request)).thenReturn(true);
        when(requestProviderService.getEncodedTppQwacCert()).thenReturn(TEST_QWAC_CERTIFICATE_VALID);
        when(qwacCertificateService.isApplicable(request, response, TEST_QWAC_CERTIFICATE_VALID)).thenReturn(true);

        //When
        qwacCertificateFilter.doFilter(request, response, chain);

        //Then
        verify(chain).doFilter(any(), any());
        verify(qwacCertificateService).isApplicable(request, response, TEST_QWAC_CERTIFICATE_VALID);
    }

    @Test
    void doFilter_error() throws IOException, ServletException, CertificateValidationException {
        //Given
        when(xs2aEndpointChecker.isXs2aEndpoint(request)).thenReturn(true);
        when(requestProviderService.getEncodedTppQwacCert()).thenReturn(TEST_QWAC_CERTIFICATE_VALID);
        when(qwacCertificateService.isApplicable(request, response, TEST_QWAC_CERTIFICATE_VALID)).thenReturn(false);

        //When
        qwacCertificateFilter.doFilter(request, response, chain);

        //Then
        verify(chain, never()).doFilter(any(), any());
        verify(qwacCertificateService).isApplicable(request, response, TEST_QWAC_CERTIFICATE_VALID);
    }

    @Test
    void doFilter_onCustomEndpoint_shouldSkipFilter() throws ServletException, IOException {
        // Given
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockResponse = new MockHttpServletResponse();

        // When
        qwacCertificateFilter.doFilter(mockRequest, mockResponse, chain);

        // Then
        verify(chain).doFilter(mockRequest, mockResponse);
    }
}
