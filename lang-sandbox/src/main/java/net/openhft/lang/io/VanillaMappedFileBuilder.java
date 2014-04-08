/*
 * Copyright 2014 Peter Lawrey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.openhft.lang.io;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Fluent helper to create a VanillaMappedFile
 */
public class VanillaMappedFileBuilder {
    private File path;
    private VanillaMappedMode mode;
    private long size;

    public VanillaMappedFileBuilder() {
        this.path = null;
        this.mode = VanillaMappedMode.defaultMode();
        this.size = -1;
    }

    public VanillaMappedFileBuilder path(String path) {
        return path(new File(path));
    }

    public VanillaMappedFileBuilder path(String root,String file) {
        return path(new File(root, file));
    }

    public VanillaMappedFileBuilder path(File path) {
        this.path = path;
        return this;
    }

    public VanillaMappedFileBuilder readWrite() {
        this.mode = VanillaMappedMode.RW;
        return this;
    }

    public VanillaMappedFileBuilder readOnly() {
        this.mode = VanillaMappedMode.RO;
        return this;
    }

    public VanillaMappedFileBuilder mode(VanillaMappedMode mode) {
        this.mode = mode;
        return this;
    }

    public VanillaMappedFileBuilder mode(String mode) {
        this.mode = VanillaMappedMode.fromValue(mode);
        return this;
    }

    public VanillaMappedFileBuilder mode(int mode) {
        this.mode = VanillaMappedMode.fromValue(mode);
        return this;
    }

    public VanillaMappedFileBuilder mode(FileChannel.MapMode mode) {
        this.mode = VanillaMappedMode.fromValue(mode);
        return this;
    }

    public VanillaMappedFileBuilder size(long size) {
        this.size = size;
        return this;
    }

    /**
     * Create a VanillaMappedFile instance.
     *
     * @return
     * @throws IOException
     */
    public VanillaMappedFile build() throws IOException {
        return new VanillaMappedFile(this.path,this.mode,this.size);
    }
}
