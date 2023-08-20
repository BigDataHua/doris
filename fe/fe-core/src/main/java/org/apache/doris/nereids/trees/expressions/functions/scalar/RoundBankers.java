// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.functions.scalar;

import org.apache.doris.catalog.FunctionSignature;
import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.ComputePrecisionForRound;
import org.apache.doris.nereids.trees.expressions.functions.PropagateNullable;
import org.apache.doris.nereids.trees.expressions.functions.SearchSignatureForRound;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.types.DecimalV3Type;
import org.apache.doris.nereids.types.DoubleType;
import org.apache.doris.nereids.types.IntegerType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * ScalarFunction 'round_bankers'. This class is generated by GenerateFunction.
 */
public class RoundBankers extends ScalarFunction
        implements SearchSignatureForRound, PropagateNullable, ComputePrecisionForRound {

    public static final List<FunctionSignature> SIGNATURES = ImmutableList.of(
            FunctionSignature.ret(DecimalV3Type.WILDCARD).args(DecimalV3Type.WILDCARD),
            FunctionSignature.ret(DecimalV3Type.WILDCARD).args(DecimalV3Type.WILDCARD, IntegerType.INSTANCE),
            FunctionSignature.ret(DoubleType.INSTANCE).args(DoubleType.INSTANCE),
            FunctionSignature.ret(DoubleType.INSTANCE).args(DoubleType.INSTANCE, IntegerType.INSTANCE)
    );

    /**
     * constructor with 1 argument.
     */
    public RoundBankers(Expression arg) {
        super("round_bankers", arg);
    }

    /**
     * constructor with 2 arguments.
     */
    public RoundBankers(Expression arg0, Expression arg1) {
        super("round_bankers", arg0, arg1);
    }

    /**
     * withChildren.
     */
    @Override
    public RoundBankers withChildren(List<Expression> children) {
        Preconditions.checkArgument(children.size() == 1
                || children.size() == 2);
        if (children.size() == 1) {
            return new RoundBankers(children.get(0));
        } else {
            return new RoundBankers(children.get(0), children.get(1));
        }
    }

    @Override
    public List<FunctionSignature> getSignatures() {
        return SIGNATURES;
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitRoundBankers(this, context);
    }
}