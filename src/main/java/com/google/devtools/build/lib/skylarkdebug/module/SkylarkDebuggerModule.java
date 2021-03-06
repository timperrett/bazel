// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.skylarkdebug.module;

import com.google.devtools.build.lib.events.Reporter;
import com.google.devtools.build.lib.runtime.BlazeModule;
import com.google.devtools.build.lib.runtime.CommandEnvironment;

/** Blaze module for setting up Skylark debugging. */
public final class SkylarkDebuggerModule extends BlazeModule {
  @Override
  public void beforeCommand(CommandEnvironment env) {
    // Conditionally enable debugging
    SkylarkDebuggerOptions buildOptions = env.getOptions().getOptions(SkylarkDebuggerOptions.class);
    boolean enabled = buildOptions != null && buildOptions.debugSkylark;
    if (enabled) {
      initializeDebugging(env.getReporter(), buildOptions.debugServerPort);
    } else {
      disableDebugging();
    }
  }

  @Override
  public void afterCommand() {
    disableDebugging();
  }

  private static void initializeDebugging(Reporter reporter, int debugPort) {
    // TODO(brendandouglas): implement a debug server
  }

  private static void disableDebugging() {
    // TODO(brendandouglas): implement a debug server
  }
}
