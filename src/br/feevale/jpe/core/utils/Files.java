/*
 * Copyright (C) 2018 Perin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads and manipulates files
 *
 * @author joaovperin
 */
public class Files {

    /**
     * Reads a file
     *
     * @param <T>
     * @param src
     * @param clazz
     * @return byte[]
     * @throws IOException
     */
    public static final <T extends FileReadable> List<T> read(String src, Class<T> clazz) throws IOException {
        return read(new File(src), clazz);
    }

    /**
     * Reads a file
     *
     * @param <T>
     * @param src
     * @param clazz
     * @return byte[]
     * @throws IOException
     */
    public static final <T extends FileReadable> List<T> read(File src, Class<T> clazz) throws IOException {
        // Check file exists
        if (!src.exists() || !src.isFile()) {
            throw new IOException("File doesn't seems to exist.");
        }
        // Reads from file
        List<T> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(src)) {
            try (Scanner scn = new Scanner(fis)) {
                // For each line, instantiate and load
                while (scn.hasNext()) {
                    T newInstance = clazz.newInstance();
                    newInstance.loadFromString(scn.nextLine());
                    list.add(newInstance);
                }
            }
        } catch (ReflectiveOperationException e) {
            throw new IOException(e);
        }
        return list;
    }

}
