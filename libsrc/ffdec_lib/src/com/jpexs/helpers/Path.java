/*
 *  Copyright (C) 2010-2015 JPEXS, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. */
package com.jpexs.helpers;

import java.io.File;

/**
 *
 * @author JPEXS
 */
public class Path {

    public static String combine(String... paths) {
        String result = "";
        String separator = File.separator;
        for (String path : paths) {
            if (path.startsWith(separator)) {
                result = result.substring(separator.length());
            }
            if (!result.endsWith(separator)) {
                result += separator;
            }
            result += path;
        }
        return result;
    }

    /*
     * Get the extension of a file.
     */
    public static String getExtension(String fileName) {
        return getExtension(new File(fileName));
    }

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i).toLowerCase();
        }
        return ext;
    }

    public static String getFileNameWithoutExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(0, i);
        }
        return ext;
    }
}
