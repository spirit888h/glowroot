/*
 * Copyright 2015-2016 the original author or authors.
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
package org.glowroot.agent.init;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JvmInfoCreatorTest {

    @Test
    public void testNonParseable() {
        assertThat(SystemInfoCreator.parseProcessId("")).isNull();
        assertThat(SystemInfoCreator.parseProcessId("x")).isNull();
        assertThat(SystemInfoCreator.parseProcessId("x:y")).isNull();
        assertThat(SystemInfoCreator.parseProcessId("@y")).isNull();
        assertThat(SystemInfoCreator.parseProcessId("x@y")).isNull();
    }

    @Test
    public void testParseable() {
        assertThat(SystemInfoCreator.parseProcessId("123456@host")).isEqualTo(123456);
    }
}
