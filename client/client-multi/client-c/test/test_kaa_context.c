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

#include "kaa_context.h"
#include "kaa_test.h"
#include "kaa_log.h"


void test_create_bootstrap_manager()
{
    KAA_TRACE_IN;

    kaa_context_t * context = NULL;

    kaa_error_t err_code = kaa_create_context(&context);
    ASSERT_EQUAL(err_code, KAA_ERR_NONE);
    ASSERT_NOT_NULL(context);
    ASSERT_NOT_NULL(context->bootstrap_manager);
    ASSERT_NOT_NULL(context->channel_manager);
#ifndef KAA_DISABLE_FEATURE_EVENTS
    ASSERT_NOT_NULL(context->event_manager);
#endif
    ASSERT_NOT_NULL(context->profile_manager);
    ASSERT_NOT_NULL(context->status);
    ASSERT_NOT_NULL(context->user_manager);

    kaa_destroy_context(context);
}

int main(int argc, char ** argv)
{
    kaa_log_init(KAA_LOG_TRACE, NULL);

    test_create_bootstrap_manager();
    return 0;
}