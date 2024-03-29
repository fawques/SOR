﻿/*
 * Copyright 2001-2008 The Apache Software Foundation.
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
 *
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace org.apache.juddi.client.org.apache.juddi.v3.client.subscription
{
   
    [Serializable]
    public class RegistrationAbortedException : Exception
    {

        public RegistrationAbortedException() { }

        public RegistrationAbortedException(string message)
            : base(message)
        {
        }
        public RegistrationAbortedException(string message, Exception innerException)
            : base(message, innerException)
        {
        }
        protected RegistrationAbortedException(SerializationInfo info, StreamingContext context)
            : base(info, context)
        {
        }
    }
}
