/*
 *   Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License").
 *   You may not use this file except in compliance with the License.
 *   A copy of the License is located at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file. This file is distributed
 *   on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *   express or implied. See the License for the specific language governing
 *   permissions and limitations under the License.
 */

package com.amazon.opendistroforelasticsearch.ppl.plans.dsl;



import com.amazon.opendistroforelasticsearch.ppl.plans.expression.DataType;
import com.amazon.opendistroforelasticsearch.ppl.plans.expression.EqualTo;
import com.amazon.opendistroforelasticsearch.ppl.plans.expression.Literal;
import com.amazon.opendistroforelasticsearch.ppl.plans.expression.UnresolvedAttribute;
import com.amazon.opendistroforelasticsearch.ppl.plans.logical.Expression;
import com.amazon.opendistroforelasticsearch.ppl.plans.logical.Filter;
import com.amazon.opendistroforelasticsearch.ppl.plans.logical.LogicalPlan;
import com.amazon.opendistroforelasticsearch.ppl.plans.logical.Project;
import com.amazon.opendistroforelasticsearch.ppl.plans.logical.Relation;

import java.util.Arrays;

public class DSL {
    public static LogicalPlan project(LogicalPlan input, Expression... projectList) {
        return new Project(Arrays.asList(projectList)).withInput(input);
    }

    public static LogicalPlan filter(LogicalPlan input, Expression expression) {
        return new Filter(expression).withInput(input);
    }

    public static LogicalPlan relation(String tableName) {
        return new Relation(tableName);
    }

    public static Expression equalTo(Expression left, Expression right) {
        return new EqualTo(left, right);
    }

    public static Expression attr(String attr) {
        return new UnresolvedAttribute(attr);
    }

    public static Expression intLiteral(Integer literal) {
        return new Literal(literal, DataType.INTEGER);
    }
}