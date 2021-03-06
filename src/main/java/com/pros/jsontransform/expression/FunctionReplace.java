/*
 * Copyright (c) 2016 PROS, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.pros.jsontransform.expression;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pros.jsontransform.ObjectTransformer;
import com.pros.jsontransform.ObjectTransformerException;

public class FunctionReplace extends FunctionAbstract
{
    public static JsonNode evaluate(
        final JsonNode argsNode,
        final JsonNode valueNode,
        final ObjectTransformer transformer)
    throws ObjectTransformerException
    {
        ObjectNode resultNode = (ObjectNode)argsNode;
        resultNode.put(
            "returnValue",
            transformValue(valueNode, transformer).replace(
                argsNode.path(ARGUMENT_WHAT).asText(),
                transformArgument(argsNode.path(ARGUMENT_WITH), transformer).asText()));

        return resultNode.get("returnValue");
    }
}
