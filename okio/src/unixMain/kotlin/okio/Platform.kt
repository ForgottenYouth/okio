/*
 * Copyright (C) 2020 Square, Inc.
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
package okio

import kotlinx.cinterop.toKString
import okio.Path.Companion.toPath
import platform.posix.getenv

@ExperimentalFilesystem
internal actual val PLATFORM_TEMPORARY_DIRECTORY: Path
  get() {
    val tmpdir = getenv("TMPDIR")
    if (tmpdir != null) return tmpdir.toKString().toPath()

    return "/tmp".toPath()
  }
