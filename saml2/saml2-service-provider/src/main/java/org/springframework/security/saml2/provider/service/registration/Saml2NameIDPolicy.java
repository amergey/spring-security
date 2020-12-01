/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.saml2.provider.service.registration;

import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration.Builder;
import org.springframework.util.Assert;

/**
 * Specifies constraints on the name identifier to be used to represent the requested
 * subject.
 *
 * @author Arnaud Mergey
 * @since 5.5
 */
public final class Saml2NameIDPolicy {

	private final String format;

	private final String sPNameQualifier;

	private final boolean allowCreate;

	private Saml2NameIDPolicy(String format, String sPNameQualifier, boolean allowCreate) {
		super();
		Assert.hasText(format, "format cannot be empty");
		this.format = format;
		this.sPNameQualifier = sPNameQualifier;
		this.allowCreate = allowCreate;
	}

	/**
	 * Gets the format of the NameIDPolicy.
	 * @return the format of the NameIDPolicy
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Gets the SPNameQualifier value.
	 * @return the SPNameQualifier value
	 */
	public String getSPNameQualifier() {
		return this.sPNameQualifier;
	}

	/**
	 * Gets the AllowCreate value.
	 * @return the AllowCreate value
	 */
	public boolean isAllowCreate() {
		return this.allowCreate;
	}

	/**
	 * Creates a {@link Builder}
	 * @return {@code Builder} to create a {@code Saml2NameIDPolicy} object
	 */
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private String format;

		private String sPNameQualifier = null;

		private boolean allowCreate = true;

		/**
		 * Specifies the URI reference corresponding to a name identifier format.
		 *
		 * <p>
		 * for example "urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified"
		 * @return the {@link Builder} for further configuration
		 */
		public Builder format(String format) {
			this.format = format;
			return this;
		}

		/**
		 * Specifies the service provider namespace that qualifies the subject's
		 * identifier
		 * @return the {@link Builder} for further configuration
		 */
		public Builder sPNameQualifier(String sPNameQualifier) {
			this.sPNameQualifier = sPNameQualifier;
			return this;
		}

		/**
		 * Indicates whether the identity provider is allowed, in the course of fulfilling
		 * the request, to create a new identifier to represent the principal.
		 * @return the {@link Builder} for further configuration
		 */
		public Builder allowCreate(boolean allowCreate) {
			this.allowCreate = allowCreate;
			return this;
		}

		/**
		 * Constructs a Saml2NameIDPolicy object based on the builder configurations
		 * @return a Saml2NameIDPolicy instance
		 */
		public Saml2NameIDPolicy build() {
			return new Saml2NameIDPolicy(this.format, this.sPNameQualifier, this.allowCreate);
		}

	}

}
