/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ranger.plugin.policyengine;

import org.apache.ranger.plugin.contextenricher.RangerTagForEval;
import org.apache.ranger.plugin.policyevaluator.RangerPolicyEvaluator;

import java.io.Serializable;
import java.util.Comparator;

public class PolicyEvaluatorForTag {
    private final RangerPolicyEvaluator evaluator;
    private final RangerTagForEval      tag;

    PolicyEvaluatorForTag(RangerPolicyEvaluator evaluator, RangerTagForEval tag) {
        this.evaluator = evaluator;
        this.tag       = tag;
    }

    RangerPolicyEvaluator getEvaluator() {
        return evaluator;
    }

    RangerTagForEval getTag() {
        return tag;
    }

    public static class PolicyNameComparator implements Comparator<PolicyEvaluatorForTag>, Serializable {
        @Override
        public int compare(PolicyEvaluatorForTag me, PolicyEvaluatorForTag other) {
            return me.getEvaluator().getPolicy().getName().compareTo(other.getEvaluator().getPolicy().getName());
        }
    }
}
