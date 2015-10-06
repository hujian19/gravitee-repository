/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.repository.api.management;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import io.gravitee.repository.exceptions.TechnicalException;
import io.gravitee.repository.model.management.Api;
import io.gravitee.repository.model.management.PolicyConfiguration;
import io.gravitee.repository.model.management.User;
import io.gravitee.repository.model.management.Team;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
public interface ApiRepository {

    /**
     * Get an API using its name.
     *
     * @param apiName The name of the API to retrieve.
     * @return An {@link Optional} API.
     */
    Optional<Api> findByName(String apiName) throws TechnicalException;

    /**
     * List all public APIs.
     *
     * @return All public APIs.
     */
    Set<Api> findAll() throws TechnicalException;

    /**
     * List APIs (public and/or private) hold by a {@link Team}.
     *
     * @param teamName The name of the team.
     * @param publicOnly List only public APIs.
     * @return List APIs from a team.
     */
    Set<Api> findByTeam(String teamName, boolean publicOnly) throws TechnicalException;

    /**
     * List APIs (public and private) hold by a {@link User}.
     *
     * @param username The name of the user.
     * @param publicOnly List only public APIs.
     * @return List APIs from a user.
     */
    Set<Api> findByUser(String username, boolean publicOnly) throws TechnicalException;

    /**
     * Create an API
     * 
     * @param api api to create
     * @return api creaded
     */
    Api create(Api api) throws TechnicalException;

    /**
     * Update an API
     * 
     * @param api api to update
     * @return api updated
     */
    Api update(Api api) throws TechnicalException;

    /**
     * Delete an API
     * 
     * @param apiName api name to delete
     */
    void delete(String apiName) throws TechnicalException;

    /**
     * Count all APIs (public and private) owned by a given {@link User}
     * 
     * @param username owner user name 
     * @param publicOnly List only public APIs.
     * @return counted APIs
     */
    int countByUser(String username, boolean publicOnly) throws TechnicalException;
   
    /**
    * Count all APIs (public and private) owned by a given {@link Team}
    * 
    * @param teamName owner team name 
    * @param publicOnly List only public APIs.
    * @return counted APIs
    */
    int countByTeam(String teamName, boolean publicOnly) throws TechnicalException;

    /**
     * Update an API policies
     *
     * @param apiName API name
     * @param policyConfigurations Ordered list of {@link PolicyConfiguration} to set to the API
     */
    @Deprecated
    default void updatePoliciesConfiguration(String apiName, List<PolicyConfiguration> policyConfigurations) throws TechnicalException {
        throw new UnsupportedOperationException();
    }

    /**
     * Update a API policy
     *
     * @param apiName API name
     * @param policyConfiguration {@link PolicyConfiguration} to update
     */
    @Deprecated
    default void updatePolicyConfiguration(String apiName, PolicyConfiguration policyConfiguration) throws TechnicalException {
        throw new UnsupportedOperationException();
    }

    /**
     * Update a API policy descriptor
     *
     * @param apiName API name
     * @param jsonDescriptor to update
     */
    default void updateDescriptor(String apiName, String jsonDescriptor) throws TechnicalException {
        // TODO remove default
    }

    /**
     * Give all {@link PolicyConfiguration} for an API
     *
     * @param apiName API name
     * @return API JSON descriptor
     */
    default String findDescriptorByApi(String apiName) throws TechnicalException {
        // TODO remove default
        return null;
    }

    /**
     * Give all {@link PolicyConfiguration} for an API
     *
     * @param apiName API name
     * @return API policies configuration
     */
    @Deprecated
    default List<PolicyConfiguration> findPoliciesByApi(String apiName) throws TechnicalException {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Find APIs by creator
     * 
     * @param userName creator {@link User} name
     * @return APIs created by the user
     */
    Set<Api> findByCreator(String userName) throws TechnicalException;
    
    /**
     * Find Apis associated with an application
     * 
     * @param application Application Name
     * @return Apis associated
     */
    Set<Api> findByApplication(String application) throws TechnicalException;

}