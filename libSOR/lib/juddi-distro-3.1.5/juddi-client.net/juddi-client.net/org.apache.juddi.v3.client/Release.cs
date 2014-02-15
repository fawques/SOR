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
using System.Reflection;
using System.Text;

namespace juddi_dotnet.org.apache.juddi.v3.client
{
    public class Release
    {
        private static readonly String UDDI_VERSION = "3.0";
        private static readonly String JAR_NAME = "juddi-client";
        private static String registryVersion = null;

        public static String getRegistryVersion()
        {
            if (registryVersion == null)
            {
                registryVersion = getVersionFromManifest(JAR_NAME);
            }
            return registryVersion;

        }

        public static String getUDDIVersion()
        {
            return UDDI_VERSION;
        }

        public static String getVersionFromManifest(String jarName)
        {
            try
            {
                return Assembly.GetExecutingAssembly().GetName().Version.ToString();
            }
            catch { }
            return "unknown";
        }
    }
}
