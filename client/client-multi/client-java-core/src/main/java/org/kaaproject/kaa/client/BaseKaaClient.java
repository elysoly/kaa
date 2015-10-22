/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaaproject.kaa.client;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.annotation.Generated;

import org.kaaproject.kaa.client.exceptions.KaaException;
import org.kaaproject.kaa.schema.base.Configuration;
import org.kaaproject.kaa.schema.base.Log;

/**
 * <p>
 * Auto-generated class based on user data structures. Provides implementation
 * of {@link KaaClient}.
 * </p>
 *
 * @author Andrew Shvayka
 *
 * @see KaaClient
 * @see AbstractKaaClient
 */
@Generated("BaseKaaClient.java.template")
public class BaseKaaClient extends AbstractKaaClient implements KaaClient {

    public BaseKaaClient(KaaClientPlatformContext context, KaaClientStateListener listener) throws IOException, GeneralSecurityException {
        super(context, listener);
    }

    @Override
    public void addLogRecord(Log record) throws KaaException {
        checkClientState(State.STARTED, "Kaa client is not started");
        logCollector.addLogRecord(record);
    }

    @Override
    public Configuration getConfiguration() throws KaaException {
        checkClientState(State.STARTED, "Kaa client is not started");
        return configurationManager.getConfiguration();
    }
}
